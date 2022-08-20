package com.academia.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    TextView txt_content_menu;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_content_menu = findViewById(R.id.context_menu);
        registerForContextMenu(txt_content_menu);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.setHeaderTitle("Choose an option");

        menu.add(0, v.getId(), 0, "Options Menu");
        menu.add(0, v.getId(), 1, "Context Menu");
        menu.add(0, v.getId(), 2, "PopUp Menu");
    }

    // Android Options Menu

    @Override
    public boolean onCreatePanelMenu(int featureId, @NonNull Menu menu)
    {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        int itemId = item.getItemId();

        if(itemId == R.id.home)
        {
            Toast.makeText(getApplicationContext(), "Home", Toast.LENGTH_LONG).show();
            return true;
        }
        else if(itemId == R.id.about)
        {
            Toast.makeText(getApplicationContext(), "About", Toast.LENGTH_LONG).show();
            return true;
        }
        else if(itemId == R.id.exit)
        {
            Toast.makeText(getApplicationContext(), "Exit", Toast.LENGTH_LONG).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}