package de.fsoldin;

public class Vector2f {

    //Klasse -> Mehrere Objekte instantiieren
    //Vector2f a
    //Vector2f b
    //a.setVector2f(b);
    //a.add(b);

    //Felder
    private float x;
    private float y;

    //Konstruktor
    public Vector2f(float x, float y) {
        this.x = x;
        this.y = y;
    }

    //Methoden

    //get x
    public float getX() {
        return x;
    }

    //get y

    public float getY() {
        return y;
    }

    //setVector2f
    public void setVector2f(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void setVector2f(Vector2f vector2f) {
        this.x = vector2f.getX();
        this.y = vector2f.getY();
    }

    //set x
    public void setX(float x) {
        this.x = x;
    }

    //set y
    public void setY(float y) {
        this.y = y;
    }

    //addiere add
    public void add(Vector2f vector2f) {
        this.x += vector2f.getX();
        this.y += vector2f.getY();
    }

    //subtrahiere subtract
    public void substract(Vector2f vector2f){
        this.x-= vector2f.getX();
        this.y-= vector2f.getY();
    }
    //multiplizieren mit vektor multiply
    public void multiply(Vector2f vector2f){
        this.x*= vector2f.getX();
        this.y*= vector2f.getY();
    }
    //multiplizieren mit ganzer zahl divide
    public void divide(Vector2f vector2f){
        this.x/= vector2f.getX();
        this.y/= vector2f.getY();
    }

    //Vector2f extends Object

    @Override
    public String toString() {
        //"(x,y)"
        return "("+x+","+y+")";
    }
}
