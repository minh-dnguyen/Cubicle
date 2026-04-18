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
        String propertyType;
        Status propertyStatus;
        String propertyAddress;
        int propertyMinCapcity;
        int propertyMaxCapacity;
        int bedrooms;
        int bathrooms;
        double propertyYearlyCost;
        String propertyFeatures;

        System.out.println("---GENERAL INFORMATION OF PROPERTY---");
        System.out.print("Enter the type of the property (Ex House / Apartment / Studio): ");
        propertyType = input.nextLine().trim();
        System.out.print("Status of the property (CONSIDERING, NEW, WITHDRAWN): ");
        String statusString = input.nextLine().trim(). toUpperCase();
        if(!verifyStatus(statusString)){
            statusString = "NEW";
        }
        propertyStatus = Status.valueOf(statusString);
        System.out.print("Address: ");
        propertyAddress = input.nextLine().trim();
        System.out.print("Min and Max people capacity (seperated with a space): ");
        propertyMinCapcity = input.nextInt();
        propertyMaxCapacity = input.nextInt();
        System.out.print("Number of bedrooms and bathrooms (seperated with a space): ");
        bedrooms = input.nextInt();
        bathrooms = input.nextInt();
        input.nextLine();
        System.out.print("Other features of the property: ");
        propertyFeatures = input.nextLine();
        System.out.println("\n=--SPECIFIC INFORMATION ABOUT PROPERTY---");


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
            propertyYearlyCost = monthlyRentAmount * 12;
            input.nextLine();

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

                places.add(new House(propertyAddress, propertyMinCapcity, propertyMaxCapacity, bedrooms, bathrooms, propertyYearlyCost, propertyFeatures, propertyTax, floors, garages, propertyStatus));
            }
            else{
                places.add(new Other(propertyAddress, propertyMinCapcity, propertyMaxCapacity, bedrooms, bathrooms, propertyYearlyCost, propertyFeatures, propertyType.toUpperCase(), propertyStatus));
            }
        }
    }

    public void addMockProperty(Property property){
        places.add(property);
    }

    public void removeProperty(){
        if(places.isEmpty()){
            System.out.println("There are no property to remove. Please add a property or choose a different response!");
        }
        
        int propertyNum;
        while(true){
            System.out.print("Enter the property number you wish to remove: ");
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
    }

    private boolean verifyStatus(String input){
        return (input.equalsIgnoreCase("considering") || input.equalsIgnoreCase("new") || input.equalsIgnoreCase("withdraw"));
    }

    public void displayAllPlacesShorthand(){
        System.out.println("A simplified display of the properties: ");
        for(int i = 0; i < places.size(); i++){
            Property property = places.get(i);
            System.out.printf("PROPERTY #%d: ", i+1);
            property.displayPropertyShorthand();
        }
    }

    public void displayAllPlaces(){
         System.out.println("After a property is displayed press enter to load the next one!\n");
        for(int i = 0; i < places.size(); i++){
            Property property = places.get(i);
            System.out.printf("PROPERTY #%d\n", i+1);
            property.displayPicture();
            property.displayProperty();
            input.nextLine();
        }
    }
}