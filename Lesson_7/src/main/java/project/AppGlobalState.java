package project;

import java.sql.*;

public class AppGlobalState {

    private static AppGlobalState instanse;

    private static Connection connection;

    private static Statement statement;

    private static PreparedStatement insertWeatherPreparedStatement;

    private String cityKey;
    public String getCityKey() {
        return cityKey;
    }
    public void setCityKey(String cityKey) {
        this.cityKey = cityKey;
    }

    public String getApiKey() {
        return "elUN9sJesNSKHDNdT3w5GaPjRYLRlQF6";
    }

    public static AppGlobalState getInstance() {
        if (instanse == null) {
            instanse = new AppGlobalState();
        }
        return instanse;
    }

    private String cityTitle;
    public String getCityTitle() {
        return cityTitle;
    }
    public void setCityTitle(String cityTitle) { this.cityTitle = cityTitle;  }


    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return connection;
    }

    public static Statement getStatement() {
        return statement;
    }

    public static PreparedStatement getInsertWeatherPreparedStatement() {
        return insertWeatherPreparedStatement;
    }

    public String getDbName() {
        return "weather-app.db";
    }

    private AppGlobalState() {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:" + getDbName());
            statement = connection.createStatement();

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS weather (" +
                    "city TEXT NOT NULL, date TEXT NOT NULL, text TEXT NOT NULL, temp INTEGER NOT NULL );");

            insertWeatherPreparedStatement = connection.prepareStatement(
                    "INSERT INTO weather  (city, date, text, temp) VALUES (?,?,?,?);"
            );

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.exit(1);
        }

    }

}
