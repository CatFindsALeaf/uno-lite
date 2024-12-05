import java.util.Scanner;

/**
 * A card abstract class.
 * This class will be used as the superclass for each
 * card you must implement.
 *
 * I have provided the method header below. Do not change anything else!
 * @author Scott Pomerville
 */

public abstract class UnoCard{
	protected int value;
	protected String color;

	/**
	 * This constructor sets the color and value of
	 * UnoCard to the provided arguments.
	 *
	 * If the card is a special card, then value should be set to -1!
	 */
	public UnoCard(String color, int value){
		this.color = color;
		this.value = value;
	}

	/**
	 * This should return true if the card is a
	 * legal card to play on top of this card. Otherwise, return false.
	 *
	 * A card is legal if:
	 * It is wild.
	 * Its number matches mine, and we are both a number card.
	 * It's color matches mine.	
	 *
	 * @param card		is the card to check against the current uno card.
	 * @return 		true, if the provided card can be played on this card.
	 */
	public boolean isLegal(UnoCard card) throws NullPointerException{

		// This card is illegal if it is null
		if (card == null)
			throw new NullPointerException("isLegal recieved argument null!");

		// If this card matches my color, or is wild...
        // Or if this card and myself are both skip cards...
        // Or if this card and myself are both reverse cards...
		if (
            (card instanceof UnoWildCard || card.getColor().equals(this.color))  ||
            (card instanceof UnoSkipCard && this instanceof UnoSkipCard)         ||
            (card instanceof UnoReverseCard && this instanceof UnoReverseCard)  
            ) {
			return true;
		}

		// If this card matches my value and this card is a number card
		// return true. Otherwise, return false.
		return (card instanceof UnoNumberCard && this instanceof UnoNumberCard
				&& card.getValue() == this.value);
	}


	/**
	 * A toString method, so you aren't so sad when debugging.
	 * Normally, we would not use instanceof here to check subclasses, but this is to help you out!
     *
	 * @return a pretty string explaining what type of card this is.
	 */
	public String toString(){
		if (this instanceof UnoWildCard){ 
			return "Wild";
		}
		else if (this instanceof UnoSkipCard){
			return getColor() + " Skip";
		}
		else if (this instanceof UnoReverseCard){
			return getColor() + " Reverse";
		}
		else{
			return getColor() + " " + getValue();
		}
	}

	/**
	 * When dealing with wild cards, we may need to set a color.
	 * Set a color if the card is a wild card. Otherwise, do not do anything.
	 * We assume most cards don't use this so we'll implement it doing nothing.
	 * @param color		is the color you would like to set the card to.
	 */
	public void setColor(String color){
        return;
    }


	/**
	 * This returns the value of the card, or -1 if the card is special.
	 * @return the value of the card
	 */
	public abstract int getValue();

	/**
	 * This returns the color of the card.
	 *@return the color of the card
	 */
	public abstract String getColor();


	/**
	 * This plays the card on top of the UnoPile. 
	 * If the card is not a real card, throw an IllegalArgumentException.
	 * If the card cannot be legally played at the moment, have the player draw two for cheating.
	 * 
	 * If I play a wild card, I need the scanner to prompt for input with the
	 * game.setTopCardColor(Scanner stdin) method. Otherwise, don't touch the scanner!
	 *
	 * If you could play the card, return true. Otherwise, return false.
	 *
	 * @param  The pile on which to play the card. There should only be one of these per game.
     * @return true if the card is legal to play, false otherwise. 
	 */
	public abstract boolean play(UnoGame game, int player, Scanner stdin);
}
