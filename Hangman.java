import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Hangman {
	private ArrayList<String> words = new ArrayList<String>(
			Arrays.asList("Apollo", "Ares", "Athena", "Hades", "Hera", "Hermes", "Hestia", "Zeus", "Aion", "Aether",
					"Ananke", "Chaos", "Erebus", "Eros", "Hypnos", "Nesoi", "Uranus", "Gaia", "Ourea", "Phanes",
					"Pontus", "Hemera", "Coeus", "Crius", "Phoebe", "Dione", "Rhea", "Helios", "Leto", "Aura"));
	private Integer numberOfLives = 5;
	private char secretWord[], guessWord[];

	public Integer getNumberOfLives() {
		return numberOfLives;
	}

	public char[] getSecretWord() {
		return secretWord;
	}

	public char[] getGuessWord() {
		return guessWord;
	}

	public void getRandomWord() {
		Random r = new Random();
		secretWord = words.get(r.nextInt(30)).toCharArray();
		guessWord = new char[secretWord.length];
		for (int i = 0; i < secretWord.length; i++) {
			guessWord[i] = '_';
		}
		display();
	}

	public void display() {
		for (int index = 0; index < secretWord.length; index++) {
			System.out.print(guessWord[index] + " ");
		}
		System.out.println();
	}

	public void guessTheWord() {
		Integer score = new Integer(100);
		char guessedChar = ' ';
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println();
			System.out.println("Guess a letter!");
			guessedChar = sc.next().charAt(0);
			if (checkIfCharIsPresent(guessedChar)) {
				ifWinnerOrLoser(score);
				display();
			} else {
				System.out.println("OOPS! You lost a life \n" + guessedChar
						+ " is not Present \nNumber of lives Remaining " + numberOfLives);
				score = score - 20;
				display();
				numberOfLives--;
				ifWinnerOrLoser(score);
			}
		} while (numberOfLives != 0);
		sc.close();
	}

	public Boolean checkIfCharIsPresent(char guessedChar) {
		boolean x = false;
		for (int index = 0; index < secretWord.length; index++) {
			if (Character.toLowerCase(secretWord[index]) == guessedChar) {
				guessWord[index] = secretWord[index];
				x = true;
			}
		}
		return x;
	}

	public void ifWinnerOrLoser(Integer score) {
		if (Arrays.equals(guessWord, secretWord)) {
			System.out.println("YAY! You've Won :D \nYour Score is " + score);
			display();
			System.exit(0);
		} else if (numberOfLives == 0) {
			System.out.println("SORRY! You lost :( \nYour Score is " + score);
			System.exit(0);
		}
	}

	public static void main(String args[]) {
		Hangman hang = new Hangman();
		hang.getRandomWord();
		hang.guessTheWord();
	}

}
