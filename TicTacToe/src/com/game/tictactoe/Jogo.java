package com.game.tictactoe;

import java.util.Scanner; //Import para fazer com que permita a entrada de informação.

public class Jogo { //Classe jogo é a classe principal.

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		Tabuleiro.tab = new char[][]{{' ', ' ', ' '},
									 {' ', ' ', ' '},
									 {' ', ' ', ' '}};
		
		Tabuleiro.printTabuleiro(Tabuleiro.tab); //Invoca o método printTabuleiro da classe Tabuleiro.
		
		Scanner escolha = new Scanner(System.in);
		System.out.println("Escolha uma dificuldade de 1 a 3");
		System.out.println("1 - Fácil");
		System.out.println("2 - Médio");
		System.out.println("3 - Difícil");
		int dif = escolha.nextInt();
		
		
		while(true) {
			Jogador.jogar(Tabuleiro.tab, scanner); //Invoca o método jogar dentro da classe Jogador, que permite com que o jogador faça um movimento.
			if(fimDoJogo(Tabuleiro.tab)) { //Caso seja o fim do jogo e não há mais movimentos, finaliza o loop.
				break;
			}
			Tabuleiro.printTabuleiro(Tabuleiro.tab); //Novamente faz o print do tabuleiro
			
			if (dif == 1) {
				ComputadorA.jogar(Tabuleiro.tab); //Invoca o método Jogar da classe Computador, permitindo o movimento da máquina
			} else if (dif == 2){
				ComputadorB.jogar(Tabuleiro.tab);
			} else {
				ComputadorC.jogar(Tabuleiro.tab);
			}
			if(fimDoJogo(Tabuleiro.tab)) { //Caso seja o fim do jogo e não há mais movimentos, finaliza o loop.
				break;
			}
			Tabuleiro.printTabuleiro(Tabuleiro.tab); //Novamente faz o print do tabuleiro
		}
		scanner.close(); //Fecha o scanner
		escolha.close();
	}
	
	private static boolean fimDoJogo(char [][] tab) { //Método para a verificação do final do jogo
		if (vencedor(Tabuleiro.tab, 'X')) { //Caso o método vencedor retorne X, significa que o humano venceu
			Tabuleiro.printTabuleiro(tab);
			System.out.println("O humano venceu!");
			return true;
		}
		
		if(vencedor(Tabuleiro.tab, 'O')) { //Caso retorne O, significa que a máquina venceu
			Tabuleiro.printTabuleiro(tab);
			System.out.println("O computador venceu!");
			return true;
		}
		
		for (int i = 0; i < Tabuleiro.tab.length; i++) { //Percorre a matriz do tabuleiro
			for (int j = 0; j < Tabuleiro.tab[i].length; j++) {
				if (Tabuleiro.tab[i][j] == ' ') { //Se houver espaços vazios e ninguém vence, é porque ainda tem movimentos a serem feitos
					return false;
				}
			}
		}
		Tabuleiro.printTabuleiro(tab); //Printa o tabuleiro de novo
		System.out.println("Empate!"); //Printa a palavra empate, caso as condições acima não forem satisfeitas
		return true;
	}
	
	private static boolean vencedor (char [][] tab, char simbolo) { //Método para verificar o vencedor
		if(
		   /*** Vencer por linhas ***/
		   (Tabuleiro.tab[0][0] == simbolo && Tabuleiro.tab[0][1] == simbolo && Tabuleiro.tab[0][2] == simbolo) ||
		   (Tabuleiro.tab[1][0] == simbolo && Tabuleiro.tab[1][1] == simbolo && Tabuleiro.tab[1][2] == simbolo) ||
		   (Tabuleiro.tab[2][0] == simbolo && Tabuleiro.tab[2][1] == simbolo && Tabuleiro.tab[2][2] == simbolo) ||
		   
		   /*** Vencer por colunas ***/
		   (Tabuleiro.tab[0][0] == simbolo && Tabuleiro.tab[1][0] == simbolo && Tabuleiro.tab[2][0] == simbolo) ||
		   (Tabuleiro.tab[0][1] == simbolo && Tabuleiro.tab[1][1] == simbolo && Tabuleiro.tab[2][1] == simbolo) ||
		   (Tabuleiro.tab[0][2] == simbolo && Tabuleiro.tab[1][2] == simbolo && Tabuleiro.tab[2][2] == simbolo) ||
		   
		   /*** Vencer por diagonais ***/
		   (Tabuleiro.tab[0][0] == simbolo && Tabuleiro.tab[1][1] == simbolo && Tabuleiro.tab[2][2] == simbolo) ||
		   (Tabuleiro.tab[0][2] == simbolo && Tabuleiro.tab[1][1] == simbolo && Tabuleiro.tab[2][0] == simbolo)) {
			return true;
		}
		return false;
	}
	
	public static boolean Disponibilidade (char[][] tab, String posicao){ //Método que verifica se há movimentos a serem feitos
		switch (posicao) {
		case "1":
			return (Tabuleiro.tab[0][0] == ' ');
		case "2":
			return (Tabuleiro.tab[0][1] == ' ');
		case "3":
			return (Tabuleiro.tab[0][2] == ' ');
		case "4":
			return (Tabuleiro.tab[1][0] == ' ');
		case "5":
			return (Tabuleiro.tab[1][1] == ' ');
		case "6":
			return (Tabuleiro.tab[1][2] == ' ');
		case "7":
			return (Tabuleiro.tab[2][0] == ' ');
		case "8":
			return (Tabuleiro.tab[2][1] == ' ');
		case "9":
			return (Tabuleiro.tab[2][2] == ' ');
		default:
			return false;
		}
	}
}
