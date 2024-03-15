public class GaussJordanEjemplo1 {


        public static void main(String[] args) {
            double[][] matriz = {{2, 1, -1, 8},
                    {-3, -1, 2, -11},
                    {-2, 1, 2, -3}};

            double[] soluciones = resolverSistema(matriz);

            System.out.println("Soluciones:");
            for (int i = 0; i < soluciones.length; i++) {
                System.out.println("x" + (i+1) + " = " + soluciones[i]);
            }
        }

        public static double[] resolverSistema(double[][] matriz) {
            int n = matriz.length;
            double[] soluciones = new double[n];

            // Proceso de Gauss-Jordan
            for (int i = 0; i < n; i++) {
                // Pivote actual
                double pivote = matriz[i][i];

                // Hacer el pivote igual a 1
                for (int j = 0; j < n + 1; j++) {
                    matriz[i][j] /= pivote;
                }

                // Eliminación hacia adelante y hacia atrás
                for (int k = 0; k < n; k++) {
                    if (k != i) {
                        double factor = matriz[k][i];
                        for (int j = 0; j < n + 1; j++) {
                            matriz[k][j] -= factor * matriz[i][j];
                        }
                    }
                }
            }

            // Extraer las soluciones
            for (int i = 0; i < n; i++) {
                soluciones[i] = matriz[i][n];
            }

            return soluciones;
        }
    }

