import java.util.Arrays;

public class GaussSeidelEjemplo1 {

    public static double[] gaussSeidel(double[][] coeficientes, double[] terminosIndependientes, double tol, int iterMax) {
        int n = terminosIndependientes.length;
        double[] soluciones = new double[n];
        double[] solucionesAnterior = new double[n];
        int iter = 0;

        // Inicio de las soluciones
        for (int i = 0; i < n; i++) {
            soluciones[i] = 0.0;
        }

        // Bucle principal del método de Gauss-Seidel
        do {
            // Copiar las soluciones de la iteración anterior
            System.arraycopy(soluciones, 0, solucionesAnterior, 0, n);

            // Actualizar cada solución
            for (int i = 0; i < n; i++) {
                double suma = 0.0;
                for (int j = 0; j < n; j++) {
                    if (j != i) {
                        suma += coeficientes[i][j] * soluciones[j];
                    }
                }
                soluciones[i] = (terminosIndependientes[i] - suma) / coeficientes[i][i];
            }

            iter++;
        } while (iter < iterMax && !converge(soluciones, solucionesAnterior, tol));

        return soluciones;
    }

    // Función para verificar si las soluciones han convergido
    public static boolean converge(double[] soluciones, double[] solucionesAnterior, double tol) {
        for (int i = 0; i < soluciones.length; i++) {
            if (Math.abs(soluciones[i] - solucionesAnterior[i]) > tol) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // Definir la matriz de coeficientes
        double[][] coeficientes = {
                {9, 2, -1},
                {7, 8, 5},
                {3, 4, -10}
        };

        // Definir el vector de términos independientes
        double[] terminosIndependientes = {-2, 3, 6};

        // Especificar la tolerancia y el número máximo de iteraciones
        double tol = 0.0001;
        int iterMax = 100;

        // Resolver el sistema de ecuaciones lineales
        double[] soluciones = gaussSeidel(coeficientes, terminosIndependientes, tol, iterMax);

        // Impreción de las soluciones
        System.out.println("Soluciones:");
        for (int i = 0; i < soluciones.length; i++) {
            System.out.println("x" + (i + 1) + ": " + soluciones[i]);
        }
    }
}
