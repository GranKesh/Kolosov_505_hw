package classes;

public class Tank extends Robot{
    private int armor;
    public Tank(String func){
        super(func);
        this.armor = 5;
    }

    public void zachichayu(){
        System.out.println(func + " Zachichayu");
    }
}
