package com.testesunitarios.service;

import com.testesunitarios.model.MovieModel;
import com.testesunitarios.model.RentModel;
import com.testesunitarios.model.UserModel;
import lombok.AllArgsConstructor;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

@Service
@AllArgsConstructor
public class RentService {

    public RentModel rentMovie(UserModel user, MovieModel movieModel) {
        var rentResponse = new RentModel();
        rentResponse.setUser(user);
        rentResponse.setMovieModel(movieModel);

        var mockDate = LocalDate.of(2022, 12, 14);
        rentResponse.setRentDate(mockDate);
        rentResponse.setReturnDate(mockDate.plusDays(7));
        rentResponse.setValue(movieModel.getPrice());

        return rentResponse;
    }

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
            System.out.println(rentModelResponse);
        } catch (AssertionError e) {
            throw new AssertionError("Data do aluguel nao coincide com a data atual!");
        }


    }
}
