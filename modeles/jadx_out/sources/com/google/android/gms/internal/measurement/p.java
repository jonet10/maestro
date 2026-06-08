package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class p implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2742a;

    /* renamed from: b, reason: collision with root package name */
    public int f2743b = 0;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Object f2744l;

    public /* synthetic */ p(Object obj, int i) {
        this.f2742a = i;
        this.f2744l = obj;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.f2742a) {
            case 0:
                if (this.f2743b < ((q) this.f2744l).f2753a.length()) {
                }
                break;
            case 1:
                if (this.f2743b < ((q) this.f2744l).f2753a.length()) {
                }
                break;
            default:
                if (this.f2743b < ((d) this.f2744l).o()) {
                }
                break;
        }
        return false;
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        switch (this.f2742a) {
            case 0:
                String str = ((q) this.f2744l).f2753a;
                int i = this.f2743b;
                if (i < str.length()) {
                    this.f2743b = i + 1;
                    return new q(String.valueOf(i));
                }
                com.google.gson.internal.a.l();
                return null;
            case 1:
                q qVar = (q) this.f2744l;
                String str2 = qVar.f2753a;
                int i6 = this.f2743b;
                if (i6 < str2.length()) {
                    this.f2743b = i6 + 1;
                    return new q(String.valueOf(qVar.f2753a.charAt(i6)));
                }
                com.google.gson.internal.a.l();
                return null;
            default:
                d dVar = (d) this.f2744l;
                int i10 = this.f2743b;
                int o10 = dVar.o();
                int i11 = this.f2743b;
                if (i10 < o10) {
                    this.f2743b = i11 + 1;
                    return dVar.p(i11);
                }
                StringBuilder sb = new StringBuilder(String.valueOf(i11).length() + 21);
                sb.append("Out of bounds index: ");
                sb.append(i11);
                throw new NoSuchElementException(sb.toString());
        }
    }
}
