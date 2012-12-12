package serpis.psp;

import java.io.*;
import java.net.*;

public class TCPServer {
	
        public static void main(String[] args) throws Exception {
        	
        	
                String recibodecliente;          
                String reenvio;       
                
               
                ServerSocket inicio = new ServerSocket(10001);
                
                
                System.out.println("Servidor ejecutado");
                	
                        
                        Socket connection = inicio.accept();
                        
                        BufferedReader cliente = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                        
                        DataOutputStream toClient = new DataOutputStream(connection.getOutputStream());
                        
        
                        recibodecliente = cliente.readLine();
                       
                        reenvio = recibodecliente.toUpperCase() + '\n';
                        
                        toClient.writeBytes(reenvio);
                }
        }
