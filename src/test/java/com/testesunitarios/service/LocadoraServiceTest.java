package com.testesunitarios.service;

import com.testesunitarios.exception.LocadoraException;
import com.testesunitarios.model.ClienteModel;
import com.testesunitarios.model.FilmeModel;
import com.testesunitarios.model.LocadoraModel;
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

  private LocadoraModel rentalCompany;

  private List<FilmeModel> filmList = new ArrayList<>();

  @Before
  public void setup() {

    service = new LocadoraService();
    cliente = new ClienteModel("Marcus Túlio", "zMarcust.st@gmail.com", "00.111.222-33",
        "85 91111-2222");
    filmList = new ArrayList<>();
    avatar = new FilmeModel("Avatar", BigDecimal.valueOf(40.00));
    starWars = new FilmeModel("Star Wars", BigDecimal.valueOf(90.00));
    harryPotter = new FilmeModel("Harry Potter e o Prisioneiro de Azkaban",
        BigDecimal.valueOf(100.00));
    filmList.add(avatar);
    filmList.add(starWars);
    filmList.add(harryPotter);
    rentalCompany = new LocadoraModel("Júlio", LocalDate.now(), LocalDate.now().plusDays(7),
        cliente, filmList, 1.0);

  }

  @Test
  public void rentalCompanyInfoValidation() {

    var locacao = service.alugarFilme(cliente, filmList);

    Assert.assertTrue("Marcus Túlio".equalsIgnoreCase(cliente.getNome()));
    for (int i = 0; i < filmList.size(); i++) {
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
  public void rentalCompanyFilmeIsNull() throws LocadoraException{

    List<FilmeModel> filmeListTest = new ArrayList<>();

    Assertions.assertThrows(LocadoraException.class, () -> {
      service.alugarFilme(cliente, filmeListTest);
    });
  }

  @Test
  public void rentalCompanyFilmDiscountBasedOnQuantity() {

    var rent = service.alugarFilme(cliente, filmList);

    Assert.assertEquals(10.00, rent.getFilmeModel().get(0).getValor().doubleValue(), 0.00);
    Assert.assertEquals(22.50, rent.getFilmeModel().get(1).getValor().doubleValue(), 0.00);
    Assert.assertEquals(25.00, rent.getFilmeModel().get(2).getValor().doubleValue(), 0.00);
  }

  @Test
  public void rentalCompanyIfUserIsNull() throws LocadoraException {

    var clienteTeste = new ClienteModel();

    Assertions.assertThrows(LocadoraException.class, () -> {
      service.alugarFilme(clienteTeste, filmList);
    });
  }
}
