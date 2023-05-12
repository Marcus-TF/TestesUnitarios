package com.testesunitarios.service;

import com.testesunitarios.exception.LocadoraException;
import com.testesunitarios.model.ClienteModel;
import com.testesunitarios.model.FilmeModel;
import com.testesunitarios.model.LocadoraModel;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class LocadoraService {

    public LocadoraModel alugarFilme(ClienteModel cliente, List<FilmeModel> filmeList) {

        var locadora = new LocadoraModel();
        locadora.setClienteModel(cliente);
        locadora.setFilmeModel(filmeList);

        if (Objects.isNull(filmeList) || filmeList.isEmpty()) {
            throw new LocadoraException("Filme nulo!");
        }

        for (int i = 0; i < filmeList.size(); i++) {
            if (filmeList.get(i).getValor() == null || filmeList.get(i).getValor() == BigDecimal.valueOf(0)) {
                throw new LocadoraException("Filme informado não possui valor!");
            }
        }

        locadora.setDataLocacao(LocalDate.now());
        locadora.setDataRetorno(LocalDate.now().plusDays(7));


        return locadora;
    }

}
