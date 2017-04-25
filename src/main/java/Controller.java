import java.sql.SQLException;
import java.util.Scanner;

public class Controller {

    Query query = new Query();

    public void start() throws SQLException, ClassNotFoundException {
        menu();
        boolean flag;
        Scanner sc1 = new Scanner(System.in);

        while (flag = true) {

            String wybor = sc1.nextLine();

            switch (Integer.parseInt(wybor)) {
                case 1:
                    query.getData();
                    menu();
                    break;
                case 2:
                    query.addBook();
                    menu();
                    break;

                case 5:
                    flag = false;
                    break;

            }
        }
    }

    public void menu(){
        System.out.println("Pracujemy z bazą danych books");
        System.out.println("Podaj numer operacji");
        System.out.println("1. Wyświetl tabelę");
        System.out.println("2. Dodaj książkę");
        System.out.println("3. Aktualizuj dane książki");
        System.out.println("4. Usuń książkę");
    }


}
