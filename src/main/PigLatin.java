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
                char[] vowels = {'a', 'e', 'i', 'o', 'u'};
                int l = word.length();
                for (int j = 0; j<l; j++){
                
                        for (int i = 0; i<vowels.length; i++){
                                if (word.charAt(j) == vowels[i]){
                                        char[] last  = new char[j];
                                        char[] first = new char[l-j]; 
                                        word.getChars(0,j,last,0);
                                        word.getChars(j,l,first,0);
                                        return String.valueOf(first) + String.valueOf(last) + "ay";
                                }
                        }
                } 
                
		return "wtf!";
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
