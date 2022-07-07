package android.house.implicitintents;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickOpenWebpageButton(View view) {
        openWebPage("https://www.google.com");
    }

    public void onClickOpenMapButton(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        Uri addressUri = Uri.parse("geo:0,0")
                .buildUpon()
                .appendQueryParameter("q", "метро Полежаевская").build();

        intent.setData(addressUri);

        if(intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }
    }

    private void openWebPage(String url) {
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}