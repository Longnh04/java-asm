package source;

public class StudentManagement {
    private Student[] students;
    private int count; // Số lượng sinh viên hiện có

    public StudentManagement(int capacity) {
        this.students = new Student[capacity];
        this.count = 0;
    }

    // Thêm sinh viên
    public void addStudent(String id, String name, double mark) {
        if (count >= students.length) {
            System.out.println("Student list is full. Cannot add more students.");
            return;
        }
        students[count++] = new Student(id, name, mark);
    }

    // In danh sách sinh viên
    public void printAllStudents() {
        if (count == 0) {
            System.out.println("No students available.");
        } else {
            for (int i = 0; i < count; i++) {
                System.out.println(students[i]);
            }
        }
    }

    // Xóa sinh viên theo ID
    public void removeStudent(String id) {
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (students[i].getId().equals(id)) {
                // Dịch chuyển các phần tử còn lại lên trên
                for (int j = i; j < count - 1; j++) {
                    students[j] = students[j + 1];
                }
                students[--count] = null; // Giảm số lượng và xóa phần tử cuối
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student not found.");
        }
    }

    // Cập nhật thông tin sinh viên
    public void updateStudent(String id, String newName, double newMark) {
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (students[i].getId().equals(id)) {
                students[i].setName(newName);
                students[i].setMark(newMark);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student not found.");
        }
    }

    // Sắp xếp sinh viên theo điểm số
    public void sortStudentsByMarks() {
        for (int i = 0; i < count - 1; i++) {
            for (int j = i + 1; j < count; j++) {
                if (students[i].getMark() > students[j].getMark()) {
                    // Hoán đổi vị trí
                    Student temp = students[i];
                    students[i] = students[j];
                    students[j] = temp;
                }
            }
        }
    }

    // Tìm kiếm sinh viên theo ID
    public void searchStudentById(String id) {
        for (int i = 0; i < count; i++) {
            if (students[i].getId().equals(id)) {
                System.out.println(students[i]);
                return;
            }
        }
        System.out.println("Student not found.");
    }
}
