package entradaYsalida;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import modelo.Mensaje;



public class Metodos {
	static Scanner teclado = new Scanner(System.in);
	private static ArrayList<Mensaje> mensajes = new ArrayList<Mensaje>(); 

	public static void main(String[] args) {
		mainMenu();
	

		
	}
	
	private static void mainMenu() {
		int opcion = 0;
		boolean control = true;
		
		do {
			System.out.print("Menú de opciones\n"

				+ "1- Leer información fichero  \t \r\n"
				+ "2- Añadir información a lista de mensajes \t \r\n"
				+ "3- Modificar mensajes \t \r\n"
				+ "4- Sobreescribir y Salir \n");

			opcion = teclado.nextInt();

			if (opcion <=4) {



				switch (opcion) {

				case 1:
					leerFichero();
					control = true;
					break;
				case 2:
					addMensaje();
					control = true;
					break;
				case 3:
					modificarMensajes();
					control = true;
					break;
				case 4:
					sobreescribirMensajes();
					control = false;
					default:
				

				}
			}else {
				System.out.println("Opcion incorrecta : debe ser entre 1 - 4");
			}

		}while (control);
		teclado.close();
	}
	
	  public static void leerFichero() {

		
		  
		  	File fichero = new File("Mensajes.txt");
		  	
		  	try {
		  		
		  		BufferedReader lecturaFichero = new BufferedReader(new FileReader(fichero));
		  		String linea;
		  		Mensaje mensaje = new Mensaje();
		  		
		  		while((linea = lecturaFichero.readLine()) != null) {
		  			
		  			if (!linea.startsWith("*")) {
		  				String[] elementos = linea.split(":");
		  				switch (elementos[0]) {
		  				case "fecha":
		  					mensaje.setFecha(elementos[1]);
		  					break;
		  				case "hora":
		  					mensaje.setHora(elementos[1].concat(":" + elementos[2]) );
		  					break;
		  				case "para":
		  					mensaje.setPara(elementos[1]);
		  					break;
		  				case "de":
		  					mensaje.setDe(elementos[1]);
		  					break;
		  				case "asunto":
		  					mensaje.setAsunto(elementos[1]);
		  					break;
		  				case "contenido":
		  					mensaje.setContenido(elementos[1]);
		  					break;
		  				}
		  				
		  			}else {
		  				mensajes.add(mensaje);
		  				mensaje = new Mensaje();
		  			}
		  		}
		  		
		  	}catch (FileNotFoundException e) {
				System.out.println("No existe el fichero");
			} catch (IOException e) {
				System.out.println("No se ha podido leer el fichero");
			}
		  	for(int i = 0; i < mensajes.size(); i++) {
		  		System.out.println(mensajes.get(i));
		  	}
		  	
		  	
		  
	  }
	  public static void addMensaje() {
		  System.out.println("Añade fecha");
		  String fecha = teclado.nextLine();
		  teclado.nextLine();
		  System.out.println("Añade hora");
		  String hora = teclado.nextLine();
		  
		  System.out.println("Añade destinatario");
		  String para = teclado.nextLine();
		  
		  System.out.println("Añade remitente");
		  String de = teclado.nextLine();
		  
		  System.out.println("Añade asunto");
		  String asunto = teclado.nextLine();
		  
		  System.out.println("Añade contenido");
		  String contenido = teclado.nextLine();
		  
		  Mensaje mensaje = new Mensaje(fecha, hora, para, de, asunto, contenido);
		  mensajes.add(mensaje);
		  for(int i = 0; i < mensajes.size(); i++) {
		  		System.out.println(mensajes.get(i));
		  	}
		  
	  }
	  public static void modificarMensajes( ) {
		  
		  System.out.println("Indica el asunto del mensaje a modificar");
		  String  asunto = teclado.nextLine();
		  teclado.nextLine();
		  System.out.println("Indica el nuevo contenido");
		  String contenido = teclado.nextLine();
	  
		  for(int i = 0; i < mensajes.size(); i++) {
			  
			  Mensaje mensaje = mensajes.get(i);
			  if(mensaje.getAsunto() == asunto) {
				  mensaje.setContenido(contenido);
				  System.out.println(mensaje);
			  }
		  }
 }
	  public static void sobreescribirMensajes() {
	  
		  
		  try {
			  BufferedWriter escrituraFichero = new BufferedWriter(new FileWriter("Mensajes.txt", true));
			  Mensaje mensaje = new Mensaje("12-02-2022","12:23", "elisa", "elena", "fresas", "dont forget the fresas");
			  
			  	escrituraFichero.newLine();
				escrituraFichero.write(mensaje.toString());
				escrituraFichero.newLine();
				escrituraFichero.write("----------------");

				escrituraFichero.close();
				System.out.println("escritura realizada");
			  
		  }catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
 }

}
