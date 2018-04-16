package de.pensel.autocomplete;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.LinearLayout;
import android.widget.Toast;



public class AutoComplete extends AppCompatActivity {

    ArrayAdapter<String> a;
    LinearLayout l;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_complete);
        a = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line);
        a.addAll(getResources().getStringArray(R.array.autoComplete));

        l = findViewById(R.id.layout);

        for(int i = 0; i < l.getChildCount()-1; i++ )
        {
            ((AutoCompleteTextView) l.getChildAt(i)).setAdapter(a);
        }

    }

    public void fertig (View view)
    {

        StringBuffer concat = new StringBuffer();
        for(int i = 0; i < l.getChildCount()-1; i++ )
        {
            if(!((AutoCompleteTextView) l.getChildAt(i)).getText().toString().isEmpty())
            {
                concat.append(((AutoCompleteTextView) l.getChildAt(i)).getText().toString() + "\n");
            }
        }
        concat.deleteCharAt(concat.length()-1);
        Toast.makeText(this, concat.toString(), Toast.LENGTH_LONG).show();
    }
}
