public class Clothes {
    private String manufacturer;
    private double price;
    private String style;

    public Clothes(String manufacturer, double price, String style) {
        this.manufacturer = manufacturer;
        this.price = price;
        this.style = style;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }
}
