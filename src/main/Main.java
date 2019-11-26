package main;

import java.io.File;
import java.util.Scanner;

import data.FizzBuzzRepository;
import model.FizzBuzz;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		FizzBuzzRepository fbr;
		File fizzbuzzFile = new File("./fizzbuzz");
		
		if (fizzbuzzFile.exists())
			fbr = (FizzBuzzRepository) FizzBuzzRepository.decode(fizzbuzzFile.getName());
		else
			fbr = new FizzBuzzRepository();
		
		
		int menu;
		boolean exit = false;
		
		String tutorial = "\n\nOlá, seja bem vindo(a) ao FizzBuzz!\n"
				+"A regra do jogo é simples:\n\n"
				+"Aparecerá um número aleatório na tela.\n"
				+"- Você deve responder com 'Fizz' caso esse número seja múltiplo de 3.\n"
				+"- Ou responder com 'Buzz' caso o número seja múltiplo de 5.\n"
				+"- Caso o número seja múltiplo de 3 e 5 ao mesmo tempo, responda com 'FizzBuzz'.\n"
				+"- Responda com o próprio número caso não se enquadre em nenhum caso acima."
				+ "\n\n Valendo!!!\n\n\n";
		
		String mainMenu = "Menu:\n"
						+"1.Novo jogo\n"
						+"2.Carregar jogo salvo\n"
						+"3.Visualizar ranking\n"
						+"4.Sair\n\n";
		do {
			System.out.println(mainMenu);
			menu = input.nextInt();
			
			switch(menu) {
				case 1: 
					System.out.println("Digite o nome do jogador:");
					String player = input.next();
					FizzBuzz game = new FizzBuzz (player);
					System.out.println(tutorial);
					game.start(input);
					if (game.getStatus().equals("Finalizado")) {
						fbr.create(game);
						fbr.save(fizzbuzzFile.getName());
					}
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					exit = true;
					break;
			}
			
		}while ((menu<0 || menu>5) && !exit);
		
		fbr.save(fizzbuzzFile.getName());
		
		input.close();
	}

}