package aula20201019.ag;

import java.util.Random;

public class AppOláMundoRandômico {

    //"Hello World";
    //"Hd23X  orLd"  fitness=4
    //"Hd23X Waaaa"  fitness=3
    //"aaaaa Waaaa"  fitness=2    


    public static void main(String[] args) {
        final String objetivo = "Hello World";
        final String alfabeto = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ ";
        Random r = new Random();        
        while (true) {
            final char[] caracteres = new char[objetivo.length()];
            for (int i = 0; i < 11; i++) {
                final int caracterSorteado = Math.abs(r.nextInt())%53;
                caracteres[i] = alfabeto.charAt(caracterSorteado);
            }
            try {
                Thread.sleep(10);
            } catch (Exception e) {
            }
            final String indivíduoGerado = new String(caracteres);
            System.out.println(indivíduoGerado);
            if (indivíduoGerado.equals(objetivo)) {
                break;
            }
        }    
        System.out.println("Acabou!");    
    }    
}
