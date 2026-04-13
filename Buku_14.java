public class Buku_14 {

    public String kodeBuku;
    public String judul;
    public int tahunTerbit;

    Buku_14(String kode, String judul, int tahun){
        kodeBuku = kode;
        this.judul = judul;
        tahunTerbit = tahun;
    }
    void tampilBuku(){
        System.out.print("Kode\t: "+kodeBuku+"\t|\t");
        System.out.print("Judul\t: "+judul+"\t|\t");
        System.out.print("Tahun\t: "+tahunTerbit);
        System.out.println("");
    }
}