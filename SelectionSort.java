import java.sql.SQLOutput;

public class SelectionSort {
    public static void main(String[] args) {
        int tamanho = 10;
        int[] vetor = new int[tamanho];

        for(int i = 0; i < tamanho; i++) {
            vetor[i] = (int) (Math.random() * tamanho);
            System.out.println(vetor[i]);
        }

        long startTime = System.nanoTime();
        int trocas = 0;
        int iteracoes = 0;

        int menor, holder;
        for(int i = 0; i < tamanho; i++) {
            menor = i;
            for(int j = i + 1; j < tamanho; j++){
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
        long endTime = System.nanoTime();
        long tempoDeExecucao = endTime - startTime;

        System.out.println("\n\n\nVetor ordenado");
        for (int i = 0; i < tamanho; i++) {
            System.out.println(vetor[i]);
        }

        System.out.println("Tempo de Execução: " + tempoDeExecucao + " ns");
        System.out.println("Número de Trocas: " + trocas);
        System.out.println("Número de Iterações: " + iteracoes);
    }
}
