package jackson.rocha;

import jackson.rocha.banco.Conta;
import jackson.rocha.banco.ContaEspecial;
import jackson.rocha.banco.Titular;

public class Principal1 {

    public static void main(String[] args) {
        Titular titular = new Titular("Jackson", "01422222160");
        ContaEspecial contaEspecial = new ContaEspecial(titular, 1234, 999999, 90);
        contaEspecial.setLimiteChequeEspecial(100);
        contaEspecial.depositar(300);

        contaEspecial.debitarTarifaMensal();

        Conta conta = contaEspecial;
//        Conta conta = (Conta) contaEspecial;

//        System.out.println(contaEspecial.getClass().getName());
//        System.out.println(conta.getClass().getName());
//
//        System.out.println(contaEspecial == conta);
    }
}
