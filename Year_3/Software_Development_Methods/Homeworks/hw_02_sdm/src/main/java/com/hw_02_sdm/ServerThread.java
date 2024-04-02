package com.hw_02_sdm;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;

public class ServerThread extends Thread {
    private Socket socket;
	private static int id = 0;
	private static HashMap<Integer, Socket> idMap = new HashMap<>();

	private int currentId;
    ServerThread(Socket socket) {
		this.currentId = id;
		this.socket = socket;
		idMap.put(currentId, socket);
		++id;
    }
    public void run() {
        DataInputStream in = null;
        DataOutputStream out = null;
        try {
			in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
			out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
			out.writeInt(currentId);
			out.flush();
			
			while(true){
				String incoming = in.readUTF();
				int idPos = incoming.indexOf(':');
				String newIncome = incoming.substring(idPos + 1);
				
				for(int i = 0; i < idMap.size(); ++i)
				{
					out = new DataOutputStream(new BufferedOutputStream(idMap.get(i).getOutputStream()));
					out.writeUTF(newIncome);
					out.flush();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
				in.close();
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
    }
}






