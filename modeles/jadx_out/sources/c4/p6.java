package c4;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ImageView;
import com.uptodown.activities.PasswordEditActivity;
import com.uptodown.activities.SearchActivity;
import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class p6 implements TextWatcher {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1985a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ k0 f1986b;

    public /* synthetic */ p6(k0 k0Var, int i) {
        this.f1985a = i;
        this.f1986b = k0Var;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        switch (this.f1985a) {
            case 0:
            case 1:
                break;
            default:
                SearchActivity searchActivity = (SearchActivity) this.f1986b;
                String valueOf = String.valueOf(editable);
                int i = SearchActivity.Y;
                String o02 = l7.u.o0(valueOf, "/", "", false);
                int length = o02.length();
                if (2 > length || length >= 40) {
                    o7.s1 s1Var = searchActivity.Q;
                    if (s1Var != null) {
                        s1Var.c(null);
                    }
                    e4.l0 l0Var = searchActivity.R;
                    if (l0Var != null) {
                        l0Var.f4602a = new ArrayList();
                        l0Var.notifyDataSetChanged();
                    }
                    e4.m0 m0Var = searchActivity.S;
                    if (m0Var != null) {
                        m0Var.f4625a = new ArrayList();
                        m0Var.notifyDataSetChanged();
                    }
                } else {
                    searchActivity.C0(2, o02);
                }
                if (String.valueOf(editable).length() <= 0) {
                    e4.l0 l0Var2 = searchActivity.R;
                    if (l0Var2 != null) {
                        l0Var2.f4602a = new ArrayList();
                        l0Var2.notifyDataSetChanged();
                    }
                    ((ImageView) searchActivity.z0().f10137b.f11757m).setVisibility(8);
                    ((ImageView) searchActivity.z0().f10137b.f11758n).setVisibility(0);
                    break;
                } else {
                    ((ImageView) searchActivity.z0().f10137b.f11757m).setVisibility(0);
                    ((ImageView) searchActivity.z0().f10137b.f11758n).setVisibility(8);
                    break;
                }
        }
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i6, int i10) {
        int i11 = this.f1985a;
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i6, int i10) {
        int i11 = this.f1985a;
        k0 k0Var = this.f1986b;
        switch (i11) {
            case 0:
                if (charSequence != null) {
                    PasswordEditActivity.y0((PasswordEditActivity) k0Var, charSequence.toString());
                    break;
                }
                break;
            case 1:
                if (charSequence != null) {
                    PasswordEditActivity passwordEditActivity = (PasswordEditActivity) k0Var;
                    int i12 = PasswordEditActivity.Q;
                    PasswordEditActivity.y0(passwordEditActivity, passwordEditActivity.z0().f9779l.getText().toString());
                    break;
                }
                break;
        }
    }

    private final void a(Editable editable) {
    }

    private final void b(Editable editable) {
    }

    private final void c(CharSequence charSequence, int i, int i6, int i10) {
    }

    private final void d(CharSequence charSequence, int i, int i6, int i10) {
    }

    private final void e(CharSequence charSequence, int i, int i6, int i10) {
    }

    private final void f(CharSequence charSequence, int i, int i6, int i10) {
    }
}
