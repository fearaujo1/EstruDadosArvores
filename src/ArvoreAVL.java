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

}
