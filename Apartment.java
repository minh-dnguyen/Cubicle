import javax.annotation.processing.SupportedSourceVersion;

public class Apartment extends Property{
    private String landLordName;
    private double monthlyRentAmount;
    private int floorNumber;

    public Apartment(String address, int minPeople, int maxPeople, int bedrooms, int bathrooms, double yearlyCost, String otherFeatures, String landLordName, double monthlyRentAmount, int floorNumber,Status currStatus){
        super(address, minPeople, maxPeople, bedrooms, bathrooms, yearlyCost, otherFeatures, currStatus);
        this.landLordName = landLordName;
        this.monthlyRentAmount = monthlyRentAmount;
        this.floorNumber = floorNumber;
    }

    //getters and setters
    public String getLandLordName() {
    return landLordName;
    }

    public void setLandLordName(String landLordName) {
        this.landLordName = landLordName;
    }

    public double getMonthlyRentAmount() {
        return monthlyRentAmount;
    }

    public void setMonthlyRentAmount(double monthlyRentAmount) {
        this.monthlyRentAmount = monthlyRentAmount;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    @Override
    public void displayProperty(){
        System.out.printf("APARTMENT ON FLOOR %d\n", floorNumber);
        super.displayProperty();
        System.out.println("Monthly Rent: " + monthlyRentAmount);
        System.out.printf("Landord: %s\n", landLordName);
        System.out.println("Other Information: " + getOtherFeatures());
    }

    @Override
    public String getInformation() {
        return "APARTMENT|" + floorNumber + "|" + landLordName + "|" + monthlyRentAmount + "|" + super.getInformation();
    }

    //visual image for apartments
    public void displayPicture(){
    System.out.println("   ___________");
    System.out.println("  |   _   _   |");
    System.out.println("  |  |_| |_|  |");
    System.out.println("  |   _   _   |");
    System.out.println("  |  |_| |_|  |");
    System.out.println("  |   _   _   |");
    System.out.println("  |  |_| |_|  |");
    System.out.println("  |___________|");
    System.out.println("      |  |    ");
    System.out.println("      |__|     \n");
    }
}
