package com.yuk_belajarwiki.yukbelajarfd;


import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Homepage extends AppCompatActivity{

    //private DrawerLayout drawer =(DrawerLayout) findViewById(R.id.Drawer);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
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
                DrawerLayout drawer = findViewById(R.id.Drawer);
                Item.setChecked(true);
                int nav_menu_id = Item.getItemId();

                switch(nav_menu_id){

                    case R.id.Nav_catatan:
                        Intent intent;
                        intent = new Intent(Homepage.this, tawal_note.class);
                        startActivity(intent);
                        break;
                    case R.id.Nav_Mpengertian:
                        Intent MP;
                        MP = new Intent(Homepage.this, maretipengertian.class);
                        startActivity(MP);
                        break;
                    case R.id.Nav_MFull:
                        Intent MT;
                        MT = new Intent(Homepage.this, materiFull.class);
                        startActivity(MT);
                        break;
                    case R.id.Nav_Mpartilly:
                        Intent Mp;
                        Mp = new Intent(Homepage.this, materipartially.class);
                        startActivity(Mp);
                        break;
                    case R.id.Nav_Mtransitive:
                        Intent MF;
                        MF = new Intent(Homepage.this, materitransitive.class);
                        startActivity(MF);
                        break;
                    case R.id.Nav_Cpengertian:
                        Intent CP;
                        CP = new Intent(Homepage.this, contohpengertian.class);
                        startActivity(CP);
                        break;
                    case R.id.Nav_CFull:
                        Intent cf;
                        cf = new Intent(Homepage.this, contohfull.class);
                        startActivity(cf);
                        break;
                    case R.id.Nav_Cpartilly:
                        Intent co;
                        co= new Intent(Homepage.this, contohpartially.class);
                        startActivity(co);
                        break;
                    case R.id.Nav_Ctransitive:
                        Intent ct;
                        ct = new Intent(Homepage.this, contohtransitive.class);
                        startActivity(ct);
                        break;
                    default:drawer.closeDrawer(0);
                        return true;
                }

                return true;
            }
        });
        Button Mpengetian= findViewById(R.id.matPengertian);
        Button MFull= findViewById(R.id.MatFull);
        Button MPartially= findViewById(R.id.MatPartially);
        Button MTransitive= findViewById(R.id.matTrans);
        Button Cpengetian= findViewById(R.id.ConPengertian);
        Button CFull= findViewById(R.id.conFull);
        Button CPartially= findViewById(R.id.ConPartially);
        Button CTransitive= findViewById(R.id.conTransitive);
        //Button Latihan= findViewById(R.id.TLatihan);


        Mpengetian.setOnClickListener( new View.OnClickListener(){
            public void onClick(View v) {
                Intent MP;
                MP = new Intent(Homepage.this, maretipengertian.class);
                startActivity(MP);
            }
        });
        MFull.setOnClickListener( new View.OnClickListener(){
            public void onClick(View v) {
                Intent MT;
                MT = new Intent(Homepage.this, materiFull.class);
                startActivity(MT);
        }});
        MPartially.setOnClickListener( new View.OnClickListener(){
            public void onClick(View v) {
                Intent Mp;
                Mp = new Intent(Homepage.this, materipartially.class);
                startActivity(Mp);
        }});
        MTransitive.setOnClickListener( new View.OnClickListener(){
            public void onClick(View v) {
                Intent MF;
                MF = new Intent(Homepage.this, materitransitive.class);
                startActivity(MF);
        }});
        Cpengetian.setOnClickListener( new View.OnClickListener(){
            public void onClick(View v) {
                Intent CP;
                CP = new Intent(Homepage.this, contohpengertian.class);
                startActivity(CP);
        }});
        CFull.setOnClickListener( new View.OnClickListener(){
            public void onClick(View v) {
                Intent cf;
                cf = new Intent(Homepage.this, contohfull.class);
                startActivity(cf);
        }});
        CPartially.setOnClickListener( new View.OnClickListener(){
            public void onClick(View v) {
                Intent cp;
                cp= new Intent(Homepage.this, contohpartially.class);
                startActivity(cp);
        }});
        CTransitive.setOnClickListener( new View.OnClickListener()

            {
                public void onClick (View v){
                    Intent ct;
                    ct = new Intent(Homepage.this, contohtransitive.class);
                    startActivity(ct);
            }
            });
        //Latihan.setOnClickListener((View.OnClickListener) this);
        }


        @Override
        public boolean onOptionsItemSelected(MenuItem menuitem) {
        DrawerLayout drawer = findViewById(R.id.Drawer);
        switch (menuitem.getItemId())
        {
            case android.R.id.home:
                drawer.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(menuitem);
    }


}
