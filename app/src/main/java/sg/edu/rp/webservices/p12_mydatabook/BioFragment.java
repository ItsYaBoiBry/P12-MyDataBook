package sg.edu.rp.webservices.p12_mydatabook;


import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class BioFragment extends Fragment {

    //TextView tvBio;
    Button btnEdit;
    ListView lv;
    ArrayList<String> listItems = new ArrayList<String>();
    ArrayAdapter<String> aa;



    public BioFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_bio, container, false);

        //tvBio = (TextView) view.findViewById(R.id.tvBio);
        btnEdit = (Button) view.findViewById(R.id.btnEdit);
        lv = (ListView) view.findViewById(R.id.lv);

//        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
//        String bio = prefs.getString("bio", "");
//        tvBio.setText(bio);

        aa = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, listItems);
        lv.setAdapter(aa);

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater = getActivity().getLayoutInflater();
                final LinearLayout passPhrase = (LinearLayout) inflater.inflate(R.layout.bio, null);

                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("Edit Bio")
                        .setView(passPhrase)
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {

                                EditText etBio = (EditText) passPhrase.findViewById(R.id.etBio);
                                String bio = etBio.getText().toString();
                                //tvBio.setText(bio);

                                listItems.add(bio);
                                aa = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, listItems);
                                lv.setAdapter(aa);

                                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
                                SharedPreferences.Editor prefEdit = prefs.edit();
                                prefEdit.putString("bio", bio);
                                prefEdit.commit();
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                            }
                        });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });

        return view;
    }

}