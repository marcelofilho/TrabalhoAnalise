
public class Main {

	
	public static void main (String arg []){
		
		
		int n = 1024;
		Strassen strassen = new Strassen();
		Algoritmo1 algoritmo = new Algoritmo1();
		
		int [][] matriz1 = new int[n][n];
		int [][] matriz2 = new int[n][n];
		int [][] resultado = new int[n][n];

		for ( int i = 0; i < n; i ++ )
			for ( int z = 0; z < n; z ++) {
				matriz1[i][z] = (int) (Math.random() * 10);
				matriz2[i][z] = (int) (Math.random() * 10);
				resultado[i][z] = 0;
			}
		
		System.out.println("\nMatriz A : ");
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
                System.out.print(matriz1[i][j] +" ");
            System.out.println();
        }
        
        System.out.println("\nMatriz B : ");
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
                System.out.print(matriz2[i][j] +" ");
            System.out.println();
        }
		
		 long startTime = System.nanoTime();

		 resultado = algoritmo.multiplica(matriz1,matriz2);
	

	        System.out.println("\nProduct of matrices A and  B : ");
	        for (int i = 0; i < n; i++)
	        {
	            for (int j = 0; j < n; j++)
	                System.out.print(resultado[i][j] +" ");
	            System.out.println();
	        }
	        long elapsedTime = System.nanoTime() - startTime;
	        System.out.println("Tempo do algortimo" + elapsedTime/1000000);
	}
	
	
}
