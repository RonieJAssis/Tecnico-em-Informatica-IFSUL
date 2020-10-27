/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula5;

/**
 *
 * @author a
 */
public class ContaBanco {
    
    public int numConta;
    protected String tipo;
    private String nome;
    private float saldo;
    private boolean status;

    public ContaBanco() {
        this.saldo=0f;
        this.status=false;
    }
    
    public void estadoAtual(){
        System.out.println("---------------------------------------");
        System.out.println("Conta: "+this.getNumConta());
        System.out.println("Dono: "+this.getNome());
        System.out.println("Tipo: "+this.getTipo());
        System.out.println("Saldo: "+this.getSaldo()+"R$");
        System.out.println("Status "+this.getStatus());
        System.out.println("---------------------------------------");
    }
    
    public void abrirConta(String t){
        switch (t)
        {
            case "cc":
                this.setTipo(t);
                this.setSaldo(this.getSaldo()+50f);
                this.setStatus(true);
                 System.out.println("Conta aberta com sucesso!");
                break;
            case "cp":
                this.setTipo(t);
                this.setSaldo(this.getSaldo()+150f);
                this.setStatus(true);
                System.out.println("Conta aberta com sucesso!");
                break;
            default:
                System.out.println("Tipo de conta invalido");
                
        }
    }
    public void fecharConta(){
        
        if(this.getSaldo() == 0){
            this.setStatus(false);
            System.out.println("Conta fechada com sucesso!");
        }
        else{
            System.out.println("Saldo diferente de 0, não é possivel fechar a conta");
        }
        
    }
    public void depositar(float v){
      if(this.getStatus()) {
          this.setSaldo(this.getSaldo() + v);
          System.out.println("Deposito de "+v+"R$ realizado com sucesso na conta de "+this.getNome());
      } 
      else{
          System.out.println("Conta fechada,impossivel depositar!");
      }
    }
    public void sacar(float v){
           if(this.getStatus()) {
               if(this.getSaldo() >= v){
                   
                  this.setSaldo(this.getSaldo() - v);
                   System.out.println("Saque de "+v+"R$ realizado com sucessona conta de "+this.getNome());
               }
               else{
                   System.out.println("saldo insuficiente");
               }
      } 
      else{
          System.out.println("Conta fechada,impossivel sacar!");
      }
        
    }
    public void pagarMen(){
      if(this.getStatus()){
          if(this.getTipo()=="cc"){
              this.setSaldo(saldo - 12f);
          }
          else {
             this.setSaldo(saldo - 20f); 
          }
      } 
      else{
          System.out.println("Conta fechada,não é possivel pagar mensalidade!");
      }
    }

    public int getNumConta() {
        return numConta;
    }

    public String getTipo() {
        return tipo;
    }

    public String getNome() {
        return nome;
    }

    public float getSaldo() {
        return saldo;
    }

    public boolean getStatus() {
        return status;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    
    
    
}
