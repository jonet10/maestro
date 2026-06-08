package l7;

import java.util.Iterator;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class g implements Iterator, e7.a {

    /* renamed from: a, reason: collision with root package name */
    public final String f7166a;

    /* renamed from: b, reason: collision with root package name */
    public int f7167b;

    /* renamed from: l, reason: collision with root package name */
    public int f7168l;

    /* renamed from: m, reason: collision with root package name */
    public int f7169m;

    /* renamed from: n, reason: collision with root package name */
    public int f7170n;

    public g(String str) {
        this.f7166a = str;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i;
        int i6;
        int i10 = this.f7167b;
        if (i10 != 0) {
            return i10 == 1;
        }
        if (this.f7170n < 0) {
            this.f7167b = 2;
            return false;
        }
        String str = this.f7166a;
        int length = str.length();
        int length2 = str.length();
        for (int i11 = this.f7168l; i11 < length2; i11++) {
            char charAt = str.charAt(i11);
            if (charAt == '\n' || charAt == '\r') {
                i = (charAt == '\r' && (i6 = i11 + 1) < str.length() && str.charAt(i6) == '\n') ? 2 : 1;
                length = i11;
                this.f7167b = 1;
                this.f7170n = i;
                this.f7169m = length;
                return true;
            }
        }
        i = -1;
        this.f7167b = 1;
        this.f7170n = i;
        this.f7169m = length;
        return true;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            com.google.gson.internal.a.l();
            return null;
        }
        this.f7167b = 0;
        int i = this.f7169m;
        int i6 = this.f7168l;
        this.f7168l = this.f7170n + i;
        return this.f7166a.subSequence(i6, i).toString();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
