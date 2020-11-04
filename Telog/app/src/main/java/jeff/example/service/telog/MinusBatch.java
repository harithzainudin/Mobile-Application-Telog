package jeff.example.service.telog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MinusBatch extends AppCompatActivity {

    Button calculate;
    EditText a,b,c,d,e;

    TextView totalresult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_minus_batch);
        a = (EditText)findViewById(R.id.QA);
        b = (EditText)findViewById(R.id.QB);
        c = (EditText) findViewById(R.id.QC);
        d = (EditText) findViewById(R.id.QD);
        e = (EditText) findViewById(R.id.QE);
        calculate = (Button) findViewById(R.id.calculate);



        totalresult = (TextView) findViewById(R.id.result);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeCalculations();
            }
        });

    }

    private void makeCalculations() {
        // I'm assuming you're getting numbers.
        double n1 = Double.valueOf(a.getText().toString());
        double n2 = Double.valueOf(b.getText().toString());
        double n3 = Double.valueOf(c.getText().toString());
        double n4 = Double.valueOf(d.getText().toString());
        double n5 = Double.valueOf(e.getText().toString());

        // Do your calculation here.


        double result = n1+n2+n3+n4+n5;
        // I'm assuming you have inserted the result on a variable called 'result'. Like: double result

        totalresult.setText("" + result);


    }

    // The rest of your Activity and methods.

}
