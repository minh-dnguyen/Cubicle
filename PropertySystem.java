import java.util.*;

public class PropertySystem{
    private ArrayList<Property> places;
    Scanner input = new Scanner(System.in);

    public PropertySystem(){
        places = new ArrayList<>();
    }

    public ArrayList<Property> getPlaces(){
        return places;
    }

    public void addProperty(){
        //all the variables for the superclass
        String propertyType;
        Status propertyStatus;
        String propertyAddress;
        int propertyMinCapcity;
        int propertyMaxCapacity;
        int bedrooms;
        int bathrooms;
        double propertyYearlyCost;
        String propertyFeatures;

        System.out.println("\n---GENERAL INFORMATION OF PROPERTY---");
        System.out.print("Enter the type of the property (Ex House / Apartment / Studio): ");
        propertyType = input.nextLine().trim();
        System.out.print("Status of the property (CONSIDERING, NEW, WITHDRAWN): ");
        String statusString = input.nextLine().trim(). toUpperCase();
        if(!verifyStatus(statusString)){
            statusString = "NEW";
        }
        //get the enum value instead of string value
        propertyStatus = Status.valueOf(statusString);
        System.out.print("Address: ");
        propertyAddress = input.nextLine().trim();
        //take up less lines but is more prone to errors
        System.out.print("Min and Max people capacity (seperated with a space): ");
        propertyMinCapcity = input.nextInt();
        propertyMaxCapacity = input.nextInt();
        System.out.print("Number of bedrooms and bathrooms (seperated with a space): ");
        bedrooms = input.nextInt();
        bathrooms = input.nextInt();
        input.nextLine();
        System.out.print("Other features of the property: ");
        propertyFeatures = input.nextLine();
        System.out.println("\n---SPECIFIC INFORMATION ABOUT PROPERTY---");


        if(propertyType.equalsIgnoreCase("apartment")){
            double monthlyRentAmount;
            String landlordName;
            int floorNumber;
            System.out.print("Landlord's Name: ");
            landlordName = input.nextLine();
            System.out.print("Floor number: ");
            floorNumber = input.nextInt();
            System.out.print("Monthly rent: ");
            monthlyRentAmount = input.nextDouble();
            //calculate the yearly amount instead of asking user to input it
            propertyYearlyCost = monthlyRentAmount * 12;
            input.nextLine();

            //Create new apartment object
            places.add(new Apartment(propertyAddress, propertyMinCapcity, propertyMaxCapacity, bedrooms, bathrooms, propertyYearlyCost, propertyFeatures, landlordName, monthlyRentAmount, floorNumber, propertyStatus));
        }
        else{
            System.out.print("Yearly Cost: ");
            propertyYearlyCost = input.nextDouble();
            input.nextLine();
            if(propertyType.equalsIgnoreCase("house")){
                int floors;
                int garages;
                double propertyTax;
                System.out.print("Property Tax %: ");
                propertyTax = input.nextDouble();
                System.out.print("Floors: ");
                floors = input.nextInt();
                System.out.print("Garages: ");
                garages = input.nextInt();
                input.nextLine();

                //Create new house object
                places.add(new House(propertyAddress, propertyMinCapcity, propertyMaxCapacity, bedrooms, bathrooms, propertyYearlyCost, propertyFeatures, propertyTax, floors, garages, propertyStatus));
            }
            else{
                //Else create an Other object
                places.add(new Other(propertyAddress, propertyMinCapcity, propertyMaxCapacity, bedrooms, bathrooms, propertyYearlyCost, propertyFeatures, propertyType.toUpperCase(), propertyStatus));
            }
            System.out.println("Succesfully added the property!");
        }
    }

    //tester will delete at the end 
    public void addMockProperty(Property property){
        places.add(property);
    }

    public void removeProperty(){
        if(places.isEmpty()){
            System.out.println("There are no property to remove. Please add a property or choose a different response!");
        }
        
        System.out.println("---REMOVING PROPERTY---");
        int propertyNum;
        while(true){
            System.out.print("Enter the property number you wish to remove: ");
            //Show safety verification, it would take up a lot of room is I used it on the add property though
            if (input.hasNextInt()) {
                propertyNum = input.nextInt(); // Safe to call nextInt() now
                if(propertyNum > 0 && propertyNum <= places.size()){
                    input.nextLine();
                    break;
                }
                System.out.println("Not a valid property number.");
            } else {
            System.out.println("Error: Not a valid integer.");
            input.nextLine();
        }
        }
        //Property displayed starting with 1-n
        //Indexes start with 0-n-1
        places.remove(propertyNum-1);
        System.out.println("Successfully removed that property");
    }

    private boolean verifyStatus(String input){
        return (input.equalsIgnoreCase("considering") || input.equalsIgnoreCase("new") || input.equalsIgnoreCase("withdraw"));
    }

    //used in the delete a property as a shorthand to not take up all the room
    public void displayAllPlacesShorthand(){
        //ensures that there is no display for the header
        if(places.isEmpty()){
            System.out.println("There are no saved properties!, Please add some if you wish to view your properties");
            return;
        }
        System.out.println("\nA simplified display of the properties: ");
        System.out.println("---------------------------");
        for(int i = 0; i < places.size(); i++){
            Property property = places.get(i);
            System.out.printf("PROPERTY #%d: ", i+1);
            property.displayPropertyShorthand();
        }
        System.out.println("---------------------------");
    }

    public void displayAllPlaces(){
        //ensures that there is no display for the header
        if(places.isEmpty()){
            System.out.println("There are no saved properties!, Please add some if you wish to view your properties");
            return;
        }
         System.out.println("\nAfter a property is displayed press enter to load the next one!");
        for(int i = 0; i < places.size(); i++){
            Property property = places.get(i);
             System.out.println("---------------------------");
            System.out.printf("PROPERTY #%d\n", i+1);
            property.displayProperty();
             System.out.println("---------------------------");
            input.nextLine();
        }
    }
}