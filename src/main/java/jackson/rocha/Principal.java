package jackson.rocha;

import jackson.rocha.banco.CaixaEletronico;
import jackson.rocha.banco.ContaEspecial;
import jackson.rocha.banco.Titular;

public class Principal {

    public static void main(String[] args) {
        CaixaEletronico caixaEletronico = new CaixaEletronico();

        ContaEspecial conta1 = new ContaEspecial(new Titular("Jackson", "01422222160"), 1234, 999999, 90);
        conta1.setLimiteChequeEspecial(100);

        ContaEspecial conta2 = new ContaEspecial(new Titular("Helen", "12309898567"), 2222, 888888888, 90);


        conta1.depositar(300);

        caixaEletronico.transferir(conta1, conta2, 50);
        conta1.imprimirDemonstrativo();
        conta2.imprimirDemonstrativo();
    }
}
