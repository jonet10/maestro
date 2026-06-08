package q2;

import android.content.Context;
import androidx.core.os.UserManagerCompat;
import b2.t1;
import j1.p;
import java.util.Set;
import java.util.concurrent.Executor;
import s1.m;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class d implements f, g {

    /* renamed from: a, reason: collision with root package name */
    public final m f8648a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f8649b;

    /* renamed from: c, reason: collision with root package name */
    public final s2.b f8650c;

    /* renamed from: d, reason: collision with root package name */
    public final Set f8651d;

    /* renamed from: e, reason: collision with root package name */
    public final Executor f8652e;

    public d(Context context, String str, Set set, s2.b bVar, Executor executor) {
        this.f8648a = new m(new n1.b(context, str));
        this.f8651d = set;
        this.f8652e = executor;
        this.f8650c = bVar;
        this.f8649b = context;
    }

    public final synchronized int a() {
        long currentTimeMillis = System.currentTimeMillis();
        i iVar = (i) this.f8648a.get();
        if (!iVar.i(currentTimeMillis)) {
            return 1;
        }
        iVar.g();
        return 3;
    }

    public final p b() {
        if (!UserManagerCompat.isUserUnlocked(this.f8649b)) {
            return t1.x("");
        }
        return t1.q(this.f8652e, new c(this, 0));
    }

    public final void c() {
        if (this.f8651d.size() <= 0) {
            t1.x(null);
        } else if (!UserManagerCompat.isUserUnlocked(this.f8649b)) {
            t1.x(null);
        } else {
            t1.q(this.f8652e, new c(this, 1));
        }
    }
}
