package androidx.profileinstaller;

import android.content.Context;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final /* synthetic */ class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f468a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f469b;

    public /* synthetic */ c(Context context, int i) {
        this.f468a = i;
        this.f469b = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f468a) {
            case 0:
                ProfileInstallerInitializer.writeInBackground(this.f469b);
                break;
            default:
                ProfileInstaller.writeProfile(this.f469b);
                break;
        }
    }
}
