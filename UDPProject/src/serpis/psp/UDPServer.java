package serpis.psp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;



public class UDPServer {

	public static void main(String[] args) throws IOException {
        byte[] buf = new byte[2048];
        int port=10001;
        	
			
			DatagramPacket datagramPacket = new DatagramPacket(buf, buf.length);
			
			InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
			
			DatagramSocket datagramSocket = new DatagramSocket(port, inetAddress);
			
			while (true){
				
				datagramPacket.setData(buf);
				datagramPacket.setLength(buf.length);
    		datagramSocket.receive(datagramPacket);
    		String data= new String (datagramPacket.getData(), 0, datagramPacket.getLength());
			System.out.println("\n El mensaje llegara en mayusculas: " + data + "\n Con puerto: " + datagramPacket.getPort() + "\n Y la IP: " + datagramPacket.getAddress());
    		
			System.out.printf("length=%d\n", datagramPacket.getLength());
			
    	data = data + data.toUpperCase();
    	
    	
    	StringUtil.FillByteArray(buf, data);
    	datagramPacket.setLength(data.getBytes().length);
    	
			
			datagramSocket.send(datagramPacket);
    		
           }
  }
}