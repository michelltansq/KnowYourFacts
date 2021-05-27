package com.myapplicationdev.android.knowyourfacts;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.crazyhitty.chdev.ks.rssmanager.RSS;
import com.crazyhitty.chdev.ks.rssmanager.RssReader;

import java.util.List;


public class FragRSS extends Fragment implements RssReader.RssCallback {

    RssReader rssReader;
    TextView tvTitle, tvTitle2;
    WebView description, description2;
    Button btnLoadRSS;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragRSS = inflater.inflate(R.layout.fragment_frag_r_s_s, container, false);

        tvTitle = fragRSS.findViewById(R.id.tvTitle);
        description = fragRSS.findViewById(R.id.description);
        tvTitle2 = fragRSS.findViewById(R.id.tvTitle2);
        description2 = fragRSS.findViewById(R.id.description2);
        btnLoadRSS = fragRSS.findViewById(R.id.btnLoadRSS);

        rssReader = new RssReader( this);

        btnLoadRSS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] url = {"https://www.singstat.gov.sg/rss"};
                rssReader.loadFeeds(url);
            }
        });

        return fragRSS;
    }//end of onCreateView


    //load feeds
    private void loadFeeds(String[] urls) {
        rssReader.loadFeeds(urls);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        rssReader.destroy();
    }

    @Override
    public void rssFeedsLoaded(List<RSS> rssList) {
        RSS currItem = rssList.get(0);

        String title = currItem.getChannel().getItems().get(0).getTitle();
        String desc = currItem.getChannel().getItems().get(0).getDescription();
        tvTitle.setText(title);
        description.loadData(desc, "text/html; charset=utf-8", "utf-8");


        String title2 = currItem.getChannel().getItems().get(1).getTitle();
        String desc2 = currItem.getChannel().getItems().get(1).getDescription();
        tvTitle2.setText(title2);
        description2.loadData(desc2, "text/html; charset=utf-8", "utf-8");
    }//end of rssFeedsLoaded

    @Override
    public void unableToReadRssFeeds(String errorMessage) {
        Toast.makeText(getActivity(), "RSS Loading Failed", Toast.LENGTH_LONG).show();
    }

}//end of class