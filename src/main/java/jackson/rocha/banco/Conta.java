package jackson.rocha.banco;

public class Conta {

    public static final int NORMAL = 0;
    public static final int INVESTIMENTO = 1;
    public static final int ESPECIAL = 2;

    private Titular titular;
    private int agencia;
    private int numero;
    private double saldo;
    private int tipo = NORMAL;

    // conta investimento
    private double valorTotalRendimento;

    // conta especial
    private double tarifaMensal;
    private double limiteChequeEspecial;

    public Titular getTitular() {
        return titular;
    }

    public void setTitular(Titular titular) {
        this.titular = titular;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getSaldoDisponivel() {
        return getSaldo() + getLimiteChequeEspecial();
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        if (tipo != NORMAL && tipo != INVESTIMENTO && tipo != ESPECIAL) {
            throw new IllegalArgumentException("Tipo inválido" + tipo);
        }
        this.tipo = tipo;

        if (tipo != ESPECIAL) {
            this.limiteChequeEspecial = 0;
        }
    }

    public double getValorTotalRendimento() {
        return valorTotalRendimento;
    }

    public double getTarifaMensal() {
        return tarifaMensal;
    }

    public void setTarifaMensal(double tarifaMensal) {
        this.tarifaMensal = tarifaMensal;
    }

    public double getLimiteChequeEspecial() {
        return limiteChequeEspecial;
    }

    public void setLimiteChequeEspecial(double limiteChequeEspecial) {
        if (getTipo() != ESPECIAL) {
            throw new RuntimeException("Esse tipo de conta não permite limite de cheque especial");
        }
        this.limiteChequeEspecial = limiteChequeEspecial;
    }

    public void creditarRendimento(double porcentualJuros) {
        if (getTipo() == INVESTIMENTO || getTipo() == ESPECIAL) {
            double valorRendimentos = getSaldo() * porcentualJuros / 100;
            this.valorTotalRendimento += valorRendimentos;
            depositar(valorRendimentos);
        } else {
            throw new RuntimeException("Pode creditar rendimentos nesse tipo de conta");
        }
    }

    public void sacar(double valorSaque) {
        if (valorSaque <= 0) {
            throw new IllegalArgumentException("Valor do saque deve ser maior que zero");
        }
        if (getSaldoDisponivel() < valorSaque) {
            throw new RuntimeException("Saldo insuficiente para saque");
        }
        saldo -= valorSaque;
    }

    public void depositar(double valorDeposito) {
        if (valorDeposito <= 0) {
            throw new IllegalArgumentException("Valor do deposito deve ser maior que zero");
        }
        saldo += valorDeposito;
    }

    public void imprimirDemonstrativo() {
        System.out.println();
        System.out.printf("Agência: %d%n", getAgencia());
        System.out.printf("Conta: %d%n", getNumero());
        System.out.printf("Titular: %s%n", getTitular().getNome());
        System.out.printf("Saldo: %.2f%n", getSaldo());
        System.out.printf("Saldo disponível: %.2f%n", getSaldoDisponivel());
    }

    public void debitarTarifaMensal() {
        if (getTipo() == ESPECIAL) {
            sacar(getTarifaMensal());
        } else {
            throw new RuntimeException("Não pode debitar tarifa mensal nesse tipo de conta");
        }
    }
}
