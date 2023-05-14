import java.io.*;
import java.util.*;

public class zadanie_6 {
    public static String read() {
        StringBuilder a = new StringBuilder();
        try (FileReader reader = new FileReader("text6.txt")) {
            int c;
            while ((c = reader.read()) != -1) {
                a.append((char) c);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return a.toString();
    }

    public static void write(String a, boolean bo) {
        try (FileWriter writer = new FileWriter("text6.txt", bo)) {
            writer.write(a);
            writer.flush();
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] args) {
        ArrayList<Double> car = new ArrayList<Double>();
        String cs = read();
        int k = 0, j = 1, c = 0;
        boolean t2 = true, t3 = true;
        for (int i = 0; i < cs.length(); i++) {
            if (cs.charAt(i) == ';')
                k++;
            if (k == 2 & t2) {
                while (true) {
                    if (cs.charAt(i - j) == ';') {
                        car.add(Double.parseDouble(cs.substring(i - j + 2, i)));
                        j = 1;
                        t2 = false;
                        break;
                    }
                    j++;
                }
            }
            if (k == 3 & t3) {
                while (true) {
                    if (cs.charAt(i - j) == ';') {
                        car.add(Double.parseDouble(cs.substring(i - j + 2, i)));
                        j = 1;
                        t3 = false;
                        break;
                    }
                    j++;
                }
            }
            if (k == 4) {
                k = 0;
                t2 = true;
                t3 = true;
            }
        }
        for (int i = 0; i < car.size(); i += 2) {
            if (car.get(i) >= 2 & car.get(i) <= 5 & car.get(i + 1) >= 2000 & car.get(i + 1) <= 2007) {
                c++;
            }
        }
        write("\nКоличество машин, удовлетворяющих критериям: " + Integer.toString(c), true);
    }
}
