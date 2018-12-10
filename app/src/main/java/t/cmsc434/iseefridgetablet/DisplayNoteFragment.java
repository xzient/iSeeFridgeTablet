package t.cmsc434.iseefridgetablet;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class DisplayNoteFragment extends Fragment {

    GeneralData generalData = GeneralData.getSingleInstance();


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_display_note, container, false);
        getActivity().setTitle( getString(R.string.nav_notes));

        TextView textView = view.findViewById(R.id.text_display_note);
        textView.setText(generalData.currentNote);

        Button deleteButton = view.findViewById(R.id.delete_display_note);
        Button returnButton = view.findViewById(R.id.return_display_note);

        final FragmentManager fm = getFragmentManager();

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (generalData.alertOrNote == 0) {//Alert
                    generalData.alerts.remove(generalData.currentNoteLocation);
                    fm.popBackStack();
                }
                else {//Note
                    generalData.notes.remove(generalData.currentNoteLocation);
                    fm.popBackStack();
                }

            }
        });

        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fm.popBackStack();
            }
        });








        return view;
    }
}
