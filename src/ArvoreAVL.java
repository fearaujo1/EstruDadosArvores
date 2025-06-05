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
}
