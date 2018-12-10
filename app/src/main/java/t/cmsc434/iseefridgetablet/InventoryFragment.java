package t.cmsc434.iseefridgetablet;

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
import android.widget.ListView;

public class InventoryFragment extends Fragment {

    private static final String TAG = "InventoryFragment";
    GeneralData generalData = GeneralData.getSingleInstance();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_inventory, container, false);
        getActivity().setTitle( getString(R.string.nav_inventory));

        final ListView inventory = view.findViewById(R.id.inventoryList);

        BottomNavigationView bottomNav = view.findViewById(R.id.bottom_navigation_inventory);

        generalData.inventoryListAdapter = new InventoryListAdapter(getActivity(), R.layout.inventory_adapter_view_layout, generalData.inventoryItems);
        inventory.setAdapter(generalData.inventoryListAdapter);


        //Listener for bottom navigation bar
        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentTransaction fr = getFragmentManager().beginTransaction();
                switch (item.getItemId()) {
                    case R.id.nav_inventory_edit:
                        fr.replace(R.id.fragment_container, new EditInventoryFragment()).addToBackStack(TAG).commit();



                        break;

                    case R.id.nav_inventory_add:
                        fr.replace(R.id.fragment_container, new AddToInventoryFragment()).addToBackStack(TAG).commit();
                        inventory.setAdapter(generalData.inventoryListAdapter);

                        break;

                    case R.id.nav_inventory_meals:
                        fr.replace(R.id.fragment_container, new MealsFragment()).addToBackStack(TAG).commit();

                        break;

                }
                return true;
            }
        });



        return view;
    }
}
