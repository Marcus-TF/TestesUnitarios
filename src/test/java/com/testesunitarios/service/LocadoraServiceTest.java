package com.testesunitarios.service;

import com.testesunitarios.model.ClienteModel;
import com.testesunitarios.model.FilmeModel;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

public class LocadoraServiceTest {

    @Test
    public void locadoraValidacao() {

        var cliente = new ClienteModel("Marcus Túlio", "zMarcust.st@gmail.com", "00.111.222-33", "85 91111-2222");

        var filme = new FilmeModel("Avatar", BigDecimal.valueOf(39.99));

        var service = new LocadoraService();

        var locacao = service.alugarFilme(cliente, filme);
        locacao.setNomeAtendente("Julio");

        Assert.assertTrue("Marcus Túlio".equalsIgnoreCase(cliente.getNome()));
        Assert.assertTrue("Verificando se os valores são iguais passando o equals..", locacao.getFilmeModel().getValor().equals(BigDecimal.valueOf(39.99)));
        Assert.assertEquals("Verificando se os valores são iguais com 2 argumentos.", locacao.getFilmeModel().getValor(), BigDecimal.valueOf(39.99));
        Assert.assertEquals("Verificando se os valores são iguais com 2 argumentos.", locacao.getDataLocacao(), LocalDate.now());
        Assert.assertEquals("Verificando se os valores são iguais com 2 argumentos.", locacao.getDataRetorno(), LocalDate.now().plusDays(7));
    }
}