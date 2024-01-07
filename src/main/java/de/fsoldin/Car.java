package de.fsoldin;

public class Car {

    public static void main(String [] args){
        System.out.println("Hello World!");
        //Hello World!
        Car car = new Car("BMW", 400);
        System.out.println(car.getAutomarke());
        System.out.println(car.getPs());
        System.out.println(car.getAutobeschreibung());
        //"BMW - 400"
        car.setPs(200);
        System.out.println(car.getAutobeschreibung());

        //(2,4)
        Vector2f a = new Vector2f(2,4);
        //(3,7)
        Vector2f b = new Vector2f(3,7);
        //addierst
        a.add(b);
        //ergebnis konsole
        System.out.println(a);
    }

    //Felder
    private String automarke;
    private int ps;

    //Konstruktoren
    public Car(String automarke,int ps){
        this.automarke = automarke;
        this.ps = ps;
    }

    //Methoden
    public String getAutomarke() {
        return automarke;
    }
    public int getPs(){
        return ps;
    }
    public String getAutobeschreibung(){
        return automarke + " - " + ps;
    }
    public void setPs(int ps){
        this.ps=ps;
    }
    // private/public/- Rückgabetyp - Name (Parameter ...) { return Rückgabetyp}
}
