package g4;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.MimeTypeMap;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.appcompat.widget.Toolbar;
import androidx.documentfile.provider.DocumentFile;
import com.uptodown.core.activities.FileExplorerActivity;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class j implements ActivityResultCallback, Toolbar.OnMenuItemClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FileExplorerActivity f5195a;

    public /* synthetic */ j(FileExplorerActivity fileExplorerActivity) {
        this.f5195a = fileExplorerActivity;
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public void onActivityResult(Object obj) {
        Bundle extras;
        ActivityResult activityResult = (ActivityResult) obj;
        int i = FileExplorerActivity.f3379q0;
        if (activityResult.getResultCode() == 145) {
            Intent data = activityResult.getData();
            String string = (data == null || (extras = data.getExtras()) == null) ? null : extras.getString("path_selected");
            FileExplorerActivity fileExplorerActivity = this.f5195a;
            fileExplorerActivity.f3389k0 = string;
            if (string != null) {
                fileExplorerActivity.f3388j0 = null;
                TextView textView = fileExplorerActivity.L;
                if (textView != null) {
                    textView.setText(string);
                    return;
                } else {
                    kotlin.jvm.internal.l.i("tvSelectedPath");
                    throw null;
                }
            }
            Intent data2 = activityResult.getData();
            Uri data3 = data2 != null ? data2.getData() : null;
            if (data3 != null) {
                fileExplorerActivity.f3388j0 = data3;
                fileExplorerActivity.f3389k0 = null;
                String lastPathSegment = data3.getLastPathSegment();
                lastPathSegment.getClass();
                String substring = lastPathSegment.substring(l7.m.A0(":", lastPathSegment, 6) + 1);
                TextView textView2 = fileExplorerActivity.L;
                if (textView2 == null) {
                    kotlin.jvm.internal.l.i("tvSelectedPath");
                    throw null;
                }
                textView2.setText(fileExplorerActivity.getString(2131952558) + "/" + substring);
            }
        }
    }

    @Override // androidx.appcompat.widget.Toolbar.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) {
        EditText editText;
        TextView textView;
        boolean z9;
        AlertDialog alertDialog;
        EditText editText2;
        TextView textView2;
        int i;
        AlertDialog alertDialog2;
        int i6 = FileExplorerActivity.f3379q0;
        menuItem.getClass();
        int itemId = menuItem.getItemId();
        final FileExplorerActivity fileExplorerActivity = this.f5195a;
        Integer num = null;
        if (itemId != 2131361869) {
            if (itemId == 2131361872) {
                AlertDialog alertDialog3 = fileExplorerActivity.S;
                if (alertDialog3 != null) {
                    alertDialog3.dismiss();
                }
                View inflate = fileExplorerActivity.getLayoutInflater().inflate(2131558487, (ViewGroup) null, false);
                TextView textView3 = (TextView) inflate.findViewById(2131363814);
                textView3.setTypeface(f4.c.f4883x);
                Context context = textView3.getContext();
                i4.b bVar = fileExplorerActivity.V;
                if (bVar != null) {
                    boolean[] zArr = bVar.f5658d;
                    if (zArr != null) {
                        i = 0;
                        for (boolean z10 : zArr) {
                            if (z10) {
                                i++;
                            }
                        }
                    } else {
                        i = 0;
                    }
                    num = Integer.valueOf(i);
                }
                textView3.setText(context.getString(2131951864, String.valueOf(num)));
                TextView textView4 = (TextView) inflate.findViewById(2131363606);
                textView4.setText(fileExplorerActivity.getString(2131952426));
                textView4.setTypeface(f4.c.f4882w);
                textView4.setOnClickListener(new g(fileExplorerActivity, 11));
                TextView textView5 = (TextView) inflate.findViewById(2131363700);
                textView5.setText(fileExplorerActivity.getString(2131952425));
                textView5.setTypeface(f4.c.f4882w);
                textView5.setOnClickListener(new g(fileExplorerActivity, 12));
                AlertDialog.Builder builder = new AlertDialog.Builder(fileExplorerActivity);
                builder.setView(inflate);
                AlertDialog create = builder.create();
                fileExplorerActivity.S = create;
                create.getClass();
                Window window = create.getWindow();
                if (window != null) {
                    a4.x.y(window, 0);
                }
                AlertDialog alertDialog4 = fileExplorerActivity.S;
                alertDialog4.getClass();
                alertDialog4.show();
                return true;
            }
            if (itemId != 2131361865) {
                if (itemId == 2131361868) {
                    v7.e eVar = o7.m0.f8288a;
                    o7.c0.s(o7.c0.b(v7.d.f10884a), null, null, new o(fileExplorerActivity, (t6.c) null, 0), 3);
                    return true;
                }
                if (itemId == 2131361870) {
                    fileExplorerActivity.f3385g0 = true;
                    v7.e eVar2 = o7.m0.f8288a;
                    o7.c0.s(o7.c0.b(v7.d.f10884a), null, null, new o(fileExplorerActivity, (t6.c) null, 1), 3);
                    return true;
                }
                if (itemId != 2131361888) {
                    return true;
                }
                if (fileExplorerActivity.f3381c0 != null) {
                    ArrayList arrayList = fileExplorerActivity.f3384f0;
                    arrayList.getClass();
                    File file = fileExplorerActivity.f3381c0;
                    file.getClass();
                    new j4.o(arrayList, file, fileExplorerActivity.f3391m0, fileExplorerActivity.f3385g0, fileExplorerActivity);
                    return true;
                }
                if (fileExplorerActivity.Y == null) {
                    return true;
                }
                ArrayList arrayList2 = fileExplorerActivity.f3384f0;
                arrayList2.getClass();
                DocumentFile documentFile = fileExplorerActivity.Y;
                documentFile.getClass();
                new j4.o(arrayList2, documentFile, fileExplorerActivity.f3391m0, fileExplorerActivity.f3385g0, fileExplorerActivity);
                return true;
            }
            if (!fileExplorerActivity.isFinishing()) {
                AlertDialog.Builder builder2 = new AlertDialog.Builder(fileExplorerActivity);
                LayoutInflater layoutInflater = fileExplorerActivity.getLayoutInflater();
                layoutInflater.getClass();
                View inflate2 = layoutInflater.inflate(2131558498, (ViewGroup) null, false);
                ((TextView) inflate2.findViewById(2131363818)).setTypeface(f4.c.f4882w);
                TextView textView6 = (TextView) inflate2.findViewById(2131363810);
                textView6.setTypeface(f4.c.f4883x);
                RelativeLayout relativeLayout = (RelativeLayout) inflate2.findViewById(2131363165);
                EditText editText3 = (EditText) inflate2.findViewById(2131362146);
                editText3.setTypeface(f4.c.f4883x);
                TextView textView7 = (TextView) inflate2.findViewById(2131363813);
                textView7.setTypeface(f4.c.f4883x);
                textView7.setText(".zip");
                ((TextView) inflate2.findViewById(2131363816)).setTypeface(f4.c.f4883x);
                TextView textView8 = (TextView) inflate2.findViewById(2131363815);
                textView8.setTypeface(f4.c.f4883x);
                TextView textView9 = (TextView) inflate2.findViewById(2131364193);
                textView9.setTypeface(f4.c.f4882w);
                TextView textView10 = (TextView) inflate2.findViewById(2131363607);
                textView10.setTypeface(f4.c.f4882w);
                TextView textView11 = (TextView) inflate2.findViewById(2131363701);
                textView11.setTypeface(f4.c.f4882w);
                ProgressBar progressBar = (ProgressBar) inflate2.findViewById(2131362993);
                i4.b bVar2 = fileExplorerActivity.V;
                bVar2.getClass();
                final ArrayList a8 = bVar2.a();
                final ArrayList arrayList3 = new ArrayList();
                if (a8.isEmpty()) {
                    editText = editText3;
                    textView = textView9;
                    z9 = true;
                } else {
                    Iterator it = a8.iterator();
                    it.getClass();
                    z9 = true;
                    String str = "";
                    while (it.hasNext()) {
                        Object next = it.next();
                        next.getClass();
                        if (next instanceof File) {
                            editText2 = editText3;
                            textView2 = textView9;
                            str = str + ((File) next).getName() + "\n";
                            arrayList3.add(next);
                        } else {
                            editText2 = editText3;
                            textView2 = textView9;
                            if (next instanceof DocumentFile) {
                                str = a4.x.k(str, ((DocumentFile) next).getName(), "\n");
                            }
                        }
                        textView9 = textView2;
                        editText3 = editText2;
                    }
                    editText = editText3;
                    textView = textView9;
                    textView8.setText(str);
                }
                final kotlin.jvm.internal.x xVar = new kotlin.jvm.internal.x();
                final u uVar = new u(progressBar, textView, editText, fileExplorerActivity, textView10, textView6, relativeLayout, textView11);
                final EditText editText4 = editText;
                textView10.setOnClickListener(new View.OnClickListener() { // from class: g4.k
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        String mimeTypeFromExtension;
                        int i10 = FileExplorerActivity.f3379q0;
                        EditText editText5 = editText4;
                        int length = editText5.getText().toString().length();
                        FileExplorerActivity fileExplorerActivity2 = fileExplorerActivity;
                        if (length <= 0) {
                            String string = fileExplorerActivity2.getString(2131951849);
                            string.getClass();
                            fileExplorerActivity2.A(string);
                            return;
                        }
                        ArrayList arrayList4 = a8;
                        if (arrayList4.isEmpty()) {
                            return;
                        }
                        File file2 = fileExplorerActivity2.f3381c0;
                        kotlin.jvm.internal.x xVar2 = xVar;
                        u uVar2 = uVar;
                        if (file2 != null) {
                            long usableSpace = file2.getUsableSpace();
                            ArrayList arrayList5 = arrayList3;
                            int size = arrayList5.size();
                            int i11 = 0;
                            long j = 0;
                            while (i11 < size) {
                                Object obj = arrayList5.get(i11);
                                i11++;
                                j = ((File) obj).length() + j;
                            }
                            if (usableSpace <= j * 2) {
                                String string2 = fileExplorerActivity2.getString(2131952002);
                                string2.getClass();
                                fileExplorerActivity2.A(string2);
                                return;
                            }
                            File file3 = fileExplorerActivity2.f3381c0;
                            File file4 = new File((file3 != null ? file3.getAbsolutePath() : null) + "/" + ((Object) editText5.getText()) + ".zip");
                            if (file4.exists()) {
                                String string3 = fileExplorerActivity2.getString(2131951848, editText5.getText());
                                string3.getClass();
                                fileExplorerActivity2.A(string3);
                                return;
                            } else {
                                Activity activity = f4.c.f4875o;
                                t0.f.h(fileExplorerActivity2, editText5);
                                v7.e eVar3 = o7.m0.f8288a;
                                xVar2.f7024a = o7.c0.s(o7.c0.b(v7.d.f10884a), null, null, new b.m(arrayList5, file4, uVar2, fileExplorerActivity2, (t6.c) null, 7), 3);
                                return;
                            }
                        }
                        if (fileExplorerActivity2.Y != null) {
                            ArrayList arrayList6 = new ArrayList();
                            Iterator it2 = arrayList4.iterator();
                            it2.getClass();
                            while (it2.hasNext()) {
                                Object next2 = it2.next();
                                next2.getClass();
                                if (next2 instanceof DocumentFile) {
                                    arrayList6.add(next2);
                                }
                            }
                            Context applicationContext = fileExplorerActivity2.getApplicationContext();
                            applicationContext.getClass();
                            DocumentFile documentFile2 = fileExplorerActivity2.Y;
                            documentFile2.getClass();
                            long c9 = n4.d.c(applicationContext, documentFile2);
                            int size2 = arrayList6.size();
                            int i12 = 0;
                            long j6 = 0;
                            while (i12 < size2) {
                                Object obj2 = arrayList6.get(i12);
                                i12++;
                                j6 = ((DocumentFile) obj2).length() + j6;
                            }
                            if (c9 > j6 * 2) {
                                String str2 = ((Object) editText5.getText()) + ".zip";
                                DocumentFile documentFile3 = fileExplorerActivity2.Y;
                                documentFile3.getClass();
                                DocumentFile[] listFiles = documentFile3.listFiles();
                                listFiles.getClass();
                                boolean z11 = false;
                                for (DocumentFile documentFile4 : listFiles) {
                                    if (kotlin.jvm.internal.l.a(documentFile4.getName(), str2)) {
                                        String string4 = fileExplorerActivity2.getString(2131951848, editText5.getText());
                                        string4.getClass();
                                        fileExplorerActivity2.A(string4);
                                        z11 = true;
                                    }
                                }
                                if (z11) {
                                    return;
                                }
                                Activity activity2 = f4.c.f4875o;
                                t0.f.h(fileExplorerActivity2, editText5);
                                DocumentFile documentFile5 = fileExplorerActivity2.Y;
                                documentFile5.getClass();
                                String substring = l7.m.y0(str2, ".", 0, false, 6) > 0 ? str2.substring(l7.m.A0(".", str2, 6) + 1) : "";
                                if (substring.equalsIgnoreCase("xapk")) {
                                    mimeTypeFromExtension = "application/xapk-package-archive";
                                } else {
                                    MimeTypeMap singleton = MimeTypeMap.getSingleton();
                                    Locale locale = Locale.getDefault();
                                    locale.getClass();
                                    String lowerCase = substring.toLowerCase(locale);
                                    lowerCase.getClass();
                                    mimeTypeFromExtension = singleton.getMimeTypeFromExtension(lowerCase);
                                    if (mimeTypeFromExtension == null) {
                                        mimeTypeFromExtension = "application/octet-stream";
                                    }
                                }
                                DocumentFile createFile = documentFile5.createFile(mimeTypeFromExtension, str2);
                                createFile.getClass();
                                v7.e eVar4 = o7.m0.f8288a;
                                xVar2.f7024a = o7.c0.s(o7.c0.b(v7.d.f10884a), null, null, new b.m(arrayList6, createFile, uVar2, fileExplorerActivity2, (t6.c) null, 6), 3);
                            }
                        }
                    }
                });
                textView11.setOnClickListener(new l(xVar, fileExplorerActivity, 0));
                builder2.setView(inflate2);
                fileExplorerActivity.S = builder2.create();
                if (fileExplorerActivity.isFinishing() || (alertDialog = fileExplorerActivity.S) == null) {
                    return z9;
                }
                Window window2 = alertDialog.getWindow();
                if (window2 != null) {
                    a4.x.y(window2, 0);
                }
                AlertDialog alertDialog5 = fileExplorerActivity.S;
                alertDialog5.getClass();
                alertDialog5.show();
                return z9;
            }
        } else if (!fileExplorerActivity.isFinishing()) {
            AlertDialog.Builder builder3 = new AlertDialog.Builder(fileExplorerActivity);
            LayoutInflater layoutInflater2 = fileExplorerActivity.getLayoutInflater();
            layoutInflater2.getClass();
            View inflate3 = layoutInflater2.inflate(2131558501, (ViewGroup) null, false);
            ((TextView) inflate3.findViewById(2131363819)).setTypeface(f4.c.f4882w);
            ((TextView) inflate3.findViewById(2131363811)).setTypeface(f4.c.f4883x);
            EditText editText5 = (EditText) inflate3.findViewById(2131362147);
            editText5.setTypeface(f4.c.f4883x);
            TextView textView12 = (TextView) inflate3.findViewById(2131363608);
            textView12.setTypeface(f4.c.f4882w);
            TextView textView13 = (TextView) inflate3.findViewById(2131363702);
            textView13.setTypeface(f4.c.f4882w);
            textView12.setOnClickListener(new c.e(28, editText5, fileExplorerActivity));
            textView13.setOnClickListener(new g(fileExplorerActivity, 6));
            builder3.setView(inflate3);
            fileExplorerActivity.S = builder3.create();
            if (!fileExplorerActivity.isFinishing() && (alertDialog2 = fileExplorerActivity.S) != null) {
                Window window3 = alertDialog2.getWindow();
                if (window3 != null) {
                    a4.x.y(window3, 0);
                }
                AlertDialog alertDialog6 = fileExplorerActivity.S;
                alertDialog6.getClass();
                alertDialog6.show();
                return true;
            }
        }
        return true;
    }
}
