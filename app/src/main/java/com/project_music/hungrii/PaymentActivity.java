package com.project_music.hungrii;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.project_music.hungrii.Adapters.OrdersAdapter;
import com.project_music.hungrii.Models.OrdersModel;
import com.project_music.hungrii.databinding.ActivityPaymentBinding;

import java.util.ArrayList;

public class PaymentActivity extends AppCompatActivity {

    ActivityPaymentBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPaymentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<OrdersModel> list = (ArrayList<OrdersModel>) getIntent().getSerializableExtra("list");
        OrdersAdapter adapter=new OrdersAdapter(list,this);
        binding.paymentRv.setAdapter(adapter);

        LinearLayoutManager layoutManager= new LinearLayoutManager(this);
        binding.paymentRv.setLayoutManager(layoutManager);

        int price = 0;
        for (OrdersModel item: list) {
            price += Integer.parseInt(item.getPrice().trim());
        }

        binding.textView2.setText(price + "");

        binding.insertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.editTextNumber.getText().length() == 16) {
                    list.clear();
                    Toast.makeText(PaymentActivity.this, "Payment Successful! Order ariving soon", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(PaymentActivity.this, MainActivity.class));
                }
                else Toast.makeText(PaymentActivity.this, "Credit card number is invalid", Toast.LENGTH_SHORT).show();
            }
        });
    }
}