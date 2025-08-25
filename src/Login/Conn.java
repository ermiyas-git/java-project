package Login;

import java.sql.*;

public class Conn {

	public Connection c;
	public Statement s;
        public PreparedStatement p;

	public Conn() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver" );
			c = DriverManager.getConnection("jdbc:sqlserver://localhost\\SQLEXPRESS01:1433;databaseName=EMPLOYEE;"
                                + "encrypt=true;trustServerCertificate=true","admin","SQL4556");
			s = c.createStatement();
                        
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

    // Method to get the connection (used for prepared statements)
    public Connection getConnection() {
        return c;
    }

    // Method to execute a query (for SELECT statements)
    public ResultSet executeQuery(String query) throws SQLException {
        return s.executeQuery(query);
    }

    // Method to execute an update (for INSERT, UPDATE, DELETE)
    public int executeUpdate(String query) throws SQLException {
        return s.executeUpdate(query);
    }

    // Method to prepare a statement
    public PreparedStatement prepareStatement(String query) throws SQLException {
        return c.prepareStatement(query);
    }
     public PreparedStatement prepareStatementWithGeneratedKeys(String query) throws SQLException {
        return c.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
    }

    // Close all resources
    public void close() {
        try {
            if (s != null) s.close();
            if (p != null) p.close();
            if (c != null) c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
