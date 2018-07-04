package com.apps.t80088.smartplayer.Album_Parts;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Outline;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;

import com.apps.t80088.smartplayer.R;

import java.util.ArrayList;
import java.util.Collections;

public class AlbumLayout extends TableLayout {
    private Context context;

    public AlbumLayout(Context context) {
        super(context);
        this.context = context;
        this.setBackgroundColor(Color.TRANSPARENT);
    }

    public AlbumLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }
    public void addAlbums(ArrayList<String> albums){
        Collections.reverse(albums);
        for(int i=0;i<albums.size();i+=2){
            // 2 albums per row, so do 2 at a time
            TableRow row = new TableRow(context);
            row.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));

            ImageButton leftAlbum = new ImageButton(context);
            leftAlbum.setImageResource(R.drawable.ic_jtgsafetravels);
            leftAlbum.setScaleType(ImageView.ScaleType.FIT_CENTER);
            leftAlbum.setLayoutDirection(LAYOUT_DIRECTION_RTL);
            leftAlbum.setBackgroundColor(Color.TRANSPARENT);
            row.addView(leftAlbum, (new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, 500)));

            if(i+1 < albums.size()) {
                ImageButton rightAlbum = new ImageButton(getContext());
                rightAlbum.setImageResource(R.drawable.ic_album);       // To-Do: In final version replace this with album art
                rightAlbum.setScaleType(ImageView.ScaleType.FIT_CENTER);
                rightAlbum.setBackgroundColor(Color.TRANSPARENT);
                row.addView(rightAlbum, (new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, 500)));
            }

            this.addView(row, i%2);
        }
    }
}
