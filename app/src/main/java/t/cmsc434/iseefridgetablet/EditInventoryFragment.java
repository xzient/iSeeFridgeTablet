package t.cmsc434.iseefridgetablet;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

public class EditInventoryFragment extends Fragment {

    private static final String TAG = "EditInventoryFragment";

    GeneralData generalData = GeneralData.getSingleInstance();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_edit_inventory, container, false);


        final ListView inventory = view.findViewById(R.id.inventory_list_edit_inventory);

        InventoryListAdapter adapter = new InventoryListAdapter(getActivity(), R.layout.inventory_adapter_view_layout, generalData.inventoryItems);
        inventory.setAdapter(adapter);


        inventory.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long l) {
               // generalData.c = i;
                //generalData.amountInvItem = generalData.inventoryItems.get(i).getAmount();
                //generalData.notesInvItem= ;

                generalData.currentItemNumBeingEdited = i;
                generalData.currentItemEditing = (InventoryItem) adapterView.getItemAtPosition(i);

                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_container, new DisplayInventoryFragment()).addToBackStack(TAG).commit();




                return;
            }
        });










        return view;
    }
}
