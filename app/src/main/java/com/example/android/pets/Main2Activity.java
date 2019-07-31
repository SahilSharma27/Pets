package com.example.android.pets;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


public class Main2Activity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner spinner;
    ArrayAdapter<CharSequence> adapter;
    EditText editText1;
    EditText editText2;
    EditText editText3;
    String gender;
    int code;
    Intent intent;
    public static final int ADD_CODE=2;
    public static final String NAME_KEY = "name";
    public static final String BREED_KEY= "breed";
    public static final String GENDER_KEY ="gender";
    public static final String WEIGHT_KEY ="weight";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toast.makeText(this, "add info", Toast.LENGTH_SHORT).show();
        editText1=findViewById(R.id.overview1);
        editText2=findViewById(R.id.overview2);
        editText3=findViewById(R.id.measurement);
        spinner=(Spinner)findViewById(R.id.spinner);
        adapter=ArrayAdapter.createFromResource(this,R.array.gender,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        gender=adapterView.getItemAtPosition(i).toString();
        if(gender.equals("Male"))
            code=Contract.PetEntry.GENDER_MALE;
        if(gender.equals("Female"))
            code=Contract.PetEntry.GENDER_FEMALE;
        if(gender.equals("Unknown"))
            code=Contract.PetEntry.GENDER_UNKNOWN;
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu1,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.saveItem) {
            insertNewPet();

        }
        return super.onOptionsItemSelected(item);
    }
    public void insertNewPet(){
        intent=getIntent();
        String Name =editText1.getText().toString();
        String Breed=editText2.getText().toString();
        int Gender=code;
        int Weight=Integer.parseInt(editText3.getText().toString());
        intent.putExtra(NAME_KEY,Name);
        intent.putExtra(BREED_KEY,Breed);
        intent.putExtra(GENDER_KEY,Gender);
        intent.putExtra(WEIGHT_KEY,Weight);
        setResult(ADD_CODE,intent);
        finish();


    }

}
