public class NoRedBlack {
    int key;
    Color color;
    NoRedBlack filhoEsquerdo, filhoDireito, parent;

    NoRedBlack(int key) {
        this.key = key;
        this.color = Color.RED;
        this.filhoEsquerdo = null;
        this.filhoDireito = null;
        this.parent = null;
    }
}
