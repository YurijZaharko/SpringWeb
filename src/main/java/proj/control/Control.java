package proj.control;

/**
 * Created by SCIP on 01.08.2016.
 */
public class Control {
    private Scann scann;

    public Control(Scann scann) {
        this.scann = scann;
    }

    public int mainMenu(){
        System.out.println("1. Work with Brand");
        System.out.println("2. Work with Country");
        System.out.println("3. Work with Category");
        System.out.println("4. Work with String property");
        System.out.println("5. Work with Integer property");
        System.out.println("6. Work with Category property");
        System.out.println("7. Work with Product");

        System.out.println("0. Exit");
        return scann.readInt("Enter number");
    }

    public int subMenu(){
        System.out.println("1. Add item");
        System.out.println("2. Delete item");
        System.out.println("3. Find by name");
        System.out.println("4. Find All");

        return scann.readInt("Enter number");
    }



}
