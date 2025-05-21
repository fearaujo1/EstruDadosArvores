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
}
