package com.uptodown.util;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class NativeApiKey {

    /* renamed from: a, reason: collision with root package name */
    public static final NativeApiKey f3448a = new NativeApiKey();

    static {
        System.loadLibrary("uptodown-native");
    }

    public final native String getAuthApikey();
}
