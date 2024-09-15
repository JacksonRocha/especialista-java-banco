package jackson.rocha;

import jackson.rocha.banco.Passaporte;

public class Principal5 {

    public static void main(String[] args) {
        Passaporte passaporte = new Passaporte("123456", "Brasil");

        System.out.println(passaporte);

    }
}
