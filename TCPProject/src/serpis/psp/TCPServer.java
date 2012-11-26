package serpis.psp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TCPServer {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		//holaMundo();
		
		pingPong();
		
	}
	
	private static void pingPong () throws IOException {

		int port = 10001;
		
		ServerSocket serverSocket = new ServerSocket(port);
		
		Socket socket = serverSocket.accept();
		
		Scanner scanner = new Scanner (socket.getInputStream());
		
		String line = scanner.nextLine();
		
		System.out.println("line=" + line);

		socket.close();
		
		serverSocket.close();
	
	}
	
	private static void connectAndRead(String[] args) {
	
	//private static void holaMundo() throws IOException {
		
		
	//}
}
