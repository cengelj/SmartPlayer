package com.apps.t80088.smartplayer.Artists_Parts;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Outline;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import java.util.Collections;

import com.apps.t80088.smartplayer.R;

import java.util.ArrayList;

public class ArtistLayout extends TableLayout {
    private Context context;

    public ArtistLayout(Context context) {
        super(context);
        this.context = context;
        this.setBackgroundColor(Color.TRANSPARENT);
    }

    public ArtistLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }
    public void addArtists(ArrayList<String> artists){
        Collections.reverse(artists);
        for(int i=0;i<artists.size();i+=2){
            // Do 2 at a time
            TableRow row = new TableRow(context);
            row.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));

            Button leftArtist = new Button(context);
            leftArtist.setBackgroundResource(R.drawable.ic_library);
            leftArtist.setText(artists.get(i));                           //ToDo replace with info grabbed from library.
            leftArtist.setTextAlignment(TEXT_ALIGNMENT_CENTER);
            leftArtist.setLayoutDirection(LAYOUT_DIRECTION_LTR);
            leftArtist.setTextColor(Color.GRAY);
            row.addView(leftArtist, (new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, 500)));

            if(i+1 < artists.size()){               // Ensure no nullpointer exception due to odd number
                Button rightArtist = new Button(getContext());
                rightArtist.setBackgroundResource(R.drawable.ic_album);
                rightArtist.setText(artists.get(i+1));
                rightArtist.setTextAlignment(TEXT_ALIGNMENT_CENTER);
                rightArtist.setTextColor(Color.GRAY);
                rightArtist.setLayoutDirection(LAYOUT_DIRECTION_LTR);
                row.addView(rightArtist, (new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, 500)));
            }

            this.addView(row, i%2);
        }
    }
}
