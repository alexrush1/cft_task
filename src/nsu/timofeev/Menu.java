package nsu.timofeev;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Menu {
    dbase base = new dbase();
    Scanner in = new Scanner(System.in);

    public Menu() throws IOException {

    }

    public void mainMenu() throws IOException {
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Print all base");
            System.out.println("2. Add new auto");
            System.out.println("0. Exit\n");
            System.out.print("~base: ");
            int mode = in.nextInt();
            switch (mode) {
                case 1 -> base.printBase(in);
                case 2 -> base.addAutoManual(in);
                case 0 -> System.exit(0);
            }
        }
    }
}
