package com.example.sjcet.database;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
 EditText Name,Surname,Mark;
 TextView DataV;
 MyDatabase database=new MyDatabase(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Name=findViewById(R.id.ed1);
        Surname=findViewById(R.id.ed2);
        Mark=findViewById(R.id.ed3);
        DataV=findViewById(R.id.textView);

    }

    public void insert(View view) {
        String UserVal=Name.getText().toString();
        String SurnameVal=Surname.getText().toString();
        Integer PassVal=Integer.parseInt(Mark.getText().toString());
        Boolean result=database.(UserVal,PassVal,SurnameVal);
        if(result=true)
        {
            Toast.makeText(getApplicationContext(),"data inserted successfully",Toast.LENGTH_SHORT).show();

        }
        else{
            Toast.makeText(getApplicationContext(),"data insertion failed",Toast.LENGTH_SHORT).show();
        }

    }

    public void Delete(View view) {
        String UserVal=Name.getText().toString();
        int result=database.deletedata(UserVal);
        Toast.makeText(getApplicationContext(),"row effected",Toast.LENGTH_SHORT).show();

    }
}
