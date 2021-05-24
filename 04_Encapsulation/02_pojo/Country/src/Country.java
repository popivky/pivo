public class Country {
    private String countryName;
    private int numberPopulation;
    private int area; // Км²
    private  String capital;
    private boolean accessToSea;

    private Country (String countryName){
        this.countryName = countryName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public int getNumberPopulation() {
        return numberPopulation;
    }

    public void setNumberPopulation(int numberPopulation) {
        this.numberPopulation = numberPopulation;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public boolean getAccessToSea() {
        return accessToSea;
    }

    public void setAccessToSea(boolean accessToSea) {
        this.accessToSea = accessToSea;
    }





}
