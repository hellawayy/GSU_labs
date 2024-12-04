public class Hoodie extends Clothes{
    private double sleeve_length;
    private double wool_percentage;

    public Hoodie(String manufacturer, double price, String style, double sleeve_length, double wool_percentage) {
        super(manufacturer, price, style);
        this.sleeve_length = sleeve_length;
        this.wool_percentage = wool_percentage;
    }

    public double getSleeve_length() {
        return sleeve_length;
    }

    public void setSleeve_length(double sleeve_length) {
        this.sleeve_length = sleeve_length;
    }

    public double getWool_percentage() {
        return wool_percentage;
    }

    public void setWool_percentage(double wool_percentage) {
        this.wool_percentage = wool_percentage;
    }
    public String toString() {
        return "Hoodie |" +
                "Manufacturer - " + getManufacturer() +
                ", Price = " + getPrice() +
                ", Style - " + getStyle() +
                ", Sleeve length - " + sleeve_length  +
                ", Wool percentage = " + wool_percentage +
                '|';
    }
}
