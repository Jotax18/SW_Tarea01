package com.example.demo.socket.archivos;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {
	
	private final Integer PORT = 13;
	private final String IP = "localhost";
	
	public Client() {
		try {
			Socket clientServer = new Socket(IP, PORT);
			System.out.println("--------- 1 Iniciando comunicación ----------");
			
			File fileOrigen = new File("D:/cliente/Java-Villena.jpeg");
			FileInputStream fis = new FileInputStream(fileOrigen);
			DataOutputStream salida = new DataOutputStream(clientServer.getOutputStream());
			
			int byteLeidos;
			while( (byteLeidos = fis.read()) != -1) {
				salida.write(byteLeidos);
			}
			
			fis.close();
			salida.close();
			
			System.out.println("--------- 2 Finalizando comunicación ----------");
			clientServer.close();	
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception  e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new Client();
	}
}
