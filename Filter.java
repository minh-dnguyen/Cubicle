import java.util.*;

public class Filter {

        public static void filterProperties(ArrayList<Property> list, Scanner input){
            int sortingChoice;
            boolean choosingFilters = true;
            int minBedrooms = 0, maxBedrooms = Integer.MAX_VALUE, minBathrooms = 0, maxBathrooms = Integer.MAX_VALUE, minCapacity = 0, maxCapacity = Integer.MAX_VALUE, minFloors = 0, maxFloors = Integer.MAX_VALUE;
            double minYearCost = 0, maxYearCost = Double.MAX_VALUE, minTax = 0, maxTax = Double.MAX_VALUE;
            Status inStatus = null;
            String userInput;

            while(choosingFilters == true) {
                System.out.println("---FILTERING SYSTEM---");
                System.out.println("\nSelect what you'd like to sort by:");
                System.out.println("Status: 1");
                System.out.println("Minimum and Maximum Capacity: 2");
                System.out.println("Number of Bedrooms: 3");
                System.out.println("Number of Bathrooms: 4");
                System.out.println("Yearly Cost for Property: 5");
                System.out.println("Property Tax: 6");
                System.out.println("Number of Floors: 7");
                System.out.println("Finish Choosing Filters: 8");
                System.out.print("Enter your Choice: ");
                sortingChoice = input.nextInt();
                input.nextLine();

                switch(sortingChoice) {                 //need to check for if they put something wacky here
                case 1:
                    System.out.print("\nEnter your desired status (CONSIDERING, WITHDRAWN, or NEW): ");
                    userInput = input.nextLine().trim().toUpperCase();
                    try {
                        inStatus = Status.valueOf(userInput);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid status.");
                    }
                    break;
                case 2:
                    System.out.println("\nEnter the range of capacity you'd like: ");
                    System.out.print("Minimum: ");
                    minCapacity = input.nextInt();
                    System.out.print("Maximum: ");
                    maxCapacity = input.nextInt();
                    break;
                case 3:
                    System.out.println("\nEnter the range of bedrooms you'd like: ");
                    System.out.print("Minimum: ");
                    minBedrooms = input.nextInt();
                    System.out.print("Maximum: ");
                    maxBedrooms = input.nextInt();
                    break;
                case 4:
                    System.out.println("\nEnter the range of bathrooms you'd like: ");
                    System.out.print("Minimum: ");
                    minBathrooms = input.nextInt();
                    System.out.print("Maximum: ");
                    maxBathrooms = input.nextInt();
                    break;
                case 5:
                    System.out.println("\nEnter your desired yearly cost range: ");      //maybe change the phrasing on this? Just sounds weird but don't know what to change it to
                    System.out.print("Minimum: ");
                    minYearCost = input.nextDouble();
                    System.out.print("Maximum: ");
                    maxYearCost = input.nextDouble();
                    break;
                case 6:
                    System.out.println("\nEnter the range of property tax you'd like: ");
                    System.out.print("Minimum: ");
                    minTax = input.nextDouble();
                    System.out.print("Maximum: ");
                    maxTax = input.nextDouble();
                    break;
                case 7:
                    System.out.println("\nEnter the range of floors you'd like: ");
                    System.out.print("Minimum: ");
                    minFloors = input.nextInt();
                    System.out.print("Maximum: ");
                    maxFloors = input.nextInt();
                    break;
                case 8:
                    choosingFilters = false;
                    System.out.println();
                    break;
                default:
                    System.out.println("Please enter a number 1-8\n");
                }
            }


            ArrayList<Property> validProperties  = getFilteredProperties(list, minBedrooms, maxBedrooms, minBathrooms, maxBathrooms, minCapacity, maxCapacity, minFloors, maxFloors, minYearCost, maxYearCost, minTax, maxTax, inStatus);

            if(validProperties.isEmpty()){
                System.out.println("There were no properties that matched your criteria :(");
            }
            //display the filtered properties
            else{   
                System.out.println("---FILTERED PROPERTIES---");
                for(int i = 0; i < validProperties.size(); i++) {
                System.out.println("---------------------------");
                System.out.println("Filtered Property " + (i+1));
                validProperties.get(i).displayProperty();
                System.out.println("---------------------------");
                input.nextLine();
                }
                //ask user if they want to save the filtered properties to a file
                String saveToFile;
                System.out.print("Would you like to save the filtered properties to a file? (Y/N): ");
                saveToFile = input.nextLine();
                if(saveToFile.equalsIgnoreCase("y")){
                    Filier.writeToFile(list, input);
                }
            }
        }
        
    
    

    //method to filter an input ArrayList<Property> and outputs an ArrayList of the properties with the desired values
    private static ArrayList<Property> getFilteredProperties(ArrayList<Property> listOfProperties, int minBedrooms, int maxBedrooms, int minBathrooms, int maxBathrooms,
	        int minCapacity, int maxCapacity, int minFloors, int maxFloors, double minYearCost, double maxYearCost, double minTax, double maxTax, Status status) {
		int length = listOfProperties.size();
		ArrayList<Property> filteredProperties = new ArrayList<>();

		for (int i = 0; i < length; i++) {
			if(minBedrooms > listOfProperties.get(i).getBedrooms() || maxBedrooms < listOfProperties.get(i).getBedrooms()) {
				continue;
			}

			if(minBathrooms > listOfProperties.get(i).getBathrooms() || maxBathrooms < listOfProperties.get(i).getBathrooms()) {
				continue;
			}

			if(listOfProperties.get(i).getMaxPeopleCapacity() < minCapacity 
            || listOfProperties.get(i).getMinPeopleCapacity() > maxCapacity) {
                 continue;
            }

			if(listOfProperties.get(i) instanceof House) {
				House house = (House) listOfProperties.get(i);
				if(minFloors > house.getFloors() || maxFloors < house.getFloors()) {
					continue;
				}
				//don't have way to sort by garage #
				if(minTax > house.getPropertyTax() || maxTax < house.getPropertyTax()) {
					continue;
				}
			}
			if(minYearCost > listOfProperties.get(i).getYearlyCost() || maxYearCost < listOfProperties.get(i).getYearlyCost()) {
				continue;
			}
			if(status != null && status != listOfProperties.get(i).getStatus()) {
				continue;
			}
            //if the property fails all of the if statements it fits the criteria and is added
			filteredProperties.add(listOfProperties.get(i));

		}
		return filteredProperties;
	}
}
