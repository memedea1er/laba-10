import java.io.*;
import java.util.*;

public class zadanie_1 {
    public static char vvod() {
        Scanner in = new Scanner(System.in);
        String x = in.nextLine();
        char t = ' ';
        while (true) {
            if (x.length() != 1) {
                System.out.println("Элемент массива должен быть одним символом");
                x = in.nextLine();
            } else {
                t = x.charAt(0);
                break;
            }
        }
        return t;
    }

    public static void mas(char[] array) {
        try (FileReader reader = new FileReader("text1.txt")) {
            int c;
            while ((c = reader.read(array)) > 0) {

                if (c < 10) {
                    array = Arrays.copyOf(array, c);
                }
                System.out.println(array);
            }
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }

    public static int abc(char[] array, char s) {
        int a = 0;
        for (int i = 0; i < 10; i++) {
            if (array[i] == s) {
                a += 1;
            }
        }
        return a;
    }

    public static boolean c(char[] array, String s) {
        boolean cp = true;
        for (int i = 0; i < s.length(); i++) {
            if (abc(array, s.charAt(i)) == 0) {
                cp = false;
                break;
            }
        }
        return cp;
    }

    public static boolean d(char[] array, String s) {
        boolean a = false;
        for (int i = 0; i < 9; i++) {
            if ((String.valueOf(array[i]) + String.valueOf(array[i + 1])).equals(s)) {
                a = true;
                break;
            }
        }
        return a;
    }

    public static boolean e(char[] array) {
        boolean a = false;
        char kostil = array[0];
        for (int i = 1; i < 9; i++) {
            if (array[i] == kostil) {
                a = true;
                break;
            }
            kostil = array[i];
        }
        return a;
    }

    public static boolean f(char[] array, int i, int l) {
        boolean a = false;
        if (array[i] == array[(i + l) % 10]) {
            a = true;
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] array = new char[10];
        mas(array);
        System.out.println("б) Введите символ");
        char b = vvod();
        System.out.println("в) Введите строку");
        String c = in.next();
        int i = -1;
        int j = -1;
        int l = -1;
        while (true) {
            System.out.println("e) Введите l (1<i<j<11)");
            l = in.nextInt();
            System.out.println("e) Введите i (1<i<j<11)");
            i = in.nextInt() - 1;
            System.out.println("e) Введите j (1<i<j<11)");
            j = in.nextInt() - 1;
            if (i + 1 > l & j + 1 > i + 1 & 11 > j + 1) {
                break;
            }
        }
        System.out.println("а) " + abc(array, ' '));
        System.out.println("б) " + abc(array, b));
        System.out.println("в) " + c(array, c));
        System.out.println("г) " + (d(array, "но") | d(array, "он")));
        System.out.println("д) " + e(array));
        System.out.println("e) " + (f(array, i, l) & f(array, j, l)));
    }
}