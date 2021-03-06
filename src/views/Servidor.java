package views;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import models.Banco;
import threads.Tratamento;

public class Servidor {
	public static void main(String[] args) throws IOException {
		// Criando um obj Bando
		Banco banco = new Banco();
		
		// Criando um obj ServerSocket
		ServerSocket servidor = new ServerSocket(12345);
		System.out.println("Servidor pronto!\n");
     
		int i = 1;
     
		while (true) {
			// Criando um obj Socket caixa para cada caixa conectado ao servidor
			Socket caixa = servidor.accept();
    	 
			// Criando um obj Tratamento (Thread) contendo todos os métodos necessários para manipular uma conta
			Tratamento tratamento = new Tratamento(caixa, "caixa-" + i, banco);
			// Executando a thread
			tratamento.start();
			
			i++;
		}
   
//		servidor.close();
//		cliente.close();
	}
 }