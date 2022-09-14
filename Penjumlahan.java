import java.util.Scanner;

public class Penjumlahan{
    public static void main(String[] args) {
        int x;
        int y;

        Scanner scan = new Scanner(System.in);
        System.out.print("Masukan x: ");
        x = scan.nextInt();
        System.out.print("Masukan y: ");
        y = scan.nextInt();

        System.out.println(tambah(x,y));

    }
    public static int tambah(int x, int y) {
        return x + y;

    }
}