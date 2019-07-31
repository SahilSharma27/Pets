package com.example.android.pets;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Intent intent;
    ListView listView;
    PetAdapter adapter;
    ArrayList <Pet> pets=new ArrayList<>();
    public static final int ADD_PET_CODE = 1;
    String Name ;
    String Breed ;
    int Gender ;
    int Measurement ;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.listview);
        readDB();
        adapter=new PetAdapter(this,pets);
        listView.setAdapter(adapter);


    }
    public void addPet(View view) {
        intent = new Intent(this, Main2Activity.class);
        startActivityForResult(intent,ADD_PET_CODE);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu2,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id= item.getItemId();
        if(id==R.id.addDummy){
            insertDummyData();


        }
        else if (id == R.id.delete){
            deleteALL();

        }
        return super.onOptionsItemSelected(item);
    }
    public void insertDummyData() {
        Pet dummyPet = new Pet();
        dummyPet.setName("TOTO");
        dummyPet.setBreed("Terrier");
        dummyPet.setGender(1);
        dummyPet.setMeasurement(7);
        insertData(dummyPet);
    }
        public void insertData(Pet p){
        PetsOpenHelper openHelper =new PetsOpenHelper(this);
        SQLiteDatabase db = openHelper.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(Contract.PetEntry.COLUMN_PET_NAME,p.getName());
        contentValues.put(Contract.PetEntry.COLUMN_PET_BREED,p.getBreed());
        contentValues.put(Contract.PetEntry.COLUMN_PET_GENDER,p.getGender());
        contentValues.put(Contract.PetEntry.COLUMN_PET_WEIGHT,p.getMeasurement());
        long id =db.insert(Contract.PetEntry.TABLE_NAME,null,contentValues);
        if (id > -1L) {

            pets.add(p);
            adapter.notifyDataSetChanged();

        }
    }
    public void readDB(){
        PetsOpenHelper openHelper =new PetsOpenHelper(this);
        SQLiteDatabase db = openHelper.getReadableDatabase();
        Cursor cursor=db.query(Contract.PetEntry.TABLE_NAME,null,null,null,null,null,null);
        while(cursor.moveToNext()){
             Name =cursor.getString(cursor.getColumnIndex(Contract.PetEntry.COLUMN_PET_NAME));
             Breed =cursor.getString(cursor.getColumnIndex(Contract.PetEntry.COLUMN_PET_BREED));
             Gender =cursor.getInt(cursor.getColumnIndex(Contract.PetEntry.COLUMN_PET_GENDER));
             Measurement =cursor.getInt(cursor.getColumnIndex(Contract.PetEntry.COLUMN_PET_WEIGHT));
             Pet newPet =new Pet();
             newPet.setName(Name);
             newPet.setBreed(Breed);
             newPet.setGender(Gender);
             newPet.setMeasurement(Measurement);
             pets.add(newPet);

        }
        cursor.close();
    }
    public void deleteALL(){

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==ADD_PET_CODE){
            if(resultCode== Main2Activity.ADD_CODE){
                Pet newPet=new Pet();
                String Name =data.getStringExtra(Main2Activity.NAME_KEY);
                String Breed=data.getStringExtra(Main2Activity.BREED_KEY);
                int Gender=data.getIntExtra(Main2Activity.GENDER_KEY,Contract.PetEntry.GENDER_UNKNOWN);
                int Weight=data.getIntExtra(Main2Activity.WEIGHT_KEY,0);
                newPet.setName(Name);
                newPet.setBreed(Breed);
                newPet.setGender(Gender);
                newPet.setMeasurement(Weight);
                insertData(newPet);
            }
        }
    }
}
