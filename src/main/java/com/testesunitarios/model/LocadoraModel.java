package com.testesunitarios.model;

import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocadoraModel {

    private String nomeAtendente;

    private LocalDate dataLocacao;

    private LocalDate dataRetorno;

    private ClienteModel clienteModel;

    private FilmeModel filmeModel;
}
