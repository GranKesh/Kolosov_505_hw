package classes;

public class Streloc extends Robot {
    private int damage;
    public Streloc(String func){
        super(func);
        this.damage = 10;
    }

    public void strelayu(){
        System.out.println(func + " Strelayu");
    }
}
