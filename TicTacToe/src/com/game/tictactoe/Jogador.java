package com.game.tictactoe;

import java.util.Scanner;

public class Jogador {

	public static void jogar (char [][] tab, Scanner scanner) { //Método que faz a jogada do humano
		String entrada;
		
		while (true) {
			System.out.println("Insira a posição  (1-9)");
			entrada = scanner.nextLine();
			System.out.println();
			if(Jogo.Disponibilidade(Tabuleiro.tab, entrada)) { //Se a jogada for válida
				break;
			} else {
				System.out.println(entrada + " não é uma posicao válida."); //Se não for, vai informar na tela
			}
		}
		Tabuleiro.colocar(Tabuleiro.tab, entrada, 'X'); //coloca o 'X' na posição que o jogador escolheu
	}
}
