package app.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListPopupWindow;
import android.widget.AdapterView;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class SharedData {
    private static SharedPreferences prefs = null;
    private static SharedPreferences.Editor editor = null;
    private Set<String> defaultRatios = new HashSet<>();
    private static Set<String> ratio_names = null;
    private static Set<String> disabled_ratio_set = new HashSet<>();
    private static String[] disabled_ratios = null;
    private static HashMap<String, Boolean> checkBoxes = new HashMap<>();
    private static HashMap<String, Float> ratios = new HashMap<>();
    public static Context mContext = null;
    public static ListPopupWindow dropdown = null;

    public SharedData(Context context) {
        mContext = context;
        prefs = mContext.getSharedPreferences(mContext.getString(R.string.preference_file), Context.MODE_PRIVATE);
        editor = prefs.edit();
        checkBoxes.put("vibration", prefs.getBoolean("c_vibration", true));
        checkBoxes.put("noise", prefs.getBoolean("c_noise", false));
        defaultRatios.add("Differential gear ratio");
        defaultRatios.add("Crankshaft pulley diameter");
        defaultRatios.add("Power steering pulley diameter");
        defaultRatios.add("Tire size");
        ratio_names = prefs.getStringSet("ratios", defaultRatios);
        for (String s : ratio_names) {
            ratios.put(s, prefs.getFloat("r_" + s, 1));
            checkBoxes.put(s, prefs.getBoolean("c_" + s, false));
            if (!checkBoxes.get(s))
                disabled_ratio_set.add(s);
        }
        dropdown = new ListPopupWindow(mContext);
        disabled_ratios = disabled_ratio_set.toArray(new String[disabled_ratio_set.size()]);
        dropdown.setAdapter(new ArrayAdapter<>(mContext, R.layout.ratios_dropdown, disabled_ratios));
        dropdown.setOnItemClickListener(selectRatio);
    }

    public static boolean getBool(String name, boolean def_val){
        if (checkBoxes.containsKey(name))
            return checkBoxes.get(name);
        else
            return def_val;
    }

    public static void putBool(String name, boolean val) {
        editor.putBoolean("c_" + name, val);
        editor.commit();
    }

    public static float getRatioVal(String name) {
        if (ratios.containsKey(name))
            return ratios.get(name);
        else
            return 1;
    }

    public static boolean isRatioEN(String name) {
        return getBool(name, false);
    }

    public static void putRatio(String name, float val, boolean EN) {
        ratios.put(name, val);
        checkBoxes.put(name, EN);
        ratio_names.add(name);
        editor.putFloat("r_" + name, val);
        editor.putBoolean("c_" + name, EN);
        editor.putStringSet("ratios", ratio_names);
        editor.commit();
    }

    public static boolean definedCheckBox(String name) {
        return checkBoxes.containsKey(name);
    }

    public static void setCheckBox(String name, boolean val) {
        checkBoxes.put(name, val);
        putBool(name,val);
    }

    public static void setFirstRun(boolean val) {
        putBool("firstrun", val);
    }

    public static boolean isFirstRun() {
        return prefs.getBoolean("firstrun", false);
    }

    public static AdapterView.OnItemClickListener selectRatio = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            String name = disabled_ratios[position];
            float val = getRatioVal(name);
            boolean EN = isRatioEN(name);
            // MISSING: change corresponding editText & checkBox values
            dropdown.dismiss();
        }
    };

}
