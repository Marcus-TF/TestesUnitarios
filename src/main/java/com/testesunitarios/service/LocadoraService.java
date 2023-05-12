package com.testesunitarios.service;

import com.testesunitarios.model.ClienteModel;
import com.testesunitarios.model.FilmeModel;
import com.testesunitarios.model.LocadoraModel;

import java.time.LocalDate;

public class LocadoraService {

    public LocadoraModel alugarFilme(ClienteModel cliente, FilmeModel filme) {

        var locadora = new LocadoraModel();

        locadora.setDataLocacao(LocalDate.now());
        locadora.setDataRetorno(LocalDate.now().plusDays(7));
        locadora.setClienteModel(cliente);
        locadora.setFilmeModel(filme);

        return locadora;
    }

}
