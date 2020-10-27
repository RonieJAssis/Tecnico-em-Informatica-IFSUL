
package br.edu.ifsul.dabd.clinica;

import br.edu.ifsul.dabd.controle.Controle;

/**
 *
 * @author Telmo Junior
 */
public class Principal {
    private Controle controle;
    
    public Principal(){
        this.controle = new Controle();
    }

    //esse metódo é chamado automaticamente ao executarmos o projeto
    public static void main(String[] args) {
        
        new Principal();
    }
    
}
