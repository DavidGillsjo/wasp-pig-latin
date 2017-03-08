import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.lang.Character;

public class PigLatin {
	
	/**
	 * Constructor for PigLatin class. Empty at the moment.
	 */
	public PigLatin()
	{
		
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

                if( Character.isUpperCase(word.charAt(0))){
                        translated_word = Character.toUpperCase(translated_word.charAt(0)) + translated_word.substring(1).toLowerCase();
                }

		return translated_word;

	}
	
	public static void main(String[] args)
	{
		
		PigLatin pig = new PigLatin();
		String inputWord = pig.getInput();
		String translatedWord = pig.translateWord(inputWord);
		
		System.out.println("English: " + inputWord);
		System.out.println("Pig Latin: " + translatedWord);
	}


}
