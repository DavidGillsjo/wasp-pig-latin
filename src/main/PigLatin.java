import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.lang.StringBuilder;

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
		
		// Create a Pattern object
		String vowels = "([^AEIOU]*)([AEIOU].*)";
                Pattern r = Pattern.compile(vowels,Pattern.CASE_INSENSITIVE);

                Matcher m = r.matcher(word);
                String translated_word;
                if (m.find()) {
			// Found vowel
			translated_word = m.group(2) + m.group(1) + "ay";
                }else {
                        // No vowel
                        translated_word = word;
                }

		return translated_word;

	}
	
	public String translateSentence(String sentence)
	{
		String[] words = sentence.split(" ");
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < words.length; i++) 
		{
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
