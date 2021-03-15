package com.game.tictactoe;

import java.util.Random;

public class ComputadorC {
	
	public static void jogar (char [][] tab){
		Random aleatorio = new Random();
		int vezDoComputador;
		
		/*** Na dificuldade difícil, representada pelo ComputadorC, será gerado um número aleatório, mas, caso alguma das condições 
		 * abaixo sejam satisfeitas, será alterada para uma posição que impeça o humano de vencer.
		 * As condições são simples, caso duas posições em sequência estejam com o símbolo 'X', o computador irá colocar 'O' na 
		 * posição seguinte do tabuleiro, impedindo a vitória do humano.
		 * Essa análise é muito parecida com a dificuldade anterior, mas com um comportamento diferente.
		 ***/
		
		while (true) {
			vezDoComputador = aleatorio.nextInt(9) + 1;
			if((Tabuleiro.tab[0][0] == 'X' && Tabuleiro.tab[0][1] == 'X') || (Tabuleiro.tab[2][2] == 'X' && Tabuleiro.tab[1][2] == 'X')) {
				vezDoComputador = 3;
				break;
			} else if ((Tabuleiro.tab[0][0] == 'X' && Tabuleiro.tab[1][0] == 'X') || (Tabuleiro.tab[0][2] == 'X' && Tabuleiro.tab[1][1] == 'X')){
				vezDoComputador = 7;
				break;
			} else if ((Tabuleiro.tab[0][0] == 'X' && Tabuleiro.tab[1][1] == 'X') || (Tabuleiro.tab[0][2] == 'X' && Tabuleiro.tab[1][2] == 'X')) {
				vezDoComputador = 9;
				break;
			} else if ((Tabuleiro.tab[0][1] == 'X' && Tabuleiro.tab[0][2] == 'X') || (Tabuleiro.tab[1][0] == 'X' && Tabuleiro.tab[2][0] == 'X')) {
				vezDoComputador = 1;
				break;
			} else if ((Tabuleiro.tab[0][1] == 'X' && Tabuleiro.tab[1][1] == 'X') || (Tabuleiro.tab[2][0] == 'X' && Tabuleiro.tab[2][2] == 'X')) {
				vezDoComputador = 8;
				break;
			} else if ((Tabuleiro.tab[0][0] == 'X' && Tabuleiro.tab[0][2] == 'X') || (Tabuleiro.tab[1][1] == 'X' && Tabuleiro.tab[2][1] == 'X')) {
				vezDoComputador = 2;
				break;
			} else if ((Tabuleiro.tab[0][0] == 'X' && Tabuleiro.tab[2][0] == 'X') || (Tabuleiro.tab[1][1] == 'X' && Tabuleiro.tab[1][2] == 'X')) {
				vezDoComputador = 4;
				break;
			} else if ((Tabuleiro.tab[0][1] == 'X' && Tabuleiro.tab[2][1] == 'X') || (Tabuleiro.tab[1][0] == 'X' && Tabuleiro.tab[1][2] == 'X')) {
				vezDoComputador = 5;
				break;
			} else if ((Tabuleiro.tab[0][2] == 'X' && Tabuleiro.tab[2][2] == 'X') || (Tabuleiro.tab[1][0] == 'X' && Tabuleiro.tab[1][1] == 'X')) {
				vezDoComputador = 6;
				break;
			}
			if (Jogo.Disponibilidade(Tabuleiro.tab, Integer.toString(vezDoComputador))) {
				break;
			}
		}
		System.out.println("Computador escolheu " + vezDoComputador);
		Tabuleiro.colocar(Tabuleiro.tab, Integer.toString(vezDoComputador), 'O');
	}
}