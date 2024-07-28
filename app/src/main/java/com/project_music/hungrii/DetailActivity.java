package com.project_music.hungrii;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.project_music.hungrii.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {
ActivityDetailBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        final DBHelper helper = new DBHelper(this);

//        if (getIntent().getIntExtra("type", 0) == 1) {




        final int image = getIntent().getIntExtra("image", 0);
        final int price = getIntent().getIntExtra("price", 0);
        final String name = getIntent().getStringExtra("name");
        final String description = getIntent().getStringExtra("desc");
        final int id = getIntent().getIntExtra("id", 1);
        Cursor cursor = helper.getOrderById(id);
        int quantity;
        if (getIntent().getIntExtra("type", 0) != 1) quantity = cursor.getInt(5);
        else quantity = 1;
        binding.quantity.setText(quantity + "");
        if (getIntent().getIntExtra("type", 0) == 2) {
            binding.nameBox.setText(cursor.getString(1));
            binding.phoneBox.setText(cursor.getString(2));
            binding.insertBtn.setText("Update Order");
        }

        binding.detailImage.setImageResource(image);
        binding.priceLbl.setText(String.format("%d", price * quantity));
        binding.fN.setText(name);
        binding.detailDescription.setText(description);


        binding.insertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.phoneBox.getText().length() == 10) {
                    boolean isInserted = helper.insertOrder(
                            binding.nameBox.getText().toString(),
                            binding.phoneBox.getText().toString(),
                            price,
                            image,
                            name,
                            description,
                            Integer.parseInt(binding.quantity.getText().toString())
                    );
                    if (isInserted)
                        Toast.makeText(DetailActivity.this, "Order successful", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(DetailActivity.this, "Error", Toast.LENGTH_SHORT).show();
                } else Toast.makeText(DetailActivity.this, "Phone Number is invalid", Toast.LENGTH_SHORT).show();
            }
        });

        binding.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                helper.updateOrder(id, binding.nameBox.getText().toString(), binding.phoneBox.getText().toString(), price, image, description, name, Integer.parseInt(binding.quantity.getText().toString()) + 1);
                binding.quantity.setText((Integer.parseInt(binding.quantity.getText().toString()) + 1) + "");
                binding.priceLbl.setText(String.format("%d", price * (Integer.parseInt(binding.quantity.getText().toString()))));
            }
        });

        binding.subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                helper.updateOrder(id, binding.nameBox.getText().toString(), binding.phoneBox.getText().toString(), price, image, description, name, Integer.parseInt(binding.quantity.getText().toString()) - 1);
                binding.quantity.setText((Integer.parseInt(binding.quantity.getText().toString()) - 1) + "");
                binding.priceLbl.setText(String.format("%d", price * (Integer.parseInt(binding.quantity.getText().toString()))));
            }
        });
    }
//    else{
//         int id= getIntent().getIntExtra("id",0);
//         Cursor cursor= helper.getOrderById(id);
//Toast.makeText(this, cursor.getString(1), Toast.LENGTH_SHORT).show();
//            binding.detailImage.setImageResource(cursor.getInt(4));
//            binding.priceLbl.setText(String.format("%d", cursor.getInt(3)));
//            binding.fN.setText(cursor.getString(6));
//            binding.detailDescription.setText(cursor.getString(5 ));
//
//    }
}