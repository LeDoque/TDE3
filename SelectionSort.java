import java.sql.SQLOutput;

public class SelectionSort {
    public static void main(String[] args) {
        int[] vetor = new int[10000];

        for(int i = 0; i < vetor.length; i++) {
            vetor[i] = (int) (Math.random() * vetor.length);
            System.out.println(vetor[i]);
        }

        long startTime = System.currentTimeMillis();
        int menor, holder;
        int trocas = 0;
        int iteracoes = 0;

        for(int i = 0; i < vetor.length; i++) {
            menor = i;
            for(int j = i + 1; j < vetor.length; j++){
                iteracoes++;
                if (vetor[j] < vetor[menor]){
                    menor = j;
                }
            }
            holder = vetor[menor];
            vetor[menor] = vetor[i];
            vetor[i] = holder;
            trocas++;
        }
        long endTime = System.currentTimeMillis();
        long tempoDeExecucao = endTime - startTime;

        System.out.println("\n\n\nVetor ordenado");
        for (int i = 0; i < vetor.length; i++) {
            System.out.println(vetor[i]);
        }

        System.out.println("Tempo de Execução: " + tempoDeExecucao + " ms");
        System.out.println("Número de Trocas: " + trocas);
        System.out.println("Número de Iterações: " + iteracoes);
    }
}
