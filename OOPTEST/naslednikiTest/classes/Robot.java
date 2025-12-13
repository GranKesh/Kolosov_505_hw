package classes;

public class Robot {
    protected String func;
    protected int speed;
    protected int range;

    public Robot(String func){
        this.func = func;
        this.speed = 2;
        this.range = 2;
    }
    public void move(){
        System.out.println(func + " Edu");
    }
    public void ccatch(){
        System.out.println(func + " Hvatau");
    }
}
