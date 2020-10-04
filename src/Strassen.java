
public class Strassen {
	
	
	
	public static int [][] multiplica(int [][] A, int [][] B)
	{
		int n = A.length;

        int[][] res = new int[n][n];

      
        if (n == 256) {
        	for(int i = 0;i<n;i++) {
        		for(int j = 0;j<n;j++) {
        			for(int k = 0;k<n;k++) {
        				res[i][j] = res[i][j] + A[i][k] * B[k][j];
        			}
        		}
        	}
        }else {

    
            int[][] a = new int[n / 2][n / 2];
            int[][] b = new int[n / 2][n / 2];
            int[][] c = new int[n / 2][n / 2];
            int[][] d = new int[n / 2][n / 2];
            
       
            int[][] e = new int[n / 2][n / 2];
            int[][] f = new int[n / 2][n / 2];
            int[][] g = new int[n / 2][n / 2];
            int[][] h = new int[n / 2][n / 2];

        
            divideMatriz(A, a, 0, 0);
            divideMatriz(A, b, 0, n / 2);
            divideMatriz(A, c, n / 2, 0);
            divideMatriz(A, d, n / 2, n / 2);

           
            divideMatriz(B, e, 0, 0);
            divideMatriz(B, f, 0, n / 2);
            divideMatriz(B, g, n / 2, 0);
            divideMatriz(B, h, n / 2, n / 2);
            
          
            int[][] p1 = multiplica(somaMatriz(a, d), somaMatriz(e, h));
            int[][] p2 = multiplica(somaMatriz(c,d),e);
            int[][] p3 = multiplica(a, subtraiMatriz(f, h));           
            int[][] p4 = multiplica(d, subtraiMatriz(g, e));
            int[][] p5 = multiplica(somaMatriz(a,b), h);
            int[][] p6 = multiplica(subtraiMatriz(c, a), somaMatriz(e, f));
            int[][] p7 = multiplica(subtraiMatriz(b, d), somaMatriz(g, h));

            
           /**
              C11 = p1 + p4 - p5 + p7
              C12 = p3 + p5
              C21 = p2 + p4
              C22 = p1 - p2 + p3 + p6
            **/
           
            int[][] C11 = somaMatriz(subtraiMatriz(somaMatriz(p1, p4), p5), p7);
            int[][] C12 = somaMatriz(p3, p5);
            int[][] C21 = somaMatriz(p2, p4);
            int[][] C22 = somaMatriz(subtraiMatriz(somaMatriz(p1, p3), p2), p6);

          
            CopiaMatriz(C11, res, 0, 0);
            CopiaMatriz(C12, res, 0, n / 2);
            CopiaMatriz(C21, res, n / 2, 0);
            CopiaMatriz(C22, res, n / 2, n / 2);
        }
        return res;
    }


   
    
    public static int[][] somaMatriz(int[][] a, int[][] b) {
        int n = a.length;
        int[][] res = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = a[i][j] + b[i][j];
            }
        }
        return res;
    }

    // Subtracting 2 matrices
    public static int[][] subtraiMatriz(int[][] a, int[][] b) {
        int n = a.length;
        int[][] res = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = a[i][j] - b[i][j];
            }
        }
        return res;
    }

   
    // divides array
    public static void divideMatriz(int[][] P, int[][] C, int iB, int jB) 
    {
        for(int i1 = 0, i2 = iB; i1 < C.length; i1++, i2++)
            for(int j1 = 0, j2 = jB; j1 < C.length; j1++, j2++)
                C[i1][j1] = P[i2][j2];
    }

    // copies
    public static void CopiaMatriz(int[][] C, int[][] P, int iB, int jB) 
    {
        for(int i1 = 0, i2 = iB; i1 < C.length; i1++, i2++)
            for(int j1 = 0, j2 = jB; j1 < C.length; j1++, j2++)
                P[i2][j2] = C[i1][j1];
    }  
 
  
    
    
}
