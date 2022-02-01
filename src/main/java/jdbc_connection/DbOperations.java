package jdbc_connection;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class DbOperations {

   public static Connection conn = null;
    //@TODO: Hide text field;


    public static void connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn  = DriverManager.getConnection("jdbc:mysql://localhost:3306/lab", "arjun", "arjun");

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

       public static boolean  insertData(String name,String email, String password) throws Exception{

            PreparedStatement pst = conn.prepareStatement("INSERT INTO users(name,email,password) VALUES (?,?,?)");
        pst.setString(1,name);
        pst.setString(2,email);
        pst.setString(3,password);

        pst.executeUpdate();
        return true;

    }

    public static boolean insertDataIntoBooksTable(String name, String category, int price, int totalUnits){

        try {
            //java javascript string literal
            //"Insert into books("+name+","+category+",")
            PreparedStatement pst = conn.prepareStatement("INSERT INTO books(name,category,quantity,price) VALUES (?,?,?,?)");
            pst.setString(1,name);
            pst.setString(2,category);
            pst.setInt(3,totalUnits);
            pst.setInt(4,price);
            pst.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    public ObservableList<Users> getAllUsers() throws Exception {

        ObservableList<Users> list = FXCollections.observableArrayList();
        Statement st = conn.createStatement();
        String statement = "SELECT * FROM Students";
        ResultSet rs = st.executeQuery(statement);
        while (rs.next()) {
            list.add(new Users(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
        }
        return list;
    }

    public static ObservableList<Books> getBookData() throws Exception {

        ObservableList<Books> list = FXCollections.observableArrayList();
        Statement st = conn.createStatement();
        String statement = "SELECT * FROM Books";
        ResultSet rs = st.executeQuery(statement);
        while (rs.next()) {
            list.add(new Books(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4),rs.getString(5)));
        }
        return list;
    }


    public static boolean login(String email,String password) throws SQLException {
        PreparedStatement statement = conn.prepareStatement("SELECT * FROM Users WHERE Email = ? AND Password = ? ");
        statement.setString(1,email);
        statement.setString(2,(password));
        ResultSet rs =statement.executeQuery();
        if(rs.next()){
                System.out.println("Login Successfully");
                return true;
            }else {
                System.out.println("Failed");
                return  false;
            }
    }


}
