/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;
import controller.DataBukuController;
import java.awt.event.ItemEvent;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
/**
 *
 * @author PC PRAKTIKUM
 */
public class MainView extends javax.swing.JFrame{
    DataBukuController dc;
    public MainView(){
        initComponents();
        dc = new DataBukuController(this);
        
    }
}
