package i7;

import q6.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class c extends x {

    /* renamed from: a, reason: collision with root package name */
    public final int f5698a;

    /* renamed from: b, reason: collision with root package name */
    public final int f5699b;

    /* renamed from: l, reason: collision with root package name */
    public boolean f5700l;

    /* renamed from: m, reason: collision with root package name */
    public int f5701m;

    public c(int i, int i6, int i10) {
        this.f5698a = i10;
        this.f5699b = i6;
        boolean z9 = false;
        if (i10 <= 0 ? i >= i6 : i <= i6) {
            z9 = true;
        }
        this.f5700l = z9;
        this.f5701m = z9 ? i : i6;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f5700l;
    }

    @Override // q6.x
    public final int nextInt() {
        int i = this.f5701m;
        if (i != this.f5699b) {
            this.f5701m = this.f5698a + i;
            return i;
        }
        if (this.f5700l) {
            this.f5700l = false;
            return i;
        }
        com.google.gson.internal.a.l();
        return 0;
    }
}
