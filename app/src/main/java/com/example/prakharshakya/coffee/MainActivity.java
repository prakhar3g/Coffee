package com.example.prakharshakya.coffee;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;
public class MainActivity extends AppCompatActivity {

    int quantity=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submit(View view) {
        int price=0;
        EditText text = (EditText) findViewById(R.id.name);
        String textname = text.getText().toString();
        CheckBox whippedcream = (CheckBox) findViewById(R.id.Whipped_check);
        boolean haswhippedcream = whippedcream.isChecked();
        CheckBox chocolate = (CheckBox) findViewById(R.id.chocolate_check);
        boolean haschocolate = chocolate.isChecked();
        if(haswhippedcream)
            price=price+(quantity*3);
        if(haschocolate)
            price=price+(quantity*5);
        price=price+(15*quantity);
        String pricemessage = display_price(price,haschocolate,haswhippedcream,textname);
        display_message(pricemessage);

    }

    public void submit1(View view) {

        int price=0;
        EditText text = (EditText) findViewById(R.id.name);
        String textname = text.getText().toString();
        CheckBox whippedcream = (CheckBox) findViewById(R.id.Whipped_check);
        boolean haswhippedcream = whippedcream.isChecked();
        CheckBox chocolate = (CheckBox) findViewById(R.id.chocolate_check);
        boolean haschocolate = chocolate.isChecked();
        if(haswhippedcream)
            price=price+(quantity*3);
        if(haschocolate)
            price=price+(quantity*5);
        price=price+(15*quantity);
        String pricemessage = display_price(price,haschocolate,haswhippedcream,textname);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "Coffee Order of "+textname);
        intent.putExtra(Intent.EXTRA_TEXT,pricemessage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

        display_message(pricemessage);

    }

    private void display_message(String pricemessage) {

        TextView w = (TextView) findViewById(R.id.price_display);
             w.setText(""+pricemessage);
    }

    private String display_price(int price, boolean haschocolate, boolean haswhippedcream, String textname) {
        String message="Name:"+textname;
        if(haschocolate)
            message+="\nAdd Chocolate:YES";
        if(!haschocolate)
            message+="\nAdd Chocolate:NO";
        if(haswhippedcream)
            message+="\nAdd WhippedCream:YES";
        if(!haswhippedcream)
            message+="\nAdd WhippedCream:NO";
        message+="\nTotal Amount: Rs"+price+".00";
        return message;
        }


    public void increment(View view) {
        quantity++;
        display(quantity);

    }


    public void decrement(View view) {

        if(quantity>0)
        {
            quantity--;
            display(quantity);
        }
    }


    private void display(int quantity) {
        TextView x = (TextView) findViewById(R.id.quantity_display);
        x.setText(""+quantity);
    }
}
