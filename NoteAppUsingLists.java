import java.util.*;

class Notes {

  private String noteD;
  private String noteN;
  private String noteC;

  Notes(String noteDate, String noteName, String noteContent) {  //parametrized constructor
    noteN = noteName;
    noteC = noteContent;
    noteD = noteDate;
  }
  public String getnoteName() {   // returns only note Name
    return noteN;
  }
  public String getnoteDate() {   // returns only note date
    return noteD;
  }
  public String getnoteContent() {  // returns only note contnet
    return noteC;
  }
  public String getNote() {  // returns all information at once
    return noteD + "\n" + noteN + "\n" + noteC;  
  }
}

class NoteAppUsingLists {
  public static void main(String[] args) {
    List<Notes> N = new ArrayList<Notes>(); //initializing our Arraylist

    Scanner scan = new Scanner(System.in);  //for String input
    Scanner in = new Scanner(System.in);    //for Number input

    boolean found = false;

    int ch;
    do {
      // main menu
      System.out.println("1. insert new Notes");
      System.out.println("2. Show all Notes");
      System.out.println("3. search Notes");
      System.out.println("4. Delete Notes");
      System.out.println("5. Update Notes");
      System.out.println("6. Exit");
      System.out.print("Enter your choice: ");
      ch = in.nextInt();

      switch (ch) {
        case 1:     // inserting values 
          System.out.print("Enter date: ");
          String Date = scan.nextLine();
          System.out.print("Enter your notes name: ");
          String Name = scan.nextLine();
          System.out.print("Write your note here: ");
          String Content = scan.nextLine();
          N.add(new Notes(Date, Name, Content)); 
          break;
        case 2:  //displaying values using iterator
          System.out.println("-----------------------------");
          Iterator<Notes> IN = N.iterator();
          while (IN.hasNext()) {
            Notes note = IN.next();
            System.out.println(note.getNote() + "\n");
          }
          System.out.println("-----------------------------");
          break;
        case 3:
          System.out.print("Enter note name to search: ");
          IN = N.iterator();
          String noteNameSea = scan.nextLine();

          System.out.println("-----------------------------");

          while (IN.hasNext()) {
            Notes notes = IN.next();
            if (notes.getnoteName().equals(noteNameSea)) {
              System.out.println(notes.getNote());
              found = true;
            }
          }
          if (found != true) {
            System.out.println("No note Found.");
          }
          System.out.println("-----------------------------");
          break;
        case 4:
        found = false;
          System.out.print("Enter note name to delete: ");
          IN = N.iterator();
          String noteNameDel = scan.nextLine();

          System.out.println("-----------------------------");

          while (IN.hasNext()) {
            Notes notes = IN.next();
            if (notes.getnoteName().equals(noteNameDel)) {
              System.out.println(notes.getNote());
              IN.remove();
              found = true;
            }
          }
          if (!found) {
            System.out.println("No note Found.");
          } else {
            System.out.println("\nThis Note has been deleted successfully.");
          }
          System.out.println("-----------------------------");
          break;
        case 5:
        found = false;
        System.out.print("Enter note name to update: ");
        ListIterator<Notes> LIN = N.listIterator();
        String noteNameUpd = scan.nextLine();

        System.out.println("-----------------------------");
        while (LIN.hasNext()) {
          Notes notes = LIN.next();
          if (notes.getnoteName().equals(noteNameUpd)) {
            System.out.println("Note name: " + notes.getnoteName());
            System.out.print("Enter date: ");
            Date = scan.nextLine();
            Name = notes.getnoteName();
            System.out.print("Write your note here: ");
            Content = scan.nextLine();
            LIN.set(new Notes(Name,Date,Content));
            found = true;
          }
        }
        if (!found) {
          System.out.println("No note Found.");
        } else {
          System.out.println("\nThis Note has been Updated successfully.");
        }
        System.out.println("-----------------------------");
        break;
        case 6:
          System.out.println("Exiting...");
          in.close();
          scan.close();
          break;
        default:
          break;
      }
    } while (ch != 6);
  }
}
