from http.server import BaseHTTPRequestHandler, HTTPServer
import json
from cryptography.hazmat.primitives import serialization
from cryptography.hazmat.primitives.asymmetric import padding
from cryptography.hazmat.primitives.hashes import SHA256

# Load private key
with open("certs/key.pem", "rb") as file:
    private_key = serialization.load_pem_private_key(file.read(), password=None)

class TransactionHandler(BaseHTTPRequestHandler):
    def do_POST(self):
        # Read the transaction data from the client
        content_length = int(self.headers['Content-Length'])
        post_data = self.rfile.read(content_length)
        transaction = json.loads(post_data)

        # Create the transaction string
        transaction_str = "sender: {}, receiver: {}, amount: {}".format(
            transaction["sender"], transaction["receiver"], transaction["amount"]
        )

        # Sign the transaction
        signature = private_key.sign(
            transaction_str.encode(),
            padding.PKCS1v15(),
            SHA256()
        )

        # Send the signed transaction back to the client
        response = {
            "transaction": transaction_str,
            "signature": signature.hex()
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