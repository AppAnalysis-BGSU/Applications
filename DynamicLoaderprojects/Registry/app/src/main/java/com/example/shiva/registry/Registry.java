package com.example.shiva.registry;

import java.util.ArrayList;

/**
 * Created by Shiva on 3/5/2018.
 */

public class Registry {
    public static ArrayList<Class<?>> _classes = new ArrayList<Class<?>>();

    static {
        _classes.add(ClassToBeImported.class);
        //more classes here
    }
}
