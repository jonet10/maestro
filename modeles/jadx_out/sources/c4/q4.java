package c4;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import com.uptodown.UptodownApp;
import com.uptodown.core.activities.FileExplorerActivity;
import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class q4 implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2011a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ w4 f2012b;

    public /* synthetic */ q4(w4 w4Var, int i) {
        this.f2011a = i;
        this.f2012b = w4Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.f2011a;
        boolean z9 = false;
        t6.c cVar = null;
        w4 w4Var = this.f2012b;
        switch (i) {
            case 0:
                AlertDialog alertDialog = w4Var.F;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                    return;
                }
                return;
            case 1:
                AlertDialog alertDialog2 = w4Var.F;
                alertDialog2.getClass();
                alertDialog2.dismiss();
                return;
            case 2:
                float f = UptodownApp.I;
                if (b4.d.t()) {
                    AlertDialog alertDialog3 = w4Var.F;
                    alertDialog3.getClass();
                    alertDialog3.dismiss();
                    return;
                }
                return;
            case 3:
                float f10 = UptodownApp.I;
                if (b4.d.t()) {
                    AlertDialog alertDialog4 = w4Var.F;
                    if (alertDialog4 != null) {
                        alertDialog4.dismiss();
                    }
                    w4Var.F = null;
                    return;
                }
                return;
            case 4:
                float f11 = UptodownApp.I;
                if (b4.d.t()) {
                    Intent intent = new Intent(w4Var, (Class<?>) FileExplorerActivity.class);
                    intent.putExtra("subdir", new h4.a(w4Var).b());
                    try {
                        SharedPreferences sharedPreferences = w4Var.getSharedPreferences("CoreSettings", 0);
                        if (sharedPreferences.contains("sdcard_as_backup_storage")) {
                            z9 = sharedPreferences.getBoolean("sdcard_as_backup_storage", false);
                        }
                    } catch (Exception unused) {
                    }
                    intent.putExtra("subdir_sd", z9);
                    w4Var.startActivity(intent);
                    AlertDialog alertDialog5 = w4Var.F;
                    if (alertDialog5 != null) {
                        alertDialog5.dismiss();
                    }
                    w4Var.F = null;
                    return;
                }
                return;
            case 5:
                float f12 = UptodownApp.I;
                if (b4.d.t()) {
                    o7.s1 s1Var = w4Var.S;
                    if (s1Var == null) {
                        kotlin.jvm.internal.l.i("jobBackup");
                        throw null;
                    }
                    s1Var.c(null);
                    AlertDialog alertDialog6 = w4Var.F;
                    if (alertDialog6 != null) {
                        alertDialog6.dismiss();
                    }
                    w4Var.F = null;
                    return;
                }
                return;
            case 6:
                AlertDialog alertDialog7 = w4Var.F;
                alertDialog7.getClass();
                alertDialog7.dismiss();
                w4Var.U = false;
                return;
            case 7:
                w4Var.Q();
                return;
            case 8:
                TextView textView = w4Var.f5184r;
                if (textView == null) {
                    kotlin.jvm.internal.l.i("tvErrorPath");
                    throw null;
                }
                if (textView.getVisibility() == 0) {
                    Animation loadAnimation = AnimationUtils.loadAnimation(w4Var.getApplicationContext(), 2130771992);
                    TextView textView2 = w4Var.f5184r;
                    if (textView2 != null) {
                        textView2.startAnimation(loadAnimation);
                        return;
                    } else {
                        kotlin.jvm.internal.l.i("tvErrorPath");
                        throw null;
                    }
                }
                Boolean bool = w4Var.f5185s;
                if (bool != null) {
                    boolean equals = bool.equals(Boolean.TRUE);
                    try {
                        SharedPreferences.Editor edit = w4Var.getSharedPreferences("CoreSettings", 0).edit();
                        edit.putBoolean("sdcard_as_backup_storage", equals);
                        edit.apply();
                    } catch (Exception e10) {
                        e10.printStackTrace();
                    }
                }
                String str = w4Var.f5186t;
                if (str != null) {
                    try {
                        SharedPreferences.Editor edit2 = w4Var.getSharedPreferences("CoreSettings", 0).edit();
                        edit2.putString("outputdir", str);
                        edit2.apply();
                    } catch (Exception e11) {
                        e11.printStackTrace();
                    }
                }
                h4.a aVar = new h4.a(w4Var);
                RadioButton radioButton = w4Var.f5178l;
                if (radioButton == null) {
                    kotlin.jvm.internal.l.i("rbAppName");
                    throw null;
                }
                aVar.e("app_name_included", radioButton.isChecked());
                RadioButton radioButton2 = w4Var.f5179m;
                if (radioButton2 == null) {
                    kotlin.jvm.internal.l.i("rbPackagename");
                    throw null;
                }
                aVar.e("packagename_included", radioButton2.isChecked());
                CheckBox checkBox = w4Var.f5181o;
                if (checkBox == null) {
                    kotlin.jvm.internal.l.i("cbVersioncode");
                    throw null;
                }
                aVar.e("versioncode_included", checkBox.isChecked());
                CheckBox checkBox2 = w4Var.f5182p;
                if (checkBox2 == null) {
                    kotlin.jvm.internal.l.i("cbVersionname");
                    throw null;
                }
                aVar.e("versionname_included", checkBox2.isChecked());
                RadioButton radioButton3 = w4Var.f5180n;
                if (radioButton3 == null) {
                    kotlin.jvm.internal.l.i("rbXapkExtension");
                    throw null;
                }
                aVar.h("xapk_extension", radioButton3.isChecked() ? ".xapk" : ".apks");
                AlertDialog alertDialog8 = w4Var.f5176a;
                if (alertDialog8 != null) {
                    alertDialog8.dismiss();
                }
                w4Var.f5176a = null;
                a2.t tVar = new a2.t(w4Var, new a3.d(w4Var, 9));
                ArrayList arrayList = w4Var.T;
                arrayList.getClass();
                v7.e eVar = o7.m0.f8288a;
                w4Var.S = o7.c0.s(o7.c0.b(v7.d.f10884a), null, null, new ya(tVar, arrayList, cVar, 16), 3);
                w4Var.T = new ArrayList();
                return;
            case 9:
                AlertDialog alertDialog9 = w4Var.f5176a;
                if (alertDialog9 != null) {
                    alertDialog9.dismiss();
                }
                w4Var.f5176a = null;
                return;
            default:
                Intent intent2 = new Intent(w4Var.getApplicationContext(), (Class<?>) FileExplorerActivity.class);
                intent2.putExtra("select_path", 1);
                w4Var.f5189x.launch(intent2);
                return;
        }
    }
}
