package com.yuk_belajarwiki.yukbelajarfd;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class contohpengertian extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contohpengertian);
        Toolbar Nav_tool= findViewById(R.id.Nav_toolbar);
        setSupportActionBar(Nav_tool);

        ActionBar actionBar= getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_navi);


        final NavigationView Navview= findViewById(R.id.Nav_menu);
        Navview.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem Item) {
                DrawerLayout drawer = findViewById(R.id.contohpengertian);
                Item.setChecked(true);
                int nav_menu_id = Item.getItemId();

                switch(nav_menu_id){

                    case R.id.Nav_catatan:
                        Intent intent;
                        intent = new Intent(contohpengertian.this, tawal_note.class);
                        startActivity(intent);
                        break;
                    case R.id.Nav_Mpengertian:
                        Intent MP;
                        MP = new Intent(contohpengertian.this, maretipengertian.class);
                        startActivity(MP);
                        break;
                    case R.id.Nav_MFull:
                        Intent MT;
                        MT = new Intent(contohpengertian.this, materiFull.class);
                        startActivity(MT);
                        break;
                    case R.id.Nav_Mpartilly:
                        Intent Mp;
                        Mp = new Intent(contohpengertian.this, materipartially.class);
                        startActivity(Mp);
                        break;
                    case R.id.Nav_Mtransitive:
                        Intent MF;
                        MF = new Intent(contohpengertian.this, materitransitive.class);
                        startActivity(MF);
                        break;
                    case R.id.Nav_Cpengertian:
                        Intent CP;
                        CP = new Intent(contohpengertian.this, contohpengertian.class);
                        startActivity(CP);
                        break;
                    case R.id.Nav_CFull:
                        Intent cf;
                        cf = new Intent(contohpengertian.this, contohfull.class);
                        startActivity(cf);
                        break;
                    case R.id.Nav_Cpartilly:
                        Intent cp;
                        cp= new Intent(contohpengertian.this, contohpartially.class);
                        startActivity(cp);
                        break;
                    case R.id.Nav_Ctransitive:
                        Intent ct;
                        ct = new Intent(contohpengertian.this, contohtransitive.class);
                        startActivity(ct);
                        break;


                    default:drawer.closeDrawer(0);
                        return true;
                }

                return true;
            }
        });
    }
}
