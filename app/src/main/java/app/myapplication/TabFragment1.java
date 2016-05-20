package app.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TabFragment1 extends Fragment {
    View mMain;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mMain = inflater.inflate(R.layout.tab_fragment_1, container, false);
        initList();
        ListView lv = (ListView) mMain.findViewById(R.id.EnterDeviceInfo);



        // This is a simple adapter that accepts as parameter
        // Context
        // Data list
        // The row layout that is used during the row creation
        // The keys used to retrieve the data
        // The View id used to show the data. The key number and the view id must match
        SimpleAdapter simpleAdpt = new SimpleAdapter(getActivity(), deviceList, android.R.layout.simple_list_item_1, new String[] {"planet"}, new int[] {android.R.id.text1});
        lv.setAdapter(simpleAdpt);
        return mMain;
    }

    // The data to show
    List<Map<String, Double>> deviceList = new ArrayList<>();

    private void initList() {
        // We populate the planets

        deviceList.add(createDevice("Crankshaft", 1.0));
        deviceList.add(createDevice("A/C", 2.5));

    }

    private HashMap<String, Double> createDevice(String name, Double value) {
        HashMap<String, Double> planet = new HashMap<>();
        planet.put(name, value);

        return planet;
    }


    @Override
    public void onPause() {
        super.onPause();

    }

    @Override
    public void onResume() {
        super.onResume();

    }
}
