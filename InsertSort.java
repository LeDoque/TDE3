public class InsertSort {
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

        int holder, j;
        for(int i = 1; i < tamanho; i++){
            holder = vetor[i];
            j = i -1;
            iteracoes++;
            while(j >= 0 && vetor[j] > holder){
                vetor[j + 1] = vetor[j];
                j--;
                trocas++;
            }
            vetor[j + 1] = holder;
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
