package androidx.appcompat.app;

import android.content.Context;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f301a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f302b;

    public /* synthetic */ a(Context context, int i) {
        this.f301a = i;
        this.f302b = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f301a) {
            case 0:
                AppCompatDelegate.lambda$syncRequestedAndStoredLocales$1(this.f302b);
                break;
            default:
                AppCompatDelegate.syncRequestedAndStoredLocales(this.f302b);
                break;
        }
    }
}
