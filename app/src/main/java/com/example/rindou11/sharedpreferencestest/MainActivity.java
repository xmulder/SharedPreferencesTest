package com.example.rindou11.sharedpreferencestest;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button button_save;
    private Button button_restore;
    private Context context;
    private Editor editor;
    private SharedPreferences pref;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_save=(Button)findViewById(R.id.button_save_button);
        button_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //首先通过getSharePreferences方法建立data文件
                editor=getSharedPreferences("data",MODE_PRIVATE).edit();
                //用putxxx方法向文件中添加数据
                editor.putString("Name","Rindou");
                editor.putInt("Age",99);
                editor.putBoolean("Married",false);
                editor.putString("Text",)
                //提交数据
                editor.apply();

                Toast.makeText(MainActivity.this,"Save Data Successed.",Toast.LENGTH_LONG).show();
            }
        });

        button_restore=(Button)findViewById(R.id.button_restore_button);
        button_restore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pref=getSharedPreferences("data",MODE_PRIVATE);

                String name=pref.getString("name","");
                int age=pref.getInt("Age",0);
                boolean married=pref.getBoolean("Married",false);

                Log.d("MainActivity",String.valueOf(name));
                Log.d("MainActivity", String.valueOf(age));
                Log.d("MainActivity", String.valueOf(married));
            }
        });

    }
}
