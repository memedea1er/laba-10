import java.io.*;

public class zadanie_5 {
    public static String read() {
        StringBuilder a = new StringBuilder();
        try (FileReader reader = new FileReader("text5.txt")) {
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
        try (FileWriter writer = new FileWriter("text5_1.txt", bo)) {
            writer.write(a);
            writer.flush();
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] args) {
        String st = (read()+" ").replaceAll("\n", "").replace("\r", " ");
        String zn = ".?!";
        int nap=-1, nas=-1;
        boolean t=false;
        for (int i = 0; i<st.length()-1; i++) {
            if (st.charAt(i)!=' ' & zn.indexOf(st.charAt(i))==-1 & nap==-1) {
                nap=i;
            }
            if (st.charAt(i)!=' ' & zn.indexOf(st.charAt(i))==-1 & nas==-1) {
                nas=i;
            }
            if (nas!=-1) {
                if (!Character.isLetter(st.charAt(i+1)) & st.charAt(i)==st.charAt(nas) & Character.isLetter(st.charAt(nas)) & nas!=i) {
                    t=true;
                }
            }
            if (zn.indexOf(st.charAt(i))>-1) {
                if (t) {
                    write(st.substring(nap, i + 1) + " ", true);
                }
                nap=-1;
                t=false;
            }
            if (st.charAt(i)==' ' | zn.indexOf(st.charAt(i))>-1){
                nas=-1;
            }
        }
    }
}
