package sg.edu.rp.c346.id20037535.demodynamiclistviewcolourlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etElement;
    EditText etIndexElement;
    Button btnAdd;
    Button btnRemove;
    Button btnUpdate;
    ListView lvColour;
    ArrayList<String> alColours = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etElement = findViewById(R.id.editTextColour);
        etIndexElement = findViewById(R.id.editTextPosition);
        btnAdd = findViewById(R.id.buttonAddItem);
        btnRemove = findViewById(R.id.buttonRemoveItem);
        btnUpdate = findViewById(R.id.buttonUpdateItem);
        lvColour = findViewById(R.id.listViewColour);

        alColours.add("Red");
        alColours.add("Orange");

        ArrayAdapter aaColour = new ArrayAdapter(this, android.R.layout.simple_list_item_1, alColours);

        lvColour.setAdapter((aaColour));

        btnAdd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String newColour = etElement.getText().toString();
                int pos = Integer.parseInt(etIndexElement.getText().toString());
                alColours.add(pos, newColour);
                aaColour.notifyDataSetChanged();
            }
        });

        btnRemove.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String newColour = etElement.getText().toString();
                int pos = Integer.parseInt(etIndexElement.getText().toString());
                alColours.remove(pos);
                aaColour.notifyDataSetChanged();
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String newColour = etElement.getText().toString();
                int pos = Integer.parseInt(etIndexElement.getText().toString());
                alColours.set(pos, newColour);
                aaColour.notifyDataSetChanged();
            }
        });

        lvColour.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String colour = (String) parent.getItemAtPosition(position);
                Toast toast = Toast.makeText(getApplicationContext(), colour, Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }
}