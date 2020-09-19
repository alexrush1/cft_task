package nsu.timofeev;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Parser {
    public ArrayList<Auto> txtToDB(InputStream in) {
        Scanner scanner = new Scanner(in);
        String buffer;
        ArrayList<Auto> list = new ArrayList<Auto>();
        while (scanner.hasNext()) {
            buffer = scanner.nextLine();
            String[] param = buffer.split(",");
            for (int i = 0; i < 4; i++) {
                param[i] = param[i].replaceAll("\\W", "");
            }
            Auto auto = new Auto(Integer.valueOf(param[2]), param[0], param[1], param[3]);
            list.add(auto);
        }
        return list;
    }
    public void dbToTxt(ArrayList<Auto> list) throws IOException {
        File file = new File("db");
        PrintWriter out = new PrintWriter(file);
        for (Auto a : list) {
            out.printf("\"%s\",\"%s\",\"%s\",\"%s\";\n", a.getManufacturer(), a.getModel(), a.getYear(), a.getBodyType());
        }
        out.close();
    }
}
