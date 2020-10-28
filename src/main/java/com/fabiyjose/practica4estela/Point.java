package com.fabiyjose.practica4estela;


public class Point {
    private final int x;
    private final int y;
    private int[] xPoint;
    private int[] yPoint;
    private int points;
    
    /**
     * Variables para la etrella.
     */
    private final int radius = 10;
    private final double spikiness = 0.4; //Grosor de aletas.
    
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public int getX(){
        return this.x;
    }
    
    public int getY(){
        return this.y;
    }
    
    public int[] getXs(){        
        return this.xPoint;
    }
    
    public int[] getYs(){
        return this.yPoint;
    }
    
    public int getPoints(){
        return this.points;
    }
        
    public void generateSquare(){
        this.xPoint = new int[]{this.getX()-5, this.getX(), this.getX()+5};
        this.yPoint = new int[]{this.getY()+5, this.getY()-5, this.getY()+5};
        this.points = 3;
    }
    
    public void generateStar(int spikes){
        this.points = spikes * 2 + 1;
        
        this.xPoint = new int[this.points];
        this.yPoint = new int[this.points];
       
        for (int i = 0; i < this.points; i++)
        {
            double iRadius = (i % 2 == 0) ? this.radius : (this.radius * this.spikiness);
            double angle = (i * 360.0) / (2*spikes);

            this.xPoint[i] = (int) (this.getX() + iRadius * Math.cos(Math.toRadians(angle - 90)));
            this.yPoint[i] = (int) (this.getY() + iRadius * Math.sin(Math.toRadians(angle - 90)));
        }   
    }  
    
}
