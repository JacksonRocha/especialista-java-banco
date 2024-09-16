package jackson.rocha;

import jackson.rocha.banco.Conta;
import jackson.rocha.banco.ContaSalario;
import jackson.rocha.banco.Titular;

public class Principal2 {

    public static void main(String[] args) {
        Titular titular = new Titular("Jackson", "01422222160");
        Conta conta = new ContaSalario(titular, 1234, 999999, 800.00);


    }
}
