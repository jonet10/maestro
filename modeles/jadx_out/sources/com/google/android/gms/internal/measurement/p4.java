package com.google.android.gms.internal.measurement;

import androidx.collection.ArrayMap;
import java.util.Iterator;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class p4 {

    /* renamed from: a, reason: collision with root package name */
    public static final ArrayMap f2745a = new ArrayMap();

    public static synchronized void a() {
        synchronized (p4.class) {
            ArrayMap arrayMap = f2745a;
            Iterator it = arrayMap.values().iterator();
            if (it.hasNext()) {
                ((p4) it.next()).getClass();
                throw null;
            }
            arrayMap.clear();
        }
    }
}
