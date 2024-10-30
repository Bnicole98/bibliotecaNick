package br.com.udf;


import java.sql.*;

public class DatabaseConnection{
    private static final String URL = "jdbc:mysql://localhost:3306/biblioteca";
    private static final String USER = "root";
    private static final String PASSWORD = "admin123";


    public static Connection getConnection(){
        try{
            return DriverManager.getConnection(URL, USER, PASSWORD);

        }catch (SQLException e){
            e.printStackTrace();
            return null;


        }
    }

    public static ResultSet consultaSQL(String query){
        try{
            Connection con = getConnection();
            if(con == null){
                return null;
            }else{
                PreparedStatement stm = con.prepareStatement(query);
                return stm.executeQuery();
            }



        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public static boolean executeQuery(String query){
        boolean succes = false;
        System.out.println("Query:"+query);
        try {
            Connection conn = getConnection();
            int ra = conn.createStatement().executeUpdate(query);

            if(ra>0){
                succes = true;
            }

        }catch (SQLException e){
            e.printStackTrace();

        }


        return succes;
    }

}