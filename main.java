import java.io.*;
import java.util.*;

public class main {

	public static void printErrorMessage(){
		System.out.println("Вы ввели некорректные данные."); 
	}
	
	public static int enterInt(Scanner sc){
		int n = 0;
		try {
			n = sc.nextInt();
			if (n < 1) { printErrorMessage(); System.exit(1); }
			return n;
		} catch (InputMismatchException IME) {
			printErrorMessage();
			System.exit(1);
		}
		return n;
	}
	
	public static void enterMatrix(int n, Scanner sc, LinearSystem ls){
		double w = 0.0;
		int i = 0;
		int j = 0;
		for (int k = 0; k < n * n + n; k++){
			if(j == n) { break; }
			if(i == n+1) { i = 0; j++; }
			
			try {
				try { 
					w = sc.nextDouble();
				} catch (InputMismatchException e1){
					printErrorMessage();
					System.exit(1);
				} 
			} catch (NoSuchElementException e) {
				printErrorMessage();
				System.exit(1);
			}
		  	ls.matrix[j][i] = w;
			i++;
		} 
	}

	public static void printMatrix(int n, LinearSystem ls){
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				System.out.print(ls.matrix[i][j] + "  ");
			}
			System.out.print("\n");
		}
	
	}
	
	public static void printX(int n, LinearSystem ls){
		System.out.println("Решение системы линейных уравнений:");
		for(int i = 0; i < n; i++){
				System.out.println("X"+i+" = " + ls.x[i][0]);
			}
	}

	public static void main(String args[]){
		int n = 0;
		LinearSystem ls;
		switch(args.length) {
			case 0:{
				ls = new LinearSystem(0);
				System.out.println("Передайте при запуске программы аргумент stdin для ввода коэффициентов с помощью командной строки."); 
				System.out.println("filename для файлового ввода."); 
				break;
			}
			case 1:{
				if (args[0].equals("stdin")) {
					System.out.println("Введите n - размер матрицы коэффициентов");
					Scanner sc = new Scanner(System.in);
					n = enterInt(sc);
					if (n > 20) { System.out.println("Вы ввели слишком большое n"); System.exit(1);}
					ls = new LinearSystem(n);
					enterMatrix(n, sc, ls);
				} else {
					try {
						Scanner sc = new Scanner(new File(args[0]));
        					n = enterInt(sc);
						if (n > 20) { System.out.println("Вы ввели слишком большое n"); System.exit(1);}
						ls = new LinearSystem(n);
						enterMatrix(n, sc, ls);
					} 
					catch (FileNotFoundException e1) {
						ls = new LinearSystem(0);
						System.out.println("Такого файла не существует"); 
					}
				}
				break;
			} 
			default: {
				ls = new LinearSystem(0);
				System.out.println("Введено слишком много аргументов командной строки"); 
				break;
			}
		}
		ls.algorithm();
		System.out.println("Треугольная матрица:");
		printMatrix(n, ls);
		printX(n, ls); 
	}	
}

