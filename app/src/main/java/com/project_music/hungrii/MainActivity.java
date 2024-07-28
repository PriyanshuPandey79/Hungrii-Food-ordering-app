package com.project_music.hungrii;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.project_music.hungrii.Adapters.MainAdapter;
import com.project_music.hungrii.Models.MainModel;
import com.project_music.hungrii.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<MainModel> list=new ArrayList<>();
        list.add(new MainModel(R.drawable.cake,"80","Veg. Burger","Veg value burger & crispy medium fries  at a deal price"));
        list.add(new MainModel(R.drawable.pizza,"160","Farmhouse Pizza","Buy one get one free pizza on medium delivery"));
        list.add(new MainModel(R.drawable.pas,"120","Pasta","Instant Fusilli Pasta, Harissa Sauce,Mushroom, Olives, Parsley sprinkle"));
        list.add(new MainModel(R.drawable.biryani,"180","Chicken Wings","Cheesy chicken fritters,tender and juicy,irresistible cheese pulls "));
        list.add(new MainModel(R.drawable.momos,"110","Momos","thickly wrapped Momos with stuffed Paneer, Vegetables and Soya Chunks. "));
        list.add(new MainModel(R.drawable.tikki,"80","Aloo Tikki","Dry heated boiled potatoes with peas & served wth curry ,saunth, tamarind sauces"));

        list.add(new MainModel(R.drawable.sandwi,"170","Sandwiches","Mustard garlic mayonnaise,with celery sandwiched in white bread slices."));
        list.add(new MainModel(R.drawable.img_5,"60","IceCream","Double Toned Milk, Cream,Skimmed Milk Powder, Cocoa, Belgian Chocolate"));
        list.add(new MainModel(R.drawable.maxresdefault,"180","Mushroom manchurian","Indo-Chinese appetizer made with crisp fried mushrooms in a delicious sweet, spicy & umami manchurian sauce"));

        list.add(new MainModel(R.drawable.img_2,"460","Choco lava cake","Covered in creamy real chocolate frosting and a boatload of chocolate chips"));
        list.add(new MainModel(R.drawable.veg_rolls,"120","Veg Rolls","Veg rolls made with whole wheat flour and mixed vegies"));
        list.add(new MainModel(R.drawable.chicken_roll,"180","Chicken rolls","A delicious roll with chicken cooked in fresh spice powder,crunchy onions & capsicum"));
        list.add(new MainModel(R.drawable.hcp,"140","Honey chilli potato","Juicy & crunchy potatoes with ajinomoto,salt,sugar and honey"));
        list.add(new MainModel(R.drawable.soup,"90","Tomato Cream Soup","Delicious creamy tomato soup made with exotic  & fresh tomatoes"));
        list.add(new MainModel(R.drawable.garlic_bread,"140","Cheese garlic Bread","topped with garlic and olive with additional herbs,oregano & chives"));
        list.add(new MainModel(R.drawable.noodles,"120","Noodles","hakka noodles with veggies, sauces and garlic,gobi manchurian and chilli paneer."));
        list.add(new MainModel(R.drawable.fries,"120","French Fries","a snack with deep-fried potatoes with sizzling shapes, especially thin strips"));
        list.add(new MainModel(R.drawable.maxresdefault,"180","Mushroom manchurian","Indo-Chinese crisp fried mushrooms with sweet, spicy & umami sauce"));


        list.add(new MainModel(R.drawable.biryani32,"180","Biryani","cooked with basmati rice flavored with exotic spices & fresh chicken pieces "));
        list.add(new MainModel(R.drawable.kabab,"210","Kababs"," meat grilled over charcoal fire and mixed with sizzling hot spices"));


        list.add(new MainModel(R.drawable.chaap,"190","Chaap","made with soya chaap , grilled in hot tandoor & served with onions & sauce "));

        MainAdapter adapter = new MainAdapter(list,this);
        binding.recylerView.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.recylerView.setLayoutManager(layoutManager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.orders:
                  startActivity(new Intent(MainActivity.this,OrderActivity.class));
                  break;
        }
        return super.onOptionsItemSelected(item);
    }
}