package com.example.caftech;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class CafeMedia extends AppCompatActivity {
    Toolbar toolbar;
    ArrayList<listitems> listitems=new ArrayList<listitems>();
    int[] imgs={R.drawable.starbucks,R.drawable.fourteen, R.drawable.bigbamboo, R.drawable.ocoin};
    ListAdapter ad;
    ArrayList<listitems> listCafe;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cafe_media3);
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        listView=(ListView)findViewById(R.id.listView);

        String[] cafename=getResources().getStringArray(R.array.cafeName);
        listCafe=new ArrayList<listitems>();
        for(int i=0;i<cafename.length;i++){
            listCafe.add(new listitems(i,imgs[i],cafename[i]));
        }
        ad=new ListAdapter(listCafe);
        listView.setAdapter(ad);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (parent.getItemAtPosition(position).toString().equals("STARBUCKS COFFEE")){
                    Intent startbucks=new Intent(CafeMedia.this,Starbucks.class);
                    startActivity(startbucks);
                }
                if (parent.getItemAtPosition(position).toString().equals("ml")){
                    Intent ac=new Intent(CafeMedia.this,MainActivity.class);
                    startActivity(ac);
                }
            }
        });




    }


    //listView
    class ListAdapter extends BaseAdapter{
        ArrayList<listitems> listitems=new ArrayList<listitems>();
        ListAdapter(ArrayList<listitems> listitems){
            this.listitems=listitems;
        }

        @Override
        public int getCount() {
            return listitems.size();
        }

        @Override
        public Object getItem(int position) {
            return listitems.get(position).name;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater layoutInflater=getLayoutInflater();
            View view=layoutInflater.inflate(R.layout.row_items,null);
            TextView name=(TextView)view.findViewById(R.id.name);
            ImageView img=(ImageView)view.findViewById(R.id.img);

            name.setText(listitems.get(position).name);
            img.setImageResource(listitems.get(position).img);
            return view;
        }

        public void update(ArrayList<listitems> results){
            listitems=new ArrayList<>();
            listitems.addAll(results);

            notifyDataSetChanged();
        }


    }






    //toolbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);

        MenuItem myActionMenuItem=menu.findItem(R.id.search);
        SearchView searchView=(SearchView)myActionMenuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                ArrayList<listitems> results=new ArrayList<>();
                for(listitems x:listCafe){
                    if(x.name.toLowerCase().contains(newText.toLowerCase()))
                        results.add(x);
                }

                ((ListAdapter)listView.getAdapter()).update(results);

                return false;
            }
        });
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();

        if(id==R.id.setting){
            Intent setting=new Intent(this,setting.class);
            startActivity(setting);
        }


        if(id==R.id.exit){
            Intent exit=new Intent(CafeMedia.this,MainActivity.class);
            startActivity(exit);

        }
        return super.onOptionsItemSelected(item);
    }


}
