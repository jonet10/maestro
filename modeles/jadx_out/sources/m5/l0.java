package m5;

import android.animation.ValueAnimator;
import android.app.AlertDialog;
import android.app.NotificationManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.RecyclerView;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import c4.c6;
import com.uptodown.UptodownApp;
import com.uptodown.activities.OldVersionsActivity;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class l0 extends RecyclerView.ViewHolder {

    /* renamed from: a, reason: collision with root package name */
    public final f0.i f7454a;

    /* renamed from: b, reason: collision with root package name */
    public final TextView f7455b;

    /* renamed from: l, reason: collision with root package name */
    public final TextView f7456l;

    /* renamed from: m, reason: collision with root package name */
    public final TextView f7457m;

    /* renamed from: n, reason: collision with root package name */
    public final TextView f7458n;

    /* renamed from: o, reason: collision with root package name */
    public final ImageView f7459o;

    /* renamed from: p, reason: collision with root package name */
    public final ProgressBar f7460p;

    /* renamed from: q, reason: collision with root package name */
    public final RelativeLayout f7461q;

    /* renamed from: r, reason: collision with root package name */
    public final float f7462r;

    /* renamed from: s, reason: collision with root package name */
    public final float f7463s;

    public l0(View view, f0.i iVar) {
        super(view);
        this.f7454a = iVar;
        View findViewById = view.findViewById(2131364574);
        findViewById.getClass();
        TextView textView = (TextView) findViewById;
        this.f7455b = textView;
        View findViewById2 = view.findViewById(2131363750);
        findViewById2.getClass();
        TextView textView2 = (TextView) findViewById2;
        this.f7456l = textView2;
        View findViewById3 = view.findViewById(2131364485);
        findViewById3.getClass();
        TextView textView3 = (TextView) findViewById3;
        this.f7457m = textView3;
        View findViewById4 = view.findViewById(2131363996);
        findViewById4.getClass();
        TextView textView4 = (TextView) findViewById4;
        this.f7458n = textView4;
        View findViewById5 = view.findViewById(2131362345);
        findViewById5.getClass();
        this.f7459o = (ImageView) findViewById5;
        View findViewById6 = view.findViewById(2131363017);
        findViewById6.getClass();
        this.f7460p = (ProgressBar) findViewById6;
        View findViewById7 = view.findViewById(2131363169);
        findViewById7.getClass();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById7;
        this.f7461q = relativeLayout;
        View findViewById8 = view.findViewById(2131362549);
        findViewById8.getClass();
        this.f7462r = 1.0f;
        this.f7463s = 0.4f;
        final int i = 0;
        relativeLayout.setOnClickListener(new View.OnClickListener(this) { // from class: m5.i0

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ l0 f7432b;

            {
                this.f7432b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                int bindingAdapterPosition;
                int bindingAdapterPosition2;
                int i6 = i;
                l0 l0Var = this.f7432b;
                switch (i6) {
                    case 0:
                        f0.i iVar2 = l0Var.f7454a;
                        if (iVar2 != null && (bindingAdapterPosition = l0Var.getBindingAdapterPosition()) != -1) {
                            OldVersionsActivity oldVersionsActivity = (OldVersionsActivity) iVar2.f4811b;
                            Object value = oldVersionsActivity.A0().f1681d.getValue();
                            value.getClass();
                            if (((x4.g) value).E0 != null) {
                                Object value2 = oldVersionsActivity.A0().f1681d.getValue();
                                value2.getClass();
                                ArrayList arrayList = ((x4.g) value2).E0;
                                arrayList.getClass();
                                if (bindingAdapterPosition < arrayList.size()) {
                                    Object value3 = oldVersionsActivity.A0().f1681d.getValue();
                                    value3.getClass();
                                    ArrayList arrayList2 = ((x4.g) value3).E0;
                                    arrayList2.getClass();
                                    long j = ((x4.t1) arrayList2.get(bindingAdapterPosition)).f11399m;
                                    boolean z9 = true;
                                    if (oldVersionsActivity.A0().f1680c.getValue() != null) {
                                        Object value4 = oldVersionsActivity.A0().f1680c.getValue();
                                        value4.getClass();
                                        if (j == ((x4.e) value4).f11124m) {
                                            String string = oldVersionsActivity.getString(2131951727);
                                            string.getClass();
                                            Object value5 = oldVersionsActivity.A0().f1681d.getValue();
                                            value5.getClass();
                                            ArrayList arrayList3 = ((x4.g) value5).E0;
                                            arrayList3.getClass();
                                            oldVersionsActivity.A(String.format(string, Arrays.copyOf(new Object[]{((x4.t1) arrayList3.get(bindingAdapterPosition)).f11396a}, 1)));
                                            break;
                                        }
                                    }
                                    e1.c0 c0Var = j5.g.D;
                                    Context applicationContext = oldVersionsActivity.getApplicationContext();
                                    applicationContext.getClass();
                                    j5.g l10 = c0Var.l(applicationContext);
                                    l10.b();
                                    Object value6 = oldVersionsActivity.A0().f1681d.getValue();
                                    value6.getClass();
                                    String str = ((x4.g) value6).F;
                                    str.getClass();
                                    x4.r L = l10.L(j, str);
                                    if (L != null) {
                                        long j6 = L.f11361q;
                                        if (a5.b.c(j6) || a5.c.b(j6)) {
                                            long j10 = L.f11361q;
                                            if (a5.b.c(j10) || a5.c.b(j10)) {
                                                a5.b.f();
                                                Object systemService = oldVersionsActivity.getSystemService("notification");
                                                systemService.getClass();
                                                ((NotificationManager) systemService).cancel(261);
                                            } else {
                                                j5.g l11 = c0Var.l(oldVersionsActivity);
                                                l11.b();
                                                if (L.p()) {
                                                    l11.j(L);
                                                } else {
                                                    Iterator it = L.F.iterator();
                                                    it.getClass();
                                                    while (it.hasNext()) {
                                                        Object next = it.next();
                                                        next.getClass();
                                                        x4.j0 j0Var = (x4.j0) next;
                                                        j0Var.f11238o = 0L;
                                                        j0Var.f11241r = 0;
                                                        l11.r0(j0Var);
                                                    }
                                                }
                                                l11.c();
                                            }
                                        } else {
                                            File g = L.g();
                                            if (!L.c() || L.F.isEmpty() || g == null || !g.exists()) {
                                                L.s(oldVersionsActivity);
                                                e4.s sVar = oldVersionsActivity.Q;
                                                if (sVar != null) {
                                                    sVar.notifyItemChanged(bindingAdapterPosition);
                                                }
                                            } else {
                                                oldVersionsActivity.B0(L);
                                            }
                                        }
                                    } else {
                                        x4.r rVar = new x4.r();
                                        Object value7 = oldVersionsActivity.A0().f1681d.getValue();
                                        value7.getClass();
                                        Object value8 = oldVersionsActivity.A0().f1681d.getValue();
                                        value8.getClass();
                                        ArrayList arrayList4 = ((x4.g) value8).E0;
                                        arrayList4.getClass();
                                        Object obj = arrayList4.get(bindingAdapterPosition);
                                        obj.getClass();
                                        rVar.b((x4.g) value7, (x4.t1) obj);
                                        Object value9 = oldVersionsActivity.A0().f1681d.getValue();
                                        value9.getClass();
                                        ArrayList arrayList5 = ((x4.g) value9).E0;
                                        arrayList5.getClass();
                                        Object obj2 = arrayList5.get(bindingAdapterPosition);
                                        obj2.getClass();
                                        x4.t1 t1Var = (x4.t1) obj2;
                                        if (t1Var.f11403q != null) {
                                            new x4.p().g(oldVersionsActivity);
                                            ArrayList arrayList6 = t1Var.f11403q;
                                            arrayList6.getClass();
                                            boolean isEmpty = x4.p.c(oldVersionsActivity, arrayList6).isEmpty();
                                            try {
                                                SharedPreferences sharedPreferences = oldVersionsActivity.getSharedPreferences("SettingsPreferences", 0);
                                                if (sharedPreferences.contains("show_warning_download_incompatible")) {
                                                    z9 = sharedPreferences.getBoolean("show_warning_download_incompatible", true);
                                                }
                                            } catch (Exception unused) {
                                            }
                                            if (!z9) {
                                                oldVersionsActivity.C0(rVar);
                                            } else if (isEmpty) {
                                                oldVersionsActivity.C0(rVar);
                                            } else {
                                                Bundle e10 = k0.k.e(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "required_feature");
                                                e10.putString("fileId", t1Var.f11402p);
                                                long j11 = rVar.f11361q;
                                                if (j11 >= 0) {
                                                    e10.putString("appId", String.valueOf(j11));
                                                }
                                                e10.putString("packagename", rVar.f11355b);
                                                android.support.v4.media.g gVar = oldVersionsActivity.E;
                                                if (gVar != null) {
                                                    gVar.E(e10, "warning");
                                                }
                                                String string2 = oldVersionsActivity.getString(2131952291);
                                                string2.getClass();
                                                if (!oldVersionsActivity.isFinishing()) {
                                                    a4.d0 k5 = a4.d0.k(oldVersionsActivity.getLayoutInflater());
                                                    TextView textView5 = (TextView) k5.f83m;
                                                    TextView textView6 = (TextView) k5.f85o;
                                                    TextView textView7 = (TextView) k5.f84n;
                                                    CheckBox checkBox = (CheckBox) k5.f82l;
                                                    textView7.setTypeface(f4.c.f4883x);
                                                    textView7.setText(string2);
                                                    checkBox.setVisibility(0);
                                                    checkBox.setTypeface(f4.c.f4883x);
                                                    checkBox.setOnCheckedChangeListener(new c6(oldVersionsActivity, 0));
                                                    textView6.setTypeface(f4.c.f4882w);
                                                    textView6.setOnClickListener(new c.e(12, oldVersionsActivity, rVar));
                                                    textView5.setTypeface(f4.c.f4882w);
                                                    textView5.setOnClickListener(new c.e(13, k5, oldVersionsActivity));
                                                    AlertDialog.Builder builder = new AlertDialog.Builder(oldVersionsActivity);
                                                    builder.setView((LinearLayout) k5.f81b);
                                                    builder.setCancelable(false);
                                                    AlertDialog alertDialog = oldVersionsActivity.F;
                                                    if (alertDialog == null || !alertDialog.isShowing()) {
                                                        oldVersionsActivity.F = builder.create();
                                                        if (!oldVersionsActivity.isFinishing()) {
                                                            AlertDialog alertDialog2 = oldVersionsActivity.F;
                                                            alertDialog2.getClass();
                                                            Window window = alertDialog2.getWindow();
                                                            if (window != null) {
                                                                a4.x.y(window, 0);
                                                            }
                                                            AlertDialog alertDialog3 = oldVersionsActivity.F;
                                                            alertDialog3.getClass();
                                                            alertDialog3.show();
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        e4.s sVar2 = oldVersionsActivity.Q;
                                        if (sVar2 != null) {
                                            sVar2.notifyItemChanged(bindingAdapterPosition);
                                        }
                                    }
                                    l10.c();
                                    break;
                                }
                            }
                        }
                        break;
                    default:
                        f0.i iVar3 = l0Var.f7454a;
                        if (iVar3 != null && (bindingAdapterPosition2 = l0Var.getBindingAdapterPosition()) != -1) {
                            iVar3.getClass();
                            float f = UptodownApp.I;
                            if (b4.d.t()) {
                                OldVersionsActivity oldVersionsActivity2 = (OldVersionsActivity) iVar3.f4811b;
                                Object value10 = oldVersionsActivity2.A0().f1681d.getValue();
                                value10.getClass();
                                if (((x4.g) value10).E0 != null) {
                                    Object value11 = oldVersionsActivity2.A0().f1681d.getValue();
                                    value11.getClass();
                                    ArrayList arrayList7 = ((x4.g) value11).E0;
                                    arrayList7.getClass();
                                    if (bindingAdapterPosition2 < arrayList7.size()) {
                                        Object value12 = oldVersionsActivity2.A0().f1681d.getValue();
                                        value12.getClass();
                                        ArrayList arrayList8 = ((x4.g) value12).E0;
                                        t6.c cVar = null;
                                        x4.t1 t1Var2 = arrayList8 != null ? (x4.t1) arrayList8.get(bindingAdapterPosition2) : null;
                                        t1Var2.getClass();
                                        if (!oldVersionsActivity2.isFinishing() && oldVersionsActivity2.A0().f1681d.getValue() != null) {
                                            Object value13 = oldVersionsActivity2.A0().f1681d.getValue();
                                            value13.getClass();
                                            String str2 = ((x4.g) value13).W;
                                            if (str2 != null && !str2.equals("PreRegister") && !str2.equals("Discontinued") && !str2.equals("ExternalDownload") && !str2.equals("ReadingMode") && !str2.equals("AppNotAvailableInThisCountry")) {
                                                o7.c0.s(LifecycleOwnerKt.getLifecycleScope(oldVersionsActivity2), null, null, new b.n(oldVersionsActivity2, t1Var2, cVar, 23), 3);
                                                break;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        break;
                }
            }
        });
        final int i6 = 1;
        ((ImageView) findViewById8).setOnClickListener(new View.OnClickListener(this) { // from class: m5.i0

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ l0 f7432b;

            {
                this.f7432b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                int bindingAdapterPosition;
                int bindingAdapterPosition2;
                int i62 = i6;
                l0 l0Var = this.f7432b;
                switch (i62) {
                    case 0:
                        f0.i iVar2 = l0Var.f7454a;
                        if (iVar2 != null && (bindingAdapterPosition = l0Var.getBindingAdapterPosition()) != -1) {
                            OldVersionsActivity oldVersionsActivity = (OldVersionsActivity) iVar2.f4811b;
                            Object value = oldVersionsActivity.A0().f1681d.getValue();
                            value.getClass();
                            if (((x4.g) value).E0 != null) {
                                Object value2 = oldVersionsActivity.A0().f1681d.getValue();
                                value2.getClass();
                                ArrayList arrayList = ((x4.g) value2).E0;
                                arrayList.getClass();
                                if (bindingAdapterPosition < arrayList.size()) {
                                    Object value3 = oldVersionsActivity.A0().f1681d.getValue();
                                    value3.getClass();
                                    ArrayList arrayList2 = ((x4.g) value3).E0;
                                    arrayList2.getClass();
                                    long j = ((x4.t1) arrayList2.get(bindingAdapterPosition)).f11399m;
                                    boolean z9 = true;
                                    if (oldVersionsActivity.A0().f1680c.getValue() != null) {
                                        Object value4 = oldVersionsActivity.A0().f1680c.getValue();
                                        value4.getClass();
                                        if (j == ((x4.e) value4).f11124m) {
                                            String string = oldVersionsActivity.getString(2131951727);
                                            string.getClass();
                                            Object value5 = oldVersionsActivity.A0().f1681d.getValue();
                                            value5.getClass();
                                            ArrayList arrayList3 = ((x4.g) value5).E0;
                                            arrayList3.getClass();
                                            oldVersionsActivity.A(String.format(string, Arrays.copyOf(new Object[]{((x4.t1) arrayList3.get(bindingAdapterPosition)).f11396a}, 1)));
                                            break;
                                        }
                                    }
                                    e1.c0 c0Var = j5.g.D;
                                    Context applicationContext = oldVersionsActivity.getApplicationContext();
                                    applicationContext.getClass();
                                    j5.g l10 = c0Var.l(applicationContext);
                                    l10.b();
                                    Object value6 = oldVersionsActivity.A0().f1681d.getValue();
                                    value6.getClass();
                                    String str = ((x4.g) value6).F;
                                    str.getClass();
                                    x4.r L = l10.L(j, str);
                                    if (L != null) {
                                        long j6 = L.f11361q;
                                        if (a5.b.c(j6) || a5.c.b(j6)) {
                                            long j10 = L.f11361q;
                                            if (a5.b.c(j10) || a5.c.b(j10)) {
                                                a5.b.f();
                                                Object systemService = oldVersionsActivity.getSystemService("notification");
                                                systemService.getClass();
                                                ((NotificationManager) systemService).cancel(261);
                                            } else {
                                                j5.g l11 = c0Var.l(oldVersionsActivity);
                                                l11.b();
                                                if (L.p()) {
                                                    l11.j(L);
                                                } else {
                                                    Iterator it = L.F.iterator();
                                                    it.getClass();
                                                    while (it.hasNext()) {
                                                        Object next = it.next();
                                                        next.getClass();
                                                        x4.j0 j0Var = (x4.j0) next;
                                                        j0Var.f11238o = 0L;
                                                        j0Var.f11241r = 0;
                                                        l11.r0(j0Var);
                                                    }
                                                }
                                                l11.c();
                                            }
                                        } else {
                                            File g = L.g();
                                            if (!L.c() || L.F.isEmpty() || g == null || !g.exists()) {
                                                L.s(oldVersionsActivity);
                                                e4.s sVar = oldVersionsActivity.Q;
                                                if (sVar != null) {
                                                    sVar.notifyItemChanged(bindingAdapterPosition);
                                                }
                                            } else {
                                                oldVersionsActivity.B0(L);
                                            }
                                        }
                                    } else {
                                        x4.r rVar = new x4.r();
                                        Object value7 = oldVersionsActivity.A0().f1681d.getValue();
                                        value7.getClass();
                                        Object value8 = oldVersionsActivity.A0().f1681d.getValue();
                                        value8.getClass();
                                        ArrayList arrayList4 = ((x4.g) value8).E0;
                                        arrayList4.getClass();
                                        Object obj = arrayList4.get(bindingAdapterPosition);
                                        obj.getClass();
                                        rVar.b((x4.g) value7, (x4.t1) obj);
                                        Object value9 = oldVersionsActivity.A0().f1681d.getValue();
                                        value9.getClass();
                                        ArrayList arrayList5 = ((x4.g) value9).E0;
                                        arrayList5.getClass();
                                        Object obj2 = arrayList5.get(bindingAdapterPosition);
                                        obj2.getClass();
                                        x4.t1 t1Var = (x4.t1) obj2;
                                        if (t1Var.f11403q != null) {
                                            new x4.p().g(oldVersionsActivity);
                                            ArrayList arrayList6 = t1Var.f11403q;
                                            arrayList6.getClass();
                                            boolean isEmpty = x4.p.c(oldVersionsActivity, arrayList6).isEmpty();
                                            try {
                                                SharedPreferences sharedPreferences = oldVersionsActivity.getSharedPreferences("SettingsPreferences", 0);
                                                if (sharedPreferences.contains("show_warning_download_incompatible")) {
                                                    z9 = sharedPreferences.getBoolean("show_warning_download_incompatible", true);
                                                }
                                            } catch (Exception unused) {
                                            }
                                            if (!z9) {
                                                oldVersionsActivity.C0(rVar);
                                            } else if (isEmpty) {
                                                oldVersionsActivity.C0(rVar);
                                            } else {
                                                Bundle e10 = k0.k.e(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "required_feature");
                                                e10.putString("fileId", t1Var.f11402p);
                                                long j11 = rVar.f11361q;
                                                if (j11 >= 0) {
                                                    e10.putString("appId", String.valueOf(j11));
                                                }
                                                e10.putString("packagename", rVar.f11355b);
                                                android.support.v4.media.g gVar = oldVersionsActivity.E;
                                                if (gVar != null) {
                                                    gVar.E(e10, "warning");
                                                }
                                                String string2 = oldVersionsActivity.getString(2131952291);
                                                string2.getClass();
                                                if (!oldVersionsActivity.isFinishing()) {
                                                    a4.d0 k5 = a4.d0.k(oldVersionsActivity.getLayoutInflater());
                                                    TextView textView5 = (TextView) k5.f83m;
                                                    TextView textView6 = (TextView) k5.f85o;
                                                    TextView textView7 = (TextView) k5.f84n;
                                                    CheckBox checkBox = (CheckBox) k5.f82l;
                                                    textView7.setTypeface(f4.c.f4883x);
                                                    textView7.setText(string2);
                                                    checkBox.setVisibility(0);
                                                    checkBox.setTypeface(f4.c.f4883x);
                                                    checkBox.setOnCheckedChangeListener(new c6(oldVersionsActivity, 0));
                                                    textView6.setTypeface(f4.c.f4882w);
                                                    textView6.setOnClickListener(new c.e(12, oldVersionsActivity, rVar));
                                                    textView5.setTypeface(f4.c.f4882w);
                                                    textView5.setOnClickListener(new c.e(13, k5, oldVersionsActivity));
                                                    AlertDialog.Builder builder = new AlertDialog.Builder(oldVersionsActivity);
                                                    builder.setView((LinearLayout) k5.f81b);
                                                    builder.setCancelable(false);
                                                    AlertDialog alertDialog = oldVersionsActivity.F;
                                                    if (alertDialog == null || !alertDialog.isShowing()) {
                                                        oldVersionsActivity.F = builder.create();
                                                        if (!oldVersionsActivity.isFinishing()) {
                                                            AlertDialog alertDialog2 = oldVersionsActivity.F;
                                                            alertDialog2.getClass();
                                                            Window window = alertDialog2.getWindow();
                                                            if (window != null) {
                                                                a4.x.y(window, 0);
                                                            }
                                                            AlertDialog alertDialog3 = oldVersionsActivity.F;
                                                            alertDialog3.getClass();
                                                            alertDialog3.show();
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        e4.s sVar2 = oldVersionsActivity.Q;
                                        if (sVar2 != null) {
                                            sVar2.notifyItemChanged(bindingAdapterPosition);
                                        }
                                    }
                                    l10.c();
                                    break;
                                }
                            }
                        }
                        break;
                    default:
                        f0.i iVar3 = l0Var.f7454a;
                        if (iVar3 != null && (bindingAdapterPosition2 = l0Var.getBindingAdapterPosition()) != -1) {
                            iVar3.getClass();
                            float f = UptodownApp.I;
                            if (b4.d.t()) {
                                OldVersionsActivity oldVersionsActivity2 = (OldVersionsActivity) iVar3.f4811b;
                                Object value10 = oldVersionsActivity2.A0().f1681d.getValue();
                                value10.getClass();
                                if (((x4.g) value10).E0 != null) {
                                    Object value11 = oldVersionsActivity2.A0().f1681d.getValue();
                                    value11.getClass();
                                    ArrayList arrayList7 = ((x4.g) value11).E0;
                                    arrayList7.getClass();
                                    if (bindingAdapterPosition2 < arrayList7.size()) {
                                        Object value12 = oldVersionsActivity2.A0().f1681d.getValue();
                                        value12.getClass();
                                        ArrayList arrayList8 = ((x4.g) value12).E0;
                                        t6.c cVar = null;
                                        x4.t1 t1Var2 = arrayList8 != null ? (x4.t1) arrayList8.get(bindingAdapterPosition2) : null;
                                        t1Var2.getClass();
                                        if (!oldVersionsActivity2.isFinishing() && oldVersionsActivity2.A0().f1681d.getValue() != null) {
                                            Object value13 = oldVersionsActivity2.A0().f1681d.getValue();
                                            value13.getClass();
                                            String str2 = ((x4.g) value13).W;
                                            if (str2 != null && !str2.equals("PreRegister") && !str2.equals("Discontinued") && !str2.equals("ExternalDownload") && !str2.equals("ReadingMode") && !str2.equals("AppNotAvailableInThisCountry")) {
                                                o7.c0.s(LifecycleOwnerKt.getLifecycleScope(oldVersionsActivity2), null, null, new b.n(oldVersionsActivity2, t1Var2, cVar, 23), 3);
                                                break;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        break;
                }
            }
        });
        textView.setTypeface(f4.c.f4882w);
        textView2.setTypeface(f4.c.f4883x);
        textView3.setTypeface(f4.c.f4882w);
        textView4.setTypeface(f4.c.f4883x);
    }

    public final void a() {
        View view = this.itemView;
        ImageView imageView = this.f7459o;
        androidx.lifecycle.l.A(view, 2131230928, imageView);
        this.f7461q.setBackground(ContextCompat.getDrawable(this.itemView.getContext(), 2131230898));
        imageView.setContentDescription(this.itemView.getContext().getString(2131952425));
    }

    public final void b() {
        if (this.f7460p.getVisibility() == 0) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(this.f7463s, this.f7462r);
            ofFloat.setStartDelay(200L);
            ofFloat.setDuration(300L);
            ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
            ofFloat.addUpdateListener(new j0(this, 1));
            ofFloat.addListener(new k0(this, 0));
            ofFloat.start();
        }
    }

    public final void c() {
        ProgressBar progressBar = this.f7460p;
        if (progressBar.getVisibility() == 8) {
            progressBar.setVisibility(0);
            ValueAnimator ofFloat = ValueAnimator.ofFloat(this.f7462r, this.f7463s);
            ofFloat.setDuration(300L);
            ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
            ofFloat.addUpdateListener(new j0(this, 0));
            ofFloat.start();
        }
    }
}
