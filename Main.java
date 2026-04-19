import java.util.*;

public class Main{
    public static void main(String[] args){
        //initialize the needed variables
        PropertySystem system = new PropertySystem();
        Scanner input = new Scanner(System.in);
        String fileName;
        int choice = 0;

        System.out.println("---WELCOME TO CUBICLE---");

        //allow user to read from file at start or go manual
        System.out.print("Load properties from a saved file? (Y/N): ");
        if (input.nextLine().trim().equalsIgnoreCase("y")) {
            System.out.print("Enter the file name to load (don't include .txt): ");
            fileName = input.nextLine().trim().concat(".txt");
            for (Property p : Filier.readFile(fileName)) {
                system.addMockProperty(p);
            }
            if(!system.getPlaces().isEmpty()){
                System.out.println("Properties loaded from " + fileName);
            }
        }

        //menu system
        while(choice != 7){
            displayMenu();
            System.out.print("Enter your choice: ");
            choice = input.nextInt();
            input.nextLine();

            switch(choice){
                case 1:
                    //display all saved properties
                    system.displayAllPlaces();
                    break;
                case 2:
                    //display all saved properties with a shorter notation
                    system.displayAllPlacesShorthand();
                    break;
                case 3:
                    system.addProperty();
                    //add a property to the list
                    break;
                case 4:
                    system.displayAllPlacesShorthand();
                    system.removeProperty();
                    //delete a saved property
                    break;
                case 5:
                    Filter.filterProperties(system.getPlaces(),input);
                    //filter properties based on criteria
                    break;
                case 6: 
                    Filier.writeToFile(system.getPlaces(), input);
                    //write saved properties to a file
                    break;
                case 7:
                    //exit the program
                    System.out.println("Thank you for using Cubicle!");
                    break;
                default:
                    System.out.println("Please enter a valid choice ranging from 1-6");
                    break;
            }
        }

    }

    //MENU
    public static void displayMenu(){
        System.out.println("\n---CUBICLE MENU---");
        System.out.println("1. Display All saved Properties");
        System.out.println("2. Display All saved Properties Shorthand");
        System.out.println("3. Add a property to the list");
        System.out.println("4. Delete a saved property");
        System.out.println("5. Filter Properties based on criteria");
        System.out.println("6. Write saved properties to a file");
        System.out.println("7. Exit the Program (Make sure to save your information!)");
        System.out.println("------------------");
    }
}