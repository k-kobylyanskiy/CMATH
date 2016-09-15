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
	
	public static void enterMatrix(int n, Scanner sc){
		LinearSystem ls = new LinearSystem(n);
		System.out.println(n);
		double w = 0.0;
		int i = 0;
		int j = 0;
		for (int k = 0; k < n * n; k++){
			if(j == n) { break; }
			if(i == n) { i = 0; System.out.print("\n"); j++; }
			
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
			System.out.println(i+"-"+j);
		  	ls.matrix[j][i] = w;
			System.out.print(w + " ");
			i++;
		} 
	}

	public static void main(String args[]){
		switch(args.length) {
			case 0:{
				System.out.println("Передайте при запуске программы аргумент stdin для ввода коэффициентов с помощью командной строки."); 
				System.out.println("filename для файлового ввода."); 
				break;
			}
			case 1:{
				if (args[0].equals("stdin")) {
					System.out.println("Введите n - размер матрицы коэффициентов");
					Scanner sc = new Scanner(System.in);
					int n = enterInt(sc);
					enterMatrix(n, sc);
				} else {
					try {
						Scanner sc = new Scanner(new File(args[0]));
        					int n = enterInt(sc);
						enterMatrix(n, sc);
					} 
					catch (FileNotFoundException e1) {
						System.out.println("Такого файла не существует"); 
					}
				}
				break;
			} 
			default: {
				System.out.println("Ты ввел слишком дохуя аргументов. Иди нахуй."); 
				break;
			}
		}
		System.out.println("Сейчас буду решать"); 
	}	
}

