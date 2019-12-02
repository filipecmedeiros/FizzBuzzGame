package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Random;
import java.util.Scanner;


/**
 * @author gih_s
 *
 */
public class FizzBuzz implements Serializable{

	private String player;
	private int points;
	private String status; //"Jogando" ou "Finalizado"
	int number;
	Random random = new Random();
	public FizzBuzz (String player) {
		this.player = player;
		this.points = 0;
		this.status = "Jogando";
	}
	
	public FizzBuzz () {
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
			else if (answer.equals(Integer.toString(number)) && input.equals("")){
				valid=true;
			}
		}
		catch (Exception e) {
			
		}
		return valid;
	}
	
	public int showNumber() {
		
		number = random.nextInt(1000);
		return number;
	}
	
	public int play(String jogada) {
		

		if(valid(number,jogada.toLowerCase())) {			
			System.out.println("Correto!");
			return 10;
		}else {
			gameOver();
			System.out.println("Game over!");
			return 0;
		}
	}
	
	public void saveGame(String nameGame) {
			nameGame += ".fizzbuzz";
			save("./"+nameGame);		
	}
	
	public static void listGames() {
		File dir = new File("./");
		
		if (dir.exists()) {
			File [] files = dir.listFiles();
			
			for (int i=0; i<files.length;i++) {
				if (files[i].isFile() && files[i].getName().contains(".fizzbuzz"))
					System.out.println(files[i].getName());
			}
			System.out.println("\n");
			
		}
	}
	
/*	public boolean requestToSave(String input) {
		return input.contains("+S");
	}*/
	
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
	
    public void save(String directory) {
		File file = new File(directory);
		
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
			FileOutputStream fout = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			oos.writeObject(this);
			
			fout.close();
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
    
	public static FizzBuzz decode (String directory) {
		FizzBuzz r = null;
		
		try {	
			FileInputStream fin = new FileInputStream(directory);
			ObjectInputStream ois = new ObjectInputStream(fin);
			
			if (fin.available() != 0){
				r = (FizzBuzz) ois.readObject();
			}
			
			fin.close();
			ois.close();
			
			
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return r;
		
	}
}
