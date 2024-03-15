import java.util.Scanner;
import javax.swing.JOptionPane;

public class EliminacionGaussianaEjemplo2 {

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Ecuaciones por Eliminación Gaussiana");

        int n = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de ecuaciones: "));
        float[][] matriz = new float[n][n + 1];

        JOptionPane.showMessageDialog(null, "Ingrese los coeficientes y resultados de cada ecuación:");

        for (int i = 0; i < n; i++) {
            String[] coeficientes = JOptionPane.showInputDialog("Ecuación " + (i + 1) + ":").split(" ");
            for (int j = 0; j < n + 1; j++) {
                matriz[i][j] = Float.parseFloat(coeficientes[j]);
            }
        }

        for (int i = 0; i < n - 1; i++) {
            for (int k = i + 1; k < n; k++) {
                float factor = matriz[k][i] / matriz[i][i];
                for (int j = i; j < n + 1; j++) {
                    matriz[k][j] -= factor * matriz[i][j];
                }
            }
        }

        float[] soluciones = new float[n];
        for (int i = n - 1; i >= 0; i--) {
            float suma = 0;
            for (int j = i + 1; j < n; j++) {
                suma += matriz[i][j] * soluciones[j];
            }
            soluciones[i] = (matriz[i][n] - suma) / matriz[i][i];
        }

        StringBuilder mensaje = new StringBuilder("Soluciones:\n");
        for (int i = 0; i < n; i++) {
            mensaje.append("x[").append(i + 1).append("] = ").append(soluciones[i]).append("\n");
        }
        JOptionPane.showMessageDialog(null, mensaje.toString());
    }
}
