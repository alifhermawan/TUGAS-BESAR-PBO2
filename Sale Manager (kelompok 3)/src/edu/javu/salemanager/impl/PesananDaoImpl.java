/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.javu.salemanager.impl;

import edu.javu.salemanager.entity.Pesanan;
import edu.javu.salemanager.error.PesananException;
import edu.javu.salemanager.service.PesananDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class PesananDaoImpl implements PesananDao {

    private Connection connection;

    private final String insertPesanan = "INSERT INTO PESANAN(TIPEPESANAN, HARGAPESANAN, UKURANPESANAN, JUMLAHPESANAN) VALUES(?,?,?,?)";

    private final String updatePesanan = "UPDATE PESANAN SET TIPEPESANAN=?, HARGAPESANAN=?, UKURANPESANAN=?, JUMLAHPESANAN=? WHERE IP=?";

    private final String deletePesanan = "DELETE FROM PESANAN WHERE IP=? ";

    private final String getByIp = "SELECT * FROM PESANAN WHERE IP=?";

    private final String selectAll = "SELECT * FROM PESANAN";

    public PesananDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insertPesanan(Pesanan pesanan) throws PesananException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);

            statement = connection.prepareStatement(insertPesanan, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, pesanan.getTipePesanan());
            statement.setString(2, pesanan.getHargaPesanan());
            statement.setString(3, pesanan.getUkuranPesanan());
            statement.setString(4, pesanan.getJumlahPesanan());
            statement.executeUpdate();
            
            ResultSet result = statement.getGeneratedKeys();
            if (result.next()) {
                pesanan.setIp(result.getInt(1));
            }

            connection.commit();

        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }

            throw new PesananException(e.getMessage());
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                }
            }

        }

    }

    @Override
    public void updatePesanan(Pesanan pesanan) throws PesananException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(updatePesanan);
            statement.setString(1, pesanan.getTipePesanan());
            statement.setString(2, pesanan.getHargaPesanan());
            statement.setString(3, pesanan.getUkuranPesanan());
            statement.setString(4, pesanan.getJumlahPesanan());
            statement.setInt(5, pesanan.getIp());
            statement.executeUpdate();
            connection.commit();

        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }

            throw new PesananException(e.getMessage());
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                }
            }

        }
    }

    @Override
    public void deletePesanan(Integer ip) throws PesananException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(deletePesanan);
            statement.setInt(1, ip);
            statement.executeUpdate();
            connection.commit();

        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }

            throw new PesananException(e.getMessage());
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                }
            }

        }
    }

    @Override
    public Pesanan getPesanan(Integer ip) throws PesananException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(getByIp);
            statement.setInt(1, ip);

            ResultSet result = statement.executeQuery();
            Pesanan pesanan = null;

            if (result.next()) {
                pesanan = new Pesanan();
                pesanan.setIp(result.getInt("IP"));
                pesanan.setTipePesanan(result.getString("TIPEPESANAN"));
                pesanan.setHargaPesanan(result.getString("HARGAPESANAN"));
                pesanan.setUkuranPesanan(result.getString("UKURANPESANAN"));
                pesanan.setJumlahPesanan(result.getString("JUMLAHPESANAN"));
            } else {
                throw new PesananException("Sepatu Pesanan Dengan Id " + ip + " Tidak Di Temukan");
            }
            connection.commit();
            return pesanan;
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }

            throw new PesananException(e.getMessage());
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                }
            }

        }
    }

    @Override
    public List<Pesanan> selectAllPesanan() throws PesananException {
        Statement statement = null;
        List<Pesanan> list = new ArrayList<Pesanan>();

        try {
            connection.setAutoCommit(false);
            statement = connection.createStatement();

            ResultSet result = statement.executeQuery(selectAll);
            Pesanan pesanan = null;

            while (result.next()) {
                pesanan = new Pesanan();
                pesanan.setIp(result.getInt("IP"));
                pesanan.setTipePesanan(result.getString("TIPEPESANAN"));
                pesanan.setHargaPesanan(result.getString("HARGAPESANAN"));
                pesanan.setUkuranPesanan(result.getString("UKURANPESANAN"));
                pesanan.setJumlahPesanan(result.getString("JUMLAHPESANAN"));
                list.add(pesanan);
            }
            connection.commit();
            return list;
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }

            throw new PesananException(e.getMessage());
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                }
            }

        }
    }

}
