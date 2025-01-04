public class lab1 {
    public static void main(String[] args) {
	    int[] p = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21};
	    double[] x = new double[17];
	    byte a = 0;
        do {
            x[a] = -3 + (15) * Math.random();
            a++;
        } while (a < 17);
	    double[][] s = new double[11][17];

        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 17; j++) {
		        switch(p[i]){
		           case 9 -> s[i][j] = Math.pow(Math.tan(Math.atan((x[j]+4.5)/15)), Math.tan(Math.log(Math.abs(x[j]))));
		           case 1, 5, 13, 15, 17 -> s[i][j] = Math.pow(2 * Math.sin(Math.tan(x[j])), Math.exp(Math.tan(x[j])));
		           default -> s[i][j] = 0.75 * Math.pow((0.25 * Math.cos(Math.asin((x[j] + 4.5) / 15))), Math.sin(Math.asin((x[j] + 4.5) / 15)));
		        }
            }
        }
        printMatrix(s);
    }
    public static void printMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double value : row) {
                System.out.printf("%.4f ", value);
            }
            System.out.println();
        }
    }
} 

