package com.project_music.hungrii;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.project_music.hungrii.Adapters.OrdersAdapter;
import com.project_music.hungrii.Models.OrdersModel;
import com.project_music.hungrii.databinding.ActivityOrderBinding;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {
    ActivityOrderBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityOrderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        DBHelper helper=new DBHelper(this);
        ArrayList<OrdersModel> list=helper.getOrders();

        if (list.isEmpty()) binding.payment.setVisibility(View.GONE);

        OrdersAdapter adapter=new OrdersAdapter(list,this);
        binding.ordersRecyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager= new LinearLayoutManager(this);
        binding.ordersRecyclerView.setLayoutManager(layoutManager);

        binding.payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(OrderActivity.this);
                dialog.setTitle("Are You Sure to make Payment?");
                dialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        startActivity(new Intent(OrderActivity.this, PaymentActivity.class).putExtra("list", list));
                        list.clear();
                        adapter.notifyDataSetChanged();
                        helper.clearTable();
                    }
                });
                dialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(OrderActivity.this, "Bhak Kanjus!", Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.show();
            }
        });

    }
}