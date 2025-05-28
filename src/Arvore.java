import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Arvore {
    No node;

    public int contarNos(No node) {
        if (node == null) return 0;
        return 1 + contarNos(node.filhoEsquerdo) + contarNos(node.filhoDireito);
    }

    public void searchPreOrder(No node) {
        if (node != null) {
            System.out.println(node.value + "  ");
            searchPreOrder(node.filhoEsquerdo);
            searchPreOrder(node.filhoDireito);
        }
    }

    public void searchInOrder(No node) {
        if(node != null) {
            searchInOrder(node.filhoEsquerdo);
            System.out.println(node.value + "  ");
            searchInOrder(node.filhoDireito);
        }
    }

    public void searchPostOrder(No node) {
        if (node != null) {
            searchPostOrder(node.filhoEsquerdo);
            searchPostOrder(node.filhoDireito);
            System.out.println(node.value + "  ");
        }
    }

    public void searchInLevel(No node) {
        if (node != null) {
            Queue<No> fila = new LinkedList<>();
            fila.add(node);

            while (!fila.isEmpty()) {
                No atual = fila.poll();
                System.out.println(atual.value + "  ");

                if(atual.filhoEsquerdo != null){
                    fila.add(atual.filhoEsquerdo);
                }
                if(atual.filhoDireito != null){
                    fila.add(atual.filhoDireito);
                }
            }
        }
    }

    public int contarNosIterativo(No node) {
        Stack<No> pilha = new Stack<No>();
        int contador = 0;

        if (node != null) {
            pilha.push(node);
        }

        while (!pilha.isEmpty()) {
            No atual = pilha.pop();
            contador++;
            if (atual.filhoEsquerdo != null) pilha.push(atual.filhoEsquerdo);
            if (atual.filhoDireito != null) pilha.push(atual.filhoDireito);
        }
        return contador;
    }

    public void searchPreOrderIterativo(No node) {
        Stack<No> pilha = new Stack<No>();
        if (node != null) {
            pilha.push(node);
        }
        while (!pilha.isEmpty()) {
            No atual = pilha.pop();
            System.out.println(atual.value + "  ");

            if(atual.filhoDireito != null) pilha.push(atual.filhoDireito);
            if(atual.filhoEsquerdo != null) pilha.push(atual.filhoEsquerdo);
        }
    }

    public void searchInOrderIterativo(No node) {
        Stack<No> pilha = new Stack<No>();

        while (node != null || !pilha.isEmpty()) {
            if (node != null) {
                pilha.push(node);
                node = node.filhoEsquerdo;
            } else {
                No atual = pilha.pop();
                System.out.println(atual.value + "  ");
                node = atual.filhoDireito;
            }
        }
    }
}
