package com.example.abhi.timestable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.sql.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lst;
    public void generateTimes(int tt)
    {

        ArrayList<String> timesTableContent=new ArrayList<String>();
        for(int i =1; i<=10;i++)
        {
            timesTableContent.add(Integer.toString(i*tt));
        }
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,timesTableContent);
        lst.setAdapter(arrayAdapter);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final SeekBar timestable=(SeekBar)findViewById(R.id.seekBar);
         lst=(ListView)findViewById(R.id.listView);
        timestable.setMax(20);
        timestable.setProgress(10);
        timestable.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min =1;
                int times;
                if(progress<min){
                    times=min;
                    timestable.setProgress(min);
                }else{
                    times=progress;
                }
                generateTimes(times);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        generateTimes(10);

    }
}
