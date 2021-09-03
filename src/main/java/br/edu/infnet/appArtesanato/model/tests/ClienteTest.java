package br.edu.infnet.appArtesanato.model.tests;

import br.edu.infnet.appArtesanato.model.domain.Cliente;

public class ClienteTest {
    public static void main(String[] args) {

        Cliente cliente = new Cliente("Cliente 01", "cliente01@gmail", "31-99999-9901");
        System.out.println("Cliente: " + cliente);
    }
}
