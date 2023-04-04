import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] tabuleiro = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
        int jogadas = 0;
        char jogadorVencedor = ' ';
        char jogadorAtual = 'X';
        boolean jogoAcabou = false;
        while (!jogoAcabou) {
            System.out.println("  1 2 3");
            for (int i = 0; i < 3; i++) {
                System.out.print((i + 1) + " ");
                for (int j = 0; j < 3; j++) {
                    System.out.print(tabuleiro[i][j] + " ");
                }
                System.out.println();
            }

            System.out.println("Jogador " + jogadorAtual + ", digite a linha e a coluna da sua jogada separados por um espaço:");
            int linha = scanner.nextInt() - 1;
            int coluna = scanner.nextInt() - 1;

            if (linha < 0 || linha > 2 || coluna < 0 || coluna > 2) {
                System.out.println("Jogada inválida, tente novamente.");
                continue;
            }
            if (tabuleiro[linha][coluna] != ' ') {
                System.out.println("Jogada inválida, tente novamente.");
                continue;
            }

            tabuleiro[linha][coluna] = jogadorAtual;
            jogadas++;
            if (tabuleiro[linha][0] == jogadorAtual && tabuleiro[linha][1] == jogadorAtual && tabuleiro[linha][2] == jogadorAtual) {
                jogoAcabou = true;
                jogadorVencedor = jogadorAtual;
            } else if (tabuleiro[0][coluna] == jogadorAtual && tabuleiro[1][coluna] == jogadorAtual && tabuleiro[2][coluna] == jogadorAtual) {
                jogoAcabou = true;
                jogadorVencedor = jogadorAtual;
            } else if (tabuleiro[0][0] == jogadorAtual && tabuleiro[1][1] == jogadorAtual && tabuleiro[2][2] == jogadorAtual) {
                jogoAcabou = true;
                jogadorVencedor = jogadorAtual;
            } else if (tabuleiro[0][2] == jogadorAtual && tabuleiro[1][1] == jogadorAtual && tabuleiro[2][0] == jogadorAtual) {
                jogoAcabou = true;
                jogadorVencedor = jogadorAtual;
            }

            if (!jogoAcabou && jogadas == 9) {
                System.out.println("Empate!");
                jogoAcabou = true;
            }

            if (jogadorAtual == 'X') {
                jogadorAtual = 'O';
            } else {
                jogadorAtual = 'X';
            }
        }

        System.out.println("  1 2 3");

        for (int i = 0; i < 3; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(tabuleiro[i][j] + " ");
            }
            System.out.println();
        }
        if (jogoAcabou) {
            System.out.print("O jogador vencededor é o: " +jogadorVencedor);
        }

    }
}