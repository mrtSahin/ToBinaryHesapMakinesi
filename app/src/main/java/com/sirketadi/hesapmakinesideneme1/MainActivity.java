package com.sirketadi.hesapmakinesideneme1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.GridView;
import android.widget.Switch;
import android.widget.Toast;

import com.sirketadi.hesapmakinesideneme1.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding views;
    private Cevir cevir;
    private Menu menu;

    private ArrayList<String> sayilar = new ArrayList<>();
    private ArrayAdapter<String> veriAdaptoru;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        views = DataBindingUtil.setContentView(this, R.layout.activity_main);
        sayilar.add("1");
        sayilar.add("2");
        sayilar.add("3");
        sayilar.add("4");
        sayilar.add("5");
        sayilar.add("6");
        sayilar.add("7");
        sayilar.add("8");
        sayilar.add("9");
        sayilar.add("Sil");
        sayilar.add("0");

        views.toolbar.setTitle("HesapMakinesi");
        views.toolbar.setTitleTextColor(getColor(R.color.yaziRengi));
        setSupportActionBar(views.toolbar);


        cevir = new Cevir();


        veriAdaptoru = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1, sayilar);
        views.gridView.setAdapter(veriAdaptoru);

        views.gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


                if (sayilar.get(i) == "Sil" && (views.textViewGiris.getText().length() - 1) >= 0) {
                    views.textViewGiris.setText(String.valueOf(views.textViewGiris.getText()).substring(0, views.textViewGiris.getText().length() - 1));
                } else if (sayilar.get(i) == "Sil") {
                    Toast.makeText(getApplicationContext(), "SayiDeğeriGiriniz", Toast.LENGTH_SHORT).show();

                } else {
                    views.textViewGiris.setText(views.textViewGiris.getText() + sayilar.get(i));
                }
            }
        });

        views.buttonCevir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                views.textViewSonuc.setText("");

                if (views.textViewGiris.getText().length() > 0) {
                    String sonuc = cevir.hesapla(Integer.parseInt(String.valueOf(views.textViewGiris.getText())));
                    views.textViewSonuc.setText(sonuc);
                } else {
                    Toast.makeText(getApplicationContext(), "DeğerGiriniz", Toast.LENGTH_SHORT).show();
                }
            }

        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mode_button:
                if (getDelegate().getLocalNightMode() == AppCompatDelegate.MODE_NIGHT_NO) {
                    getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    return true;
                } else {
                    getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    return true;
                }
        default:
            return super.onOptionsItemSelected(item);
        }
    }
}