public class NoAVL {
    int value;
    int fatorBalanceamento;
    int altura;
    NoAVL filhoEsquerdo;
    NoAVL filhoDireito;

    public NoAVL(int value) {
        this.value = value;
        this.filhoEsquerdo = null;
        this.filhoDireito = null;
        this.fatorBalanceamento = 0;
        this.altura = 0;
    }
}
