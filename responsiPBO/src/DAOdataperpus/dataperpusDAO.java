/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOdataperpus;

import java.sql.*;
import java.util.*;
import koneksi.connector;
import model.*;
import DAOImplement.databukuimplement;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author PC PRAKTIKUM
 */
public class dataperpusDAO implements databukuimplement {

    Connection connection;
    final String select = "select * from dataperpus;";
    final String insert = "INSERT INTO dataperpus(judul,genre,penulis,penerbit,lokasi,stock)VALUES (?,?,?,?,?,?);";
    final String update = "update dataperpus set judul=?, genre=?, penulis=?, penerbit=?, lokasi=?, stock=? where id=?";
    final String delete = "delete from dataperpus where id=?";
    public dataperpusDAO(){
        connection = connector.connection();
    }
    @Override
    public void insert(dataperpus p) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(insert,statement.RETURN_GENERATED_KEYS);
            statement.setString(1, p.getJudul());
            statement.setString(2, p.getGenre());
            statement.setString(3, p.getPenulis());
            statement.setString(4, p.getPenerbit());
            statement.setString(5, p.getLokasi());
            statement.setInt(5, p.getStock());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            while(rs.next()){
                p.setId(rs.getInt(1));
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void update(dataperpus p) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(update);
            statement.setString(1, p.getJudul());
            statement.setString(2, p.getGenre());
            statement.setString(3, p.getPenulis());
            statement.setString(4, p.getPenerbit());
            statement.setString(5, p.getLokasi());
            statement.setInt(5, p.getStock());
            statement.executeUpdate();
 
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void delete(int id) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(delete);
            statement.setInt(1, id);
            statement.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public List<dataperpus> getALL() {
        List<dataperpus>dp = null;
        try{
            dp = new ArrayList<dataperpus>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while(rs.next()){
                dataperpus pp = new dataperpus();
                pp.setId(rs.getInt("id"));
                pp.setJudul(rs.getString("judul"));
                pp.setGenre(rs.getString("genre"));
                pp.setPenulis(rs.getString("penulis"));
                pp.setPenerbit(rs.getString("penerbit"));
                pp.setLokasi(rs.getString("lokasi"));
                pp.setStock(rs.getInt("stock"));
                dp.add(pp);
            }
        }catch(SQLException ex){
            Logger.getLogger(dataperpusDAO.class.getName()).log(Level.SEVERE, null,ex);
        }
        return dp;
    }
    
}
