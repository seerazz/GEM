package com.animbus.music.activities;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.animbus.music.R;
import com.animbus.music.ThemeManager;
import com.animbus.music.data.SettingsManager;


public class NowPlaying extends AppCompatActivity {

    SettingsManager settings;
    ThemeManager themeManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        settings = new SettingsManager(this);
        themeManager = new ThemeManager(this, ThemeManager.TYPE_TRANSPARENT_APPBAR);

        //Themeing
        setTheme(themeManager.getCurrentTheme());
        setContentView(R.layout.activity_now_playing);
        findViewById(R.id.now_playing_root_view).setBackgroundResource(themeManager.getCurrentBackgroundColor());

        //Toolbar, setting toolbar as Actionbar,Setting the back arrow to be shown, and setting the NavdrawerItemTitle to nothing
        Toolbar toolbar = (Toolbar) findViewById(R.id.now_playing_appbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeAsUpIndicator(settings.getExitIcon());
        } else {
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeAsUpIndicator(settings.getExitIcon());
        }
        toolbar.setTitle("ALBUM_NAME");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_now_playing, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_settings:
                break;
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}