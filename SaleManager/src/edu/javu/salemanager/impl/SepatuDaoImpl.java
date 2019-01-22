/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.javu.salemanager.impl;

import edu.javu.salemanager.entity.Sepatu;
import edu.javu.salemanager.error.SepatuException;
import edu.javu.salemanager.service.SepatuDao;
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
public class SepatuDaoImpl implements SepatuDao {

    private Connection connection;
    private final String insertSepatu = "INSERT INTO SEPATU (TIPESEPATU,HARGASEPATU,STOKSEPATU,UKURANSEPATU) VALUES(?,?,?,?)";
    private final String updateSepatu = "UPDATE SEPATU SET TIPESEPATU=?, HARGASEPATU=?, STOKSEPATU=?, UKURANSEPATU=? WHERE ID=?";
    private final String deleteSepatu = "DELETE FROM SEPATU WHERE ID=?";
    private final String getById = "SELECT * FROM SEPATU WHERE ID=?";
    private final String selectAll = "SELECT * FROM SEPATU";

    public SepatuDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insertSepatu(Sepatu sepatu) throws SepatuException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);

            statement = connection.prepareStatement(insertSepatu, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, sepatu.getTipeSepatu());
            statement.setString(2, sepatu.getHargaSepatu());
            statement.setString(3, sepatu.getStokSepatu());
            statement.setString(4, sepatu.getUkuranSepatu());
            statement.executeUpdate();

            ResultSet result = statement.getGeneratedKeys();
            if (result.next()) {
                sepatu.setId(result.getInt(1));
                
            }
            connection.commit();

        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }

            throw new SepatuException(e.getMessage());
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
    public void updateSepatu(Sepatu sepatu) throws SepatuException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(updateSepatu);
            statement.setString(1, sepatu.getTipeSepatu());
            statement.setString(2, sepatu.getHargaSepatu());
            statement.setString(3, sepatu.getStokSepatu());
            statement.setString(4, sepatu.getUkuranSepatu());
            statement.setInt(5, sepatu.getId());
            statement.executeUpdate();
            connection.commit();

        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }

            throw new SepatuException(e.getMessage());
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
    public void deleteSepatu(Integer id) throws SepatuException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(deleteSepatu);
            statement.setInt(1, id);

            statement.executeUpdate();
            connection.commit();

        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }

            throw new SepatuException(e.getMessage());
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
    public Sepatu getSepatu(Integer id) throws SepatuException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(getById);
            statement.setInt(1, id);

            ResultSet result = statement.executeQuery();
            Sepatu sepatu = null;

            if (result.next()) {
                sepatu = new Sepatu();
                sepatu.setId(result.getInt("ID"));
                sepatu.setTipeSepatu(result.getString("TIPESEPATU"));
                sepatu.setHargaSepatu(result.getString("HARGASEPATU"));
                sepatu.setStokSepatu(result.getString("STOKSEPATU"));
                sepatu.setUkuranSepatu(result.getString("UKURANSEPATU"));

            } else {
                throw new SepatuException("Sepatu Dengan Id " + id + " Tidak Ditemukan");
            }
            connection.commit();
            return sepatu;
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }

            throw new SepatuException(e.getMessage());
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
    public List<Sepatu> selectAllSepatu() throws SepatuException {
        Statement statement = null;
        List<Sepatu> list = new ArrayList<Sepatu>();

        try {
            connection.setAutoCommit(false);
            statement = connection.createStatement();

            ResultSet result = statement.executeQuery(selectAll);
            Sepatu sepatu = null;

            while (result.next()) {
                sepatu = new Sepatu();
                sepatu.setId(result.getInt("ID"));
                sepatu.setTipeSepatu(result.getString("TIPESEPATU"));
                sepatu.setHargaSepatu(result.getString("HARGASEPATU"));
                sepatu.setStokSepatu(result.getString("STOKSEPATU"));
                sepatu.setUkuranSepatu(result.getString("UKURANSEPATU"));
                list.add(sepatu);
            }
            connection.commit();
            return list;
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }

            throw new SepatuException(e.getMessage());
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
