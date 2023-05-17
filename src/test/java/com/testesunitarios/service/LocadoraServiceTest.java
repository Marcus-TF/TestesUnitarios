package com.testesunitarios.service;

import com.testesunitarios.exception.LocadoraException;
import com.testesunitarios.model.ClienteModel;
import com.testesunitarios.model.FilmeModel;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class LocadoraServiceTest {

  private LocadoraService service;

  private ClienteModel cliente;

  private FilmeModel avatar;

  private FilmeModel starWars;

  private FilmeModel harryPotter;

  private List<FilmeModel> filmList = new ArrayList<>();

  @Before
  public void setup() {
    service = new LocadoraService();
    cliente = new ClienteModel("Marcus Túlio", "zMarcust.st@gmail.com", "00.111.222-33",
        "85 91111-2222");
    avatar = new FilmeModel("Avatar", BigDecimal.valueOf(39.99));
    starWars = new FilmeModel("Star Wars", BigDecimal.valueOf(89.99));
    harryPotter = new FilmeModel("Harry Potter e o Prisioneiro de Azkaban",
        BigDecimal.valueOf(100.00));
    filmList = new ArrayList<>();
    filmList.add(avatar);
    filmList.add(starWars);
    filmList.add(harryPotter);
  }

  @Test
  public void rentalCompanyInfoValidation() {

    List<FilmeModel> filmeList = new ArrayList<>();
    filmeList.add(avatar);
    filmeList.add(starWars);

    var locacao = service.alugarFilme(cliente, filmeList);
    locacao.setNomeAtendente("Julio");

    Assert.assertTrue("Marcus Túlio".equalsIgnoreCase(cliente.getNome()));
    for (int i = 0; i < filmeList.size(); i++) {
      Assert.assertTrue("Valores diferentes.", locacao.getFilmeModel().get(i).getValor()
          .equals(locacao.getFilmeModel().get(i).getValor()));
      Assert.assertEquals("Valores diferentes.", locacao.getFilmeModel().get(i).getValor(),
          locacao.getFilmeModel().get(i).getValor());
    }
    Assert.assertEquals("Data de locação não coincidem!.", locacao.getDataLocacao(),
        LocalDate.now());
    Assert.assertEquals("Data de retorno não coincidem!", locacao.getDataRetorno(),
        LocalDate.now().plusDays(7));
  }

  @Test
  public void rentalCompanyFilmeNotNull() {

    try {

      var locacao = service.alugarFilme(cliente, filmList);
      locacao.setNomeAtendente("Julio");

    } catch (LocadoraException e) {
      Assert.fail(e.getMessage());
    }
  }

  @Test
  public void rentalCompanyFilmDiscountBasedOnQuantity() {

    try {

      var locacao = service.alugarFilme(cliente, filmList);
      System.out.println(locacao.getFilmeModel().get(2).getValor());
      locacao.setNomeAtendente("Julio");
    } catch (LocadoraException e) {
      Assert.fail(e.getMessage());
    }
  }

  @Test
  public void rentalCompanyIfUserIsNull() throws LocadoraException {

    var clienteTeste = new ClienteModel();

    Assertions.assertThrows(LocadoraException.class, () -> {
      service.alugarFilme(clienteTeste, filmList);
    });
  }
}
