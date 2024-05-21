/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author PC PRAKTIKUM
 */
public class ModelDataBuku extends AbstractTableModel {

    List<DataBuku> db;

    public ModelDataBuku(List<DataBuku> db) {
        this.db = db;
    }

    @Override
    public int getRowCount() {
        return db.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ID";
            case 1:
                return "Nama Penyewa";
            case 2:
                return "Judul Buku";
            case 3:
                return "Jenis Buku";
            case 4:
                return "Nomor telepon";
            case 5:
                return "Durasi Sewa";
            case 6:
                return "Total Biaya";
            default:
                return null;
        }

    }

    @Override
    public Object getValueAt(int row, int column) {
        switch (column) {
            case 0:
                return db.get(row).getId();
            case 1:
                return db.get(row).getNama();
            case 2:
                return db.get(row).getJudul();
            case 3:
                return db.get(row).getJenis();
            case 4:
                return db.get(row).getTelepon();
            case 5:
                return db.get(row).getDurasi();
            case 6:
                return db.get(row).getTotal();
            default:
                return null;
        }
    }
}
