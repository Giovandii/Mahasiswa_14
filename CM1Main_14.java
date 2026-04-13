import java.util.Scanner;
public class CM1Main_14 {

    static MahasiswaData_14 dataMahasiswa(){
        MahasiswaData_14 data = new MahasiswaData_14();

        data.tambah(new Mahasiswa_14("22001", "Andi", "Teknik Informatika"));
        data.tambah(new Mahasiswa_14("22002", "Budi", "Teknik Informatika"));
        data.tambah(new Mahasiswa_14("22003", "Citra", "Sistem Informasi Bisnis"));

        return data;
    }

    static bukuData14 dataBuku(){
        bukuData14 dataBuku = new bukuData14();

        dataBuku.tambah(new Buku_14("B001", "Algoritma", 2020));
        dataBuku.tambah(new Buku_14("B002", "Basis Data", 2019));
        dataBuku.tambah(new Buku_14("B003", "Pemrograman", 2021));
        dataBuku.tambah(new Buku_14("B004", "Fisika", 2024));

        return dataBuku;
    }

    static PeminjamanData_14 dataPeminjaman(MahasiswaData_14 mhs, bukuData14 buku){
        PeminjamanData_14 dataPeminjaman = new PeminjamanData_14();

        Peminjiman_14 p1 = new Peminjiman_14(mhs.listMhs[0], buku.listBuku[0], 7);
        Peminjiman_14 p2 = new Peminjiman_14(mhs.listMhs[1], buku.listBuku[1], 3);
        Peminjiman_14 p3 = new Peminjiman_14(mhs.listMhs[2], buku.listBuku[2], 10);
        Peminjiman_14 p4 = new Peminjiman_14(mhs.listMhs[2], buku.listBuku[3], 6);
        Peminjiman_14 p5 = new Peminjiman_14(mhs.listMhs[0], buku.listBuku[1], 4);

        p1.hitungDenda();
        p2.hitungDenda();
        p3.hitungDenda();
        p4.hitungDenda();
        p5.hitungDenda();

        dataPeminjaman.tambah(p1);
        dataPeminjaman.tambah(p2);
        dataPeminjaman.tambah(p3);
        dataPeminjaman.tambah(p4);
        dataPeminjaman.tambah(p5);

        return dataPeminjaman;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pilihan;
        MahasiswaData_14 data = dataMahasiswa();
        bukuData14 dataBuku = dataBuku();
        PeminjamanData_14 dataPinjaman = dataPeminjaman(data, dataBuku);
        
        do {
            
            System.out.println("=== SISTEM PEMINJAMAN RUANG BACA JTI ===");
            System.out.println("1. Tampilkan Mahasiswa");
            System.out.println("2. Tampilkan Buku");
            System.out.println("3. Tampilkan Peminjaman");
            System.out.println("4. Urutkan Berdasarkan Denda");
            System.out.println("5. Cari Berdasarkan NIM");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");
            pilihan = sc.nextInt();

            switch (pilihan) {
                case 1:
                    System.out.println("Daftar Mahasiswa: ");
                    data.tampil();
                    break;
                case 2:
                    System.out.println("Daftar Buku: ");
                    dataBuku.tampilBuku();
                    break;
                case 3:
                    System.out.println("Data Peminjaman: ");
                    dataPinjaman.tampil();
                    break;
                case 4:
                    System.out.println("Setelah diurutkan Denda terbesar: ");
                    dataPinjaman.insertionSort();
                    dataPinjaman.tampil();
                    break;
                case 5:
                    System.out.print("MASUKAN NIM: ");
                    String cari = sc.next();

    // 🔥 WAJIB sorting dulu
                    dataPinjaman.cariNIM(cari);

                    int posisi = dataPinjaman.findBinarySearch(cari, 0, dataPinjaman.idx - 1);

                    if (posisi != -1) {
                        dataPinjaman.listPeminjaman[posisi].tampilPeminjaman();
                    } else {
                        System.out.println("Data tidak ditemukan");
                    }
                    break;
                case 0:
                    System.out.println("Program Selesai");
                    break;

                default :
                System.out.println("Pilihan tidak tersedia");
                break;
            }

        } while (pilihan !=0);        
    }
}