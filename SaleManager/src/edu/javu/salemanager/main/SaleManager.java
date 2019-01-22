/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.javu.salemanager.main;

import edu.javu.salemanager.database.SaleManagerDatabase;
import edu.javu.salemanager.entity.Sepatu;
import edu.javu.salemanager.error.SepatuException;
import edu.javu.salemanager.service.SepatuDao;
import edu.javu.salemanager.view.LoginView;
import java.sql.SQLException;

/**
 *
 * @author user
 */
public class SaleManager {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, SepatuException{
        
        SepatuDao dao = SaleManagerDatabase.getSepatuDao();
        
        dao.deleteSepatu(1);
        LoginView n = new LoginView();
        
        
    }
    
}
