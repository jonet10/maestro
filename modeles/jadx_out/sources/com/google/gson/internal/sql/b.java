package com.google.gson.internal.sql;

import com.google.gson.j;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final boolean f3261a;

    /* renamed from: b, reason: collision with root package name */
    public static final j f3262b;

    /* renamed from: c, reason: collision with root package name */
    public static final j f3263c;

    /* renamed from: d, reason: collision with root package name */
    public static final j f3264d;

    static {
        boolean z9;
        try {
            Class.forName("java.sql.Date");
            z9 = true;
        } catch (ClassNotFoundException unused) {
            z9 = false;
        }
        f3261a = z9;
        if (z9) {
            f3262b = SqlDateTypeAdapter.f3255b;
            f3263c = SqlTimeTypeAdapter.f3257b;
            f3264d = SqlTimestampTypeAdapter.f3259b;
        } else {
            f3262b = null;
            f3263c = null;
            f3264d = null;
        }
    }
}
