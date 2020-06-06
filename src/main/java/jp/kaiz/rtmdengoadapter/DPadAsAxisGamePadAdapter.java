package jp.kaiz.rtmdengoadapter;

import org.lwjgl.input.Controller;

public class DPadAsAxisGamePadAdapter extends GamePadAdapter {

    @Override
    public boolean isHorn(Controller control) {
        return control.isButtonPressed(3);
    }

    @Override
    public boolean isDoorR(Controller control) {
        return control.isButtonPressed(8);
    }

    @Override
    public boolean isDoorL(Controller control) {
        return control.isButtonPressed(9);
    }

    public int getNotch(Controller control, int lastNotchLevel) {
        int notchLevel;
        int notchAxis = (int) control.getXAxisValue();
        boolean notchButton = control.isButtonPressed(0);
        if (notchAxis == -1) {
            if (notchButton) {
                notchLevel = 3;
            } else {
                if (lastNotchLevel == 3
                        || lastNotchLevel == 4
                        || lastNotchLevel == 5) {
                    notchLevel = 4;
                } else {
                    notchLevel = 0;
                }
            }
        } else if (notchAxis == 1) {
            if (notchButton) {
                notchLevel = 1;
            } else {
                notchLevel = 2;
            }
        } else if (notchAxis == 0) {
            if (notchButton) {
                notchLevel = 5;
            } else {
                notchLevel = lastNotchLevel;
            }
        } else {
            notchLevel = lastNotchLevel;
        }
        return notchLevel;
    }
}
