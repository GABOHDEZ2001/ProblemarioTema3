public class MetodoJacobiEjemplo1 {

    // Función para calcular el siguiente valor de x[i]
    public static double calculateNewX(double x, double y, double z) {
        return (4 - 2 * y + z) / 6.0;
    }

    // Función para calcular el siguiente valor de y[i]
    public static double calculateNewY(double x, double y, double z) {
        return (3 - x - z) / 5.0;
    }

    // Función para calcular el siguiente valor de z[i]
    public static double calculateNewZ(double x, double y, double z) {
        return (27 - 2 * x - y) / 4.0;
    }

    // Método de Jacobi
    public static void jacobi(double x, double y, double z, double tolerance, int maxIterations) {
        int iterations = 0;

        while (iterations < maxIterations) {
            double newX = calculateNewX(x, y, z);
            double newY = calculateNewY(x, y, z);
            double newZ = calculateNewZ(x, y, z);

            // Comprobar la convergencia
            double maxDiff = Math.max(Math.abs(newX - x), Math.max(Math.abs(newY - y), Math.abs(newZ - z)));

            if (maxDiff < tolerance) {
                System.out.println("Convergencia alcanzada en la iteración " + iterations);
                System.out.println("x = " + newX);
                System.out.println("y = " + newY);
                System.out.println("z = " + newZ);
                return;
            }

            // Actualizar los valores de x, y, y z
            x = newX;
            y = newY;
            z = newZ;

            iterations++;
        }

        System.out.println("No se alcanzó la convergencia después de " + maxIterations + " iteraciones.");
    }

    public static void main(String[] args) {
        double x = 0; // Valor inicial de x
        double y = 0; // Valor inicial de y
        double z = 0; // Valor inicial de z
        double tolerance = 0.0001; // Tolerancia
        int maxIterations = 100; // Número máximo de iteraciones

        jacobi(x, y, z, tolerance, maxIterations);
    }
}