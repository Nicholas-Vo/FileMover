import java.io.IOException;
import java.io.PrintWriter;

public class Main {
   public static void main(String[] args) throws IOException {
       String currentPath = new java.io.File("Movable.txt").getCanonicalPath();
       System.out.println("Current dir: " + currentPath);
        getDirectory();

   }
   static void getDirectory(){
       try {
           PrintWriter file = new PrintWriter("Movable.txt");
           file.append("This file will be moved with the magic of coding!!");
           /*Once the file is moved it will display a different message
           "This file was moved with the magic of coding "
            */
           file.close();
           System.out.println("File updated.");
       } catch (IOException exception) {
           System.out.println("Error!");
           exception.printStackTrace();

       }
   }
}