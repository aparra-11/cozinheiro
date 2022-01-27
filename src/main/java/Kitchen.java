import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Kitchen {
    Utensils utensils;
    private static ArrayList<Utensils> utensilsList = new ArrayList<Utensils>();
    static Scanner sc = new Scanner(System.in);

    static String[] finalRead;

    public Kitchen (Utensils utensils) {
        this.utensils = utensils;
    }
    public static void createAKitchen() throws Exception {
        try {
            System.out.println("To create a kitchen, you have to specify which tools does it have. Please, tell us if you have de following utensils, using y for Yes and n for No");
            System.out.println("Knife");
            String knife = sc.nextLine();
            System.out.println("Pan");
            String pan = sc.nextLine();
            if (knife.equals("y") && pan.equals("y")) {
                utensilsList.add(new Utensils("Knife", "Pan"));
            } else if (knife.equals("y") && pan.equals("n")) {
                utensilsList.add(new Utensils("Knife", null));
            } else if (knife.equals("n") && pan.equals("y")) {
                utensilsList.add(new Utensils(null, "Pan"));
            } else if (knife.equals("n") && pan.equals("n")) {
                utensilsList.add(new Utensils(null, null));
            } else {
                System.out.println("That's not a correct input! Try again.");
                createAKitchen();
            }
            System.out.println("Please specify a name for your Kitchen");
            String fileName = sc.nextLine();
            String allFilesName = FileManager.getFilesOnDirectory();

            if (!FileManager.checkIfFileIsOnDirectory(fileName)) {
                FileManager.createFileIfNotExist(fileName);
            }
            FileManager.writeOnFile(fileName, allFilesName);

        } catch (InputMismatchException e){
            System.out.println("That's not a correct input! Try again.");
            createAKitchen();
        }
    }

    public static void cook() throws IOException {
        System.out.println("Welcome to the cooking spot. For our cooker to cook, we need a knife and a pan in our kitchen. Do you have it? Please, select the name of your kitchen!");
        String nameInput = sc.nextLine();
        Boolean exists = FileManager.checkIfFileIsOnDirectory(nameInput);
        if (exists = true) {
            String read = FileManager.readFile(nameInput);
            finalRead = read.split(" ---- ");
            if (finalRead[0].equals("Knife -> null") && finalRead[1].equals("Pan -> null") || finalRead[0].equals("Knife -> null") || finalRead[1].equals("Pan -> null")) {
                System.out.println("This kitchen doesn't have a knife and a pan! Please, choose another.");
                cook();
            } else {
                System.out.println("Nice! Our cooker just produced a delicious Carbonara. Enjoy!");
            }
        }
    }
}
