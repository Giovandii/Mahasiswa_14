public class Peminjiman_14 {

    Mahasiswa_14 mhs;
    Buku_14 buku;
    int lamaPinjam;
    int batasPinjam =5;
    int terlambat;
    int denda;

    Peminjiman_14 (Mahasiswa_14 mhs, Buku_14 buku, int lamaPinjam){
        this.mhs = mhs;
        this.buku = buku;
        this.lamaPinjam = lamaPinjam;
    }

    void hitungDenda(){
        terlambat = lamaPinjam - batasPinjam;

        if (terlambat > 0) {
            denda = terlambat * 2000;
        }else{
            denda =0;
            terlambat =0;
        }
    }

    void tampilPeminjaman (){
        System.out.print(mhs.nama + "\t|");
        System.out.print(buku.judul +"\t|");
        System.out.print("Lama: " + lamaPinjam +"\t|");
        System.out.print("Terlambat: "+terlambat+"\t|");
        System.out.print("Denda: "+denda);
        System.out.println("");
    }
}