package jackson.rocha;

import jackson.rocha.banco.ContaInvestimento;
import jackson.rocha.banco.Titular;

public class Principal2 {
    public static void main(String[] args) {
        ContaInvestimento conta1 = new ContaInvestimento();
        conta1.setTitular(new Titular("Jackson", "01422222160"));
        conta1.setAgencia(1234);
        conta1.setNumero(999999);

        conta1.imprimirDemonstrativo();

        conta1.depositar(100);
        conta1.imprimirDemonstrativo();

        conta1.creditarRendimento(6);
        conta1.imprimirDemonstrativo();
    }
}
