
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class HttpServer {

	private static ServerSocket serversocket;
	private static Socket socket;
	private static final String newLine = "\r\n";
	
	public static void main(String[] args) throws IOException{
		
		final int port = 8080;
		ServerSocket serverSocket = new ServerSocket(port);
		
		
		while(true) {
		Socket socket = serverSocket.accept();
		
		String fileName = getFileName(socket.getInputStream());
		
		writeHeader(socket.getOutputStream(), fileName);
		
		writeFile(socket.getOutputStream(), fileName);
	
		socket.close();
		//serverSocket.close();

		//PrintWriter printWriter = new PrintWriter (socket.getOutputStream(),true);
		//printWriter.println(response + newLine);
		//printWriter.println(newLine); 
		
		//printWriter.close();
	
	}
	}

	
private static String getFileName(InputStream inputStream){
		
Scanner scanner = new Scanner(inputStream);
		
		String fileName = "index.html";
		
		while (true){
			String line = scanner.nextLine();
			System.out.println(line);
			if (line.startsWith("GET")) { //GET /index.html HTTP/1.1
				fileName = line.split("")[1].substring(1); //-> index.html
			System.out.println("fileName=" + fileName);
			}
			if (line.equals(""))
			break;
			
		}
		
		return fileName;
	}

private static void writeHeader(OutputStream outputStream, String fileName) throws IOException {
	final String response200 = "HTTP/1.0 200 OK";
	final String response404 = "HTTP/1.0 404 NOT FOUND";
	File file = new File(fileName);
	String response = file.exists() ? response200 : response404;
	String header = response + newLine + newLine;
	byte[] headerBuffer = header.getBytes();
	outputStream.write(headerBuffer);

}

private static void writeFile(OutputStream outputStream, String fileName) throws IOException {
	
	final String fileNameError404 = "fileError404.html";
	
	File file = new File(fileName);
	
	String responseFileName = file.exists() ? fileName : fileNameError404;
	
	final int bufferSize = 2048;
	
	byte [] buffer = new byte [bufferSize];
	
	FileInputStream fileInputStream = new FileInputStream(responseFileName);
	
	int count;
	//pausa
	while ((count = fileInputStream.read(buffer)) != -1)
		outputStream.write(buffer, 0, count);
	
	fileInputStream.close();
	
	
}

}
