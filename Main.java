import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        while (true) {
            try {
                BufferedReader br = new BufferedReader(new FileReader(new File("hasil.txt")));
                Scanner sc1 = new Scanner(br);
                LinkedList ll = new LinkedList();
                while (sc1.hasNextLine()) {
                    String[] data = sc1.nextLine().split(":");
                    ll.add(data[0], data[1]);
                }

                while (true) {
                    System.out.println("\n==============================================================");
                    System.out.println("\n\t+-------------------------------------------+");
                    System.out.println("\t| Program Pencarian Data dan Tampilkan data |");
                    System.out.println("\t+-------------------------------------------+");
                    System.out.println("\t|Pilihan :                                  |");
                    System.out.println("\t|1. Search Data                             |");
                    System.out.println("\t|2. Tampilkan Nama Editor                   |");
                    System.out.println("\t|3. Tampilkan Nama Editor dan jumlah artikel|");
                    System.out.println("\t|4. Exit                                    |");
                    System.out.println("\t+-------------------------------------------+");
                    System.out.print("\nMasukan Pilihan : ");
                    Scanner sc2 = new Scanner(System.in);
                    int pil = sc2.nextInt();

                    switch (pil) {
                        case 1:
                            System.out.print("Nama yang dicari (Case Sensitive) : ");
                            Scanner sc3 = new Scanner(System.in);
                            String nama = sc3.nextLine();
                            ll.result(nama);
                            break;

                        case 2:
                            ll.insertionSort();
                            ll.display(ll.getHead());
                            break;

                        case 3:
                            ll.insertionSort();
                            ll.display();
                            break;

                        case 4:
                            System.out.println("\n=== Terima Kasih! ===");
                            System.exit(0);

                        default:
                            System.out.println("\n[!] Pilihan yang dimasukan salah");
                            break;
                    }
                }

            } catch (FileNotFoundException e) {
                System.out.println("\nFile tidak ditemukan");
                System.exit(0);
            } catch (InputMismatchException e) {
                System.out.println("\n[!] Pilihan yang dimasukkan salah");
                continue;
            } catch (Exception e) {
                System.out.println("\nProgram Error");
                System.exit(0);
            }
        }
    }
}