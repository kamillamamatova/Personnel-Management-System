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
            double gpa = Double.parseDouble(input.nextLine());
            System.out.print("Credit hours: ");
            int credits = Integer.parseInt(input.nextLine());
            people.add(new Student(name, id, gpa, credits));
            return;
          }

          // If parsing error
          catch(Exception e){
            System.out.println("Invalid, try again.");
          }
        }
    }

  // Method to enter a new faculty member
  static void enterFaculty(){
    // 3 tries
    for(int i = 0; i < 3; i++){
      System.out.println("Enter faculty info:");
      System.out.print("Name: ");
      String name = input.nextLine();
      System.out.print("ID: ");
      String id = input.nextLine();

      // Validate ID format
      if(!id.matches("[a-zA-Z]{2}\\d{4}")){
        System.out.println("Invalid ID Format. Must be LetterLetterDigitDigitDigitDigit");
        continue;
      }

      // Duplicate ID
      if(findPersonById(id) != null){
        System.out.println("Duplicate ID. Must be a different ID.\nTry again.");
        continue;
      }

      System.out.print("Department (Mathematics, Engineering, English): ");
      String department = input.nextLine();
      System.out.print("Rank (Professor or Adjunct): ");
      String rank = input.nextLine();

      // Validates department and rank
      if(!Arrays.asList("mathematics", "engineering", "english").contains(department.toLowerCase()) || !Arrays.asList("professor", "adjunct").contains(rank.toLowerCase())){
        System.out.println("Invalid, try again.");
        continue;
      }

      people.add(new Faculty(name, id, department, rank));
      System.out.println("Faculty added!");
      return;
    }
  }

  // Method to enter a staff member
  static void enterStaff(){
    // 3 tries
    for(int i = 0; i < 3; i++){
      System.out.println("Enter staff info:");
      System.out.print("Name: ");
      String name = input.nextLine();
      System.out.print("ID: ");
      String id = input.nextLine();

      // Validate ID format
      if(!id.matches("[a-zA-Z]{2}\\d{4}")){
        System.out.println("Invalid ID Format. Must be LetterLetterDigitDigitDigitDigit");
        continue;
      }

      // Duplicate ID
      if(findPersonById(id) != null){
        System.out.println("Duplicate ID. Must be a different ID.\nTry again.");
        continue;
      }

      System.out.print("Department (Mathematics, Engineering, English): ");
      String department = input.nextLine();
      System.out.print("Status (Part-time or Full-time): ");
      String status = input.nextLine();

      // Validates department and rank
      if(!Arrays.asList("mathematics", "engineering", "english").contains(department.toLowerCase()) || !Arrays.asList("part-time", "full-time").contains(status.toLowerCase())){
        System.out.println("Invalid, try again.");
        continue;
      }

      people.add(new Staff(name, id, department, status));
      return;
    }
  }

  // Method to print a student's tuition invoice
  static void printStudentInvoice(){
    System.out.print("Enter the student's ID: ");
    String id = input.nextLine();

    // Loops through to find the ID
    for(Person p : people){
      if(p instanceof Student && p.getId().equalsIgnoreCase(id)){
        p.print();
        return;
      }
    }

    System.out.println("Student with this ID doesn't exist.");
  }

  // Method to print faculty info
  static void printFacultyInfo(){
    System.out.print("Enter the faculty's ID: ");
    String id = input.nextLine();

    // Loops through to find the ID
    for(Person p : people){
      if(p instanceof Faculty && p.getId().equalsIgnoreCase(id)){
        p.print();
        return;
      }
    }
    System.out.println("Faculty with this ID doesn't exist.");
  }

  // Method to print staff info
  static void printStaffInfo(){
    System.out.print("Enter the staff's ID: ");
    String id = input.nextLine();

    // Loops through to find the ID
    for(Person p : people){
      if (p instanceof Staff && p.getId().equalsIgnoreCase(id)){
        p.print();
        return;
      }
    }
    System.out.println("Staff with this ID doesn't exist.");
  }

  // Method to delete a person
  static void deletePerson(){
    System.out.print("Enter ID to delete: ");
    String id = input.nextLine();
    Iterator<Person> it = people.iterator();
    while(it.hasNext()){
    }
  }
}
