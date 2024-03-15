package com.lab_02_sdm;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(2999);
			while (true) {
				Socket socket = serverSocket.accept();
				ServerThreadWorker serverWorker = new ServerThreadWorker(socket);
				serverWorker.start();
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
