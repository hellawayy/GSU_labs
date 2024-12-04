public class Jacket extends Clothes {
    private String season;
    private String hood;

    public Jacket(String manufacturer, double price, String style, String season, String hood) {
        super(manufacturer, price, style);
        this.season = season;
        this.hood = hood;
    }


    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getHood() {
        return hood;
    }

    public void setHood(String hood) {
        this.hood = hood;
    }

    public String toString() {
        return "Jacket |" +
                "Manufacturer - " + getManufacturer() +
                ", Price = " + getPrice() +
                ", Style - " + getStyle() +
                ", Season - " + season  +
                ", Hood = " + hood +
                '|';
    }
}
