/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.javu.salemanager.main;

import edu.javu.salemanager.database.SaleManagerDatabase;
import edu.javu.salemanager.entity.Pesanan;
import edu.javu.salemanager.entity.Sepatu;
import edu.javu.salemanager.error.PesananException;
import edu.javu.salemanager.error.SepatuException;
import edu.javu.salemanager.service.PesananDao;
import edu.javu.salemanager.service.SepatuDao;
import edu.javu.salemanager.view.LoginView;
import edu.javu.salemanager.view.SepatuView;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;

/**
 *
 * @author user
 */
public class SaleManager {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, SepatuException, PesananException {

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {

                LoginView login = new LoginView();
                login.setVisible(true);

            }
        });
    }

}
