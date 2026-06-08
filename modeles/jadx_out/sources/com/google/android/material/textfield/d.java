package com.google.android.material.textfield;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3058a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3059b;

    public /* synthetic */ d(Object obj, int i) {
        this.f3058a = i;
        this.f3059b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3058a) {
            case 0:
                ((ClearTextEndIconDelegate) this.f3059b).lambda$tearDown$2();
                break;
            case 1:
                ((DropdownMenuEndIconDelegate) this.f3059b).lambda$afterEditTextChanged$3();
                break;
            default:
                ((TextInputLayout) this.f3059b).lambda$onGlobalLayout$1();
                break;
        }
    }
}
