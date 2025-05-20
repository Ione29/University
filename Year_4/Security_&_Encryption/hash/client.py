import json
import requests
import hmac
import hashlib

# Load the secret key
with open("certs/key.pem", "r") as file:
    secret_key = file.read().strip()

# Request the encoded transaction from the server
response = requests.get("http://localhost:8080")
if response.status_code == 200:
    encoded_transaction = response.json()

    # Extract the transaction and HMAC
    transaction_str = encoded_transaction["transaction"]
    received_hmac = encoded_transaction["hmac"]

    # Print the encoded message (HMAC) received from the server
    print(f"Received encoded transaction (HMAC): {received_hmac}")

    # Verify the HMAC
    calculated_hmac = hmac.new(secret_key.encode(), transaction_str.encode(), hashlib.sha256).hexdigest()
    if hmac.compare_digest(received_hmac, calculated_hmac):
        print(f"Transaction verified: {transaction_str}")
    else:
        print("Transaction verification failed: HMAC mismatch")
else:
    print(f"Failed to fetch transaction. Server responded with status code {response.status_code}")