package com.game.tictactoe;

import java.util.Random;

public class ComputadorB {
	
	public static void jogar (char [][] tab){
		/*** Na dificuldade média, representada pelo ComputadorB, será  analisado, através das condições abaixo, se há duas 
		 * posições em sequência do computador. Cajo haja dois símbolos 'O' em sequência, o computador irá inserir na posição
		 * seguinte, garantindo a vitória.
		 * ***/
		
		
		Random aleatorio = new Random();
		int vezDoComputador;
		
		while (true) {
			vezDoComputador = aleatorio.nextInt(9) + 1; //Gera a posição de 1 a 9
			if((Tabuleiro.tab[0][0] == 'O' && Tabuleiro.tab[0][1] == 'O') || (Tabuleiro.tab[2][2] == 'O' && Tabuleiro.tab[1][2] == 'O')) {
				vezDoComputador = 3;
				break;
			} else if ((Tabuleiro.tab[0][0] == 'O' && Tabuleiro.tab[1][0] == 'O') || (Tabuleiro.tab[0][2] == 'O' && Tabuleiro.tab[1][1] == 'O')){
				vezDoComputador = 7;
				break;
			} else if ((Tabuleiro.tab[0][0] == 'O' && Tabuleiro.tab[1][1] == 'O') || (Tabuleiro.tab[0][2] == 'O' && Tabuleiro.tab[1][2] == 'O')) {
				vezDoComputador = 9;
				break;
			} else if ((Tabuleiro.tab[0][1] == 'O' && Tabuleiro.tab[0][2] == 'O') || (Tabuleiro.tab[1][0] == 'O' && Tabuleiro.tab[2][0] == 'O')) {
				vezDoComputador = 1;
				break;
			} else if ((Tabuleiro.tab[0][1] == 'O' && Tabuleiro.tab[1][1] == 'O') || (Tabuleiro.tab[2][0] == 'O' && Tabuleiro.tab[2][2] == 'O')) {
				vezDoComputador = 8;
				break;
			} else if ((Tabuleiro.tab[0][0] == 'O' && Tabuleiro.tab[0][2] == 'O') || (Tabuleiro.tab[1][1] == 'O' && Tabuleiro.tab[2][1] == 'O')) {
				vezDoComputador = 2;
				break;
			} else if ((Tabuleiro.tab[0][0] == 'O' && Tabuleiro.tab[2][0] == 'O') || (Tabuleiro.tab[1][1] == 'O' && Tabuleiro.tab[1][2] == 'O')) {
				vezDoComputador = 4;
				break;
			} else if ((Tabuleiro.tab[0][1] == 'O' && Tabuleiro.tab[2][1] == 'O') || (Tabuleiro.tab[1][0] == 'O' && Tabuleiro.tab[1][2] == 'O')) {
				vezDoComputador = 5;
				break;
			} else if ((Tabuleiro.tab[0][2] == 'O' && Tabuleiro.tab[2][2] == 'O') || (Tabuleiro.tab[1][0] == 'O' && Tabuleiro.tab[1][1] == 'O')) {
				vezDoComputador = 6;
				break;
			}
			if (Jogo.Disponibilidade(Tabuleiro.tab, Integer.toString(vezDoComputador))) {
				break;
			}
		}
		System.out.println("Computador escolheu " + vezDoComputador);
		Tabuleiro.colocar(Tabuleiro.tab, Integer.toString(vezDoComputador), 'O'); //Converte a posição para o símbolo do tabuleiro
	}
}
