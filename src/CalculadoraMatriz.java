public class CalculadoraMatriz {
    
    /*
     * Imprime no terminal a determinada matriz.
     */
    public void mostrar(int matriz[][]) {
        for (int linha = 0; linha < matriz.length; linha++) {
            for (int coluna = 0; coluna < matriz[0].length; coluna++) {
                System.out.printf(" %d ", matriz[linha][coluna]);
            }
            System.out.println("");
        }
    }

    /*
     * Verifica se as duas matrizes passadas são iguais.
     */
    public boolean equals(int matriz1[][], int matriz2[][]) {
        // Caso de algum erro, provavel que seja de index, então, não iguais
        try {
            // Verifica cada elemento das matrizes se são iguais, caso contrario retorna falso
            for (int linha = 0; linha < matriz1.length; linha++) {
                for (int coluna = 0; coluna < matriz2[0].length; coluna++) {
                    if (matriz1[linha][coluna] != matriz2[linha][coluna]) {
                        return false;
                    }
                }
            }
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    /*
     * Soma duas matrizes passadas.
     */
    public int[][] somar(int matriz1[][], int matriz2[][]) {
        // Array que salvará a soma das duas matrizes
        int soma[][] = new int[matriz1.length][matriz1[0].length];

        /*
         * O tamanho das duas matrizes devem ser os mesmos, para assim
         * poder efetuar a soma.
         */
        if (getTamanho(matriz1).equals(getTamanho(matriz2))) {
            for (int linha = 0; linha < matriz1.length; linha++) {
                for (int coluna = 0; coluna < matriz2.length; coluna++) {
                    // Adiciona ao determinado elemento da nova matriz soma, a soma do elemento da matriz 1 e o da 2
                    soma[linha][coluna] = matriz1[linha][coluna] + matriz2[linha][coluna];
                }
            }
        } else {
            return null;
        }

        return soma;
    }

    /*
     * Subtrai duas matrizes passadas.
     */
    public int[][] subtrair(int matriz1[][], int matriz2[][]) {
        // Array que salvará a subtração das duas matrizes
        int subtracao[][] = new int[matriz1.length][matriz1[0].length];

        /*
         * O tamanho das duas matrizes devem ser os mesmos, para assim
         * poder efetuar a subtração.
         */
        if (getTamanho(matriz1).equals(getTamanho(matriz2))) {
            for (int linha = 0; linha < matriz1.length; linha++) {
                for (int coluna = 0; coluna < matriz2.length; coluna++) {
                    // Adiciona ao determinado elemento da nova matriz subtração, a subtração do elemento da matriz 1 e o da 2
                    subtracao[linha][coluna] = matriz1[linha][coluna] - matriz2[linha][coluna];
                }
            }
        } else {
            return null;
        }

        return subtracao;
    }

    /*
     * Multiplica duas matrizes passadas.
     */
    public int[][] multiplicar(int matriz1[][], int matriz2[][]) {
        // Array que salvará a multiplicação das duas matrizes
        int multiplicacao[][] = new int[matriz1.length][matriz2[0].length];

        /*
         * Caso a quantidade de linhas da primeira matriz seja
         * igual a quantidade de colunas da segunda.
         */
        if (matriz1[0].length == matriz2.length) {
            for (int linha = 0; linha < matriz1.length; linha++) {
                int linhaMultiplicar[] = getLinha(matriz1, linha);

                for (int coluna = 0; coluna < matriz2.length; coluna++) {
                    int colunaMultiplicar[] = getColuna(matriz2, coluna);
                    multiplicacao[linha][coluna] += multiplicarLinhaColuna(linhaMultiplicar, colunaMultiplicar);
                }
            }
        } else {
            return null;
        }

        return multiplicacao;
    }

    /*
     * Faz a transposta da matriz passada.
     */
    public int[][] transposta(int matriz[][]) {
        // Array que salvara a transposta da matriz
        int matrizTransposta[][] = new int[matriz[0].length][matriz.length];

        // Inverte a linha e coluna e preenche o array
        for (int linha = 0; linha < matriz.length; linha++) {
            for (int coluna = 0; coluna < matriz[0].length; coluna++) {
                matrizTransposta[coluna][linha] = matriz[linha][coluna];
            }
        }

        return matrizTransposta;
    }

    /*
     * Calcula a determinante de uma matriz
     */
    public int determinante(int matriz[][]) {

        if (getTamanho(matriz).equals("2x2")) {
            return det2x2(matriz);
        } else if (getTamanho(matriz).equals("3x3")) {
            return det3x3(matriz);
        }

        return 0;
    }

    /*
     * Calcula a determinante de uma matriz 3x3.
     */
    private int det3x3(int matriz[][]) {
        // Nada feito
        return 0;
    }

    /*
     * Calcula a determinante de uma matriz 2x2.
     */
    private int det2x2(int matriz[][]) {
        return matriz[0][0] * matriz[1][1] - matriz[0][1] * matriz[1][0];
    }

    /*
     * Retorna o tamanho da matriz.
     */
    private String getTamanho(int matriz[][]) {
        return matriz.length + "x" + matriz[0].length;
    }

    /*
     * Multiplica a determinada linha pela coluna.
     */
    private int multiplicarLinhaColuna(int linhaMultiplicar[], int colunaMultiplicar[]) {
        int total = 0;

        for (int linhaColuna = 0; linhaColuna < linhaMultiplicar.length; linhaColuna++) {
            total += linhaMultiplicar[linhaColuna] * colunaMultiplicar[linhaColuna];
        }

        return total;
    }

    /*
     * Obtem a determinada linha da matriz.
     */
    private int[] getLinha(int matriz[][], int linhaProcurar) {
        int[] linhaReturn = new int[matriz[0].length];

        for (int linha = 0; linha <= linhaProcurar; linha++) {
            if (linha == linhaProcurar) {
                for (int coluna = 0; coluna < matriz[0].length; coluna++) {
                    linhaReturn[coluna] = matriz[linha][coluna];
                }
            }
        }

        return linhaReturn;
    }

    /*
     * Obtem a determinada coluna da matriz.
     */
    private int[] getColuna(int matriz[][], int colunaProcurar) {
        int[] colunaReturn = new int[matriz.length];

        for (int linha = 0; linha < matriz.length; linha++) {
            for (int coluna = 0; coluna <= colunaProcurar; coluna++) {
                if (coluna == colunaProcurar) {
                    colunaReturn[linha] = matriz[linha][coluna];
                }
            }
        }

        return colunaReturn;
    }

}