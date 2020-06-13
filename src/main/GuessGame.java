package main;

import java.util.Scanner;

public class GuessGame {
	
	public static void main(String[] args) {
		
		
		final int MAX_TRIES = 5;
		final int MIN_RAND_NUM = 1;
		final int MAX_RAND_NUM = 100;
		int numberToGuess = generateRandomNumber(MIN_RAND_NUM,MAX_RAND_NUM);
		Scanner scanner = new Scanner(System.in);
		System.out.println("Pick a number between 1 and 100");
		
		boolean isWin = false;
		
		try {
			int userGuess = scanner.nextInt();
			int tryCounter = 1;
			while (isWin == false) {
				if (tryCounter < MAX_TRIES) {
					if (userGuess < MIN_RAND_NUM || userGuess > MAX_RAND_NUM) {
						System.out.println("Your guess is not between 1 and 100, please try again");
						userGuess = scanner.nextInt();
					} else {
						if (userGuess < numberToGuess) {
							tryCounter++;
							System.out.println("Please pick a higher number");
							userGuess = scanner.nextInt();
						} else if (userGuess > numberToGuess) {
							tryCounter++;
							System.out.println("Please pick a lower number");
							userGuess = scanner.nextInt();
						} else {
							System.out.println("You win!");
							isWin = true;
							scanner.close();
						}
					} 		
				} else {
					throw new Exception();
				}					
			}		
		} catch (Exception e) {
			System.out.println("You lose, the number to guess was " + numberToGuess);
		}
		
	}
	
	private static int generateRandomNumber(int min, int max) {
		return ((int)(Math.random() * (max - min))) + min;
	}

}
