
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class HttpServer {

	
	public static void main(String[] args) throws IOException{
		int port = 8080;
		
		ServerSocket serverSocket = new ServerSocket(port);
		
		Socket socket = serverSocket.accept();
		
		Scanner scanner = new Scanner(socket.getInputStream());
		
		while (scanner.hasNextLine()){
			String line = scanner.nextLine();
			System.out.println(line);

	}
		
		PrintWriter printWriter = new PrintWriter (socket.getOutputStream());
		printWriter.println("HTTP/1.0 404 NOT FOUND");
		printWriter.println(); 
		
	
	socket.close();
	serverSocket.close();
	
	}

}
