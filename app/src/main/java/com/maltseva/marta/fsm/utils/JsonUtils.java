package com.maltseva.marta.fsm.utils;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.maltseva.marta.fsm.model.Action;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Марта on 23.02.2018.
 */

public class JsonUtils {
    private String createStringFromJson(Context context, String filePath) {
        try {
            InputStream is = context.getAssets().open(filePath);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            return new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List<Action> getActionsFromJson(Context context, String filePath) {
        TypeToken<ArrayList<Action>> token = new TypeToken<ArrayList<Action>>() {
        };
        return new Gson().fromJson(createStringFromJson(context, filePath), token.getType());
    }
}
