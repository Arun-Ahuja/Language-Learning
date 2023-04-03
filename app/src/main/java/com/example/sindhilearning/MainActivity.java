package com.example.sindhilearning;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.sindhilearning.adapters.MyPagerAdapter;
import com.example.sindhilearning.fragments.DashBoardFrag;
import com.example.sindhilearning.fragments.LoginFrag;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

       // setSupportActionBar(toolbar);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.layout, new LoginFrag());
        fragmentTransaction.commit();
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {



        FragmentManager fm = getSupportFragmentManager();

        Log.e("++_++",""+fm.getBackStackEntryCount());
        super.onBackPressed();


//        for(int entry = 0; entry < fm.getBackStackEntryCount(); entry++){
//            Log.i(TAG, "Found fragment: " + fm.getBackStackEntryAt(entry).getId());
//        }
    }


    //    @Override
//    public void onBackPressed() {
//        AlertDialog.Builder builder1 = new AlertDialog.Builder(getApplicationContext());
//        builder1.setMessage("Do you want to close App?");
//        builder1.setCancelable(true);
//
//        builder1.setPositiveButton(
//                "Yes",
//                new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int id) {
//                        onBackPressed();
//                    }
//                });
//
//        builder1.setNegativeButton(
//                "No",
//                new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int id) {
//                        dialog.cancel();
//                    }
//                });
//
//        AlertDialog alert11 = builder1.create();
//        alert11.show();
//    }

    private void moveToDashboard(){

        Fragment myFragment  = new DashBoardFrag();
        FragmentTransaction fragmentTransaction =this.getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.container, myFragment);
        fragmentTransaction.addToBackStack("youfragment");
        fragmentTransaction.commit();
    }
}
