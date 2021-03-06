package Question3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;

public class DeleteRecordFromDatabase {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        java.sql.Date ourJavaDateObject = new java.sql.Date(calendar.getTime().getTime());

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int count = 0;
        try {
            String sql = "delete from customer_details where cid = ? ";
            connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment1", "Trantor", "1234");
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,1);
            count = preparedStatement.executeUpdate();
            System.out.println(count);
            System.out.println("record Deleted...");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
