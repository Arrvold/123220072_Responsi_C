/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.util.List;
import DAODataBuku.DataBukuDAO;
import model.*;
import DAOImplement.DataBukuInterface;
import view.MainView;
import view.BukuView;
/**
 *
 * @author PC PRAKTIKUM
 */
public class DataBukuController {
    MainView frame;
    DataBukuInterface implDataBuku;
    List<DataBuku>db;
    
    public DataBukuController (MainView frame){
        this.frame = frame;
        implDataBuku = new DataBukuDAO();
        db = implDataBuku.getALl();
    }
    
    public void isiTabel(){
        db = implDataBuku.getALl();
        ModelDataBuku mb = new ModelDataBuku(db);
        frame.getTabelBuku().setModel(mb);
    }
    
    public void insert(){
        DataBuku db = new DataBuku();
        db.setId(db.getId());
        db.setNama(frame.getNama().getText());
        
    }
}
