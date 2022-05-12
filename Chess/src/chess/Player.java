package chess;
import java.awt.*;
public class Player {
    private static int numPlayers=2;
    private static Player players[] = new Player[numPlayers];
    private static Player currentPlayer;
    private Color color;
    
    public static void Reset() {
        players[0] = new Player(Color.white);
        players[1] = new Player(Color.black);
        currentPlayer = players[0];
                
    }
    public static Player getCurrentPlayer() {
        return currentPlayer;
    }
    public static void switchCurrentPlayer() {
        if (currentPlayer == players[0])
            currentPlayer = players[1];
        else
            currentPlayer = players[0];
    }    
    
    public Player(Color _color) {
        color = _color;
    }    
    public Color getColor() {
        return (color);
    }
}