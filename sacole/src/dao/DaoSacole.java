/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import modelo.Sacole;

/**
 *
 * @author Administrador
 */
public class DaoSacole {
    public static boolean inserir(Sacole objeto) {
        String sql = "INSERT INTO sacole (nrserie, preco, datavalidade, sabor) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, objeto.getNrserie());
            ps.setDouble(2, objeto.getPreco());
            ps.setDate(3, Date.valueOf(objeto.getDatavalidade()));
              ps.setString(4, objeto.getSabor());
            ps.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
    public static void main(String[] args) {
        Sacole objeto = new Sacole();
        objeto.setNrserie(4);
        objeto.setPreco(2.00);
        objeto.setDatavalidade(LocalDate.parse("11/01/1988", DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        objeto.setSabor("Morango");
        
        
        boolean resultado = inserir(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
    }
     public static boolean alterar(Sacole objeto) {
        String sql = "UPDATE sacole SET nrserie = ?, preco = ?, datavalidade = ?, sabor = ? WHERE codigo=?";
        try {
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, objeto.getNrserie());
            ps.setDouble(2, objeto.getPreco());
            ps.setDate(3, Date.valueOf(objeto.getDatavalidade()));
            ps.setString(4, objeto.getSabor());
            ps.setInt(5, objeto.getCodigo());
            ps.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
    
}
