class Pilha implements IEstruturaDeDados {
    private int[] elementos;
    private int topo;

    public Pilha(int capacidade) { // 10
        this.elementos = new int[capacidade];
        this.topo = -1; // Pilha vazia
    }

    @Override
    public void adicionar(int valor) {
        if (topo == elementos.length - 1) {
            throw new RuntimeException("A pilha está cheia!");
        }
        elementos[++topo] = valor;
    }

    @Override
    public int remover() { //pop()
        if (estaVazia()) {
            throw new RuntimeException("A pilha está vazia!");
        }
        return elementos[topo--];
    }

    @Override
    public int tamanho() {
        return topo + 1;
    }

    @Override
    public boolean estaVazia() {
        return topo == -1;
    }

    public int peek() {
        if (estaVazia()) {
            throw new RuntimeException("A pilha está vazia!");
        }
        return elementos[topo];
    }
}