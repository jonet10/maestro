package u4;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.CompoundButton;
import androidx.lifecycle.ViewModelKt;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class h implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10497a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f0 f10498b;

    public /* synthetic */ h(f0 f0Var, int i) {
        this.f10497a = i;
        this.f10498b = f0Var;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z9) {
        int i = this.f10497a;
        f0 f0Var = this.f10498b;
        switch (i) {
            case 0:
                Context requireContext = f0Var.requireContext();
                requireContext.getClass();
                SharedPreferences sharedPreferences = requireContext.getSharedPreferences("SettingsPreferences", 0);
                sharedPreferences.getClass();
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putBoolean("show_warning_download_incompatible", !z9);
                edit.apply();
                break;
            default:
                v0 G = f0Var.G();
                Context requireContext2 = f0Var.requireContext();
                requireContext2.getClass();
                long j = f0Var.B().f11158a;
                G.getClass();
                o7.a0 viewModelScope = ViewModelKt.getViewModelScope(G);
                v7.e eVar = o7.m0.f8288a;
                o7.c0.s(viewModelScope, v7.d.f10884a, null, new u0(requireContext2, j, z9, null), 2);
                break;
        }
    }
}
