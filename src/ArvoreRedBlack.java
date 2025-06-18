public class ArvoreRedBlack {
    private NoRedBlack root;
    private final NoRedBlack NIL;

    public ArvoreRedBlack() {
        NIL = new NoRedBlack(-1);
        NIL.color = Color.BLACK;
        NIL.filhoEsquerdo = NIL.filhoDireito = NIL.parent = null;
        root = NIL;
    }
}
