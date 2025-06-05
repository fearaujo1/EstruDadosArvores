public class Main {
    public static void main(String[] args) {
        ArvoreAVL arvoreAVL = new ArvoreAVL();

        arvoreAVL.node = arvoreAVL.insertItem(arvoreAVL.node, 6);
        arvoreAVL.node = arvoreAVL.insertItem(arvoreAVL.node, 4);
        arvoreAVL.node = arvoreAVL.insertItem(arvoreAVL.node, 7);
        arvoreAVL.node = arvoreAVL.insertItem(arvoreAVL.node,2);
        arvoreAVL.node = arvoreAVL.insertItem(arvoreAVL.node,5);
        arvoreAVL.node = arvoreAVL.insertItem(arvoreAVL.node,9);
        arvoreAVL.node = arvoreAVL.insertItem(arvoreAVL.node,11);


        System.out.println("Árvore Pré Ordem");
        arvoreAVL.OrderAndPrintPreOrder(arvoreAVL.node);
        System.out.println("================");
    }
}
