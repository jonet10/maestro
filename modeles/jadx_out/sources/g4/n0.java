package g4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.uptodown.core.activities.InstallerActivity;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class n0 extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5227a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ InstallerActivity f5228b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ kotlin.jvm.internal.x f5229l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n0(kotlin.jvm.internal.x xVar, InstallerActivity installerActivity, t6.c cVar) {
        super(2, cVar);
        this.f5227a = 2;
        this.f5229l = xVar;
        this.f5228b = installerActivity;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f5227a) {
            case 0:
                return new n0(this.f5228b, this.f5229l, cVar, 0);
            case 1:
                return new n0(this.f5228b, this.f5229l, cVar, 1);
            default:
                return new n0(this.f5229l, this.f5228b, cVar);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        o7.a0 a0Var = (o7.a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f5227a) {
            case 0:
                n0 n0Var = (n0) create(a0Var, cVar);
                p6.x xVar = p6.x.f8463a;
                n0Var.invokeSuspend(xVar);
                return xVar;
            case 1:
                n0 n0Var2 = (n0) create(a0Var, cVar);
                p6.x xVar2 = p6.x.f8463a;
                n0Var2.invokeSuspend(xVar2);
                return xVar2;
            default:
                n0 n0Var3 = (n0) create(a0Var, cVar);
                p6.x xVar3 = p6.x.f8463a;
                n0Var3.invokeSuspend(xVar3);
                return xVar3;
        }
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        int i = this.f5227a;
        p6.x xVar = p6.x.f8463a;
        kotlin.jvm.internal.x xVar2 = this.f5229l;
        InstallerActivity installerActivity = this.f5228b;
        switch (i) {
            case 0:
                p6.a.e(obj);
                ProgressBar progressBar = installerActivity.f3403y;
                if (progressBar != null) {
                    progressBar.setIndeterminate(false);
                }
                TextView textView = installerActivity.L;
                if (textView != null) {
                    textView.setText("");
                }
                TextView textView2 = installerActivity.N;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                }
                TextView textView3 = installerActivity.M;
                if (textView3 != null) {
                    textView3.setVisibility(8);
                }
                Object obj2 = xVar2.f7024a;
                if (obj2 == null) {
                    Intent intent = new Intent();
                    intent.putExtra("realPath", installerActivity.S);
                    installerActivity.setResult(10, intent);
                    installerActivity.finish();
                    break;
                } else {
                    TextView textView4 = installerActivity.L;
                    if (textView4 != null) {
                        textView4.setText((CharSequence) obj2);
                        break;
                    }
                }
                break;
            case 1:
                p6.a.e(obj);
                Intent intent2 = installerActivity.getIntent();
                if (intent2 != null) {
                    installerActivity.T = intent2.getData();
                    Bundle extras = intent2.getExtras();
                    if (extras != null && extras.containsKey("realPath")) {
                        String string = extras.getString("realPath");
                        installerActivity.S = string;
                        string.getClass();
                        String str = installerActivity.S;
                        str.getClass();
                        xVar2.f7024a = string.substring(l7.m.A0("/", str, 6) + 1);
                        break;
                    }
                }
                break;
            default:
                p6.a.e(obj);
                String str2 = (String) xVar2.f7024a;
                if (str2 == null) {
                    str2 = installerActivity.getString(2131952007);
                    str2.getClass();
                }
                installerActivity.M(str2);
                break;
        }
        return xVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ n0(InstallerActivity installerActivity, kotlin.jvm.internal.x xVar, t6.c cVar, int i) {
        super(2, cVar);
        this.f5227a = i;
        this.f5228b = installerActivity;
        this.f5229l = xVar;
    }
}
