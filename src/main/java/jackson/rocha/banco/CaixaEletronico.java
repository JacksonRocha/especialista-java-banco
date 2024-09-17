package jackson.rocha.banco;

public class CaixaEletronico {

    public static final double TARIFA_TRANSFERENCIA = 10;
    public static final double TARIFA_IMPRESSAO_DEMONSTRATIVO = 5;

    public void transferir(Conta contaOrigen, Conta contaDestino,
                           double valorTransferencia) {
        System.out.printf("Transferindo R$%.2f da conta %d/%d para %d/%d%n", valorTransferencia,
                contaOrigen.getAgencia(), contaOrigen.getNumero(), contaDestino.getAgencia(),
                contaDestino.getNumero());

        contaOrigen.sacar(valorTransferencia + TARIFA_TRANSFERENCIA);
        contaDestino.depositar(valorTransferencia);
    }

    public void imprimirDemonstrativo(Conta conta) {
        if (conta instanceof ContaInvestimento) {
            ContaInvestimento contaInvestimento = (ContaInvestimento) conta;

            if (contaInvestimento.getValorTotalRendimento() > 0) {
                System.out.println("Impressão do demonstrativo é gratuita!");
            } else {
                debitarTarifaImpressaoDemonstrativo(conta);
            }
        } else {
            debitarTarifaImpressaoDemonstrativo(conta);
        }

        conta.imprimirDemonstrativo();
    }

    private static void debitarTarifaImpressaoDemonstrativo(Conta conta) {
        System.out.printf("Custo da impressão: R$%.2f%n", TARIFA_IMPRESSAO_DEMONSTRATIVO);
        conta.sacar(TARIFA_IMPRESSAO_DEMONSTRATIVO);
    }
}
