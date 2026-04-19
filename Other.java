public class Other extends Property {
    private String originalType;

    public Other(String address, int minPeople, int maxPeople, int bedrooms, int bathrooms, double yearlyCost, String otherFeatures, String propertyType, Status currStatus){
        //calls super's constructor
        super(address, minPeople, maxPeople, bedrooms, bathrooms, yearlyCost, otherFeatures, currStatus);
        this.originalType = propertyType;
    }

    //seters and getters
    public String getOriginalType(){
        return originalType;
    }

    public void setOriginalType(String originalType){
        this.originalType = originalType;
    }

    public void displayPicture(){
        System.out.println("    _________");
        System.out.println("   /         \\");
        System.out.println("  |    ???    |");
        System.out.println("  |           |");
        System.out.println("  |___________|");
        System.out.println("      |   |");
        System.out.println("      |___|  \n");
    }

    @Override
    public String getInformation(){
        return originalType + "|" + super.getInformation();
    }

    @Override
    //displays the information for an Other property
    public void displayProperty(){
        displayPicture();
        System.out.printf("%s\n", originalType);
        super.displayProperty();
        System.out.println("Other Information: " + getOtherFeatures());
    }
}
