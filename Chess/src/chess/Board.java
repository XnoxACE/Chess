//Board class===================================================


package chess;
import java.awt.*;

public class Board {
    private final static int NUM_ROWS = 8;
    private final static int NUM_COLUMNS = 8;      
    private static Piece board[][] = new Piece[NUM_ROWS][NUM_COLUMNS];

    public static void Reset() {
//clear the board.
        for (int zrow=0;zrow<NUM_ROWS;zrow++)
            for (int zcol=0;zcol<NUM_COLUMNS;zcol++)
                board[zrow][zcol] = null;        
    }
    
    public static void Draw(Graphics2D g) {
        boolean runOnce = true;
//draw grid
        int ydelta = Window.getHeight2()/NUM_ROWS;
        int xdelta = Window.getWidth2()/NUM_COLUMNS;
 
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
            }
            count--;
        } 
        if(runOnce){
        for (int zrow=0;zrow<NUM_ROWS;zrow++)
        {
            for (int zcol=0;zcol<NUM_COLUMNS;zcol++)        
            {
                if (zrow == 0 || zrow == 1)
                    board[zrow][zcol] = new Piece(new Color(82, 69, 86));
                if (zrow == 6 || zrow == 7)
                    board[zrow][zcol] = new Piece(new Color(250, 236, 226));
                    
               if (board[zrow][zcol] != null)
                    board[zrow][zcol].draw(g, zrow, zcol,xdelta, ydelta);
            }
            runOnce = false;
        }        
        
        
        }
        
    }
    public static void SelectPiece(Graphics2D g, int xVal,int yVal){
        System.out.println("output");
        xVal -= Window.getX(0);
        yVal -= Window.getY(0);
//don't add a piece if outside the board.
        if (xVal <= 0 || xVal >= Window.getWidth2() ||
        yVal <= 0 || yVal >= Window.getHeight2())  //too far to the left,right,top,bottom.
            return;
        
        int ydelta = Window.getHeight2()/NUM_ROWS;
        int xdelta = Window.getWidth2()/NUM_COLUMNS;
        int col = xVal/xdelta;
        int row = yVal/ydelta;
        System.out.println(row + " " + col);
        board[row][col].color = Color.YELLOW;
        System.out.println(board[row][col].getColor());
        board[row][col].draw(g, row, col,xdelta, ydelta);
  
        
    }
   

}
