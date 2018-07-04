package com.apps.t80088.smartplayer.Playlist_Parts;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.apps.t80088.smartplayer.R;

import java.util.ArrayList;
import java.util.Collections;

public class PlaylistsLayout extends TableLayout {
    private Context context;

    public PlaylistsLayout(Context context) {
        super(context);
        this.context = context;
        this.setBackgroundColor(Color.TRANSPARENT);
    }

    public PlaylistsLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }
    public void addPlaylists(ArrayList<String> playlists){
        for(int i=0;i<playlists.size();i++){
            TableRow row = new TableRow(context);
            row.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
            ImageView image = new ImageView(context);
            image.setImageDrawable(getResources().getDrawable(R.drawable.ic_playlists, getResources().newTheme()));

            TextView text = new TextView(context);
            text.setText(playlists.get(i));         // Todo: Create playlist class and import it here, maybe use earlier code?

            row.addView(image, (new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, 100)));
            row.addView(text, (new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, 100)));

            this.addView(row, i);
        }
    }
}