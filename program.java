
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Program {
    // CONNECTION
    public static void loadDriver() {
        try {
            Class.forName("org.postgresql.Driver");
        }
        catch (ClassNotFoundException cnfe) {
            System.out.println("Couldn't find driver class!");
            cnfe.printStackTrace();
            System.exit(1);
        }
    }

    public static Connection getConnection() {
        Connection postGresConn = null;
        try {
            postGresConn = DriverManager.getConnection("jdbc:postgresql://server", "username", "password") ;
        }
        catch (SQLException sqle) {
            System.out.println("Couldn't connect to database!");
            sqle.printStackTrace();
            return null ;
        }
        System.out.println("Successfully connected to Postgres Database");
        return postGresConn ;
    }

    // SEARCH
    public static void searchProducts(String productName, Connection connection, int columnCount) {
        if (connection == null) {
            System.out.println("Unexpected error");
            return;
        }

        // Define all possible columns in the table
        String[] allColumns = {"PROD_ID", "Pavadinimas", "Aprasymas", "Kaina"}; // Add more columns as needed

        // Ensure columnCount does not exceed the available columns
        columnCount = Math.min(columnCount, allColumns.length);

        // Select columns from the left
        String[] columns = new String[columnCount];
        System.arraycopy(allColumns, 0, columns, 0, columnCount);

        // Build the column list for the SQL query
        StringBuilder columnList = new StringBuilder();
        for (String column : columns) {
            columnList.append(column).append(", ");
        }
        // Remove the trailing comma and space
        columnList.setLength(columnList.length() - 2);

        // Determine the maximum width of each column for proper alignment
        int[] columnWidths = new int[columns.length];
        for (int i = 0; i < columns.length; i++) {
            columnWidths[i] = columns[i].length();
        }

        List<String[]> rows = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            // Adjust SQL query to filter by product name using LIKE for partial matches
            String query = "SELECT " + columnList.toString() + " FROM schema.produktas WHERE Pavadinimas LIKE ?";
            stmt = connection.prepareStatement(query);
            stmt.setString(1, "%" + productName + "%");  // Use wildcards for partial match
            rs = stmt.executeQuery();

            // Store rows and calculate maximum widths based on the result set data
            while (rs.next()) {
                String[] row = new String[columns.length];
                for (int i = 0; i < columns.length; i++) {
                    String value = rs.getString(columns[i]);
                    row[i] = value;
                    columnWidths[i] = Math.max(columnWidths[i], value != null ? value.length() : 0);
                }
                rows.add(row);
            }

        } catch (SQLException e) {
            System.out.println("SQL Error!");
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException exp) {
                System.out.println("Unexpected SQL error!");
                exp.printStackTrace();
            }
        }

        // Construct the header and separator lines for the output
        StringBuilder header = new StringBuilder("|");
        StringBuilder separator = new StringBuilder("+");
        for (int i = 0; i < columns.length; i++) {
            header.append(" ").append(String.format("%-" + columnWidths[i] + "s", columns[i])).append(" |");
            separator.append("-".repeat(columnWidths[i] + 2)).append("+");
        }

        // Print the table header
        System.out.println(separator.toString());
        System.out.println(header.toString());
        System.out.println(separator.toString());

        // Print the table rows
        for (String[] row : rows) {
            StringBuilder rowOutput = new StringBuilder("|");
            for (int i = 0; i < columns.length; i++) {
                rowOutput.append(" ").append(String.format("%-" + columnWidths[i] + "s", row[i] != null ? row[i] : "")).append(" |");
            }
            System.out.println(rowOutput.toString());
        }

        // Print the footer separator
        System.out.println(separator.toString());
    }

    public static void searchFactories(String factoryName, Connection connection, int columnCount) {
        if (connection == null) {
            System.out.println("Unexpected error");
            return;
        }

        // Define all possible columns in the table
        String[] allColumns = {"GAM_ID", "Pavadinimas", "Adresas"}; // Add more columns as needed

        // Ensure columnCount does not exceed the available columns
        columnCount = Math.min(columnCount, allColumns.length);

        // Select columns from the left
        String[] columns = new String[columnCount];
        System.arraycopy(allColumns, 0, columns, 0, columnCount);

        // Build the column list for the SQL query
        StringBuilder columnList = new StringBuilder();
        for (String column : columns) {
            columnList.append(column).append(", ");
        }
        // Remove the trailing comma and space
        columnList.setLength(columnList.length() - 2);

        // Determine the maximum width of each column for proper alignment
        int[] columnWidths = new int[columns.length];
        for (int i = 0; i < columns.length; i++) {
            columnWidths[i] = columns[i].length();
        }

        List<String[]> rows = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            // Adjust SQL query to filter by factory name using LIKE for partial matches
            String query = "SELECT " + columnList.toString() + " FROM schema.Gamykla WHERE Pavadinimas LIKE ?";
            stmt = connection.prepareStatement(query);
            stmt.setString(1, "%" + factoryName + "%");  // Use wildcards for partial match
            rs = stmt.executeQuery();

            // Store rows and calculate maximum widths based on the result set data
            while (rs.next()) {
                String[] row = new String[columns.length];
                for (int i = 0; i < columns.length; i++) {
                    String value = rs.getString(columns[i]);
                    row[i] = value;
                    columnWidths[i] = Math.max(columnWidths[i], value != null ? value.length() : 0);
                }
                rows.add(row);
            }

            // Construct the header and separator lines for the output
            StringBuilder header = new StringBuilder("|");
            StringBuilder separator = new StringBuilder("+");
            for (int i = 0; i < columns.length; i++) {
                header.append(" ").append(String.format("%-" + columnWidths[i] + "s", columns[i])).append(" |");
                separator.append("-".repeat(columnWidths[i] + 2)).append("+");
            }

            // Print the table header
            System.out.println(separator.toString());
            System.out.println(header.toString());
            System.out.println(separator.toString());

            // Print the table rows
            for (String[] row : rows) {
                StringBuilder rowOutput = new StringBuilder("|");
                for (int i = 0; i < columns.length; i++) {
                    rowOutput.append(" ").append(String.format("%-" + columnWidths[i] + "s", row[i] != null ? row[i] : "")).append(" |");
                }
                System.out.println(rowOutput.toString());
            }

            // Print the footer separator
            System.out.println(separator.toString());

        } catch (SQLException e) {
            System.out.println("SQL Error!");
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException exp) {
                System.out.println("Unexpected SQL error!");
                exp.printStackTrace();
            }
        }
    }

    // DELETE
    public static void deleteProduct(int prod_id, Connection connection) {
        if(connection == null)
            System.out.println("Unexpected error");

        PreparedStatement stmt = null;
        ResultSet rs = null;

        try{
            stmt = connection.prepareStatement("DELETE FROM schema.produktas WHERE prod_id = ?");
            stmt.setInt(1, prod_id);
            stmt.executeUpdate();
        } catch(SQLException e){
            System.out.println("SQL Error!");
            e.printStackTrace();
        } finally {
            try{
                if(null != rs)
                rs.close();
                if(null != stmt)
                stmt.close();
            } catch (SQLException exp){
                System.out.println("Unexpected SQL error!");
                exp.printStackTrace();
            }
        }
    }

    public static void deleteFactory(int gam_id, Connection connection) {
        if(connection == null)
            System.out.println("Unexpected error");

        PreparedStatement stmt = null;
        ResultSet rs = null;

        try{
            stmt = connection.prepareStatement("DELETE FROM schema.Gamykla WHERE gam_id = ?");
            stmt.setInt(1, gam_id);
            stmt.executeUpdate();
        } catch(SQLException e) {
            System.out.println("SQL Error!");
            e.printStackTrace();
        } finally {
            try {
                if(null != rs)
                rs.close();
                if(null != stmt)
                stmt.close();
            } catch (SQLException exp){
                System.out.println("Unexpected SQL error!");
                exp.printStackTrace();
            }
        }
    }

    // UPDATE
    public static void updateProductPrice(int prod_id, double kaina, Connection connection) {
        if(connection == null)
            System.out.println("Unexpected error");

        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = connection.prepareStatement("UPDATE schema.produktas SET kaina = ? WHERE prod_id = ?");
            stmt.setDouble(1, kaina);
            stmt.setInt(2, prod_id);
            stmt.executeUpdate();
        } catch(SQLException e) {
            System.out.println("SQL Error!");
            e.printStackTrace();
        } finally {
            try{
                if(null != rs)
                rs.close();
                if(null != stmt)
                stmt.close();
            } catch (SQLException exp){
                System.out.println("Unexpected SQL error!");
                exp.printStackTrace();
            }
        }
    }
    public static void updateFactoryName(int gam_id, String pavadinimas, Connection connection) {
        if(connection == null)
            System.out.println("Unexpected error");

        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = connection.prepareStatement("UPDATE schema.Gamykla SET pavadinimas = ? WHERE gam_id = ?");
            stmt.setString(1, pavadinimas);
            stmt.setInt(2, gam_id);
            stmt.executeUpdate();
        } catch(SQLException e){
            System.out.println("SQL Error!");
            e.printStackTrace();
        } finally {
            try{
                if(null != rs)
                rs.close();
                if(null != stmt)
                stmt.close();
            } catch (SQLException exp){
                System.out.println("Unexpected SQL error!");
                exp.printStackTrace();
            }
        }
    }

    // INSERT
    public static void addNewProduct(int prod_id, String pavadinimas, String aprasymas, double kaina, int gam_id, Connection connection) {
        if (connection == null) {
            System.out.println("Unexpected error");
            return;
        }

        PreparedStatement productStmt = null;
        PreparedStatement productionStmt = null;

        try {
            connection.setAutoCommit(false);

            // Insert into Produktas table
            productStmt = connection.prepareStatement("INSERT INTO schema.produktas VALUES (?, ?, ?, ?)");
            productStmt.setInt(1, prod_id);
            productStmt.setString(2, pavadinimas);
            productStmt.setString(3, aprasymas);
            productStmt.setDouble(4, kaina);
            productStmt.executeUpdate();

            System.out.println("<debugging>");
            searchProducts("", connection, 4);

            // Insert into Gaminimas table
            productionStmt = connection.prepareStatement("INSERT INTO schema.gaminimas VALUES (?, ?)");
            productionStmt.setInt(1, prod_id);
            productionStmt.setInt(2, gam_id);
            productionStmt.executeUpdate();

            connection.commit();  // Commit the transaction if everything is successful

        } catch (SQLException e) {
            System.out.println("SQL Error!");
            e.printStackTrace();
            try {
                if (connection != null) {
                    connection.rollback();  // Rollback the transaction if an error occurs
                }
            } catch (SQLException rollbackEx) {
                System.out.println("Rollback failed!");
                rollbackEx.printStackTrace();
            }
        } finally {
            try {
                if (productStmt != null) {
                    productStmt.close();
                }
                if (productionStmt != null) {
                    productionStmt.close();
                }
                if (connection != null) {
                    connection.setAutoCommit(true);  // Reset auto-commit mode
                }
            } catch (SQLException closeEx) {
                System.out.println("Unexpected SQL error during cleanup!");
                closeEx.printStackTrace();
            }
        }
    }

    public static void addNewFactory(int gam_id, String adresas, String pavadinimas, Connection connection) {
        if(connection == null)
            System.out.println("Unexpected error");

        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = connection.prepareStatement("INSERT INTO schema.Gamykla VALUES (?, ?, ?)");
            stmt.setInt(1, gam_id);
            stmt.setString(2, adresas);
            stmt.setString(3, pavadinimas);
            stmt.executeUpdate();
        } catch(SQLException e) {
            System.out.println("SQL Error!");
            e.printStackTrace();
        } finally {
            try {
                if(null != rs)
                rs.close();
                if(null != stmt)
                stmt.close();
            } catch (SQLException exp){
                System.out.println("Unexpected SQL error!");
                exp.printStackTrace();
            }
        }
    }
    
    // DIALOGUE
    private static void printMenu() {
        System.out.println("+----+----------------------------------+");
        System.out.println("| Nr |               Menu               |");
        System.out.println("+----+----------------------------------+");
        System.out.println("|  1 | Ieškoti produktų                 |");
        System.out.println("|  2 | Pridėti produktą į katalogą      |");
        System.out.println("|  3 | Ištrinti produktą is katalogo    |");
        System.out.println("|  4 | Atnaujinti produkto kainą        |");
        System.out.println("+----+----------------------------------+");
        System.out.println("|  5 | Ieškoti gamyklų                  |");
        System.out.println("|  6 | Prideti gamyklą                  |");
        System.out.println("|  7 | Ištrinti gamyklą                 |");
        System.out.println("|  8 | Pakeisti gamyklos pavadinimą     |");
        System.out.println("+----+----------------------------------+");
        System.out.println("|  0 | Baigti darbą                     |");
        System.out.println("+----+----------------------------------+");
    }

    private static String readStringInput(String helpMessage, Scanner sc) {
        System.out.print(helpMessage);
        String result = sc.nextLine();
        return result;
    }

    // private static int readIntInput(String helpMessage, Scanner sc) {
    //     System.out.print(helpMessage);
    //     int result = sc.nextInt();
    //     sc.nextLine();
    //     return result;
    // }

    private static double readDoubleInput(String helpMessage, Scanner sc) {
        System.out.print(helpMessage);
        double result = sc.nextDouble();
        sc.nextLine();
        return result;
    }

    private static int readIntInput(String helpMessage, Scanner sc) {
        while (true) {
            System.out.print(helpMessage);
            String input = sc.nextLine();

            if (input.equals("?")) {
                printMenu();
                continue; // Prompt the user again after displaying the menu
            }

            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer or '?' for the menu.");
            }
        }
    }

    // MAIN
    public static void main(String[] args) {
        loadDriver() ;
        Connection connection = getConnection() ;

        Scanner sc = new Scanner(System.in);
        
        if (null != connection) {
            while (true) {
                // printMenu();
                int selectedMenuItem = readIntInput("Pasirinkite veiksmą (pagalba: '?'): ", sc);
                switch (selectedMenuItem) {
                    case 0: // Baigti darba
                        System.out.println("Programa baigia darba");
                        break;
                    case 1: { // Ieškoti produktų
                        String search = readStringInput("Iveskite produkto pavadinimą: ", sc);
                        searchProducts(search, connection, 4);
                        break;
                    }
                    case 2: { // Prideti produkta i kataloga
                        System.out.println("Produktai: ");
                        searchProducts("", connection, 2);
                        int prod_ID = readIntInput("Iveskite produkto id: ", sc);
                        String pavadinimas = readStringInput("Iveskite produkto pavadinima: ", sc);
                        String aprasymas = readStringInput("Iveskite produkto aprasyma: ", sc);
                        double kaina = readDoubleInput("Iveskite produkto kaina: ", sc);
                        System.out.println("Gamyklos: ");
                        searchFactories("", connection, 2);
                        int gam_ID = readIntInput("Iveskite gamyklos id: ", sc);
                        addNewProduct(prod_ID, pavadinimas, aprasymas, kaina, gam_ID, connection);
                        break;
                    }
                    case 3: { // Istrinti produkta is katalogo
                        System.out.println("Produktai: ");
                        searchProducts("", connection, 2);
                        int prod_ID = readIntInput("Iveskite produkto id: ", sc);
                        deleteProduct(prod_ID, connection);
                        break;
                    }
                    case 4: { // Atnaujinti produkto kaina
                        System.out.println("Produktai: ");
                        searchProducts("", connection, 2);
                        int prod_ID = readIntInput("Iveskite produkto id: ", sc);
                        double kaina = readDoubleInput("Iveskite produkto kaina: ", sc);
                        updateProductPrice(prod_ID, kaina, connection);
                        break;
                    }
                    case 5: { // Rodyti visas gamyklas
                        String search = readStringInput("Iveskite gamyklos pavadinimą: ", sc);
                        searchFactories(search, connection, 3);
                        break;
                    }
                    case 6: { // Prideti gamykla
                        System.out.println("Gamyklos: ");
                        searchFactories("", connection, 2);
                        int gam_ID = readIntInput("Iveskite gamyklos id: ", sc);
                        String adresas = readStringInput("Iveskite gamyklos adresa: ", sc);
                        String gamPavadinimas = readStringInput("Iveskite gamyklos pavadinima: ", sc);
                        addNewFactory(gam_ID, adresas, gamPavadinimas, connection);
                        break;
                    }
                    case 7: { // Istrinti gamykla
                        System.out.println("Gamyklos: ");
                        searchFactories("", connection, 2);
                        int gam_ID = readIntInput("Iveskite gamyklos id: ", sc);
                        deleteFactory(gam_ID, connection);
                        break;
                    }
                    case 8: { // Pakeisti gamyklos pavadinima
                        System.out.println("Gamyklos: ");
                        searchFactories("", connection, 2);
                        int gam_ID = readIntInput("Iveskite gamyklos id: ", sc);
                        String gamPavadinimas = readStringInput("Iveskite gamyklos pavadinima: ", sc);
                        updateFactoryName(gam_ID, gamPavadinimas, connection);
                        break;
                    }
                }
                if (selectedMenuItem == 0) // išeinu iš loop'o (case 0 išeina tik iš switch'o)
                    break;
            }
        }       
        if (null != connection) {
            try {
                connection.close() ;
            }
            catch (SQLException exp) {
                System.out.println("Can not close connection!");
                exp.printStackTrace();
            }
        }

        sc.close ();
    }
}