import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        ComparacaoBusca comparacao = new ComparacaoBusca();
        System.out.println("Algoritmo TamanhoEntrada TempoMedio");

        try {
            BufferedReader reader = new BufferedReader(
                                        new InputStreamReader(System.in));
            String line = "";
            while ((line = reader.readLine()) != null) {
                int[] entrada = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
                // executando 30x para tirar a mediana.
                
                long[] obs = new long[30];
                for (int i = 0; i < 30; i++) {
                    // medindo tempo
                    long start = System.nanoTime();
                    comparacao.buscaBinariaIterativa(entrada, -123456);
                    long end = System.nanoTime();
                    long time = end - start;
                    obs[i] = time;
                }

                Arrays.sort(obs);
                System.out.println("iterativa " +  entrada.length + " "+ (obs[14]));

                obs = new long[30];
                for (int i = 0; i < 30; i++){
                  long start = System.nanoTime();
                  comparacao.buscaBinariaRecursiva(entrada, 0, entrada.length - 1, -123456);
                  long end = System.nanoTime();
                  long time = end - start;
                  obs[i] = time;
                }
                Arrays.sort(obs);
                System.out.println("recursiva " +  entrada.length + " "+ (obs[14]));

           }

       } catch (Exception e) {}
    }   
}
