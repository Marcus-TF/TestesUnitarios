package com.testesunitarios.service;

import com.testesunitarios.exception.LocadoraException;
import com.testesunitarios.model.ClienteModel;
import com.testesunitarios.model.FilmeModel;
import com.testesunitarios.model.LocadoraModel;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class LocadoraService {

    public LocadoraModel alugarFilme(ClienteModel cliente, FilmeModel filme) {

        var locadora = new LocadoraModel();
        locadora.setClienteModel(cliente);
        locadora.setFilmeModel(filme);

        if (Objects.isNull(filme.getValor()) || filme.getValor().equals(BigDecimal.valueOf(0))) {
            throw new LocadoraException("Valor do filme nulo!");
        }

        locadora.setDataLocacao(LocalDate.now());
        locadora.setDataRetorno(LocalDate.now().plusDays(7));


        return locadora;
    }

}
