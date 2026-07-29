import java.util.ArrayList;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    BST tree = new BST();
    Scanner sc = new Scanner(System.in);

    tree.insert(105, "CTBus", "Colombo", 1200);
    tree.insert(102, "CTBus", "Kandy", 900);
    tree.insert(110, "Private Bus", "Galle", 1500);
    tree.insert(101, "CTBus", "Matara", 800);
    tree.insert(108, "Private Bus", "Jaffna", 1300);

    int choice;

    do {

      System.out.println("\n===== BUS RESERVATION SYSTEM =====");
      System.out.println("1. Display All Buses");
      System.out.println("2. Search Bus");
      System.out.println("3. Sort Buses By Fare");
      System.out.println("4. Exit");
      System.out.print("Enter your choice: ");

      choice = sc.nextInt();

      switch(choice) {

        case 1:
          System.out.println("\n===== BUS LIST =====");
          tree.inorder(tree.root);
          break;

        case 2:

          System.out.print("\nEnter Bus ID to search: ");
          int id = sc.nextInt();

          Bus found = tree.search(tree.root, id);

          if(found != null) {

            System.out.println("\n===== BUS FOUND =====");
            System.out.println("Bus ID      : " + found.busID);
            System.out.println("Bus Name    : " + found.busName);
            System.out.println("Destination : " + found.destination);
            System.out.println("Fare        : " + found.fare);

          } else {
            System.out.println("Bus not found!");

          }
          break;

        case 3:

          ArrayList<Bus> list = new ArrayList<>();
          tree.store(tree.root, list);
          SelectionSort.sortByFare(list);

          System.out.println("\n===== SORTED BY FARE =====");

          for(Bus b : list) {

            System.out.println(
                    "Bus ID: " + b.busID +
                            " | Name: " + b.busName +
                            " | Destination: " + b.destination +
                            " | Fare: " + b.fare
            );
          }

          break;

        case 4:

          System.out.println("Thank you for using Bus Reservation System.");
          break;

        default:

          System.out.println("Invalid choice!");

      }

    } while(choice != 4);

    sc.close();

  }
}