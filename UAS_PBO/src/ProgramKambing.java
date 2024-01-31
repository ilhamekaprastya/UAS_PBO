// Class untuk merepresentasikan setiap kambing
class Kambing {
    private String nama;
    private double berat;
    private double tinggi;
    private double panjang;
    private boolean hidup; // Menandakan apakah kambing masih hidup atau sudah terjual/mati

    // Constructor untuk inisialisasi saat pembuatan objek
    public Kambing(String nama, double berat, double tinggi, double panjang) {
        this.nama = nama;
        this.berat = berat;
        this.tinggi = tinggi;
        this.panjang = panjang;
        this.hidup = true; // Awalnya kambing masih hidup
    }

    // Metode untuk merepresentasikan pertumbuhan kambing setiap bulan
    public void tumbuh(double tambahBerat, double tambahTinggi, double tambahPanjang) {
        this.berat += tambahBerat;
        this.tinggi += tambahTinggi;
        this.panjang += tambahPanjang;
    }

    // Metode untuk mencatat kambing yang terjual atau mati
    public void jualAtauMati() {
        this.hidup = false;
        System.out.println("Kambing " + this.nama + " telah mati atau dijual.");
    }

    // Metode untuk menampilkan informasi kambing
    public void tampilkanInfo() {
        System.out.println("===== Informasi Kambing =====");
        System.out.println("Nama: " + this.nama);
        System.out.println("Berat: " + this.berat + " kg");
        System.out.println("Tinggi: " + this.tinggi + " cm");
        System.out.println("Panjang: " + this.panjang + " cm");
        System.out.println("Status: " + (this.hidup ? "Hidup" : "Mati"));
        System.out.println("==============================");
    }
}

// Class untuk merepresentasikan kandang kambing
class Kandang {
    private String pemilik;
    private Kambing[] kambingArray;

    // Constructor untuk inisialisasi saat pembuatan objek
    public Kandang(String pemilik, int jumlahKambing) {
        this.pemilik = pemilik;
        this.kambingArray = new Kambing[jumlahKambing];
    }

    // Metode untuk menambahkan kambing ke kandang
    public void tambahKambing(Kambing kambing, int index) {
        this.kambingArray[index] = kambing;
    }

    // Metode untuk menampilkan informasi semua kambing di kandang
    public void tampilkanKandang() {
        System.out.println("===== Informasi Kandang =====");
        System.out.println("Pemilik: " + this.pemilik);
        for (Kambing kambing : this.kambingArray) {
            if (kambing != null) {
                kambing.tampilkanInfo();
                System.out.println();
            }
        }
        System.out.println("==============================");
    }
}

// Class untuk program utama
public class ProgramKambing {
    public static void main(String[] args) {
        // Membuat objek kambing
        Kambing kambing1 = new Kambing("Kambing A", 20, 70, 90);
        Kambing kambing2 = new Kambing("Kambing B", 25, 75, 95);

        // Membuat objek kandang
        Kandang kandangPakSlamet = new Kandang("Pak Slamet", 2);

        // Menambahkan kambing ke kandang
        kandangPakSlamet.tambahKambing(kambing1, 0);
        kandangPakSlamet.tambahKambing(kambing2, 1);

        // Menampilkan informasi kandang dan kambing di dalamnya
        kandangPakSlamet.tampilkanKandang();

        // Mengupdate perkembangan kambing setiap bulan
        kambing1.tumbuh(2, 3, 4);
        kambing2.tumbuh(3, 4, 5);

        // Menampilkan informasi kandang dan kambing setelah pertumbuhan
        kandangPakSlamet.tampilkanKandang();

        // Menjual atau mencatat kambing yang mati
        kambing1.jualAtauMati();

        // Menampilkan informasi kandang dan kambing setelah dijual atau mati
        kandangPakSlamet.tampilkanKandang();
    }
}