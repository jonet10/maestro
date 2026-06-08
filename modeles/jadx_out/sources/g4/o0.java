package g4;

import com.uptodown.core.activities.InstallerActivity;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class o0 extends v6.c {

    /* renamed from: a, reason: collision with root package name */
    public int f5233a;

    /* renamed from: b, reason: collision with root package name */
    public kotlin.jvm.internal.x f5234b;

    /* renamed from: l, reason: collision with root package name */
    public /* synthetic */ Object f5235l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ InstallerActivity f5236m;

    /* renamed from: n, reason: collision with root package name */
    public int f5237n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o0(InstallerActivity installerActivity, v6.c cVar) {
        super(cVar);
        this.f5236m = installerActivity;
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        this.f5235l = obj;
        this.f5237n |= Integer.MIN_VALUE;
        return this.f5236m.O(0, this);
    }
}
