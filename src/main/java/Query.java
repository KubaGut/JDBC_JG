import com.sun.org.apache.xpath.internal.SourceTree;

import java.net.CookieHandler;
import java.sql.*;
import java.util.Scanner;

public class Query {

    Statement statement;

    public void getData() throws SQLException, ClassNotFoundException {
        statement = Connect.getInstance().getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM books");

        while (resultSet.next()) {
            System.out.println(resultSet.getString("id") + " " + resultSet.getString("title") +
                    resultSet.getString("author") + resultSet.getString("price") +
                    resultSet.getString("page_count"));
        }
        resultSet.close();
        statement.close();
        Connect.getInstance().getConnection().close();
    }

    public void addBook() throws SQLException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Podaj tytuł");
        String tytul = "'" + sc.nextLine() + "'";
        System.out.println("Podaj autora");
        String autor = "'" + sc.nextLine() + "'";
        System.out.println("Podaj kategorię");
        String category = "'" + sc.nextLine() + "'";
        System.out.println("Podaj wydawce");
        String wydawca = "'" + sc.nextLine() + "'";
        System.out.println("Podaj cene");
        int cena = Integer.parseInt(sc.nextLine());
        System.out.println("Podaj ilosc stron");
        int ilStron = Integer.parseInt(sc.nextLine());
        // System.out.println("Data publikacji RRRR-MM-DD");
        //String data = sc.nextLine();

        statement = Connect.getInstance().getConnection().createStatement();
        statement.executeUpdate("INSERT INTO books(author, title, category, publisher, price, page_count) " +
                "VALUES ("+tytul+" , "+autor+" , "+category+" , "+wydawca+" , "+cena+", "+ilStron+" )" );

    }


}
