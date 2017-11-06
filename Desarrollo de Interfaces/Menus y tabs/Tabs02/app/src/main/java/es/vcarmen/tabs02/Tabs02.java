package es.vcarmen.tabs02;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;

public class Tabs02 extends FragmentActivity {
    private FragmentTabHost TabHost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabs02);
        TabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        TabHost.setup(this, getSupportFragmentManager(), android.R.id.tabcontent);
        TabHost.addTab(
                TabHost.newTabSpec("tab1").setIndicator("Tab 1", null),
                Fragmento1.class, null);
        TabHost.addTab(
                TabHost.newTabSpec("tab2").setIndicator("Tab 2", null),
                Fragmento2.class, null);
        TabHost.addTab(
                TabHost.newTabSpec("tab3").setIndicator("Tab 3", null),
                Fragmento3.class, null);
    }
}
