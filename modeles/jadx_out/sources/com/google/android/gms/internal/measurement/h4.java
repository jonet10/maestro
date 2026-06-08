package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class h4 extends ContentObserver {
    @Override // android.database.ContentObserver
    public final void onChange(boolean z9) {
        n4.i.incrementAndGet();
    }
}
