package com.google.android.gms.internal.measurement;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class a9 extends h {

    /* renamed from: l, reason: collision with root package name */
    public final z5 f2505l;

    /* renamed from: m, reason: collision with root package name */
    public final HashMap f2506m;

    public a9(z5 z5Var) {
        super("require");
        this.f2506m = new HashMap();
        this.f2505l = z5Var;
    }

    @Override // com.google.android.gms.internal.measurement.h
    public final n a(y2.s sVar, List list) {
        n nVar;
        b2.t1.S("require", 1, list);
        String f = ((t) sVar.f11756l).c(sVar, (n) list.get(0)).f();
        HashMap hashMap = this.f2506m;
        if (hashMap.containsKey(f)) {
            return (n) hashMap.get(f);
        }
        HashMap hashMap2 = (HashMap) this.f2505l.f2934a;
        if (hashMap2.containsKey(f)) {
            try {
                nVar = (n) ((Callable) hashMap2.get(f)).call();
            } catch (Exception unused) {
                androidx.privacysandbox.ads.adservices.customaudience.a.i("Failed to create API implementation: ".concat(String.valueOf(f)));
                return null;
            }
        } else {
            nVar = n.f2717c;
        }
        if (nVar instanceof h) {
            hashMap.put(f, (h) nVar);
        }
        return nVar;
    }
}
