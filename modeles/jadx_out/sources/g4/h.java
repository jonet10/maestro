package g4;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.documentfile.provider.DocumentFile;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import c4.sc;
import java.io.File;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class h extends AppCompatActivity {

    /* renamed from: a, reason: collision with root package name */
    public AlertDialog f5176a;

    /* renamed from: b, reason: collision with root package name */
    public TextView f5177b;

    /* renamed from: l, reason: collision with root package name */
    public RadioButton f5178l;

    /* renamed from: m, reason: collision with root package name */
    public RadioButton f5179m;

    /* renamed from: n, reason: collision with root package name */
    public RadioButton f5180n;

    /* renamed from: o, reason: collision with root package name */
    public CheckBox f5181o;

    /* renamed from: p, reason: collision with root package name */
    public CheckBox f5182p;

    /* renamed from: q, reason: collision with root package name */
    public TextView f5183q;

    /* renamed from: r, reason: collision with root package name */
    public TextView f5184r;

    /* renamed from: s, reason: collision with root package name */
    public Boolean f5185s;

    /* renamed from: t, reason: collision with root package name */
    public String f5186t;

    /* renamed from: u, reason: collision with root package name */
    public final ActivityResultLauncher f5187u;
    public final ActivityResultLauncher v;

    /* renamed from: w, reason: collision with root package name */
    public final ActivityResultLauncher f5188w;

    /* renamed from: x, reason: collision with root package name */
    public final ActivityResultLauncher f5189x;

    public h() {
        final int i = 0;
        ActivityResultLauncher registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback(this) { // from class: g4.c

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ h f5142b;

            {
                this.f5142b = this;
            }

            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                Bundle extras;
                Bundle extras2;
                Bundle extras3;
                int i6 = i;
                boolean z9 = false;
                h hVar = this.f5142b;
                ActivityResult activityResult = (ActivityResult) obj;
                switch (i6) {
                    case 0:
                        if (hVar.l()) {
                            hVar.u();
                            return;
                        } else {
                            hVar.s();
                            return;
                        }
                    case 1:
                        if (activityResult.getResultCode() == -1) {
                            Intent data = activityResult.getData();
                            Uri data2 = data != null ? data.getData() : null;
                            if (data2 == null) {
                                hVar.p();
                                return;
                            }
                            Intent data3 = activityResult.getData();
                            Integer valueOf = data3 != null ? Integer.valueOf(data3.getFlags()) : null;
                            if (valueOf != null) {
                                valueOf = Integer.valueOf(valueOf.intValue() & 3);
                            }
                            ContentResolver contentResolver = hVar.getContentResolver();
                            valueOf.getClass();
                            contentResolver.takePersistableUriPermission(data2, valueOf.intValue());
                            String path = data2.getPath();
                            if (path != null) {
                                Pattern compile = Pattern.compile(".*\\b[ABCDEF[0-9]][ABCDEF[0-9]][ABCDEF[0-9]][ABCDEF[0-9]]-[ABCDEF[0-9]][ABCDEF[0-9]][ABCDEF[0-9]][ABCDEF[0-9]]:.*");
                                compile.getClass();
                                z9 = compile.matcher(path).matches();
                            }
                            if (z9) {
                                hVar.q();
                                return;
                            } else {
                                hVar.r();
                                return;
                            }
                        }
                        return;
                    case 2:
                        hVar.w();
                        return;
                    default:
                        activityResult.getClass();
                        if (activityResult.getResultCode() == 145) {
                            Intent data4 = activityResult.getData();
                            hVar.f5186t = (data4 == null || (extras3 = data4.getExtras()) == null) ? null : extras3.getString("path_selected");
                            Intent data5 = activityResult.getData();
                            hVar.f5185s = (data5 == null || (extras2 = data5.getExtras()) == null) ? null : Boolean.valueOf(extras2.getBoolean("sdcard_selected"));
                            Intent data6 = activityResult.getData();
                            Uri data7 = data6 != null ? data6.getData() : null;
                            if (hVar.f5186t != null) {
                                String str = hVar.f5186t;
                                str.getClass();
                                File file = new File(str);
                                TextView textView = hVar.f5183q;
                                if (textView == null) {
                                    kotlin.jvm.internal.l.i("tvPath");
                                    throw null;
                                }
                                textView.setText(hVar.f5186t);
                                if (file.exists() && file.isDirectory() && file.canWrite()) {
                                    TextView textView2 = hVar.f5184r;
                                    if (textView2 != null) {
                                        textView2.setVisibility(8);
                                        return;
                                    } else {
                                        kotlin.jvm.internal.l.i("tvErrorPath");
                                        throw null;
                                    }
                                }
                                TextView textView3 = hVar.f5184r;
                                if (textView3 != null) {
                                    textView3.setVisibility(0);
                                    return;
                                } else {
                                    kotlin.jvm.internal.l.i("tvErrorPath");
                                    throw null;
                                }
                            }
                            if (data7 == null) {
                                TextView textView4 = hVar.f5184r;
                                if (textView4 != null) {
                                    textView4.setVisibility(0);
                                    return;
                                } else {
                                    kotlin.jvm.internal.l.i("tvErrorPath");
                                    throw null;
                                }
                            }
                            String lastPathSegment = data7.getLastPathSegment();
                            Intent data8 = activityResult.getData();
                            hVar.f5185s = (data8 == null || (extras = data8.getExtras()) == null) ? null : Boolean.valueOf(extras.getBoolean("sdcard_selected"));
                            hVar.f5186t = lastPathSegment != null ? lastPathSegment.substring(l7.m.A0(":", lastPathSegment, 6) + 1) : null;
                            boolean a8 = kotlin.jvm.internal.l.a(hVar.f5185s, Boolean.TRUE);
                            TextView textView5 = hVar.f5183q;
                            if (a8) {
                                if (textView5 == null) {
                                    kotlin.jvm.internal.l.i("tvPath");
                                    throw null;
                                }
                                textView5.setText(hVar.getString(2131952558) + "/" + hVar.f5186t);
                            } else {
                                if (textView5 == null) {
                                    kotlin.jvm.internal.l.i("tvPath");
                                    throw null;
                                }
                                textView5.setText(hVar.getString(2131952099) + "/" + hVar.f5186t);
                            }
                            DocumentFile fromSingleUri = DocumentFile.fromSingleUri(hVar, data7);
                            if (fromSingleUri != null && fromSingleUri.exists() && fromSingleUri.isDirectory() && fromSingleUri.canWrite()) {
                                TextView textView6 = hVar.f5184r;
                                if (textView6 != null) {
                                    textView6.setVisibility(8);
                                    return;
                                } else {
                                    kotlin.jvm.internal.l.i("tvErrorPath");
                                    throw null;
                                }
                            }
                            TextView textView7 = hVar.f5184r;
                            if (textView7 != null) {
                                textView7.setVisibility(0);
                                return;
                            } else {
                                kotlin.jvm.internal.l.i("tvErrorPath");
                                throw null;
                            }
                        }
                        return;
                }
            }
        });
        registerForActivityResult.getClass();
        this.f5187u = registerForActivityResult;
        final int i6 = 1;
        ActivityResultLauncher registerForActivityResult2 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback(this) { // from class: g4.c

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ h f5142b;

            {
                this.f5142b = this;
            }

            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                Bundle extras;
                Bundle extras2;
                Bundle extras3;
                int i62 = i6;
                boolean z9 = false;
                h hVar = this.f5142b;
                ActivityResult activityResult = (ActivityResult) obj;
                switch (i62) {
                    case 0:
                        if (hVar.l()) {
                            hVar.u();
                            return;
                        } else {
                            hVar.s();
                            return;
                        }
                    case 1:
                        if (activityResult.getResultCode() == -1) {
                            Intent data = activityResult.getData();
                            Uri data2 = data != null ? data.getData() : null;
                            if (data2 == null) {
                                hVar.p();
                                return;
                            }
                            Intent data3 = activityResult.getData();
                            Integer valueOf = data3 != null ? Integer.valueOf(data3.getFlags()) : null;
                            if (valueOf != null) {
                                valueOf = Integer.valueOf(valueOf.intValue() & 3);
                            }
                            ContentResolver contentResolver = hVar.getContentResolver();
                            valueOf.getClass();
                            contentResolver.takePersistableUriPermission(data2, valueOf.intValue());
                            String path = data2.getPath();
                            if (path != null) {
                                Pattern compile = Pattern.compile(".*\\b[ABCDEF[0-9]][ABCDEF[0-9]][ABCDEF[0-9]][ABCDEF[0-9]]-[ABCDEF[0-9]][ABCDEF[0-9]][ABCDEF[0-9]][ABCDEF[0-9]]:.*");
                                compile.getClass();
                                z9 = compile.matcher(path).matches();
                            }
                            if (z9) {
                                hVar.q();
                                return;
                            } else {
                                hVar.r();
                                return;
                            }
                        }
                        return;
                    case 2:
                        hVar.w();
                        return;
                    default:
                        activityResult.getClass();
                        if (activityResult.getResultCode() == 145) {
                            Intent data4 = activityResult.getData();
                            hVar.f5186t = (data4 == null || (extras3 = data4.getExtras()) == null) ? null : extras3.getString("path_selected");
                            Intent data5 = activityResult.getData();
                            hVar.f5185s = (data5 == null || (extras2 = data5.getExtras()) == null) ? null : Boolean.valueOf(extras2.getBoolean("sdcard_selected"));
                            Intent data6 = activityResult.getData();
                            Uri data7 = data6 != null ? data6.getData() : null;
                            if (hVar.f5186t != null) {
                                String str = hVar.f5186t;
                                str.getClass();
                                File file = new File(str);
                                TextView textView = hVar.f5183q;
                                if (textView == null) {
                                    kotlin.jvm.internal.l.i("tvPath");
                                    throw null;
                                }
                                textView.setText(hVar.f5186t);
                                if (file.exists() && file.isDirectory() && file.canWrite()) {
                                    TextView textView2 = hVar.f5184r;
                                    if (textView2 != null) {
                                        textView2.setVisibility(8);
                                        return;
                                    } else {
                                        kotlin.jvm.internal.l.i("tvErrorPath");
                                        throw null;
                                    }
                                }
                                TextView textView3 = hVar.f5184r;
                                if (textView3 != null) {
                                    textView3.setVisibility(0);
                                    return;
                                } else {
                                    kotlin.jvm.internal.l.i("tvErrorPath");
                                    throw null;
                                }
                            }
                            if (data7 == null) {
                                TextView textView4 = hVar.f5184r;
                                if (textView4 != null) {
                                    textView4.setVisibility(0);
                                    return;
                                } else {
                                    kotlin.jvm.internal.l.i("tvErrorPath");
                                    throw null;
                                }
                            }
                            String lastPathSegment = data7.getLastPathSegment();
                            Intent data8 = activityResult.getData();
                            hVar.f5185s = (data8 == null || (extras = data8.getExtras()) == null) ? null : Boolean.valueOf(extras.getBoolean("sdcard_selected"));
                            hVar.f5186t = lastPathSegment != null ? lastPathSegment.substring(l7.m.A0(":", lastPathSegment, 6) + 1) : null;
                            boolean a8 = kotlin.jvm.internal.l.a(hVar.f5185s, Boolean.TRUE);
                            TextView textView5 = hVar.f5183q;
                            if (a8) {
                                if (textView5 == null) {
                                    kotlin.jvm.internal.l.i("tvPath");
                                    throw null;
                                }
                                textView5.setText(hVar.getString(2131952558) + "/" + hVar.f5186t);
                            } else {
                                if (textView5 == null) {
                                    kotlin.jvm.internal.l.i("tvPath");
                                    throw null;
                                }
                                textView5.setText(hVar.getString(2131952099) + "/" + hVar.f5186t);
                            }
                            DocumentFile fromSingleUri = DocumentFile.fromSingleUri(hVar, data7);
                            if (fromSingleUri != null && fromSingleUri.exists() && fromSingleUri.isDirectory() && fromSingleUri.canWrite()) {
                                TextView textView6 = hVar.f5184r;
                                if (textView6 != null) {
                                    textView6.setVisibility(8);
                                    return;
                                } else {
                                    kotlin.jvm.internal.l.i("tvErrorPath");
                                    throw null;
                                }
                            }
                            TextView textView7 = hVar.f5184r;
                            if (textView7 != null) {
                                textView7.setVisibility(0);
                                return;
                            } else {
                                kotlin.jvm.internal.l.i("tvErrorPath");
                                throw null;
                            }
                        }
                        return;
                }
            }
        });
        registerForActivityResult2.getClass();
        this.v = registerForActivityResult2;
        final int i10 = 2;
        ActivityResultLauncher registerForActivityResult3 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback(this) { // from class: g4.c

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ h f5142b;

            {
                this.f5142b = this;
            }

            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                Bundle extras;
                Bundle extras2;
                Bundle extras3;
                int i62 = i10;
                boolean z9 = false;
                h hVar = this.f5142b;
                ActivityResult activityResult = (ActivityResult) obj;
                switch (i62) {
                    case 0:
                        if (hVar.l()) {
                            hVar.u();
                            return;
                        } else {
                            hVar.s();
                            return;
                        }
                    case 1:
                        if (activityResult.getResultCode() == -1) {
                            Intent data = activityResult.getData();
                            Uri data2 = data != null ? data.getData() : null;
                            if (data2 == null) {
                                hVar.p();
                                return;
                            }
                            Intent data3 = activityResult.getData();
                            Integer valueOf = data3 != null ? Integer.valueOf(data3.getFlags()) : null;
                            if (valueOf != null) {
                                valueOf = Integer.valueOf(valueOf.intValue() & 3);
                            }
                            ContentResolver contentResolver = hVar.getContentResolver();
                            valueOf.getClass();
                            contentResolver.takePersistableUriPermission(data2, valueOf.intValue());
                            String path = data2.getPath();
                            if (path != null) {
                                Pattern compile = Pattern.compile(".*\\b[ABCDEF[0-9]][ABCDEF[0-9]][ABCDEF[0-9]][ABCDEF[0-9]]-[ABCDEF[0-9]][ABCDEF[0-9]][ABCDEF[0-9]][ABCDEF[0-9]]:.*");
                                compile.getClass();
                                z9 = compile.matcher(path).matches();
                            }
                            if (z9) {
                                hVar.q();
                                return;
                            } else {
                                hVar.r();
                                return;
                            }
                        }
                        return;
                    case 2:
                        hVar.w();
                        return;
                    default:
                        activityResult.getClass();
                        if (activityResult.getResultCode() == 145) {
                            Intent data4 = activityResult.getData();
                            hVar.f5186t = (data4 == null || (extras3 = data4.getExtras()) == null) ? null : extras3.getString("path_selected");
                            Intent data5 = activityResult.getData();
                            hVar.f5185s = (data5 == null || (extras2 = data5.getExtras()) == null) ? null : Boolean.valueOf(extras2.getBoolean("sdcard_selected"));
                            Intent data6 = activityResult.getData();
                            Uri data7 = data6 != null ? data6.getData() : null;
                            if (hVar.f5186t != null) {
                                String str = hVar.f5186t;
                                str.getClass();
                                File file = new File(str);
                                TextView textView = hVar.f5183q;
                                if (textView == null) {
                                    kotlin.jvm.internal.l.i("tvPath");
                                    throw null;
                                }
                                textView.setText(hVar.f5186t);
                                if (file.exists() && file.isDirectory() && file.canWrite()) {
                                    TextView textView2 = hVar.f5184r;
                                    if (textView2 != null) {
                                        textView2.setVisibility(8);
                                        return;
                                    } else {
                                        kotlin.jvm.internal.l.i("tvErrorPath");
                                        throw null;
                                    }
                                }
                                TextView textView3 = hVar.f5184r;
                                if (textView3 != null) {
                                    textView3.setVisibility(0);
                                    return;
                                } else {
                                    kotlin.jvm.internal.l.i("tvErrorPath");
                                    throw null;
                                }
                            }
                            if (data7 == null) {
                                TextView textView4 = hVar.f5184r;
                                if (textView4 != null) {
                                    textView4.setVisibility(0);
                                    return;
                                } else {
                                    kotlin.jvm.internal.l.i("tvErrorPath");
                                    throw null;
                                }
                            }
                            String lastPathSegment = data7.getLastPathSegment();
                            Intent data8 = activityResult.getData();
                            hVar.f5185s = (data8 == null || (extras = data8.getExtras()) == null) ? null : Boolean.valueOf(extras.getBoolean("sdcard_selected"));
                            hVar.f5186t = lastPathSegment != null ? lastPathSegment.substring(l7.m.A0(":", lastPathSegment, 6) + 1) : null;
                            boolean a8 = kotlin.jvm.internal.l.a(hVar.f5185s, Boolean.TRUE);
                            TextView textView5 = hVar.f5183q;
                            if (a8) {
                                if (textView5 == null) {
                                    kotlin.jvm.internal.l.i("tvPath");
                                    throw null;
                                }
                                textView5.setText(hVar.getString(2131952558) + "/" + hVar.f5186t);
                            } else {
                                if (textView5 == null) {
                                    kotlin.jvm.internal.l.i("tvPath");
                                    throw null;
                                }
                                textView5.setText(hVar.getString(2131952099) + "/" + hVar.f5186t);
                            }
                            DocumentFile fromSingleUri = DocumentFile.fromSingleUri(hVar, data7);
                            if (fromSingleUri != null && fromSingleUri.exists() && fromSingleUri.isDirectory() && fromSingleUri.canWrite()) {
                                TextView textView6 = hVar.f5184r;
                                if (textView6 != null) {
                                    textView6.setVisibility(8);
                                    return;
                                } else {
                                    kotlin.jvm.internal.l.i("tvErrorPath");
                                    throw null;
                                }
                            }
                            TextView textView7 = hVar.f5184r;
                            if (textView7 != null) {
                                textView7.setVisibility(0);
                                return;
                            } else {
                                kotlin.jvm.internal.l.i("tvErrorPath");
                                throw null;
                            }
                        }
                        return;
                }
            }
        });
        registerForActivityResult3.getClass();
        this.f5188w = registerForActivityResult3;
        final int i11 = 3;
        ActivityResultLauncher registerForActivityResult4 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback(this) { // from class: g4.c

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ h f5142b;

            {
                this.f5142b = this;
            }

            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                Bundle extras;
                Bundle extras2;
                Bundle extras3;
                int i62 = i11;
                boolean z9 = false;
                h hVar = this.f5142b;
                ActivityResult activityResult = (ActivityResult) obj;
                switch (i62) {
                    case 0:
                        if (hVar.l()) {
                            hVar.u();
                            return;
                        } else {
                            hVar.s();
                            return;
                        }
                    case 1:
                        if (activityResult.getResultCode() == -1) {
                            Intent data = activityResult.getData();
                            Uri data2 = data != null ? data.getData() : null;
                            if (data2 == null) {
                                hVar.p();
                                return;
                            }
                            Intent data3 = activityResult.getData();
                            Integer valueOf = data3 != null ? Integer.valueOf(data3.getFlags()) : null;
                            if (valueOf != null) {
                                valueOf = Integer.valueOf(valueOf.intValue() & 3);
                            }
                            ContentResolver contentResolver = hVar.getContentResolver();
                            valueOf.getClass();
                            contentResolver.takePersistableUriPermission(data2, valueOf.intValue());
                            String path = data2.getPath();
                            if (path != null) {
                                Pattern compile = Pattern.compile(".*\\b[ABCDEF[0-9]][ABCDEF[0-9]][ABCDEF[0-9]][ABCDEF[0-9]]-[ABCDEF[0-9]][ABCDEF[0-9]][ABCDEF[0-9]][ABCDEF[0-9]]:.*");
                                compile.getClass();
                                z9 = compile.matcher(path).matches();
                            }
                            if (z9) {
                                hVar.q();
                                return;
                            } else {
                                hVar.r();
                                return;
                            }
                        }
                        return;
                    case 2:
                        hVar.w();
                        return;
                    default:
                        activityResult.getClass();
                        if (activityResult.getResultCode() == 145) {
                            Intent data4 = activityResult.getData();
                            hVar.f5186t = (data4 == null || (extras3 = data4.getExtras()) == null) ? null : extras3.getString("path_selected");
                            Intent data5 = activityResult.getData();
                            hVar.f5185s = (data5 == null || (extras2 = data5.getExtras()) == null) ? null : Boolean.valueOf(extras2.getBoolean("sdcard_selected"));
                            Intent data6 = activityResult.getData();
                            Uri data7 = data6 != null ? data6.getData() : null;
                            if (hVar.f5186t != null) {
                                String str = hVar.f5186t;
                                str.getClass();
                                File file = new File(str);
                                TextView textView = hVar.f5183q;
                                if (textView == null) {
                                    kotlin.jvm.internal.l.i("tvPath");
                                    throw null;
                                }
                                textView.setText(hVar.f5186t);
                                if (file.exists() && file.isDirectory() && file.canWrite()) {
                                    TextView textView2 = hVar.f5184r;
                                    if (textView2 != null) {
                                        textView2.setVisibility(8);
                                        return;
                                    } else {
                                        kotlin.jvm.internal.l.i("tvErrorPath");
                                        throw null;
                                    }
                                }
                                TextView textView3 = hVar.f5184r;
                                if (textView3 != null) {
                                    textView3.setVisibility(0);
                                    return;
                                } else {
                                    kotlin.jvm.internal.l.i("tvErrorPath");
                                    throw null;
                                }
                            }
                            if (data7 == null) {
                                TextView textView4 = hVar.f5184r;
                                if (textView4 != null) {
                                    textView4.setVisibility(0);
                                    return;
                                } else {
                                    kotlin.jvm.internal.l.i("tvErrorPath");
                                    throw null;
                                }
                            }
                            String lastPathSegment = data7.getLastPathSegment();
                            Intent data8 = activityResult.getData();
                            hVar.f5185s = (data8 == null || (extras = data8.getExtras()) == null) ? null : Boolean.valueOf(extras.getBoolean("sdcard_selected"));
                            hVar.f5186t = lastPathSegment != null ? lastPathSegment.substring(l7.m.A0(":", lastPathSegment, 6) + 1) : null;
                            boolean a8 = kotlin.jvm.internal.l.a(hVar.f5185s, Boolean.TRUE);
                            TextView textView5 = hVar.f5183q;
                            if (a8) {
                                if (textView5 == null) {
                                    kotlin.jvm.internal.l.i("tvPath");
                                    throw null;
                                }
                                textView5.setText(hVar.getString(2131952558) + "/" + hVar.f5186t);
                            } else {
                                if (textView5 == null) {
                                    kotlin.jvm.internal.l.i("tvPath");
                                    throw null;
                                }
                                textView5.setText(hVar.getString(2131952099) + "/" + hVar.f5186t);
                            }
                            DocumentFile fromSingleUri = DocumentFile.fromSingleUri(hVar, data7);
                            if (fromSingleUri != null && fromSingleUri.exists() && fromSingleUri.isDirectory() && fromSingleUri.canWrite()) {
                                TextView textView6 = hVar.f5184r;
                                if (textView6 != null) {
                                    textView6.setVisibility(8);
                                    return;
                                } else {
                                    kotlin.jvm.internal.l.i("tvErrorPath");
                                    throw null;
                                }
                            }
                            TextView textView7 = hVar.f5184r;
                            if (textView7 != null) {
                                textView7.setVisibility(0);
                                return;
                            } else {
                                kotlin.jvm.internal.l.i("tvErrorPath");
                                throw null;
                            }
                        }
                        return;
                }
            }
        });
        registerForActivityResult4.getClass();
        this.f5189x = registerForActivityResult4;
    }

    public final void A(String str) {
        str.getClass();
        LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this);
        v7.e eVar = o7.m0.f8288a;
        o7.c0.s(lifecycleScope, t7.n.f10348a, null, new sc(this, str, null, 6), 2);
    }

    public final void B(String str, String str2, long j, String str3, boolean z9) {
        String concat;
        String str4;
        long j6;
        RadioButton radioButton = this.f5178l;
        if (radioButton == null) {
            kotlin.jvm.internal.l.i("rbAppName");
            throw null;
        }
        if (radioButton.isChecked()) {
            if (str == null) {
                str = getString(2131951718);
                str.getClass();
            }
        } else if (str2 != null) {
            str = str2;
        } else {
            str = getPackageName();
            str.getClass();
        }
        CheckBox checkBox = this.f5181o;
        if (checkBox == null) {
            kotlin.jvm.internal.l.i("cbVersioncode");
            throw null;
        }
        if (checkBox.isChecked()) {
            if (j > -1) {
                str = str + "_" + j;
            } else {
                try {
                    PackageManager packageManager = getPackageManager();
                    packageManager.getClass();
                    String packageName = getPackageName();
                    packageName.getClass();
                    j6 = n4.d.d(n4.i.e(packageManager, packageName, 0));
                } catch (PackageManager.NameNotFoundException e10) {
                    e10.printStackTrace();
                    j6 = 0;
                }
                str = str + "_" + j6;
            }
        }
        CheckBox checkBox2 = this.f5182p;
        if (checkBox2 == null) {
            kotlin.jvm.internal.l.i("cbVersionname");
            throw null;
        }
        if (checkBox2.isChecked()) {
            if (str3 != null) {
                str = a4.x.k(str, "_", str3);
            } else {
                try {
                    PackageManager packageManager2 = getPackageManager();
                    packageManager2.getClass();
                    String packageName2 = getPackageName();
                    packageName2.getClass();
                    str4 = n4.i.e(packageManager2, packageName2, 0).versionName;
                } catch (PackageManager.NameNotFoundException e11) {
                    e11.printStackTrace();
                    str4 = null;
                }
                str = a4.x.k(str, "_", str4);
            }
        }
        if (z9) {
            RadioButton radioButton2 = this.f5180n;
            if (radioButton2 == null) {
                kotlin.jvm.internal.l.i("rbXapkExtension");
                throw null;
            }
            concat = radioButton2.isChecked() ? str.concat(".xapk") : str.concat(".apks");
        } else {
            concat = str.concat(".apk");
        }
        TextView textView = this.f5177b;
        if (textView != null) {
            textView.setText(concat);
        } else {
            kotlin.jvm.internal.l.i("tvResult");
            throw null;
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public final void attachBaseContext(Context context) {
        if (context != null) {
            Activity activity = f4.c.f4875o;
            context = t0.f.e(context);
        }
        super.attachBaseContext(context);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x02d0  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x007f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void h(final java.lang.String r23, final java.lang.String r24, final long r25, final java.lang.String r27, final boolean r28) {
        /*
            Method dump skipped, instructions count: 730
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: g4.h.h(java.lang.String, java.lang.String, long, java.lang.String, boolean):void");
    }

    public final void i(String str) {
        AlertDialog alertDialog = this.f5176a;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        View inflate = getLayoutInflater().inflate(2131558486, (ViewGroup) null, false);
        TextView textView = (TextView) inflate.findViewById(2131363807);
        textView.setTypeface(f4.c.f4883x);
        if (str == null) {
            textView.setText(getString(2131952007));
        } else {
            textView.setText(str);
        }
        TextView textView2 = (TextView) inflate.findViewById(2131363606);
        textView2.setTypeface(f4.c.f4882w);
        textView2.setOnClickListener(new f(this, 2));
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(inflate);
        builder.setCancelable(false);
        this.f5176a = builder.create();
        if (isFinishing()) {
            return;
        }
        AlertDialog alertDialog2 = this.f5176a;
        alertDialog2.getClass();
        Window window = alertDialog2.getWindow();
        if (window != null) {
            a4.x.y(window, 0);
        }
        AlertDialog alertDialog3 = this.f5176a;
        alertDialog3.getClass();
        alertDialog3.show();
    }

    public final void j() {
        try {
            if (m()) {
                return;
            }
            AlertDialog alertDialog = this.f5176a;
            if (alertDialog != null) {
                alertDialog.dismiss();
            }
            View inflate = getLayoutInflater().inflate(2131558535, (ViewGroup) null, false);
            TextView textView = (TextView) inflate.findViewById(2131363817);
            textView.setTypeface(f4.c.f4882w);
            textView.setText(getString(2131952655, getString(2131951718)));
            TextView textView2 = (TextView) inflate.findViewById(2131363814);
            textView2.setTypeface(f4.c.f4883x);
            textView2.setText(getString(2131952274, getString(2131951718)));
            TextView textView3 = (TextView) inflate.findViewById(2131363606);
            textView3.setTypeface(f4.c.f4882w);
            textView3.setOnClickListener(new f(this, 0));
            TextView textView4 = (TextView) inflate.findViewById(2131363700);
            textView4.setTypeface(f4.c.f4882w);
            textView4.setOnClickListener(new f(this, 1));
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setView(inflate);
            AlertDialog create = builder.create();
            this.f5176a = create;
            create.getClass();
            Window window = create.getWindow();
            if (window != null) {
                window.setBackgroundDrawable(new ColorDrawable(0));
            }
            if (isFinishing()) {
                return;
            }
            AlertDialog alertDialog2 = this.f5176a;
            alertDialog2.getClass();
            alertDialog2.show();
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public final boolean k() {
        return Build.VERSION.SDK_INT >= 33 || ContextCompat.checkSelfPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }

    public final boolean l() {
        return Build.VERSION.SDK_INT >= 30 ? Environment.isExternalStorageManager() : k();
    }

    public final boolean m() {
        return Build.VERSION.SDK_INT < 26 ? Settings.Secure.getInt(getContentResolver(), "install_non_market_apps", 0) == 1 : getPackageManager().canRequestPackageInstalls();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!f4.c.f4878r) {
            f4.c.f4878r = true;
            Configuration configuration = getResources().getConfiguration();
            f4.c.f4877q = (configuration.screenLayout & 15) >= 3 && configuration.smallestScreenWidthDp >= 600;
        }
        if (f4.c.f4877q) {
            setRequestedOrientation(-1);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        strArr.getClass();
        iArr.getClass();
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == 645) {
            if (iArr.length != 0 && iArr[0] == 0) {
                v();
                return;
            } else {
                t();
                return;
            }
        }
        if (i != 646) {
            return;
        }
        if (iArr.length != 0 && iArr[0] == 0) {
            o();
        } else {
            n();
        }
    }

    public abstract void p();

    public abstract void q();

    public abstract void r();

    public abstract void s();

    public abstract void u();

    public final void x() {
        ActivityCompat.requestPermissions(this, new String[]{"android.permission.POST_NOTIFICATIONS"}, 646);
        try {
            SharedPreferences.Editor edit = getSharedPreferences("CoreSettings", 0).edit();
            edit.putBoolean("notification_permission_request", true);
            edit.apply();
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public final void y() {
        try {
            int i = Build.VERSION.SDK_INT;
            ActivityResultLauncher activityResultLauncher = this.f5188w;
            if (i < 26) {
                activityResultLauncher.launch(new Intent("android.settings.SECURITY_SETTINGS"));
                return;
            }
            activityResultLauncher.launch(new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES", Uri.parse("package:" + getPackageName())));
        } catch (ActivityNotFoundException e10) {
            e10.printStackTrace();
        }
    }

    public final void z() {
        if (Build.VERSION.SDK_INT < 30) {
            if (k()) {
                return;
            }
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 645);
        } else {
            if (Environment.isExternalStorageManager()) {
                if (k()) {
                    return;
                }
                ActivityCompat.requestPermissions(this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 645);
                return;
            }
            try {
                this.f5187u.launch(new Intent("android.settings.MANAGE_APP_ALL_FILES_ACCESS_PERMISSION", Uri.parse("package:" + getPackageName())));
            } catch (ActivityNotFoundException e10) {
                e10.printStackTrace();
                ActivityCompat.requestPermissions(this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 645);
            }
        }
    }

    public void n() {
    }

    public void o() {
    }

    public void t() {
    }

    public void v() {
    }

    public void w() {
    }
}
