package e5;

import a4.g0;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.leanback.widget.Presenter;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class q extends Presenter {

    /* renamed from: a, reason: collision with root package name */
    public int f4754a = -1;

    /* renamed from: b, reason: collision with root package name */
    public int f4755b = -1;

    @Override // androidx.leanback.widget.Presenter
    public final void onBindViewHolder(Presenter.ViewHolder viewHolder, Object obj) {
        viewHolder.getClass();
        if (obj == null) {
            return;
        }
        g0.d().e(((x4.g) obj).e()).e(((i5.h) viewHolder).f5694a, null);
    }

    @Override // androidx.leanback.widget.Presenter
    public final Presenter.ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        View s6 = androidx.lifecycle.l.s(viewGroup, 2131558851, viewGroup, false);
        this.f4755b = ContextCompat.getColor(viewGroup.getContext(), 2131100500);
        this.f4754a = ContextCompat.getColor(viewGroup.getContext(), 2131100502);
        s6.setFocusable(true);
        s6.setFocusableInTouchMode(true);
        s6.setOnFocusChangeListener(new com.google.android.material.datepicker.c(this, 2));
        s6.setBackgroundColor(this.f4755b);
        return new i5.h(s6);
    }

    @Override // androidx.leanback.widget.Presenter
    public final void onUnbindViewHolder(Presenter.ViewHolder viewHolder) {
        viewHolder.getClass();
    }
}
