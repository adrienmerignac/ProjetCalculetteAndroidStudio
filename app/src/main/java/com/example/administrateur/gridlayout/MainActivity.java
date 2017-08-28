package com.example.administrateur.gridlayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import net.sourceforge.jeval.EvaluationException;
import net.sourceforge.jeval.Evaluator;

public class MainActivity extends AppCompatActivity {

    private TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtResult = (TextView) findViewById(R.id.txtResult);
    }

    public void touche (View v){

        Button b = (Button) v;
        //b.getText();
        String str = b.getText().toString();
        String result = txtResult.getText().toString();
        result = result + str;
        txtResult.setText(result);
    }

    public void toucheEgal (View v) throws EvaluationException {

        String result = txtResult.getText().toString();

        Evaluator evaluator = new Evaluator();

        try {
            txtResult.setText(evaluator.evaluate(result));
        }
        catch (Exception ex){
            Toast.makeText(this,"Erreur de syntaxe dans la formule", Toast.LENGTH_LONG).show();
        }
    }

    public void toucheClear (View v){
        txtResult.setText("");
    }
}
