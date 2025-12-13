package classes;

public class Crafter extends Robot {
    private int craftSize;
    public Crafter(String func){
        super(func);
        this.craftSize = 3;
    }

    public void Crafshu(){
        System.out.println(func + " Sozdau predmet");
    }

}
