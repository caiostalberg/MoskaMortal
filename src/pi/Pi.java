/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author victor.wdebaza
 */
public class Pi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner ler = new Scanner(System.in);
        int j1 = 0, j2 = 0;
        int[][] arena = new int[1][1];
        boolean esmagou = false;
        //Pedir tamanho da arena
        int op = menuArena();
        switch (op) {
            case 1:
                arena = new int[3][3];
                //desenhaArena(arena);
                break;
            case 2:
                arena = new int[6][6];
                //desenhaArena(arena);
                break;
            case 3:
                arena = new int[12][12];
                //desenhaArena(arena);
                break;
            default:
                System.out.println("Opção inválida");
        }
        //Inicia o jogo
        while (j1 != 5) {
            desenhaArena(arena);
            arena = posicaoMosca(arena);
            System.out.println("Digite a coluna do tapa:");
            int colunaTapa = ler.nextInt();
            System.out.println("Digite a linha do tapa:");
            int linhaTapa = ler.nextInt();
            if (arena[colunaTapa - 1][linhaTapa - 1] == 1) {
                esmagou = true;
                splash();
                j1++;

                System.out.println("PONTUAÇÃO: " + j1);
            }

            //conferir acerto
            //
        }// fim do while

    }

    public static int menuJogo() {
        Scanner ler = new Scanner(System.in);
        System.out.println("Bem vindo a Moska Mortal");
        System.out.println("1. Jogar");
        System.out.println("2. Opções");
        int op = ler.nextInt();
        return op;
    }

    public static int menuArena() {
        Scanner ler = new Scanner(System.in);
        System.out.println("Selecione o tamanho da arena");
        System.out.println("1. pequena");
        System.out.println("2. Média");
        System.out.println("3. Grande");
        System.out.print("Opção: ");
        int op = ler.nextInt();
        return op;
    }

    public static int[][] posicaoMosca(int[][] arena) {
        int linha, coluna;
        Random gp = new Random();
        linha = gp.nextInt(arena.length - 1);// pega tamanho da arena -1 pra não estourar o array
        coluna = gp.nextInt(arena.length - 1);// pega tamanho da arena -1 pra não estourar o array
        System.out.println(linha + " , " + coluna);
        int[][] novapos = new int[arena.length][arena.length];// cria novo array - copia do anterior

        novapos[linha][coluna] = 1;// cria novo array com a posição da mosca
        //System.out.println(linha + " "+ coluna);
        return novapos; // retorna ao main o novo array
    }

    public static void desenhaArena(int[][] arena) {
        System.out.println("");
        for (int linha = 0; linha < arena.length; linha++) {

            for (int coluna = 0; coluna < arena.length; coluna++) {

                if (coluna == 0 || coluna == (arena.length)) {
                    fundo("vermelho");
                    System.out.print("||");
                    reset();

                }

                if (arena[linha][coluna] == 1) {
                    System.out.print(" 8 ");
                }

                if (arena[linha][coluna] != 1 && arena[linha][coluna] == 0) {
                    fundo("branco");
                    System.out.print(" . ");
                    reset();
                }

            }
            fundo("vermelho");
            System.out.println("||");
            reset();
        }

    }

    public static void cor(String cor) {
        int valor = 0;

        switch (cor.toLowerCase()) {
            case "preto":
            case "preta":
                valor = 30;
                break;
            case "vermelho":
            case "vermelha":
                valor = 31;
                break;
            case "verde":
                valor = 32;
                break;
            case "amarelo":
            case "amarela":
                valor = 33;
                break;
            case "azul":
                valor = 34;
                break;
            case "magenta":
                valor = 35;
                break;
            case "ciano":
                valor = 36;
                break;
            case "branco":
            case "branca":
                valor = 37;
                break;
        }

        System.out.printf("\u001b[%dm", valor);
    }

    public static void splash() {
        char[] c1 = ("  _________      .__          _____  __  ._._._.").toCharArray();
        char[] c2 = (" /   _____/_____ |  | _____ _/ ____\\/  |_| | | |").toCharArray();
        char[] c3 = (" \\_____  \\\\____ \\|  | \\__  \\\\   __\\\\   __\\ | | |").toCharArray();
        char[] c4 = (" /        \\  |_> >  |__/ __ \\|  |   |  |  \\|\\|\\|").toCharArray();
        char[] c5 = ("/_______  /   __/|____(____  /__|   |__|  ______").toCharArray();
        char[] c6 = ("        \\/|__|             \\/             \\/\\/\\/").toCharArray();
        ArrayList<char[]> splash = new ArrayList<>();
        splash.add(c1);
        splash.add(c2);
        splash.add(c3);
        splash.add(c4);
        splash.add(c5);
        splash.add(c6);
        splash.forEach((linha) -> {
            int numer = linha.length;
            for (int i = 0; i < numer; i++) {
                negrito(true);
                cor("preto");
                fundo("verde");
                System.out.print(linha[i]);
                /*fundo("vermelho");
                System.out.print(linha[i]);*/

            }
            System.out.println("");
        });
    }

    public static void fundo(String cor) {
        int valor = 0;

        switch (cor.toLowerCase()) {
            case "preto":
            case "preta":
                valor = 40;
                break;
            case "vermelho":
            case "vermelha":
                valor = 41;
                break;
            case "verde":
                valor = 42;
                break;
            case "amarelo":
            case "amarela":
                valor = 43;
                break;
            case "azul":
                valor = 44;
                break;
            case "magenta":
                valor = 45;
                break;
            case "ciano":
                valor = 46;
                break;
            case "branco":
            case "branca":
                valor = 47;
                break;
        }

        System.out.printf("\u001b[%dm", valor);
    }

    public static void negrito(boolean ligado) {
        if (ligado) {
            System.out.printf("\u001b[100m");
        } else {
            System.out.printf("\u001b[22m");
        }
    }

    public static void reset() {
        System.out.printf("\u001b[0m");
    }

    public static void limpaTela() {
        System.out.printf("\u001b[2J");
    }

}
