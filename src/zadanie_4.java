import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class zadanie_4 {
    public static String read() {
        StringBuilder a = new StringBuilder();
        try (FileReader reader = new FileReader("text4.txt")) {
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
        try (FileWriter writer = new FileWriter("text4_1.txt", bo)) {
            writer.write(a);
            writer.flush();
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] args) {
        String st = read() + " ";
        write("", false);
        String st2 = "_.,;:\n\t!?";
        String st3 = "BCDFGHJKLMNPQRSTVWXZbcdfghjklmnpqrstvwxz";
        for (int k = 0; k < st.length(); k++) {
            if (st2.indexOf(st.charAt(k)) > -1) {
                st = st.replace(st.charAt(k), '\n');
            }
        }
        for (int i = 0; i < st.length(); i++) {
            if ((st.charAt(i) == ' ' | i == st.length() - 1)) {
                int j = 1;
                boolean t = false;
                boolean t2 = true;
                while (i - j >= 0) {
                    if (st.charAt(i - j) == '\n') {
                        t = true;
                        t2 = false;
                    }
                    if (st3.indexOf(st.charAt(i - j)) > -1) {
                        t2 = false;
                    }
                    if (i - j == 0) {
                        if (t | t2) {
                            write(st.substring(0, i) + "\n", true);
                        }
                        break;
                    } else if (st.charAt(i - j - 1) == ' ') {
                        if (t | t2) {
                            write(st.substring(i - j, i) + "\n", true);
                        }
                        break;
                    }
                    j++;
                }
            }
        }
    }
}

