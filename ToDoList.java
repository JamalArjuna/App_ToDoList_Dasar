import java.util.Scanner;

public class ToDoList {
    private static String[] Activity = new String[10];
    private static Scanner InputUser = new Scanner(System.in);

    public static void main(String[] args) {
        viewShowToDo();

        //testViewEditToDo();
    }

    // Menampilkan ToDo list
    private static void showToDoList(){
        System.out.println("TO DO LIST HARI INI");
        for (var i = 0; i < Activity.length; i++){
            var Todo = Activity[i];
            var no = i + 1;
            if (Todo != null){
                System.out.println(no + ". " + Todo);
            }
        }
    }

    // Menambahkan Todo List
    private static void addToDo(String todo){
        // Pengecekan apakah model
        var isFull = true;
        var temp = Activity;
        for (int i = 0; i < Activity.length; i++) {
            if (Activity[i] == null) {
                // model masih ada yang kosong
                isFull = false;
                break;
            }
        }

        // jika penuh, kita resize ukuran array 2x lipat
        if (isFull) {
            Activity = new String[Activity.length * 2];

        }
        for (int i = 0; i < temp.length; i++) {
            Activity[i] = temp[i];
        }

        // tambahkan ke posisi yang data array nya NULL
        for (var i = 0; i < Activity.length; i++) {
            if (Activity[i] == null) {
                Activity[i] = todo;
                break;
            }
        }
    }

    private static void testToDoList(){
       addToDo("Makan");
       addToDo("Makan");
       addToDo("Makan");
       addToDo("Makan");
       addToDo("Makan");
       addToDo("Makan");
       addToDo("Makan");
       addToDo("Makan");
       addToDo("Makan");
       addToDo("Makan");
        showToDoList();
    }

    // Menghapus Todo list
    private static Boolean deleteToDo(Integer Angka) {
        if ((Angka - 1) >= Activity.length) {
            // Pengecekan apakah input melebihi batas array
            return false;
        } else if (Activity[Angka - 1] == null) {
            // Pengecekan apakah input yang dimasukkan null, maka tidak terjadi apa apa
            return false;
        } else {
            for (int i = (Angka - 1); i < Activity.length; i++) {
                if (i == (Activity.length - 1)) {
                    // Pengecekan apakah Array mendekati akhir agar tidak menjadi out of bounds
                    Activity[i] = null;
                } else {
                    // Menggeser Urutan agar tidak terjadi loncatan data
                    Activity[i] = Activity[i + 1];
                }
            }
        }
        return true;
    }

    private static void testRemoveToDo(){

        addToDo("todo satu");
        addToDo("todo dua");
        addToDo("todo tiga");
        addToDo("todo empat");
        addToDo("todo lima");
        addToDo("todo enam");
        addToDo("todo tujuh");
        addToDo("todo delapan");
        addToDo("todo sembilan");

        var hasil = deleteToDo(20);
        System.out.println(hasil);

        hasil = deleteToDo(6);
        System.out.println(hasil);

        hasil = deleteToDo(5);
        System.out.println(hasil);

        showToDoList();

    }
    // Input To Do List
    private static String input(){
        System.out.print("Input : ");
        String dataInput = InputUser.nextLine();
        return dataInput;
    }

    private static void testInput(){
        System.out.println("To Do LIst yang dimasukkan adalah: " + input());
    }
    // UI Show Todo list
    private static void viewShowToDo(){
        while (true){
            showToDoList();
            System.out.println("MENU: ");

            System.out.println("1. Tambah To Do List");
            System.out.println("2. Hapus To Do List");
            System.out.println("3. Edit To Do List");
            System.out.println("4. Berhenti");

            if (input().equals("1")){
                viewAddToDo();
            } else if (input().equals("2")) {
                viewDeleteToDo();
            } else if (input().equals("3")) {
                viewEditToDo();
            } else if (input().equals("4")) {
                break;
            } else {
                System.out.println("Input yang Kamu masukkan salah!!!");
            }
        }
    }

    private static void testViewShowToDo(){
        addToDo("Makan");
        addToDo("Mandi");
        addToDo("Belajar Programming");
        addToDo("Kuliah");

        viewShowToDo();
    }

    // UI Add Todo list
    private static void viewAddToDo(){
        System.out.println("TAMBAHKAN TO DO LIST");

        System.out.print("Masukkan To Do list(Tekan x jika batal) : ");
        var addToDo = InputUser.nextLine();

        if (addToDo.equals("x")){
            // kembali
        } else {
            addToDo(addToDo);
        }
    }

    private static void testViewAddToDo(){
        addToDo("Makan");
        addToDo("Tidur");
        addToDo("Belanja");
        addToDo("Kerja");
        addToDo("Belajar");
        viewAddToDo();

        showToDoList();
    }
    // UI Delete Todo list
    private static void viewDeleteToDo(){
        System.out.println("HAPUS TO DO LIST");

        System.out.print("Masukkan To Do list Yang Mau Dihapus (Tekan 0 jika batal) : ");
        int deleteToDo = InputUser.nextInt();

        if (deleteToDo == 0){

        } else {
            deleteToDo(deleteToDo);
        }
    }

    private static void testViewDeleteToDO(){
        addToDo("Makan");
        addToDo("Tidur");
        addToDo("Belajar");
        addToDo("Belanja");

        showToDoList();

        viewDeleteToDo();

        showToDoList();
    }


    private static void viewEditToDo(){
        System.out.println("EDIT TO DO LIST");

        System.out.print("Masukkan To Do List (Tekan 0 jika batal) : ");
        String editToDo = InputUser.nextLine();
        System.out.print("Masukkan Nomor To Do Yang Mau diganti (Tekan 0 jika batal) : ");
        int editNumberToDo = InputUser.nextInt();

        if (editToDo  == "0" || editNumberToDo == 0){

        } else {
            EditToDo(editNumberToDo, editToDo);
        }
    }

    private static Boolean EditToDo(Integer Angka, String todo){
        System.out.println("EDIT TO DO LIST");

        if ((Angka - 1) >= Activity.length){
            return false;
        } else if (Activity[Angka - 1] == null) {
            return false;
        }else {
            Activity[Angka - 1] = todo;;
        }
        return true;
    }

    private static void testViewEditToDo(){
        addToDo("Makan");
        addToDo("Tidur");
        addToDo("Mandi");
        addToDo("Kelas");

        showToDoList();
        viewEditToDo();
        showToDoList();
    }
}
