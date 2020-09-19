package nsu.timofeev;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

class dbase {
    private ArrayList<Auto> base = new ArrayList<>();

    public dbase() throws IOException {
        loadTxt();
    }

    public void printBase(Scanner in) throws IOException {
        if (base.size() == 0) {
            System.out.println("\nThere are no records in database!");
        } else {
            while (true) {
                for (int i = 0; i < base.size(); i++) {
                    System.out.printf("%d. %s %s (%d)\n", i + 1, base.get(i).getManufacturer(), base.get(i).getModel(), base.get(i).getYear());
                }
                System.out.print("Choose auto (0 to main menu): ");
                int ans = in.nextInt();
                if (ans == 0) {
                    break;
                }
                infoMore(ans - 1, in);
            }
        }
    }

    private void infoMore(int ans, Scanner in) throws IOException {
        while (true) {
            System.out.printf("\nAbout auto #%d\n\n", ans);
            System.out.printf("Manufacturer: %s\n", base.get(ans).getManufacturer());
            System.out.printf("Model: %s\n", base.get(ans).getModel());
            System.out.printf("Year: %d\n", base.get(ans).getYear());
            System.out.printf("Body Type: %s", base.get(ans).getBodyType());
            System.out.print("\n1.Edit info\n2.Delete auto\n0.Back to list\n~base: ");
            int ans2 = in.nextInt();
            switch (ans2) {
                case 1: editInfo(ans, in); break;
                case 2: delAuto(ans); return;
                case 0: return;
            }
        }
    }

    private void editInfo(int index, Scanner in) throws IOException {
        while (true) {

            Auto element = base.get(index);
            System.out.printf("\nCurrent: %s %s (%d, %s)\n", element.getManufacturer(), element.getModel(), element.getYear(), element.getBodyType());

            System.out.print("\nEdit: \n1.Manufacturer\n2.Model\n3.Year\n4.Body Type\n~base: ");
            int ans = in.nextInt();
            String buffer;

            switch (ans) {
                case 1:
                    System.out.print("New manufacturer: ");
                    buffer = in.next();
                    element.setManufacturer(buffer);
                    break;
                case 2:
                    System.out.print("New model: ");
                    buffer = in.next();
                    element.setModel(buffer);
                    break;
                case 3:
                    System.out.print("New year: ");
                    buffer = in.next();
                    element.setYear(Integer.parseInt(buffer));
                    break;
                case 4:
                    System.out.print("New body type (cabrio/sedan/coupe/suv/pickup/crossover): ");
                    buffer = in.next();
                    element.setBodyType(buffer);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Wrong number");
                    break;
            }
            base.set(index, element);
            saveTxt();
        }
    }

    private void delAuto(int index) throws IOException {
        base.remove(index);
        System.out.print("\nDELETED!\n");
        saveTxt();
    }

    public void addAutoManual(Scanner in) throws IOException {
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
        saveTxt();
    }

    private void loadTxt() {
        Parser parser = new Parser();
        try {
            InputStream file = new FileInputStream("db");
            base = parser.txtToDB(file);
            file.close();
        } catch (Exception e) {}
    }

    private void saveTxt() throws IOException {
        Parser parser = new Parser();
        parser.dbToTxt(base);
    }
}