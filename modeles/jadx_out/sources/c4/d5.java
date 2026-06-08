package c4;

import android.app.AlertDialog;
import android.view.View;
import com.uptodown.activities.MyDownloads;
import com.uptodown.activities.UserActivity;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class d5 implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1509a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ kotlin.jvm.internal.x f1510b;

    public /* synthetic */ d5(kotlin.jvm.internal.x xVar, int i) {
        this.f1509a = i;
        this.f1510b = xVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.f1509a;
        kotlin.jvm.internal.x xVar = this.f1510b;
        switch (i) {
            case 0:
                int i6 = MyDownloads.V;
                if (a5.b.d()) {
                    a5.b.h();
                } else {
                    a5.b.g();
                }
                AlertDialog alertDialog = (AlertDialog) xVar.f7024a;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                    break;
                }
                break;
            default:
                int i10 = UserActivity.W;
                Object obj = xVar.f7024a;
                obj.getClass();
                ((AlertDialog) obj).dismiss();
                break;
        }
    }
}
