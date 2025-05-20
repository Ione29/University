import random
import json
names = ["Ana", "Mircea", "Mihai", "Vlad", "Raluca"]

# sender
# receiver
# amount

transactions = []
for _ in range(80):
    sender, receiver = random.sample(names, 2)
    amount = random.randint(1, 15000)
    transactions.append(
        {
            "sender": sender,
            "receiver": receiver,
            "amount": amount
        }
    )

# save to JSON
with open("transactions.json", "w") as file:
    json.dump(transactions, file, indent = 4)

print(transactions)