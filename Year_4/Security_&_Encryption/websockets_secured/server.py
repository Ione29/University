import socket
import ssl

def server():
    port = 5000
    host = "localhost"

    server_socket = socket.socket()
    server_socket.bind((host, port))
    server_socket.listen(3)

    context = ssl.SSLContext(ssl.PROTOCOL_TLS_SERVER)
    context.load_cert_chain(certfile='./certs/cert.pem', keyfile='./certs/key.pem')
    server_socket = context.wrap_socket(server_socket, server_side=True)

    print(f"Server started on {host}:{port}")
    conn, address = server_socket.accept()

    print("Connected from:", str(address))
    while True:
        data = conn.recv(1024).decode()
        if not data:
            break
        print("From client:", str(data))
        data = input("-> ")
        conn.send(data.encode())

    conn.close()

if __name__ == "__main__":
    server()