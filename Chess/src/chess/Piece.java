//Piece class===================================================

package chess;
import java.awt.*;

public class Piece {
    public Color color;
    public boolean highlight = false;
    Piece(Color _color)
    {
        color = _color;
       
    }
    public Color getColor()
    {
        return (color);
    }

    public void draw(Graphics2D g,int row,int column,int xdelta,int ydelta) {
        
        g.setColor(Color.black);
        g.fillOval(Window.getX(column*xdelta), Window.getY(row*ydelta), xdelta, ydelta);
        g.setColor(color);
        g.fillOval(Window.getX(column*xdelta), Window.getY(row*ydelta), xdelta-3, ydelta-3);
//        if(highlight){
//            g.setColor(Color.yellow);
//            g.fillOval(Window.getX(column*xdelta), Window.getY(row*ydelta), xdelta-3, ydelta-3);
//        }
            
        
        g.setColor(Color.white);
    }
    
}