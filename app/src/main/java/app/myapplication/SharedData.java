package app.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;

import java.util.HashMap;
import java.util.Set;

public class SharedData {
    private static SharedPreferences prefs;
    private static SharedPreferences.Editor editor;
    private Set<String> defaultRatios;
    private static Set<String> ratios;
    private static HashMap<String, Boolean> checkBoxes = new HashMap<String, Boolean>();


    public SharedData(Context context) {
        prefs = context.getSharedPreferences(context.getString(R.string.preference_file), Context.MODE_PRIVATE);
        editor = prefs.edit();
        checkBoxes.put("vibration", prefs.getBoolean("vibration", true));
        checkBoxes.put("noise", prefs.getBoolean("noise", true));
        defaultRatios.add("Differential gear ratio");
        defaultRatios.add("Crankshaft pulley diameter");
        defaultRatios.add("Power steering pulley diameter");
        defaultRatios.add("Tire size");
        ratios = prefs.getStringSet("ratios", defaultRatios);

    }

    public boolean getBool(String name, boolean def_val){
        if (checkBoxes.containsKey(name))
            return checkBoxes.get(name);
        else
            return def_val;
    }

    public static void putBool(String name, boolean val) {
        editor.putBoolean(name, val);
        editor.commit();
    }

    public boolean definedCheckBox(String name) {
        return checkBoxes.containsKey(name);
    }

    public static void setCheckBox(String name, boolean val) {
        checkBoxes.put(name, val);
        putBool(name,val);
    }

    public void setFirstRun(boolean val) {
        putBool("firstrun", false);
    }

    public boolean isFirstRun() {
        return prefs.getBoolean("firstrun", false);
    }

    public static void checkBoxListener(int id) {

    }

    private static View.OnClickListener checkVibration = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    };

}
