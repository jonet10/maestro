package c4;

import android.R;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import androidx.viewbinding.ViewBindings;
import androidx.work.Data;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import com.uptodown.UptodownApp;
import com.uptodown.activities.CustomWebView;
import com.uptodown.activities.MainActivity;
import com.uptodown.activities.MyApps;
import com.uptodown.activities.MyDownloads;
import com.uptodown.core.activities.InstallerActivity;
import com.uptodown.core.view.WrapContentLinearLayoutManager;
import com.uptodown.workers.DownloadApkWorker;
import j$.time.Year;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class k0 extends g4.s0 {
    public static final /* synthetic */ int N = 0;
    public android.support.v4.media.g E;
    public AlertDialog F;
    public RecyclerView G;
    public e4.c0 H;
    public final f0.i I = new f0.i(this, 5);
    public ArrayList J = new ArrayList();
    public ActivityResultLauncher K;
    public n5.d L;
    public RelativeLayout M;

    public final void H(String str, d7.a aVar) {
        if (isFinishing()) {
            return;
        }
        Q();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        a4.d0 k5 = a4.d0.k(getLayoutInflater());
        TextView textView = (TextView) k5.f83m;
        TextView textView2 = (TextView) k5.f85o;
        TextView textView3 = (TextView) k5.f84n;
        textView3.setTypeface(f4.c.f4883x);
        textView3.setText(str);
        textView2.setTypeface(f4.c.f4882w);
        textView2.setOnClickListener(new p(aVar, this, 0));
        textView.setTypeface(f4.c.f4882w);
        textView.setOnClickListener(new o(this, 2));
        builder.setView((LinearLayout) k5.f81b);
        this.F = builder.create();
        if (isFinishing() || this.F == null) {
            return;
        }
        u0();
    }

    public final void I(String str, d7.a aVar, d7.a aVar2) {
        LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this);
        v7.e eVar = o7.m0.f8288a;
        o7.c0.s(lifecycleScope, t7.n.f10348a, null, new w(this, str, aVar, aVar2, null, 0), 2);
    }

    public final void J() {
        if (isFinishing()) {
            return;
        }
        Q();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        int i = 0;
        View inflate = getLayoutInflater().inflate(2131558485, (ViewGroup) null, false);
        int i6 = 2131363953;
        TextView textView = (TextView) ViewBindings.findChildViewById(inflate, 2131363953);
        if (textView != null) {
            i6 = 2131364010;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(inflate, 2131364010);
            if (textView2 != null) {
                i6 = 2131364110;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(inflate, 2131364110);
                if (textView3 != null) {
                    i6 = 2131364363;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(inflate, 2131364363);
                    if (textView4 != null) {
                        textView4.setTypeface(f4.c.f4882w);
                        textView2.setTypeface(f4.c.f4883x);
                        textView3.setTypeface(f4.c.f4882w);
                        textView.setTypeface(f4.c.f4883x);
                        textView3.setOnClickListener(new o(this, i));
                        textView.setOnClickListener(new o(this, 1));
                        builder.setView((LinearLayout) inflate);
                        this.F = builder.create();
                        if (isFinishing() || this.F == null) {
                            return;
                        }
                        u0();
                        return;
                    }
                }
            }
        }
        com.google.gson.internal.a.i("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i6)));
    }

    public final void K(String str, final d7.a aVar, final d7.a aVar2) {
        Integer h02 = str != null ? l7.t.h0(str) : null;
        if (h02 == null || h02.intValue() < 18) {
            aVar.invoke();
            return;
        }
        int i = getSharedPreferences("SettingsPreferences", 0).getInt("ageVerificationYear", -1);
        final int value = Year.now().getValue();
        if (i > 0) {
            if (value - i >= 18) {
                aVar.invoke();
                return;
            } else {
                L(aVar2);
                return;
            }
        }
        Q();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        final g4.u c9 = g4.u.c(getLayoutInflater());
        TextView textView = c9.f5269n;
        TextView textView2 = c9.f5268m;
        ((TextView) c9.f5273r).setTypeface(f4.c.f4882w);
        c9.f5271p.setTypeface(f4.c.f4883x);
        c9.f5270o.setTypeface(f4.c.f4883x);
        c9.f5267l.setTypeface(f4.c.f4883x);
        ((TextView) c9.f5272q).setTypeface(f4.c.f4883x);
        textView2.setTypeface(f4.c.f4882w);
        textView.setTypeface(f4.c.f4882w);
        textView2.setOnClickListener(new View.OnClickListener() { // from class: c4.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EditText editText = g4.u.this.f5267l;
                Integer h03 = l7.t.h0(editText.getText().toString());
                Editable text = editText.getText();
                text.getClass();
                int length = text.length();
                k0 k0Var = this;
                if (length <= 0 || h03 == null) {
                    String string = k0Var.getString(2131951667);
                    string.getClass();
                    k0Var.A(string);
                    return;
                }
                String obj = editText.getText().toString();
                int intValue = h03.intValue();
                obj.getClass();
                int i6 = value;
                if (intValue >= i6 || obj.length() != 4 || intValue <= 1900) {
                    String string2 = k0Var.getString(2131951667);
                    string2.getClass();
                    k0Var.A(string2);
                    return;
                }
                Object systemService = k0Var.getSystemService("input_method");
                systemService.getClass();
                ((InputMethodManager) systemService).hideSoftInputFromWindow(editText.getWindowToken(), 0);
                k0Var.Q();
                int intValue2 = h03.intValue();
                SharedPreferences sharedPreferences = k0Var.getSharedPreferences("SettingsPreferences", 0);
                sharedPreferences.getClass();
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putInt("ageVerificationYear", intValue2);
                edit.apply();
                if (i6 - h03.intValue() >= 18) {
                    aVar.invoke();
                } else {
                    k0Var.L(aVar2);
                }
            }
        });
        textView.setOnClickListener(new o(this, 3));
        builder.setView(c9.f5266b);
        builder.setCancelable(false);
        this.F = builder.create();
        u0();
    }

    public final void L(d7.a aVar) {
        Q();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        a4.d0 k5 = a4.d0.k(getLayoutInflater());
        TextView textView = (TextView) k5.f84n;
        textView.setTypeface(f4.c.f4883x);
        textView.setText(getString(2131951666));
        ((TextView) k5.f83m).setVisibility(8);
        TextView textView2 = (TextView) k5.f85o;
        textView2.setText(getString(2131952047));
        textView2.setTypeface(f4.c.f4882w);
        textView2.setOnClickListener(new p(aVar, this, 1));
        builder.setView((LinearLayout) k5.f81b);
        builder.setCancelable(false);
        this.F = builder.create();
        u0();
    }

    public final void M(File file) {
        String string = getString(2131952802);
        string.getClass();
        H(string, new androidx.work.impl.utils.c(2, this, file));
    }

    public final void N(String str) {
        str.getClass();
        if (isFinishing()) {
            return;
        }
        Q();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        a4.d0 k5 = a4.d0.k(getLayoutInflater());
        TextView textView = (TextView) k5.f85o;
        TextView textView2 = (TextView) k5.f84n;
        textView2.setTypeface(f4.c.f4883x);
        textView2.setText(str);
        ((TextView) k5.f83m).setVisibility(8);
        textView.setTypeface(f4.c.f4882w);
        textView.setOnClickListener(new o(this, 5));
        builder.setView((LinearLayout) k5.f81b);
        this.F = builder.create();
        if (isFinishing() || this.F == null) {
            return;
        }
        u0();
    }

    public final void O() {
        AlertDialog alertDialog;
        if (isFinishing()) {
            return;
        }
        Q();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        a4.d0 k5 = a4.d0.k(getLayoutInflater());
        TextView textView = (TextView) k5.f85o;
        TextView textView2 = (TextView) k5.f84n;
        TextView textView3 = (TextView) k5.f83m;
        textView2.setTypeface(f4.c.f4883x);
        textView2.setText(getString(2131952286));
        textView.setTypeface(f4.c.f4882w);
        MainActivity mainActivity = (MainActivity) this;
        textView.setOnClickListener(new s(0, mainActivity));
        textView3.setTypeface(f4.c.f4882w);
        textView3.setText(getString(2131952009));
        textView3.setOnClickListener(new s(1, mainActivity));
        builder.setView((LinearLayout) k5.f81b);
        builder.setCancelable(false);
        this.F = builder.create();
        if (isFinishing() || (alertDialog = this.F) == null) {
            return;
        }
        Window window = alertDialog.getWindow();
        if (window != null) {
            a4.x.y(window, 0);
        }
        AlertDialog alertDialog2 = this.F;
        alertDialog2.getClass();
        alertDialog2.show();
    }

    public final void P(x4.g gVar, x4.f2 f2Var, d7.a aVar, d7.a aVar2) {
        Object obj;
        gVar.getClass();
        Q();
        View inflate = getLayoutInflater().inflate(2131558536, (ViewGroup) null, false);
        int i = 2131362327;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(inflate, 2131362327);
        if (imageView != null) {
            i = 2131362554;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(inflate, 2131362554);
            if (imageView2 != null) {
                i = 2131362781;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(inflate, 2131362781);
                if (linearLayout != null) {
                    i = 2131363299;
                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(inflate, 2131363299);
                    if (relativeLayout != null) {
                        i = 2131363618;
                        TextView textView = (TextView) ViewBindings.findChildViewById(inflate, 2131363618);
                        if (textView != null) {
                            i = 2131363790;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(inflate, 2131363790);
                            if (textView2 != null) {
                                i = 2131364389;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(inflate, 2131364389);
                                if (textView3 != null) {
                                    i = 2131364601;
                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(inflate, 2131364601);
                                    if (textView4 != null) {
                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(inflate, 2131364602);
                                        if (textView5 != null) {
                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(inflate, 2131364603);
                                            if (textView6 != null) {
                                                RelativeLayout relativeLayout2 = (RelativeLayout) inflate;
                                                textView3.setTypeface(f4.c.f4882w);
                                                textView2.setTypeface(f4.c.f4883x);
                                                imageView.setOnClickListener(new p(this, aVar2, 2));
                                                if (f2Var != null) {
                                                    textView.setText(getString(2131951963));
                                                    textView6.setTypeface(f4.c.f4882w);
                                                    textView5.setTypeface(f4.c.f4883x);
                                                    textView5.setText(getString(2131952800, String.valueOf(f2Var.f11154m), String.valueOf(f2Var.f11153l)));
                                                    textView4.setTypeface(f4.c.f4883x);
                                                    textView4.setText(getString(2131952780, f2Var.f11155n));
                                                    ArrayList arrayList = f2Var.f11156o;
                                                    if (arrayList != null && !arrayList.isEmpty()) {
                                                        ArrayList arrayList2 = f2Var.f11156o;
                                                        arrayList2.getClass();
                                                        int size = arrayList2.size();
                                                        int i6 = 0;
                                                        while (true) {
                                                            if (i6 >= size) {
                                                                obj = null;
                                                                break;
                                                            }
                                                            obj = arrayList2.get(i6);
                                                            i6++;
                                                            x4.g1 g1Var = (x4.g1) obj;
                                                            if (g1Var.f11201l == 0 && g1Var.f11202m == 0) {
                                                                break;
                                                            }
                                                        }
                                                        if (((x4.g1) obj) != null) {
                                                            relativeLayout.setBackground(ContextCompat.getDrawable(this, 2131231242));
                                                            imageView2.setImageDrawable(ContextCompat.getDrawable(this, 2131231498));
                                                        }
                                                        ArrayList arrayList3 = f2Var.f11156o;
                                                        arrayList3.getClass();
                                                        m0(linearLayout, arrayList3);
                                                        if (gVar.f11158a > 0) {
                                                            ArrayList arrayList4 = f2Var.f11156o;
                                                            arrayList4.getClass();
                                                            if (arrayList4.size() > 3) {
                                                                View inflate2 = getLayoutInflater().inflate(2131558853, (ViewGroup) null, false);
                                                                if (inflate2 == null) {
                                                                    com.google.gson.internal.a.i("rootView");
                                                                    return;
                                                                }
                                                                TextView textView7 = (TextView) inflate2;
                                                                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                                                                layoutParams.setMargins((int) getResources().getDimension(2131166252), (int) getResources().getDimension(2131166250), 0, 0);
                                                                textView7.setLayoutParams(layoutParams);
                                                                textView7.setTypeface(f4.c.f4882w);
                                                                textView7.setOnClickListener(new t(this, gVar, f2Var, 0));
                                                                linearLayout.addView(textView7);
                                                            }
                                                        }
                                                    }
                                                }
                                                textView.setTypeface(f4.c.f4882w);
                                                textView.setOnClickListener(new p(this, aVar, 3));
                                                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                                                builder.setView(relativeLayout2);
                                                builder.setCancelable(true);
                                                builder.setOnCancelListener(new u(aVar2, 0));
                                                this.F = builder.create();
                                                u0();
                                                return;
                                            }
                                            i = 2131364603;
                                        } else {
                                            i = 2131364602;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        com.google.gson.internal.a.i("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    public final void Q() {
        AlertDialog alertDialog = this.F;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    public final void R() {
        RecyclerView recyclerView = (RecyclerView) findViewById(2131363337);
        this.G = recyclerView;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new WrapContentLinearLayoutManager(this, 1, false));
            RecyclerView recyclerView2 = this.G;
            recyclerView2.getClass();
            recyclerView2.addItemDecoration(new l5.g((int) getResources().getDimension(2131166251)));
            MainActivity mainActivity = (MainActivity) this;
            this.H = new e4.c0(mainActivity, this.I);
            RecyclerView recyclerView3 = this.G;
            recyclerView3.getClass();
            recyclerView3.setAdapter(this.H);
            new ItemTouchHelper(new v(mainActivity)).attachToRecyclerView(this.G);
        }
    }

    public final void S(x4.q2 q2Var, File file) {
        ApplicationInfo applicationInfo;
        q2Var.getClass();
        if (!file.isDirectory() && (file = new File(file.getAbsolutePath()).getParentFile()) == null) {
            return;
        }
        File file2 = file;
        b5.m mVar = new b5.m(this, file2, q2Var, 2);
        try {
            PackageManager packageManager = getPackageManager();
            packageManager.getClass();
            applicationInfo = n4.i.b(packageManager, q2Var.f11344b, 128);
        } catch (PackageManager.NameNotFoundException e10) {
            e10.printStackTrace();
            applicationInfo = null;
        }
        if (applicationInfo == null) {
            String string = getString(2131952085);
            string.getClass();
            N(string);
        } else {
            File file3 = new File(applicationInfo.sourceDir);
            ArrayList arrayList = new ArrayList();
            arrayList.add(file3);
            new j4.o(arrayList, file2, mVar, false, this);
        }
    }

    public final boolean T() {
        if (com.google.android.gms.internal.measurement.z3.f2928c) {
            return true;
        }
        String string = getString(2131952001);
        string.getClass();
        N(string);
        return false;
    }

    public final void U(File file, String str) {
        android.support.v4.media.g gVar = new android.support.v4.media.g(1, this, file);
        if (f4.a.f4869a.c() != null || f4.c.v != null) {
            String string = getString(2131951872);
            string.getClass();
            A(string);
            return;
        }
        String name = file.getName();
        name.getClass();
        if (!l7.u.k0(name, ".xapk", true) && !l7.u.k0(name, ".apks", true) && !l7.u.k0(name, ".apkm", true) && !l7.u.k0(name, ".zip", true)) {
            float f = UptodownApp.I;
            b4.d.q(this, str, file);
        } else {
            String absolutePath = file.getAbsolutePath();
            absolutePath.getClass();
            new a2.t(this, absolutePath, gVar, m());
        }
    }

    public final void V(File file, String str) {
        file.getClass();
        boolean f = j5.a.f(this);
        x4.w2 h = x4.u2.h(this);
        j5.g l10 = j5.g.D.l(this);
        l10.b();
        if (file.isFile()) {
            String name = file.getName();
            name.getClass();
            x4.r G = l10.G(name);
            if (h == null || !h.d()) {
                String absolutePath = file.getAbsolutePath();
                absolutePath.getClass();
                Intent intent = new Intent(this, (Class<?>) InstallerActivity.class);
                intent.putExtra("realPath", absolutePath);
                intent.putExtra("requireUserAction", f);
                intent.putExtra("backgroundInstallation", false);
                intent.addFlags(268435456);
                if (str != null && str.length() != 0) {
                    intent.putExtra("newFeatures", str);
                }
                startActivity(intent);
                X(G);
            } else {
                o7.c0.s(LifecycleOwnerKt.getLifecycleScope(this), null, null, new d0(this, com.google.android.gms.internal.measurement.z3.x(file.getAbsolutePath()), G, file, str, f, null), 3);
            }
        } else {
            String absolutePath2 = file.getAbsolutePath();
            absolutePath2.getClass();
            Intent intent2 = new Intent(this, (Class<?>) InstallerActivity.class);
            intent2.putExtra("realPath", absolutePath2);
            intent2.putExtra("requireUserAction", f);
            intent2.putExtra("backgroundInstallation", false);
            intent2.addFlags(268435456);
            if (str != null && str.length() != 0) {
                intent2.putExtra("newFeatures", str);
            }
            startActivity(intent2);
            String absolutePath3 = file.getAbsolutePath();
            absolutePath3.getClass();
            X(l10.H(absolutePath3));
        }
        l10.c();
    }

    public final void W(File file, String str) {
        file.getClass();
        boolean z9 = false;
        try {
            SharedPreferences sharedPreferences = getSharedPreferences("CoreSettings", 0);
            if (sharedPreferences.contains("show_installation_details")) {
                z9 = sharedPreferences.getBoolean("show_installation_details", false);
            }
        } catch (Exception unused) {
        }
        if (z9) {
            V(file, str);
            return;
        }
        x4.w2 h = x4.u2.h(this);
        if (h == null || !h.d()) {
            U(file, str);
            return;
        }
        if (!file.isFile()) {
            U(file, str);
            return;
        }
        String x3 = com.google.android.gms.internal.measurement.z3.x(file.getAbsolutePath());
        j5.g l10 = j5.g.D.l(this);
        l10.b();
        String name = file.getName();
        name.getClass();
        x4.r G = l10.G(name);
        l10.c();
        o7.c0.s(LifecycleOwnerKt.getLifecycleScope(this), null, null, new z(this, x3, G, file, str, (t6.c) null), 3);
    }

    public final void X(x4.r rVar) {
        String str;
        Bundle bundle = new Bundle();
        t6.c cVar = null;
        if ((rVar != null ? rVar.f11355b : null) != null) {
            String str2 = rVar.f11355b;
            str2.getClass();
            b2.t1.i(this, str2, bundle, rVar.A == 1);
            bundle.putString("packagename", rVar.f11355b);
        }
        if (rVar != null) {
            long j = rVar.f11361q;
            if (j > 0) {
                bundle.putString("appId", String.valueOf(j));
            }
        }
        if (rVar != null && (str = rVar.f11355b) != null && rVar.f11369z > 0) {
            bundle.putString("updateOrigin", a5.e.a(str));
        }
        if (rVar == null || rVar.f11369z <= 0) {
            bundle.putInt("update", 0);
        } else {
            bundle.putInt("update", 1);
        }
        bundle.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "start");
        android.support.v4.media.g gVar = this.E;
        if (gVar != null) {
            gVar.E(bundle, "install");
        }
        LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this);
        v7.e eVar = o7.m0.f8288a;
        o7.c0.s(lifecycleScope, v7.d.f10884a, null, new b6.a(this, rVar, cVar, 4), 2);
    }

    public final void applyWindowInsets(View view) {
        view.getClass();
        ViewCompat.setOnApplyWindowInsetsListener(view, new c2.a(8));
    }

    public void b0(x4.d0 d0Var) {
        d0Var.getClass();
    }

    public void c0(x4.i0 i0Var) {
        i0Var.getClass();
    }

    public void d0(x4.u0 u0Var) {
        u0Var.getClass();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        if (motionEvent == null || motionEvent.getSource() != 8194) {
            return super.dispatchGenericMotionEvent(motionEvent);
        }
        return true;
    }

    public final void hideKeyboardOnScroll(final View view) {
        view.getClass();
        view.setOnScrollChangeListener(new View.OnScrollChangeListener() { // from class: c4.n
            @Override // android.view.View.OnScrollChangeListener
            public final void onScrollChange(View view2, int i, int i6, int i10, int i11) {
                if (i6 > i11) {
                    Object systemService = k0.this.getSystemService("input_method");
                    systemService.getClass();
                    ((InputMethodManager) systemService).hideSoftInputFromWindow(view.getWindowToken(), 0);
                }
            }
        });
    }

    public void i0(long j) {
        if (T()) {
            if (j <= 0) {
                k0();
                return;
            }
            LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this);
            v7.e eVar = o7.m0.f8288a;
            o7.c0.s(lifecycleScope, t7.n.f10348a, null, new x(this, j, null, 1), 2);
        }
    }

    public void j0(long j, String str) {
        if (T()) {
            LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this);
            v7.e eVar = o7.m0.f8288a;
            o7.c0.s(lifecycleScope, t7.n.f10348a, null, new j0(this, j, str, (t6.c) null, 0), 2);
        }
    }

    public final void k0() {
        if (isFinishing() || (f4.c.f4875o instanceof MyDownloads)) {
            return;
        }
        Intent intent = new Intent(this, (Class<?>) MyDownloads.class);
        float f = UptodownApp.I;
        startActivity(intent, b4.d.a(this));
    }

    public final void l0(String str) {
        if (str == null || isFinishing()) {
            return;
        }
        String w2 = androidx.lifecycle.l.w("https://www.virustotal.com/gui/file/", str, "/detection");
        String string = getString(2131952781);
        string.getClass();
        j5.c.e(this, w2, string);
    }

    public final void m0(LinearLayout linearLayout, ArrayList arrayList) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins((int) getResources().getDimension(2131166252), (int) getResources().getDimension(2131166251), 0, 0);
        List subList = arrayList.subList(0, Math.min(3, arrayList.size()));
        subList.getClass();
        for (Object obj : subList) {
            obj.getClass();
            x4.g1 g1Var = (x4.g1) obj;
            t4.t0 a8 = t4.t0.a(getLayoutInflater());
            TextView textView = a8.f10126l;
            TextView textView2 = a8.f10127m;
            View view = a8.f10125b;
            TextView textView3 = a8.f10128n;
            view.setLayoutParams(layoutParams);
            textView2.setTypeface(f4.c.f4882w);
            textView2.setText(g1Var.f11200b);
            textView.setTypeface(f4.c.f4883x);
            textView.setText(g1Var.f11199a);
            textView3.setTypeface(f4.c.f4882w);
            if (g1Var.f11201l == 1) {
                textView3.setText(getString(2131952505));
            } else if (g1Var.f11202m == 1) {
                textView3.setText(getString(2131951664));
            } else {
                a8.f10129o.setBackground(ContextCompat.getDrawable(this, 2131231252));
                textView3.setText(getString(2131952206));
                textView3.setTextColor(ContextCompat.getColor(this, 2131100824));
                textView3.setBackground(ContextCompat.getDrawable(this, 2131231194));
            }
            linearLayout.addView(view);
        }
    }

    public final void o0(int i, String str) {
        if (!com.google.android.gms.internal.measurement.z3.f2928c) {
            String string = getString(2131952001);
            string.getClass();
            A(string);
            return;
        }
        float f = UptodownApp.I;
        if (!b4.d.p(this, "downloadApkWorker")) {
            WorkManager.Companion.getInstance(this).enqueue(((OneTimeWorkRequest.Builder) androidx.lifecycle.l.t(DownloadApkWorker.class, "downloadApkWorker")).setInputData(new Data.Builder().putInt("downloadId", i).build()).build());
        } else {
            if (str == null || str.length() == 0) {
                return;
            }
            String string2 = getString(2131952261);
            string2.getClass();
            A(String.format(string2, Arrays.copyOf(new Object[]{str}, 1)));
        }
    }

    @Override // g4.h, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.E = new android.support.v4.media.g(this, 20);
        t6.c cVar = null;
        r7.k0.n(new r7.o(a5.d.f202b, new h0(this, cVar, 1)), LifecycleOwnerKt.getLifecycleScope(this));
        r7.k0.n(new r7.o(a5.d.f204d, new h0(this, cVar, 2)), LifecycleOwnerKt.getLifecycleScope(this));
        o7.c0.s(LifecycleOwnerKt.getLifecycleScope(this), null, null, new i0(this, null), 3);
    }

    @Override // g4.s0, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this);
        v7.e eVar = o7.m0.f8288a;
        o7.c0.s(lifecycleScope, v7.d.f10884a, null, new b0(this, null), 2);
        n0();
    }

    public void q0(File file) {
        file.getClass();
    }

    public boolean s0() {
        return !(this instanceof MyApps);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity
    public final void setContentView(int i) {
        super.setContentView(i);
        View findViewById = findViewById(R.id.content);
        if (findViewById != null) {
            applyWindowInsets(findViewById);
        }
    }

    public final void showKeyboard(View view) {
        view.getClass();
        Object systemService = getSystemService("input_method");
        systemService.getClass();
        ((InputMethodManager) systemService).showSoftInput(view.findFocus(), 1);
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01c9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void t0(x4.g r19, d7.a r20) {
        /*
            Method dump skipped, instructions count: 550
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c4.k0.t0(x4.g, d7.a):void");
    }

    public final void u0() {
        AlertDialog alertDialog = this.F;
        alertDialog.getClass();
        Window window = alertDialog.getWindow();
        if (window != null) {
            a4.x.y(window, 0);
        }
        AlertDialog alertDialog2 = this.F;
        alertDialog2.getClass();
        alertDialog2.show();
    }

    public void v0(long j) {
        String string = getString(2131951876, getString(2131951718));
        string.getClass();
        N(string);
    }

    public final void w0() {
        if (T()) {
            CustomTabsIntent build = new CustomTabsIntent.Builder().build();
            build.getClass();
            String H = d0.b.H(this);
            if (l7.m.q0(H, ".uptodown.com/", false)) {
                H = (l7.m.q0(H, "?", false) ? H.concat("&") : H.concat("?")).concat("userAgent=uptodownandroid");
            }
            build.intent.setData(Uri.parse(H));
            try {
                ActivityResultLauncher activityResultLauncher = this.K;
                activityResultLauncher.getClass();
                Intent intent = build.intent;
                float f = UptodownApp.I;
                activityResultLauncher.launch(intent, b4.d.b(this));
            } catch (Exception unused) {
                Intent intent2 = new Intent(this, (Class<?>) CustomWebView.class);
                if (getTitle() != null) {
                    intent2.putExtra("title", getTitle());
                }
                intent2.putExtra("url", H);
                float f10 = UptodownApp.I;
                startActivity(intent2, b4.d.a(this));
            }
        }
    }

    public void x0(x4.g gVar) {
        gVar.getClass();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(View view) {
        view.getClass();
        super.setContentView(view);
        applyWindowInsets(view);
    }

    public void g0() {
    }

    public void n0() {
    }

    @Override // g4.h
    public final void p() {
    }

    @Override // g4.h
    public final void q() {
    }

    @Override // g4.h
    public final void r() {
    }

    @Override // g4.h
    public void s() {
    }

    @Override // g4.h
    public void u() {
    }

    public void Y(String str) {
    }

    public void Z(String str) {
    }

    public void a0(String str) {
    }

    public void e0(String str) {
    }

    public void h0(String str) {
    }

    public void p0(File file) {
    }

    public void r0(File file) {
    }

    public void f0(String str, String str2) {
    }
}
