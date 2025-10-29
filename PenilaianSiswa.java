import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.io.*;
import java.nio.file.*;

// Class untuk menyimpan data dan logika penilaian setiap siswa
class Siswa {
    private int idSiswa;
    private String nama;
    private int ddp;
    private int matdis;
    private int eldas;
    private int litdig;
    private int pkwn;
    
    // Konstanta untuk konfigurasi nilai
    // Passing grades (asumsi default)
    private static final int PASS_DDP = 70;
    private static final int PASS_MATDIS = 75;
    private static final int PASS_ELDAS = 70;
    private static final int PASS_LITDIG = 65;
    private static final int PASS_PKWN = 60;
    
    private static final int SKOR_MIN = 30; // Skor min global terendah
    private static final int SKOR_MAX = 100;
    
    // Constructor untuk membuat data siswa secara acak
    public Siswa(int id) {
        Random rand = new Random();
        this.idSiswa = id;
        this.nama = "Siswa_" + String.format("%02d", id);
        
        // Generate nilai acak untuk 5 matakuliah
        this.ddp = rand.nextInt(SKOR_MAX - SKOR_MIN + 1) + SKOR_MIN; 
        this.matdis = rand.nextInt(SKOR_MAX - 50 + 1) + 50; // Min 50
        this.eldas = rand.nextInt(SKOR_MAX - 45 + 1) + 45; // Min 45
        this.litdig = rand.nextInt(SKOR_MAX - SKOR_MIN + 1) + SKOR_MIN; // Min 30
        this.pkwn = rand.nextInt(SKOR_MAX - SKOR_MIN + 1) + SKOR_MIN; // Min 30
    }

    // Konstruktor untuk membuat data siswa dari input pengguna
    public Siswa(int id, String nama, int ddp, int matdis, int eldas, int litdig, int pkwn) {
        this.idSiswa = id;
        this.nama = nama;
        this.ddp = ddp;
        this.matdis = matdis;
        this.eldas = eldas;
        this.litdig = litdig;
        this.pkwn = pkwn;
    }
    
    // Metode untuk menghitung rata-rata
    public double hitungRataRata() {
        return (double) (ddp + matdis + eldas + litdig + pkwn) / 5;
    }
    
    // Metode untuk mendapatkan status kelulusan (LULUS/TIDAK LULUS)
    public String getStatus() {
        if (ddp >= PASS_DDP && 
            matdis >= PASS_MATDIS && 
            eldas >= PASS_ELDAS && 
            litdig >= PASS_LITDIG && 
            pkwn >= PASS_PKWN) {
            return "LULUS";
        } else {
            return "TIDAK LULUS";
        }
    }
    
    // Metode untuk menampilkan detail penilaian siswa
    public void cetakDataSiswa() {
        System.out.println("------------------------------------------------------------------");
        System.out.println("ID: " + idSiswa + " | Nama: " + nama);
        System.out.println("------------------------------------------------------------------");
        
        // Penilaian per mata pelajaran
        System.out.printf("  DDP: %d (Passing Grade: %d) -> %s\n", 
            ddp, PASS_DDP, (ddp >= PASS_DDP ? "Lulus" : "Gagal"));
        System.out.printf("  Matdis: %d (Passing Grade: %d) -> %s\n", 
            matdis, PASS_MATDIS, (matdis >= PASS_MATDIS ? "Lulus" : "Gagal"));
        System.out.printf("  Eldas: %d (Passing Grade: %d) -> %s\n", 
            eldas, PASS_ELDAS, (eldas >= PASS_ELDAS ? "Lulus" : "Gagal"));
        System.out.printf("  Litdig: %d (Passing Grade: %d) -> %s\n", 
            litdig, PASS_LITDIG, (litdig >= PASS_LITDIG ? "Lulus" : "Gagal"));
        System.out.printf("  PKWN: %d (Passing Grade: %d) -> %s\n", 
            pkwn, PASS_PKWN, (pkwn >= PASS_PKWN ? "Lulus" : "Gagal"));
            
        // Hasil akhir
        System.out.printf("  Rata-rata Nilai: %.2f | Status Akhir: %s\n", 
            hitungRataRata(), getStatus());
        System.out.println("------------------------------------------------------------------");
    }

    // Serialisasi ke CSV (id;nama;ddp;matdis;eldas;litdig;pkwn)
    public String toCSV() {
        // Escape semicolon in name if any by replacing with comma
        String safeName = nama.replace(";", ",");
        return String.format("%d;%s;%d;%d;%d;%d;%d", idSiswa, safeName, ddp, matdis, eldas, litdig, pkwn);
    }

