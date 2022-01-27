import java.util.Scanner;

public class Menu {
    static Scanner sc = new Scanner(System.in);
    public static void menu() throws Exception {
        System.out.println("Welcome! What do you want to do?\n1 - Create a Kitchen\n2 - Cook");
        int choice = sc.nextInt();

        switch(choice) {
            case 1:
                Kitchen.createAKitchen();
                break;
            case 2:
                Kitchen.cook();
                break;
        }
    }
}
