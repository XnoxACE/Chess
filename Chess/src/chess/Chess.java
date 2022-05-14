package chess;

import java.io.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.basic.BasicTreeUI.SelectionModelPropertyChangeHandler;

public class Chess extends JFrame implements Runnable {
    boolean animateFirstTime = true;
    public static Piece selectedPiece;
    Image image;
    Graphics2D g;

    public static void main(String[] args) {
        Chess frame = new Chess();
        frame.setSize(Window.WINDOW_WIDTH, Window.WINDOW_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public Chess() {
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {

                if (e.BUTTON1 == e.getButton() ) {
                    if(selectedPiece != null && Board.SelectPiece(g, e.getX(),e.getY()) == null){

                        int xVal = e.getX();
                        int yVal = e.getY();

                        xVal -= Window.getX(0);
                        yVal -= Window.getY(0);
                        
                        if (xVal <= 0 || xVal >= Window.getWidth2() ||
                         yVal <= 0 || yVal >= Window.getHeight2()){
                             return;
                         }
                        Board.board[selectedPiece.row][selectedPiece.col] = null;
                        selectedPiece.setPos(e.getX(),e.getY());
                        selectedPiece.highlight = false;
                        selectedPiece = null;
                        
                        
                    }
                    else if(selectedPiece == null && Board.SelectPiece(g, e.getX(),e.getY()) != null){
                        selectedPiece = Board.SelectPiece(g, e.getX(),e.getY());
                    }
                    else if(selectedPiece != null && Board.SelectPiece(g, e.getX(),e.getY()) != null) {
                        selectedPiece.highlight = false;
                        selectedPiece = null;
                        selectedPiece = Board.SelectPiece(g, e.getX(),e.getY());
                        
                    }
                    
                    


                }

                if (e.BUTTON3 == e.getButton()) {

                }
                repaint();
            }
        });
            

    addMouseMotionListener(new MouseMotionAdapter() {
      public void mouseDragged(MouseEvent e) {

        repaint();
      }
    });

    addMouseMotionListener(new MouseMotionAdapter() {
      public void mouseMoved(MouseEvent e) {

        repaint();
      }
    });

        addKeyListener(new KeyAdapter() {

            public void keyPressed(KeyEvent e) {
                if (e.VK_UP == e.getKeyCode()) {
                } else if (e.VK_DOWN == e.getKeyCode()) {
                } else if (e.VK_LEFT == e.getKeyCode()) {
                } else if (e.VK_RIGHT == e.getKeyCode()) {
                } else if (e.VK_ESCAPE == e.getKeyCode()) {
                    reset();
                }
                repaint();
            }
        });
        init();
        start();
    }
    Thread relaxer;
////////////////////////////////////////////////////////////////////////////
    public void init() {
        requestFocus();
    }
////////////////////////////////////////////////////////////////////////////
    public void destroy() {
    }
////////////////////////////////////////////////////////////////////////////
    public void paint(Graphics gOld) {
        if (image == null || Window.xsize != getSize().width || Window.ysize != getSize().height) {
            Window.xsize = getSize().width;
            Window.ysize = getSize().height;
            image = createImage(Window.xsize, Window.ysize);
            g = (Graphics2D) image.getGraphics();
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
        }
//fill background
        
        g.setColor(Color.black);
        g.fillRect(0, 0, Window.xsize, Window.ysize);

        int x[] = {Window.getX(0), Window.getX(Window.getWidth2()), Window.getX(Window.getWidth2()), Window.getX(0), Window.getX(0)};
        int y[] = {Window.getY(0), Window.getY(0), Window.getY(Window.getHeight2()), Window.getY(Window.getHeight2()), Window.getY(0)};
//fill border
        g.setColor(Color.black);
        g.fillPolygon(x, y, 4);
// draw border
        g.setColor(Color.black);
        g.drawPolyline(x, y, 5);

        if (animateFirstTime) {
            gOld.drawImage(image, 0, 0, null);
            return;
        }
        
              
        Board.Draw(g);
        
        

        gOld.drawImage(image, 0, 0, null);
    }

////////////////////////////////////////////////////////////////////////////
// needed for     implement runnable
    public void run() {
        while (true) {
            animate();
            repaint();
            double seconds = .1;    //time that 1 frame takes.
            int miliseconds = (int) (1000.0 * seconds);
            try {
                Thread.sleep(miliseconds);
            } catch (InterruptedException e) {
            }
        }
    }
    
/////////////////////////////////////////////////////////////////////////
    public void reset() {
        Board.Reset();
        
    }
/////////////////////////////////////////////////////////////////////////
    public void animate() {

        if (animateFirstTime) {
            animateFirstTime = false;
            if (Window.xsize != getSize().width || Window.ysize != getSize().height) {
                Window.xsize = getSize().width;
                Window.ysize = getSize().height;
                
            }

            reset();

        }

        
    }

////////////////////////////////////////////////////////////////////////////
    public void start() {
        if (relaxer == null) {
            relaxer = new Thread(this);
            relaxer.start();
        }
    }
////////////////////////////////////////////////////////////////////////////
    public void stop() {
        if (relaxer.isAlive()) {
            relaxer.stop();
        }
        relaxer = null;
    }

}