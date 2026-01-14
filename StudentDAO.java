import java.sql.*;

public class StudentDAO {

    // Add Student
    public void addStudent(Student s) {
        String query = "INSERT INTO students VALUES (?, ?, ?, ?, ?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, s.getRollNo());
            ps.setString(2, s.getName());
            ps.setString(3, s.getDepartment());
            ps.setInt(4, s.getYear());
            ps.setString(5, s.getEmail());
            ps.executeUpdate();

            System.out.println("Student added successfully.");

        } catch (Exception e) {
            System.out.println("Error adding student.");
        }
    }

    // View All Students
    public void viewStudents() {
        String query = "SELECT * FROM students";
        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query)) {

            System.out.println("\nRoll | Name | Dept | Year | Email");
            while (rs.next()) {
                System.out.println(
                        rs.getInt("roll_no") + " | " +
                        rs.getString("name") + " | " +
                        rs.getString("department") + " | " +
                        rs.getInt("year") + " | " +
                        rs.getString("email")
                );
            }
        } catch (Exception e) {
            System.out.println("Error fetching students.");
        }
    }

    // Update Student
    public void updateStudent(int rollNo, String name, String dept, int year, String email) {
        String query = "UPDATE students SET name=?, department=?, year=?, email=? WHERE roll_no=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, name);
            ps.setString(2, dept);
            ps.setInt(3, year);
            ps.setString(4, email);
            ps.setInt(5, rollNo);

            int rows = ps.executeUpdate();
            if (rows > 0)
                System.out.println("Student updated successfully.");
            else
                System.out.println("Student not found.");

        } catch (Exception e) {
            System.out.println("Error updating student.");
        }
    }

    // Delete Student
    public void deleteStudent(int rollNo) {
        String query = "DELETE FROM students WHERE roll_no=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, rollNo);
            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Student deleted successfully.");
            else
                System.out.println("Student not found.");

        } catch (Exception e) {
            System.out.println("Error deleting student.");
        }
    }

    // Search Student
    public void searchStudent(int rollNo) {
        String query = "SELECT * FROM students WHERE roll_no=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, rollNo);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("\nStudent Found:");
                System.out.println("Roll No: " + rs.getInt("roll_no"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Department: " + rs.getString("department"));
                System.out.println("Year: " + rs.getInt("year"));
                System.out.println("Email: " + rs.getString("email"));
            } else {
                System.out.println("Student not found.");
            }
        } catch (Exception e) {
            System.out.println("Error searching student.");
        }
    }
}
