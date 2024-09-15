package jackson.rocha;

import jackson.rocha.banco.Conta;
import jackson.rocha.banco.ContaEspecial;
import jackson.rocha.banco.Titular;

public class Principal6 {
    public static void main(String[] args) {
        Titular titular = new Titular("Jackson", "01422222160");
        Conta conta1 = new Conta(titular, 1234, 999999);
        Conta conta2 = new Conta(titular, 1234, 999999);
        ContaEspecial contaEspecial = new ContaEspecial(titular, 1234, 999999, 90);

        System.out.println(conta1.equals(conta2));
        System.out.println(conta1.equals(contaEspecial));
    }
}
