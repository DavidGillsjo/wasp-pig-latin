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
		quizSentences.add("Class dismissed!");
		quizSentences.add("Translate me!");
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
		String word_uc = word.toUpperCase();
		String word_ending = "ay";
		if (word_uc.matches("\\A[AEIOUY].*")) {
			// Starts with vowel
			word_ending = "way";
		}

		Pattern vowel_present_p = Pattern.compile("(\\A[^AEIOUY]*)([AEIOUY][\\w']*)(\\W*)\\z",Pattern.CASE_INSENSITIVE);

		Matcher m = vowel_present_p.matcher(word);
		String translated_word;
		if (m.find()) {
			// Found vowel
			translated_word = m.group(2) + m.group(1) + word_ending + m.group(3);
		} else {
			Pattern only_consonants_p = Pattern.compile("(\\A[\\w']+)(\\W*)\\z",Pattern.CASE_INSENSITIVE);
			m = only_consonants_p.matcher(word);
			if (m.find()) {
				// No vowel
				translated_word = m.group(1) + word_ending + m.group(2);
			 } else {
				// Fallback
				translated_word = word + word_ending;
			 }
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
		int points = 0;
		boolean run = true;
		
		while (run)
		{
			
			System.out.println("Translate the following sentence:");
			String sentence = this.getQuizSentence();
			System.out.println(sentence);
			String userTranslation = this.getInput();

			String correctTranslation = this.translateSentence(sentence);
			if (userTranslation.matches(correctTranslation)) {
				System.out.println("You are correct!");
				points++;
			} else {
				System.out.println("You are wrong! Correct translation:");
				System.out.println(correctTranslation);
			}
			
			System.out.println("Type yes to continue quiz, no to quit:");
			Scanner input=new Scanner(System.in);
			
			String answer = input.nextLine();
			
			if (answer.equals("yes"))
			{
				// Continue quiz
				run = true;
			}
			else if (answer.equals("no"))
			{
				// Quit quiz
				run = false;
			}
			else
			{
				// Incorrect input
				System.out.println("Incorrect input, shutting down quiz");
				run = false;
			}	
		}
		
		System.out.println("Quiz ended with a score of: " + points);
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
