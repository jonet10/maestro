package c4;

import android.app.AlertDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.system.Os;
import android.system.StructStatVfs;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.documentfile.provider.DocumentFile;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import com.uptodown.UptodownApp;
import com.uptodown.activities.MainActivity;
import com.uptodown.activities.MyDownloads;
import com.uptodown.activities.preferences.PreferencesActivity;
import com.uptodown.core.activities.FileExplorerActivity;
import java.io.File;
import java.util.HashMap;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class y2 implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2332a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f2333b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Object f2334l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Object f2335m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ Object f2336n;

    public /* synthetic */ y2(Object obj, Object obj2, Object obj3, Object obj4, int i) {
        this.f2332a = i;
        this.f2333b = obj;
        this.f2334l = obj2;
        this.f2335m = obj3;
        this.f2336n = obj4;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.f2332a;
        Object obj = this.f2336n;
        Object obj2 = this.f2335m;
        Object obj3 = this.f2334l;
        Object obj4 = this.f2333b;
        switch (i) {
            case 0:
                MainActivity mainActivity = (MainActivity) obj4;
                int i6 = MainActivity.G0;
                mainActivity.K(((x4.g) obj3).O, new androidx.room.c((TextView) obj2, mainActivity, (RelativeLayout) obj, 4), new androidx.room.g(mainActivity, 22));
                break;
            case 1:
                kotlin.jvm.internal.x xVar = (kotlin.jvm.internal.x) obj4;
                MyDownloads myDownloads = (MyDownloads) obj3;
                kotlin.jvm.internal.x xVar2 = (kotlin.jvm.internal.x) obj2;
                kotlin.jvm.internal.x xVar3 = (kotlin.jvm.internal.x) obj;
                int i10 = MyDownloads.V;
                float f = UptodownApp.I;
                if (b4.d.t()) {
                    Object obj5 = xVar.f7024a;
                    obj5.getClass();
                    String str = ((x4.j0) obj5).f11240q;
                    str.getClass();
                    File file = new File(str);
                    String str2 = (String) xVar2.f7024a;
                    str2.getClass();
                    LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(myDownloads);
                    v7.e eVar = o7.m0.f8288a;
                    o7.c0.s(lifecycleScope, t7.n.f10348a, null, new b5.j(myDownloads, str2, file, null, 2), 2);
                }
                AlertDialog alertDialog = (AlertDialog) xVar3.f7024a;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                    break;
                }
                break;
            case 2:
                PreferencesActivity preferencesActivity = (PreferencesActivity) obj4;
                int i11 = PreferencesActivity.T;
                String string = preferencesActivity.getString(2131952576);
                string.getClass();
                preferencesActivity.y0(string, (HashMap) obj3, ((kotlin.jvm.internal.v) obj2).f7022a, new androidx.work.impl.model.a(8, preferencesActivity, (b5.m) obj));
                break;
            default:
                FileExplorerActivity fileExplorerActivity = (FileExplorerActivity) obj3;
                kotlin.jvm.internal.x xVar4 = (kotlin.jvm.internal.x) obj2;
                g4.v vVar = (g4.v) obj;
                long j = 0;
                if (!(obj4 instanceof File)) {
                    if (!(obj4 instanceof DocumentFile)) {
                        int i12 = FileExplorerActivity.f3379q0;
                        break;
                    } else if (fileExplorerActivity.f3389k0 == null) {
                        if (fileExplorerActivity.f3388j0 == null) {
                            DocumentFile documentFile = fileExplorerActivity.Y;
                            if (documentFile == null) {
                                File file2 = fileExplorerActivity.f3381c0;
                                if (file2 != null) {
                                    String absolutePath = file2.getAbsolutePath();
                                    absolutePath.getClass();
                                    v7.e eVar2 = o7.m0.f8288a;
                                    xVar4.f7024a = o7.c0.s(o7.c0.b(v7.d.f10884a), null, null, new b.m((DocumentFile) obj4, absolutePath, vVar, fileExplorerActivity, (t6.c) null, 11), 3);
                                    break;
                                }
                            } else {
                                Uri uri = documentFile.getUri();
                                uri.getClass();
                                v7.e eVar3 = o7.m0.f8288a;
                                xVar4.f7024a = o7.c0.s(o7.c0.b(v7.d.f10884a), null, null, new b.m((DocumentFile) obj4, uri, vVar, fileExplorerActivity, (t6.c) null, 12), 3);
                                break;
                            }
                        } else {
                            Context applicationContext = fileExplorerActivity.getApplicationContext();
                            applicationContext.getClass();
                            Uri uri2 = fileExplorerActivity.f3388j0;
                            uri2.getClass();
                            try {
                                ParcelFileDescriptor openFileDescriptor = applicationContext.getContentResolver().openFileDescriptor(uri2, "r");
                                if (openFileDescriptor != null) {
                                    StructStatVfs fstatvfs = Os.fstatvfs(openFileDescriptor.getFileDescriptor());
                                    j = fstatvfs.f_bsize * fstatvfs.f_bavail;
                                    openFileDescriptor.close();
                                }
                            } catch (Exception e10) {
                                e10.printStackTrace();
                            }
                            DocumentFile documentFile2 = (DocumentFile) obj4;
                            if (j > documentFile2.length() * 2) {
                                Uri uri3 = fileExplorerActivity.f3388j0;
                                uri3.getClass();
                                v7.e eVar4 = o7.m0.f8288a;
                                xVar4.f7024a = o7.c0.s(o7.c0.b(v7.d.f10884a), null, null, new b.m(documentFile2, uri3, vVar, fileExplorerActivity, (t6.c) null, 12), 3);
                                break;
                            }
                        }
                    } else {
                        File file3 = fileExplorerActivity.f3381c0;
                        if (file3 == null) {
                            File externalStorageDirectory = Environment.getExternalStorageDirectory();
                            if (externalStorageDirectory != null) {
                                j = externalStorageDirectory.getUsableSpace();
                            }
                        } else {
                            j = file3.getUsableSpace();
                        }
                        DocumentFile documentFile3 = (DocumentFile) obj4;
                        if (j > documentFile3.length() * 2) {
                            String str3 = fileExplorerActivity.f3389k0;
                            str3.getClass();
                            v7.e eVar5 = o7.m0.f8288a;
                            xVar4.f7024a = o7.c0.s(o7.c0.b(v7.d.f10884a), null, null, new b.m(documentFile3, str3, vVar, fileExplorerActivity, (t6.c) null, 11), 3);
                            break;
                        }
                    }
                } else if (fileExplorerActivity.f3389k0 == null) {
                    if (fileExplorerActivity.f3388j0 != null) {
                        Context applicationContext2 = fileExplorerActivity.getApplicationContext();
                        applicationContext2.getClass();
                        Uri uri4 = fileExplorerActivity.f3388j0;
                        uri4.getClass();
                        try {
                            ParcelFileDescriptor openFileDescriptor2 = applicationContext2.getContentResolver().openFileDescriptor(uri4, "r");
                            if (openFileDescriptor2 != null) {
                                StructStatVfs fstatvfs2 = Os.fstatvfs(openFileDescriptor2.getFileDescriptor());
                                j = fstatvfs2.f_bsize * fstatvfs2.f_bavail;
                                openFileDescriptor2.close();
                            }
                        } catch (Exception e11) {
                            e11.printStackTrace();
                        }
                        File file4 = (File) obj4;
                        if (j > file4.length() * 2) {
                            Uri uri5 = fileExplorerActivity.f3388j0;
                            uri5.getClass();
                            v7.e eVar6 = o7.m0.f8288a;
                            xVar4.f7024a = o7.c0.s(o7.c0.b(v7.d.f10884a), null, null, new b.m(file4, uri5, vVar, fileExplorerActivity, (t6.c) null, 10), 3);
                            break;
                        }
                    }
                } else {
                    File file5 = fileExplorerActivity.f3381c0;
                    Long valueOf = file5 != null ? Long.valueOf(file5.getUsableSpace()) : null;
                    valueOf.getClass();
                    File file6 = (File) obj4;
                    if (valueOf.longValue() > file6.length() * 2) {
                        String str4 = fileExplorerActivity.f3389k0;
                        str4.getClass();
                        v7.e eVar7 = o7.m0.f8288a;
                        xVar4.f7024a = o7.c0.s(o7.c0.b(v7.d.f10884a), null, null, new b.m(file6, str4, vVar, fileExplorerActivity, (t6.c) null, 9), 3);
                        break;
                    }
                }
                break;
        }
    }
}
