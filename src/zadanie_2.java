import java.io.*;
public class zadanie_2 {
    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                System.out.print(j+"-"+i+"="+(i-j)+" ");
            }
            System.out.println();
        }
        try(FileWriter writer = new FileWriter("text2.txt", false)) {
            String text = "Hello Gold!";
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
}
