from http.server import BaseHTTPRequestHandler, HTTPServer
import json
import hmac
import hashlib

# Load the secret key
with open("certs/key.pem", "r") as file:
    secret_key = file.read().strip()

# Load transactions from the JSON file
with open("transactions.json", "r") as file:
    transactions = json.load(file)

class TransactionHandler(BaseHTTPRequestHandler):
    def do_GET(self):
        # Select a transaction to encode
        transaction = transactions[0]  # For simplicity, send the first transaction
        transaction_str = "sender: {}, receiver: {}, amount: {}".format(
            transaction["sender"], transaction["receiver"], transaction["amount"]
        )

        # Encode the transaction using HMAC
        transaction_hmac = hmac.new(secret_key.encode(), transaction_str.encode(), hashlib.sha256).hexdigest()

        # Print the encoded message (HMAC) on the server side
        print(f"Encoded transaction (HMAC): {transaction_hmac}")

        # Send the encoded transaction to the client
        response = {
            "transaction": transaction_str,
            "hmac": transaction_hmac
        }
        self.send_response(200)
        self.send_header("Content-Type", "application/json")
        self.end_headers()
        self.wfile.write(json.dumps(response).encode())

# Start the server
if __name__ == "__main__":
    server_address = ("", 8080)  # Listen on all interfaces, port 8080
    httpd = HTTPServer(server_address, TransactionHandler)
    print("Server running on port 8080...")
    httpd.serve_forever()