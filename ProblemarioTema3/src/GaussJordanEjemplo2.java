public class GaussJordanEjemplo2 {


        public static void main(String[] args) {
            double[][] matriz = {
                    {2, 1, -1, 8},
                    {-3, -1, 2, -11},
                    {-2, 1, 2, -3}
            };

            double[] solucion = resolverSistema(matriz);

            // Imprimir la solución
            for (int i = 0; i < solucion.length; i++) {
                System.out.println("x" + (i + 1) + " = " + solucion[i]);
            }
        }

        public static double[] resolverSistema(double[][] matriz) {
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
            double[] solucion = new double[filas];
            for (int i = 0; i < filas; i++) {
                double pivote = matriz[i][i];
                solucion[i] = matriz[i][columnas - 1] / pivote;
            }

            return solucion;
        }
    }


