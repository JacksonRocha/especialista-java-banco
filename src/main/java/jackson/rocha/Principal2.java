package jackson.rocha;

import jackson.rocha.banco.ContaInvestimento;
import jackson.rocha.banco.Titular;

public class Principal2 {
    public static void main(String[] args) {
        Titular titular = new Titular("Jackson", "01422222160");
        ContaInvestimento conta1 = new ContaInvestimento(titular, 1234, 999999);

        conta1.imprimirDemonstrativo();

        conta1.depositar(100);
        conta1.imprimirDemonstrativo();

        conta1.creditarRendimento(6);
        conta1.imprimirDemonstrativo();
    }
}
