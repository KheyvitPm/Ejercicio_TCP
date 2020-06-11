package ejrcicio_1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class cliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		final String HOST="127.0.0.1";
		final int PUERTO = 5000;
		DataInputStream in;
		DataOutputStream out;
		
		try{
			Socket sc = new Socket(HOST, PUERTO);
			
			in = new DataInputStream(sc.getInputStream());
			out = new DataOutputStream(sc.getOutputStream());
			
			out.writeUTF("hola cliente ");
			System.out.println();
			
			
			Scanner sn = new Scanner(System.in);
	        boolean salir = false;
	        int opcion; 
		while (!salir) {
        	System.out.println("El cliente esta conectado con el Servidor");
        	System.out.println("MENU");
        	System.out.println("*----Elija una opcion----*");
            System.out.println("-Opcion 1");
            System.out.println("-Opcion 2");
            System.out.println("-Opcion 3");
            System.out.println("-Salir 4");
 
            try {
 
                System.out.println("Elija una de las opciones:");
                opcion = sn.nextInt();
 
                switch (opcion) {
                    case 1:
                        System.out.println("*--PAPEL--* ");
                        System.out.println("------");
                        break;
                    case 2:
                        System.out.println("*--PIEDRA--*");
                        System.out.println("------");
                        break;
                    case 3:
                        System.out.println("*--TIJERA--*");
                        System.out.println("------");
                        break;
                    case 4:
                        salir = true;
                        System.out.println("usted salio del cliente");
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 4");
                }
            } catch (InputMismatchException e) {
                System.out.println("*------solo numeros------*");
                sn.next();
            }
        }
		
		    sn.close();
		System.out.println("cliente desconectado");
			String mensaje = in.readUTF();
			sc.close();	
			 
			
			System.out.println(mensaje);
			
			sc.close();
		
		}catch (IOException ex){
			Logger.getLogger(servidor.class.getName()).log(Level.SEVERE,  null, ex);
		}
		
	}
}
