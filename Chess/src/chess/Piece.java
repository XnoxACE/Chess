package chess;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

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
    Image image;
    private int row;
    private int col;
    Piece(Color _color, int _row, int _col, Type _type)
    {
        color = _color;
        row = _row;
        col = _col;
        type = _type;
        //Rules pieceRules = new Rules(this);
        pos = new Position(row, col);
        Imageinit();
        
        //pieceImage = _pieceImage;
    }
    void Imageinit(){
        if(color == Color.BLACK){
            if(type == Type.pawn){
                image = new ImageIcon("./src/chessp/b_pawn.png").getImage();
            }
            if(type == Type.queen){
                image = new ImageIcon("./src/chessp/b_queen.png").getImage();
            }
            if(type == Type.king){
                image = new ImageIcon("./src/chessp/b_king.png").getImage();
            }
            if(type == Type.bishop){
                image = new ImageIcon("./src/chessp/b_bishop.png").getImage();
            }
            if(type == Type.knight){
                image = new ImageIcon("./src/chessp/b_knight.png").getImage();
            }
            if(type == Type.rook){
                image = new ImageIcon("./src/chessp/b_rook.png").getImage();
            }
        }
        if(color == Color.white){
            if(type == Type.pawn){
                image = new ImageIcon("./src/chessp/w_pawn.png").getImage();
            }
            if(type == Type.queen){
                image = new ImageIcon("./src/chessp/w_queen.png").getImage();
            }
            if(type == Type.king){
                image = new ImageIcon("./src/chessp/w_king.png").getImage();
            }
            if(type == Type.bishop){
                image = new ImageIcon("./src/chessp/w_bishop.png").getImage();
            }
            if(type == Type.knight){
                image = new ImageIcon("./src/chessp/w_knight.png").getImage();
            }
            if(type == Type.rook){
                image = new ImageIcon("./src/chessp/w_rook.png").getImage();
            }
        }
    }
    
    
    void update(){

    }
    Color getColor(){
        return color;
    }
    Type getType() {
        return type;
    }
    Position getPos() {
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

    void setPos(int xVal, int yVal){
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
        if(Board.board[zrow][zcol] == null || Board.board[zrow][zcol].getColor()!= color){
            Board.board[zrow][zcol] = null;
            Board.board[row][col] = null;
            Board.board[zrow][zcol] = this;
            
            // set new col and row
            row = zrow;
            col = zcol;
        }
    }
    public void checkPromo(){
        if(type == Type.pawn && color == Color.white && row == 0){
            type = Type.queen;
        }
        if(type == Type.pawn && color == Color.black && row == 7){
            type = Type.queen;
        }
    }
    public void draw(Graphics2D g,int row,int column,int xdelta,int ydelta, Chess thisObj) {
        if(highlight){
            g.setColor(new Color(186,202,68));
            g.fillRect(Window.getX(column*xdelta), Window.getY(row*ydelta), xdelta, ydelta);
            
        }
        checkPromo();
        Imageinit();
        
        
        g.drawImage(image,Window.getX(column*xdelta), Window.getY(row*ydelta),xdelta, ydelta, null);
        
        
        
            
        
    }
}

