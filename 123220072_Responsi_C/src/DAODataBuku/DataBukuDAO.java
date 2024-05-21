/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAODataBuku;

import java.sql.*;
import java.util.*;
import koneksi.Connector;
import model.*;
import DAOImplement.DataBukuInterface;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC PRAKTIKUM
 */
public class DataBukuDAO implements DataBukuInterface {

    Connection connection;
    final String select = "SELECT * FROM sewa_buku";
    final String insert = "INSERT INTO sewa_buku (nama_penyewa, judul_buku, jenis_buku, nomor_telepon, durasi_sewa, total_biaya) VALUES (?,?,?,?,?,?)";
    final String update = "UPDATE sewa_buku set nama_penyewa=?, judul_buku=?, jenis_buku=?, nomor_telepon=?, durasi_sewa=?, total_biaya=? WHERE id=?";
    final String delete = "DELETE FROM sewa_buku where id=?";

    public DataBukuDAO() {
        connection = Connector.connection();
    }

    @Override
    public void insert(DataBuku b) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, b.getNama());
            statement.setString(2, b.getJudul());
            statement.setString(3, b.getJenis());
            statement.setString(4, b.getTelepon());
            statement.setInt(5, b.getDurasi());
            statement.setInt(6, b.getTotal());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            while (rs.next()) {
                b.setId(rs.getInt(1));
            }
            throw new SQLException("Data Telah Ditambahkan");
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void update(DataBuku b) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, b.getNama());
            statement.setString(2, b.getJudul());
            statement.setString(3, b.getJenis());
            statement.setString(4, b.getTelepon());
            statement.setInt(5, b.getDurasi());
            statement.setInt(6, b.getTotal());
            statement.setInt(7, b.getId());
            statement.executeUpdate();
            throw new SQLException("Data Telah Diupdate");
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void delete(int id) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(delete);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public List<DataBuku> getALl() {
        List<DataBuku> db = null;
        try{
            db = new ArrayList<DataBuku>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()){
                DataBuku buku = new DataBuku();
                buku.setId(rs.getInt("id"));
                buku.setNama(rs.getString("nama_penyewa"));
                buku.setJudul(rs.getString("judul_buku"));
                buku.setJenis(rs.getString("jenis_buku"));
                buku.setTelepon(rs.getString("nomor_telepon"));
                buku.setDurasi(rs.getInt("durasi_sewa"));
                buku.setTotal(rs.getInt("total_biaya"));
            }
        }catch (SQLException ex){
            Logger.getLogger(DataBukuDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return db;
    }

}
