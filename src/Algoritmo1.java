
public class Algoritmo1 {
	
	public int[][] multiplica(int[][] matriz1, int[][] matriz2)
    { 
		int n = matriz1.length;
		int[][] resultado = new int[n][n];

	for(int i = 0;i<n;i++) {
		for(int j = 0;j<n;j++) {
			for(int k = 0;k<n;k++) {
				resultado[i][j] = resultado[i][j] + matriz1[i][k] * matriz2[k][j];
			}
		}
	}
	

	 return resultado;
    }

}
