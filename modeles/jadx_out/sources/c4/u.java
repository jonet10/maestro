package c4;

import android.content.DialogInterface;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class u implements DialogInterface.OnCancelListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2142a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f2143b;

    public /* synthetic */ u(Object obj, int i) {
        this.f2142a = i;
        this.f2143b = obj;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        switch (this.f2142a) {
            case 0:
                ((d7.a) this.f2143b).invoke();
                break;
            default:
                ((w4) this.f2143b).U = false;
                break;
        }
    }
}
