
package trabfut;

import javax.swing.JOptionPane;

public class Campeonato {
   private Time [] t=new Time[4];
   private int[] p= new int [4];
   private Partida[] pa= new Partida[2];
   private String ganhadorR="";
   private String nome;
   private int pG=0;

    public Time[] getT() {
        return t;
    }

    public int[] getP() {
        return p;
    }

    public Campeonato(Time t1, Time t2,Time t3,Time t4) {
        t[0]=t1;
        t[1]=t2;
        t[2]=t3;
        t[3]=t4;
       
    }
    public void Rodada(int i){
        if(i == 1){
            int pont=t[0].getOverwall();
            pa[0] = new Partida (this, t[0],t[1]);
            pa[0].comecar();
            if (pont+1==(t[0].getOverwall())){
                p[0]++;
                p[1]++;
            }
            else if (pont>t[0].getOverwall()) {
                p[1]+=3;
            }
            else{
                p[0]+=3;
            }
            
    //------------------------------------------------------------------        
            
            
            int pont2=t[2].getOverwall();
            pa[1] = new Partida (this, t[2],t[3]);
            pa[1].comecar();
            if (pont2+1==(t[2].getOverwall())){
                p[2]++;
                p[3]++;
                
            }
            else if (pont2>t[2].getOverwall()) {
                p[3]+=3;
            }
            else{
                p[2]+=3;
            }
        }
        //==========================================================================
            else if(i == 2){
            int pont=t[0].getOverwall();
            pa[0] = new Partida (this, t[0],t[2]);
            pa[0].comecar();
            if (pont+1==(t[0].getOverwall())){
                p[0]++;
                p[2]++;      
            }
            else if (pont>t[0].getOverwall()) {
                p[2]+=3;
            }
            else{
                p[0]+=3;
            }
            
    //------------------------------------------------------------------        
            
            
            int pont2=t[1].getOverwall();
            pa[1] = new Partida (this, t[1],t[3]);
            pa[1].comecar();
            if (pont2+1==(t[1].getOverwall())){
                p[1]++;
                p[3]++;     
            }
            else if (pont2>t[1].getOverwall()) {
                p[3]+=3;
            }
            else{
                p[1]+=3;
            }
        }
        //==========================================================================
            else if(i == 3){
            int pont=t[0].getOverwall();
            pa[0] = new Partida (this, t[0],t[3]);
            pa[0].comecar();
            if  (pont+1==(t[0].getOverwall())){
                p[0]++;
                p[3]++;                           
            }
            else if (pont>t[0].getOverwall()) {
                p[3]+=3;
            }
            else{
                p[0]+=3;
            }
            
    //------------------------------------------------------------------        
            
            
            int pont2=t[1].getOverwall();
            pa[1] = new Partida (this, t[1],t[2]);
            pa[1].comecar();
            if (pont2+1==(t[1].getOverwall())){
                p[1]++;
                p[2]++;        
            }
            else if (pont2>t[1].getOverwall()) {
                p[2]+=3;
            }
            else{
                p[1]+=3;
            }
        }
        //==========================================================================
            else if(i == 4){
            int pont=t[1].getOverwall();
            pa[0] = new Partida (this, t[1],t[0]);
            pa[0].comecar();
            if (pont+1==(t[1].getOverwall())){
                p[0]++;
                p[1]++;                  
            }
            else if (pont>t[1].getOverwall()) {
                p[0]+=3;
            }
            else{
                p[1]+=3;
            }
            
    //------------------------------------------------------------------        
            
            
            int pont2=t[3].getOverwall();
            pa[1] = new Partida (this, t[3],t[2]);
            pa[1].comecar();
            if (pont2+1==(t[3].getOverwall())){
                p[2]++;
                p[3]++;                   
            }
            else if (pont2>t[3].getOverwall()) {
                p[2]+=3;
            }
            else{
                p[3]+=3;
            }
        }
        //==========================================================================
            else if(i == 5){
            int pont=t[2].getOverwall();
            pa[0] = new Partida (this, t[2],t[0]);
            pa[0].comecar();
            if (pont+1==(t[2].getOverwall())){
                p[0]++;
                p[2]++;                   
            }
            else if (pont>t[2].getOverwall()) {
                p[0]+=3;
            }
            else{
                p[2]+=3;
            }
            
    //------------------------------------------------------------------        
            
            
            int pont2=t[3].getOverwall();
            pa[1] = new Partida (this, t[3],t[1]);
            pa[1].comecar();
            if (pont2+1==(t[3].getOverwall())){
                p[1]++;
                p[3]++;                   
            }
            else if (pont2>t[3].getOverwall()) {
                p[1]+=3;
            }
            else{
                p[3]+=3;
            }
        }
        //==========================================================================
            else if(i == 6){
            int pont=t[3].getOverwall();
            pa[0] = new Partida (this, t[3],t[0]);
            pa[0].comecar();
            if (pont+1==(t[3].getOverwall())){
                p[0]++;
                p[3]++;                    
            }
            else if (pont>t[3].getOverwall()) {
                p[0]+=3; 
            }
            else{
                p[3]+=3;
            }
            
    //------------------------------------------------------------------        
            
            
            int pont2=t[2].getOverwall();
            pa[1] = new Partida (this, t[2],t[1]);
            pa[1].comecar();
            if (pont2+1==(t[2].getOverwall())){
                p[1]++;
                p[2]++;                    
            }
            else if (pont2>t[2].getOverwall()) {
                p[1]+=3;
            }
            else{
                p[2]+=3;
            }
        }
    }
    public void tabela(){
        String aux="";
        for (int i = 0; i < 4; i++) {
            if (this.pG<p[i]) {
                this.pG=p[i];
                this.ganhadorR=t[i].getNome();
            }
        }
        for (int i = 0; i < 4; i++) {
            aux+=t[i].getNome()+"-"+p[i]+"\n";
        }
        JOptionPane.showMessageDialog(null, aux);
    }
  public void começar(){
      for (int i = 1; i < 6; i++) {
          this.Rodada(i);
          this.tabela();
          for (int j = 0; j < 4; j++) {
              JOptionPane.showMessageDialog(null,"Treino do time "+t[j].getNome());
              for (int k = 0; k < 3; k++) {
                t[j].treinar();  
              }
          }
      }
      JOptionPane.showConfirmDialog(null,"O ganhador foi "+this.ganhadorR+" com "+this.pG+" pontos!");
  }

    public String getNome() {
        return nome;
    }
  

    @Override
    public String toString() {
        return this.getNome();
    }
  
}

