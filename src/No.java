public class No {
    int value;
    int fatorBalanceamento;
    No filhoEsquerdo;
    No filhoDireito;

    public No(int value) {
        this.value = value;
        filhoEsquerdo = null;
        filhoDireito = null;
        fatorBalanceamento = 0;
    }
}
