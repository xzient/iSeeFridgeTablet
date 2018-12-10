package t.cmsc434.iseefridgetablet;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class AddToInventoryFragment extends Fragment {

    GeneralData generalData = GeneralData.getSingleInstance();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_to_inventory, container, false);
        getActivity().setTitle(Html.fromHtml("<small>"+ getString(R.string.nav_add_to_inventory) +"</small>"));

        final TextView nameTV = view.findViewById(R.id.add_to_inventory_name);
        final Spinner ownerTV = view.findViewById(R.id.add_to_inventory_owner);
        final TextView amountTV = view.findViewById(R.id.add_to_inventory_amount);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_dropdown_item,
                new ArrayList<String>(generalData.users.keySet()));

        ownerTV.setAdapter(adapter);

        BottomNavigationView bottomNav = view.findViewById(R.id.bottom_navigation_add_to_inventory);

        //Listener for bottom navigation bar
        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            FragmentManager fm = getFragmentManager();
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.nav_add_to_inventory_add:

                        InventoryItem newItem = new InventoryItem(nameTV.getText().toString(),
                                amountTV.getText().toString(), ownerTV.getSelectedItem().toString());
                        generalData.inventoryItems.add(newItem);
                        generalData.inventoryListAdapter = new InventoryListAdapter(getActivity(), R.layout.inventory_adapter_view_layout, generalData.inventoryItems);
                        //

                        fm.popBackStack();

                        break;

                    case R.id.nav_add_to_inventory_cancel:
                        fm.popBackStack();
                        break;


                }
                return true;
            }
        });




        return view;
    }
}
