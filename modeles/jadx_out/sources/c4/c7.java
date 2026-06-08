package c4;

import com.uptodown.activities.PreregistrationActivity;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class c7 extends kotlin.jvm.internal.m implements d7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1468a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PreregistrationActivity f1469b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c7(PreregistrationActivity preregistrationActivity, int i) {
        super(0);
        this.f1468a = i;
        this.f1469b = preregistrationActivity;
    }

    @Override // d7.a
    public final Object invoke() {
        switch (this.f1468a) {
            case 0:
                return this.f1469b.getViewModelStore();
            default:
                return this.f1469b.getDefaultViewModelCreationExtras();
        }
    }
}
