package t.cmsc434.iseefridgetablet;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class DisplayInventoryFragment extends Fragment {

    GeneralData generalData = GeneralData.getSingleInstance();


    Dialog dialog;

    private static final String TAG = "DisplayInventoryFragmen";

    EditText name, amount;
    Spinner owner;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_display_inventory, container, false);
        getActivity().setTitle( getString(R.string.nav_inventory));

        name = view.findViewById(R.id.fragment_display_edit_text_name);
        amount = view.findViewById(R.id.fragment_display_edit_amount);
        owner = view.findViewById(R.id.fragment_display_spinner_user);

        BottomNavigationView bottomNav = view.findViewById(R.id.bottom_navigation_display_inventory);



        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_dropdown_item,
                new ArrayList<String>(generalData.users.keySet()));

        owner.setAdapter(adapter);


        name.setText(generalData.currentItemEditing.getName());
        amount.setText(generalData.currentItemEditing.getAmount());
        owner.setPrompt(generalData.currentItemEditing.getNotes());


        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentTransaction fr = getFragmentManager().beginTransaction();
                switch (item.getItemId()) {
                    case R.id.nav_dis_inv_done:
                        generalData.inventoryItems.get(generalData.currentInventoryLocation).setAmount(amount.getText().toString());
                        generalData.inventoryItems.get(generalData.currentInventoryLocation).setName(name.getText().toString());
                        generalData.inventoryItems.get(generalData.currentInventoryLocation).setNotes(owner.getSelectedItem().toString());

                        Toast.makeText(getContext(), "The item has been updated!", Toast.LENGTH_SHORT).show();
                        getFragmentManager().popBackStack();
                        getFragmentManager().popBackStack();

                        break;
                    case R.id.nav_dis_inv_cancel:
                        getFragmentManager().popBackStack();
                        getFragmentManager().popBackStack();


                        break;
                    case R.id.nav_dis_inv_delete:
                        dialog = new Dialog(getContext());

                        ShowPopup();

                        break;


                }
                return true;
            }
        });







        return view;
    }

    public void ShowPopup() {
        dialog.setContentView(R.layout.warning_popup);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable((Color.TRANSPARENT)));
        dialog.show();

        TextView yes, no;
        yes = dialog.findViewById(R.id.warning_yes);
        no = dialog.findViewById(R.id.warning_cancel);

        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                generalData.inventoryItems.remove(generalData.currentInventoryLocation);
                Toast.makeText(getContext(), "The item has been removed!", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
                getFragmentManager().popBackStack();
                getFragmentManager().popBackStack();
            }
        });







    }
}
