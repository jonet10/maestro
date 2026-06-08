package g4;

import android.app.AlertDialog;
import android.view.View;
import com.uptodown.core.activities.FileExplorerActivity;
import o7.e1;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class l implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5207a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ kotlin.jvm.internal.x f5208b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ FileExplorerActivity f5209l;

    public /* synthetic */ l(kotlin.jvm.internal.x xVar, FileExplorerActivity fileExplorerActivity, int i) {
        this.f5207a = i;
        this.f5208b = xVar;
        this.f5209l = fileExplorerActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.f5207a;
        FileExplorerActivity fileExplorerActivity = this.f5209l;
        kotlin.jvm.internal.x xVar = this.f5208b;
        switch (i) {
            case 0:
                int i6 = FileExplorerActivity.f3379q0;
                e1 e1Var = (e1) xVar.f7024a;
                if (e1Var != null) {
                    e1Var.c(null);
                }
                AlertDialog alertDialog = fileExplorerActivity.S;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                    break;
                }
                break;
            default:
                int i10 = FileExplorerActivity.f3379q0;
                e1 e1Var2 = (e1) xVar.f7024a;
                if (e1Var2 != null) {
                    e1Var2.c(null);
                }
                AlertDialog alertDialog2 = fileExplorerActivity.S;
                if (alertDialog2 != null) {
                    alertDialog2.dismiss();
                    break;
                }
                break;
        }
    }
}
