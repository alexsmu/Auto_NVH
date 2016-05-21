package app.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class TabFragment2 extends Fragment {
    View mMain = null;
    private ToggleButton toggleRealTime, togglePlayBack;
    private TextView textTitle;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mMain = inflater.inflate(R.layout.tab_fragment_2, container, false);
        addListenerToToggleButtons();
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
