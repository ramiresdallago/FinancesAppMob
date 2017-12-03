package br.com.fean.finances.app.manager.activity;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.com.fean.finances.app.manager.R;
import br.com.fean.finances.app.manager.model.User;
import br.com.fean.finances.app.manager.task.UserTask;

/**
 * Created by ramirespatricio on 02/12/2017.
 */

public class UserActivity extends AppCompatActivity {

    private Button btnRegister;
    private EditText name, email, password;
    private User currentUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_account);
    }

    public void registerUser(View v){
        name = (EditText) findViewById(R.id.name);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);

        User userMain = new User();
      /*if(currentUser != null){
            userMain.setId(currentUser.getId());
        }*/

        userMain.setName(name.getText().toString());
        userMain.setEmail(email.getText().toString());
        userMain.setPassword(password.getText().toString());

        new UserTask(v.getContext(), userMain).execute();
    }

}
