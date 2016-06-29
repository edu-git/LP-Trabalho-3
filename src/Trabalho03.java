import java.util.Locale;
import java.util.Scanner;

public class Trabalho03 {
	/**
	 * Faz a leitura dos vetores a partir da entrada padrao
	 * @param codigo vetor String  
	 * @param descricao vetor string
	 * @param custo vetor double
	 * @param estoque vetor int
	 */
	public static void lerTabela(String[] codigo, String[] descricao, double[] custo, int[] estoque) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		for(int i=0;i<codigo.length;i++) {
			System.out.println("Insira os dados do "+(i+1)+"º produto: ");
			System.out.print("Código: ");
			codigo[i] = sc.next();
			System.out.print("Produto: ");
			sc.nextLine();
			descricao[i] = sc.nextLine();
			System.out.print("Preço: ");
			custo[i] = sc.nextDouble();
			System.out.print("Quantidade: ");
			estoque[i] = sc.nextInt();
		}	
	}	
	/**
	 * Mostra na tela o menu de opções 
	 */
	public static void mostrarMenu() {
		System.out.println("\nMenu de opções:");
		System.out.println("--------------------------------------");
		System.out.println("1 – Imprimir tabela de todos produtos");
		System.out.println("2 – Pesquisar por um produto");
		System.out.println("3 – Mostrar produto mais caro do estoque");
		System.out.println("4 - Mostrar produto(s) com estoque abaixo de 10");
		System.out.println("5 – Ativo total do estoque");
		System.out.println("6 – Efetuar uma venda");
		System.out.println("7 - Sair");
		System.out.println("--------------------------------------");
		System.out.print("Digite a opção: ");
	}
	/**
	 * Função para tratar as opções do menu escolhidas pelo usuario
	 * @param op
	 * @param codigo
	 * @param descricao
	 * @param custo
	 * @param estoque
	 */
	public static void tratarMenu(int op, String[] codigo, String[] descricao, double[] custo, int[] estoque) {
		if (op == 1) {
			mostrarTabela(codigo, descricao, custo, estoque);
		} 
		else if (op == 2) {
			pesquisarProduto(codigo, descricao, custo, estoque); 
		}
		else if (op == 3) {
			mostrarMaisCaro(codigo, descricao, custo, estoque);
		}
		else if (op == 4) {
			mostrarEstoqueBaixo(codigo, descricao, estoque);
		}
		else if (op == 5) {
			mostrarAtivoTotal(custo, estoque);
		}
		else if (op == 6) {
			realizarVenda(codigo, descricao, custo, estoque);
		}
		else if (op == 7) {
			System.out.println("Programa encerrado.");
		}
		else {
			System.out.println("Opção inválida.");
		}
	}
	/**
	 * Imprime na tela a tabela com todos os vetores 
	 * @param codigo vetor String ja preenchido
	 * @param descricao vetor String ja preenchido
	 * @param custo vetor double ja preenchido
	 * @param estoque vetor int ja preenchido
	 */
	public static void mostrarTabela(String[] codigo, String[] descricao, double[] custo, int[] estoque) {
		System.out.println("\nCódigo\t | \tDescrição \t |   Preço(R$) \t | Quantidade");
		for(int i=0;i<codigo.length;i++) {
			System.out.println(codigo[i]+"\t | \t"+descricao[i]+" \t | \t"+custo[i]+" \t | "+estoque[i]);
		}
	}
	/**
	 * Localiza no vetor a posição que usuario digitou e mostra na tela
	 * @param codigo vetor string ja preenchido
	 */
	public static void pesquisarProduto(String[] codigo, String[] descricao, double[] custo, int[] estoque) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String pesquisa;
		System.out.print("\nDigite o código do produto: ");
		pesquisa = sc.nextLine();
		int pos=0;
		int cont=0;
		for(int i=0;i<codigo.length;i++) {
			if(codigo[i].equals(pesquisa)) {
				pos = i;
				cont++;
			}	
		}
		double custototal = 0;
		custototal = custo[pos] * estoque[pos];
		if(cont == 0) {
			System.out.println("Este código de produto não existe.");
		}
		else { 
			System.out.println("\nCódigo\t | \tDescrição\t |  Preço(R$) \t | Quantidade");
			System.out.println(codigo[pos]+"\t | \t"+descricao[pos]+"\t | \t"+custo[pos]+"\t | "+estoque[pos]);
			System.out.printf("Valor total: R$%.2f\n",custototal);
		}	
	}
	/**
	 * Imprime na tela a o codigo,descricao,custo e quantidade do produto mais caro cadastrado
	 * @param codigo vetor String ja preenchido
	 * @param descricao vetor String ja preenchido
	 * @param custo vetor double ja preenchido
	 * @param estoque vetor int ja preenchido
	 */
	public static void mostrarMaisCaro(String[] codigo, String[] descricao, double[] custo, int[] estoque) {
		int pos=0;
		for(int i=1;i<custo.length;i++) {
			if(custo[i] > custo[pos])
				pos = i;
		}
		System.out.println("\nProduto mais caro do estoque:");
		System.out.println("\nCódigo\t |\t Descrição\t |\t Preço (R$) | Quantidade");
		System.out.println(codigo[pos]+"\t |\t "+descricao[pos]+"\t |\t "+custo[pos]+"\t | "+estoque[pos]);
	}
	/**
	 * Imprime na tela o codigo e descricao do(s) produto(s) com estoque baixo de 10 unidades
	 * @param codigo vetor String ja preenchido
	 * @param descricao vetor String ja preenchido
	 * @param estoque vetor int ja preenchido
	 */
	public static void mostrarEstoqueBaixo(String[] codigo, String[] descricao, int[] estoque) {
		System.out.println("\nProduto(s) com estoque abaixo de 10 unidades:");
		System.out.println("\nCódigo\t | Descrição");
		for(int i=0;i<estoque.length;i++) {
			if(estoque[i] < 10){
				System.out.println(codigo[i]+"\t | "+descricao[i]);
			}
		}
	}
	/**
	 * Imprime na tela o valor total (custo x estoque)
	 * @param custo Vetor double ja preenchido
	 * @param estoque Vetor int ja preenchido
	 */
	public static void mostrarAtivoTotal(double[] custo, int[] estoque) {
		double custototal=0;
		for(int i=0;i<custo.length;i++) {
			custototal = custototal + custo[i] * estoque[i];
		}
		System.out.printf("\nAtivo total no estoque: R$%.2f\n",custototal);
	}
	/**
	 * Localiza no vetor a posição que usuario digitou, apos produto localizado pede q usuario digite a
	 * quantidade para ser debitada
	 * @param codigo vetor ja preenchido
	 * @param descricao vetor ja preenchido
	 * @param custo vetor ja preenchido
	 * @param estoque vetor ja preenchido
	 */
	public static void realizarVenda(String[] codigo, String[] descricao, double[] custo, int[] estoque) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String pesquisa,conf;
		int qtdvenda;
		double venda;
		System.out.print("\nDigite o código do produto para venda: ");
		pesquisa = sc.nextLine();
		int pos=0;
		int cont=0;
		for(int i=0;i<codigo.length;i++) {
			if(codigo[i].equals(pesquisa)) {
				pos = i;
				cont++;
			}	
		}
		if(cont == 0) {
			System.out.println("Este código de produto não existe.");
		}
		else { 
			System.out.println("\nCódigo\t | \tDescrição \t | \tPreço (R$) \t | Quantidade");
			System.out.println(codigo[pos]+"\t | \t"+descricao[pos]+" \t | \t"+custo[pos]+" \t | "+estoque[pos]);
			if (estoque[pos] <= 0) {
				System.out.println("Venda cancelada: estoque insuficiente.");
			}
			else {
				System.out.print("\nQuantidade a ser vendida: ");
				qtdvenda = sc.nextInt();
				venda = qtdvenda * custo[pos];
				if(qtdvenda <= 0) {
					System.out.println("Venda cancelada.");
				}
				else if(qtdvenda > estoque[pos]) {
					System.out.println("Venda cancelada: estoque insufuciente.");
				}
				else {
				System.out.println("Pedido: "+qtdvenda+" x "+descricao[pos]+". Valor da venda: R$"+venda);
					System.out.print("Confirmar venda:(S)im ou (N)ão?");
					conf = sc.next();
						if(conf.equalsIgnoreCase("s")) {
							estoque[pos] = estoque[pos] - qtdvenda;
							System.out.println("Pedido feito com sucesso.");
						}
						else  {
							System.out.println("Venda cancelada");
						}
				}				
			}					
		}		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc.useLocale(Locale.ENGLISH);
		Locale.setDefault(new Locale("en", "US"));
		
		int N,op;
		
		System.out.print("Quantos produtos irá cadastrar?");
		N = sc.nextInt();
		
		String c[] = new String[N];
		String d[] = new String[N];
		double p[] = new double[N];
		int q[] = new int[N];
		
		lerTabela(c, d, p, q);
		
		op=0;
		while(op != 7) {
			mostrarMenu();
			op = sc.nextInt();
			tratarMenu(op, c, d, p, q);
		}
			
	sc.close();	
	}
}