package com.milestns.gladpet.utils;


import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Handler;

import com.milestns.gladpet.R;

public class FragmentUtil {
    public static void replaceFragment(final FragmentManager manager, Fragment fragment,
                                       final boolean addToBackStack, boolean useLeftRightAnimations) {
        final FragmentTransaction fTrans;
        fTrans = manager.beginTransaction();
        fTrans.replace(R.id.container, fragment, fragment.getClass().getSimpleName());
        /*if (useLeftRightAnimations) {
            fTrans.setCustomAnimations(R.animator.enter_from_right, R.animator.exit_to_left);
        } else {
            fTrans.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        }*/
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                if (addToBackStack) {
                    fTrans.addToBackStack(null);
                } else {
                    manager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                }
                fTrans.commitAllowingStateLoss();
            }
        });
    }

    public static void replaceFragment(FragmentManager manager, Fragment fragment, boolean addToBackStack) {
        replaceFragment(manager, fragment, addToBackStack, false);
    }
}