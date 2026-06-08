package com.google.gson.internal;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class g {

    /* renamed from: a, reason: collision with root package name */
    public static final int f3219a;

    static {
        int i;
        String property = System.getProperty("java.version");
        try {
            String[] split = property.split("[._]", 3);
            i = Integer.parseInt(split[0]);
            if (i == 1 && split.length > 1) {
                i = Integer.parseInt(split[1]);
            }
        } catch (NumberFormatException unused) {
            i = -1;
        }
        if (i == -1) {
            try {
                StringBuilder sb = new StringBuilder();
                for (int i6 = 0; i6 < property.length(); i6++) {
                    char charAt = property.charAt(i6);
                    if (!Character.isDigit(charAt)) {
                        break;
                    }
                    sb.append(charAt);
                }
                i = Integer.parseInt(sb.toString());
            } catch (NumberFormatException unused2) {
                i = -1;
            }
        }
        if (i == -1) {
            i = 6;
        }
        f3219a = i;
    }
}
