import socket
import ssl

def client():
    port = 5000
    host = "localhost"

    client_socket = socket.socket()

    context = ssl.create_default_context(ssl.Purpose.SERVER_AUTH)
    context.load_verify_locations(cafile='./certs/cert.pem')
    client_socket = context.wrap_socket(client_socket, server_hostname=host)

    client_socket.connect((host, port))

    print("Peer Certificate:", client_socket.getpeercert())
    print("Cipher Used:", client_socket.cipher())

    message = input("<- ")

    # Stop connection with "bye"
    while message.lower().strip() != "bye":
        client_socket.send(message.encode())
        data = client_socket.recv(1024).decode()
        print("Received from server:", str(data))
        message = input("<- ")

    client_socket.close()

if __name__ == "__main__":
    client()