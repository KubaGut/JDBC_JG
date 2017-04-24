import java.net.CookieHandler;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Query {

    Statement statement;

    public void getData() throws SQLException, ClassNotFoundException {
        statement = Connect.getInstance().getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM books");

        while (resultSet.next()) {
            System.out.println(resultSet.getString("id") + " " + resultSet.getString("title"));
        }
    }


}
