package ejrcicio_1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class servidor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ServerSocket servidor = null;
		Socket sc= null;
		DataInputStream in;
		DataOutputStream out;
		
		final int PUERTO =5000;
		
		try{
			servidor=new ServerSocket(PUERTO);
			System.out.println("servidor iniciado");
			
			while(true){
				sc= servidor.accept();
				
				System.out.println("cliente conectado");
				
				in = new DataInputStream(sc.getInputStream());
				out = new DataOutputStream(sc.getOutputStream());
				
				String mensaje = in.readUTF();
				
				System.out.println(mensaje);
				
				out.writeUTF("saludos desde el servidor");
				
				
			}
		} catch (IOException ex){
			Logger.getLogger(servidor.class.getName()).log(Level.SEVERE,  null, ex);
	}
		
	}

}