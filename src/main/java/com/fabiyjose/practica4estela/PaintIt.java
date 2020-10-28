package com.fabiyjose.practica4estela;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class PaintIt extends JPanel{
    
    //Dimensiones del círculo de la estela.
    private final int width = 10;
    private final int height = 10;
    private final int spikes = 5;
    
    //0 para círculos, 1 para triángulos, 2 para cuadriláteros, 3 para estrellas.
    private int shape = 0; 
    
    //Variables que indican el color escogido.
    private int colorEst = 7;
    private int colorBack = 0;
    
    /**Vector donde se almacenan 5 puntos,
     * inicializado todos los círculos en 
     * la coordenada (0,0) 
    **/
    private final Point pts = new Point(-10, -10);
    private final Point [] points = new Point[]{pts, pts, pts, pts, pts};
    
    /**Variables que recorren el vector de puntos,
     * y cuenta la separación entre puntos.
    **/
    private int pos = 0;
    private int sep = 0;
    
    //Vector de colores. Los mismos para ambos, distinto orden.
    private final Color [] colors = new Color[]{
        Color.WHITE, Color.RED, Color.GREEN, Color.BLUE, Color.GRAY, Color.MAGENTA,
        Color.CYAN, Color.BLACK
    };
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        this.setBackground(colors[colorBack]);
        g.setColor(colors[colorEst]);
        paintAllEst(g);        
    }
    
    private void paintAllEst(Graphics g){
        for(Point pt : points){
            switch (this.shape) {
                case 0:
                    g.fillOval(pt.getX(), pt.getY(), width, height);
                    break;
                case 1:
                    g.fillRect(pt.getX(), pt.getY(), width, height);
                    break;
                case 2:
                    pt.generateSquare();
                    g.fillPolygon(pt.getXs(), pt.getYs(), pt.getPoints());
                    break;
                default:
                    pt.generateStar(this.spikes); //Se pasa el número de aletas=5
                    g.fillPolygon(pt.getXs(), pt.getYs(), pt.getPoints());
                    break;
            }
        }
    }
    
    public void paintBack(int col){
        colorBack = col;
    }
    
    public void paintEst(int col){
        colorEst = col;
    }
    
    public void paintCircle(int x, int y, int shape){
        
        if (sep >= 7){
            this.shape = shape;
            Point pt = new Point(x, y);
            points[pos] = pt;
            pos++;

            if (pos >= points.length){
                pos = 0;
            }        
            this.repaint();
            sep = -1;
        }
        sep++;
    }
}
