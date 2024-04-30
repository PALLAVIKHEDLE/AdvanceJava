import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;


public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Connection connection=null;

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/training","root","root@123");
			System.out.println(connection);
			if(connection!=null) {
				PreparedStatement statement=connection.prepareStatement("insert into user values(?,?,?,?)");
				statement.setString(1,"John");
				statement.setString(2,"Ross");
				statement.setString(3,"JOHNRoss");
				statement.setString(4,"Ross456");
				
				int executeUpdate=statement.executeUpdate();
				System.out.println(executeUpdate);
				statement.close();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}