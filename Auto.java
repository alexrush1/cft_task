package nsu.timofeev;

class Auto {
    private final int year;
    private final String manufacturer;
    private final String model;
    private final String bodyType;

    public Auto(int year, String man, String model, String body) {
        this.year = year;
        this.manufacturer = man;
        this.model = model;
        this.bodyType = body;
    }

    public int getYear() {
        return year;
    }
    public String getModel() {
        return model;
    }
    public String getManufacturer() {
        return manufacturer;
    }
    public String getBodyType() {
        return bodyType;
    }
}
