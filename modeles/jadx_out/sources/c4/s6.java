package c4;

import com.uptodown.activities.PasswordEditActivity;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class s6 extends kotlin.jvm.internal.m implements d7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2082a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PasswordEditActivity f2083b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ s6(PasswordEditActivity passwordEditActivity, int i) {
        super(0);
        this.f2082a = i;
        this.f2083b = passwordEditActivity;
    }

    @Override // d7.a
    public final Object invoke() {
        switch (this.f2082a) {
            case 0:
                return this.f2083b.getViewModelStore();
            default:
                return this.f2083b.getDefaultViewModelCreationExtras();
        }
    }
}
