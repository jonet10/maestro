package c4;

import com.uptodown.activities.MyDownloads;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class k5 extends kotlin.jvm.internal.m implements d7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1789a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MyDownloads f1790b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ k5(MyDownloads myDownloads, int i) {
        super(0);
        this.f1789a = i;
        this.f1790b = myDownloads;
    }

    @Override // d7.a
    public final Object invoke() {
        switch (this.f1789a) {
            case 0:
                return this.f1790b.getViewModelStore();
            default:
                return this.f1790b.getDefaultViewModelCreationExtras();
        }
    }
}
