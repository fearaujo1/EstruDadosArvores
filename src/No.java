public class No {
    String conteudo;
    No filhoEsquerdo;
    No filhoDireito;

    public No(String conteudo) {
        this.conteudo = conteudo;
        filhoEsquerdo = filhoDireito = null;
    }
}
