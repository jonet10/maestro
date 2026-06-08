package c4;

import com.uptodown.activities.UserAvatarActivity;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class sb extends kotlin.jvm.internal.m implements d7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2094a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ UserAvatarActivity f2095b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ sb(UserAvatarActivity userAvatarActivity, int i) {
        super(0);
        this.f2094a = i;
        this.f2095b = userAvatarActivity;
    }

    @Override // d7.a
    public final Object invoke() {
        switch (this.f2094a) {
            case 0:
                return this.f2095b.getViewModelStore();
            default:
                return this.f2095b.getDefaultViewModelCreationExtras();
        }
    }
}
