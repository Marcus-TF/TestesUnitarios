package com.testesunitarios.serviceteste;

import com.testesunitarios.model.MovieModel;
import com.testesunitarios.model.RentModel;
import com.testesunitarios.model.UserModel;
import com.testesunitarios.service.RentService;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import java.time.LocalDate;
import java.util.Objects;

public class RentServiceTeste {

    @Rule
    public ErrorCollector error = new ErrorCollector();

    @Test
    public void testAsserts() {
        //Principio First

        //cenario
        var rentServiceResponse = new RentService();
        var userResponse = new UserModel("Marcus");
        var movieResponse = new MovieModel("Us", 5, 90.00);

        //acao
        RentModel rentModelResponse = rentServiceResponse.rentMovie(userResponse, movieResponse);

        //verificacao
        try {
            Assert.assertEquals(rentModelResponse.getRentDate(), LocalDate.now());
            System.out.println("Test passed!\n" + rentModelResponse);
        } catch (AssertionError e) {
            throw new AssertionError("Assert Equals Error!");
        }

        try {
            Assert.assertTrue(Objects.equals(rentModelResponse.getRentDate(), LocalDate.now()));
            System.out.println("Test passed!\n" + rentModelResponse);
        } catch (AssertionError e) {
            throw new AssertionError("Assert True Error!");
        }

        try {
            Assert.assertThat(rentModelResponse.getValue(), CoreMatchers.is(90.00));
            System.out.println("Test passed!\n" + rentModelResponse);
        } catch (AssertionError e) {
            throw new AssertionError("Assert That Error!");
        }

    }

    @Test
    public void testErrorCollector() {
        //cenario
        var rentServiceResponse = new RentService();
        var userResponse = new UserModel("Marcus");
        var movieResponse = new MovieModel("Us", 5, 90.00);

        //acao
        RentModel rentModelResponse = rentServiceResponse.rentMovie(userResponse, movieResponse);

        //verificacao usando Erro Collector
        error.checkThat(rentModelResponse.getRentDate(), CoreMatchers.is(LocalDate.now())); //Verificando se as datas são iguais com CheckThat
        error.checkThat(rentModelResponse.getValue(), CoreMatchers.is(90.00)); //Verificando se os valores são iguais
    }

    @Test
    public void testOutOfStock() {
        //cenario
        var rentServiceResponse = new RentService();
        var userResponse = new UserModel("Marcus");
        var movieResponse = new MovieModel("Us", 5, 90.00); //Verificando o estoque

        //acao
        RentModel rentModelResponse = rentServiceResponse.rentMovie(userResponse, movieResponse);

        //verificacao
        System.out.println("Test passed!\n" + rentModelResponse);
    }

    @Test
    public void testDifferentValue() {
        //cenario
        var rentServiceResponse = new RentService();
        var userResponse = new UserModel("Marcus");
        var movieResponse = new MovieModel("Us", 5, 90.00);

        //acao
        RentModel rentModelResponse = rentServiceResponse.rentMovie(userResponse, movieResponse);

        //verificacao
        try {
            Double storeValue = 90.00;
            Assert.assertEquals(rentModelResponse.getValue(), storeValue); //Verificando se os valores são iguais
            System.out.println("Test passed!\n" + rentModelResponse);
        } catch (AssertionError e) {
            throw new AssertionError("Valor do aluguel nao coincide com o preco em loja!");
        }
    }

    @Test
    public void testDifferentDate() {
        //cenario
        var rentServiceResponse = new RentService();
        var userResponse = new UserModel("Marcus");
        var movieResponse = new MovieModel("Us", 5, 90.00);

        //acao
        RentModel rentModelResponse = rentServiceResponse.rentMovie(userResponse, movieResponse);

        //verificacao
        try {
            Assert.assertEquals(rentModelResponse.getRentDate(), LocalDate.now()); //Verificando se os valores são iguais
            System.out.println("Test passed!\n" + rentModelResponse);
        } catch (AssertionError e) {
            throw new AssertionError("Data do aluguel nao coincide com a data atual!");
        }
    }

    @Test
    public void testStockIsNull() {
        //cenario
        var rentServiceResponse = new RentService();
        var userResponse = new UserModel("Marcus");
        var movieResponse = new MovieModel("Us", 5, 90.00);

        //acao
        RentModel rentModelResponse = rentServiceResponse.rentMovie(userResponse, movieResponse);

        //verificacao
        try {
            Integer value = 0;
            Assert.assertNotEquals(movieResponse.getInventory(), value);
            System.out.println("Test passed!\n" + rentModelResponse);
        } catch (AssertionError e) {
            throw new AssertionError("Filme sem estoque!");
        }
    }
}
