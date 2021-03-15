package com.game.tictactoe;

import java.util.Scanner;

public class Jogador {

	public static void jogar (char [][] tab, Scanner scanner) { //M�todo que faz a jogada do humano
		String entrada;
		
		while (true) {
			System.out.println("Insira a posi��o  (1-9)");
			entrada = scanner.nextLine();
			System.out.println();
			if(Jogo.Disponibilidade(Tabuleiro.tab, entrada)) { //Se a jogada for v�lida
				break;
			} else {
				System.out.println(entrada + " n�o � uma posicao v�lida."); //Se n�o for, vai informar na tela
			}
		}
		Tabuleiro.colocar(Tabuleiro.tab, entrada, 'X'); //coloca o 'X' na posi��o que o jogador escolheu
	}
}
