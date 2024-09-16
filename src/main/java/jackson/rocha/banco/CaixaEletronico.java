package jackson.rocha.banco;

public class CaixaEletronico {

    public static final double TARIFA_TRANSFERENCIA = 10;

    public void transferir(ContaEspecial contaOrigen, ContaEspecial contaDestino,
                           double valorTransferencia) {
        System.out.printf("Transferindo R$%.2f da conta %d/%d para %d/%d%n", valorTransferencia,
                contaOrigen.getAgencia(), contaOrigen.getNumero(), contaDestino.getAgencia(),
                contaDestino.getNumero());

        contaOrigen.sacar(valorTransferencia + TARIFA_TRANSFERENCIA);
        contaDestino.depositar(valorTransferencia);
    }
}
