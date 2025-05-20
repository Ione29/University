import java.io.*;
import java.net.*;

class Client {
    Client() {
        try {
            InetAddress ia = InetAddress.getLocalHost();
            DatagramSocket ds = new DatagramSocket();
            DatagramSocket ds1 = new DatagramSocket(1300);

            System.out.println("\nRPC Client\n");
            System.out.println("Enter method and parameters (e.g., add 3 4 or gcd 12 18 24)\n");

            while (true) {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String str = br.readLine();
                byte[] b = str.getBytes();

                DatagramPacket dp = new DatagramPacket(b, b.length, ia, 1200);
                ds.send(dp);

                byte[] buffer = new byte[4096];
                DatagramPacket dp1 = new DatagramPacket(buffer, buffer.length);
                ds1.receive(dp1);

                String s = new String(dp1.getData(), 0, dp1.getLength());
                System.out.println("\nResult = " + s + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Client();
    }
}
