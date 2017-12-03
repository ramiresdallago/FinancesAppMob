package br.com.fean.finances.app.manager.interfaces;

import br.com.fean.finances.app.manager.model.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by ramirespatricio on 02/12/2017.
 */

public interface UserInterface {

    @POST("user/register")
    @Headers("Content-Type: application/json")
    Call<User> register(@Body User user);

    @GET("user/find/{idUser}")
    Call<User> findUser(@Path(value = "idUser") int idUser);

    @PUT("user/edit")
    @Headers("Content-Type: application/json")
    Call<User> update(@Body User user);

    @DELETE("user/delete/{idUser}")
    Call<String> delete(@Path(value = "idUser") int idUser);
}