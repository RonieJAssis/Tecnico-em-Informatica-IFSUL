
package br.edu.ifsul.dabd.model;
public class Leitos {
         private int codigo;
         private String numero,descricao;
         private Andares andar;

    public Leitos() {

    }

    public Andares getAndar() {
        return andar;
    }

    public void setAndar(Andares andar) {
        this.andar = andar;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
                
         
         
         
         
         
         
         
         
         
}
