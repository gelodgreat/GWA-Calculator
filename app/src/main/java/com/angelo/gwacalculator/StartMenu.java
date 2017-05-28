package com.angelo.gwacalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class StartMenu extends AppCompatActivity {

    private Button btn_gocalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_menu);

        btn_gocalculate = (Button) findViewById(R.id.btn_gocalculate);
        btn_gocalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.angelo.gwacalculator.MainActivity");
                startActivity(intent);
            }
        });

    }
}
