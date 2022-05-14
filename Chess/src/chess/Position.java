package chess;

public class Position {
   
    private int xpos;
    private int ypos;
    private int[] XYpos = new int[2];
    Position(int _xpos, int _ypos){
        xpos = _xpos;
        ypos = _ypos;
        XYpos[0] = xpos;
        XYpos[1] = ypos;
    }
    public int getX() {
        return xpos;
    }
    public int getY() {
        return ypos;
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