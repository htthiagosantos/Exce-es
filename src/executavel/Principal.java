package executavel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import execao.DominioErro;
import model.Reserva;

public class Principal {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		// --------------- LEITURA DOS DADOS -----------------
		try {
			System.out.print("Numero do Quarto: ");
			int numero = sc.nextInt();
			System.out.print("Entre com a data de Check-in (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("Entre com a data de Check-out (dd/MM/yyyy): ");
			Date checkOut = sdf.parse(sc.next());
			
			// -------------- ESTANCIANDO RESERVA -----------------
			Reserva reserva = new Reserva(numero, checkIn, checkOut);
			System.out.println("Reserva: " + reserva); // MOSTRA NA TELA
			
			// LER OS DADOS DA ATUALIZAÇÃO DE RESERVA
			System.out.println();
			System.out.println("Insira os dados para atualizar a reserva:");
			System.out.print("Entre com a data de Check-in (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Entre com a data de Check-out (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
			
			// EFETUAR ATUALIZAÇÃO MANUALMENTE 
			reserva.atualizacaoDeDatas(checkIn, checkOut);
			System.out.print("Reserva: " + reserva);
		}
		catch(ParseException e) {
			System.out.println("Formato de data invalido");
		}
		catch(DominioErro e) {
			System.out.println("Erro na reserva: " + e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("Erro Inesperado.");
		}
		
		sc.close();
		}
		
}
		

 

