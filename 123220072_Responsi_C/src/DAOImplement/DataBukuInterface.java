/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOImplement;
import java.util.List;
import model.*;

/**
 *
 * @author PC PRAKTIKUM
 */
public interface DataBukuInterface {
    public void insert(DataBuku b);
    public void update(DataBuku b);
    public void delete(int id);
    public List<DataBuku> getALl();
}
