/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uas1;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;


    public class dsnkoneksi {
    String JDBC_Driver = "com.mysql.cj.jdbc.Driver";
    String DB_URL = "jdbc:mysql://localhost/db_dosen";
    String USER = "root";
    String PASS = "";
    
    private static Connection koneksi;
    
    public Connection koneksi(){
        if(this.koneksi == null){
            try{
                DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
                koneksi = DriverManager.getConnection(DB_URL, USER,PASS);
                System.out.println("Berhasil");
            }catch (Exception e){
                System.out.println("Eror saat membuat koneksi ke DBMS");
            }
        }return this.koneksi;
    }
 }
