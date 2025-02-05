package com.project_music.hungrii.Adapters;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project_music.hungrii.DetailActivity;
import com.project_music.hungrii.Models.OrdersModel;
import com.project_music.hungrii.R;

import java.util.ArrayList;

public class OrdersAdapter extends RecyclerView.Adapter<OrdersAdapter.viewHolder>{
    ArrayList<OrdersModel> list;
    Context context;

    public OrdersAdapter(ArrayList<OrdersModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.order_sample,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
     final OrdersModel model=list.get(position);
     holder.orderImage.setImageResource(model.getOrderImage());
     holder.soldItemName.setText(model.getSoldItemName());
     holder.orderNumber.setText(model.getOrderNumber());
     holder.price.setText(model.getPrice());

     holder.itemView.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             Intent intent= new Intent(context, DetailActivity.class);
             intent.putExtra("id",Integer.parseInt(model.getOrderNumber().trim()));
             intent.putExtra("image", model.getOrderImage());
             intent.putExtra("name", model.getSoldItemName());
             intent.putExtra("desc", "");
             intent.putExtra("price", Integer.parseInt(model.getPrice().trim()));
//             intent.putExtra("id",model.getOrderNumber());
             intent.putExtra("type",2);
             context.startActivity(intent);
         }
     });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{

        ImageView orderImage;
        TextView soldItemName,orderNumber,price;

        public viewHolder(@NonNull View itemView) {

            super(itemView);
            orderImage=itemView.findViewById(R.id.orderImage);
            soldItemName=itemView.findViewById(R.id.orderItemName);
            orderNumber=itemView.findViewById(R.id.orderNumber);
            price=itemView.findViewById(R.id.orderAmount);
        }

    }
}
