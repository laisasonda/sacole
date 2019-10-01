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

import java.util.List;

import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrador
 */
public class ControladorSacole {

    public static void inserir(ManutencaoSacole man) {
        Sacole objeto = new Sacole();
        objeto.setNrserie(Integer.parseInt(man.jtfNrserie.getText()));
        objeto.setPreco(Double.parseDouble(man.jtfPreco.getText()));
        objeto.setDatavalidade(LocalDate.parse(man.jtfDatavalidade.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        objeto.setSabor(man.jtfSabor.getText());

        boolean resultado = DaoSacole.inserir(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
            if (man.listagem != null) {
                atualizarTabela(man.listagem.tabela); //atualizar a tabela da listagem
            }
            man.dispose();//fechar a tela da manutenção
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
    }

    public static void alterar(ManutencaoSacole man) {
        Sacole objeto = new Sacole();
        //definir todos os atributos
        objeto.setCodigo(Integer.parseInt(man.jtfCodigo.getText()));
        objeto.setNrserie(Integer.parseInt(man.jtfNrserie.getText()));
        objeto.setPreco(Double.parseDouble(man.jtfPreco.getText()));
        objeto.setDatavalidade(LocalDate.parse(man.jtfDatavalidade.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        objeto.setSabor(man.jtfSabor.getText());

        boolean resultado = DaoSacole.alterar(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
            if (man.listagem != null) {
                atualizarTabela(man.listagem.tabela); //atualizar a tabela da listagem
            }
            man.dispose();//fechar a tela da manutenção
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
    }

    public static void excluir(ManutencaoSacole man) {
        Sacole objeto = new Sacole();
        objeto.setCodigo(Integer.parseInt(man.jtfCodigo.getText())); //só precisa definir a chave primeira

        boolean resultado = DaoSacole.excluir(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
            if (man.listagem != null) {
                atualizarTabela(man.listagem.tabela); //atualizar a tabela da listagem
            }
            man.dispose();//fechar a tela da manutenção
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
    }

    public static void atualizarTabela(JTable tabela) {
        DefaultTableModel modelo = new DefaultTableModel();
        //definindo o cabeçalho da tabela
        modelo.addColumn("Codigo");
        modelo.addColumn("Nr de Série");
        modelo.addColumn("Preco");
        modelo.addColumn("Data de validade");
        modelo.addColumn("Sabor");
        List<Sacole> resultados = DaoSacole.consultar();
        for (Sacole objeto : resultados) {
            Vector linha = new Vector();

            //definindo o conteúdo da tabela
            linha.add(objeto.getCodigo());
            linha.add(objeto.getNrserie());
           linha.add(objeto.getPreco());
           linha.add(objeto.getDatavalidade().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            linha.add(objeto.getSabor());

            modelo.addRow(linha); //adicionando a linha na tabela
        }
        tabela.setModel(modelo);

    }

    public static void atualizaCampos(ManutencaoSacole man, int pk) {
        Sacole objeto = DaoSacole.consultar(pk);
        //Definindo os valores do campo na tela (um para cada atributo/campo)
        man.jtfCodigo.setText(objeto.getCodigo().toString());
        man.jtfNrserie.setText(objeto.getNrserie().toString());
        man.jtfPreco.setText(objeto.getPreco().toString());
        man.jtfDatavalidade.setText(objeto.getDatavalidade().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        man.jtfSabor.setText(objeto.getSabor());

        man.jtfCodigo.setEnabled(false); //desabilitando o campo código
        man.btnAdicionar.setEnabled(false); //desabilitando o botão adicionar
    }
}
