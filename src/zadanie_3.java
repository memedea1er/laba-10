import java.io.*;

public class zadanie_3 {
    public static String file() {
        StringBuilder a = new StringBuilder();
        try (FileReader reader = new FileReader("text3.txt")) {
            int c;
            while ((c = reader.read()) != -1) {
                a.append((char) c);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return a.toString();
    }

    public static void main(String[] args) {
        String st = file() + " ";
        for (int i = 0; i < st.length(); i++) {
            char ch = st.charAt(i);
            if ((ch == ' ' | i == st.length() - 1)) {
                int j = 1;
                if (Character.isLowerCase(st.charAt(i - j))) {
                    while (i - j != 0) {
                        j++;
                        if (i - j == 0) {
                            if (Character.isUpperCase(st.charAt(0))) {
                                System.out.println(st.substring(0,i));
                            }
                            break;
                        } else if (st.charAt(i - j - 1) == ' ') {
                            if (Character.isUpperCase(st.charAt(i - j))) {
                                System.out.println(st.substring(i-j,i));
                            }
                            break;
                        }
                    }
                }
            }
        }
    }
}
