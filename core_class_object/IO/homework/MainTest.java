package com.kkb.test;

import com.kkb.view.ExpressView;

/**
 * @author Yan Wang
 * @version 1.0
 */
public class MainTest {
    public static void main(String[] args) {
        ExpressView view = new ExpressView();
        while(true){
            if(view.startMenu()==0)
                break;
        }
    }
}
