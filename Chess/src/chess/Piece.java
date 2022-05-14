package chess;
import java.awt.*;
import javax.swing.*;

public class Piece {
    public Color color;
    public static enum Type {
        pawn, rook, bishop, knight, queen, king
    };
    private Type type;
    public Position pos;
    public boolean highlight = false;
    Image pieceImage;
    public int row;
    public int col;
    Piece(Color _color, int xpos, int ypos, Type _type)
    {
        color = _color;
        row = xpos;
        col = ypos;
        type = _type;
        //Rules pieceRules = new Rules(this);
        pos = new Position(xpos, ypos);
        
        //pieceImage = _pieceImage;
    }
    public Color getColor(){
        return color;
    }
    public Type getType() {
        return type;
    }
    public Position getPos() {
        return pos;
    }
    public void setPos(int xVal, int yVal){
        xVal -= Window.getX(0);
        yVal -= Window.getY(0);
//don't add a piece if outside the board.
        
        
        int ydelta = Window.getHeight2()/8;
        int xdelta = Window.getWidth2()/8;
        int zcol = xVal/xdelta;
        int zrow = yVal/ydelta;
        if (xVal <= 0 || xVal >= Window.getWidth2() ||
        yVal <= 0 || yVal >= Window.getHeight2())
        return;
        if(Board.board[zrow][zcol] == null){
            Board.board[zrow][zcol] = this;
            row = zrow;
            col = zcol;
        }
        
        
    }
    public void draw(Graphics2D g,int row,int column,int xdelta,int ydelta) {
        
        g.setColor(Color.black);
        g.fillOval(Window.getX(column*xdelta), Window.getY(row*ydelta), xdelta, ydelta);
        g.setColor(color);
        g.fillOval(Window.getX(column*xdelta), Window.getY(row*ydelta), xdelta-3, ydelta-3);
        if(highlight){
            g.setColor(Color.yellow);
            g.fillOval(Window.getX(column*xdelta), Window.getY(row*ydelta), xdelta-3, ydelta-3);
            
        }
        
        //System.out.println("test");
    }    
}