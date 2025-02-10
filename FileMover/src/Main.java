import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static String currentPath;
    static String newPath;
    public static void main(String[] args) throws IOException {

        currentPath = new java.io.File("Movable.txt").getCanonicalPath();
        System.out.println("Current dir: " + currentPath);
        newPath = String.valueOf(Path.of(sc.nextLine()));
        moveFile(currentPath, newPath);
        getDirectory();
        //moveFile(currentPath,newPath);

   }
   static void getDirectory(){
       try {
           PrintWriter file = new PrintWriter("Movable.txt");
           file.append("This file will be moved once it is moved to its new directory");
           /*Once the file is moved it will display a different message
           "This file was moved to a new directory "
            */
           file.close();
           System.out.println("File updated.");
       } catch (IOException exception) {
           System.out.println("Error!");
           exception.printStackTrace();

       }
   }
    private static void moveFile(String currentPath, String newPath) {
        moveFile(currentPath, newPath);
    }
}
