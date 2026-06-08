package c4;

import android.content.Intent;
import android.view.View;
import androidx.core.content.FileProvider;
import androidx.documentfile.provider.DocumentFile;
import androidx.work.Data;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import com.uptodown.UptodownApp;
import com.uptodown.workers.GenerateQueueWorker;
import java.io.File;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class r4 implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2045a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ w4 f2046b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ String f2047l;

    public /* synthetic */ r4(w4 w4Var, String str, int i) {
        this.f2045a = i;
        this.f2046b = w4Var;
        this.f2047l = str;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.f2045a;
        String str = this.f2047l;
        w4 w4Var = this.f2046b;
        switch (i) {
            case 0:
                float f = UptodownApp.I;
                if (b4.d.t()) {
                    Intent intent = new Intent("android.intent.action.SEND");
                    Object a8 = new h4.a(w4Var).a();
                    if (!(a8 instanceof File)) {
                        if (a8 instanceof DocumentFile) {
                            intent.putExtra("android.intent.extra.STREAM", ((DocumentFile) a8).getUri());
                            w4Var.startActivity(Intent.createChooser(intent, w4Var.getString(2131952097)));
                            break;
                        }
                    } else {
                        File file = new File((File) a8, str);
                        if (file.exists()) {
                            intent.setType("application/vnd.android.package-archive");
                            intent.putExtra("android.intent.extra.STREAM", FileProvider.getUriForFile(w4Var, w4Var.getPackageName() + ".provider", file));
                            w4Var.startActivity(Intent.createChooser(intent, w4Var.getString(2131952097)));
                            break;
                        }
                    }
                }
                break;
            default:
                w4Var.Q();
                float f10 = UptodownApp.I;
                if (!b4.d.p(w4Var, "GenerateQueueWorker") && !b4.d.p(w4Var, "downloadApkWorker")) {
                    w4Var.R = true;
                    if (!b4.d.p(w4Var, "GenerateQueueWorker")) {
                        WorkManager.Companion.getInstance(w4Var).enqueue(((OneTimeWorkRequest.Builder) androidx.lifecycle.l.t(GenerateQueueWorker.class, "GenerateQueueWorker")).setInputData(new Data.Builder().putBoolean("downloadAnyway", true).putString("packagename", str).build()).build());
                        break;
                    }
                } else {
                    String string = w4Var.getString(2131951994);
                    string.getClass();
                    w4Var.N(string);
                    break;
                }
                break;
        }
    }
}
