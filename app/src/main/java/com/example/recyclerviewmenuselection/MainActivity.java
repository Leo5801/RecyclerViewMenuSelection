package com.example.recyclerviewmenuselection;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Vocabulary> vocabularyArrayList;
    VocabularyAdapter adapter;
    TextView textView;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=findViewById(R.id.textviewcounter);
        imageView=findViewById(R.id.imageviewdelete);

        recyclerView=findViewById(R.id.recyclerview1);
        vocabularyArrayList=new ArrayList<>();
        vocabularyArrayList.add(new Vocabulary("Cat","Mushuk"));
        vocabularyArrayList.add(new Vocabulary("Dog","Ko'ppak"));
        vocabularyArrayList.add(new Vocabulary("Bird","Qush"));
        vocabularyArrayList.add(new Vocabulary("Bear","Ayiq"));

        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        adapter=new VocabularyAdapter(MainActivity.this,vocabularyArrayList);
        recyclerView.setAdapter(adapter);
    }
}