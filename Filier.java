import java.io.*;
import java.util.*;

public class Filier {
    public static ArrayList<Property> readFile(String fileName){
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            ArrayList<Property> readList = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.isBlank()) continue;
                String[] parts = line.split("\\|");
                String type = parts[0];

                if (type.equals("HOUSE")) {
                    // HOUSE|propertyTax|floors|garages|address|status|yearlyCost|min|max|beds|baths|otherFeatures
                    double propertyTax   = Double.parseDouble(parts[1]);
                    int    floors        = Integer.parseInt(parts[2]);
                    int    garages       = Integer.parseInt(parts[3]);
                    String address       = parts[4];
                    Status status        = Status.valueOf(parts[5]);
                    double yearlyCost    = Double.parseDouble(parts[6]);
                    int    minPeople     = Integer.parseInt(parts[7]);
                    int    maxPeople     = Integer.parseInt(parts[8]);
                    int    bedrooms      = Integer.parseInt(parts[9]);
                    int    bathrooms     = Integer.parseInt(parts[10]);
                    String otherFeatures = parts[11];
                    readList.add(new House(address, minPeople, maxPeople, bedrooms, bathrooms,
                            yearlyCost, otherFeatures, propertyTax, floors, garages, status));

                } else if (type.equals("APARTMENT")) {
                    // APARTMENT|floorNumber|landLordName|monthlyRent|address|status|yearlyCost|min|max|beds|baths|otherFeatures
                    int    floorNumber       = Integer.parseInt(parts[1]);
                    String landLordName      = parts[2];
                    double monthlyRentAmount = Double.parseDouble(parts[3]);
                    String address           = parts[4];
                    Status status            = Status.valueOf(parts[5]);
                    double yearlyCost        = Double.parseDouble(parts[6]);
                    int    minPeople         = Integer.parseInt(parts[7]);
                    int    maxPeople         = Integer.parseInt(parts[8]);
                    int    bedrooms          = Integer.parseInt(parts[9]);
                    int    bathrooms         = Integer.parseInt(parts[10]);
                    String otherFeatures     = parts[11];
                    readList.add(new Apartment(address, minPeople, maxPeople, bedrooms, bathrooms,
                            yearlyCost, otherFeatures, landLordName, monthlyRentAmount, floorNumber, status));

                } else {
                    // OTHER|address|status|yearlyCost|min|max|beds|baths|otherFeatures
                    String originalType  = parts[0];
                    String address       = parts[1];
                    Status status        = Status.valueOf(parts[2]);
                    double yearlyCost    = Double.parseDouble(parts[3]);
                    int    minPeople     = Integer.parseInt(parts[4]);
                    int    maxPeople     = Integer.parseInt(parts[5]);
                    int    bedrooms      = Integer.parseInt(parts[6]);
                    int    bathrooms     = Integer.parseInt(parts[7]);
                    String otherFeatures = parts[8];
                    readList.add(new Other(address, minPeople, maxPeople, bedrooms, bathrooms,
                            yearlyCost, otherFeatures, originalType, status));
                }
            }
            
            return readList;
        } catch (Exception e) {
            System.out.println("There was an error accessing that file in your folder. We will default to manually adding");
            return new ArrayList<Property>();
        }
    }

    public static void writeToFile(ArrayList<Property> list, Scanner input){
        
        if(list.isEmpty()){
            System.out.printf("There is no property to write to a file :(");
            return;
        }
        
        //ask user which file to write to and if they want it to overwrite their existing work
        boolean append;
        String appendChoice;
        System.out.print("Enter a file you wish to write the information into: (don't include .txt): ");
        String fileName = input.nextLine().concat(".txt");
        System.out.print("Do you wish to overwrite the file? (Y/N): ");
        appendChoice = input.nextLine();
        append = !appendChoice.equalsIgnoreCase("y");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName,append))) {
            for(Property property : list){
                //getInformation has the properties seperated by | for easier reading/parsing for readFileMethod
                writer.write(property.getInformation());
                writer.newLine();
            }
            System.out.printf("Successfully written to %s\n", fileName);
        } catch (Exception e) {
            System.out.println("There was an error writting to the file please try again");
        }
    }
}
