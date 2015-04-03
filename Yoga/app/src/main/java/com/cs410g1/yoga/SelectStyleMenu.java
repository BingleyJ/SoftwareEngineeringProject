package com.cs410g1.yoga;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class SelectStyleMenu extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_style_menu);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_select_style_menu, menu);
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

    public void yogaButtonClicked(View view)
    {
        Button b = (Button) view;
        Intent YogaStyleIntent;

        YogaStyleIntent = new Intent(this, YogaStyleScreen.class);
        YogaStyleIntent.putExtra("Name", b.getText());

        for(int i = 0; i < Settings.styleBackgrounds.length; i+=2)
        {
            if(Settings.styleBackgrounds[i] == b.getId())
            {
                YogaStyleIntent.putExtra("Background", Settings.styleBackgrounds[i+1]);
                break;
            }
        }

        startActivity(YogaStyleIntent);
    }
}
