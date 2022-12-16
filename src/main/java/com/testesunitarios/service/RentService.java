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

        rentResponse.setRentDate(LocalDate.now());
        rentResponse.setReturnDate(LocalDate.now().plusDays(7));
        rentResponse.setValue(movieModel.getPrice());

        return rentResponse;
    }
}
