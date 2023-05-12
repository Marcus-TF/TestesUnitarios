package com.testesunitarios.service;

import com.testesunitarios.model.LocadoraModel;
import com.testesunitarios.model.ClienteModel;
import com.testesunitarios.model.FilmeModel;

import java.math.BigDecimal;
import java.time.LocalDate;

public class LocadoraService {

    public LocadoraModel alugarFilme(ClienteModel cliente, FilmeModel filme) {
        return alugarFilme(cliente, filme);
    }

    public static void main(String[] args) {

        ClienteModel cliente = new ClienteModel("Marcus Túlio", "zMarcust.st@gmail.com", "00.111.222-33", "85 91111-2222");

        FilmeModel filme = new FilmeModel("Avatar", BigDecimal.valueOf(39.99));

        LocadoraModel locadora = new LocadoraModel("Júlio", LocalDate.now(), LocalDate.now().plusDays(7), cliente, filme);

        System.out.println("Cliente: " + locadora.getClienteModel().getNome() +
                "\nAtendente: " + locadora.getNomeAtendente() +
                "\nFilme: " + locadora.getFilmeModel().getNome() +
                "\nValor: R$ " + locadora.getFilmeModel().getValor() + " reais" +
                "\nData da locação: " + locadora.getDataLocacao() +
                "\nData de retorno: " + locadora.getDataRetorno());
    }

}
