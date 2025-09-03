import java.util.Scanner;

public class Main {

    private static String inverterComPilha(String palavra) {
        String normalizada = palavra.toLowerCase();
        Pilha pilha = new Pilha(normalizada.length());

        for (int i = 0; i < normalizada.length(); i++) {
            pilha.adicionar((int) normalizada.charAt(i));
        }

        StringBuilder invertida = new StringBuilder(normalizada.length());
        while (!pilha.estaVazia()) {
            invertida.append((char) pilha.remover());
        }

        return invertida.toString();
    }

    private static boolean ehPalindromo(String palavra) {
        if (palavra == null) return false;

        String normalizada = palavra.toLowerCase();
        String invertida = inverterComPilha(normalizada);

        return normalizada.equals(invertida);
    }

    public static void main(String[] args) {
        System.out.println("=== Verificador de Palíndromos (usando Pilha do projeto) ===");
        System.out.println("Digite uma palavra (ENTER vazio sai):");

        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                System.out.print("> ");
                String entrada = sc.nextLine();
                if (entrada == null || entrada.isBlank()) {
                    System.out.println("Encerrando...");
                    break;
                }

                String normalizada = entrada.toLowerCase();
                String invertida = inverterComPilha(entrada);
                boolean palindromo = ehPalindromo(entrada);

                System.out.println("Original : " + normalizada);
                System.out.println("Invertida: " + invertida);
                System.out.println("Resultado: " + (palindromo ? "É palíndromo ✅" : "Não é palíndromo ❌"));
                System.out.println();
            }
        }
    }
}
