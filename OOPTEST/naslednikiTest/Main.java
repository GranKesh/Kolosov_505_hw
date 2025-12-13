//import classes.Crafter;
//import classes.robot;
import classes.*;

public class Main {
    public static void main(String[] args) {
        Robot robot = new Robot("BaseBot");
        Crafter crafter = new Crafter("CraftBot");
        Streloc streloc = new Streloc("SoldatBot");
        Tank tank = new Tank("TankBot");

        robot.move();
        robot.ccatch();

        System.out.println("\nshvatil palku\n");

        robot.move();
        crafter.ccatch();
        crafter.Crafshu();
        System.out.println(("\nsozdal kopio\n"));

        streloc.strelayu();
        System.out.println("rasstrelyal\n");

        tank.zachichayu();
        System.out.println("Zachitil");

    }
}