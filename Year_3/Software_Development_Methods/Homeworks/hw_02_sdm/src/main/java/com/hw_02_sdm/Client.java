package com.hw_02_sdm;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {
	
	public static void main(String[] args) {
		DataInputStream in = null; DataOutputStream out = null;
		Socket socket = null;
		Scanner scanner = null;
		int clientID;

		try {
			socket = new Socket("127.0.0.1", 2999);
			out = new DataOutputStream(socket.getOutputStream());
			out.flush();
			in = new DataInputStream(socket.getInputStream());
			
			ExecutorService es= Executors.newSingleThreadExecutor();
			DataInputStream finalIn = in;
			
			clientID = in.readInt();
			System.out.println("\nYour ID is: " + clientID + ". Happy messaging!");

			es.submit(()->{
				while(true) {
					String incoming = finalIn.readUTF();
					int i = incoming.indexOf(':');
					String messageID = "";

					for(int ind = 0; ind < i; ++ind){
						messageID = messageID + incoming.charAt(ind);
					}

					if(messageID.isEmpty())
						System.out.println(incoming);
					else if(Integer.parseInt(messageID) == clientID)
						System.out.println(incoming.substring(i + 1));
				}
			});
			es.shutdown();
			scanner = new Scanner(System.in);
			
			while(true) {
				String s = scanner.nextLine();
				if(s.equals("END"))
					break;
				
				String toSend = String.valueOf(clientID) + ':' +s;
				out.writeUTF(toSend);
				out.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		 finally {
			try {
				scanner.close();
				out.close();
				in.close();
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}