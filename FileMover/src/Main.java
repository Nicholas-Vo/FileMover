import java.io.FileOutputStream;
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
            file.append("This file will be updated once it is moved to its new directory!");
           /*Once the file is moved it will display a different message
           "This file was moved to a new directory!"
            */
            clearFile();
            file.close();
            System.out.println("File updated.");
        } catch (IOException exception) {
            System.out.println("Error!");
            exception.printStackTrace();

        }
    }
    static void moveFile() throws IOException {
        if (!Files.exists(newPath)) {
            Files.move(currentPath, newPath, StandardCopyOption.REPLACE_EXISTING);
        } else {
            System.out.println("File already exists at destination.");
        }
    }

    static void clearFile() throws IOException {

        // Clear the file and write new content
        try (FileOutputStream fos = new FileOutputStream(String.valueOf(newPath), false)) {
            String newContent = "This file was moved to a new directory!";
            fos.write(newContent.getBytes());
            System.out.println("File cleared and new content written successfully.");
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }
}
