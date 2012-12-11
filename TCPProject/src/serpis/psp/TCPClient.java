package serpis.psp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;




public class TCPClient {

	
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		pingPong();

		
	}
	
	private static void pingPong() throws IOException{

		InetAddress inetAddress = InetAddress.getByName("127.0.0.1"); 		
		int port = 10001;
		String mensaje;

		InputStreamReader inputStreamReader = new InputStreamReader(System.in); 
		BufferedReader escribirTeclado = new BufferedReader(inputStreamReader);

			Socket socket = new Socket(inetAddress,port);

			OutputStream outputStream = socket.getOutputStream();
			PrintWriter PrintWriter = new PrintWriter(outputStream, true);

			java.io.InputStream inputStream = socket.getInputStream();
			BufferedReader	bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

			System.out.print("Mensaje a enviar: ");
			PrintWriter.println( escribirTeclado.readLine() ); 

			mensaje = bufferedReader.readLine();
			System.out.println("Mensaje del servidor: " + mensaje);


			PrintWriter.close();
			bufferedReader.close();
			socket.close();

		}
}

