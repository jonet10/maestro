package com.google.gson;

import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class c extends d implements Iterable {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f3116a = new ArrayList();

    public final boolean equals(Object obj) {
        if (obj != this) {
            return (obj instanceof c) && ((c) obj).f3116a.equals(this.f3116a);
        }
        return true;
    }

    public final int hashCode() {
        return this.f3116a.hashCode();
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return this.f3116a.iterator();
    }
}
