package com.gfi.appcommercial.activity;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.CheckBox;
import android.view.View;
import android.widget.Toast;

import com.gfi.appcommercial.R;
import com.gfi.appcommercial.dao.CommercialDAO;
import com.gfi.appcommercial.dao.NeedDAO;
import com.gfi.appcommercial.model.Need;

import java.lang.reflect.Array;
import java.security.Timestamp;
import 	java.text.DateFormat;
import java.text.SimpleDateFormat;
import 	java.util.*;

import org.w3c.dom.Text;

/**
 * Created by ASUS on 03/10/2017.
 */

public class FicheBesoinActivity extends AppCompatActivity {
    // les zones de saisie et les variables associées

    private EditText editTextContactName;
    private EditText editTextTitle;
    private EditText editTextFullDescription;
    private EditText editTextKey1;
    private EditText editTextKey2;
    private EditText editTextKey3;
    private EditText editTextDuration;
    private EditText editTextDays;

    private DatePicker datePickerStartDate;

    private EditText editTextLocation;
    private EditText editTextRate;
    private AutoCompleteTextView  autoCompleteTextViewRaisonSocial;
    private EditText editTextConsultant1;
    private EditText editTextConsultant2;
    private EditText editTextConsultant3;
    private EditText editTextConsultant4;
    private EditText editTextConsultant5;

    private String contactName;
    private String title;
    private String fullDescription;
    private String key1;
    private String key2;
    private String key3;
    private String duration;
    private String days;
    private String location;
    private String rate;
    private String raisonSocial;
    private String consultant1;
    private String consultant2;
    private String consultant3;
    private String consultant4;
    private String consultant5;

    // les zones d'affichage de message

    private TextView textViewNomCommercial;
    private TextView textViewDate;
    private TextView textViewFileToUp;
    private TextView textViewStatus;

    // les boutons

    private Button buttonBrowse;
    private Button buttonUpload;
    private Button buttonSaveShare;
    private Button buttonCancel;

    //spinner

    private Spinner spinnerStatus;
    private String status;

    //Date

    private String currentDateTimeString;

    //Nom Commercial


    private final String EXTRA_MOD = "0";

    // Le besoin

    Need unBesoin;

    //Toast

    private Context context;
    private CharSequence text;
    private int time;

    //Liste

    List<String> keys;
    List<String> consultants;

    //Autres

    Date tmp;

    //Layout

    LinearLayout linearRel;
    RelativeLayout relLay;
    ViewGroup.LayoutParams params;

    //EXTRA

