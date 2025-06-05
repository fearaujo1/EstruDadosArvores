public class ArvoreAVL {
    NoAVL node;

    /*
    public int height(No node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.filhoEsquerdo), height(node.filhoDireito));
    }

    public void updateBalanceFactor(No node) {
        int heightLeft = height(node.filhoEsquerdo);
        int heightRight = height(node.filhoDireito);

        node.fatorBalanceamento = heightLeft - heightRight;
    }
    */

    public void updateHeightAndBalanceFactor(NoAVL node) {
        int heightLeft = (node.filhoEsquerdo != null) ? node.filhoEsquerdo.altura : 0;
        int heightRight = (node.filhoDireito != null) ? node.filhoDireito.altura : 0;

        node.altura = 1 + Math.max(heightLeft, heightRight);
        node.fatorBalanceamento = heightLeft - heightRight;
    }

    public NoAVL rotacaoDireita(NoAVL noDesbalanceado) {
        NoAVL noParaCima = noDesbalanceado.filhoEsquerdo;
        NoAVL subArvoreTemporaria = noParaCima.filhoDireito;

        noParaCima.filhoDireito = noDesbalanceado;
        noDesbalanceado.filhoEsquerdo = subArvoreTemporaria;

        updateHeightAndBalanceFactor(noDesbalanceado);
        updateHeightAndBalanceFactor(noParaCima);

        return noParaCima;
    }

    public NoAVL rotacaoEsquerda(NoAVL noDesbalanceado) {
        NoAVL noParaCima = noDesbalanceado.filhoDireito;
        NoAVL subArvoreTemporaria = noParaCima.filhoEsquerdo;

        noParaCima.filhoEsquerdo = noDesbalanceado;
        noDesbalanceado.filhoDireito = subArvoreTemporaria;

        updateHeightAndBalanceFactor(noDesbalanceado);
        updateHeightAndBalanceFactor(noParaCima);

        return noParaCima;
    }

    public NoAVL balance(NoAVL node) {
        updateHeightAndBalanceFactor(node);

        // Caso haja desbalanceio à esquerda
        if (node.fatorBalanceamento > 1) {
            if (node.filhoEsquerdo.fatorBalanceamento >= 0) {
                // Rotação simples à direita
                return rotacaoDireita(node);
            } else {
                // Rotação dupla à direita
                node.filhoEsquerdo = rotacaoEsquerda(node.filhoEsquerdo);
                return rotacaoDireita(node);
            }
        }

        // Caso haja desbalanceio à direita
        if (node.fatorBalanceamento < -1) {
            if (node.filhoDireito.fatorBalanceamento <= 0) {
                // Rotação simples à esquerda
                return rotacaoEsquerda(node);
            } else {
                // Rotação dupla à esquerda
                node.filhoDireito = rotacaoDireita(node.filhoDireito);
                return rotacaoEsquerda(node);
            }
        }
        return node;
    }

    public NoAVL insertItem(NoAVL node, int valor) {
        if (node == null) node = new NoAVL(valor);

        if (valor < node.value) {
            node.filhoEsquerdo = insertItem(node.filhoEsquerdo, valor);
        } else if (valor > node.value) {
            node.filhoDireito = insertItem(node.filhoDireito, valor);
        } else {
            return node;
        }

        updateHeightAndBalanceFactor(node);
        return balance(node);
    }

    private NoAVL encontrarMenor (NoAVL node){
        while (node.filhoEsquerdo != null) {
            node = node.filhoEsquerdo;
        }
        return node;
    }

    public NoAVL removeItem(NoAVL node, int valor) {
        // Caso o nó seja null
        if (node == null) return null;

        // Percorre a árvore encontrando o Nó
        if (valor < node.value) {
            node.filhoEsquerdo = removeItem(node.filhoEsquerdo, valor);
        } else if (valor > node.value) {
            node.filhoDireito = removeItem(node.filhoDireito, valor);
        } else {

            // Caso o nó encontrado não tenha filhos
            if (node.filhoEsquerdo == null && node.filhoDireito == null) {
                return null;

                // Caso o nó tenha um filho
            } else if (node.filhoEsquerdo == null) {
                return node.filhoDireito;
            } else if (node.filhoDireito == null) {
                return node.filhoEsquerdo;

                // Caso o nó tenha 2 filhos
            } else {
                // Encontra menor valor da subArvore à direita (Regra da árvore binária de busca)
                NoAVL sucessor = encontrarMenor(node.filhoDireito);
                node.value = sucessor.value;
                node.filhoDireito = removeItem(node.filhoDireito, valor);
            }
        }

        // Atualiza a árvore e faz o balanceamento
        updateHeightAndBalanceFactor(node);
        return balance(node);
    }
}
