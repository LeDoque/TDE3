public class InsertSort {
    public static void main(String[] args) {
        int[] vetor = new int[10000];

        for(int i = 0; i < vetor.length; i++) {
            vetor[i] = (int) (Math.random() * vetor.length);
            System.out.println(vetor[i]);
        }

        long startTime = System.nanoTime();
        int trocas = 0;
        int iteracoes = 0;

        int holder, j;
        for(int i = 1; i < vetor.length; i++){
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
        for (int i = 0; i < vetor.length; i++) {
            System.out.println(vetor[i]);
        }

        System.out.println("Tempo de Execução: " + tempoDeExecucao + " ns");
        System.out.println("Número de Trocas: " + trocas);
        System.out.println("Número de Iterações: " + iteracoes);
    }
}
