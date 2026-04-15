public class LaporanMahasiswa14 {

    Mahasiswa_14 mahasiswa;
    int totalPinjam;
    int totalDenda;
    int totalTerlambat;

    LaporanMahasiswa14(Mahasiswa_14 mahasiswa){
        this.mahasiswa = mahasiswa;
    }

    void hitungLaporan(Peminjiman_14[] pinjam){
        totalPinjam = 0;
        totalDenda = 0;
        totalTerlambat = 0;

        for(int i=0; i<pinjam.length; i++){
            if(pinjam[i] != null && pinjam[i].mhs.nim.equals(mahasiswa.nim)){
                totalPinjam++;
                totalDenda += pinjam[i].denda;

                if(pinjam[i].terlambat > 0){
                    totalTerlambat++;
                }
            }
        }
    }

    void tampilLaporan(){
        System.out.print("NIM: " + mahasiswa.nim + " | ");
        System.out.print("Nama: " + mahasiswa.nama + " | ");
        System.out.print("Total Pinjam: " + totalPinjam + " | ");
        System.out.print("Total Denda: Rp " + totalDenda + " | ");
        System.out.println("Terlambat: " + totalTerlambat + "x");
    }
}