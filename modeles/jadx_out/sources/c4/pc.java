package c4;

import com.uptodown.activities.UserDevicesActivity;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class pc extends kotlin.jvm.internal.m implements d7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UserDevicesActivity f1999a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public pc(UserDevicesActivity userDevicesActivity) {
        super(0);
        this.f1999a = userDevicesActivity;
    }

    @Override // d7.a
    public final Object invoke() {
        return this.f1999a.getDefaultViewModelProviderFactory();
    }
}
