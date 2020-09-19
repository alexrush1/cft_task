package nsu.timofeev;

class Auto {
    private int year;
    private String manufacturer;
    private String model;
    private String bodyType;

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

    public void setYear(int year) {this.year = year; }
    public void setModel(String model) {this.model = model; }
    public void setManufacturer(String manufacturer) {this.manufacturer = manufacturer; }
    public void setBodyType(String bodyType) { this.bodyType = bodyType; }
}
