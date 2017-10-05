package com.gfi.appcommercial.activity;


import android.content.Intent;
import android.database.MatrixCursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.Button;

import com.gfi.appcommercial.R;
import com.gfi.appcommercial.dao.NeedDAO;
import com.gfi.appcommercial.model.Need;

import java.util.Date;
import java.util.List;

public class ListActivity extends AppCompatActivity {
    private ListView mListView;
    Spinner spinner;
    private final String EXTRA_MOD = "0";
    private final String EXTRA_TITLE = "title";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        //Spinner initialisation
        spinner = (Spinner) findViewById(R.id.spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.tri, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the ListActivity of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {


            public void onItemSelected(AdapterView<?> parent, View view,

                                       int position, long id) {
                final String itemSelect = spinner.getSelectedItem().toString();
                // action a faire ici, position represente la position de l’element selectionne

            }
            public void onNothingSelected(AdapterView<?> parent) {
                //TODOAuto-generatedmethodstub
            }

        });

        NeedDAO dao = NeedDAO.getInstance();
        final List<Need> needs = dao.getAll();

        // Définition des colonnes
        // NB : SimpleCursorAdapter a besoin obligatoirement d'un ID nommé "_id"
        String[] columns = new String[]{"_id", "client", "title", "date", "status"};

        // Définition des données du tableau
        // les lignes ci-dessous ont pour seul but de simuler
        // un objet de type Cursor pour le passer au SimpleCursorAdapter.
        // Si vos données sont issues d'une base SQLite,
        // utilisez votre "cursor" au lieu du "matrixCursor"
        final MatrixCursor matrixCursor = new MatrixCursor(columns);
        startManagingCursor(matrixCursor);

        // on prendra les données des colonnes 1 a 4
        String[] from = new String[]{"client", "title", "date", "status"};

        // ...pour les placer dans les TextView définis dans "row_item.xml"
        int[] to = new int[]{R.id.textViewCol1, R.id.textViewCol2, R.id.textViewCol3, R.id.textViewCol4};

        int i;
        int j=0;
        int k=0;
        int l=0;

        int gestionOpen[] = new int[needs.size()];
        int gestionWon[]= new int[needs.size()];;
        int gestionLost[]= new int[needs.size()];;



        //for i=0 i<length i++
        for(i=0;i<needs.size();i++){
            if(needs.get(i).getStatus().equals("Open")){
                gestionOpen[j]=i;
                j++;
            }
            if(needs.get(i).getStatus().equals("Won")){
                gestionWon[k]=i;
                k++;
            }
            if(needs.get(i).getStatus().equals("Lost")){
                gestionLost[l]=i;
                l++;
            }


        }

        //tri open

        for (i=0;i<j;i++){
            matrixCursor.addRow(new Object[]{1 + i, needs.get(gestionOpen[i]).getClient(), needs.get(gestionOpen[i]).getTitle(), needs.get(gestionOpen[i]).getDate(), needs.get(gestionOpen[i]).getStatus()});
        }
        int b=i;
        for (i=0;i<k;i++){
            matrixCursor.addRow(new Object[]{1 + b, needs.get(gestionWon[i]).getClient(), needs.get(gestionWon[i]).getTitle(), needs.get(gestionWon[i]).getDate(), needs.get(gestionWon[i]).getStatus()});
        }
        int c=i;
        for (i=0;i<l;i++){
            matrixCursor.addRow(new Object[]{1 + c, needs.get(gestionLost[i]).getClient(), needs.get(gestionLost[i]).getTitle(), needs.get(gestionLost[i]).getDate(), needs.get(gestionLost[i]).getStatus()});
        }

        // création de l'objet SimpleCursorAdapter...
        SimpleCursorAdapter curserAdapter = new SimpleCursorAdapter(this, R.layout.row_item, matrixCursor, from, to, 0);

        // ...qui va remplir l'objet ListView
        ListView lv = (ListView) findViewById(R.id.listView);
        lv.setAdapter(curserAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView,View view, int position, long id) {
                matrixCursor.moveToPosition(position);

                String title = matrixCursor.getString(2);// get title
                Intent intent = new Intent(ListActivity.this, FicheBesoinActivity.class);
                intent.putExtra(EXTRA_MOD, "mod");
                intent.putExtra(EXTRA_TITLE, title) ;
                startActivity(intent);

            }
        });
        final Button loginButton = (Button) findViewById(R.id.button);

         loginButton.setOnClickListener(new View.OnClickListener() {

             @Override
             public void onClick(View v) {
                 Intent intent = new Intent(ListActivity.this, FicheBesoinActivity.class);
                 intent.putExtra(EXTRA_MOD, "add");

                 startActivity(intent);
             }
         });


    }

    public int compare(Date d1, Date d2) {
        int result =  d1.compareTo(d2);
        return result;
    }


}
