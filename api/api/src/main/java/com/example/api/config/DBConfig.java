package com.example.api.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConfig {

  private static final String URL = "jdbc:h2:mem:biblioteca";

  private static final String USER = "sa";

  private static final String PASSWORD = "";

  public static Connection getConnection() throws SQLException {
    return DriverManager.getConnection(URL, USER, PASSWORD);
  }

  public static void createTables() {
    // TODO: Query para criar as tabelas no banco e executar ao iniciar o sistema
  }
}