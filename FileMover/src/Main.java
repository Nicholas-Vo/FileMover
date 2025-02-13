import java.io.*;
import java.nio.file.*;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Path currentPath;
    static Path newPath;
    static PrintWriter file;
    static FileWriter history;
    static Path targetPath;
    static Scanner fsc = new Scanner(String.valueOf(history));

    public static void main(String[] args) throws IOException {

        currentPath = Path.of("Movable.txt").toAbsolutePath();
        System.out.println("Current dir: " + "\n" + currentPath);
        System.out.println("New Path: ");
        newPath = Paths.get(sc.nextLine());
        getDirectory();
        moveFile(); // Now correctly moves and updates the file

    }

    static void getDirectory() {
        try {
            file = new PrintWriter("Movable.txt");
            /*
            file.append("This file will be updated once it is moved to its new directory!");
            /* Once the file is moved it will display a different message:
               "This file was moved to a new directory!"
            */
            file.close();
        } catch (IOException exception) {
            System.out.println("Error!");
        }
    }

    static void moveFile() throws IOException {
        // Ensure the new path includes the file name, not just the directory
        targetPath = newPath.resolve(currentPath.getFileName());

        if (!Files.exists(targetPath)) {
            System.out.println("File moved successfully!");
            Files.move(currentPath, targetPath, StandardCopyOption.REPLACE_EXISTING);
            historyFile();
            // Update file contents after moving
        } else {
            System.out.println("This file already exists in this directory!");
        }
    }
    /*
    static void clearFile(Path targetFile) {
        // Clear the file and write new content to reflect the move
        try (FileOutputStream fos = new FileOutputStream(targetFile.toString(), false)) {
            String newContent = "This file was moved to a new directory!";
            fos.write(newContent.getBytes());
            System.out.println("File cleared and new content written successfully.");
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }

     */
    static void historyFile(){
        try {
            history = new FileWriter("History.txt");
            history.append(String.valueOf(newPath));
            history.close();
            System.out.println("History updated.");
            System.out.println(fsc.nextLine());
        } catch (IOException exception) {
            System.out.println("Error!");
            exception.printStackTrace();
        }
    }
