/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import models.Item;

/**
 *
 * @author ADM_House
 */
public class ItemDAO {
    
    public void armazenaDados(Item item) throws SQLException{
        Connection con =  ConnectionFactory.getConnection();
        PreparedStatement stmt  = null;
        String sql = "insert into item (item_nome, item_descricao, item_preco, item_dataentrada, item_quantidade) values (?,?,?,?,?);";
                
                
        try{
            stmt = con.prepareStatement(sql);
            
            stmt.setString(1, item.getNome());
            stmt.setString(2, item.getDescricao());
            stmt.setString(3, item.getPreco());
            stmt.setString(4, item.getDataEntrada());
            stmt.setString(5, item.getQuantidade());
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso !");
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Erro ao tentar salvado o item: " + e.getMessage());
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        
    }
    
    
    public void selecionarItens(){
        
          Connection con =  ConnectionFactory.getConnection();
        PreparedStatement stmt  = null;
        String sql = "select item_id, item_nome, item_preco, item_dataentrada, item_quantidade from item;";
                
                
        try{
            stmt = con.prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery();
            //DefaultTableModel itemTabela = (DefaultTableModel) tbLista.get
            
            DefaultTableModel itemTabela = new DefaultTableModel();
            
            itemTabela.addColumn("Nome");
            itemTabela.addColumn("Descrição");
            itemTabela.addColumn("Preço");
            itemTabela.addColumn("Data Entrada");
            itemTabela.addColumn("Quantidade");
            
            stmt.executeUpdate();
            
                        
            rs.getString(sql);
            
            JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso !");
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Erro ao tentar salvado o item: " + e.getMessage());
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        
    }
    
}
