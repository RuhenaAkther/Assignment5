package com.example.assignmentrecyclerview;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.SearchView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        String[] title = getResources().getStringArray(R.array.Country_names);
        String[] subtitles= getResources().getStringArray(R.array.Country_subtitles);

        Integer[] imgid= {R.drawable.bangladesh , R.drawable.bhutan , R.drawable.china, R.drawable.india ,
                R.drawable.japan , R.drawable.america, R.drawable.armenia , R.drawable.afghanistan ,
                R.drawable.nepal, R.drawable.pakistan  };
        ArrayList<Model> data = new ArrayList<>();
        for (int i = 0; i<title.length; i++){
            Model obj = new Model();
            obj.setTitle(title[i]);
            obj.setSubtitle(subtitles[i]);
            obj.setImageId(imgid[i]);
            data.add(obj);
        }
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(data, getApplicationContext());
        recyclerView.setAdapter(adapter);
    }


}