package serpis.psp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TCPServer {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		
		pingPong();
		
	}
	
	private static void pingPong () throws IOException {

		int port = 10001;
		
		ServerSocket serverSocket = new ServerSocket(port);
		
		Socket socket = serverSocket.accept();
		
		BufferedReader bufferedReader = new BufferedReader( new InputStreamReader ( socket.getInputStream() ) );
		PrintWriter printWriter = new PrintWriter ( socket.getOutputStream() );
		
		String mensaje = bufferedReader.readLine();
		System.out.println("Mensaje: " + mensaje);
		System.out.println("Enviando: "+mensaje.toLowerCase());

		System.out.println("Mensaje enviado.");
		printWriter.println(mensaje.toLowerCase());

		printWriter.close();
		bufferedReader.close();
		socket.close();
		serverSocket.close();

		socket.close();
		
		serverSocket.close();
	
	}
	
}
