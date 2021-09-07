package com.example.java_lucky_ticket;

import static android.graphics.Color.GRAY;
import static android.graphics.Color.GREEN;
import static android.graphics.Color.RED;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
   private EditText number;
   private ImageView image_lamp;
   private Drawable drawable_lamp;

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        number = findViewById(R.id.edit_Number);
        image_lamp = findViewById(R.id.lamp_image);
        drawable_lamp = getDrawable(R.drawable.circle);
    }

    public void checkTicket(View view){
        char[] ticket = number.getText().toString().toCharArray();
        int leftSum = 0;
        int rightSum = 0;

        if(ticket.length != 6) {
            drawable_lamp.setColorFilter(GRAY, PorterDuff.Mode.SRC_ATOP);
            image_lamp.setBackground(drawable_lamp);
            Toast.makeText(getApplicationContext(), getResources().getString(R.string.incorrectLength), Toast.LENGTH_SHORT).show();
        } else {
            for(int i = 0;i < 3;i++){
                leftSum += Integer.parseInt(String.valueOf(ticket[i]));
                rightSum += Integer.parseInt(String.valueOf(ticket[i+3]));
            }
            if(leftSum == rightSum)  {
                drawable_lamp.setColorFilter(GREEN, PorterDuff.Mode.SRC_ATOP);
                image_lamp.setBackground(drawable_lamp);
                Toast.makeText(getApplicationContext(), getResources().getString(R.string.lucky), Toast.LENGTH_SHORT).show();
            } else {
                drawable_lamp.setColorFilter(RED, PorterDuff.Mode.SRC_ATOP);
                image_lamp.setBackground(drawable_lamp);
                Toast.makeText(getApplicationContext(), getResources().getString(R.string.unlucky), Toast.LENGTH_SHORT).show();
            }
        }
    }

}