package com.example.zagne_000.candysop;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class ItemListFragment extends Fragment {
    List<Candy> candies = new ArrayList<>();
    private void setInitialData(){
        if(candies.isEmpty()) {
            candies.add(new Candy(R.drawable.chocolate, "Шоколад Шоколадский", "Мегакрутейший молочный шоколад", "100", "Шоколады"));
            candies.add(new Candy(R.drawable.cake, "Торт Дуэт", "Мегакрутейший торт", "300", "Торты"));
            candies.add(new Candy(R.drawable.pie, "Пироженое Пироженское", "Мегакрутейшее пироженое", "150", "Пироженые"));
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item_list, container, false);
        setInitialData();
        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.ItemListRecyclerView);
        // создаем адаптер
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        DataAdapter adapter = new DataAdapter(getActivity(), candies);
        // устанавливаем для списка адаптер
        recyclerView.setAdapter(adapter);
        return view;
    }
}