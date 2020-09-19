package nsu.timofeev;

import java.util.Scanner;

public class Menu {
    dbase base = new dbase();
    Scanner in = new Scanner(System.in);
    public void mainMenu() {
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Print all base");
            System.out.println("2. Add new auto");
            System.out.println("0. Exit\n");
            System.out.print("~base: ");
            int mode = in.nextInt();
            switch (mode) {
                case 1 -> base.printBase(in);
                case 2 -> base.addAuto(in);
                case 0 -> System.exit(0);
            }
        }
    }
}
