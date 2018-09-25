public class Matrix {

	public static int determinant(int[][] matrix) {
        return determinantOfMatrix(matrix, matrix.length);
    }
	
	public static int determinantOfMatrix(int[][] matrix, int n) {
		int D = 0;
        if (n == 1) 
            return matrix[0][0]; 
        int temp[][] = new int[n][n];   
        int sign = 1;  
        for (int f = 0; f < n; f++) 
        { 
            getCofactor(matrix, temp, 0, f, n); 
            D += sign * matrix[0][f]  
               * determinantOfMatrix(temp, n - 1);  
            sign = -sign; 
        } 
      
        return D;
	}
	
	static void getCofactor(int mat[][], int temp[][], int p, int q, int n) {
		int i = 0, j = 0;
		for (int row = 0; row < n; row++) {
			for (int col = 0; col < n; col++) {
				if (row != p && col != q) {
					temp[i][j++] = mat[row][col];
					if (j == n - 1) {
						j = 0;
						i++;
					}
				}
			}
		}
	}
}
