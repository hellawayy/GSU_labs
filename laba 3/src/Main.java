//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Hoodie hoodie = new Hoodie("Nike",40.99,"Modern",77,52);
        System.out.println(hoodie.toString());

        Jacket jacket = new Jacket("Adidas",149.99,"Vintage","Winter","Yes");
        System.out.println(jacket.toString());

        Trousers trousers = new Trousers("Demix",52.99,"Sport","Yes");
        System.out.println(trousers.toString());
    }
}