package com.example.rahul.codekulpractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnclicked).setOnClickListener(this::clicked);

        findViewById(R.id.btnpressed).setOnClickListener(this::clicked);

    }


    public void clicked(View view){

        if(view.getId() == R.id.btnclicked){

            settextinfo(""+converttodp(geteditvalue(),2));

            Toast.makeText(this,"btn clicked",Toast.LENGTH_SHORT).show();
        }
        else{
            settextinfo(""+converttopx(geteditvalue(),3));
            Toast.makeText(this,"btn pressed",Toast.LENGTH_SHORT).show();
        }

    }

    private int geteditvalue()
    {
//        EditText editText = (EditText)findViewById(R.id.editone);
//        int val = Integer.parseInt(editText.getText().toString());
//        return val;
//
        return Integer.parseInt(((EditText)findViewById(R.id.editone)).getText().toString());

    }

    public void settextinfo(String info)
    {
//        TextView textView = (TextView)findViewById(R.id.textview);
//        textView.setText(info);

        ((TextView) findViewById(R.id.textview)).setText(info);

    }

    public int converttopx(int x, int y){
        return x=x+y;
    }

    public int converttodp(int a, int b){
        return a*b;
    }

}
