package com.example.rahul.codekulpractice;


import android.os.Process;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity {

    private static final String KEY_NAME = "Name";
    private static final String KEY_PRICE = "Price";
    private static final String KEY_CASHBACK = "Cashback";
    private MyView product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.btnOkay).setOnClickListener(this::clicked);


    }

    private void clicked(View view) {
        if(view.getId() == R.id.btnOkay)
            product = getmeproduct();
        ((TextView)findViewById(R.id.textInfo)).setText(product.getName());

    }

    private MyView getmeproduct(){

        product = new MyView();
        product.setName("Mobile");
        product.setPrice(12000);
        product.setCashback(1200);

        return product;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString(KEY_NAME,product.getName());
        outState.putFloat(KEY_PRICE,product.getPrice());
        outState.putInt(KEY_CASHBACK,product.getCashback());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        if(savedInstanceState!=null)
            ((TextView)findViewById(R.id.textInfo))
                    .setText(savedInstanceState.getString(KEY_NAME)+"->"
                    +savedInstanceState.getFloat(KEY_PRICE));
    }
}
