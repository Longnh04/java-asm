package source;

import java.util.Scanner;

public class ControlApp {
    private StudentManagement studentManager;

    public ControlApp() {
        this.studentManager = new StudentManagement(1000); // Khởi tạo StudentManagement
    }

    public boolean handleOption(int option, Scanner scanner) {
        switch (option) {
            case 1:
                System.out.print("Enter student ID: ");
                String id = scanner.nextLine();
                System.out.print("Enter student name: ");
                String name = scanner.nextLine();
                System.out.print("Enter student mark: ");
                double mark = scanner.nextDouble();
                scanner.nextLine(); // Xóa bộ đệm
                studentManager.addStudent(id, name, mark); // Gọi phương thức thêm sinh viên
                break;

            case 2:
                studentManager.printAllStudents(); // Hiển thị thông tin sinh viên
                break;

            case 3:
                System.out.print("Enter student ID to remove: ");
                String removeId = scanner.nextLine();
                studentManager.removeStudent(removeId); // Gọi phương thức xóa
                break;

            case 4:
                System.out.print("Enter student ID to update: ");
                String updateId = scanner.nextLine();
                System.out.print("Enter new name: ");
                String newName = scanner.nextLine();
                System.out.print("Enter new mark: ");
                double newMark = scanner.nextDouble();
                scanner.nextLine();
                studentManager.updateStudent(updateId, newName, newMark); // Cập nhật thông tin
                break;

            case 5:
                studentManager.sortStudentsByMarks(); // Sắp xếp theo điểm
                break;

            case 6:
                System.out.print("Enter student ID to search: ");
                String searchId = scanner.nextLine();
                studentManager.searchStudentById(searchId); // Tìm kiếm sinh viên
                break;

            case 7:
                return false; // Kết thúc chương trình
            default:
                System.out.println("Invalid option!");
        }

        return true; // Tiếp tục chạy chương trình
    }
}
