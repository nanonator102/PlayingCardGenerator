import java.util.Scanner;
import java.util.Random;
import java.io.IOException;
import java.io.PrintWriter;
public class PlayingCardGenerator {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		Random randInt = new Random();
		
		System.out.print("How many cards would you like? ");
		int cardCount = keyboard.nextInt(), i=0;
		String cards[] = new String[cardCount]; //Creates a new String array called "cards" and sets the length to the number of cards input by the user.
		
		System.out.print("Would you like to save the results to a text file(1) or print them in the console(2)? ");
        int saveFile = keyboard.nextInt();

        while(saveFile < 1 || saveFile > 2) //Ensures that saveFile is only 1 or 2,
        {
                System.out.print("Please enter either 1 or 2.");
                saveFile = keyboard.nextInt();
        }
        keyboard.close(); //Closes the Scanner class called "keyboard" because Eclipse complained about it being unclosed.
		
		while(i<cardCount)
		{
			int randomNumber = randInt.nextInt(13);
			int randomSymbolInt = randInt.nextInt(4);
			String randomSymbol=("null");
			
			//if statements to fill in the symbol used for the final output. 
			if(randomSymbolInt==1)
			{
				randomSymbol = ("Diamonds");
			}
			else if(randomSymbolInt==2)
			{
				randomSymbol = ("Hearts");
			} 
			else if(randomSymbolInt==3)
			{
				randomSymbol = ("Spades");
			}
			else
			{
				randomSymbol = ("Clubs");
			}
			
			randomNumber+=1;
			String randomNumberString = Integer.toString(randomNumber);
			
			//if statements used to convert the numbers 1, 11, 12 and 13 to their card counterparts (Ace, Jack, Queen, King).
			if(randomNumberString.equals("1"))  {
				
				randomNumberString=("Ace");
				
			}  else if(randomNumberString.equals("11"))  {
				
				randomNumberString=("Jack");
				
			}  else if(randomNumberString.equals("12"))  {
				
				randomNumberString=("Queen");
			}  else if(randomNumberString.equals("13"))  {
				
				randomNumberString=("King");
				
			}  else  {}
			
			String randomCard = (randomNumberString + " of " + randomSymbol);
			cards[i]=randomCard; //Stores the card value in the relevant spot in the array.
			if(saveFile==2) {
				System.out.println("Card #" + (i+1) + " is " + cards[i]);
			}
			i++; //Increment i by 1.
		}
		
		i=0;
            if (saveFile == 1) {
                try {
                    PrintWriter writer = new PrintWriter("Cards.txt");
                    for(i=0; i < cardCount; i++) {
                        writer.println("Card # " + (i+1) + " is: " + cards[i]);
                    }
                    writer.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

        keyboard.close();
            if(saveFile==1) {
                System.out.println("Program executed successfully. Wrote " + cards.length + " cards to Cards.txt");
            }

	}

}
