package o1;

import android.os.Bundle;
import androidx.lifecycle.CoroutineLiveDataKt;
import androidx.work.WorkRequest;
import com.google.android.gms.internal.measurement.a1;
import com.google.android.gms.internal.measurement.c1;
import com.google.android.gms.internal.measurement.e1;
import com.google.android.gms.internal.measurement.h0;
import com.google.android.gms.internal.measurement.k1;
import com.google.android.gms.internal.measurement.x0;
import com.google.android.gms.internal.measurement.y0;
import com.google.android.gms.internal.measurement.z0;
import e1.c3;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class a implements c3 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k1 f8133a;

    public a(k1 k1Var) {
        this.f8133a = k1Var;
    }

    @Override // e1.c3
    public final void a(String str, String str2, Bundle bundle) {
        k1 k1Var = this.f8133a;
        k1Var.a(new e1(k1Var, str, str2, bundle, true));
    }

    @Override // e1.c3
    public final String b() {
        h0 h0Var = new h0();
        k1 k1Var = this.f8133a;
        k1Var.a(new c1(k1Var, h0Var, 3));
        return (String) h0.d(String.class, h0Var.c(500L));
    }

    @Override // e1.c3
    public final String c() {
        h0 h0Var = new h0();
        k1 k1Var = this.f8133a;
        k1Var.a(new c1(k1Var, h0Var, 4));
        return (String) h0.d(String.class, h0Var.c(500L));
    }

    @Override // e1.c3
    public final void d(Bundle bundle) {
        k1 k1Var = this.f8133a;
        k1Var.a(new x0(k1Var, bundle, 1));
    }

    @Override // e1.c3
    public final void e(String str) {
        k1 k1Var = this.f8133a;
        k1Var.a(new a1(k1Var, str, 1));
    }

    @Override // e1.c3
    public final void f(String str) {
        k1 k1Var = this.f8133a;
        k1Var.a(new a1(k1Var, str, 0));
    }

    @Override // e1.c3
    public final long g() {
        h0 h0Var = new h0();
        k1 k1Var = this.f8133a;
        k1Var.a(new c1(k1Var, h0Var, 2));
        Long l10 = (Long) h0.d(Long.class, h0Var.c(500L));
        if (l10 != null) {
            return l10.longValue();
        }
        long nextLong = new Random(System.nanoTime() ^ System.currentTimeMillis()).nextLong();
        int i = k1Var.f2682d + 1;
        k1Var.f2682d = i;
        return nextLong + i;
    }

    @Override // e1.c3
    public final void h(String str, String str2, Bundle bundle) {
        k1 k1Var = this.f8133a;
        k1Var.a(new y0(k1Var, str, str2, bundle, 0));
    }

    @Override // e1.c3
    public final List i(String str, String str2) {
        h0 h0Var = new h0();
        k1 k1Var = this.f8133a;
        k1Var.a(new y0(k1Var, str, str2, h0Var, 1));
        List list = (List) h0.d(List.class, h0Var.c(CoroutineLiveDataKt.DEFAULT_TIMEOUT));
        return list == null ? Collections.EMPTY_LIST : list;
    }

    @Override // e1.c3
    public final int j(String str) {
        h0 h0Var = new h0();
        k1 k1Var = this.f8133a;
        k1Var.a(new z0(k1Var, str, h0Var, 1));
        Integer num = (Integer) h0.d(Integer.class, h0Var.c(WorkRequest.MIN_BACKOFF_MILLIS));
        if (num == null) {
            return 25;
        }
        return num.intValue();
    }

    @Override // e1.c3
    public final String k() {
        h0 h0Var = new h0();
        k1 k1Var = this.f8133a;
        k1Var.a(new c1(k1Var, h0Var, 1));
        return (String) h0.d(String.class, h0Var.c(50L));
    }

    @Override // e1.c3
    public final String l() {
        h0 h0Var = new h0();
        k1 k1Var = this.f8133a;
        k1Var.a(new c1(k1Var, h0Var, 0));
        return (String) h0.d(String.class, h0Var.c(500L));
    }

    @Override // e1.c3
    public final Map m(String str, String str2, boolean z9) {
        h0 h0Var = new h0();
        k1 k1Var = this.f8133a;
        k1Var.a(new e1(k1Var, str, str2, z9, h0Var));
        Bundle c9 = h0Var.c(CoroutineLiveDataKt.DEFAULT_TIMEOUT);
        if (c9 == null || c9.size() == 0) {
            return Collections.EMPTY_MAP;
        }
        HashMap hashMap = new HashMap(c9.size());
        for (String str3 : c9.keySet()) {
            Object obj = c9.get(str3);
            if ((obj instanceof Double) || (obj instanceof Long) || (obj instanceof String)) {
                hashMap.put(str3, obj);
            }
        }
        return hashMap;
    }
}
