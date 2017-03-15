import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.util.ArrayList;
import java.util.Random;

import java.lang.StringBuilder;
import java.lang.Character;


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
	 * Reads the input sentence from console and returns it as a String.
	 */
	public String getInput()
	{
		Scanner input=new Scanner(System.in);
		return input.nextLine();
	}
	
	/**
	 * Translates from English to Pig Latin. Returns the translated word as a String.
	 */
	public String translateWord(String word)
	{
		
		/** Create a Pattern object
		* Group 1: Consonants before first vowel
		* Group 2: First vowel and all letters
		* Group 3: Other characters (comma, questionmark, etc.)
		*/
		String vowels = "(\\A[^AEIOUY]*)([AEIOUY][\\w']*)(\\W*)\\z";
                Pattern r = Pattern.compile(vowels,Pattern.CASE_INSENSITIVE);

                Matcher m = r.matcher(word);
                String translated_word;
                if (m.find()) {
			// Found vowel
			translated_word = m.group(2) + m.group(1) + "ay" + m.group(3);
                }else {
                        // No vowel
                        translated_word = word + "ay";
                }

                if( Character.isUpperCase(word.charAt(0))){
                        translated_word = Character.toUpperCase(translated_word.charAt(0)) + translated_word.substring(1).toLowerCase();
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
	
	public String translateSentence(String sentence)
	{
		String[] words = sentence.split(" ");
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < words.length; i++) 
		{
			String word = words[i];
			
			if (word.isEmpty())
			{
				// Dont translate empty words
				continue;
			}
			
			String translatedWord = translateWord(words[i]);				
			sb.append(translatedWord);
			
			if (i < words.length - 1)
			{
				sb.append(" ");
			}
			
		}
		
		return sb.toString();	
	}
	
	public void runTranslator()
	{
		System.out.println("Enter an English sentence for translation:");
		String inputSentence = this.getInput();
		String translatedSentence = this.translateSentence(inputSentence);

		System.out.println("English: " + inputSentence);
		System.out.println("Pig Latin: " + translatedSentence);
	}

	public void runQuiz()
	{
		System.out.println("Translate the following sentence:");
		String sentence = this.getQuizSentence();
		System.out.println(sentence);
		String userTranslation = this.getInput();

		String correctTranslation = this.translateSentence(sentence);
		if (userTranslation.matches(correctTranslation)) {
			System.out.println("You are correct!");
		} else {
			System.out.println("You are wrong! Correct translation:");
			System.out.println(correctTranslation);
		}
	}
	
	public static void main(String[] args)
	{	
		boolean quiz = args[0].matches("quiz");

		PigLatin pig = new PigLatin();
		if (quiz) {
			pig.runQuiz();
		} else {
			pig.runTranslator();
		}
	}


}
