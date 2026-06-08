package p;

import a4.x;
import android.content.Context;
import android.net.ConnectivityManager;
import g5.f;
import java.net.MalformedURLException;
import java.net.URL;
import n2.d;
import q.a0;
import q.b0;
import q.c0;
import q.d0;
import q.e0;
import q.f0;
import q.g;
import q.h;
import q.i;
import q.i0;
import q.j;
import q.k;
import q.l;
import q.m;
import q.n;
import q.o;
import q.p;
import q.q;
import q.r;
import q.s;
import q.t;
import q.v;
import q.w;
import q.y;
import s.e;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class c implements e {

    /* renamed from: a, reason: collision with root package name */
    public final f f8398a;

    /* renamed from: b, reason: collision with root package name */
    public final ConnectivityManager f8399b;

    /* renamed from: c, reason: collision with root package name */
    public final Context f8400c;

    /* renamed from: d, reason: collision with root package name */
    public final URL f8401d;

    /* renamed from: e, reason: collision with root package name */
    public final q2.e f8402e;
    public final q2.e f;
    public final int g;

    public c(Context context, q2.e eVar, q2.e eVar2) {
        d dVar = new d();
        q.c cVar = q.c.f8564a;
        dVar.a(w.class, cVar);
        dVar.a(m.class, cVar);
        j jVar = j.f8588a;
        dVar.a(f0.class, jVar);
        dVar.a(t.class, jVar);
        q.d dVar2 = q.d.f8566a;
        dVar.a(y.class, dVar2);
        dVar.a(n.class, dVar2);
        q.b bVar = q.b.f8556a;
        dVar.a(q.a.class, bVar);
        dVar.a(l.class, bVar);
        i iVar = i.f8583a;
        dVar.a(e0.class, iVar);
        dVar.a(s.class, iVar);
        q.e eVar3 = q.e.f8569a;
        dVar.a(a0.class, eVar3);
        dVar.a(o.class, eVar3);
        h hVar = h.f8579a;
        dVar.a(d0.class, hVar);
        dVar.a(r.class, hVar);
        g gVar = g.f8575a;
        dVar.a(c0.class, gVar);
        dVar.a(q.class, gVar);
        k kVar = k.f8595a;
        dVar.a(i0.class, kVar);
        dVar.a(v.class, kVar);
        q.f fVar = q.f.f8572a;
        dVar.a(b0.class, fVar);
        dVar.a(p.class, fVar);
        dVar.f7930d = true;
        this.f8398a = new f(dVar, 10);
        this.f8400c = context;
        this.f8399b = (ConnectivityManager) context.getSystemService("connectivity");
        this.f8401d = b(a.f8390c);
        this.f8402e = eVar2;
        this.f = eVar;
        this.g = 130000;
    }

    public static URL b(String str) {
        try {
            return new URL(str);
        } catch (MalformedURLException e10) {
            throw new IllegalArgumentException(x.j("Invalid url: ", str), e10);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x00a8, code lost:
    
        if (((q.g0) q.g0.f8577a.get(r0)) != null) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0110  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final r.i a(r.i r8) {
        /*
            Method dump skipped, instructions count: 288
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p.c.a(r.i):r.i");
    }
}
