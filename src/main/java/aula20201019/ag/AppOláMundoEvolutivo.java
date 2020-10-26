package aula20201019.ag;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class AppOláMundoEvolutivo {
    private static final String OBJETIVO = "Formandos ESOFT";
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
        public int getFitness() {
            return fitness;
        }

    }
    public static void main(String[] args) {
        List<IndivíduoPopulação> população = gerarPopulaçãoInicial(OBJETIVO, ALFABETO, 10);
        população.sort(Comparator.comparing(IndivíduoPopulação::getFitness).reversed());
        //Collections.sort(população, Comparator.<IndivíduoPopulação>comparingInt(ip -> ip.fitness).reversed());

        while (true) {
            listarPopulação(população);    
            população = gerarPopulaçãoDescendente(população);        
            população.sort(Comparator.comparing(IndivíduoPopulação::getFitness).reversed());
            listarPopulação(população);
            if (população.get(0).fitness == OBJETIVO.length()) {
                System.out.println("Achou!!!!!!!!");
                break;
            }
            System.out.println("=========================================== " + System.currentTimeMillis());
            try {
                //Thread.sleep(100);
            } catch (Exception e) {
            }

        }

    }
    
    private static List<IndivíduoPopulação> gerarPopulaçãoDescendente(List<IndivíduoPopulação> populaçãoInicial) {
        List<IndivíduoPopulação> populaçãoDescendente = new LinkedList<>(populaçãoInicial);

        final int limite = (int)(populaçãoInicial.size()/2);
        for (int i = 0; i < limite; i = i + 2) {
            final String parceiroA = populaçãoInicial.get(i).indivíduo;
            final String parceiroB = populaçãoInicial.get(i+1).indivíduo;

            final int geneDoMeio = (int)(parceiroA.length()/2);
            String derivadoA = parceiroA.substring(0, geneDoMeio) + parceiroB.substring(geneDoMeio);
            final String derivadoB = parceiroB.substring(0, geneDoMeio) + parceiroA.substring(geneDoMeio);

            //prevendo uma mutação...
            if (System.currentTimeMillis()%2 == 0) {
                System.out.println("Mutação!");
                Random r = new Random();
                final int pontoDaMutaçao = Math.abs(r.nextInt()) % derivadoA.length();
                char[] cromossomoDeA = derivadoA.toCharArray();
                cromossomoDeA[pontoDaMutaçao] = sortearCaracter();

                derivadoA = new String(cromossomoDeA);
            }

            System.out.println(derivadoA);
            System.out.println(derivadoB);
            populaçãoDescendente.set(populaçãoDescendente.size()-1-i, new IndivíduoPopulação(fitnessCaracteresCorretos(derivadoA, OBJETIVO), derivadoA));
            populaçãoDescendente.set(populaçãoDescendente.size()-1-(i+1), new IndivíduoPopulação(fitnessCaracteresCorretos(derivadoB, OBJETIVO), derivadoB));

        }
        return populaçãoDescendente;
    }

    public static void listarPopulação(List<IndivíduoPopulação> população) {
        System.out.println("---- população ----");
        população.forEach(System.out::println);
        System.out.println("----   FIM     ----");
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

    private static char sortearCaracter() {
        final Random r = new Random();
        final int caracterSorteado = Math.abs(r.nextInt()) % 53;
        return ALFABETO.charAt(caracterSorteado);
    }
    private static List<IndivíduoPopulação> gerarPopulaçãoInicial(final String OBJETIVO, final String ALFABETO,
            int tamanhoDesejado) {
        final List<IndivíduoPopulação> população = new LinkedList<>();
        for (int tamanhoAtual = 0; tamanhoAtual < tamanhoDesejado; tamanhoAtual++) {
            final char[] caracteres = new char[OBJETIVO.length()];
            for (int i = 0; i < 11; i++) {
                caracteres[i] = sortearCaracter();
            }
            final String indivíduo = new String(caracteres);
            final IndivíduoPopulação indivíduoGerado = new IndivíduoPopulação(fitnessCaracteresCorretos(indivíduo, OBJETIVO), indivíduo) ;
            população.add(indivíduoGerado);
        }

        return população;
    }

}
