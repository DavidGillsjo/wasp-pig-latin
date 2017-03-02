import java.util.Scanner;

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
		return "Pig Latin text...";
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
