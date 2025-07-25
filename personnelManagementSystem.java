import java.util.*; // Import util like Scanner, ArrayList, etc,
import java.io.*; // Import file operations
import java.time.LocalDate; // Import for current data

public class FinalProject{
  // User input
  static Scanner input = new Scanner(System.in);
  // List for all personnel
  static ArrayList<Person> people = new ArrayList<>();

  public static void main(String[] args){
    System.out.println("\n\t\t\tWelcome to the Personnel Management System\nChoose one of the options:");

    // Control var for loop
    boolean running = true;

    // Main menu loop
    while(running){
      System.out.println("\n\t\t\tWelcome to the Personnel Management System\nChoose one of the options:");
      System.out.println("1- Enter the information of a faculty");
      System.out.println("2- Enter the information of a student");
      System.out.println("3- Print tuition invoice for a student");
      System.out.println("4- Print faculty information");
      System.out.println("5- Enter the information of a staff member");
    }
  }
}
