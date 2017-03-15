import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.lang.StringBuilder;
import java.lang.Character;

public class PigLatin {
	
	/**
	 * Constructor for PigLatin class. Empty at the moment.
	 */
	public PigLatin()
	{
		
	}
	
	/**
	 * Reads the input sentence from console and returns it as a String.
	 */
	public String getInput()
	{
		System.out.print("Enter an English sentence: ");
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
			translated_word = m.group(2) + m.group(1) + "ays" + m.group(3);
                }else {
                        // No vowel
                        translated_word = word + "ay";
                }

                if( Character.isUpperCase(word.charAt(0))){
                        translated_word = Character.toUpperCase(translated_word.charAt(0)) + translated_word.substring(1).toLowerCase();
                }

		return translated_word;

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
	
	
	
	public static void main(String[] args)
	{	
		PigLatin pig = new PigLatin();
		String inputSentence = pig.getInput();
		String translatedSentence = pig.translateSentence(inputSentence);
		
		System.out.println("English: " + inputSentence);
		System.out.println("Pig Latin: " + translatedSentence);
	}


}
