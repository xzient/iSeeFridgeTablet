package t.cmsc434.iseefridgetablet;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class AddNoteFragment extends Fragment {

    GeneralData generalData = GeneralData.getSingleInstance();
    private static final String TAG = "AddNoteFragment";

    String[] hourSpinnerList = new String[] {
            "12pm","1am", "2am", "3am", "4am", "5am","6am","7am","8am","9am","10am","11am","12pm",
            "1pm", "2pm", "3pm", "4pm", "5pm","6pm","7pm","8pm","9pm","10pm","11pm",
    };

    String[] minuteSpinnerList = new String[] {
            "0","1","2","3","4","5","6","7","8","9"
            ,"10","11","12","13","14","15","16","17","18","19"
            ,"20","21","22","23","24","25","26","27","28","29"
            ,"30","31","32","33","34","35","36","37","38","39"
            ,"40","41","42","43","44","45","46","47","48","49"
            ,"50","51","52","53","54","55","56","57","58","59"};



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_add_note, container, false);
        getActivity().setTitle( getString(R.string.nav_notes));
        //TO DO



        Spinner hourSpinner = view.findViewById(R.id.hour_add_notes);
        Spinner minuteSpinner = view.findViewById(R.id.minute_add_notes);

        Button button = view.findViewById(R.id.add_button_add_notes);
        final EditText message = view.findViewById(R.id.message_add_notes);

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, hourSpinnerList);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, minuteSpinnerList);
        hourSpinner.setAdapter(adapter1);
        minuteSpinner.setAdapter(adapter2);


        button.setOnClickListener(new View.OnClickListener() {
            FragmentManager fr = getFragmentManager();//.beginTransaction();
            @Override
            public void onClick(View view) {

                //Add note to front
                generalData.notes.add(0, message.getText().toString());
                Toast.makeText(getActivity(), "Note added!", Toast.LENGTH_SHORT).show();


                fr.popBackStack();
                //fr.replace(R.id.fragment_container, new HomeFragment()).addToBackStack(TAG).commit();

            }
        });




        return view;
    }
}
