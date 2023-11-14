import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class StudentService {
    private List<Student> students = new ArrayList<>();
    public void addStudent() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Nhập thông tin sinh viên: ");

        System.out.println("Mã sinh viên: ");
        int id = InputCheck.Number();

        System.out.println("Tên sinh viên: ");
        String name = InputCheck.Name();

        System.out.println("Tuổi: ");
        int age = InputCheck.age();

        System.out.println("Giới tính: ");
        String sex = scan.nextLine();

        System.out.println("Địa chỉ: ");
        String address = scan.nextLine();

        System.out.println("Điểm trunh bình: ");
        double midscore = scan.nextDouble();

        Student student = new Student(id, name, age, sex, address, midscore);
        this.students.add(student);
        System.out.println("Thêm thành công!");
    }
    public void showStudent(){
        for (Student s : this.students) {
            System.out.println(s.toString());
        }
    }
    public void editStudent(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập id cần sửa: ");
        int id = Integer.parseInt(scanner.nextLine());
        boolean check = false;
        for (Student s : this.students) {
            if (id == s.getId()) {
                System.out.println("Mã sinh viên: ");
                int idSv = InputCheck.Number();
                System.out.println("Họ tên: ");
                String name = InputCheck.Name();
                System.out.println("Tuổi: ");
                int age = InputCheck.age();
                System.out.println("Giới tính: ");
                String sex = scanner.nextLine();

                System.out.println("Địa chỉ: ");
                String address = scanner.nextLine();
                System.out.println("Điểm trung bình: ");
                double midscore = scanner.nextDouble();
                s.setId(idSv);
                s.setName(name);
                s.setAge(age);
                s.setSex(sex);
                s.setAddress(address);
                s.setMidscore(midscore);
                System.out.println("Sửa thành công!");
                check = true;
            }else {

            }
        }
        if (!check){
            System.out.println("Không tìm thấy mã sv, vui lòng nhập lại!");
        }
    }

    public void deleteStudent() {
        boolean check = false;
        Scanner scanner = new Scanner(System.in);
        do{
            System.out.println("Nhập id muốn xoá");
            int id = Integer.parseInt(scanner.nextLine());
            for (Student s : this.students) {
                if (id == s.getId()) {
                    this.students.remove(s);
                    System.out.println("Xoá thành công!");
                    check = true;
                    break;
                }
            }
            if (!check) {
                System.out.println("Không tìm thấy mã sv, vui lòng nhập lại!");
            }
        }while (!check);

    }
    public void sortStudent() {
        System.out.println("Chọn chức năng theo số (để tiếp tục)");
        System.out.println("1. Sắp xếp điểm trung bình tăng dần");
        System.out.println("2. Sắp xếp điểm trung bình giảm dần");
        int choose = -1;
        do {
            choose = InputCheck.Number();
            switch (choose) {
                case 1:
                    this.sortIncrease();
                    break;
                case 2:
                    this.sortDecrease();
                    break;
            }
        }while (choose != 3);
    }
    public void sortIncrease () {
        Collections.sort(this.students);
        this.showStudent();
    }
    public void sortDecrease() {
        Collections.sort(this.students);
        Collections.reverse(this.students);
        this.showStudent();
    }
    public void readFile (){

        try{
            BufferedReader br = new BufferedReader(new FileReader("src/data.csv"));
            String line = br.readLine();
            while (line != null){
                String[] value = line.split(",");
                int id = Integer.parseInt(value[0]);
                String name = value[1];
                int age = Integer.parseInt(value[2]);
                String sex = value[3];
                String address = value[4];
                Double midcore = Double.parseDouble(value[5]);

                this.students.add(new Student(id, name, age, sex, address, midcore));
                line = br.readLine();
            }
            br.close();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Đọc file thành công");
    }

    public void printToFile(Scanner scanner) throws IOException {
        System.out.println("Nhập đường link file:");
        String path = scanner.nextLine();
        ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(Paths.get(path)));
        oos.writeObject(this.students);
        oos.close();
    }
}
