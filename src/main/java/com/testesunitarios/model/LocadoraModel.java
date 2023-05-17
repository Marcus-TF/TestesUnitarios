package com.testesunitarios.model;

import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocadoraModel {

  private String nomeAtendente;

  private LocalDate dataLocacao;

  private LocalDate dataRetorno;

  private ClienteModel clienteModel;

  private List<FilmeModel> filmeModel;

  private Double desconto;
}
