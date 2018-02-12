package com.example.codingmounrtain.addtocartbadgecount;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.codingmounrtain.addtocartbadgecount.ModelClasses.Products;
import com.example.codingmounrtain.addtocartbadgecount.adapter.RecyclerAdapter;
import com.example.codingmounrtain.addtocartbadgecount.interfaces.AddorRemoveCallbacks;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AddorRemoveCallbacks {

    RecyclerView mRecyclerView;
    RecyclerAdapter mAdapter;
    String[] productNames={"Watch","Sunglasses","Book","Watch","Shoes","Books","Glasses","Camera","Camera","Laptop"};
    int[] productImages={R.drawable.item1,R.drawable.item4,R.drawable.item3,R.drawable.item2,R.drawable.item5,R.drawable.item6,R.drawable.item7,R.drawable.item8,R.drawable.item9,R.drawable.item10};
    private static int cart_count=0;
    FloatingActionButton fab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("CodingMountain");

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        Products product;
        List<Products> listdata=new ArrayList<>();
        for(int i=0;i<10;i++)
        {
            product = new Products(productNames[i],productImages[i]);
            listdata.add(product);
        }

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        mRecyclerView.setHasFixedSize(true);
        GridLayoutManager mLayoutManager = new GridLayoutManager(this,2);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new RecyclerAdapter(this,listdata);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem menuItem = menu.findItem(R.id.cart_action);
        menuItem.setIcon(Converter.convertLayoutToImage(MainActivity.this,cart_count,R.drawable.ic_shopping_cart_white_24dp));
        MenuItem menuItem2 = menu.findItem(R.id.notification_action);
        menuItem2.setIcon(Converter.convertLayoutToImage(MainActivity.this,2,R.drawable.ic_notifications_white_24dp));
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onAddProduct() {
        cart_count++;
        invalidateOptionsMenu();
        Snackbar.make((CoordinatorLayout)findViewById(R.id.parentlayout), "Added to cart !!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();


    }

    @Override
    public void onRemoveProduct() {
        cart_count--;
        invalidateOptionsMenu();
        Snackbar.make((CoordinatorLayout)findViewById(R.id.parentlayout), "Removed from cart !!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

    }
}
