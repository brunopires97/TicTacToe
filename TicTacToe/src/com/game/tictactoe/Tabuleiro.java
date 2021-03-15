package com.game.tictactoe;

public class Tabuleiro {
	
	public static char tab[][] = new char[3][3];
	
	public static void printTabuleiro (char[][] tab){ //Método que printa o tabuleiro
	
	System.out.println(tab[0][0] + "|" + tab[0][1] + "|" + tab[0][2]);
	System.out.println("-+-+-");
	System.out.println(tab[1][0] + "|" + tab[1][1] + "|" + tab[1][2]);
	System.out.println("-+-+-");
	System.out.println(tab[2][0] + "|" + tab[2][1] + "|" + tab[2][2]);
	}
	
	public static void colocar(char[][] tab, String posicao, char simbolo) { //Método que faz a colocação do simbolo, seja para o humano ou para o computador
		switch (posicao) {
		case "1":
			tab[0][0] = simbolo;
			break;
		case "2":
			tab[0][1] = simbolo;
			break;
		case "3":
			tab[0][2] = simbolo;
			break;
		case "4":
			tab[1][0] = simbolo;
			break;
		case "5":
			tab[1][1] = simbolo;
			break;
		case "6":
			tab[1][2] = simbolo;
			break;
		case "7":
			tab[2][0] = simbolo;
			break;
		case "8":
			tab[2][1] = simbolo;
			break;
		case "9":
			tab[2][2] = simbolo;
			break;
		default:
			System.out.println(":(");
		}
	}
}
