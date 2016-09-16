public class LinearSystem {
	
	public double[][] matrix;
	public double[][] x; 
	public int strings;
	LinearSystem(int n){
		matrix = new double [n][n+1];
		x = new double [n][1];
		strings = n;
	}
	
	public void algorithm(){
		
		// Прямой ход
	
		for(int i = 0; i < strings - 1; i++){
			if(matrix[i][i] == 0.0) {
				// Переставить уравнения
				for(int j = i+1; j < strings-1; j++){
					if(matrix[j][i] != 0){
						// Переставить
						for(int k = 0; k < strings+1; k++){
							double t = matrix[i][i];
							matrix[i][i] = matrix[j][i];
							matrix[j][i] = t;
						}
					}
				}
			}

			double a1 = matrix[i][i];
			for(int k = i+1; k < strings; k++){
			double a2 = matrix[k][i];
				for(int j = 0; j < strings + 1; j++){
					matrix[k][j] += -matrix[i][j]*a2/a1;
				}
			}
		}

		// Обратный ход
		
		for(int i = strings-1; i >= 0; i--){
			double s = 0;
			for(int j = i + 1; j < strings; j++){
				s += x[j][0]*matrix[i][j];
			}
			x[i][0] = (matrix[i][strings]-s)/matrix[i][i];	
		}	

	}

}
