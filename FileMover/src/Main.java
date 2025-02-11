import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.*;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Path currentPath;
    static Path newPath;
    static PrintWriter file;
    public static void main(String[] args) throws IOException {

            currentPath = Paths.get("Movable.txt");
            System.out.println("Current dir: " + "\n" + currentPath.toAbsolutePath());
            System.out.println("New Path: ");
            newPath = Paths.get(sc.nextLine());

            getDirectory();
            moveFile();

    }
    static void getDirectory(){
        try {
            file = new PrintWriter("Movable.txt");
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
    static void moveFile() throws IOException {
        Files.move(currentPath,newPath);
    }
}
