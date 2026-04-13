public class PeminjamanData_14 {

    Peminjiman_14 listPeminjaman [] = new Peminjiman_14[5];
    int idx;
    Mahasiswa_14 listMahasiswa [] = new Mahasiswa_14[3];

    PeminjamanData_14(){
        listPeminjaman = new Peminjiman_14[5];
    }
    
    void tambah(Peminjiman_14 m){
        if (idx < listPeminjaman.length) {
            listPeminjaman[idx] =m;
            idx++;
        }else{
            System.out.println("Data Sudah Penuh");
        }
    }
    
    void tampil(){
        
        for(int i = 0; i<listPeminjaman.length; i++){
            if (listPeminjaman[i] != null) {
                listPeminjaman[i].tampilPeminjaman();
            }
        }
    }
    void insertionSort(){
        for(int i=1; i<listPeminjaman.length; i++){
            if (listPeminjaman[i] == null) continue; 
                
            Peminjiman_14 temp = listPeminjaman[i];
            int j =i;

            while (j>0 && listPeminjaman[j-1] != null && listPeminjaman[j-1].denda < temp.denda) {
                
                listPeminjaman[j] = listPeminjaman [j-1];
                j--;
            }
            listPeminjaman[j] = temp;
        }
    }
    int findBinarySearch(String cari, int left, int right){
    if (right >= left) {
        int mid = (left + right) / 2;

        if (listPeminjaman[mid].mhs.nim.equals(cari)) {
            return mid;
        } 
        else if (listPeminjaman[mid].mhs.nim.compareTo(cari) > 0) {
            return findBinarySearch(cari, left, mid - 1);
        } 
        else {
            return findBinarySearch(cari, mid + 1, right);
        }
    }
    return -1;
}

    int cariNIM(String nim){
    for(int i = 0; i < listPeminjaman.length; i++){
        if(listPeminjaman[i] != null){
            if(listPeminjaman[i].mhs.nim.equals(nim)){
                return i;
            }
        }
    }
    return -1;
}
}