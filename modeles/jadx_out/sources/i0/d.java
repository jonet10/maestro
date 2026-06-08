package i0;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import androidx.collection.ArraySet;
import b5.m;
import e1.c0;
import j0.o;
import java.util.Collections;
import java.util.Set;
import k0.y;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public final Context f5614a;

    /* renamed from: b, reason: collision with root package name */
    public final String f5615b;

    /* renamed from: c, reason: collision with root package name */
    public final android.support.v4.media.g f5616c;

    /* renamed from: d, reason: collision with root package name */
    public final a f5617d;

    /* renamed from: e, reason: collision with root package name */
    public final j0.a f5618e;
    public final Looper f;
    public final int g;
    public final o h;
    public final c0 i;
    public final j0.e j;

    public d(Context context, android.support.v4.media.g gVar, a aVar, c cVar) {
        y.h(context, "Null context is not permitted.");
        y.h(gVar, "Api must not be null.");
        y.h(cVar, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        Context applicationContext = context.getApplicationContext();
        y.h(applicationContext, "The provided context did not have an application context.");
        this.f5614a = applicationContext;
        String attributionTag = Build.VERSION.SDK_INT >= 30 ? context.getAttributionTag() : null;
        this.f5615b = attributionTag;
        this.f5616c = gVar;
        this.f5617d = aVar;
        this.f = cVar.f5613b;
        this.f5618e = new j0.a(gVar, aVar, attributionTag);
        this.h = new o(this);
        j0.e d10 = j0.e.d(applicationContext);
        this.j = d10;
        this.g = d10.f6497q.getAndIncrement();
        this.i = cVar.f5612a;
        a4.c0 c0Var = d10.v;
        c0Var.sendMessage(c0Var.obtainMessage(7, this));
    }

    public final m a() {
        m mVar = new m(14);
        Set set = Collections.EMPTY_SET;
        if (((ArraySet) mVar.f1061b) == null) {
            mVar.f1061b = new ArraySet();
        }
        ((ArraySet) mVar.f1061b).addAll(set);
        Context context = this.f5614a;
        mVar.f1063m = context.getClass().getName();
        mVar.f1062l = context.getPackageName();
        return mVar;
    }
}
