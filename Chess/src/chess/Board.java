package chess;
import java.awt.*;

import chess.Piece.Type;

public class Board {
    private final static int NUM_ROWS = 8;
    private final static int NUM_COLUMNS = 8;      
    public static Piece board[][] = new Piece[NUM_ROWS][NUM_COLUMNS];
    private static boolean runOnce = true;

    static void Reset() {
//clear the board.
        
        for (int zrow=0;zrow<NUM_ROWS;zrow++)
            for (int zcol=0;zcol<NUM_COLUMNS;zcol++)
                board[zrow][zcol] = null;        
        runOnce = true;
    }
    
    static void Draw(Graphics2D g) {
//draw grid
        int ydelta = Window.getHeight2()/NUM_ROWS;
        int xdelta = Window.getWidth2()/NUM_COLUMNS;
        
        // only draws pieces once
        if(runOnce){
            DrawPieces(xdelta, ydelta, g);
            runOnce = false;
        }
 
        g.setColor(Color.black);
        for (int zi = 1;zi<NUM_ROWS;zi++)
        {
            g.drawLine(Window.getX(0),Window.getY(zi*ydelta),
                    Window.getX(Window.getWidth2()),Window.getY(zi*ydelta));
        }
        
        for (int zi = 1;zi<NUM_COLUMNS;zi++)
        {
            g.drawLine(Window.getX(zi*xdelta),Window.getY(0),
                    Window.getX(zi*xdelta),Window.getY(Window.getHeight2()));
        }
        // Draws Board
        int count = 1;
        Color color = new Color(79, 72, 74);
        Color color2 = new Color (236, 216, 155);
        for (int zrow=0;zrow<NUM_ROWS;zrow++)
        {
            for (int zcol=0;zcol<NUM_COLUMNS;zcol++){
                if (count%2 == 0)
                    g.setColor(color);
                else
                    g.setColor(color2);
                g.fillRect(Window.getX(zcol*xdelta),Window.getY(zrow*ydelta), xdelta, ydelta);
                count++;
                if(board[zrow][zcol] != null)
                    board[zrow][zcol].draw(g, zrow, zcol, xdelta, ydelta);   
            }
            count--;
        } 
    }
    
    static Piece SelectPiece(Graphics2D g, int xVal,int yVal){
        //David
        // converts x and y to row and col
        xVal -= Window.getX(0);
        yVal -= Window.getY(0);
        int ydelta = Window.getHeight2()/NUM_ROWS;
        int xdelta = Window.getWidth2()/NUM_COLUMNS;
        int col = xVal/xdelta;
        int row = yVal/ydelta;
        
        // checks if piece is outside the board
        if (xVal <= 0 || xVal >= Window.getWidth2() ||
        yVal <= 0 || yVal >= Window.getHeight2())  
            return null;
        
        // highlights piece 
        if(board[row][col] != null){
            board[row][col].setHighlight(true);
            // returns piece to selectedPiece to chess.Chess.java
            return board[row][col];
        }
        return null;
    }
    
    static void DrawPieces(int xdelta, int ydelta, Graphics2D g){
        //David
        for (int zrow=0;zrow<NUM_ROWS;zrow++)
        {
            for (int zcol=0;zcol<NUM_COLUMNS;zcol++)        
            {
                // black pieces
                if (zrow == 1)
                    board[zrow][zcol] = new Piece(new Color(82, 69, 86), zrow, zcol, Type.pawn); // creates black pawns
                if(zrow == 0 && zcol == 3)
                    board[zrow][zcol] = new Piece(new Color(82, 69, 86), zrow, zcol, Type.queen); // creates black queen
                if(zrow == 0 && zcol == 4)
                    board[zrow][zcol] = new Piece(new Color(82, 69, 86), zrow, zcol, Type.king); // creates black king
                if(zrow == 0 && (zcol == 2 || zcol == 5))
                    board[zrow][zcol] = new Piece(new Color(82, 69, 86), zrow, zcol, Type.bishop); // creates black bishops
                if(zrow == 0 && (zcol == 1 || zcol == 6))
                    board[zrow][zcol] = new Piece(new Color(82, 69, 86), zrow, zcol, Type.knight); // creates black knights
                if(zrow == 0 && (zcol == 0 || zcol == 7))
                    board[zrow][zcol] = new Piece(new Color(82, 69, 86), zrow, zcol, Type.rook); // creates black rooks
                
               
                // white pieces
                if (zrow == 6)
                    board[zrow][zcol] = new Piece(new Color(250, 236, 226), zrow, zcol, Type.pawn); // creates white pawns
                if(zrow == 7 && zcol == 3)
                    board[zrow][zcol] = new Piece(new Color(250, 236, 226), zrow, zcol, Type.queen); // creates white queen
                if(zrow == 7 && zcol == 4)
                    board[zrow][zcol] = new Piece(new Color(250, 236, 226), zrow, zcol, Type.king); // creates white king
                if(zrow == 7 && (zcol == 2 || zcol == 5))
                    board[zrow][zcol] = new Piece(new Color(250, 236, 226), zrow, zcol, Type.bishop); // creates white bishops
                if(zrow == 7 && (zcol == 1 || zcol == 6))
                    board[zrow][zcol] = new Piece(new Color(250, 236, 226), zrow, zcol, Type.knight); // creates white knights
                if(zrow == 7 && (zcol == 0 || zcol == 7))
                    board[zrow][zcol] = new Piece(new Color(250, 236, 226), zrow, zcol, Type.rook); // creates white rooks
                
                
                // draws piece of board position is not null    
               if (board[zrow][zcol] != null)
                    board[zrow][zcol].draw(g, zrow, zcol,xdelta, ydelta);
            }
        }        
    }
}
