public class Mahasiswa_14 {

    public String nim;
    public String nama;
    public String prodi;

    Mahasiswa_14(String nim, String nama, String prodi){
        this.nim = nim;
        this.nama = nama;
        this.prodi = prodi;
    }

    void tampilMahasiswa(){
        System.out.print("Nama\t: "+nama+"\t|\t");
        System.out.print("NIM\t: "+nim+"\t|\t");
        System.out.print("Prodi\t: "+prodi);
        System.out.println("");
    }
}