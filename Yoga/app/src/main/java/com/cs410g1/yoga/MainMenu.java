package com.cs410g1.yoga;

import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Button;


public class MainMenu extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        CheckBox check = (CheckBox) findViewById(R.id.TOS_check);

        if(check.isChecked())
        {
            enableButtons();
        }

        disableButtons();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_menu, menu);
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

    //Called when the "I agree" button of the TOS Dialog is pressed

    public void doPositiveClick() {

        Settings.TOSAgreed = true;

        CheckBox check = (CheckBox)findViewById(R.id.TOS_check);

        check.setChecked(true);

        enableButtons();
    }

    //Called when the "Cancel" button of the TOS Dialog is pressed

    public void doNegativeClick() {

        CheckBox check = (CheckBox)findViewById(R.id.TOS_check);

        check.setChecked(false);

        disableButtons();
    }

    public void TOSBoxClicked(View view) {

        CheckBox check = (CheckBox) view;
        if(check.isChecked())
        {
            check.setChecked(false);
            DialogFragment dialog = TOSDialogFragment.newInstance(R.string.TOS_title);
            dialog.show(getSupportFragmentManager(), "TOSDialog");
        }
        else
        {
            disableButtons();
        }
    }

    //Connecting buttons to other activities

    public void settingsButtonClicked(View view)
    {
        Intent settingsIntent = new Intent(this, SettingsMenu.class);
        startActivity(settingsIntent);
    }

    public void selectAStyleButtonClicked(View view)
    {
        Intent selectAStyleIntent = new Intent(this, SelectStyleMenu.class);
        startActivity(selectAStyleIntent);
    }

    //Simple function for disabling buttons from TOS checkbox

    public void disableButtons()
    {
        Button disableButton = (Button)findViewById(R.id.select_style_button);
        disableButton.setAlpha(.5f);
        disableButton.setClickable(false);

        disableButton = (Button)findViewById(R.id.custom_workout_button);
        disableButton.setAlpha(.5f);
        disableButton.setClickable(false);

        disableButton = (Button)findViewById(R.id.settings_button);
        disableButton.setAlpha(.5f);
        disableButton.setClickable(false);
    }

    //Simple function for enabling buttons from TOS checkbox

    public void enableButtons()
    {
        Button disableButton = (Button)findViewById(R.id.select_style_button);
        disableButton.setAlpha(1.0f);
        disableButton.setClickable(true);

        disableButton = (Button)findViewById(R.id.custom_workout_button);
        disableButton.setAlpha(1.0f);
        disableButton.setClickable(true);

        disableButton = (Button)findViewById(R.id.settings_button);
        disableButton.setAlpha(1.0f);
        disableButton.setClickable(true);
    }

}
