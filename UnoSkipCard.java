import java.util.Scanner;

/**
 * A class implementing the skip cards for Uno.
 *
 * Date Last Modified: 09/29/2024
 * @author Elliot Kucharski
 *
 * CS1122, Fall 2024
 * Lab Section 2
 */

public class UnoSkipCard extends UnoCard {
    public UnoSkipCard(String color, int value) {
        super(color, value);
    }

    public boolean play(UnoGame game, int player, Scanner stdin) {
        if(!game.getLastPlayed().getColor().equals(this.color) && !(game.getLastPlayed().getValue() == this.value)) {
            game.draw(player);
            game.draw(player);
            return false;
        }
        game.playCard(this);
        game.nextPlayer();
        return true;
    }

    public int getValue() {
        return -2;
    }

    public String getColor() {
        return this.color;
    }
}