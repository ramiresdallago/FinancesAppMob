package br.com.fean.finances.app.manager;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import br.com.fean.finances.app.manager.activity.UserActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent insertUser = new Intent(MainActivity.this, UserActivity.class);
        startActivity(insertUser);
    }

}