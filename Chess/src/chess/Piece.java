package chess;
import java.awt.*;

//import javax.print.attribute.PrintServiceAttributeSet;
//import javax.swing.*;

public class Piece {
    private Color color;
    public enum Type {
        pawn, rook, bishop, knight, queen, king
    };
    private Type type;
    private Position pos;
    private boolean highlight = false;
    Image pieceImage;
    private int row;
    private int col;
    Piece(Color _color, int _row, int _col, Type _type, Image _pieceImage)
    {
        color = _color;
        row = _row;
        col = _col;
        type = _type;
        //Rules pieceRules = new Rules(this);
        pos = new Position(row, col);
        
        pieceImage = _pieceImage;
    }
    public void Init()
    {    
        pieceImage = Toolkit.getDefaultToolkit().getImage(".Pieces/b_bishop_png_shadow_128px.png.GIF");
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
    int getRow(){
        return row;
    }
    int getCol(){
        return col;
    }
    void setHighlight(boolean state){
        highlight = state;
    }

    public void setPos(int xVal, int yVal){
        // David
        // converts x and y to row and col
        xVal -= Window.getX(0);
        yVal -= Window.getY(0);
        int ydelta = Window.getHeight2()/8;
        int xdelta = Window.getWidth2()/8;
        int zcol = xVal/xdelta;
        int zrow = yVal/ydelta;
        
        // if the piece will be moved to is outside the board code is stoped
        if (xVal <= 0 || xVal >= Window.getWidth2() ||
        yVal <= 0 || yVal >= Window.getHeight2())
        return;
        // if the positoin that the piece will be moved to is null set piece position to the new board position
        if(Board.board[zrow][zcol] == null){
            Board.board[zrow][zcol] = this;
            // set new col and row
            row = zrow;
            col = zcol;
        }
    }
    public void draw(Graphics2D g,int row,int column,int xdelta,int ydelta, Chess thisObj) {
        
        if(color == Color.white){
            g.setColor(Color.black);
            g.fillOval(Window.getX(column*xdelta), Window.getY(row*ydelta), xdelta, ydelta);
            g.setColor(color);
            g.fillOval(Window.getX(column*xdelta), Window.getY(row*ydelta), xdelta-3, ydelta-3);
        }
        if(color == Color.black){
            g.setColor(Color.white);
            g.fillOval(Window.getX(column*xdelta), Window.getY(row*ydelta), xdelta, ydelta);
            g.setColor(color);
            g.fillOval(Window.getX(column*xdelta), Window.getY(row*ydelta), xdelta-3, ydelta-3);
        }
        if(highlight){
            g.setColor(new Color(186,202,68));
            g.fillOval(Window.getX(column*xdelta), Window.getY(row*ydelta), xdelta-3, ydelta-3);
            
        }
        if(color == Color.white){
            if(type == Type.pawn){
                
                g.setColor(Color.black);
                g.setFont(new Font("Arial", Font.PLAIN, 20));
                g.drawString("P", Window.getX(0) + column * Window.getWidth2() / 8 + 10,
                Window.getY(0) + row * Window.getHeight2() / 8 + 20);
            }
            if(type == Type.queen){
                g.setColor(Color.black);
                g.setFont(new Font("Arial", Font.PLAIN, 20));
                g.drawString("Q", Window.getX(0) + column * Window.getWidth2() / 8 + 10,
                Window.getY(0) + row * Window.getHeight2() / 8 + 20);
            }
            if(type == Type.king){
                g.setColor(Color.black);
                g.setFont(new Font("Arial", Font.PLAIN, 20));
                g.drawString("K", Window.getX(0) + column * Window.getWidth2() / 8 + 10,
                Window.getY(0) + row * Window.getHeight2() / 8 + 20);
            }
            if(type == Type.bishop){
                g.setColor(Color.black);
                g.setFont(new Font("Arial", Font.PLAIN, 20));
                g.drawString("B", Window.getX(0) + column * Window.getWidth2() / 8 + 10,
                Window.getY(0) + row * Window.getHeight2() / 8 + 20);
            }
            if(type == Type.knight){
                g.setColor(Color.black);
                g.setFont(new Font("Arial", Font.PLAIN, 20));
                g.drawString("N", Window.getX(0) + column * Window.getWidth2() / 8 + 10,
                Window.getY(0) + row * Window.getHeight2() / 8 + 20);
            }
            if(type == Type.rook){
                g.setColor(Color.black);
                g.setFont(new Font("Arial", Font.PLAIN, 20));
                g.drawString("R", Window.getX(0) + column * Window.getWidth2() / 8 + 10,
                Window.getY(0) + row * Window.getHeight2() / 8 + 20);
            }
        }
        
        if(color == Color.black){
            if(type == Type.pawn){
                g.setColor(Color.white);
                g.setFont(new Font("Arial", Font.PLAIN, 20));
                g.drawString("P", Window.getX(0) + column * Window.getWidth2() / 8 + 10,
                Window.getY(0) + row * Window.getHeight2() / 8 + 20);
            }
            if(type == Type.queen){
                g.setColor(Color.white);
                g.setFont(new Font("Arial", Font.PLAIN, 20));
                g.drawString("Q", Window.getX(0) + column * Window.getWidth2() / 8 + 10,
                Window.getY(0) + row * Window.getHeight2() / 8 + 20);
            }
            if(type == Type.king){
                g.setColor(Color.white);
                g.setFont(new Font("Arial", Font.PLAIN, 20));
                g.drawString("K", Window.getX(0) + column * Window.getWidth2() / 8 + 10,
                Window.getY(0) + row * Window.getHeight2() / 8 + 20);
            }
            if(type == Type.bishop){
                g.setColor(Color.white);
                g.setFont(new Font("Arial", Font.PLAIN, 20));
                g.drawString("B", Window.getX(0) + column * Window.getWidth2() / 8 + 10,
                Window.getY(0) + row * Window.getHeight2() / 8 + 20);
            }
            if(type == Type.knight){
                g.setColor(Color.white);
                g.setFont(new Font("Arial", Font.PLAIN, 20));
                g.drawString("N", Window.getX(0) + column * Window.getWidth2() / 8 + 10,
                Window.getY(0) + row * Window.getHeight2() / 8 + 20);
            }
            if(type == Type.rook){
                g.setColor(Color.white);
                g.setFont(new Font("Arial", Font.PLAIN, 20));
                g.drawString("R", Window.getX(0) + column * Window.getWidth2() / 8 + 10,
                Window.getY(0) + row * Window.getHeight2() / 8 + 20);
            }
            
        }    
    }
}

