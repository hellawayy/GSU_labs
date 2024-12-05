public class Main {
    public static void main(String[] args) {
        Star sun = new Star("Sun");
        StarSystem solarSystem = new StarSystem(sun);

        solarSystem.addPlanet(new Planet("Venus"));
        solarSystem.addPlanet(new Planet("Jupiter"));
        solarSystem.addPlanet(new Planet("Saturn"));
        solarSystem.addPlanet(new Planet("Earth"));
        solarSystem.printInfo();
    }
}