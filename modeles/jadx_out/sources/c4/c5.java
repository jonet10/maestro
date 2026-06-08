package c4;

import android.app.AlertDialog;
import android.content.Intent;
import android.view.View;
import com.uptodown.activities.MyDownloads;
import com.uptodown.core.activities.FileExplorerActivity;
import java.io.File;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class c5 implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1462a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ kotlin.jvm.internal.x f1463b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ MyDownloads f1464l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ int f1465m;

    public /* synthetic */ c5(MyDownloads myDownloads, int i, kotlin.jvm.internal.x xVar) {
        this.f1462a = 0;
        this.f1464l = myDownloads;
        this.f1465m = i;
        this.f1463b = xVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.f1462a;
        int i6 = this.f1465m;
        MyDownloads myDownloads = this.f1464l;
        kotlin.jvm.internal.x xVar = this.f1463b;
        switch (i) {
            case 0:
                e4.b bVar = myDownloads.Q;
                bVar.getClass();
                bVar.c(true);
                e4.b bVar2 = myDownloads.Q;
                bVar2.getClass();
                bVar2.b(i6);
                myDownloads.E0();
                myDownloads.D0();
                AlertDialog alertDialog = (AlertDialog) xVar.f7024a;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                    break;
                }
                break;
            case 1:
                int i10 = MyDownloads.V;
                AlertDialog alertDialog2 = (AlertDialog) xVar.f7024a;
                if (alertDialog2 != null) {
                    alertDialog2.dismiss();
                }
                myDownloads.z0(i6);
                break;
            default:
                int i11 = MyDownloads.V;
                AlertDialog alertDialog3 = (AlertDialog) xVar.f7024a;
                if (alertDialog3 != null) {
                    alertDialog3.dismiss();
                }
                e4.b bVar3 = myDownloads.Q;
                bVar3.getClass();
                String str = ((x4.j0) ((x4.r) bVar3.f4485b.get(i6)).F.get(0)).f11240q;
                if (str != null && str.length() != 0) {
                    e4.b bVar4 = myDownloads.Q;
                    bVar4.getClass();
                    String str2 = ((x4.j0) ((x4.r) bVar4.f4485b.get(i6)).F.get(0)).f11240q;
                    str2.getClass();
                    File parentFile = new File(str2).getParentFile();
                    String absolutePath = parentFile != null ? parentFile.getAbsolutePath() : null;
                    if (absolutePath == null) {
                        String string = myDownloads.getString(2131952085);
                        string.getClass();
                        myDownloads.A(string);
                        break;
                    } else {
                        Intent intent = new Intent(myDownloads.getApplicationContext(), (Class<?>) FileExplorerActivity.class);
                        intent.putExtra("subdir", absolutePath);
                        myDownloads.startActivity(intent);
                        break;
                    }
                }
                break;
        }
    }

    public /* synthetic */ c5(kotlin.jvm.internal.x xVar, MyDownloads myDownloads, int i, int i6) {
        this.f1462a = i6;
        this.f1463b = xVar;
        this.f1464l = myDownloads;
        this.f1465m = i;
    }
}
