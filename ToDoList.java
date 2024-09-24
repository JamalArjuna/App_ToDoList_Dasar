import java.util.Scanner;

public class ToDoList {
    private static String[] Activity = new String[10];
    private static Scanner InputUser = new Scanner(System.in);

    public static void main(String[] args) {
        testRemoveToDo();
    }

    // Menampilkan ToDo list
    private static void showToDoList(){
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
    // UI Show Todo list
    private static void viewShowToDo(){

    }
    // UI Add Todo list
    private static void viewAddToDo(){

    }
    // UI Delete Todo list
    private static void viewDeleteToDo(){

    }
}
