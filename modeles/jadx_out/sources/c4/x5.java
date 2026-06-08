package c4;

import com.uptodown.activities.NotificationsRegistryActivity;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class x5 extends v6.c {

    /* renamed from: a, reason: collision with root package name */
    public int f2301a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f2302b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ NotificationsRegistryActivity f2303l;

    /* renamed from: m, reason: collision with root package name */
    public int f2304m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x5(NotificationsRegistryActivity notificationsRegistryActivity, v6.c cVar) {
        super(cVar);
        this.f2303l = notificationsRegistryActivity;
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        this.f2302b = obj;
        this.f2304m |= Integer.MIN_VALUE;
        return NotificationsRegistryActivity.z0(this.f2303l, 0, this);
    }
}
