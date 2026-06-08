package com.google.android.material.textfield;

import android.view.View;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3052a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ EndIconDelegate f3053b;

    public /* synthetic */ a(EndIconDelegate endIconDelegate, int i) {
        this.f3052a = i;
        this.f3053b = endIconDelegate;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f3052a) {
            case 0:
                ((ClearTextEndIconDelegate) this.f3053b).lambda$new$0(view);
                break;
            case 1:
                ((DropdownMenuEndIconDelegate) this.f3053b).lambda$new$0(view);
                break;
            default:
                ((PasswordToggleEndIconDelegate) this.f3053b).lambda$new$0(view);
                break;
        }
    }
}
