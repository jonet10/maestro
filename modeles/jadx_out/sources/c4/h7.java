package c4;

import com.uptodown.activities.PublicListActivity;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class h7 extends kotlin.jvm.internal.m implements d7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1683a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PublicListActivity f1684b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ h7(PublicListActivity publicListActivity, int i) {
        super(0);
        this.f1683a = i;
        this.f1684b = publicListActivity;
    }

    @Override // d7.a
    public final Object invoke() {
        switch (this.f1683a) {
            case 0:
                return this.f1684b.getViewModelStore();
            default:
                return this.f1684b.getDefaultViewModelCreationExtras();
        }
    }
}
