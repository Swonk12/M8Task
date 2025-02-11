package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.google.android.material.textfield.TextInputEditText;
import androidx.appcompat.app.AppCompatActivity;
public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Referencias a los elementos
        TextInputEditText inputNumber = findViewById(R.id.inputNumber);
        Button convertButton = findViewById(R.id.convertButton);
        TextInputEditText resultText = findViewById(R.id.resultText);
        Button backButton = findViewById(R.id.backButton); // Botón para volver al MainActivity

        // Configurar el botón de conversión
        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = inputNumber.getText().toString();

                if (!input.isEmpty()) {
                    try {
                        double number = Double.parseDouble(input);
                        // Fórmula para convertir a Fahrenheit
                        double converted = (number * 9 / 5) + 32;
                        resultText.setText(String.valueOf(converted) + " °F");
                    } catch (NumberFormatException e) {
                        resultText.setText("Ingrese un número válido.");
                    }
                } else {
                    resultText.setText("Ingrese un número.");
                }
            }
        });

        // Configurar el botón de regreso
        backButton.setOnClickListener(v -> {
            // Volver a MainActivity
            Intent intent = new Intent(SecondActivity.this, MainActivity.class);
            startActivity(intent);
            finish(); // Opcional: Cierra SecondActivity después de regresar
        });
    }
}