package aula07e08;

public class Lutador {
    
private String Nome;
private String Nacionalidade;
private int Idade;
private float Altura;
private float Peso;
private String Categoria;
private int Vitorias;
private int derrota;
private int empate;

    public Lutador(String Nome, String Nacionalidade, int Idade, float Altura, float Peso, int Vitorias, int derrota, int empate) {
        this.Nome = Nome;
        this.Nacionalidade = Nacionalidade;
        this.Idade = Idade;
        this.Altura = Altura;
        this.setPeso(Peso);
        this.Vitorias = Vitorias;
        this.derrota = derrota;
        this.empate = empate;
        
        
        
    }

    

    public String getNome() {
        return Nome;
    }

    public String getNacionalidade() {
        return Nacionalidade;
    }

    public int getIdade() {
        return Idade;
    }

    public float getAltura() {
        return Altura;
    }

    public float getPeso() {
        return Peso;
    }

    public String getCategoria() {
        return Categoria;
    }

    public int getVitorias() {
        return Vitorias;
    }

    public int getDerrota() {
        return derrota;
    }

    public int getEmpate() {
        return empate;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public void setNacionalidade(String Nacionalidade) {
        this.Nacionalidade = Nacionalidade;
    }

    public void setIdade(int Idade) {
        this.Idade = Idade;
    }

    public void setAltura(float Altura) {
        this.Altura = Altura;
    }

    public void setPeso(float Peso) {
        this.Peso = Peso;
        this.setCategoria();
    }

    private void setCategoria() {
        if(Peso <52.2 || Peso > 120.2){
           this.Categoria = "Invalido";
        }
        else if(Peso<=70.3){
            this.Categoria = "Leve";
        }
        else if(Peso<=83.9){
            this.Categoria ="Medio";
        }
        else if(Peso<=120.2){
            this.Categoria ="Pesado";
        }
    }

    public void setVitorias(int Vitorias) {
        this.Vitorias = Vitorias;
    }

    public void setDerrota(int derrota) {
        this.derrota = derrota;
    }

    public void setEmpate(int empate) {
        this.empate = empate;
    }
    
    public void apresentar(){
        System.out.println("Lutador: "+this.getNome());
        System.out.println("Origem: "+this.getNacionalidade());
        System.out.println(this.getIdade()+" anos");
        System.out.println(this.getAltura()+"m de altura");
        System.out.println("Pesando: "+this.getPeso()+"kg");
        System.out.println("Ganhou:"+this.getVitorias());
        System.out.println("Perdeu: "+this.getDerrota());
        System.out.println("Empatou: "+this.getEmpate());
    }
    public void status(){
        System.out.println(this.getNome());
        System.out.println("é um peso: "+this.getCategoria());
        System.out.println(this.getVitorias()+" vitorias");
        System.out.println(this.getDerrota()+" derrotas");
        System.out.println(this.getEmpate()+" empates");
    }
    public void ganharLuta(){
       this.setVitorias(this.getVitorias()+ 1); 
    }
    public void perderLuta(){
       this.setDerrota(this.getDerrota()+1);
    }
    public void empatarLuta(){
      this.setEmpate(this.getEmpate()+1);   
    }
}