    private String nom;
    private String add_mod;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fiche_besoin);

        Intent uneIntent = getIntent();
        nom = CommercialDAO.getInstance().getName();
        add_mod = uneIntent.getStringExtra(EXTRA_MOD);

        if (add_mod.equals("add")){
        // récupération des TextView grâce à leur ID

        currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
        textViewDate = (TextView) findViewById(R.id.textViewDate);
        textViewDate.setText("Date : " + currentDateTimeString );

        textViewFileToUp = (TextView) findViewById(R.id.textViewFileToUp);
        //Le nomdu fichier à mettre ici quand il est up
        textViewNomCommercial = (TextView) findViewById(R.id.textViewNomCommercial);
        textViewNomCommercial.setText(nom);
        textViewStatus = (TextView) findViewById(R.id.textViewStatus);

        //Layout

        linearRel = (LinearLayout) findViewById(R.id.linearRel);
        relLay = (RelativeLayout) findViewById(R.id.relLay);
        params = relLay.getLayoutParams();

        // récupération des EditText grâce à leur ID

        editTextContactName = (EditText) findViewById(R.id.editTextContactName);
        editTextTitle = (EditText) findViewById(R.id.editTextTitle);
        editTextFullDescription = (EditText) findViewById(R.id.editTextFullDescription);
        editTextKey1 = (EditText) findViewById(R.id.editTextKey1);
        editTextKey2 = (EditText) findViewById(R.id.editTextKey2);
        editTextKey3 = (EditText) findViewById(R.id.editTextKey3);
        editTextDuration = (EditText) findViewById(R.id.editTextDuration);
        editTextDays = (EditText) findViewById(R.id.editTextDays);
        editTextLocation = (EditText) findViewById(R.id.editTextLocation);
        editTextRate = (EditText) findViewById(R.id.editTextRate);
        editTextConsultant1 = (EditText) findViewById(R.id.editTextConsultant1);

        editTextConsultant1.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {}

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                if(editTextConsultant1.length() == 1 && editTextConsultant2.getVisibility()== View.INVISIBLE){
                    editTextConsultant2.setVisibility(View.VISIBLE);
                    editTextConsultant2.setTranslationY(editTextConsultant2.getTranslationY()+150);
                    linearRel.setTranslationY(linearRel.getTranslationY()+150);
                    params.height = (params.height + 150);
                    relLay.setLayoutParams(params);}

            }
        });
        editTextConsultant2 = (EditText) findViewById(R.id.editTextConsultant2);
        editTextConsultant2.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {}

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                if(editTextConsultant2.length() == 1 && editTextConsultant3.getVisibility()== View.INVISIBLE){
                    editTextConsultant3.setVisibility(View.VISIBLE);
                    editTextConsultant3.setTranslationY(editTextConsultant2.getTranslationY()+150);
                    linearRel.setTranslationY(linearRel.getTranslationY()+150);
                    params.height = (params.height + 150);
                    relLay.setLayoutParams(params);}


            }
        });
        editTextConsultant3 = (EditText) findViewById(R.id.editTextConsultant3);
        editTextConsultant3.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {}

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                if(editTextConsultant3.length() == 1 && editTextConsultant4.getVisibility()== View.INVISIBLE){
                    editTextConsultant4.setVisibility(View.VISIBLE);
                    editTextConsultant4.setTranslationY(editTextConsultant3.getTranslationY()+150);
                    linearRel.setTranslationY(linearRel.getTranslationY()+150);
                    params.height = (params.height + 150);
                    relLay.setLayoutParams(params);}


            }
        });
        editTextConsultant4 = (EditText) findViewById(R.id.editTextConsultant4);
        editTextConsultant4.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {}

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                if(editTextConsultant4.length() == 1 && editTextConsultant5.getVisibility()== View.INVISIBLE){
                    editTextConsultant5.setVisibility(View.VISIBLE);
                    editTextConsultant5.setTranslationY(editTextConsultant4.getTranslationY()+150);
                    linearRel.setTranslationY(linearRel.getTranslationY()+150);
                    params.height = (params.height + 150);
                    relLay.setLayoutParams(params);}


            }
        });
        editTextConsultant5 = (EditText) findViewById(R.id.editTextConsultant5);
        autoCompleteTextViewRaisonSocial = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextViewRaisonSocial);

        // récupération des boutons grâce à leur ID

        buttonBrowse = (Button) findViewById(R.id.buttonBrowse);
        buttonCancel = (Button) findViewById(R.id.buttonCancel);
        buttonUpload = (Button) findViewById(R.id.buttonUpload);
        buttonSaveShare = (Button) findViewById(R.id.buttonSaveShare);

        //récupération du spinner

        spinnerStatus = (Spinner) findViewById(R.id.spinnerStatus);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.tri, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinnerStatus.setAdapter(adapter);

        //Date picker

        datePickerStartDate = (DatePicker) findViewById(R.id.datePickerStartDate);



        // association d'un écouteur d'évenement au bouton
        buttonCancel.setOnClickListener ( new buttonRetournerClickListener());
        buttonSaveShare.setOnClickListener(new buttonCreerClickListener());
        //buttonUpload & Browse a faire

        //Récupération des listes

        keys = new ArrayList<String>();
        //consultants = new ArrayList<String>();

        }



    }

    /** classe interne pour gérer le clic sur le bouton buttonRetourner. */
    private class buttonRetournerClickListener implements View.OnClickListener {
        public void onClick(View v) {
            finish();
        }
    }



    private class buttonCreerClickListener implements View.OnClickListener {
        public void onClick(View v) {
            //progressBar.setVisibility(View.VISIBLE);


            contactName = editTextContactName.getText().toString();
            title = editTextTitle.getText().toString();
            fullDescription = editTextFullDescription.getText().toString();
            key1 = editTextKey1.getText().toString();
            key2 = editTextKey2.getText().toString();
            key3 = editTextKey3.getText().toString();
            duration = editTextDuration.getText().toString();
            days = editTextDays.getText().toString();
            location = editTextLocation.getText().toString();
            rate = editTextRate.getText().toString();
            consultant1 = editTextConsultant1.getText().toString();
            consultant2 = editTextConsultant2.getText().toString();
            consultant3 = editTextConsultant3.getText().toString();
            consultant4 = editTextConsultant4.getText().toString();
            consultant5 = editTextConsultant5.getText().toString();
            raisonSocial = autoCompleteTextViewRaisonSocial.getText().toString();
            status = spinnerStatus.getSelectedItem().toString();

            int   day  = datePickerStartDate.getDayOfMonth();
            int   month= datePickerStartDate.getMonth();
            int   year = datePickerStartDate.getYear();
            tmp = new Date(day, month, year);

            new TacheCreerBesoin().execute();
        }

    }

    private class buttonModifierClickListener implements View.OnClickListener {
        public void onClick(View v) {
            //progressBar.setVisibility(View.VISIBLE);


            contactName = editTextContactName.getText().toString();
            title = editTextTitle.getText().toString();
            fullDescription = editTextFullDescription.getText().toString();
            key1 = editTextKey1.getText().toString();
            key2 = editTextKey2.getText().toString();
            key3 = editTextKey3.getText().toString();
            duration = editTextDuration.getText().toString();
            days = editTextDays.getText().toString();
            location = editTextLocation.getText().toString();
            rate = editTextRate.getText().toString();
            consultant1 = editTextConsultant1.getText().toString();
            consultant2 = editTextConsultant2.getText().toString();
            consultant3 = editTextConsultant3.getText().toString();
            consultant4 = editTextConsultant4.getText().toString();
            consultant5 = editTextConsultant5.getText().toString();
            raisonSocial = autoCompleteTextViewRaisonSocial.getText().toString();
            status = spinnerStatus.getSelectedItem().toString();

            int   day  = datePickerStartDate.getDayOfMonth();
            int   month= datePickerStartDate.getMonth();
            int   year = datePickerStartDate.getYear();
            tmp = new Date(day, month, year);

            new TacheCreerBesoin().execute();
        }

    }

    // -----------------------------------------------------------------------------------------------------------------------------
    // -------------------------- Tâche asynchrone TacheCreerBesoin -----------------------------
    // -----------------------------------------------------------------------------------------------------------------------------

    // l'appel à un service web peut prendre quelques secondes
    // à partir d'Android 3.0, une requête HTTP doit être effectuée à l'intérieur d'une tâche asynchrone
    // doc sur la classe AsyncTask à l'adresse http://developer.android.com/reference/android/os/AsyncTask.html

    // appel du service web CreerBesoin(post)
    private class TacheCreerBesoin extends AsyncTask<Void, Void, String> {
        protected String doInBackground(Void... params) {
            // cette méthode permet de lancer l'exécution de la tâche longue

            unBesoin = new Need();

            unBesoin.setDate(new Date());
            unBesoin.setContactName(contactName);
            unBesoin.setTitle(title);
            unBesoin.setFullDescription(fullDescription);

            keys.add(key1); keys.add(key2);keys.add(key3);
            unBesoin.setMainKeyFactors(keys);
            unBesoin.addConsultant(consultant1);
            if(!consultant2.isEmpty()){
                unBesoin.addConsultant(consultant2);
                if(!consultant3.isEmpty()){
                    unBesoin.addConsultant(consultant3);
                    if(!consultant4.isEmpty()){
                        unBesoin.addConsultant(consultant4);
                        if(!consultant5.isEmpty()){
                            unBesoin.addConsultant(consultant5);
                        }
                    }
                }
            }

            unBesoin.setDurationMonths(Integer.parseInt(duration));
            unBesoin.setDurationDaysPerWeek(Integer.parseInt(days));
            unBesoin.setStartAtLastest(tmp);
            unBesoin.setLocation(location);
            unBesoin.setRate(Double.parseDouble(rate));
            unBesoin.setClient(raisonSocial);
            unBesoin.setStatus(status);






            Boolean reussite = NeedDAO.getInstance().post(unBesoin);
            if (reussite){
                return "New need added";}
            else
                return "Error add fail";
        }
        protected void onPostExecute(String msg) {

            context = getApplicationContext();
            text = msg;
            time = Toast.LENGTH_LONG;
            Toast.makeText(context, text, time).show();

            //progressBar.setVisibility(View.GONE);
        }
    } // fin tâche asynchrone TacheConsulterReservations
}





