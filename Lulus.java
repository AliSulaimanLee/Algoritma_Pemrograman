import java.util.Scanner;
public class Lulus {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String nama;
        int nilai;

        System.out.print("Nama:");
        nama = scan.next();
        System.out.print("Nilai:");
        nilai = scan.nextInt();

        System.out.println(test(nama, nilai));

    }
    public static String test(String Nama, int Nilai){
        if(Nilai >= 60) {
            return (Nama + " "+ "Lulus");

        }else{
            return (Nama + " "+ "Tidak Lulus");
        }


    }

}
