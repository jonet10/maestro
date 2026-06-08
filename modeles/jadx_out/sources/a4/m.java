package a4;

import android.os.Message;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class m implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f139a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Message f140b;

    public /* synthetic */ m(Message message, int i) {
        this.f139a = i;
        this.f140b = message;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f139a) {
            case 0:
                throw new AssertionError("Unknown handler message received: " + this.f140b.what);
            default:
                throw new AssertionError("Unhandled stats message." + this.f140b.what);
        }
    }
}
