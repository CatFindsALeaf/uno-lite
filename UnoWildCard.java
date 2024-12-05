import java.util.Scanner;

/**
 * A class implementing the wild cards for Uno.
 *
 * Date Last Modified: 09/29/2024
 * @author Elliot Kucharski
 *
 * CS1122, Fall 2024
 * Lab Section 2
 */

public class UnoWildCard extends UnoCard {
    public UnoWildCard(String color, int value) {
        super(color, value);
    }

    public boolean play(UnoGame game, int player, Scanner stdin) {
        game.playCard(this);
        game.setTopCardColor(stdin);
        this.color = game.getLastPlayed().getColor();
        return true;
    }

    public int getValue() {
        return -1;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}