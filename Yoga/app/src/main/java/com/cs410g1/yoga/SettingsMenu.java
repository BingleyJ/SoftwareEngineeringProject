package com.cs410g1.yoga;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SeekBar;


public class SettingsMenu extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_menu);

        SeekBar sb = (SeekBar)findViewById(R.id.seekBar);
        sb.setProgress(Settings.masterVolume);
        sb.setOnSeekBarChangeListener(new VolumeBarListener());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_settings_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
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

    private class VolumeBarListener implements SeekBar.OnSeekBarChangeListener
    {
        private String TAG = "VolumeBarListener";
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
        {
            Settings.masterVolume = progress;
            Integer i = Settings.masterVolume;
            Log.d(TAG,i.toString());
        }

        public void onStartTrackingTouch(SeekBar seekBar)
        {}

        public void onStopTrackingTouch(SeekBar seekBar)
        {}
    }
}
