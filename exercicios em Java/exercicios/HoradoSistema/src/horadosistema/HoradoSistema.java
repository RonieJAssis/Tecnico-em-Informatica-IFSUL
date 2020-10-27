package horadosistema;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Date;
import java.util.Locale;

public class HoradoSistema {
    public static void main(String[] args) {
        Date relogio = new Date();
        System.out.print("A hora do sistema é: ");
        System.out.println(relogio.toString());
        
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        System.out.println("A resolução da sua máquina é: " +d.width + " x " +d.height);
        
        Locale idioma = Locale.getDefault();
        System.out.print("O idioma do seu sistema está configurado para: ");
        System.out.println(idioma.getDisplayLanguage());
    }
}
