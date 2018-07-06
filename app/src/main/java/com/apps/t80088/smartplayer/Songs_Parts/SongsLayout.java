package com.apps.t80088.smartplayer.Songs_Parts;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.apps.t80088.smartplayer.R;

import java.util.ArrayList;

public class SongsLayout extends TableLayout {
    private Context context;

    public SongsLayout(Context context) {
        super(context);
        this.context = context;
        this.setBackgroundColor(Color.TRANSPARENT);
    }

    public SongsLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }
    public void addSongs(ArrayList<String> songs){
        for(int i=0;i<songs.size();i++){
            TableRow row = new TableRow(context);
            row.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
            TextView[] metadata = {new TextView(context), new TextView(context), new TextView(context), new TextView(context)};
            metadata[0].setText("Song "+i);
            metadata[1].setText("Artist "+i);
            metadata[2].setText("Album "+i);
            metadata[3].setText("Rating "+i);

            for(TextView data:metadata){
                row.addView(data, (new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, 100)));
            }
            this.addView(row, i);
        }
    }
}

