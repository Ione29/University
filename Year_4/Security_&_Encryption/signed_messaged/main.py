import json
import hashlib
import hmac

with open("transactions.json", "r") as file:
    data = json.load(file)


with open("certs/key.pem", "r") as file:
    key = file.read()

for el in data:
    print(el)
    transaction_str = "sender: {}, receiver: {}, amount: {}".format(el["sender"], el["receiver"], el["amount"])
    # print(transaction_str)
    # transaction_hash = hashlib.sha256(transaction_str.encode()).hexdigest()
    transaction_sig = hmac.new(key.encode(), transaction_str.encode())
    print(transaction_sig.hexdigest())

# homework: use the same application, send the message but it is encoded by the server but decoded by the client