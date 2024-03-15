public class EliminacionGaussianaEjemplo3 {

    public static void main(String[] args) {
        double[][] sistemaEcuaciones = {
                {2, 1, -1, 8},
                {-3, -1, 2, -11},
                {-2, 1, 2, -3}
        };

        resolverSistema(sistemaEcuaciones);
    }

    public static void resolverSistema(double[][] matriz) {
        int filas = matriz.length;
        int columnas = matriz[0].length - 1; // Ignoramos la última columna (soluciones)

        // Aplicar eliminación gaussiana
        for (int i = 0; i < filas - 1; i++) {
            for (int j = i + 1; j < filas; j++) {
                double factor = matriz[j][i] / matriz[i][i];
                for (int k = i; k < columnas + 1; k++) {
                    matriz[j][k] -= factor * matriz[i][k];
                }
            }
        }

        // Realizar sustitución hacia atrás
        double[] soluciones = new double[filas];
        for (int i = filas - 1; i >= 0; i--) {
            double suma = 0;
            for (int j = i + 1; j < filas; j++) {
                suma += matriz[i][j] * soluciones[j];
            }
            soluciones[i] = (matriz[i][columnas] - suma) / matriz[i][i];
        }

        // Mostrar las soluciones
        System.out.println("Soluciones:");
        for (int i = 0; i < filas; i++) {
            System.out.println("x" + (i + 1) + " = " + soluciones[i]);
        }
    }
}