package com.google.android.material.datepicker;

import android.view.View;
import android.widget.EditText;
import com.google.android.material.internal.ViewUtils;
import e5.l;
import e5.q;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class c implements View.OnFocusChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2996a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f2997b;

    public /* synthetic */ c(Object obj, int i) {
        this.f2996a = i;
        this.f2997b = obj;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z9) {
        switch (this.f2996a) {
            case 0:
                for (EditText editText : (EditText[]) this.f2997b) {
                    if (editText.hasFocus()) {
                        break;
                    }
                }
                ViewUtils.hideKeyboard(view, false);
                break;
            case 1:
                l lVar = (l) this.f2997b;
                view.getClass();
                view.setBackgroundColor(z9 ? lVar.f4743a : lVar.f4744b);
                break;
            default:
                q qVar = (q) this.f2997b;
                view.getClass();
                view.setBackgroundColor(z9 ? qVar.f4754a : qVar.f4755b);
                break;
        }
    }
}
