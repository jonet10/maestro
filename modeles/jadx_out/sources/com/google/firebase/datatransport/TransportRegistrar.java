package com.google.firebase.datatransport;

import android.content.Context;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.google.firebase.components.ComponentRegistrar;
import j9.u;
import java.util.Arrays;
import java.util.List;
import o.f;
import p.a;
import r.r;
import s1.b;
import s1.i;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@Keep
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public class TransportRegistrar implements ComponentRegistrar {
    private static final String LIBRARY_NAME = "fire-transport";

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ f lambda$getComponents$0(b bVar) {
        r.b((Context) bVar.a(Context.class));
        return r.a().c(a.f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ f lambda$getComponents$1(b bVar) {
        r.b((Context) bVar.a(Context.class));
        return r.a().c(a.f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ f lambda$getComponents$2(b bVar) {
        r.b((Context) bVar.a(Context.class));
        return r.a().c(a.f8392e);
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    @NonNull
    public List<s1.a> getComponents() {
        u a8 = s1.a.a(f.class);
        a8.f6817c = LIBRARY_NAME;
        a8.c(i.a(Context.class));
        a8.f = new com.google.gson.internal.a(10);
        s1.a d10 = a8.d();
        u b7 = s1.a.b(new s1.r(j2.a.class, f.class));
        b7.c(i.a(Context.class));
        b7.f = new com.google.gson.internal.a(11);
        s1.a d11 = b7.d();
        u b10 = s1.a.b(new s1.r(j2.b.class, f.class));
        b10.c(i.a(Context.class));
        b10.f = new com.google.gson.internal.a(12);
        return Arrays.asList(d10, d11, b10.d(), a.a.s(LIBRARY_NAME, "19.0.0"));
    }
}
