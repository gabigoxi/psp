package serpis.psp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class UDPClient {

	private static void fillByteArray(byte[] buf, String data){
		
		byte [] bufData = data.getBytes();
		for (int index=0; index < bufData.length; index++ )
			buf[index] = bufData[index];
	}
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		String text = "Hola desde UDPClient soy Gaby";
		InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
		int port = 10001;
		
		DatagramSocket datagramsocket = new DatagramSocket();
		byte[] buf = new byte[2048];
		DatagramPacket datagramPacket = new DatagramPacket(buf, buf.length, inetAddress, port);
		datagramsocket.send(datagramPacket);
		
		while(true){
		
			text="cliente";
		fillByteArray(buf, text);
		datagramPacket.setLength(text.getBytes().length);
		datagramsocket.send(datagramPacket);
		
		datagramPacket.setLength(buf.length);
		
		datagramsocket.receive(datagramPacket);
		
		
		@SuppressWarnings("deprecation")
		String data = new String (datagramPacket.getData(), datagramPacket.getLength());
				System.out.printf("Receive Data='%S' \n", data);
		
		System.out.println("UDPClient fin.");
	}

}
}
