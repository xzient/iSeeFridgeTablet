package t.cmsc434.iseefridgetablet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class InventoryListAdapter extends ArrayAdapter<InventoryItem> {

    private static final String TAG = "InventoryListAdapter";

    private Context mContext;
    int mResource;

    public InventoryListAdapter (Context context, int resource, ArrayList<InventoryItem> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        String name = getItem(position).getName();
        String amount = getItem(position).getAmount();
        String notes = getItem(position).getNotes();

        InventoryItem item = new InventoryItem(name, amount, notes);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        TextView tvName = (TextView) convertView.findViewById(R.id.textView1);
        TextView tvAmount = (TextView) convertView.findViewById(R.id.textView2);
        TextView tvNotes = (TextView) convertView.findViewById(R.id.textView3);

        tvName.setText(name);
        tvAmount.setText(amount);
        tvNotes.setText(notes);

        return convertView;
    }
}
