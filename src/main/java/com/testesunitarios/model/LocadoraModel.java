package com.testesunitarios.model;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocadoraModel {

    private String nomeAtendente;

    private LocalDate dataLocacao;

    private LocalDate dataRetorno;

    private ClienteModel clienteModel;

    private List<FilmeModel> filmeModel;
}
