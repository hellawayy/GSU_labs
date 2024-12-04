public class Trousers extends Clothes{
    private String flare;

    public Trousers(String manufacturer, double price, String style, String flare) {
        super(manufacturer, price, style);
        this.flare = flare;
    }

    public String getFlare() {
        return flare;
    }

    public void setFlare(String flare) {
        this.flare = flare;
    }
    public String toString() {
        return "Trousers |" +
                "Manufacturer - " + getManufacturer() +
                ", Price = " + getPrice() +
                ", Style - " + getStyle() +
                ", Flare - " + flare  +
                '|';
    }
}
