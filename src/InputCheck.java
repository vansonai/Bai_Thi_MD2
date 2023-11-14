import java.util.Scanner;

public class InputCheck {
    public static int age(){
        while (true) {
            Scanner scanner = new Scanner(System.in);
            try{
                int age = scanner.nextInt();
                boolean isValid = Regex.checkAge(String.valueOf(age));
                if (isValid && age >= 18 && age <= 40){
                    return age;
                }else{
                    System.out.println("Độ tuổi không hợp lệ vui lòng nhập lại!");
                }
            }catch (Exception e){
                System.out.println("Vui lòng nhập lại!");
            }
        }
    }
    public static int Number(){
        while (true) {
            Scanner scan = new Scanner(System.in);
            try{
                return Integer.parseInt(scan.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Dữ liệu sai, Vui lòng nhập lại!");
            }
        }
    }
    public static String Name(){
        while (true){
            Scanner scanner = new Scanner(System.in);
            try {
                String name = scanner.nextLine();
                boolean isValid = Regex.checkString(name);
                if(isValid){
                    return name;
                }else {
                    System.out.println("Định dạng sai, mời nhập lại!");
                }
            }catch (Exception e){
                System.out.println("Kiểu dữ liệu bị sai!");
            }
        }
    }
}
