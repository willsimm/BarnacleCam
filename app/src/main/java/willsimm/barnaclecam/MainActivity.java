package willsimm.barnaclecam;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.afollestad.materialcamera.MaterialCamera;

public class MainActivity extends AppCompatActivity {
    private final static int CAMERA_RQ = 6969;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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



        MaterialCamera xyz;
        xyz = new MaterialCamera(this);
        xyz.countdownSeconds(30f)


                .allowRetry(false)                          // Whether or not 'Retry' is visible during playback
                .autoSubmit(true)                         // Whether or not user is allowed to playback videos after recording. This can affect other things, discussed in the next section.
                        //.saveDir(saveFolder)                       // The folder recorded videos are saved to
                        //.primaryColorAttr(R.attr.colorPrimary)     // The theme color used for the camera, defaults to colorPrimary of Activity in the constructor
                .showPortraitWarning(false)                 // Whether or not a warning is displayed if the user presses record in portrait orientation
                .defaultToFrontFacing(false)               // Whether or not the camera will initially show the front facing camera
                        //.retryExits(false)                         // If true, the 'Retry' button in the playback screen will exit the camera instead of going back to the recorder
                .start(CAMERA_RQ);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
