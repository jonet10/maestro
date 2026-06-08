package q8;

import java.util.ArrayList;
import m8.a0;
import m8.c0;
import m8.v;
import m8.z;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f8786a;

    /* renamed from: b, reason: collision with root package name */
    public final p8.e f8787b;

    /* renamed from: c, reason: collision with root package name */
    public final a f8788c;

    /* renamed from: d, reason: collision with root package name */
    public final p8.a f8789d;

    /* renamed from: e, reason: collision with root package name */
    public final int f8790e;
    public final a0 f;
    public final z g;
    public final m8.b h;
    public final int i;
    public final int j;

    /* renamed from: k, reason: collision with root package name */
    public final int f8791k;

    /* renamed from: l, reason: collision with root package name */
    public int f8792l;

    public d(ArrayList arrayList, p8.e eVar, a aVar, p8.a aVar2, int i, a0 a0Var, z zVar, m8.b bVar, int i6, int i10, int i11) {
        this.f8786a = arrayList;
        this.f8789d = aVar2;
        this.f8787b = eVar;
        this.f8788c = aVar;
        this.f8790e = i;
        this.f = a0Var;
        this.g = zVar;
        this.h = bVar;
        this.i = i6;
        this.j = i10;
        this.f8791k = i11;
    }

    public final c0 a(a0 a0Var) {
        return b(a0Var, this.f8787b, this.f8788c, this.f8789d);
    }

    public final c0 b(a0 a0Var, p8.e eVar, a aVar, p8.a aVar2) {
        a0 a0Var2;
        ArrayList arrayList = this.f8786a;
        int size = arrayList.size();
        int i = this.f8790e;
        if (i >= size) {
            throw new AssertionError();
        }
        this.f8792l++;
        a aVar3 = this.f8788c;
        if (aVar3 != null) {
            a0Var2 = a0Var;
            if (!this.f8789d.j(a0Var2.f7673a)) {
                androidx.core.view.contentcapture.a.n(arrayList.get(i - 1), "network interceptor ", " must retain the same host and port");
                return null;
            }
        } else {
            a0Var2 = a0Var;
        }
        if (aVar3 != null && this.f8792l > 1) {
            androidx.core.view.contentcapture.a.n(arrayList.get(i - 1), "network interceptor ", " must call proceed() exactly once");
            return null;
        }
        int i6 = i + 1;
        d dVar = new d(arrayList, eVar, aVar, aVar2, i6, a0Var2, this.g, this.h, this.i, this.j, this.f8791k);
        v vVar = (v) arrayList.get(i);
        c0 a8 = vVar.a(dVar);
        if (aVar != null && i6 < arrayList.size() && dVar.f8792l != 1) {
            androidx.core.view.contentcapture.a.p(vVar, "network interceptor ", " must call proceed() exactly once");
            return null;
        }
        if (a8 != null) {
            if (a8.f7698p != null) {
                return a8;
            }
            androidx.core.view.contentcapture.a.p(vVar, "interceptor ", " returned a response with no body");
            return null;
        }
        throw new NullPointerException("interceptor " + vVar + " returned null");
    }
}
