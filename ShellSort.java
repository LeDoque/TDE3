public class ShellSort {
    public static void main(String[] args) {
        int[] vetor = new int[10000];

        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = (int) (Math.random() * vetor.length);
            System.out.println(vetor[i]);
        }

        long startTime = System.nanoTime();
        int trocas = 0;
        int iteracoes = 0;

        int h = 1;
        int n = vetor.length;
        while (h < n) {
            h = h * 3 + 1;
        }
        h = (int) (h / 3);

        int c, j;
        while (h > 0) {
            for (int i = h; i < n; i++) {
                c = vetor[i];
                j = i;
                iteracoes++;
                while (j >= h && vetor[j - h] > c) {
                    vetor[j] = vetor[j - h];
                    j = j - h;
                    trocas++;
                }
                vetor[j] = c;

            }
            h = h / 2;
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
