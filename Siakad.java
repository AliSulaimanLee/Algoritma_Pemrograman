import java.util.Scanner;


public class Siakad {
    static int jumlahData;
    static Mahasiswa[] mahasiswa = new Mahasiswa[1000];
    //Scanner scan = new Scanner(System.in); //why?

    public static void main(String[] args) {
        menu();
    }
    public static void menu() {
        Scanner scan = new Scanner(System.in);
        System.out.println(
                "Menu Siakad\n" +
                "1. Tambah Data\n" +
                "2. Lihat Data\n" +
                "3. Sortir Data\n" +
                        "4. Search Data\n" +
                        "5. Keluar\n" +
                "Pilih menu = ");

        int inputMenu;
        inputMenu = scan.nextInt();

        switch (inputMenu) {
            case 1:
                tambahData();
                menu();
                //tambah
                break;
            case 2:
                tampilData();
                menu();
                //lihat
                break;
            case 3:
                sortData();
                menu();
                //keluar
                break;
            case 4:
                searchData();
                menu();
                break;

        }

        }
        public static void tambahData() {
            Scanner scan = new Scanner(System.in);
            System.out.println("Silahkan tambah data");
            System.out.print("Masukan NIM: ");
            String nim = scan.nextLine();
            System.out.print("Masukan Nama: ");
            String nama = scan.nextLine();
            mahasiswa[jumlahData] = new Mahasiswa();
            mahasiswa[jumlahData].setNim(Integer.parseInt(nim));
            mahasiswa[jumlahData].setNama(nama);
            jumlahData++;

        }
        public static void tampilData(){
            System.out.println("Berikut data Anda:");
            int i = 0;

            while (i < jumlahData) {
                //if(mahasiswa[i].getNim() == null) {
                    System.out.println((i+1) +". " +mahasiswa[i].getNim() + " "+ mahasiswa[i].getNama());
                    i++;
                //}

            }
        }

        public static void sortData() {
        Scanner scan = new Scanner(System.in);
            System.out.println("Pilih Algoritma Sortir\n" +
                    "1. Exchange Sort\n" +
                    "2. Selection Sort\n" +
                    "3. Quick Sort\n" +
                    "4. Bubble Sort\n" +
                    "5. Shell Sort\n" +
                    "6. UAS Sort\n" +
                    "Pilih Algoritma: ");

            int selection =scan.nextInt();
            switch (selection) {
                case 1:
                    exchangeSort();
                    break;
                case 2:
                    selectionSort();
                    break;
                case 3:
                    quickSort(mahasiswa, 0, jumlahData-1);
                    break;
                case 4:
                    bubbleSort();
                    break;
                case 5 :
                    shellSort();
                    break;
                case 6:
                    uas();
                    break;
            }
        }
        public static void searchData() {
            Scanner scan = new Scanner(System.in);
            System.out.println("Pilih Algoritma Search\n" +
                    "1. Linear Search\n" +
                    "2. Binary Search (X)\n" +
                    "Pilih Algoritma: ");

            int selection=scan.nextInt();
            switch (selection) {
                case 1:
                    System.out.println("Search: ");
                    int target= scan.nextInt();
                    tampilSearch(linearSearch(target));
                    break;
                case 2:
                    System.out.println("Search: ");
                    int target2= scan.nextInt();
                    tampilSearch(binarySearch(mahasiswa,jumlahData-1 , 0,target2));
                    break;

        }
    }

    /* EDIT AND DELETE SECTION */
    public static void editData(int target) {
        Scanner scan = new Scanner(System.in);
        int nim;
        String nama;
        System.out.println("Tuliskan NIM terbaru: ");
        nim = scan.nextInt();
        System.out.println("Tuliskan Nama terbaru: ");
        nama= scan.next();

        mahasiswa[target].setNama(nama);
        mahasiswa[target].setNim(nim);

        /*
        if (nama != null) {
            mahasiswa[target].setNama(nama);
        }
        if (nim != null) {
            mahasiswa[target].setNim(nim);
        }

         */
    }

    public static Mahasiswa[] deleteData(Mahasiswa[] arr, int target)
    {
        // If the array is empty
        // or the index is not in array range
        // return the original array
        if (arr == null || target < 0 || target >= arr.length) {

            return arr;
        }

        // Create another array of size one less
        Mahasiswa[] anotherArray = new Mahasiswa[arr.length - 1];

        // Copy the elements except the index
        // from original array to the other array
        for (int i = 0, k = 0; i < arr.length; i++) {

            if (i == target) {
                continue;
            }

            // if the index is not
            // the removal element index
            anotherArray[k++] = arr[i];
        }
        jumlahData--; //INCONSISTENCY, could be optimized.
        return anotherArray;
    }




    /* EDIT AND DELETE SECTION ENDS*/

    /* UAS SECTION */

