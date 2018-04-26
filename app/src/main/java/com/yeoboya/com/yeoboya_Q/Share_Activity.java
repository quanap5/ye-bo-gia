package com.yeoboya.com.yeoboya_Q;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Share_Activity extends AppCompatActivity {
    private  String SHARED_PREFERENCES_NAME ="quan";
    private  final String MY_NAME = "my_name";
    private  final  String AGE = "AGE";
    private  final  String IS_SINGLE = "is_single";
    private  final String WEIGHT = "weight";
    private Button btnSaveData;
    private Button btn_Read;
    private  Button btn_remove;

    private final String TAG = getClass().getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_);
        btnSaveData = findViewById(R.id.btn_share);
        btn_Read = findViewById(R.id.btn_read);
        btn_remove = findViewById(R.id.btn_remove);

        btnSaveData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            addData();
            }
        });
        btn_Read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readData();
            }
        });

        btn_remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeByKey(MY_NAME);
            }
        });



    }
    public void addData(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(MY_NAME, "Nguyen Van Quan");
        editor.putInt(AGE, 28);
        editor.putBoolean(IS_SINGLE, false);
        editor.putLong(WEIGHT, 60);

        editor.apply();
        Toast.makeText(Share_Activity.this, "Save successfully", Toast.LENGTH_SHORT).show();
        //editor.commit();
    }

    public  void readData(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE);
        String name = sharedPreferences.getString(MY_NAME,"quanap5");
        Integer age = sharedPreferences.getInt(AGE,0);
        Boolean isSingle = sharedPreferences.getBoolean(IS_SINGLE, false);
        Long weigh = sharedPreferences.getLong(WEIGHT,0);
        String add = sharedPreferences.getString("ADRESS", "Hatinh");

        Log.d(TAG, "NameL: "+name+"\n"+ "Age: "+ age+"\n"+
                "weigh: "+weigh +"add: "+ add);
    }
    public void  removeByKey(String key){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(key);
        editor.apply();
    }
}
