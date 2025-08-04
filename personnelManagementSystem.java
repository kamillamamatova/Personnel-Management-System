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
      System.out.println("6- Print the information of a staff member");
      System.out.println("7- Delete a person");
      System.out.println("8- Exit Program");

      // User input
      System.out.print("Enter your selection: ");
      String selection = input.nextLine().trim();
      switch(selection){
        case "1": enterFaculty(); break;
        case "2": enterStudent(); break;
        case "3": printStudentInvoice(); break;
        case "4": printFacultyInfo(); break;
        case "5": enterStaff(); break;
        case "6": printStaffInfo(); break;
        case "7": deletePerson(); break;
        case "8": running = false; exitProgram(); break;
        default: System.out.println("Wrong input, try again.");
      }
    }
  }
  // Method to enter a new student
    static void enterStudent(){
      // 3 tries
        for(int i = 0; i < 3; i++){
          System.out.println("Enter a student info:");
          System.out.print("Name: ");
          String name = input.nextLine();
          System.out.print("ID: ");
          String id = input.nextLine();

          // Validates ID format
          if(!id.matches("[a-zA-Z]{2}\\d{4}")){
            System.out.println("Invalid ID Format. Must be LetterLetterDigitDigitDigitDigit");
            continue;
          }

          // Duplicate ID
          if(findPersonById(id) != null){
            System.out.println("Duplicate ID. Must be a different ID.\nTry again.");
            continue;
          }

          try{
            System.out.print("GPA: ");
          }
        }
    }
}
