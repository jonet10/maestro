package c4;

import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class d7 extends v6.c {

    /* renamed from: a, reason: collision with root package name */
    public ArrayList f1512a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f1513b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ e7 f1514l;

    /* renamed from: m, reason: collision with root package name */
    public int f1515m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d7(e7 e7Var, v6.c cVar) {
        super(cVar);
        this.f1514l = e7Var;
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        this.f1513b = obj;
        this.f1515m |= Integer.MIN_VALUE;
        return e7.a(this.f1514l, null, this);
    }
}
