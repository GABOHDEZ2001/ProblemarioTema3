public class EliminacionGaussianaEjemplo5 {

    public static void main(String[] args) {
        double[][] matriz = {{3, -1, 4, 7},
                {2, 1, -3, 8},
                {1, -4, 2, 9}};

        double[] soluciones = resolverSistema(matriz);

        System.out.println("Soluciones:");
        for (int i = 0; i < soluciones.length; i++) {
            System.out.println("x" + (i+1) + " = " + soluciones[i]);
        }
    }

    public static double[] resolverSistema(double[][] matriz) {
        int n = matriz.length;
        double[] soluciones = new double[n];

        // Eliminación hacia adelante
        for (int i = 0; i < n; i++) {
            for (int k = i+1; k < n; k++) {
                double factor = matriz[k][i] / matriz[i][i];
                for (int j = i; j < n+1; j++) {
                    matriz[k][j] -= factor * matriz[i][j];
                }
            }
        }

        // Sustitución hacia atrás
        for (int i = n-1; i >= 0; i--) {
            soluciones[i] = matriz[i][n] / matriz[i][i];
            for (int k = i-1; k >= 0; k--) {
                matriz[k][n] -= matriz[k][i] * soluciones[i];
            }
        }

        return soluciones;
    }
}
