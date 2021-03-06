package com.game.tictactoe;

import java.util.Scanner; //Import para fazer com que permita a entrada de informa??o.

public class Jogo { //Classe jogo ? a classe principal.

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		Tabuleiro.tab = new char[][]{{' ', ' ', ' '},
									 {' ', ' ', ' '},
									 {' ', ' ', ' '}};
		
		Tabuleiro.printTabuleiro(Tabuleiro.tab); //Invoca o m?todo printTabuleiro da classe Tabuleiro.
		
		Scanner escolha = new Scanner(System.in);
		System.out.println("Escolha uma dificuldade de 1 a 3");
		System.out.println("1 - F?cil");
		System.out.println("2 - M?dio");
		System.out.println("3 - Dif?cil");
		int dif = escolha.nextInt();
		
		
		while(true) {
			Jogador.jogar(Tabuleiro.tab, scanner); //Invoca o m?todo jogar dentro da classe Jogador, que permite com que o jogador fa?a um movimento.
			if(fimDoJogo(Tabuleiro.tab)) { //Caso seja o fim do jogo e n?o h? mais movimentos, finaliza o loop.
				break;
			}
			Tabuleiro.printTabuleiro(Tabuleiro.tab); //Novamente faz o print do tabuleiro
			
			if (dif == 1) {
				ComputadorA.jogar(Tabuleiro.tab); //Invoca o m?todo Jogar da classe Computador, permitindo o movimento da m?quina
			} else if (dif == 2){
				ComputadorB.jogar(Tabuleiro.tab);
			} else {
				ComputadorC.jogar(Tabuleiro.tab);
			}
			if(fimDoJogo(Tabuleiro.tab)) { //Caso seja o fim do jogo e n?o h? mais movimentos, finaliza o loop.
				break;
			}
			Tabuleiro.printTabuleiro(Tabuleiro.tab); //Novamente faz o print do tabuleiro
		}
		scanner.close(); //Fecha o scanner
		escolha.close();
	}
	
	private static boolean fimDoJogo(char [][] tab) { //M?todo para a verifica??o do final do jogo
		if (vencedor(Tabuleiro.tab, 'X')) { //Caso o m?todo vencedor retorne X, significa que o humano venceu
			Tabuleiro.printTabuleiro(tab);
			System.out.println("O humano venceu!");
			return true;
		}
		
		if(vencedor(Tabuleiro.tab, 'O')) { //Caso retorne O, significa que a m?quina venceu
			Tabuleiro.printTabuleiro(tab);
			System.out.println("O computador venceu!");
			return true;
		}
		
		for (int i = 0; i < Tabuleiro.tab.length; i++) { //Percorre a matriz do tabuleiro
			for (int j = 0; j < Tabuleiro.tab[i].length; j++) {
				if (Tabuleiro.tab[i][j] == ' ') { //Se houver espa?os vazios e ningu?m vence, ? porque ainda tem movimentos a serem feitos
					return false;
				}
			}
		}
		Tabuleiro.printTabuleiro(tab); //Printa o tabuleiro de novo
		System.out.println("Empate!"); //Printa a palavra empate, caso as condi??es acima n?o forem satisfeitas
		return true;
	}
	
	private static boolean vencedor (char [][] tab, char simbolo) { //M?todo para verificar o vencedor
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
	
	public static boolean Disponibilidade (char[][] tab, String posicao){ //M?todo que verifica se h? movimentos a serem feitos
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
