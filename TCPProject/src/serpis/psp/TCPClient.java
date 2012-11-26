package serpis.psp;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Date;

public class TCPClient {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException, IOException {
		//holaMundo();
		//pingPong();
		
		System.out.println("argumentos:");
		for (int index = 0; index < args.length; index++)
		System.out.println(args[index]);
		System.out.println("fin");
	}
	
	private static void pingPong () throws IOException {
		
		InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
		int port= 10001;
		Socket socket = new Socket(inetAddress, port);
		
		OutputStream outputStream = socket.getOutputStream();
		PrintWriter printwriter = new PrintWriter(outputStream, true);
		printwriter.println("Hola desde TCPClient a las " + new Date());
		
		printwriter.close();
		socket.close();
	
	
	//private static void holaMundo() throws UnknownHostException, IOException {

		
	//}

}
}
