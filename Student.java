public class Student {
    private int rollNo;
    private String name;
    private String department;
    private int year;
    private String email;

    public Student(int rollNo, String name, String department, int year, String email) {
        this.rollNo = rollNo;
        this.name = name;
        this.department = department;
        this.year = year;
        this.email = email;
    }

    public int getRollNo() {
        return rollNo;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public int getYear() {
        return year;
    }

    public String getEmail() {
        return email;
    }
}
