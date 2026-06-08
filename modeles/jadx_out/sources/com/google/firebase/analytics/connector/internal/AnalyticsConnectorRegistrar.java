package com.google.firebase.analytics.connector.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.google.android.gms.internal.measurement.k1;
import com.google.firebase.components.ComponentRegistrar;
import e1.c0;
import j1.o;
import j9.u;
import java.util.Arrays;
import java.util.List;
import k0.y;
import n1.f;
import p1.a;
import p2.c;
import s1.b;
import s1.i;
import s1.k;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@Keep
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public class AnalyticsConnectorRegistrar implements ComponentRegistrar {
    /* JADX INFO: Access modifiers changed from: private */
    public static a lambda$getComponents$0(b bVar) {
        f fVar = (f) bVar.a(f.class);
        Context context = (Context) bVar.a(Context.class);
        c cVar = (c) bVar.a(c.class);
        y.g(fVar);
        y.g(context);
        y.g(cVar);
        y.g(context.getApplicationContext());
        if (p1.b.f8416c == null) {
            synchronized (p1.b.class) {
                try {
                    if (p1.b.f8416c == null) {
                        Bundle bundle = new Bundle(1);
                        fVar.a();
                        if ("[DEFAULT]".equals(fVar.f7909b)) {
                            ((k) cVar).a(o.f6558b, c0.f3841s);
                            bundle.putBoolean("dataCollectionDefaultEnabled", fVar.h());
                        }
                        p1.b.f8416c = new p1.b(k1.c(context, bundle).f2680b);
                    }
                } finally {
                }
            }
        }
        return p1.b.f8416c;
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    @NonNull
    @Keep
    @SuppressLint({"MissingPermission"})
    public List<s1.a> getComponents() {
        u a8 = s1.a.a(a.class);
        a8.c(i.a(f.class));
        a8.c(i.a(Context.class));
        a8.c(i.a(c.class));
        a8.f = q1.a.f8633b;
        a8.e(2);
        return Arrays.asList(a8.d(), a.a.s("fire-analytics", "23.0.0"));
    }
}
