package com.example.zakat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText etGoldWeight;
    RadioGroup rgGoldType;
    RadioButton rbRadioKeep;
    RadioButton rbRadioWear;
    RadioButton rbSelect;
    EditText etCurrentGoldValue;
    Button btnCalculate;
    TextView tvValueGold;
    TextView tvZakatPayable;
    TextView tvZakat;
    Button btnClear;

    double goldTypeWeight =0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        etGoldWeight = (EditText) findViewById(R.id.goldWeight);
        etCurrentGoldValue = (EditText) findViewById(R.id.currentGoldValue);
        rgGoldType = (RadioGroup) findViewById(R.id.goldType);
        btnCalculate = (Button) findViewById(R.id.btnCalculate);
        tvValueGold = (TextView) findViewById(R.id.tvValueGold);
        tvZakatPayable = (TextView) findViewById(R.id.tvZakatPayable);
        tvZakat = (TextView) findViewById(R.id.tvZakat);
        btnClear = (Button) findViewById(R.id.btnClear);

        btnCalculate.setOnClickListener(this);
        btnClear.setOnClickListener(this);


    }

    public void checkButton(View view){

        int radioId = rgGoldType.getCheckedRadioButtonId();

        rbSelect = findViewById(radioId);

        // double goldTypeWeight = 0; (declare at main activity)

        if(rbSelect.getText().equals("Keep")){
            goldTypeWeight = 85;
        }
        else if(rbSelect.getText().equals("Wear")){
            goldTypeWeight = 200;
        }
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.btnCalculate:

                try{
                    double goldWeight = Double.parseDouble(etGoldWeight.getText().toString());
                    double CurrentgoldValue = Double.parseDouble(etCurrentGoldValue.getText().toString());

                    double totalValue = goldWeight * CurrentgoldValue;
                    double zakatPayable = (goldWeight - goldTypeWeight) * CurrentgoldValue;

                    if(zakatPayable < 0){
                        zakatPayable = 0;
                    }

                    double totalZakat = zakatPayable * 0.025;

                    tvValueGold.setText("Total Value of gold: RM" + totalValue);
                    tvZakatPayable.setText("Total Value of Zakat Payable: RM" +zakatPayable);
                    tvZakat.setText("Total Zakat: RM" + totalZakat);

                    break;

                }
                catch (java.lang.NumberFormatException nfe ){

                    Toast.makeText(this, "Please enter a valid number",Toast.LENGTH_SHORT).show();

                }
                catch (Exception exp) {

                    Toast.makeText(this, "Unknown Exception" + exp.getMessage() , Toast.LENGTH_SHORT).show();

                    Log.d("Exception", exp.getMessage());

                }

            case R.id.btnClear:
                etGoldWeight.setText("");
                rgGoldType.clearCheck();
                etCurrentGoldValue.setText("");
                tvValueGold.setText("Total Value of gold: RM");
                tvZakatPayable.setText("Total Value of Zakat Payable: RM");
                tvZakat.setText("Total Zakat: RM" );

                break;
        }
    }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.about :
                //Toast.makeText(this, "This is about",Toast.LENGTH_LONG).show();

                Intent intent = new Intent( this, AboutActivity.class);
                startActivity(intent);

                break;

            case R.id.calculator:

                //Toast.makeText(this, "This is calculator",Toast.LENGTH_LONG).show();
                Intent intent2 = new Intent( this, MainActivity.class);
                startActivity(intent2);

                break;
        }

        return super.onOptionsItemSelected(item);
    }
}