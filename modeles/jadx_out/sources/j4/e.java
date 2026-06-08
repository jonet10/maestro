package j4;

import a2.t;
import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.zip.ZipOutputStream;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class e extends v6.c {

    /* renamed from: a, reason: collision with root package name */
    public ArrayList f6587a;

    /* renamed from: b, reason: collision with root package name */
    public ArrayList f6588b;

    /* renamed from: l, reason: collision with root package name */
    public ZipOutputStream f6589l;

    /* renamed from: m, reason: collision with root package name */
    public byte[] f6590m;

    /* renamed from: n, reason: collision with root package name */
    public BufferedInputStream f6591n;

    /* renamed from: o, reason: collision with root package name */
    public long f6592o;

    /* renamed from: p, reason: collision with root package name */
    public long f6593p;

    /* renamed from: q, reason: collision with root package name */
    public int f6594q;

    /* renamed from: r, reason: collision with root package name */
    public int f6595r;

    /* renamed from: s, reason: collision with root package name */
    public int f6596s;

    /* renamed from: t, reason: collision with root package name */
    public int f6597t;

    /* renamed from: u, reason: collision with root package name */
    public int f6598u;
    public /* synthetic */ Object v;

    /* renamed from: w, reason: collision with root package name */
    public final /* synthetic */ t f6599w;

    /* renamed from: x, reason: collision with root package name */
    public int f6600x;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(t tVar, v6.c cVar) {
        super(cVar);
        this.f6599w = tVar;
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        this.v = obj;
        this.f6600x |= Integer.MIN_VALUE;
        return this.f6599w.m(null, null, null, 0L, this);
    }
}
