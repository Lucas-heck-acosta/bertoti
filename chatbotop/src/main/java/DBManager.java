import java.sql.*;


public class DBManager {
    private final String databaseUrl;

    public DBManager(String databasePath) {
        this.databaseUrl = "jdbc:sqlite:" + databasePath;
    }

    public void initializeDatabase() {
        try (Connection conn = DriverManager.getConnection(databaseUrl)) {
            if (conn != null) {
                Statement stmt = conn.createStatement();

                // Limpa a tabela antes de inserções
                clearDatabase(stmt);

                String createTableSql = "CREATE TABLE IF NOT EXISTS books ("
                        + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                        + "title TEXT NOT NULL,"
                        + "author TEXT NOT NULL,"
                        + "year INTEGER"
                        + ");";
                stmt.execute(createTableSql);

                String insertBooksSql = "INSERT INTO books(title, author, year) VALUES"
                        + "('1984', 'George Orwell', 1949),"
                        + "('To Kill a Mockingbird', 'Harper Lee', 1960),"
                        + "('The Great Gatsby', 'F. Scott Fitzgerald', 1925);";
                stmt.execute(insertBooksSql);

                System.out.println("Database initialized and books inserted.");
            }
        } catch (SQLException e) {
            System.out.println("Error initializing database: " + e.getMessage());
        }
    }

    private void clearDatabase(Statement stmt) {
        try {
            String clearTableSql = "DELETE FROM books";
            stmt.execute(clearTableSql);
            System.out.println("Table cleared.");
        } catch (SQLException e) {
            System.out.println("Error clearing table: " + e.getMessage());
        }
    }

    public String getBooks() {
        StringBuilder books = new StringBuilder();
        String sql = "SELECT title, author, year FROM books";

        try (Connection conn = DriverManager.getConnection(databaseUrl);
             Statement stmt = conn.createStatement();
             var rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                books.append(rs.getString("title"))
                        .append(" by ")
                        .append(rs.getString("author"))
                        .append(" (")
                        .append(rs.getInt("year"))
                        .append(")\n");
            }
        } catch (SQLException e) {
            books.append("Error retrieving books: ").append(e.getMessage());
        }

        return books.toString();
    }

    public void addBook(String title, String author, int year) {
        String sql = "INSERT INTO books(title, author, year) VALUES(?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(databaseUrl);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, title);
            pstmt.setString(2, author);
            pstmt.setInt(3, year);
            pstmt.executeUpdate();
            System.out.println("Book added: " + title);

        } catch (SQLException e) {
            System.out.println("Error adding book: " + e.getMessage());
        }
    }
}
