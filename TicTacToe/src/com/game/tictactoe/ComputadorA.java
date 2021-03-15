package com.game.tictactoe;

import java.util.Random;

public class ComputadorA {
	
	public static void jogar (char [][] tab){
		/*** Na dificuldade f�cil, representada pelo ComputadorA, ser� apenas gerado uma posi��o aleat�ria no tabuleiro ***/
		
		
		Random aleatorio = new Random();
		int vezDoComputador;
		
		while (true) {
			vezDoComputador = aleatorio.nextInt(9) + 1; //Gera a posi��o de 1 a 9
			if (Jogo.Disponibilidade(Tabuleiro.tab, Integer.toString(vezDoComputador))) {
				break;
			}
		}
		System.out.println("Computador escolheu " + vezDoComputador);
		Tabuleiro.colocar(Tabuleiro.tab, Integer.toString(vezDoComputador), 'O'); //Converte a posi��o para o s�mbolo do tabuleiro
	}
}
