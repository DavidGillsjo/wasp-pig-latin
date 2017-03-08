import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
	public String translate(String word)
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
	
	public static void main(String[] args)
	{
		
		PigLatin pig = new PigLatin();
		String inputWord = pig.getInput();
		String translatedWord = pig.translate(inputWord);
		
		System.out.println("English: " + inputWord);
		System.out.println("Pig Latin: " + translatedWord);
	}


}
