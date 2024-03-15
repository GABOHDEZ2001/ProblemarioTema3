import java.util.Arrays;

public class MetodoJacobiEjemplo4 {

    public static void main(String[] args) {
        // Definir el nuevo sistema de ecuaciones
        double[][] coeficientes = {
                {2, -1, 3},
                {1, -2, 1},
                {3, 2, -4}
        };

        double[] soluciones = {7, -6, 14}; // Cambiar las soluciones según el nuevo sistema

        // Resolver el sistema utilizando el método de Jacobi
        double[] resultado = jacobi(coeficientes, soluciones, 0.0001, 100);

        // Imprimir las soluciones
        System.out.println("Soluciones:");
        System.out.println(Arrays.toString(resultado));
    }

    public static double[] jacobi(double[][] coeficientes, double[] soluciones, double tolerancia, int maxIteraciones) {
        int n = soluciones.length;
        double[] x = new double[n];
        double[] xAnterior = new double[n];
        int iteraciones = 0;

        while (iteraciones < maxIteraciones) {
            for (int i = 0; i < n; i++) {
                xAnterior[i] = x[i];
            }

            for (int i = 0; i < n; i++) {
                double sum = soluciones[i];
                for (int j = 0; j < n; j++) {
                    if (j != i) {
                        sum -= coeficientes[i][j] * xAnterior[j];
                    }
                }
                x[i] = sum / coeficientes[i][i];
            }

            double error = 0;
            for (int i = 0; i < n; i++) {
                error = Math.max(error, Math.abs(x[i] - xAnterior[i]));
            }

            if (error < tolerancia) {
                break;
            }

            iteraciones++;
        }

        return x;
    }
}
