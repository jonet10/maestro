package c4;

import com.uptodown.activities.MainActivity;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class k3 extends v6.c {

    /* renamed from: a, reason: collision with root package name */
    public MainActivity f1782a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f1783b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ MainActivity f1784l;

    /* renamed from: m, reason: collision with root package name */
    public int f1785m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k3(MainActivity mainActivity, v6.c cVar) {
        super(cVar);
        this.f1784l = mainActivity;
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        this.f1783b = obj;
        this.f1785m |= Integer.MIN_VALUE;
        return MainActivity.I0(this.f1784l, this);
    }
}
