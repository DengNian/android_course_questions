package com.college.quiz1_question;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private final String LOG_TAG="MainActivity";
    // EditText view for the website URI
    private EditText mWebsiteEditText;
    // EditText view for the location URI
    private EditText mLocationEditText;
    // EditText view for the share text
    private EditText mShareTextEditText;
    //EditText for Dial action
    private EditText mDialEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWebsiteEditText = findViewById(R.id.website_edittext);
        mLocationEditText = findViewById(R.id.location_editext);
        mShareTextEditText = findViewById(R.id.share_edittext);
        mDialEditText = findViewById(R.id.phone_edittext);

    }

    // TODO
    /**
     * Handles the onClick for the "Open Website" button.  Gets the URI
     * from the edit text and sends an implicit intent for that URL.
     *
     * @param view The view (Button) that was clicked.
     */
    public void openWebsite(View view) {
        String url=mWebsiteEditText.getText().toString();
        Intent urlIntent=new Intent(Intent.ACTION_VIEW);
        urlIntent.setData(Uri.parse(url));
        startActivity(urlIntent);
    }

    // TODO
    /**
     * Handles the onClick for the "Open Location" button.  Gets the location
     * text from the edit text and sends an implicit intent for that location.
     *
     * The location text can be any searchable geographic location.
     *
     * @param view The view (Button) that was clicked.
     */
    public void openLocation(View view) {
        String location=mLocationEditText.getText().toString();
        Uri gmmIntentUri=Uri.parse("geo:0,0?q="+location);
        Intent mapIntent=new Intent(Intent.ACTION_VIEW,gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }

    // TODO
    /**
     * Handles the onClick for the "Share This Text" button.  The
     * implicit intent here is created by the  {@link ShareCompat.IntentBuilder}
     * class.  An app chooser appears with the available options for sharing.
     *
     * ShareCompat.IntentBuilder is from the v4 Support Library.
     *
     * @param view The view (Button) that was clicked.
     */
    public void shareText(View view) {
        //ref:https://stackoverflow.com/questions/9948373/android-share-plain-text-using-intent-to-all-messaging-apps
        String shareText=mShareTextEditText.getText().toString();
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT,shareText);
        startActivity(Intent.createChooser(shareIntent,"Share via"));
    }

    // TODO
    /**
     * Handles the onClick for the "Dial" button.
     *
     * @param view The view (Button) that was clicked.
     */
    public void dial(View view) {
        String phoneNumber=mDialEditText.getText().toString() ;
        Intent callIntent = new Intent(Intent.ACTION_DIAL);
        callIntent.setData(Uri.parse("tel:"+phoneNumber));
        startActivity(callIntent);
    }

    // TODO
    /**
     * Handles the onClick for the "View Contacts" button.
     *
     * @param view The view (Button) that was clicked.
     */
    public void viewContact(View view) {
        Uri uri = Uri.parse("content://contacts/people/");
        Intent intent=new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

}