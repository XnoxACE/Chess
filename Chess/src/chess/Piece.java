//Piece class===================================================

package chess;
import java.awt.*;

public class Piece {
    private Color color;
    Piece(Color _color)
    {
        color = _color;
    }
    public Color getColor()
    {
        return (color);
    }

    public void draw(Graphics2D g,int row,int column,int xdelta,int ydelta) {

    }
    
}