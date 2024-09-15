package jackson.rocha.banco;

public class ContaInvestimento extends Conta {

    private double valorTotalRendimento;

    public ContaInvestimento() {
    }

    public double getValorTotalRendimento() {
        return valorTotalRendimento;
    }

    public void creditarRendimento(double porcentualJuros) {
        double valorRendimentos = getSaldo() * porcentualJuros / 100;
        this.valorTotalRendimento += valorRendimentos;
        depositar(valorRendimentos);
    }
}
