package com.testesunitarios.service;

import com.testesunitarios.exception.OutOfStockException;
import com.testesunitarios.model.MovieModel;
import com.testesunitarios.model.RentModel;
import com.testesunitarios.model.UserModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Objects;

@Service
@AllArgsConstructor
public class RentService {

    public RentModel rentMovie(UserModel user, MovieModel movieModel) {
        var rentResponse = new RentModel();
        rentResponse.setUser(user);
        rentResponse.setMovieModel(movieModel);

        if (Objects.isNull(movieModel.getInventory()) || movieModel.getInventory() == 0){
            throw new OutOfStockException("Filme sem estoque!");
        }

        rentResponse.setRentDate(LocalDate.now());
        rentResponse.setReturnDate(LocalDate.now().plusDays(7));
        rentResponse.setValue(movieModel.getPrice());

        return rentResponse;
    }
}
