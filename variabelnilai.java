import java.util.Scanner;

public class variabelnilai { //HAESAM ABDULLAH 1A
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Input jumlah mata kuliah
        System.out.print("Masukkan jumlah mata kuliah: ");
        int jumlahMataKuliah = input.nextInt();

        // Deklarasi array untuk menyimpan nama dan nilai mata kuliah
        String[] namaMataKuliah = new String[jumlahMataKuliah];
        double[] nilaiMataKuliah = new double[jumlahMataKuliah];

        // Input nama dan nilai mata kuliah
        for (int i = 0; i < jumlahMataKuliah; i++) {
            System.out.print("Masukkan nama mata kuliah ke-" + (i + 1) + ": ");
            namaMataKuliah[i] = input.next();
            System.out.print("Masukkan nilai mata kuliah " + namaMataKuliah[i] + ": ");
            nilaiMataKuliah[i] = input.nextDouble();
        }
        // Hitung total nilai
        double totalNilai = 0;
        for (double nilai : nilaiMataKuliah) {
            totalNilai += nilai;
        }

        // Hitung rata-rata nilai
        double rataRata = totalNilai / jumlahMataKuliah;

        // Tampilkan hasil
        System.out.println("\nHasil:");
        for (int i = 0; i < jumlahMataKuliah; i++) {
            System.out.println("Mata Kuliah: " + namaMataKuliah[i] + ", Nilai: " + nilaiMataKuliah[i]);
        }
        System.out.println("Rata-rata nilai mata kuliah: " + rataRata);

        // Tentukan grade berdasarkan rata-rata nilai
        String grade;
        if (rataRata >= 90) {
            grade = "A";
        } else if (rataRata >= 80) {
            grade = "B";
        } else if (rataRata >= 70) {
            grade = "C";
        } else if (rataRata >= 60) {
            grade = "D";
        } else {
            grade = "E";
        }

        System.out.println("Grade: " + grade);
    }
}
