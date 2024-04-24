import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class AccountDAO {

	public static void main(String[] args)  throws SQLException{
		
		Connection connection=null;

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/training","root","root@123");
			System.out.println(connection);
			Statement statement=connection.createStatement();
			int executeUpdate=statement.executeUpdate("insert into account values(3,'demo','temp',4000)");
			System.out.println("Number Return "+executeUpdate);
//			int update=statement.executeUpdate("update account set bal=2000 where id=1");
//			System.out.println("Number Return "+update);
//			int delete=statement.executeUpdate("delete from account  where id=1");
//			System.out.println("Number Return "+delete);
			
			ResultSet resultSet=statement.executeQuery("select * from account");
			while(resultSet.next()) {
				System.out.println("ID of User is "+resultSet.getInt(1));
				System.out.println("FirstNAme User is "+resultSet.getString(2));
				System.out.println("LastNAme User is "+resultSet.getString(3));
				System.out.println("Bal Of User is "+resultSet.getInt(4));
				System.out.println("---------------------------------------------");
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			connection.close();
		}
	}

}