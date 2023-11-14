import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void menu(){
        System.out.println("--------------CHƯƠNG TRÌNH QUẢN LÝ SINH VIÊN-------------");
        System.out.println("1. Xem danh sách sinh viên");
        System.out.println("2. Thêm mới");
        System.out.println("3. Cập nhật");
        System.out.println("4. Xoá");
        System.out.println("5. Sắp xếp");
        System.out.println("6. Đọc từ file");
        System.out.println("7. Ghi vào file");
        System.out.println("8. Thoát");
        System.out.println("Chọn chức năng: ");
    }
    public static void main(String[] args) throws IOException {
        StudentService studentService = new StudentService();
        Scanner scanner = new Scanner(System.in);
        int choose = -1;
        do{
            menu();
            try{
                choose = scanner.nextInt();
                switch (choose){
                    case 1:
                        studentService.showStudent();
                        break;
                    case 2:
                        studentService.addStudent();
                        break;
                    case 3:
                        studentService.editStudent();
                        break;
                    case 4:
                        studentService.deleteStudent();
                        break;
                    case 5:
                        studentService.sortStudent();
                        break;
                    case 6:
                        studentService.readFile();
                        break;
                    case 7:
                        studentService.printToFile(scanner);
                        break;
                    case 8:
                        break;
                }
            }catch (InputMismatchException e) {
                System.out.println("Nhập sai dữ liệu, vui lòng nhập lại");
            }
        }while (choose != 8);

    }
}