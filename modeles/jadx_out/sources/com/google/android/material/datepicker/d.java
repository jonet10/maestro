package com.google.android.material.datepicker;

import android.view.View;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class d implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2998a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MaterialDatePicker f2999b;

    public /* synthetic */ d(MaterialDatePicker materialDatePicker, int i) {
        this.f2998a = i;
        this.f2999b = materialDatePicker;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f2998a) {
            case 0:
                this.f2999b.lambda$initHeaderToggle$0(view);
                break;
            case 1:
                this.f2999b.onPositiveButtonClick(view);
                break;
            default:
                this.f2999b.onNegativeButtonClick(view);
                break;
        }
    }
}
