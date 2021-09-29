package com.androidstudio.play;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GamesLevels extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamelevel);
        SharedPreferences save =getSharedPreferences("Save",MODE_PRIVATE);
        final int level = save.getInt("Level",1);

        Window window = getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Button button_back = (Button) findViewById(R.id.button_back_levels);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(GamesLevels.this, MainActivity.class);
                    startActivity(intent); finish();
                }catch (Exception e){

                }
            }
        });


        TextView textView1 =(TextView)findViewById(R.id.textView1);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (level>=1){
                        Intent intent = new Intent(GamesLevels.this, Level1.class);
                        startActivity(intent); finish();
                    }else {
                        //
                    }

                }catch (Exception e){

                }
            }
        });
        TextView textView2 =(TextView)findViewById(R.id.textView2);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (level>=2){
                    Intent intent = new Intent(GamesLevels.this, Level2.class);
                    startActivity(intent); finish();
                    }else {
                        //
                    }

                }catch (Exception e){

                }
            }
        });
        final int[] x ={
                R.id.textView1,
                R.id.textView2,
                R.id.textView3,
                R.id.textView4,
                R.id.textView5,
        };
        for (int i=1;i<level; i++){
            TextView tv =findViewById(x[i]);
            tv.setText(""+(i+1));
        }
    }
    @Override
        public void onBackPressed(){
        Intent intent = new Intent(GamesLevels.this, MainActivity.class);
        startActivity(intent); finish();
    }
}