package com.umb.calculadora;

import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etNumero1, etNumero2;
    private TextView tvResultado, tvHistorial;
    private Button btnSumar, btnRestar, btnMultiplicar, btnDividir, btnLimpiar, btnSalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Vinculación de vistas
        etNumero1 = findViewById(R.id.etNumero1);
        etNumero2 = findViewById(R.id.etNumero2);
        tvResultado = findViewById(R.id.tvResultado);
        tvHistorial = findViewById(R.id.tvHistorial);
        btnSumar = findViewById(R.id.btnSumar);
        btnRestar = findViewById(R.id.btnRestar);
        btnMultiplicar = findViewById(R.id.btnMultiplicar);
        btnDividir = findViewById(R.id.btnDividir);
        btnLimpiar = findViewById(R.id.btnLimpiar);
        btnSalir = findViewById(R.id.btnSalir);

        // Un solo gestor de eventos (OnClickListener) para todos los botones
        btnSumar.setOnClickListener(this);
        btnRestar.setOnClickListener(this);
        btnMultiplicar.setOnClickListener(this);
        btnDividir.setOnClickListener(this);
        btnLimpiar.setOnClickListener(this);
        btnSalir.setOnClickListener(this);

        // OnKeyListener: al presionar Enter en el segundo cuadro se ejecuta la suma
        etNumero2.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                    btnSumar.performClick();
                    return true;
                }
                return false;
            }
        });
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        if (id == R.id.btnLimpiar) {
            etNumero1.setText("");
            etNumero2.setText("");
            tvResultado.setTextColor(Color.parseColor("#2ECC71"));
            tvResultado.setText("Resultado: ");
            tvHistorial.setText("Historial:\n");
            Toast.makeText(this, "Calculadora limpia", Toast.LENGTH_SHORT).show();
            return;
        }

        if (id == R.id.btnSalir) {
            // Cierra todas las actividades y detiene el proceso de la APP
            finishAffinity();
            System.exit(0);
            return;
        }

        // Validación de entrada
        String texto1 = etNumero1.getText().toString().trim();
        String texto2 = etNumero2.getText().toString().trim();
        if (texto1.isEmpty() || texto2.isEmpty()) {
            Toast.makeText(this, "Ingrese ambos números", Toast.LENGTH_SHORT).show();
            return;
        }

        double a;
        double b;
        try {
            a = Double.parseDouble(texto1);
            b = Double.parseDouble(texto2);
        } catch (NumberFormatException e) {
            // Ocurre si el usuario escribe solo "-" o "."
            Toast.makeText(this, "Ingrese números válidos", Toast.LENGTH_SHORT).show();
            return;
        }

        double resultado;
        String simbolo;

        if (id == R.id.btnSumar) {
            resultado = sumar(a, b);
            simbolo = "+";
        } else if (id == R.id.btnRestar) {
            resultado = restar(a, b);
            simbolo = "−";
        } else if (id == R.id.btnMultiplicar) {
            resultado = multiplicar(a, b);
            simbolo = "×";
        } else if (id == R.id.btnDividir) {
            if (b == 0) {
                Toast.makeText(this, "No se puede dividir entre cero", Toast.LENGTH_LONG).show();
                tvResultado.setTextColor(Color.RED);
                tvResultado.setText("Resultado: error");
                return;
            }
            resultado = dividir(a, b);
            simbolo = "÷";
        } else {
            return;
        }

        mostrarResultado(a, b, simbolo, resultado);
    }

    // ===== Operaciones: una por integrante =====

    // Integrante 1
    private double sumar(double a, double b) {
        return a + b;
    }

    // Integrante 1
    private double restar(double a, double b) {
        return a - b;
    }

    // Integrante 2
    private double multiplicar(double a, double b) {
        return a * b;
    }

    // Integrante 3
    private double dividir(double a, double b) {
        return a / b;
    }

    // ===== Salida: formato de texto desde Java y append() =====

    private void mostrarResultado(double a, double b, String simbolo, double resultado) {
        String linea = formatear(a) + " " + simbolo + " " + formatear(b) + " = " + formatear(resultado);
        tvResultado.setTextColor(Color.parseColor("#2ECC71"));
        tvResultado.setText("Resultado: " + formatear(resultado));
        tvHistorial.append(linea + "\n");
    }

    private String formatear(double n) {
        if (n == (long) n) {
            return String.valueOf((long) n);
        }
        return String.valueOf(n);
    }
}
