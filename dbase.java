package nsu.timofeev;

import java.util.ArrayList;
import java.util.Scanner;

class dbase {
    private ArrayList<Auto> base = new ArrayList<Auto>();

    public void printBase(Scanner in) {
        for (int i = 0; i < base.size(); i++) {
            System.out.printf("%d. %s %s (%d)\n", i+1, base.get(i).getManufacturer(), base.get(i).getModel(), base.get(i).getYear());
        }
        while (true) {
            System.out.print("Choose auto (0 to main menu): ");
            int ans = in.nextInt();
            if (ans == 0) {
                break;
            }
            infoMore(ans - 1, in);
        }
    }

    private void infoMore(int ans, Scanner in) {
        System.out.printf("\nAbout auto #%d\n\n", ans);
        System.out.printf("Manufacturer: %s\n", base.get(ans).getManufacturer());
        System.out.printf("Model: %s\n", base.get(ans).getModel());
        System.out.printf("Year: %d\n", base.get(ans).getYear());
        System.out.printf("Body Type: %s", base.get(ans).getBodyType());
        System.out.printf("\n1.Edit info\n2.Delete auto\n0.Back to list\n");
        ans = in.nextInt();
    }

    private void delAuto() {
        
    }

    public void addAuto(Scanner in) {
        System.out.println("\nAdding new auto\n");
        System.out.print("Manufacturer: ");
        String man = in.next();
        System.out.print("Model: ");
        String model = in.next();
        System.out.print("Year: ");
        int year = in.nextInt();
        System.out.print("Body Type (cabrio/sedan/coupe/suv/pickup/crossover): ");
        String body = in.next();
        Auto auto = new Auto(year, man, model, body);
        base.add(auto);
    }
}