/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOImplement;

import java.util.*;
import model.*;
/**
 *
 * @author PC PRAKTIKUM
 */
public interface databukuimplement {
    public void insert(dataperpus p);
    public void update(dataperpus p);
    public void delete(int id);
    public List<dataperpus>getALL();
}
