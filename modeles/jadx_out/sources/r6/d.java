package r6;

import java.util.Iterator;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class d implements Iterator, e7.a {

    /* renamed from: a, reason: collision with root package name */
    public final f f8923a;

    /* renamed from: b, reason: collision with root package name */
    public int f8924b;

    /* renamed from: l, reason: collision with root package name */
    public int f8925l;

    /* renamed from: m, reason: collision with root package name */
    public int f8926m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ int f8927n;

    public d(f fVar, int i) {
        this.f8927n = i;
        fVar.getClass();
        this.f8923a = fVar;
        this.f8925l = -1;
        this.f8926m = fVar.f8939q;
        c();
    }

    public final void a() {
        if (this.f8923a.f8939q == this.f8926m) {
            return;
        }
        a3.b.i();
    }

    public final void c() {
        while (true) {
            int i = this.f8924b;
            f fVar = this.f8923a;
            if (i >= fVar.f8937o || fVar.f8934l[i] >= 0) {
                return;
            } else {
                this.f8924b = i + 1;
            }
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f8924b < this.f8923a.f8937o;
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.f8927n) {
            case 0:
                a();
                int i = this.f8924b;
                f fVar = this.f8923a;
                if (i >= fVar.f8937o) {
                    com.google.gson.internal.a.l();
                    break;
                } else {
                    this.f8924b = i + 1;
                    this.f8925l = i;
                    e eVar = new e(fVar, i);
                    c();
                    break;
                }
            case 1:
                a();
                int i6 = this.f8924b;
                f fVar2 = this.f8923a;
                if (i6 >= fVar2.f8937o) {
                    com.google.gson.internal.a.l();
                    break;
                } else {
                    this.f8924b = i6 + 1;
                    this.f8925l = i6;
                    Object obj = fVar2.f8932a[i6];
                    c();
                    break;
                }
            default:
                a();
                int i10 = this.f8924b;
                f fVar3 = this.f8923a;
                if (i10 >= fVar3.f8937o) {
                    com.google.gson.internal.a.l();
                    break;
                } else {
                    this.f8924b = i10 + 1;
                    this.f8925l = i10;
                    Object[] objArr = fVar3.f8933b;
                    objArr.getClass();
                    Object obj2 = objArr[this.f8925l];
                    c();
                    break;
                }
        }
        return null;
    }

    @Override // java.util.Iterator
    public final void remove() {
        a();
        if (this.f8925l == -1) {
            androidx.privacysandbox.ads.adservices.customaudience.a.i("Call next() before removing element from the iterator.");
            return;
        }
        f fVar = this.f8923a;
        fVar.d();
        fVar.l(this.f8925l);
        this.f8925l = -1;
        this.f8926m = fVar.f8939q;
    }
}
