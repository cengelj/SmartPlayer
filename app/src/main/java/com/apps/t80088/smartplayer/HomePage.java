package com.apps.t80088.smartplayer;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.apps.t80088.smartplayer.Album_Parts.AlbumFragment;
import com.apps.t80088.smartplayer.Artists_Parts.ArtistFragment;
import com.apps.t80088.smartplayer.Playlist_Parts.PlaylistsFragment;
import com.apps.t80088.smartplayer.Songs_Parts.SongsFragment;

public class HomePage extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, AlbumFragment.OnFragmentInteractionListener, ArtistFragment.OnFragmentInteractionListener, SongsFragment.OnFragmentInteractionListener, PlaylistsFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home_page, menu);
        return true;
    }

    @Override
    // This handles the top left bar, will likely just have a bar for settings,
    // maybe add cast icon later?
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch(id){
            case R.id.action_settings:
                Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        // Handling navigation bar clicks with a nifty switch
        int id = item.getItemId();
        switch(id){
            case R.id.nav_albums:
                Toast.makeText(this, "Albums", Toast.LENGTH_SHORT).show();
                Fragment albums = new AlbumFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, albums).commit();

                break;
            case R.id.nav_artists:
                Toast.makeText(this, "Artists", Toast.LENGTH_SHORT).show();

                Fragment artists = new ArtistFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, artists).commit();
                break;
            case R.id.nav_playlists:
                Toast.makeText(this, "Playlists", Toast.LENGTH_SHORT).show();
                Fragment playlists = new PlaylistsFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, playlists).commit();
                break;
            case R.id.nav_songs:
                Toast.makeText(this, "Songs", Toast.LENGTH_SHORT).show();
                Fragment songs = new SongsFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, songs).commit();
                break;
            case R.id.nav_report_bug:
                Toast.makeText(this, "Report Bug", Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(this, "This shouldn't be possible", Toast.LENGTH_SHORT).show();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        // Do Something Later On
    }
}
