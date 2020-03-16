package com.SeleniumFuc;

import java.io.IOException;

public class ExeAutoit {

    public void  upDatafile(String exepath){
        try {
            Runtime.getRuntime().exec(exepath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
