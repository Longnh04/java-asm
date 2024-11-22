package source;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        ControlApp controlApp = new ControlApp(); // Tạo đối tượng ControlApp để phân luồng
        Scanner scanner = new Scanner(System.in);
        boolean keepRunning = true;

        while (keepRunning) {
            System.out.println("Choose an option below:");
            System.out.println("1. Add student");
            System.out.println("2. Print student information");
            System.out.println("3. Delete student information");
            System.out.println("4. Update student information");
            System.out.println("5. Sort students by mark");
            System.out.println("6. Search student by Id");
            System.out.println("7. Exit");
            System.out.print("Your option is: ");

            int option = scanner.nextInt();
            scanner.nextLine(); // Xóa bộ đệm
            keepRunning = controlApp.handleOption(option, scanner); // Chuyển xử lý tới ControlApp
        }

        System.out.println("Exit the program!");
        scanner.close();
    }
}
