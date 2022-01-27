import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class FileManager {
    private static File[] listOfFiles;
    private static File folder = new File("src/main/java/kitchens/");
    private static String[] Arrayfiles;
    static Scanner sc = new Scanner(System.in);
    static String content;

    public static String readFile(String fileName) throws IOException {
        File file = new File("src/main/java/kitchens/" + fileName);
        Scanner reader = new Scanner(file);
        while (reader.hasNextLine()) {
            content = reader.nextLine();
            return content;
        }
        reader.close();
        return content;
    }

    public static String getFilesOnDirectory() throws Exception {
        listOfFiles = folder.listFiles();

        String filesOnDirectory = "";

        for (int i = 0; i < listOfFiles.length; i++) {
            filesOnDirectory = listOfFiles[i].getName();
        }
        return filesOnDirectory;
    }

    public static boolean checkIfFileIsOnDirectory(String name) {
        File folder = new File("src/main/java/kitchens/");
        listOfFiles = folder.listFiles();
        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].equals(name)) {
                return true;
            }
        }
        return false;
    }


    public static void createFileIfNotExist(String name) throws IOException {
        File file = new File("src/main/java/kitchens/" + name);
        if (file.createNewFile()) {
            System.out.println("Your kitchen as been created");
        } else {
            System.out.println("This kitchen already exists!");
        }
    }

    public static void writeOnFile(String name, String content) throws Exception {

        content = "Knife -> " + Utensils.getKnife() + " ---- Pan -> " + Utensils.getPan();

        byte[] buffer = content.getBytes();

        FileOutputStream fileOutputStream;
        fileOutputStream = new FileOutputStream("src/main/java/kitchens/" + name);
        fileOutputStream.write(buffer);
        fileOutputStream.close();
    }

}

