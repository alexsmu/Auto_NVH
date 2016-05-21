package app.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class TabFragment2 extends Fragment {
    View mMain = null;
    private ToggleButton toggleRealTime, togglePlayBack;
    private TextView textTitle;
    private Spinner fileSpinner;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mMain = inflater.inflate(R.layout.tab_fragment_2, container, false);
        addListenerToToggleButtons();
        /*THE FOLLOWING ITEMS ARE FOR TESTING ONLY*/
        List<String> testFiles = new ArrayList<String>();
        testFiles.add("BlueCar.txt");
        testFiles.add("RedCar.txt");
        testFiles.add("NeonCar.txt");
        testFiles.add("BlackCar.txt");
        /*TESTCODE ENDS HERE*/

        fileSpinner = (Spinner) mMain.findViewById(R.id.fileSpinner);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getActivity().getApplicationContext(), R.layout.file_spinner, testFiles);
       // adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fileSpinner.setAdapter(adapter);
        return mMain;
    }

    void addListenerToToggleButtons() {
        toggleRealTime = (ToggleButton) mMain.findViewById(R.id.toggleRealTime);
        togglePlayBack = (ToggleButton) mMain.findViewById(R.id.togglePlayBack);
        textTitle = (TextView) mMain.findViewById(R.id.textTitle);

        toggleRealTime.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                toggleRealTime.setChecked(true);
                togglePlayBack.setChecked(false);
                Toast.makeText(getActivity().getApplicationContext(), "Real Time Session",
                        Toast.LENGTH_SHORT).show();
                textTitle.setText("Real Time Session");
            }
        });

        togglePlayBack.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                togglePlayBack.setChecked(true);
                toggleRealTime.setChecked(false);
                Toast.makeText(getActivity().getApplicationContext(), "Playback Session",
                        Toast.LENGTH_SHORT).show();
                textTitle.setText("Playback Session");
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();

    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        // Is fragment currently visible ?
        if (this.isVisible()) {
            // Is it becoming invisible?
            if (!isVisibleToUser) {

            }
        }
        else { // Is fragment currently invisible?
            // Is it becoming visible?
            if (isVisibleToUser) {

            }
        }
    }
}
