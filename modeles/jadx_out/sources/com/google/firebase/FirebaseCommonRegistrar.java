package com.google.firebase;

import a3.b;
import a3.c;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import com.google.firebase.components.ComponentRegistrar;
import j9.u;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import q2.d;
import q2.e;
import q2.f;
import q2.g;
import s1.a;
import s1.i;
import s1.r;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public class FirebaseCommonRegistrar implements ComponentRegistrar {
    public static /* synthetic */ String a(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        return (applicationInfo == null || Build.VERSION.SDK_INT < 24) ? "" : String.valueOf(applicationInfo.minSdkVersion);
    }

    public static String b(String str) {
        return str.replace(' ', '_').replace('/', '_');
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public final List getComponents() {
        String str;
        ArrayList arrayList = new ArrayList();
        u a8 = a.a(c.class);
        a8.c(new i(2, 0, a3.a.class));
        a8.f = new b(0);
        arrayList.add(a8.d());
        r rVar = new r(r1.a.class, Executor.class);
        u uVar = new u(d.class, new Class[]{f.class, g.class});
        uVar.c(i.a(Context.class));
        uVar.c(i.a(n1.f.class));
        uVar.c(new i(2, 0, e.class));
        uVar.c(new i(1, 1, c.class));
        uVar.c(new i(rVar, 1, 0));
        uVar.f = new q2.b(rVar, 0);
        arrayList.add(uVar.d());
        arrayList.add(a.a.s("fire-android", String.valueOf(Build.VERSION.SDK_INT)));
        arrayList.add(a.a.s("fire-core", "22.0.1"));
        arrayList.add(a.a.s("device-name", b(Build.PRODUCT)));
        arrayList.add(a.a.s("device-model", b(Build.DEVICE)));
        arrayList.add(a.a.s("device-brand", b(Build.BRAND)));
        arrayList.add(a.a.y("android-target-sdk", new com.google.gson.internal.a(20)));
        arrayList.add(a.a.y("android-min-sdk", new com.google.gson.internal.a(21)));
        arrayList.add(a.a.y("android-platform", new com.google.gson.internal.a(22)));
        arrayList.add(a.a.y("android-installer", new com.google.gson.internal.a(23)));
        try {
            p6.e.f8436b.getClass();
            str = "2.2.10";
        } catch (NoClassDefFoundError unused) {
            str = null;
        }
        if (str != null) {
            arrayList.add(a.a.s("kotlin", str));
        }
        return arrayList;
    }
}
