public class GaussJordanEjemplo5 {

    // Ecuacion a Resolver
    // 3x -  y + 4z = 7
    // 2x +  y - 3z = 8
    //  x - 4y + 2z = 9

    public static void main(String[] args) {
        double[][] matriz = {
                {3, -1, 4, 7},
                {2, 1, -3, 8},
                {1, -4, 2, 9}
        };

        resolverSistema(matriz);
    }

    public static void resolverSistema(double[][] matriz) {
        int filas = matriz.length;
        int columnas = matriz[0].length;

        // Escalonar la matriz
        for (int i = 0; i < filas; i++) {
            double pivote = matriz[i][i];
            for (int j = i + 1; j < filas; j++) {
                double factor = matriz[j][i] / pivote;
                for (int k = i; k < columnas; k++) {
                    matriz[j][k] -= matriz[i][k] * factor;
                }
            }
        }

        // Reducir la matriz a forma escalonada reducida
        for (int i = filas - 1; i >= 0; i--) {
            double pivote = matriz[i][i];
            for (int j = i - 1; j >= 0; j--) {
                double factor = matriz[j][i] / pivote;
                for (int k = i; k < columnas; k++) {
                    matriz[j][k] -= matriz[i][k] * factor;
                }
            }
        }

        // Normalizar la matriz
        for (int i = 0; i < filas; i++) {
            double pivote = matriz[i][i];
            for (int j = i; j < columnas; j++) {
                matriz[i][j] /= pivote;
            }
        }

        // Imprimir la solución
        for (int i = 0; i < filas; i++) {
            System.out.print("x" + (i + 1) + " = " + matriz[i][columnas - 1]);
            System.out.println();
        }
    }
}
