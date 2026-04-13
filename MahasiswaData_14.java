public class MahasiswaData_14 {

    Mahasiswa_14 listMhs [] = new Mahasiswa_14[3];
    int idx;

    MahasiswaData_14(){
        listMhs = new Mahasiswa_14[3];
    }
    //================= INPUT MAHASISWA ===========
    void tambah(Mahasiswa_14 m){
        if (idx < listMhs.length) {
            listMhs[idx] =m;
            idx++;
        }else{
            System.out.println("Data Sudah Penuh");
        }
    }
    
    void tampil(){
        for(int i = 0; i<listMhs.length; i++){
            if (listMhs[i] != null) {
                listMhs[i].tampilMahasiswa();
            }
        }
    }
}