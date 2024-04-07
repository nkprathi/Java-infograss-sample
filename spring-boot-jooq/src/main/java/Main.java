import static org.jooq.impl.DSL.*;

import java.sql.*;

import org.jooq.DSLContext;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.TableLike;
import org.jooq.impl.DSL;
import org.jooq.Record;
public class Main {

	public static void main(String[] args) {
        String userName = "root";
        String password = "";
        String url = "jdbc:mysql://localhost:3306/library";

        // Connection is the only JDBC resource that we need
        // PreparedStatement and ResultSet are handled by jOOQ, internally
        try (Connection conn = DriverManager.getConnection(url, userName, password)) {
        	DSLContext create = DSL.using(conn, SQLDialect.MYSQL);

            Result<Record> result = create.select().fetch();
            Author author = new Author();
            for (Record r : result) {
            	Object id = r.getValue(author.getId());
                Object firstName = r.getValue(author.getFirstname());
                Object lastName = r.getValue(author.getLastname());

                System.out.println("ID: " + id + " first name: " + firstName + " last name: " + lastName);
            }
        } 

        // For the sake of this tutorial, let's keep exception handling simple
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}