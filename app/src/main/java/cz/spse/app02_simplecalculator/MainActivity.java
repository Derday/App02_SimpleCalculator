package cz.spse.app02_simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.security.PrivateKey;

public class MainActivity extends AppCompatActivity {

    private EditText mTextNum1, mTextNum2;
    private Spinner mSpinner;
    private Button mBtn1;
    private TextView mResult;

    private String[] operation = {"+", "-", "*", "/"};
    private String selectedOp; //vzbrana operace

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //my code
        // binding
        mTextNum1 = findViewById(R.id.TextNum1);
        mTextNum2 = findViewById(R.id.TextNum2);
        mSpinner = findViewById(R.id.spinner);
        mBtn1 = findViewById(R.id.Btn1);
        mResult = findViewById(R.id.textViewReslut);

        //aplikacni logika
        // nastaveni adapteru spineru
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_item, operation);
        mSpinner.setAdapter(adapter);

        //listener + handler
        mBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Double d1 = Double.parseDouble(mTextNum1.getText().toString());
                Double d2 = Double.parseDouble(mTextNum2.getText().toString());
                Double result;
                selectedOp = mSpinner.getSelectedItem().toString();

                switch (selectedOp) {
                    case "+": result = d1 + d2; mResult.setText(result.toString()); break;
                    case "-": result = d1 - d2; mResult.setText(result.toString()); break;
                    case "*": result = d1 * d2; mResult.setText(result.toString()); break;
                    case "/": result = d1 / d2; mResult.setText(result.toString()); break;
                    default: System.out.println("no");
                }




            }
        });


    }
}