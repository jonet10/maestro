package com.google.gson.internal;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class n implements CharSequence {

    /* renamed from: a, reason: collision with root package name */
    public char[] f3246a;

    /* renamed from: b, reason: collision with root package name */
    public String f3247b;

    @Override // java.lang.CharSequence
    public final char charAt(int i) {
        return this.f3246a[i];
    }

    @Override // java.lang.CharSequence
    public final int length() {
        return this.f3246a.length;
    }

    @Override // java.lang.CharSequence
    public final CharSequence subSequence(int i, int i6) {
        return new String(this.f3246a, i, i6 - i);
    }

    @Override // java.lang.CharSequence
    public final String toString() {
        if (this.f3247b == null) {
            this.f3247b = new String(this.f3246a);
        }
        return this.f3247b;
    }
}
