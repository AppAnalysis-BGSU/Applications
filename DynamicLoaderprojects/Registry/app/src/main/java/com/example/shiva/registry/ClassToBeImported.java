package com.example.shiva.registry;

import android.util.Log;

/**
 * Created by Shiva on 3/5/2018.
 */

public class ClassToBeImported {

    public static ClassLoader method(){
        Log.v("ClassToBeImported", "called method of class " + ClassToBeImported.class.getName());
        return ClassToBeImported.class.getClassLoader();
    }
}
