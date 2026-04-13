public class bukuData14 {

    Buku_14 listBuku [] = new Buku_14[4];
    int idx;

    bukuData14(){
        listBuku = new Buku_14[4];
    }
    //================= INPUT MAHASISWA ===========
    void tambah(Buku_14 m){
        if (idx < listBuku.length) {
            listBuku[idx] =m;
            idx++;
        }else{
            System.out.println("Data Sudah Penuh");
        }
    }
    
    void tampilBuku(){
        for(int i = 0; i<listBuku.length; i++){
            if (listBuku[i] != null) {
                listBuku[i].tampilBuku();
            }
        }
    }
}