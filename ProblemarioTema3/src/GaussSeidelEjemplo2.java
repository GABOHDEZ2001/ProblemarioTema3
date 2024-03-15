public class GaussSeidelEjemplo2 {

    static final int MAX_ITERATIONS = 100;
    static final double TOLERANCE = 0.0001;

    public static void main(String[] args) {
        double[][] coefficients = {
                {10, -1, 2, 0},
                {-1, 11, -1, 3},
                {2, -1, 10, -1},
                {0, 3, -1, 8}
        };
        double[] initialValues = {0, 0, 0, 0};
        double[] solutions = gaussSeidel(coefficients, initialValues);
        System.out.println("Solutions:");
        for (int i = 0; i < solutions.length; i++) {
            System.out.println("x[" + i + "] = " + solutions[i]);
        }
    }

    public static double[] gaussSeidel(double[][] coefficients, double[] initialValues) {
        int n = coefficients.length;
        double[] solutions = new double[n];
        double[] newSolutions = new double[n];
        int iterations = 0;
        double error;

        do {
            for (int i = 0; i < n; i++) {
                double sum = 0.0;
                for (int j = 0; j < n; j++) {
                    if (j != i) {
                        sum += coefficients[i][j] * newSolutions[j];
                    }
                }
                newSolutions[i] = (initialValues[i] - sum) / coefficients[i][i];
            }

            error = 0.0;
            for (int i = 0; i < n; i++) {
                error = Math.max(error, Math.abs(newSolutions[i] - solutions[i]));
                solutions[i] = newSolutions[i];
            }

            iterations++;
        } while (error > TOLERANCE && iterations < MAX_ITERATIONS);

        if (iterations >= MAX_ITERATIONS) {
            System.out.println("Maximum iterations reached without convergence");
        }

        return solutions;
    }
}
