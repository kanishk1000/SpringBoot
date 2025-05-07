import java.sql.*;

public class DemoJdbc {
    public static void main(String[] args) throws Exception {

        /*

           Import the Package

           Load and Register the drivers

           Create Connection

           Create a Statement

           Execute the Statement

           Process the Results

           Close

         */

        int sid = 102;
        String sname = "Jasmine";
        int marks = 52;

        String url = "jdbc:postgresql://localhost:5432/demo";
        String uname = "postgres";
        String pass = "Scabius@1234";
        String sql = "insert into student values (?,?,?) ";


        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection(url, uname, pass);
        System.out.println("Connection is established...");

        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1, sid);
        st.setString(2, sname);
        st.setInt(3, marks);

        st.execute();

        con.close();
        System.out.println("Connection is closed...");
    }
}
