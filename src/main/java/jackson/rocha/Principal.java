package jackson.rocha;

import jackson.rocha.banco.*;

public class Principal {

    public static void main(String[] args) {
        CaixaEletronico caixaEletronico = new CaixaEletronico();

        ContaEspecial conta1 = new ContaEspecial(new Titular("Jackson", "01422222160"), 1234, 999999, 90);
        conta1.setLimiteChequeEspecial(1000);

        ContaInvestimento conta2 = new ContaInvestimento(new Titular("Jackson", "01422222160"), 1234, 999999);
        conta2.depositar(100);
        conta2.creditarRendimento(10);

        ContaSalario conta3 = new ContaSalario(new Titular("Jackson", "01422222160"), 1234, 999999, 18.000);
        conta2.depositar(100);

        caixaEletronico.imprimirDemonstrativo(conta3);

    }
}
