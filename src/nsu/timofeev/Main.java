package nsu.timofeev;


public class Main {

    public static void main(String[] args)  {
        try {
            System.out.println("Automobile Database");
            Menu menu = new Menu();
            menu.mainMenu();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