    public static void uas() {
        if(jumlahData == 0) {
            System.out.println("Tidak ada data.");

        }
        else {
            int jarak = jumlahData;
            int susut = 13;
            int urut = 0;
            Mahasiswa temp;

            while(urut == 0) {
                jarak = (jarak * 10) / susut;

                if(jarak <= 1) {
                    jarak = 1;
                    urut = 1;
                }

                for(int i = 0; i+jarak < jumlahData; i++) {
                    if(mahasiswa[i].getNim() > mahasiswa[i + jarak].getNim()) {
                        temp = mahasiswa[i];
                        mahasiswa[i]=mahasiswa[i+jarak];
                        mahasiswa[i+jarak]=temp;

                        //or use swap function here
                        //swap(mahasiswa, i, i+jarak);

                        urut = 0;
                    }
                }
            }
            System.out.println("Data telah diurutkan. Silahkan tampilkan data");


            }

        }


    /*UAS SECTION ENDS */

    /* SORT SECTION  */

        static void swap(Mahasiswa[] arr, int a, int b) {
            Mahasiswa temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
        }

        public static int partition(Mahasiswa[] arr, int low, int high) {
        int p = low;
        int i;
        for (i = low + 1; i <= high; i++) {
            if (arr[i].getNim() < arr[low].getNim()) {
                swap(arr, ++p, i);
                }
            }
        swap(arr, low, p);
        return p;
        }

        public static void quickSort(Mahasiswa[] arr, int low, int high) {
        if(low < high){
            int p = partition(arr, low, high); //dibagi dua dengan partisi
            quickSort(arr, low, p-1); //awal ke partisi
            quickSort(arr, p+1, high); //partisi ke akhir index
            }
        }

        public static void exchangeSort(){
        for (int i = 0; i < jumlahData; i++) {
            for(int j = i+1; j < jumlahData; j++) {
                if (mahasiswa[i].getNim() > (mahasiswa[j].getNim())) { //change
                    swap(mahasiswa, i, j);
                    }
                }
            }
        }

        public static void selectionSort() {
            for (int i = 0; i < jumlahData-1; i++) {
                int min = i; //data pertama
                for (int j = i + 1; j < jumlahData; j++) {
                    if(mahasiswa[j] == null){ //bugfix: nullpointerException
                        continue;
                    }
                    if(mahasiswa[j].getNim() > mahasiswa[min].getNim()) {
                        min = j;
                    }
                    //System.out.println("masuk"); //bugfix purposes
                    swap(mahasiswa, j, min);

                }
            }
        }

        public static void bubbleSort() {
        for (int i = 0; i < jumlahData-1; i++) {
            for (int j = 0; j < jumlahData-i ; j++) {
                if(mahasiswa[j]== null) {
                    continue;
                }
                if(mahasiswa[j+1] == null){
                    continue;
                }

                if(mahasiswa[j].getNim()>mahasiswa[j+1].getNim()){
                    System.out.println("masuk");
                    swap(mahasiswa, j, j+1);


                }

            }
        }
    }

    public static void shellSort() {
        for (int gap = jumlahData/2; gap > 0; gap/=2){
            for (int i = gap; i < jumlahData; i+= 1){
                Mahasiswa temp = mahasiswa[i];
                int j = i;
                if(mahasiswa[j] == null){
                    continue;
                }
                for (j = i; j>=gap && mahasiswa[j-gap].getNim()>temp.getNim(); j-= gap){
                    mahasiswa[j] = mahasiswa[j-gap];
                }
                mahasiswa[j] = temp;
            }
        }
    }

    /* SORT SECTION ENDS*/

    /* SEARCH SECTION  */
    public static void tampilSearch(int result) {
        if (result== -1) {
            System.out.println("Data tidak ada.");
        } else{
            //tampilan
            System.out.println((result+1) +". " +mahasiswa[result].getNim() + " "+ mahasiswa[result].getNama());

            System.out.println(); //space

            Scanner scan = new Scanner(System.in);
            System.out.println("Operasi\n" +
                    "1. Edit\n" +
                    "2. Delete\n" +
                    "3. Keluar\n" +
                    "Pilih Operasi= ");

            int selection = scan.nextInt();
            switch (selection) {
                case 1:
                    editData(result);
                    break;
                case 2:
                    mahasiswa = deleteData(mahasiswa, result);
                    break;
                case 3:
                    menu();
                    break;


            }
        }




    }

    public static int linearSearch(int target) {
        for (int i = 0; i < jumlahData; i++) {
            if (mahasiswa[i].getNim() == target)
                return i;
        }
        return -1; //return false
    }

    public static int binarySearch(Mahasiswa[] arr, int high, int low, int target) {
        if (high>=low){
            int mid = (low + high)/2;
            if (arr[mid].getNim()==target){
                return mid;
            }
            if (arr[mid].getNim()>target){
                return binarySearch(arr, mid-1, low, target);
            }
            return binarySearch(arr, high, mid+1, target);
        }
        return -1;
    }



    /* SEARCH SECTION ENDS */




              /*
        do {
            System.out.println(
                    "Menu Siakad\n" +
                            "1. Tambah Data\n" +
                            "2. Lihat Data\n" +
                            "3. Keluar\n" +
                            "Pilih menu = ");
            inputMenu = scan.nextInt();
            if (inputMenu == 1) {
                System.out.println("Silahkan tambah data");

            } else if (inputMenu == 2) {
                System.out.println("Berikut data Anda:");
            }
        } while(inputMenu != 3); */
    }

