package com.yashovardhan99.activitiesandintents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button clickMe = findViewById(R.id.button_1);
        clickMe.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        EditText nameText = findViewById(R.id.name);
        String name = nameText.getText().toString();
        nameText.setText("");
        switch (v.getId()) {
            case R.id.button_1 : Toast.makeText(this, "Your name is " + name, Toast.LENGTH_LONG).show();
                break;
            case R.id.next:
                Intent nextActivity = new Intent(this, NameActivity.class);
                startActivity(nextActivity);
        }
    }
}
