package t.cmsc434.iseefridgetablet;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class NotesFragment extends Fragment {

    GeneralData generalData = GeneralData.getSingleInstance();
    private static final String TAG = "NotesFragment";

    ListView listAlert;
    ListView listNotes;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notes, container, false);
        getActivity().setTitle("Notes");


        //TO DO

        listAlert = view.findViewById(R.id.list_alert_notes);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_expandable_list_item_1, generalData.alerts);
        listAlert.setAdapter(adapter1);


        listNotes = view.findViewById(R.id.list_notes_notes);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_expandable_list_item_1, generalData.notes);
        listNotes.setAdapter(adapter2);

        FloatingActionButton fab = view.findViewById(R.id.fab_notes);

        fab.setOnClickListener(new View.OnClickListener() {
            FragmentTransaction fr = getFragmentManager().beginTransaction();
            @Override
            public void onClick(View view) {
                fr.replace(R.id.fragment_container, new AddNoteFragment()).addToBackStack(TAG).commit();

            }
        });


        //Click for Alerts
        listAlert.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long l) {
                generalData.currentNoteLocation = i;
                generalData.currentNote = generalData.alerts.get(i);
                generalData.alertOrNote = 0;

                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_container, new DisplayNoteFragment()).addToBackStack(TAG).commit();



                return;
            }
        });

        listNotes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long l) {
                generalData.currentNoteLocation = i;
                generalData.currentNote = generalData.notes.get(i);
                generalData.alertOrNote = 1;

                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_container, new DisplayNoteFragment()).addToBackStack(TAG).commit();



                return;
            }
        });





        return view;
    }

}
