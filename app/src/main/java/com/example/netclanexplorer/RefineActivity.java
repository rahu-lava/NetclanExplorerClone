package com.example.netclanexplorer;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RefineActivity extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refine);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        imageView = findViewById(R.id.backImage);
        Spinner spinner = findViewById(R.id.spinner);

        String[] availString = getResources().getStringArray(R.array.availableArray);
        ArrayAdapter adapter = new ArrayAdapter(RefineActivity.this, android.R.layout.simple_spinner_item,availString);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

// Get references to all TextViews
        TextView textView23 = findViewById(R.id.textView23);
        TextView textView24 = findViewById(R.id.textView24);
        TextView textView25 = findViewById(R.id.textView25);
        TextView textView26 = findViewById(R.id.textView26);
        TextView textView27 = findViewById(R.id.textView27);
        TextView textView28 = findViewById(R.id.textView28);
        TextView textView29 = findViewById(R.id.textView29);
        TextView textView30 = findViewById(R.id.textView30);

// Set OnClickListener for each TextView
        textView23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleTextStyle(textView23);
            }
        });

        textView24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleTextStyle(textView24);
            }
        });

        textView25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleTextStyle(textView25);
            }
        });

        textView26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleTextStyle(textView26);
            }
        });

        textView27.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleTextStyle(textView27);
            }
        });

        textView28.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleTextStyle(textView28);
            }
        });

        textView29.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleTextStyle(textView29);
            }
        });

        textView30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleTextStyle(textView30);
            }
        });
        EditText editText = findViewById(R.id.editTextText2);
        TextView charCountTextView = findViewById(R.id.charCount);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Not needed
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Update the character count TextView with the length of the text
                int charCount = s.length();
                if (charCount > 250) {
                    editText.setText(s.subSequence(0, 250));
                    editText.setSelection(250); // Move cursor to the end
                    charCount = 250; // Update charCount to 250
                }
                charCountTextView.setText(String.valueOf(charCount));
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }

        });


    }
    private void toggleTextStyle(TextView textView) {
        // Toggle the text color and background
        if (textView.getCurrentTextColor() == getResources().getColor(R.color.white)) {
            // If it's style 1, set it to style 2
            textView.setTextColor(getResources().getColor(R.color.secondaryColor)); // Change to your style 2 color
            textView.setBackgroundResource(R.drawable.custom_purpose2); // Change to your style 2 background
        } else {
            // If it's style 2, set it to style 1
            textView.setTextColor(getResources().getColor(R.color.white)); // Change to your style 1 color
            textView.setBackgroundResource(R.drawable.custom_purpose); // Change to your style 1 background
        }
    }
}