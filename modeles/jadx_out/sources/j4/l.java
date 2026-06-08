package j4;

import java.util.Iterator;
import kotlin.jvm.internal.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class l extends v6.c {

    /* renamed from: a, reason: collision with root package name */
    public x f6636a;

    /* renamed from: b, reason: collision with root package name */
    public Iterator f6637b;

    /* renamed from: l, reason: collision with root package name */
    public /* synthetic */ Object f6638l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ o f6639m;

    /* renamed from: n, reason: collision with root package name */
    public int f6640n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(o oVar, v6.c cVar) {
        super(cVar);
        this.f6639m = oVar;
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        this.f6638l = obj;
        this.f6640n |= Integer.MIN_VALUE;
        return this.f6639m.d(null, null, this);
    }
}
