package com.example.uts_mcs_2540120345;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


public class HomeFragment extends Fragment {
    TextView NewsTitle, NewsDesc;
    AdapterNews adapter;
    ArrayList<News> NewsList;
    RecyclerView recyclerView;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        NewsTitle = view.findViewById(R.id.tv_newsTitle);
        NewsDesc = view.findViewById(R.id.tv_newsDesc);
        recyclerView = view.findViewById(R.id.rvList2);

        NewsList = new ArrayList<>();
        NewsList.add(new News("Warriors VS Kings", " 87 - 90"));
        NewsList.add(new News("Lakers VS Memphis", "102 - 104"));

        adapter = new AdapterNews(NewsList, this.getContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
        return view;
    }
}