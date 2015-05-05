package com.saier.sebastian.fragments;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button_fragment_1 = (Button) findViewById(R.id.button_fragment_1);
        Button button_fragment_2 = (Button) findViewById(R.id.button_fragment_2);
        button_fragment_1.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container, new PlaceholderFragment()).commit();
            }
        });
        button_fragment_2.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container, new PlaceholderFragment2()).commit();
            }
        });
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.container, new PlaceholderFragment()).commit();
        }
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            TextView hello = (TextView) rootView.findViewById(R.id.willkommen);
            final EditText eingabe = (EditText) rootView.findViewById(R.id.textinput);
            final TextView ausgabe = (TextView) rootView.findViewById(R.id.textoutput);
            Button absendebutton = (Button) rootView.findViewById(R.id.absendebutton);
            absendebutton.setOnClickListener(new Button.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ausgabe.setText(eingabe.getText());
                }
            });

            return rootView;
        }
    }
    public static class PlaceholderFragment2 extends Fragment {
        String[] monthsArray = {"Digitale Medien", "Computer & Electrical Engineering", "Gesundheit, Sicherheit, Gesellschaft", "Industrial Technologies", "Informatik",
                "Mechanical and Medical Engineering", "Medical and Life Sciences", "Wirtschaft", "Wirtschaftsinformatik", "Wirtschaftsingenieurwesen", "Fakultät11", "Fakultät12", "Fakultät13", "Fakultät14"};
        private ListView monthListView;
        private ArrayAdapter<String> arrayAdapter;
        public PlaceholderFragment2() { }
        /*
        CharSequence text = "Hello toast!";
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();*/

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_two, container, false);
            monthListView = (ListView) rootView.findViewById(R.id.months_list);
            arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, monthsArray);
            monthListView.setAdapter(arrayAdapter);
            return rootView;
        }
    }
}
