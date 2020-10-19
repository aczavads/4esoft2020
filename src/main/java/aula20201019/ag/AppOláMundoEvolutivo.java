package aula20201019.ag;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class AppOláMundoEvolutivo {
    private static final String OBJETIVO = "Hello World";
    private static final String ALFABETO = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ ";


    private static class IndivíduoPopulação {
        int fitness;
        String indivíduo;

        public IndivíduoPopulação(int fitness, String indivíduo) {
            this.fitness = fitness;
            this.indivíduo = indivíduo;
        }
        @Override
        public String toString() {
            return "Indivíduo = " + indivíduo + ", fitness = " + fitness;
        }

    }
    public static void main(String[] args) {
        List<IndivíduoPopulação> população = gerarPopulaçãoInicial(OBJETIVO, ALFABETO, 1_000);
        Collections.sort(população, Comparator.<IndivíduoPopulação>comparingInt(ip -> ip.fitness).reversed());

        for (IndivíduoPopulação indivíduoPopulação : população) {
            System.out.println(indivíduoPopulação);
        }



    }

    private static int fitnessCaracteresCorretos(String indivíduo, final String OBJETIVO) {
        int caracteresCorretos = 0;
        for (int i = 0; i < OBJETIVO.length(); i++) {
            if (indivíduo.charAt(i) == OBJETIVO.charAt(i)) {
                caracteresCorretos++;
            }
        }
        return caracteresCorretos;
    }

    private static List<IndivíduoPopulação> gerarPopulaçãoInicial(final String OBJETIVO, final String ALFABETO,
            int tamanhoDesejado) {
        final List<IndivíduoPopulação> população = new LinkedList<>();
        final Random r = new Random();
        for (int tamanhoAtual = 0; tamanhoAtual < tamanhoDesejado; tamanhoAtual++) {
            final char[] caracteres = new char[OBJETIVO.length()];
            for (int i = 0; i < 11; i++) {
                final int caracterSorteado = Math.abs(r.nextInt()) % 53;
                caracteres[i] = ALFABETO.charAt(caracterSorteado);
            }
            final String indivíduo = new String(caracteres);
            final IndivíduoPopulação indivíduoGerado = new IndivíduoPopulação(fitnessCaracteresCorretos(indivíduo, OBJETIVO), indivíduo) ;
            população.add(indivíduoGerado);
        }

        return população;
    }

}
