import java.util.Scanner;

public class CM1Main_14 {

    // ================= DATA MAHASISWA =================
    static MahasiswaData_14 dataMahasiswa(){
        MahasiswaData_14 data = new MahasiswaData_14();

        data.tambah(new Mahasiswa_14("22001","Andi","TI"));
        data.tambah(new Mahasiswa_14("22002","Budi","TI"));
        data.tambah(new Mahasiswa_14("22003","Citra","SIB"));

        return data;
    }

    // ================= DATA BUKU =================
    static bukuData14 dataBuku(){
        bukuData14 data = new bukuData14();

        data.tambah(new Buku_14("B001","Algoritma",2020));
        data.tambah(new Buku_14("B002","Basis Data",2019));
        data.tambah(new Buku_14("B003","Pemrograman",2021));
        data.tambah(new Buku_14("B004","Fisika",2024));

        return data;
    }

    // ================= MAIN =================
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        MahasiswaData_14 mhs = dataMahasiswa();
        bukuData14 buku = dataBuku();
        PeminjamanData_14 pinjam = new PeminjamanData_14(mhs, buku);

        int pilih;

        do{
            System.out.println("\n=== SISTEM PEMINJAMAN RUANG BACA ===");
            System.out.println("1. Tampilkan Mahasiswa");
            System.out.println("2. Tampilkan Buku");
            System.out.println("3. Tampilkan Peminjaman");
            System.out.println("4. Urutkan Berdasarkan Denda");
            System.out.println("5. Cari Berdasarkan NIM");
            System.out.println("6. Tambah Peminjaman");
            System.out.println("7. Statistik");
            System.out.println("8. Laporan Per Mahasiswa");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");
            pilih = sc.nextInt();

            switch(pilih){

                case 1:
                    System.out.println("\n=== DATA MAHASISWA ===");
                    mhs.tampil();
                    break;

                case 2:
                    System.out.println("\n=== DATA BUKU ===");
                    buku.tampilBuku();
                    break;

                case 3:
                    System.out.println("\n=== DATA PEMINJAMAN ===");
                    pinjam.tampil();
                    break;

                case 4:
                    System.out.println("\n=== SORTING DENDA TERBESAR MENGGUNAKAN INSERTION SORT (DSC) ===");
                    pinjam.insertionSort();
                    pinjam.tampil();
                    break;

                case 5:
                    System.out.print("Masukkan NIM yang dicari: ");
                    String cari = sc.next();
                    System.out.println("BINNARY SEARCH DATA DITEMUKAN: ");

                    pinjam.sortByNIM(); // wajib sebelum binary search
                    int posisi = pinjam.findBinarySearch(cari, 0, pinjam.listPeminjaman.length - 1);

                    if(posisi != -1){
                        System.out.println("Data ditemukan:");
                        pinjam.listPeminjaman[posisi].tampilPeminjaman();
                    } else {
                        System.out.println("Data tidak ditemukan");
                    }
                    break;

                case 6:
                    System.out.println("\n=== TAMBAH PEMINJAMAN ===");
                    pinjam.tambah(sc);
                    break;

                case 7:
                    System.out.println();
                    pinjam.tampilStatistik();
                    break;

                case 8:
                    System.out.println("\n=== LAPORAN PER MAHASISWA ===");

                    LaporanMahasiswa14[] laporan = new LaporanMahasiswa14[mhs.listMhs.length];

                    for(int i=0; i<mhs.listMhs.length; i++){
                        if(mhs.listMhs[i] != null){
                        laporan[i] = new LaporanMahasiswa14(mhs.listMhs[i]);

                        laporan[i].hitungLaporan(pinjam.listPeminjaman);

                        laporan[i].tampilLaporan();
                        }
                    }
                    break;

                case 0:
                    System.out.println("Program selesai...");
                    break;

                default:
                    System.out.println("Menu tidak tersedia!");
            }

        } while(pilih != 0);

        sc.close();
    }
}