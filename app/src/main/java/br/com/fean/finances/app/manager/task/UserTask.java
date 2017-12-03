package br.com.fean.finances.app.manager.task;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import br.com.fean.finances.app.manager.ApiClient;
import br.com.fean.finances.app.manager.MainActivity;
import br.com.fean.finances.app.manager.activity.UserActivity;
import br.com.fean.finances.app.manager.interfaces.UserInterface;
import br.com.fean.finances.app.manager.model.User;
import retrofit2.Call;


/**
 * Created by ramirespatricio on 02/12/2017.
 */

public class UserTask extends AsyncTask<Void,Void,User> {

    private ProgressDialog progressDialog;
    private Context context;
    private User user;

    public UserTask(Context context, User userMain) {
        this.context = context;
        this.user = userMain;
    }

    @Override
    protected User doInBackground(Void... voids) {
        User responseUser = sendPost();
        return responseUser;
    }

    private User sendPost() {
        User response = null;

        try {
            Call<User> userCall = null;

            if(user.getId() !=  null){
                userCall = ApiClient.getClientWithGson()
                        .newBuilder().build().create(UserInterface.class).update(user);
            }else{
                userCall = ApiClient.getClientWithGson()
                        .newBuilder().build().create(UserInterface.class).register(user);
            }

            response = userCall.execute().body();

        } catch (Exception e){
            e.printStackTrace();
            Log.e("User task", e.getMessage());
        }

        return response;
    }
}
