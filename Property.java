

public abstract class Property {
    private String address;
    private int minPeopleCapacity;
    private int maxPeopleCapacity;
    private int bedrooms;
    private int bathrooms;
    private double yearlyCost;
    private String otherFeatures;
    private Status currentStatus;

    //main constructor
    public Property(String address, int minPeople, int maxPeople, int bedrooms, int bathrooms, double yearlyCost, String otherFeatures, Status currStatus){
        this.address = address;
        this.minPeopleCapacity = minPeople;
        this.maxPeopleCapacity = maxPeople;
        this.bedrooms = bedrooms;
        this.bathrooms = bathrooms;
        this.yearlyCost = yearlyCost;
        this.otherFeatures = otherFeatures;
        this.currentStatus = currStatus;
    }

    //all the getters and setters

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getMinPeopleCapacity() {
        return minPeopleCapacity;
    }

    public void setMinPeopleCapacity(int minPeopleCapacity) {
        this.minPeopleCapacity = minPeopleCapacity;
    }

    public int getMaxPeopleCapacity() {
        return maxPeopleCapacity;
    }

    public void setMaxPeopleCapacity(int maxPeopleCapacity) {
        this.maxPeopleCapacity = maxPeopleCapacity;
    }

    public int getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(int bedrooms) {
        this.bedrooms = bedrooms;
    }

    public int getBathrooms() {
        return bathrooms;
    }

    public void setBathrooms(int bathrooms) {
        this.bathrooms = bathrooms;
    }

    public double getYearlyCost() {
        return yearlyCost;
    }

    public void setYearlyCost(double yearlyCost) {
        this.yearlyCost = yearlyCost;
    }

    public String getOtherFeatures() {
        return otherFeatures;
    }

    public void setOtherFeatures(String otherFeatures) {
        this.otherFeatures = otherFeatures;
    }

    public Status getStatus() {
        return currentStatus;
    }

    public void setOtherFeatures(Status newStatus) {
        this.currentStatus = newStatus;
    }

    //superclass implementation of displayProperty that is used in the subclasses as well so need to make it abstract
    public void displayProperty(){
        System.out.println("Current Status: " + currentStatus.name());
        System.out.printf("For %d-%d People\n", minPeopleCapacity, maxPeopleCapacity);
        System.out.println("Address: " + address);
        System.out.printf("Bedrooms: %d | Bathrooms: %d\n", bedrooms, bathrooms);
        System.out.printf("Yearly Cost: $%.2f\n",yearlyCost);
    }

    //shorthand display to not clog terminal if needed
    public void displayPropertyShorthand(){
        System.out.printf("$%.2f | %s | %s\n",yearlyCost,currentStatus.name(), address);
    }

    public String getInformation() {
    return address + "|" + currentStatus.name() + "|" + yearlyCost + "|" + 
           minPeopleCapacity + "|" + maxPeopleCapacity + "|" + bedrooms + "|" + 
           bathrooms + "|" + otherFeatures;
    }


    public abstract void displayPicture();
}
