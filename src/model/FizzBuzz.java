package model;

import java.io.Serializable;
import java.util.Random;
import java.util.Scanner;

public class FizzBuzz implements Serializable{

	private String player;
	private int points;
	private String status; //"Jogando" ou "Finalizado"
	

	public FizzBuzz (String player) {
		this.player = player;
		this.points = 0;
		this.status = "Jogando";
	}
	
	public String fizzbuzz(int number) {
		String response = "";
		
		if (number % 3 == 0)
			response = "fizz";
			
		if (number % 5 == 0)
			response += "buzz";
		
		if (response.equals(""))
			response = Integer.toString(number);
		
		return response;
	}
	
	public boolean valid (int number, String input) {
		boolean valid = false;
		
		try {
			String answer = fizzbuzz(number);
			if (input.equals(answer)) {
				valid=true;
			}
		}
		catch (Exception e) {
			
		}
		return valid;
	}
	
	public void start(Scanner scanner) {
		boolean correct = true;
		String input = null;
		int number;
		Random random = new Random();
		while (correct) {
			number = random.nextInt(10);
			
			System.out.println(number);
			input = scanner.next();
			
			correct = valid(number, input.toLowerCase());
			if (correct) {
				increasePoints();
				System.out.println("Correto!");
			}
			else {
				gameOver();
				System.out.println("Game over!");
				showPoints();
			}
		}
	}
	
	public void increasePoints() {
		setPoints(getPoints()+10);
	}
	
	public void showPoints() {
		System.out.println("Parabéns! Sua pontuação foi:");
		System.out.println(getPoints());
	}
	
	public void gameOver() {
		setStatus("Finalizado");
	}
	
	public String getPlayer() {
		return player;
	}

	public void setPlayer(String player) {
		this.player = player;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
