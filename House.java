public class House extends Property {
    private double propertyTax;
    private int floors;
    private int garages;

    public House(String address, int minPeople, int maxPeople, int bedrooms, int bathrooms, double yearlyCost, String otherFeatures, double propertyTax, int floors, int garages, Status currStatus){
                super(address, minPeople, maxPeople, bedrooms, bathrooms, yearlyCost, otherFeatures, currStatus);
                this.propertyTax = propertyTax;
                this.floors = floors;
                this.garages = garages;
    }

    //getters and setters
    public double getPropertyTax() {
    return propertyTax;
    }

    public void setPropertyTax(double propertyTax) {
        this.propertyTax = propertyTax;
    }

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }

    public int getGarages() {
        return garages;
    }

    public void setGarages(int garages) {
        this.garages = garages;
    }

    //visual image for houses
    public void displayPicture(){
        System.out.println("    ________________     ");
        System.out.println("  /                  \\  ");
        System.out.println(" /____________________\\ ");
        System.out.println("  |  __    __    __  |    ");
        System.out.println("  | |__|  |__|  |__| |    ");
        System.out.println("  |                  |    ");
        System.out.println("  |     ________     |    ");
        System.out.println("  |    |   __   |    |    ");
        System.out.println("  |    |  |  |  |    |    ");
        System.out.println("  |___ |__|__|__|____|    ");
        System.out.println("      |         |          ");
        System.out.println("      |_________|          \n");
    }
    
    @Override
    public String getInformation() {
        return "HOUSE|" + propertyTax + "|" + floors + "|" + garages + "|" + super.getInformation();
    }

    @Override
    public void displayProperty(){
        displayPicture();
        System.out.printf("%d FLOOR HOUSE\n", floors);
        super.displayProperty();
        System.out.printf("Property Tax: %.2f%%\n", propertyTax);
        System.out.println("Garages: " + garages);
        System.out.println("Other Information: " + getOtherFeatures());
    }
}
