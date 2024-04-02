package com.hw_02_sdm;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(2999);
			System.out.println("\nServer initialized and listening on port 2999.");
			while (true) {
				Socket socket = serverSocket.accept();
				ServerThread serverThread = new ServerThread(socket);
				serverThread.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				serverSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
