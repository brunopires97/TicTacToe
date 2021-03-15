package com.game.tictactoe;

import java.util.Random;

public class ComputadorA {
	
	public static void jogar (char [][] tab){
		/*** Na dificuldade fácil, representada pelo ComputadorA, será apenas gerado uma posição aleatória no tabuleiro ***/
		
		
		Random aleatorio = new Random();
		int vezDoComputador;
		
		while (true) {
			vezDoComputador = aleatorio.nextInt(9) + 1; //Gera a posição de 1 a 9
			if (Jogo.Disponibilidade(Tabuleiro.tab, Integer.toString(vezDoComputador))) {
				break;
			}
		}
		System.out.println("Computador escolheu " + vezDoComputador);
		Tabuleiro.colocar(Tabuleiro.tab, Integer.toString(vezDoComputador), 'O'); //Converte a posição para o símbolo do tabuleiro
	}
}
