package jeff.example.service.telog;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View.OnClickListener;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;




public class AddBatch extends AppCompatActivity {

    Button calculate, add;
    EditText QUANTITYA,QUANTITYB,QUANTITYC,QUANTITYD,QUANTITYE,DATES;
    TextView totalresult;
    databaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myDb = new databaseHelper(this);
        setContentView(R.layout.activity_add_batch);
        QUANTITYA = (EditText)findViewById(R.id.QA);
        QUANTITYB = (EditText)findViewById(R.id.QB);
        QUANTITYC = (EditText) findViewById(R.id.QC);
        QUANTITYD = (EditText) findViewById(R.id.QD);
        QUANTITYE = (EditText) findViewById(R.id.QE);
        DATES = (EditText) findViewById(R.id.date);
        calculate = (Button) findViewById(R.id.calculate);
        add = (Button) findViewById(R.id.save);



        totalresult = (TextView) findViewById(R.id.result);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeCalculations();
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addData();
            }
        });
    }



    private void makeCalculations() {
        // I'm assuming you're getting numbers.
        double n1 = Double.valueOf(QUANTITYA.getText().toString());
        double n2 = Double.valueOf(QUANTITYB.getText().toString());
        double n3 = Double.valueOf(QUANTITYC.getText().toString());
        double n4 = Double.valueOf(QUANTITYD.getText().toString());
        double n5 = Double.valueOf(QUANTITYE.getText().toString());

        // Do your calculation here.

        double result = n1+n2+n3+n4+n5;
        // I'm assuming you have inserted the result on a variable called 'result'. Like: double result

        totalresult.setText("" + result);


    }
    public void addData() {

        add.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
        boolean isInserted = myDb.insertData( QUANTITYA.getText().toString(), QUANTITYB.getText().toString(), QUANTITYC.getText().toString(), QUANTITYD.getText().toString(), QUANTITYE.getText().toString(), DATES.getText().toString());
    if(isInserted=true)
        Toast.makeText(AddBatch.this, "Data inserted", Toast.LENGTH_LONG).show();
    else
        Toast.makeText(AddBatch.this, "Data not inserted", Toast.LENGTH_LONG).show();
            }
        });
    }



    // The rest of your Activity and methods.

}
