package com.example.whatsappintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    EditText phoneText;
    EditText messageText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        phoneText = findViewById(R.id.editTextPhone);
        messageText = findViewById(R.id.editTextMessage);

    }

    public void sendMessage(View view)
    {
        String phoneString = String.valueOf(phoneText.getText());
        String messageString = String.valueOf(messageText.getText());
        messageString.replace(" ", "%20");
        Uri webpage = Uri.parse(
                        "https://wa.me/" + phoneString +
                        "?text=" + messageString);
        Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(webIntent);
    }
}