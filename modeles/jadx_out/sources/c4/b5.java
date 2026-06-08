package c4;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Environment;
import android.view.View;
import androidx.core.content.FileProvider;
import com.uptodown.UptodownApp;
import com.uptodown.activities.MyDownloads;
import java.io.File;
import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class b5 implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1416a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ kotlin.jvm.internal.x f1417b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ x4.r f1418l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ MyDownloads f1419m;

    public /* synthetic */ b5(kotlin.jvm.internal.x xVar, MyDownloads myDownloads, x4.r rVar) {
        this.f1416a = 2;
        this.f1417b = xVar;
        this.f1419m = myDownloads;
        this.f1418l = rVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        String str;
        String str2;
        int i = this.f1416a;
        boolean z9 = false;
        x4.r rVar = this.f1418l;
        MyDownloads myDownloads = this.f1419m;
        kotlin.jvm.internal.x xVar = this.f1417b;
        switch (i) {
            case 0:
                int i6 = MyDownloads.V;
                AlertDialog alertDialog = (AlertDialog) xVar.f7024a;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
                boolean a8 = kotlin.jvm.internal.l.a(rVar.f11355b, myDownloads.getPackageName());
                ArrayList arrayList = rVar.F;
                if (!a8) {
                    if (arrayList.size() == 1 && (str = ((x4.j0) rVar.F.get(0)).f11240q) != null && str.length() != 0) {
                        String str3 = ((x4.j0) rVar.F.get(0)).f11240q;
                        str3.getClass();
                        File file = new File(str3);
                        if (!file.exists()) {
                            String string = myDownloads.getString(2131952085);
                            string.getClass();
                            myDownloads.A(string);
                            break;
                        } else {
                            String name = file.getName();
                            name.getClass();
                            if (!l7.u.k0(name, ".xapk", true) && !l7.u.k0(name, ".apks", true) && !l7.u.k0(name, ".apkm", true) && !l7.u.k0(name, ".zip", true)) {
                                myDownloads.W(file, null);
                                break;
                            } else {
                                boolean n10 = e1.c0.n(file);
                                if (!e1.c0.g(file) || new File(a4.x.C(Environment.getExternalStorageDirectory().getAbsolutePath(), "/Android/obb/")).canWrite()) {
                                    z9 = n10;
                                } else if (myDownloads.m()) {
                                    myDownloads.v0(0L);
                                } else {
                                    myDownloads.y();
                                }
                                if (z9) {
                                    myDownloads.W(file, null);
                                    break;
                                }
                            }
                        }
                    } else {
                        File g = rVar.g();
                        if (g == null) {
                            String string2 = myDownloads.getString(2131952085);
                            string2.getClass();
                            myDownloads.A(string2);
                            break;
                        } else {
                            myDownloads.W(g, null);
                            break;
                        }
                    }
                } else if (!arrayList.isEmpty() && ((x4.j0) rVar.F.get(0)).f11240q != null) {
                    String str4 = ((x4.j0) rVar.F.get(0)).f11240q;
                    str4.getClass();
                    File file2 = new File(str4);
                    if (!file2.exists()) {
                        String string3 = myDownloads.getString(2131952085);
                        string3.getClass();
                        myDownloads.A(string3);
                        break;
                    } else {
                        PackageManager packageManager = myDownloads.getPackageManager();
                        packageManager.getClass();
                        String absolutePath = file2.getAbsolutePath();
                        absolutePath.getClass();
                        if (n4.i.d(packageManager, absolutePath, 128) != null) {
                            myDownloads.W(file2, null);
                            break;
                        } else {
                            String string4 = myDownloads.getString(2131952085);
                            string4.getClass();
                            myDownloads.A(string4);
                            break;
                        }
                    }
                } else {
                    String string5 = myDownloads.getString(2131952085);
                    string5.getClass();
                    myDownloads.A(string5);
                    break;
                }
                break;
            case 1:
                int i10 = MyDownloads.V;
                float f = UptodownApp.I;
                if (b4.d.t()) {
                    AlertDialog alertDialog2 = (AlertDialog) xVar.f7024a;
                    if (alertDialog2 != null) {
                        alertDialog2.dismiss();
                    }
                    if (rVar.c() && rVar.F.size() == 1 && (str2 = ((x4.j0) rVar.F.get(0)).f11240q) != null) {
                        Intent intent = new Intent("android.intent.action.SEND");
                        Uri uriForFile = FileProvider.getUriForFile(myDownloads, a4.x.C(myDownloads.getPackageName(), ".provider"), new File(str2));
                        intent.setType(myDownloads.getContentResolver().getType(uriForFile));
                        intent.putExtra("android.intent.extra.STREAM", uriForFile);
                        myDownloads.startActivity(Intent.createChooser(intent, myDownloads.getString(2131952097)));
                        break;
                    }
                }
                break;
            default:
                int i11 = MyDownloads.V;
                float f10 = UptodownApp.I;
                if (b4.d.t()) {
                    AlertDialog alertDialog3 = (AlertDialog) xVar.f7024a;
                    if (alertDialog3 != null) {
                        alertDialog3.dismiss();
                    }
                    myDownloads.i0(rVar.f11361q);
                    break;
                }
                break;
        }
    }

    public /* synthetic */ b5(kotlin.jvm.internal.x xVar, x4.r rVar, MyDownloads myDownloads, int i) {
        this.f1416a = i;
        this.f1417b = xVar;
        this.f1418l = rVar;
        this.f1419m = myDownloads;
    }
}
