package com.google.android.gms.internal.measurement;

import android.net.Uri;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class y3 {

    /* renamed from: a, reason: collision with root package name */
    public static final Uri f2909a = Uri.parse("content://com.google.android.gsf.gservices");

    /* renamed from: b, reason: collision with root package name */
    public static final Pattern f2910b;

    /* renamed from: c, reason: collision with root package name */
    public static final Pattern f2911c;

    static {
        Uri.parse("content://com.google.android.gsf.gservices/prefix");
        f2910b = Pattern.compile("^(1|true|t|on|yes|y)$", 2);
        f2911c = Pattern.compile("^(0|false|f|off|no|n)$", 2);
    }
}
