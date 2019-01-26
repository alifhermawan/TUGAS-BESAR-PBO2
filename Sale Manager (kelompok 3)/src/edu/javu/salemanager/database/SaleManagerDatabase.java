/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.javu.salemanager.database;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import edu.javu.salemanager.impl.PesananDaoImpl;
import edu.javu.salemanager.impl.SepatuDaoImpl;
import edu.javu.salemanager.service.PesananDao;
import edu.javu.salemanager.service.SepatuDao;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author user
 */
public class SaleManagerDatabase {
    
    private static Connection connection;
    private static SepatuDao sepatuDao;
    private static PesananDao pesananDao;
    
    
    public static Connection getConnection() throws SQLException{
        if (connection==null) {
            
            MysqlDataSource dataSource= new MysqlDataSource();
            dataSource.setURL("jdbc:mysql://localhost:3306/salemanager");
            dataSource.setUser("root");
            dataSource.setPassword("");
            connection = dataSource.getConnection();
            
        }
        return connection;
    }
    
    public static SepatuDao getSepatuDao() throws SQLException{
        if (sepatuDao==null) {
            sepatuDao = new SepatuDaoImpl(getConnection());
            
            
        }
        return sepatuDao;
    }
    
        public static PesananDao getPesananDao() throws SQLException{
        if (pesananDao==null) {
            pesananDao = new PesananDaoImpl(getConnection());                      
        }
        return pesananDao;
    }
}
