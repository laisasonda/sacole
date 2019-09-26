/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import tela.manutencao.ManutencaoSacole;
import dao.DaoSacole;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import modelo.Sacole;
import tela.manutencao.ManutencaoSacole;


/**
 *
 * @author Administrador
 */
public class ControladorSacole {

   public static void inserir(ManutencaoSacole man){
        Sacole objeto = new Sacole();
        objeto.setNrserie(Integer.parseInt(man.jtfNrserie.getText()));
        objeto.setPreco(Double.parseDouble(man.jtfPreco.getText()));
        objeto.setDatavalidade(LocalDate.parse(man.jtfDatavalidade.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        objeto.setSabor(man.jtfSabor.getText());
        
        boolean resultado = DaoSacole.inserir(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
}

    public static void alterar(ManutencaoSacole aThis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
