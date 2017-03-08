import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.Random;

public class PigLatin {
	
	private ArrayList<String> quizSentences;
	private Random randomGenerator;

	/**
	 * Constructor for PigLatin class. Empty at the moment.
	 */
	public PigLatin()
	{
		quizSentences = new ArrayList<String>();
		quizSentences.add("Hello World");
		quizSentences.add("I see you!");
		quizSentences.add("Testing testing...");
		randomGenerator = new Random();
	}
	
	/**
	 * Reads the input word from console and returns it as a String.
	 */
	public String getInput()
	{
		System.out.print("Enter an english word: ");
		Scanner input=new Scanner(System.in);
		return input.nextLine();
	}
	
	/**
	 * Translates from English to Pig Latin. Returns the translated word as a String.
	 */
	public String translate(String word)
	{
		
		/** Create a Pattern object
		* Group 1: Consonants before first vowel
		* Group 2: First vowel and all letters
		* Group 3: Other characters (comma, questionmark, etc.)
		*/
		String vowels = "(\\A[^AEIOU]*)([AEIOU]\\w*)(\\W*)\\z";
                Pattern r = Pattern.compile(vowels,Pattern.CASE_INSENSITIVE);

                Matcher m = r.matcher(word);
                String translated_word;
                if (m.find()) {
			// Found vowel
			translated_word = m.group(2) + m.group(1) + "ay" + m.group(3);
                }else {
                        // No vowel
                        translated_word = word;
                }

		return translated_word;

	}

	/**
	 * Return string for quiz.
	 */
	public String getQuizSentence()
	{
		int index = randomGenerator.nextInt(quizSentences.size());
        String sentence = quizSentences.get(index);
        return sentence;
	}
	
	public static void main(String[] args)
	{
		
		PigLatin pig = new PigLatin();
		String inputWord = pig.getInput();
		String translatedWord = pig.translate(inputWord);
		
		System.out.println("English: " + inputWord);
		System.out.println("Pig Latin: " + translatedWord);
	}


}
