import java.io.*;
import java.util.*;

public class FileHandler {
    public static ArrayList<Property> readFile(String fileName){
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            ArrayList<Property> readList = new ArrayList<>();
            //YOUR IMPLEMENTATION HERE!
            //TRY TO FOLLOW THE FORMAT IN THE TXT FILE!
            return readList;
        } catch (Exception e) {
            System.out.println("There was an error accessing that file in your folder. We will default to manually adding");
            return new ArrayList<Property>();
        }
    }

    public static void writeToFile(ArrayList<Property> list, String fileName, boolean append){
        if(list.isEmpty()){
            System.out.printf("There is no property to write to %s :(", fileName);
            return;
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName,append))) {
            for(Property property : list){
                //getInformation has the properties seperated by | for easier reading/parsing for readFileMethod
                writer.write(property.getInformation());
                writer.newLine();
            }
        } catch (Exception e) {
            System.out.println("There was an error writting to the file please try again");
        }
    }
}
