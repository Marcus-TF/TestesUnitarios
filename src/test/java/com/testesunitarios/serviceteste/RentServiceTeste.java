package com.testesunitarios.serviceteste;

import com.testesunitarios.model.MovieModel;
import com.testesunitarios.model.RentModel;
import com.testesunitarios.model.UserModel;
import com.testesunitarios.service.RentService;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Objects;

public class RentServiceTeste {

    @Test
    public void test() {
        //Principio First

        //cenario
        var rentServiceResponse = new RentService();
        var userResponse = new UserModel("Marcus");
        var movieResponse = new MovieModel("Us", 5, 90.00);

        //acao
        RentModel rentModelResponse = rentServiceResponse.rentMovie(userResponse, movieResponse);

        //verificacao
        try {
            Assert.assertTrue(Objects.equals(rentModelResponse.getRentDate(), LocalDate.now())); //Verficando se as datas são iguais
            Assert.assertEquals(rentModelResponse.getRentDate(), LocalDate.now()); //Verificando se as datas são iguais
            Assert.assertThat(rentModelResponse.getValue(), CoreMatchers.is(90.00)); //Verificando se os valores são iguais
            System.out.println("Test passed!\n" + rentModelResponse);
        } catch (AssertionError e) {
            throw new AssertionError("Data do aluguel nao coincide com a data atual!");
        }
    }
}
