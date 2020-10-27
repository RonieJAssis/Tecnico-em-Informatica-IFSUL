
package aula11;
public abstract class Pessoas {
    
    private String nome;
    private int idade;
    private String Sexo;   

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String Sexo) {
        this.Sexo = Sexo;
    }

    public void fazerAniversario(){
        this.setIdade(this.getIdade()+1);
        
    }

    @Override
    public String toString() {
        return "Pessoas{" + "nome=" + nome + ", idade=" + idade + ", Sexo=" + Sexo + '}';
    }
    
}