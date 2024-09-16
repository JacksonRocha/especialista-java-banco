package jackson.rocha.banco;

public class ContaSalario extends Conta {

    Double salarioMensal;

    public ContaSalario(Titular titular, int agencia, int numero, Double salarioMensal) {
        super(titular, agencia, numero);
        this.salarioMensal = salarioMensal;
    }

    public Double getSalarioMensal() {
        return salarioMensal;
    }

    public void setSalarioMensal(Double salarioMensal) {
        this.salarioMensal = salarioMensal;
    }
}
