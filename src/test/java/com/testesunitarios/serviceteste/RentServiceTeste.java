package com.testesunitarios.serviceteste;

import com.testesunitarios.model.MovieModel;
import com.testesunitarios.model.RentModel;
import com.testesunitarios.model.UserModel;
import com.testesunitarios.service.RentService;
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
            Assert.assertTrue(Objects.equals(rentModelResponse.getRentDate(), LocalDate.now()));
            System.out.println("Test passed!\n" + rentModelResponse);
        } catch (AssertionError e) {
            throw new AssertionError("Data do aluguel nao coincide com a data atual!");
        }
    }
}
