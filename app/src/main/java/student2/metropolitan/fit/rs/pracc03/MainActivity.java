package student2.metropolitan.fit.rs.pracc03;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String[] items = {"Uno", "Quatro", "Cinco", "Sei"};
    private ListView itemsListView;
    private Button secondActivityButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        populateListView();
        onItemClickListener();
    }

    public void changeActivity(View v) {
        secondActivityButton = (Button)findViewById(R.id.secondActivityButton);
        Intent intentToSwitchActivity = new Intent("student2.metropolitan.fit.rs.pracc03.ImageActivity");
        startActivity(intentToSwitchActivity);
    }

    private void populateListView() {
        itemsListView = (ListView)findViewById(R.id.itemsListView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.single_item, items);

        itemsListView.setAdapter(adapter);
    }

    private void onItemClickListener() {
        itemsListView = (ListView)findViewById(R.id.itemsListView);
        itemsListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View activeView, int position, long id) {
                        TextView singleItem = (TextView) activeView;
                        String message = "Clicked on: " + singleItem.getText().toString() + " on position: " + position;
                        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_action_bar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.settings_id:
                Toast.makeText(MainActivity.this, "Clicked on: " + item.toString(), Toast.LENGTH_LONG).show();
                return true;
            case R.id.wifi_id:
                Toast.makeText(MainActivity.this, "Clicked on: " + item.toString(), Toast.LENGTH_LONG).show();
                return true;
            case R.id.search_id:
                Toast.makeText(MainActivity.this, "Clicked on: " + item.toString(), Toast.LENGTH_LONG).show();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
