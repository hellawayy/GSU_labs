import by.gsu.epamlab.Trial;
public class Runner {
    public static void main(String[] args) {
        Trial[] trials = {
                new Trial("Sakovich", 45, 93),
                null,
                new Trial("Zhylinsky", 51, 35),
                new Trial()
        };
        for (Trial trial : trials) {
            System.out.println(trial);
        }
    }
}