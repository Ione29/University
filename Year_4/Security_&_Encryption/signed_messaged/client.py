import json
import requests
from cryptography.hazmat.primitives import serialization
from cryptography.hazmat.primitives.asymmetric import padding
from cryptography.hazmat.primitives.hashes import SHA256

# Load public key
with open("certs/cert.pem", "rb") as file:
    public_key = serialization.load_pem_public_key(file.read())

# Define a transaction
transaction = {
    "sender": "Alice",
    "receiver": "Bob",
    "amount": 100
}

# Send the transaction to the server
response = requests.post("http://localhost:8080", json=transaction)
if response.status_code == 200:
    signed_transaction = response.json()

    # Verify the signed transaction
    transaction_str = signed_transaction["transaction"]
    signature = bytes.fromhex(signed_transaction["signature"])
    try:
        public_key.verify(
            signature,
            transaction_str.encode(),
            padding.PKCS1v15(),
            SHA256()
        )
        print(f"Transaction verified: {transaction_str}")
    except Exception as e:
        print(f"Verification failed for transaction: {transaction_str}. Error: {e}")
else:
    print(f"Failed to send transaction. Server responded with status code {response.status_code}")