package jeff.example.service.telog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import android.os.Bundle;

public class Report extends AppCompatActivity {
    Button reportall, specificdate;
    databaseHelper myDb;
    EditText masuk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myDb = new databaseHelper(this);
        setContentView(R.layout.activity_report);
        masuk = (EditText)findViewById(R.id.masuk);
        specificdate = (Button) findViewById(R.id.specificdate);
        reportall = (Button) findViewById(R.id.reportall);
        reportall();



    }









    public void reportall() {

        reportall.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
               Cursor res = myDb.getAllData();
               if(res.getCount() ==0){

                   //show message
                   showMessage("Error", "No data found");
                   return;


               }

               StringBuffer buffer = new StringBuffer();
               while (res.moveToNext()){
                   buffer.append("Quantity A:" + res.getString(0) + "\n");
                   buffer.append("Quantity B:" + res.getString(1) + "\n");
                   buffer.append("Quantity C:" + res.getString(2) + "\n");
                   buffer.append("Quantity D:" + res.getString(3) + "\n");
                   buffer.append("Quantity E:" + res.getString(4) + "\n");
                   buffer.append("Date:" + res.getString(5) + "\n\n");
               }

               //show data
                showMessage("Data", buffer.toString());
            }
        });
    }

    public void showMessage(String title, String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
}
