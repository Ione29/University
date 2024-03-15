package com.lab_02_sdm;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class MyClient {

	public static void main(String[] args) {
		Socket socket = null;
        Scanner scanner = new Scanner(System.in);
		try {
            System.out.println("Give the socket a name = ");
            String socketName = scanner.nextLine();
            socket = new Socket("127.0.0.1", 2999);
			while (true) {

				ClientThreadWorker clientWorker = new ClientThreadWorker(socket, socketName);
				clientWorker.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
