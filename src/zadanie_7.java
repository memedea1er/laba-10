import java.io.*;

import static java.lang.Math.*;

public class zadanie_7 {
    public static void write(String a, boolean bo) {
        try (FileWriter writer = new FileWriter("text7.txt", bo)) {
            writer.write(a);
            writer.flush();
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] args) {
        write("Диапазон аргумента: -3<=x<=3\nФункция:\nif (x >= 0) \n\tx = sin(PI)\nelse \n\tx = PI * pow(x, 2)\nВывод в порядке возрастания x\n", false);
        for (Double x = -3.0; x <= 3.0; x += 0.5) {
            if (x >= 0)
                write(("x=" + x + "; f(x)=" + sin(PI) * x + "\n"), true);
             else
                write(("x=" + x + "; f(x)=" + PI * pow(x, 2) + "\n"), true);
        }
    }
}
