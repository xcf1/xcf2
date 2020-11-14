package com.example.fruit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button b1;
    private EditText e1;
    private ProgressBar pb1;
    private  String[] data={"apple","banana","cheryy","pear","orange","grape"};
    private ListView myList;
    private List<Fruit>fruitList=new ArrayList<Fruit>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=findViewById(R.id.b1);
        myList=findViewById(R.id.l1);
        InitFruit();
        FruitAdapter adapter=new FruitAdapter(MainActivity.this,R.layout.item_layout,fruitList);
        ArrayAdapter<String> adapter1=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,data);
        myList.setAdapter(adapter);
        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fruit fruit=fruitList.get(position);
                Toast.makeText(getApplicationContext(),fruit.getName(),Toast.LENGTH_LONG).show();
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                final String geteidtext=e1.getText().toString();
                int pb=pb1.getProgress();
                pb=pb+10;
                pb1.setProgress(pb);
                AlertDialog.Builder dialog=new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("this is Dialog");
                dialog.setCancelable(false);
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                dialog.show();

                //Toast.makeText(MainActivity.this,geteidtext,Toast.LENGTH_LONG).show();
            }
        });                }
    public  void InitFruit(){
        for (int i=0;i<2;i++){
            Fruit fruit=new Fruit("苹果",R.drawable.apple_pic);
            fruitList.add(fruit);
            Fruit fruit1=new Fruit("香蕉",R.drawable.banana_pic);
            fruitList.add(fruit1);
            Fruit fruit2=new Fruit("樱桃",R.drawable.cherry_pic);
            fruitList.add(fruit2);
            Fruit fruit3=new Fruit("葡萄",R.drawable.grape_pic);
            fruitList.add(fruit3);
            Fruit fruit4=new Fruit("芒果",R.drawable.mango_pic);
            fruitList.add(fruit4);
            Fruit fruit5=new Fruit("梨子",R.drawable.pear_pic);
            fruitList.add(fruit5);}
    }
}