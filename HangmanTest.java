import static org.junit.Assert.*;

import org.junit.Test;

public class HangmanTest {

	Hangman hangtest = new Hangman();
	
	@Test
	public void testGetRandomWord() {
		hangtest.getRandomWord();
		assertNotNull(hangtest.getSecretWord());
		assertNotNull(hangtest.getGuessWord());
	}

}
