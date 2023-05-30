/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import DAOdataperpus.dataperpusDAO;
import DAOImplement.databukuimplement;
import model.*;
import responsipbo.MainView;
/**
 *
 * @author PC PRAKTIKUM
 */
public class dataperpuscontroller {
    MainView frame;
    databukuimplement impldataperpus;
    List<dataperpus>dp;

    public dataperpuscontroller(MainView frame) {
        this.frame = frame;
        impldataperpus = new dataperpusDAO();
        dp = impldataperpus.getALL();
    }
    public void isitabel(){
        dp = impldataperpus.getALL();
        modeltabeldataperpus mp = new modeltabeldataperpus(dp);
        frame.getTabelDataperpus().setModel(mp);
    }
    
    public void insert(){
        dataperpus dp = new dataperpus();
        dp.setJudul(frame.getJudul().getText());
        dp.setGenre(frame.getGenre().getText());
        dp.setPenulis(frame.getPenulis().getText());
        dp.setPenerbit(frame.getPenerbit().getText());
        dp.setLokasi(frame.getLokasi().getText());
        dp.setStock(Integer.parseInt(frame.getStock().getText()));
        impldataperpus.insert(dp);
    }
    
    public void update(){
        dataperpus dp = new dataperpus();
        dp.setJudul(frame.getJudul().getText());
        dp.setGenre(frame.getGenre().getText());
        dp.setPenulis(frame.getPenulis().getText());
        dp.setPenerbit(frame.getPenerbit().getText());
        dp.setLokasi(frame.getLokasi().getText());
        dp.setStock(Integer.parseInt(frame.getStock().getText()));
        dp.setId(Integer.parseInt(frame.getId().getText()));
        impldataperpus.update(dp);
    }
    
    public void delete(){
        int id = Integer.parseInt(frame.getId().getText());
        impldataperpus.delete(id);
    }
    
}
