package chess;

public class Position {
   
    private int row;
    private int col;
    private int[] XYpos = new int[2];
    Position(int _row, int _col){
        row = _row;
        col = _col;
        XYpos[0] = row;
        XYpos[1] = col;
    }
    public int getRow() {
        return row;
    }
    public int getCol() {
        return col;
    }
    public int[] getXY() {        
        return XYpos;
    }
    public static int[] getXY(int xpos, int ypos) {        
        int[] returnInt = new int[2];
        returnInt[0] = xpos;
        returnInt[1] = ypos;
        return returnInt;
    }
}