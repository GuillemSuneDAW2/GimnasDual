package com.example.gimnasdual.fragments;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.gimnasdual.ListViewAdapters.*;
import com.example.gimnasdual.R;
import com.example.gimnasdual.model.FirebaseWorkout.*;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class Rutina2Fragment extends Fragment {

    View rootView;

    final Calendar myCalendar = Calendar.getInstance();

    EditText datePicker;
    ListView lv_exercicis;
    ListView lv_series;
    Spinner sp_exercicis;
    Button btn_addExercici;
    Button btn_removeExercici;
    EditText et_pes;
    EditText et_repes;
    Button btn_addSerie;
    Button btn_updateSerie;
    Button btn_removeSerie;

    String day = "";

    String sociKey;
    Soci soci;
    int diaSeleccionat;

    List<Exercici> exercicis;
    int selectedExercici = -1;

    List<Serie> series;
    int selectedSerie = -1;

    ListExerciciAdapter exerciciAdapter;
    ListSerieAdapter serieAdapter;

    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mWorkoutReference;

    public Rutina2Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_rutina2, container, false);

        FirebaseApp.initializeApp(getContext());
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mWorkoutReference = mFirebaseDatabase.getReference().child("socis");

        Bundle bundle = getArguments();
        if (bundle != null) {
            sociKey = bundle.getString("sociKey");
            soci = (Soci) bundle.getSerializable("soci");
            diaSeleccionat = bundle.getInt("dia");
        }

        LoadViews();
        LoadButtonClickListeners();
        LoadListClickListener();
        LoadDatePicker();
        LoadExercicisSpinner();

        if (diaSeleccionat != -1) {
            datePicker.setText(soci.getDies().get(diaSeleccionat).getData());
            LoadExercicis(diaSeleccionat);
            day = datePicker.getText().toString();
        }

        return rootView;
    }

    private void UpdateSoci() {
        mWorkoutReference.child(sociKey).setValue(soci);
    }

    private void LoadSeries(int pos) {
        if (pos == -1){
            selectedSerie = -1;
            lv_series.setAdapter(null);
        } else {
            series = exercicis.get(pos).getSeries();
            if (series != null) {
                serieAdapter = new ListSerieAdapter(getContext(), android.R.layout.activity_list_item, series);
                lv_series.setAdapter(serieAdapter);
            } else {
                selectedSerie = -1;
                lv_series.setAdapter(null);
            }
        }
    }

    private void LoadExercicis(int dayPicked) {
        if (dayPicked == -1) {
            selectedExercici = -1;
            lv_exercicis.setAdapter(null);
        } else {
            exercicis = soci.getDies().get(dayPicked).getExercicis();
            if (exercicis != null){
                exerciciAdapter = new ListExerciciAdapter(getContext(), android.R.layout.activity_list_item, exercicis);
                lv_exercicis.setAdapter(exerciciAdapter);
            } else {
                selectedExercici = -1;
                lv_exercicis.setAdapter(null);
            }
        }
    }

    private void LoadExercicisSpinner() {
        ArrayAdapter<String> gameKindArray = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.exercicis));
        gameKindArray.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_exercicis.setAdapter(gameKindArray);
    }

    private void LoadListClickListener() {
        lv_exercicis.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedExercici = position;
                LoadSeries(position);
            }
        });

        lv_series.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedSerie = position;
                et_pes.setText(String.valueOf(series.get(position).getPes()));
                et_repes.setText(String.valueOf(series.get(position).getRepeticions()));
            }
        });
    }

    private boolean DateIsSelected(){
        if (day.isEmpty()){
            Toast.makeText(getContext(), "Has de seleccionar un dia", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private boolean ExerciciIsSelected(){
        if (sp_exercicis.getSelectedItem().toString().isEmpty()) {
            Toast.makeText(getContext(), "Has de seleccionar un exercici", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private boolean ExerciciDiaSelected() {
        if (selectedExercici == -1) {
            Toast.makeText(getContext(), "Has de seleccionar un exercici.", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private boolean SerieIsSelected() {
        if (selectedSerie == -1) {
            Toast.makeText(getContext(), "Has de seleccionar un serie per modificar-la/eliminar-la.", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private boolean SerieFieldsOk() {
        if (et_pes.getText().toString().isEmpty() || et_repes.getText().toString().isEmpty()){
            Toast.makeText(getContext(), "S'ha d'indicar un nombre de repeticions i un pes", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private void AddExercici() {
        String exercici = sp_exercicis.getSelectedItem().toString();
        boolean exerciciTrobat = false;

        if (soci.getDies().get(diaSeleccionat).getExercicis() != null) {
            for (Exercici exer : soci.getDies().get(diaSeleccionat).getExercicis()) {
                if (exer.getNom().equals(exercici)) {
                    exerciciTrobat = true;
                    break;
                }
            }
            if (!exerciciTrobat) {
                soci.getDies().get(diaSeleccionat).addExercicis(new Exercici(exercici));
                LoadExercicis(diaSeleccionat);
            }
        } else {
            soci.getDies().get(diaSeleccionat).addExercicis(new Exercici(exercici));
            LoadExercicis(diaSeleccionat);
        }
        UpdateSoci();
    }

    private void DeleteExercici() {
        soci.getDies().get(diaSeleccionat).getExercicis().remove(selectedExercici);
        LoadExercicis(diaSeleccionat);
        selectedExercici = -1;
        LoadSeries(-1);
        UpdateSoci();
    }

    private void AddSerie() {
        int repes = Integer.parseInt(et_repes.getText().toString());
        double pes = Double.parseDouble(et_pes.getText().toString());
        Serie serie = new Serie(repes, pes);

        soci.getDies().get(diaSeleccionat).getExercicis().get(selectedExercici).addSeries(serie);
        LoadSeries(selectedExercici);
        UpdateSoci();
    }

    private void UpdateSerie() {
        double pes = Double.parseDouble(et_pes.getText().toString());
        int repes = Integer.parseInt(et_repes.getText().toString());
        soci.getDies().get(diaSeleccionat).getExercicis().get(selectedExercici).getSeries().get(selectedSerie).setPes(pes);
        soci.getDies().get(diaSeleccionat).getExercicis().get(selectedExercici).getSeries().get(selectedSerie).setRepeticions(repes);
        LoadSeries(selectedExercici);
        UpdateSoci();
    }

    private void DeleteSerie() {
        soci.getDies().get(diaSeleccionat).getExercicis().get(selectedExercici).getSeries().remove(selectedSerie);
        LoadSeries(selectedExercici);
        UpdateSoci();
    }

    private void LoadButtonClickListeners() {
        btn_addExercici.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (DateIsSelected() && ExerciciIsSelected()) {
                    AddExercici();
                }
            }
        });
        btn_removeExercici.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (DateIsSelected() && ExerciciDiaSelected()) {
                    DeleteExercici();
                }
            }
        });
        btn_addSerie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (DateIsSelected() && ExerciciDiaSelected() && SerieFieldsOk()) {
                    AddSerie();
                }
            }
        });
        btn_updateSerie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (DateIsSelected() && ExerciciDiaSelected() && SerieFieldsOk() && SerieIsSelected()) {
                    UpdateSerie();
                }
            }
        });
        btn_removeSerie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (DateIsSelected() && ExerciciDiaSelected() && SerieIsSelected()) {
                    DeleteSerie();
                }
            }
        });
    }

    private void updateLabel() {
        String myFormat = "dd/MM/yyyy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        datePicker.setText(sdf.format(myCalendar.getTime()));
        day = sdf.format(myCalendar.getTime());

        selectedExercici = -1;

        boolean diaTrobat = false;

        if (soci.getDies() != null) {
            int posicioDia = 0;
            for (Dia d : soci.getDies()){
                if (d.getData().equals(day)){
                    LoadExercicis(posicioDia);
                    diaTrobat = true;
                    diaSeleccionat = posicioDia;
                    break;
                }
                posicioDia++;
            }
            if (!diaTrobat) {
                soci.afegirDies(new Dia(day));
                diaSeleccionat = soci.getDies().size() -1;
                LoadExercicis(-1);
                LoadSeries(-1);
            }
        } else {
            soci.afegirDies(new Dia(day));
            diaSeleccionat = soci.getDies().size() -1;
            LoadExercicis(-1);
            LoadSeries(-1);
        }
    }

    private void LoadDatePicker() {
        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

        };

        datePicker.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                new DatePickerDialog(getContext(), date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }

    private void LoadViews() {
        datePicker = rootView.findViewById(R.id.dayPicker);
        sp_exercicis = rootView.findViewById(R.id.sp_exercicis);
        et_pes = rootView.findViewById(R.id.et_pes);
        et_repes = rootView.findViewById(R.id.et_repes);

        btn_addExercici = rootView.findViewById(R.id.btn_addExercici);
        btn_removeExercici = rootView.findViewById(R.id.btn_removeExercici);
        btn_addSerie = rootView.findViewById(R.id.btn_addSerie);
        btn_updateSerie = rootView.findViewById(R.id.btn_updateSerie);
        btn_removeSerie = rootView.findViewById(R.id.btn_removeSerie);

        lv_exercicis = rootView.findViewById(R.id.lv_exercicis);
        lv_series = rootView.findViewById(R.id.lv_series);
    }
}
