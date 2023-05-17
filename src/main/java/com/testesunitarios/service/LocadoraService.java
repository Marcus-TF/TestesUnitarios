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

    if (cliente.getNome() == null || cliente.getNome().isEmpty()) {
      throw new LocadoraException("Usuário inexistente!");
    }

    if (Objects.isNull(filmeList) || filmeList.isEmpty()) {
      throw new LocadoraException("Filme nulo!");
    }

    var locadora = new LocadoraModel();
    locadora.setClienteModel(cliente);
    locadora.setFilmeModel(filmeList);

    for (int i = 0; i < filmeList.size(); i++) {
      if (filmeList.size() == 3) {
        locadora.setDesconto(0.25);
        BigDecimal valorFinal = locadora.getFilmeModel().get(i).getValor()
            .multiply(BigDecimal.valueOf(locadora.getDesconto()));
        filmeList.get(i).setValor(valorFinal);

      } else if (filmeList.size() == 4) {
        locadora.setDesconto(0.5);
        BigDecimal valorFinal = locadora.getFilmeModel().get(i).getValor()
            .multiply(BigDecimal.valueOf(locadora.getDesconto()));
        filmeList.get(i).setValor(valorFinal);
      } else if (filmeList.size() == 5) {
        locadora.setDesconto(0.75);
        BigDecimal valorFinal = locadora.getFilmeModel().get(i).getValor()
            .multiply(BigDecimal.valueOf(locadora.getDesconto()));
        filmeList.get(i).setValor(valorFinal);
      } else if (filmeList.size() == 6) {
        locadora.setDesconto(0.0);
        BigDecimal valorFinal = locadora.getFilmeModel().get(i).getValor()
            .multiply(BigDecimal.valueOf(locadora.getDesconto()));
        filmeList.get(i).setValor(valorFinal);
      } else {
        locadora.setDesconto(1.0);
      }
    }

    for (int i = 0; i < filmeList.size(); i++) {
      if (filmeList.get(i).getValor() == null || filmeList.get(i).getValor() == BigDecimal.valueOf(
          0)) {
        throw new LocadoraException("Filme informado não possui valor!");
      }
    }

    locadora.setDataLocacao(LocalDate.now());
    locadora.setDataRetorno(LocalDate.now().plusDays(7));

    return locadora;
  }

}
