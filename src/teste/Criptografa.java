package teste;


import java.util.Scanner;

public class Criptografa {
	static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		char alfa[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g','h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v','w', 'x', 'y', 'z'};
		String alfabeto = "abcdefghijklmnopqrstuvwxyz";
		char[] aux = null;
		int chave = 0, opc1 = 0, opc2 = 0, opc3 = 1;
		String chave2 = " ";
		System.out.println("1 - Criptografia Simples.");
		System.out.println("2 - Criptografia Media.");
		System.out.print(": ");
		opc1 = Integer.parseInt(input.nextLine());

		while(opc3 == 1)
		{
			switch (opc1)
			{
				case 1:
					System.out.print("\nDigite sua frase: ");
					String frase = input.nextLine();
					System.out.print("Valor chave de criptografia: ");
					chave = Integer.parseInt(input.nextLine());
					
					aux = frase.toCharArray();
					char[] resultado = new char [aux.length];
					
					System.out.println("1 - Criar uma criptografia.");
					System.out.println("2 - Descriptografar.");
					System.out.print(": ");
					opc2 = Integer.parseInt(input.nextLine());
					if (opc2 == 1)
					{
						for (int i = 0; i < aux.length; i++) 
						{
							for (int j = 0; j < alfa.length; j++) 
							{
								if(aux[i] == alfa[j])
								{
									if((j + chave) > alfa.length){
										resultado[i] = alfa[(j + chave) % alfa.length];
									}
									else{
										if(j + chave >= 26)
										{
											resultado[i] = alfa[(j + chave) - 26];
										}
										else
											resultado[i] = alfa[((j) + chave)];
											
										
									}				
								}					
							}
							System.out.print(resultado[i]);
						}
					}
					else if(opc2 == 2)
					{
						 
						for (int i = 0; i < aux.length; i++) 
						{
							for (int j = 0; j < alfa.length; j++) 
							{
								if(aux[i] == alfa[j])
								{
									int posicao = j - chave;
									while(posicao < 0)
									{
										posicao += alfa.length;
									}
									resultado[i] = alfa[posicao];
		
								}		
							}
							System.out.print(resultado[i]);
						}
					}
					break;
				
				case 2:
					System.out.print("Digite sua frase: ");
					String var = input.nextLine();
				    
				    var = var.replace(" ", "");
					System.out.println("Chave de criptografia: ");
					chave2 = input.nextLine().replace(" ", "");//Retira os espaços
					
					int coluna = chave2.length();
					int linha = (int) Math.ceil( ((float)var.length()/coluna) );
					char[][] matrix = new char[linha][coluna];
					int[] index = new int[coluna];
					
					//Pega os indice de todas as palavras da string no alfabeto
					for (int i = 0; i < chave2.length(); i++) 
						for (int j = 0; j < alfabeto.length(); j++) 				
							if(alfabeto.charAt(j) == chave2.charAt(i))					
								index[i] = j;
				
					int cont = 0, cont2 = 0;
					//Preenche a matriz com a string e com letras aleatorias para completar
					for (int i = 0; i < linha; i++) 
						for (int j = 0; j < coluna; j++) 
						{
							if(cont < var.length())
								matrix[i][j] = var.charAt(cont);
							else{
								matrix[i][j] = alfabeto.charAt(cont2);
								cont2++;
							}
								
							cont++;
						}
					
					for (int i = 0; i < matrix.length; i++) {
						for (int j = 0; j < matrix[0].length; j++) {
							System.out.print(matrix[i][j]);
						}
						System.out.println();
					}
					
					System.out.print("Criptografado: ");
					for (int k = 0; k < 26; k++) 
						for (int k2 = 0; k2 < index.length; k2++) 
							if(index[k2] == k)
								for (int i = 0; i < linha; i++) System.out.print(matrix[i][k2]);

					System.out.println();
					break;
				}
				
			}
			System.out.print("\n[1] para continuar: ");
			opc3 = Integer.parseInt(input.nextLine());
			
			
			input.close();
		}

}
