package com.testesunitarios.service;

import com.testesunitarios.model.Movie;
import com.testesunitarios.model.Rent;
import com.testesunitarios.model.User;
import jakarta.persistence.NoResultException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Service
@AllArgsConstructor
public class RentService {

    public Rent rentMovie(User user, Movie movie) {
        var rentResponse = new Rent();
        rentResponse.setUser(user);
        rentResponse.setMovie(movie);

        var mockDate = LocalDate.of(2022, 12, 13);
        rentResponse.setRentDate(mockDate);
        rentResponse.setReturnDate(mockDate.plusDays(7));
        rentResponse.setValue(movie.getPrice());

        return rentResponse;
    }

    public static void main(String[] args) {
        //Principio First

        //cenario
        var rentServiceResponse = new RentService();
        var userResponse = new User("Marcus");
        var movieResponse = new Movie("Us", 5, 90.00);

        //acao
        Rent rentResponse = rentServiceResponse.rentMovie(userResponse, movieResponse);

        //verificacao
        if (movieResponse.getInventory() != 5 || rentResponse.getRentDate() != LocalDate.now()){
            System.out.println("Informacoes erradas.");
        } else {
            System.out.println(rentResponse);
        }

    }
}
