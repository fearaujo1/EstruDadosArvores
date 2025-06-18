public class ArvoreRedBlack {
    private NoRedBlack root;
    private final NoRedBlack NIL;

    public ArvoreRedBlack() {
        NIL = new NoRedBlack(-1);
        NIL.color = Color.BLACK;
        NIL.filhoEsquerdo = NIL.filhoDireito = NIL.parent = null;
        root = NIL;
    }

    private void leftRotate(NoRedBlack x) {
        NoRedBlack y = x.filhoDireito;
        x.filhoDireito = y.filhoEsquerdo;
        if (y.filhoEsquerdo != NIL) y. filhoEsquerdo.parent = x;

        y.parent = x.parent;

        if(x.parent == null) root = y;
        else if (x == x.parent.filhoEsquerdo) x.parent.filhoEsquerdo = y;
        else x.parent.filhoDireito = y;

        y.filhoEsquerdo = x;
        x.parent = y;
    }

    private void rightRotate(NoRedBlack y) {
        NoRedBlack x = y.filhoDireito;
        y.filhoDireito = x.filhoEsquerdo;
        if (x.filhoEsquerdo != NIL) x.filhoEsquerdo.parent = y;

        x.parent = y.parent;

        if(y.parent == null) root = x;
        else if (y == y.parent.filhoEsquerdo) y.parent.filhoDireito = x;
        else y.parent.filhoEsquerdo = x;

        x.filhoDireito = y;
        y.parent = x;
    }
}
