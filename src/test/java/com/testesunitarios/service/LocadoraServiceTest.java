package com.testesunitarios.service;

import com.testesunitarios.exception.LocadoraException;
import com.testesunitarios.model.ClienteModel;
import com.testesunitarios.model.FilmeModel;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LocadoraServiceTest {

    private LocadoraService service;
    @Before
    public void setup() {
        service = new LocadoraService();
    }

    @Test
    public void locadoraValidacao() {

        var cliente = new ClienteModel("Marcus Túlio", "zMarcust.st@gmail.com", "00.111.222-33", "85 91111-2222");

        var avatar = new FilmeModel("Avatar", BigDecimal.valueOf(39.99));
        var starWars = new FilmeModel("Star Wars", BigDecimal.valueOf(89.99));

        List<FilmeModel> filmeList = new ArrayList<>();
        filmeList.add(avatar);
        filmeList.add(starWars);


        var locacao = service.alugarFilme(cliente, filmeList);
        locacao.setNomeAtendente("Julio");

        Assert.assertTrue("Marcus Túlio".equalsIgnoreCase(cliente.getNome()));
        for (int i = 0; i < filmeList.size(); i++) {
            Assert.assertTrue("Valores diferentes.", locacao.getFilmeModel().get(i).getValor().equals(locacao.getFilmeModel().get(i).getValor()));
            Assert.assertEquals("Valores diferentes.", locacao.getFilmeModel().get(i).getValor(), locacao.getFilmeModel().get(i).getValor());
        }
        Assert.assertEquals("Data de locação não coincidem!.", locacao.getDataLocacao(), LocalDate.now());
        Assert.assertEquals("Data de retorno não coincidem!", locacao.getDataRetorno(), LocalDate.now().plusDays(7));
    }

    @Test
    public void locadoraValidacaoFilmeValor() {

        try {
            var cliente = new ClienteModel("Marcus Túlio", "zMarcust.st@gmail.com", "00.111.222-33", "85 91111-2222");
            var avatar = new FilmeModel("Avatar", BigDecimal.valueOf(39.99));
            var starWars = new FilmeModel("Star Wars", BigDecimal.valueOf(89.99));

            List<FilmeModel> filmeList = new ArrayList<>();
            filmeList.add(avatar);
            filmeList.add(starWars);

            var locacao = service.alugarFilme(cliente, filmeList);
            locacao.setNomeAtendente("Julio");

        } catch (LocadoraException e) {
            Assert.fail(e.getMessage());
        }
    }
}
