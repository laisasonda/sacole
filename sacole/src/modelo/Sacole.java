/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.time.LocalDate;

/**
 *
 * @author Administrador
 */
public class Sacole {
   private Integer codigo;
   private Integer nrserie;
   private Double preco;
   private LocalDate datavalidade;
   private String sabor;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getNrserie() {
        return nrserie;
    }

    public void setNrserie(Integer nrserie) {
        this.nrserie = nrserie;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public LocalDate getDatavalidade() {
        return datavalidade;
    }

    public void setDatavalidade(LocalDate datavalidade) {
        this.datavalidade = datavalidade;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    @Override
    public String toString() {
        return "Sacole{" + "sabor=" + sabor + '}';
    }


   
   
    
}
