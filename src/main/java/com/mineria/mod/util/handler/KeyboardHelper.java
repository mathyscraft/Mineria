package com.mineria.mod.util.handler;

import org.lwjgl.input.Keyboard;

public class KeyboardHelper
{
    public static boolean isShiftKeyDown()
    {
        return Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT);
    }
}
