package jackson.rocha;

import jackson.rocha.banco.Conta;
import jackson.rocha.banco.Titular;

public class Principal1 {
    public static void main(String[] args) {
        Titular titular = new Titular("Jackson", "01422222160");
        Conta conta1 = new Conta(titular, 1234, 999999);

        conta1.imprimirDemonstrativo();

        conta1.depositar(100);
        conta1.imprimirDemonstrativo();

        conta1.sacar(27.5);
        conta1.imprimirDemonstrativo();
    }
}
