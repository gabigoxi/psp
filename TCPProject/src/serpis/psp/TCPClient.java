package serpis.psp;

import java.io.*;
import java.net.*;

public class TCPClient {
	
        public static void main(String[] args) throws Exception{
                String envio;                        
                String respuesta;        
                
                
                BufferedReader cliente = new BufferedReader(new InputStreamReader(System.in));
                
                
                Socket TCPClient = new Socket("127.0.0.1", 10001);
                
                
                DataOutputStream servidor = new DataOutputStream(TCPClient.getOutputStream());
                
                
                BufferedReader fromServer = new BufferedReader (new InputStreamReader(TCPClient.getInputStream()));
                
                System.out.print("Cliente dice: ");
                
                envio = cliente.readLine();
                servidor.writeBytes(envio + '\n');
                
                respuesta = fromServer.readLine();
                System.out.println("Servidor dice: " + respuesta);
                TCPClient.close();  
        }
}
		
		