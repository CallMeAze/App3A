package com.example.app3a.model.api;

import com.example.app3a.model.personnage.Personnage;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface API {
    @GET("projet3a.php")
    Call<List<Personnage>> get();
}
