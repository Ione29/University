import sys
import socket
import threading
import re
import time
exit_flag = True


def connect(conn):
    global flag
    while flag:
        received = conn.recv(1024)
        if not received.decode():
            break
        if received == ' ':
            pass
        elif received == "exit":
            break
        else:
            print("Client>>>   " + received.decode())
    flag = False


def sendMsg(conn):
    while flag:
        send_msg = input().encode('utf-8')
        if send_msg == ' ':
            pass
        else:
            conn.sendall(send_msg)


if __name__ == '__main__':
    flag = True
    start_time = time.monotonic()
    s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    s.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)
    s.bind(('', 11111))
    s.listen()
    (conn, addr) = s.accept()
    thread1 = threading.Thread(target=connect, args=([conn]))
    thread2 = threading.Thread(target=sendMsg, args=([conn]))
    thread1.start()
    thread2.start()
    thread1.join()
    thread2.join()
