import java.util.Scanner;

public class Perulangan2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Masukan n: ");
        int n = scan.nextInt();
        printAst(n);

    }

    public static void printAst(int n) {
      /*  for(int baris = 0; baris < n; baris++){
            for(int j = 0; j < n; j++){
               if(j == 0 || j == baris || j == n-1 || j == (n-1)-baris || j == n/2) {
                   System.out.print("*");
               }
               else {
                   System.out.print(" ");
               }
            }
            System.out.println();*/
        // cara yang gagal

        for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if ((j <= i || j >= (n+1)-i) && (j >= i || j <=(n+1)-i)) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                }
            System.out.println();
            }
        }
    }
