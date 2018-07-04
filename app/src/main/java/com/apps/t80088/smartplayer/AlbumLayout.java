package com.apps.t80088.smartplayer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;

import java.util.ArrayList;

public class AlbumLayout extends TableLayout {
    private Context context;

    public AlbumLayout(Context context) {
        super(context);
        this.context = context;
    }

    public AlbumLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }
    public void addAlbums(ArrayList<String> albums){
        for(int i=0;i<albums.size();i+=2){
            // 2 albums per row, so do 2 at a time
            TableRow row = new TableRow(context);
            row.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));

            ImageButton leftAlbum = new ImageButton(context);
            leftAlbum.setImageResource(R.drawable.ic_jtgsafetravels);
            leftAlbum.setScaleType(ImageView.ScaleType.FIT_CENTER);
            leftAlbum.setLayoutDirection(LAYOUT_DIRECTION_RTL);

            ImageButton rightAlbum = new ImageButton(getContext());
            rightAlbum.setImageResource(R.drawable.ic_album);       // To-Do: In final version replace this with album art
            rightAlbum.setScaleType(ImageView.ScaleType.FIT_CENTER);

            row.addView(leftAlbum, (new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, 500)));
            row.addView(rightAlbum, (new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, 500)));

            this.addView(row, i%2);
        }
    }
}
