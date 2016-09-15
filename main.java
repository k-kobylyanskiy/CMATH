import java.io.*;
import java.util.*;

public class main {
	public static void main(String args[]){
		switch(args.length) {
			case 0:{
				System.out.println("Ты не ввел аргумент ебаной командной строки. Неужели блядь это так сложно?"); 
				System.out.println("Введи stdin для ввода коэффициентов с помощью командной строки."); 
				System.out.println("filename для файлового ввода."); 
				System.out.println("А еще ты пидор)"); 
				break;
			}
			case 1:{
				System.out.println("Ты хочешь открыть " + args[0]); 
				if (args[0].equals("stdin")) {
					System.out.println("Сейчас будешь вручную вводить блядские коэффициенты, сука");
					// Ввод коэффициентов
					Scanner sc = new Scanner(System.in);
        				try { 
						int n = sc.nextInt();
					}
					catch (Mismath
					LinearSystem ls = new LinearSystem(n);
					System.out.println(n);
					double w;
					int i = 0;
					int j = 0;
					for (int k = 0; k < n * n; k++){
						if(j == n) { break; }
						if(i == n) { i = 0; System.out.print("\n"); j++; }
						w = sc.nextDouble();
						LinearSystem.matrix[i][j] = w;
						System.out.print(w + " ");
						i++;
					} 
				
				} else {
					try {
						Scanner sc = new Scanner(new File(args[0]));
        					int n = sc.nextInt();
						LinearSystem ls = new LinearSystem(n);
						System.out.println(n);
						double w;
						int i = 0;
						int j = 0;
						try {
							for (int k = 0; k < n * n; k++){
								if(j == n) { break; }
								if(i == n) { i = 0; System.out.print("\n"); j++; }
								w = sc.nextDouble();
								LinearSystem.matrix[i][j] = w;
								System.out.print(w + " ");
								i++;
							}
						}
						catch (NoSuchElementException q)  {
							System.out.println("\nМаловато аргументов, дружок\nПопробуй заново)"); 
						}		
					} 
					catch (FileNotFoundException e1) {
						System.out.println("Ахуел, что ли, сука? Такого файла тут нет."); 
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

