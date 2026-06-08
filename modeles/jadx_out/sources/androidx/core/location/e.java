package androidx.core.location;

import android.location.Location;
import androidx.core.util.Consumer;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final /* synthetic */ class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f350a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Consumer f351b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Location f352l;

    public /* synthetic */ e(Consumer consumer, Location location, int i) {
        this.f350a = i;
        this.f351b = consumer;
        this.f352l = location;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f350a) {
            case 0:
                this.f351b.accept(this.f352l);
                break;
            default:
                this.f351b.accept(this.f352l);
                break;
        }
    }
}
