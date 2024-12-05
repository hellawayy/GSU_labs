import java.util.ArrayList;
import java.util.List;

public class StarSystem {
    Star star;
    List<Planet> planets;

    public StarSystem(Star star) {
        this.star = star;
        this.planets = new ArrayList<>();
    }

    public void addPlanet(Planet planet) {
        planets.add(planet);
    }

    public int getPlanetCount() {
        return planets.size();
    }

    public String getStarName() {
        return star.getName();
    }

    public void printInfo() {
        System.out.println("Star System: " + star.getName());
        System.out.println("Number of planets: " + getPlanetCount());
        System.out.println("Planets:");
        for (Planet planet : planets) {
            System.out.println("- " + planet);
        }
    }
}