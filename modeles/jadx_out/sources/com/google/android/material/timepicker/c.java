package com.google.android.material.timepicker;

import com.google.android.material.button.MaterialButtonToggleGroup;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class c implements MaterialButtonToggleGroup.OnButtonCheckedListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3067a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3068b;

    public /* synthetic */ c(Object obj, int i) {
        this.f3067a = i;
        this.f3068b = obj;
    }

    @Override // com.google.android.material.button.MaterialButtonToggleGroup.OnButtonCheckedListener
    public final void onButtonChecked(MaterialButtonToggleGroup materialButtonToggleGroup, int i, boolean z9) {
        switch (this.f3067a) {
            case 0:
                ((TimePickerTextInputPresenter) this.f3068b).lambda$setupPeriodToggle$0(materialButtonToggleGroup, i, z9);
                break;
            default:
                ((TimePickerView) this.f3068b).lambda$new$0(materialButtonToggleGroup, i, z9);
                break;
        }
    }
}
