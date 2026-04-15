import java.util.Scanner;

public class PeminjamanData_14 {

    Peminjiman_14 listPeminjaman[] = new Peminjiman_14[0];
    int idx;

    MahasiswaData_14 dataMhs;
    bukuData14 dataBuku;

    // constructor
    PeminjamanData_14(MahasiswaData_14 mhs, bukuData14 buku){
        this.dataMhs = mhs;
        this.dataBuku = buku;
    }

    // ================= MENU 6 =================
    void tambah(Scanner sc){
        System.out.print("Masukkan NIM: ");
        String nim = sc.next();

        Mahasiswa_14 mhs = null;
        for(int i=0; i<dataMhs.listMhs.length; i++){
            if(dataMhs.listMhs[i] != null && dataMhs.listMhs[i].nim.equals(nim)){
                mhs = dataMhs.listMhs[i];
                break;
            }
        }

        if(mhs == null){
            System.out.println("NIM tidak ditemukan!");
            return;
        }

        System.out.print("Masukkan Kode Buku: ");
        String kode = sc.next();

        Buku_14 buku = null;
        for(int i=0; i<dataBuku.listBuku.length; i++){
            if(dataBuku.listBuku[i] != null && dataBuku.listBuku[i].kodeBuku.equals(kode)){
                buku = dataBuku.listBuku[i];
                break;
            }
        }

        if(buku == null){
            System.out.println("Kode buku tidak ditemukan!");
            return;
        }

        System.out.print("Masukkan Lama Pinjam: ");
        int lama = sc.nextInt();

        Peminjiman_14 pj = new Peminjiman_14(mhs, buku, lama);
        pj.hitungDenda();

        // ARRAY EXPANSION
        Peminjiman_14[] newArr = new Peminjiman_14[listPeminjaman.length + 1];

        for(int i=0; i<listPeminjaman.length; i++){
            newArr[i] = listPeminjaman[i];
        }

        newArr[listPeminjaman.length] = pj;
        listPeminjaman = newArr;

        idx++;

        System.out.println("Data peminjaman berhasil ditambahkan!");
    }

    // ================= MENU 7 =================
    void tampilStatistik(){
        int totalDenda = 0;
        int terlambat = 0;
        int tepatWaktu = 0;

        for(int i=0; i<listPeminjaman.length; i++){
            if(listPeminjaman[i] != null){
                totalDenda += listPeminjaman[i].denda;

                if(listPeminjaman[i].terlambat > 0){
                    terlambat++;
                } else {
                    tepatWaktu++;
                }
            }
        }

        System.out.println("=== STATISTIK PEMINJAMAN ===");
        System.out.println("Total Denda: Rp " + totalDenda);
        System.out.println("Jumlah Terlambat: " + terlambat);
        System.out.println("Jumlah Tepat Waktu: " + tepatWaktu);
    }

    void tampil(){
        for(int i=0; i<listPeminjaman.length; i++){
            if(listPeminjaman[i] != null){
                listPeminjaman[i].tampilPeminjaman();
            }
        }
    }

    // ================= MENU 4 =================
    void insertionSort(){
        for(int i=1; i<listPeminjaman.length; i++){
            if(listPeminjaman[i] == null) continue;

            Peminjiman_14 temp = listPeminjaman[i];
            int j = i;

            while(j > 0 && listPeminjaman[j-1] != null &&
                  listPeminjaman[j-1].denda < temp.denda){
                listPeminjaman[j] = listPeminjaman[j-1];
                j--;
            }
            listPeminjaman[j] = temp;
        }
    }

    // ================= SORT NIM =================
    void sortByNIM(){
        for(int i=0; i<listPeminjaman.length-1; i++){
            for(int j=0; j<listPeminjaman.length-i-1; j++){
                if(listPeminjaman[j] != null && listPeminjaman[j+1] != null){
                    if(listPeminjaman[j].mhs.nim.compareTo(listPeminjaman[j+1].mhs.nim) > 0){
                        Peminjiman_14 temp = listPeminjaman[j];
                        listPeminjaman[j] = listPeminjaman[j+1];
                        listPeminjaman[j+1] = temp;
                    }
                }
            }
        }
    }

    // ================= MENU 5 =================
    int findBinarySearch(String cari, int left, int right){
        if(right >= left){
            int mid = (left + right) / 2;

            if(listPeminjaman[mid].mhs.nim.equals(cari)){
                return mid;
            } else if(listPeminjaman[mid].mhs.nim.compareTo(cari) > 0){
                return findBinarySearch(cari, left, mid-1);
            } else {
                return findBinarySearch(cari, mid+1, right);
            }
        }
        return -1;
    }
}