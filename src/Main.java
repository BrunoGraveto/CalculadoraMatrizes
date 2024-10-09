public class Main {

    public static void main(String[] args) {
        
        // Matriz 1
        int matriz1[][] = new int[][] {
            {1, 7 , 9},
            {3, 5 , 0},
            {8, 2 , 3}
        };

        // Matriz 2
        int matriz2[][] = new int[][] {
            {1, 5 , 1},
            {8, 2 , 7},
            {5, 3, 9}
        };

        // Chama a classe Calc. Matriz.
        CalculadoraMatriz calc = new CalculadoraMatriz();
        
        // Mostra a matriz 1
        System.out.println("-> Matriz 1:");
        calc.mostrar(matriz1);

        // Mostra a matriz 2
        System.out.println("\n-> Matriz 2:");
        calc.mostrar(matriz2);

        // Igualdade das matrizes
        if (calc.equals(matriz1, matriz2)) {
            System.out.println("\n-> As matrizes são iguais!");
        } else {
            System.out.println("\n-> As matrizes não são iguais!");
        }

        // Soma das matrizes
        int somaMatrizes[][] = calc.somar(matriz1, matriz2);

        if (somaMatrizes != null) {
            System.out.println("\n-> Soma da matriz 1 e matriz 2:");
            calc.mostrar(somaMatrizes);
        } else {
            System.out.println("\n-> Não é possivel somar as duas matrizes!");
        }

        // Subtração das matrizes
        int subtracaoMatrizes[][] = calc.subtrair(matriz1, matriz2);

        if (subtracaoMatrizes != null) {
            System.out.println("\n-> Subtração da matriz 1 e matriz 2:");
            calc.mostrar(subtracaoMatrizes);
        } else {
            System.out.println("\n-> Não é possivel subtrair as duas matrizes!");
        }

        // Multiplicação das duas matrizes
        int produtoMatrizes[][] = calc.multiplicar(matriz1, matriz2);

        if (produtoMatrizes != null) {
            System.out.println("\n-> Multiplicação da matriz 1 e matriz 2:");
            calc.mostrar(produtoMatrizes);
        } else {
            System.out.println("\n-> Não é possivel multiplicar as duas matrizes!");
        }

        // Matriz 1 transposta
        System.out.println("\n-> Matriz 1 tranposta:");
        calc.mostrar(calc.transposta(matriz1));

        // Matriz 1 transposta
        System.out.println("\n-> Matriz 2 tranposta:");
        calc.mostrar(calc.transposta(matriz2));

    }

}