package com.example.zagne_000.candysop;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class ItemFragment extends Fragment {
    AlertDialog.Builder ad;
    private ImageView image;
    private TextView nameMsg;
    private TextView categoryMsg;
    private TextView descriptionMsg;
    private Button buyBtn;
    private Button backBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item, container, false);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        image = (ImageView)getActivity().findViewById(R.id.imageView);
        nameMsg = (TextView)getActivity().findViewById(R.id.name_id);
        categoryMsg = (TextView)getActivity().findViewById(R.id.category_id);
        descriptionMsg = (TextView)getActivity().findViewById(R.id.description_id);
        buyBtn = (Button)getActivity().findViewById(R.id.button);
        backBtn = (Button)getActivity().findViewById(R.id.button3);
        ad = new AlertDialog.Builder(getContext());
        Bundle bundle = getArguments();
        Candy candy = (Candy)bundle.getSerializable("object");
        image.setImageResource(candy.getImage());
        nameMsg.setText(candy.getName());
        categoryMsg.setText(candy.getCategory());
        descriptionMsg.setText(candy.getDescription());
        String title = "Подтверждение выбора";
        String message = "Вы уверены, что хотите приобрести " + candy.getName() + " за " + candy.getPrice() + " р. ?";
        String button1String = "Да";
        String button2String = "Нет";
        ad.setTitle(title);  // заголовок
        ad.setMessage(message); // сообщение
        ad.setPositiveButton(button1String, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int arg1) {
                Toast.makeText(getContext(), "Вы сделали покупку",
                        Toast.LENGTH_LONG).show();
            }
        });
        ad.setNegativeButton(button2String, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int arg1) {
                Toast.makeText(getContext(), "Покупка отменена", Toast.LENGTH_LONG)
                        .show();
            }
        });
        buyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ad.show();
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchFragment(new ItemListFragment());
            }
        });
    }

    private void switchFragment(Fragment newFragment){
        if(getContext() == null){
            return;
        }
        if(getContext() instanceof MainActivity){
            MainActivity feeds = (MainActivity) getContext();
            feeds.replaceFirstFragment();
        }
    }
}