    // Parse dari baris CSV, format: id;nama;ddp;matdis;eldas;litdig;pkwn
    public static Siswa fromCSV(String line) {
        if (line == null) return null;
        String[] parts = line.split(";", -1);
        if (parts.length < 7) throw new IllegalArgumentException("Format CSV tidak valid: " + line);
        try {
            int id = Integer.parseInt(parts[0].trim());
            String nama = parts[1].trim();
            int ddp = Integer.parseInt(parts[2].trim());
            int matdis = Integer.parseInt(parts[3].trim());
            int eldas = Integer.parseInt(parts[4].trim());
            int litdig = Integer.parseInt(parts[5].trim());
            int pkwn = Integer.parseInt(parts[6].trim());
            return new Siswa(id, nama, ddp, matdis, eldas, litdig, pkwn);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Nilai angka tidak valid di baris CSV: " + line, e);
        }
    }
}
//
// Class utama untuk menjalankan program
class PenilaianSiswa {
    
    private static int readIntInRange(Scanner sc, String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            String line = sc.nextLine();
            try {
                int val = Integer.parseInt(line.trim());
                if (val < min || val > max) {
                    System.out.println("Nilai harus antara " + min + " dan " + max + ". Coba lagi.");
                    continue;
                }
                return val;
            } catch (NumberFormatException e) {
                System.out.println("Input harus bilangan bulat. Coba lagi.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=================================================");
        System.out.println("  PENILAIAN INPUT DATA MAHASISWA 1A");
        System.out.println("=================================================");

        System.out.println("Pilih mode input:");
        System.out.println(" 1) Random (nilai di-generate otomatis)");
        System.out.println(" 2) Manual (masukkan nama dan nilai tiap siswa)");
        int mode = readIntInRange(sc, "Masukkan pilihan (1 atau 2): ", 1, 2);

        List<Siswa> basisDataSiswa = new ArrayList<>();

        if (mode == 1) {
            int jumlah = readIntInRange(sc, "Masukkan jumlah siswa (1-100): ", 1, 100);
            for (int i = 1; i <= jumlah; i++) {
                Siswa s = new Siswa(i);
                basisDataSiswa.add(s);
            }
        } else {
            int jumlah = readIntInRange(sc, "Masukkan jumlah siswa (1-100): ", 1, 100);
            for (int i = 1; i <= jumlah; i++) {
                System.out.println("--- Data siswa ke-" + i + " ---");
                System.out.print("Nama: ");
                String nama = sc.nextLine().trim();
                if (nama.isEmpty()) {
                    nama = "Siswa_" + String.format("%02d", i);
                }
                int ddp = readIntInRange(sc, "DDP (0-100): ", 0, 100);
                int matdis = readIntInRange(sc, "Matdis (0-100): ", 0, 100);
                int eldas = readIntInRange(sc, "Eldas (0-100): ", 0, 100);
                int litdig = readIntInRange(sc, "Litdig (0-100): ", 0, 100);
                int pkwn = readIntInRange(sc, "PKWN (0-100): ", 0, 100);

                Siswa s = new Siswa(i, nama, ddp, matdis, eldas, litdig, pkwn);
                basisDataSiswa.add(s);
            }
        }

        // TAMPILAN BASIS DATA DAN PENILAIAN
        for (Siswa s : basisDataSiswa) {
            s.cetakDataSiswa();
        }

        // Tawarkan menyimpan ke file
        System.out.print("Simpan data ke file CSV? (y/n): ");
        String saveAns = sc.nextLine().trim().toLowerCase();
        if (saveAns.equals("y") || saveAns.equals("yes")) {
            System.out.print("Masukkan nama file (default: data_siswa.csv): ");
            String filename = sc.nextLine().trim();
            if (filename.isEmpty()) filename = "data_siswa.csv";
            try {
                saveToCSV(basisDataSiswa, filename);
                System.out.println("Data tersimpan di " + filename);
            } catch (IOException e) {
                System.out.println("Gagal menyimpan file: " + e.getMessage());
            }
        }

        sc.close();
    }

    // Simpan daftar siswa ke file CSV
    private static void saveToCSV(List<Siswa> list, String path) throws IOException {
        try (PrintWriter pw = new PrintWriter(new FileWriter(path))) {
            // header optional (sesuaikan dengan matakuliah)
            pw.println("id;nama;ddp;matdis;eldas;litdig;pkwn");
            for (Siswa s : list) {
                pw.println(s.toCSV());
            }
        }
    }

    // Muat daftar siswa dari file CSV
    private static List<Siswa> loadFromCSV(String path) throws IOException {
        List<Siswa> out = new ArrayList<>();
        List<String> lines = Files.readAllLines(Paths.get(path));
        for (String line : lines) {
            if (line.trim().isEmpty()) continue;
            if (line.toLowerCase().startsWith("id;") || line.startsWith("#")) continue; // skip header/comment
            out.add(Siswa.fromCSV(line));
        }
        return out;
    }
}