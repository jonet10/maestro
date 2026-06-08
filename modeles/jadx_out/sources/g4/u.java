package g4;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.core.activities.FileExplorerActivity;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class u implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5265a = 2;

    /* renamed from: b, reason: collision with root package name */
    public final RelativeLayout f5266b;

    /* renamed from: l, reason: collision with root package name */
    public final EditText f5267l;

    /* renamed from: m, reason: collision with root package name */
    public final TextView f5268m;

    /* renamed from: n, reason: collision with root package name */
    public final TextView f5269n;

    /* renamed from: o, reason: collision with root package name */
    public final TextView f5270o;

    /* renamed from: p, reason: collision with root package name */
    public final TextView f5271p;

    /* renamed from: q, reason: collision with root package name */
    public final View f5272q;

    /* renamed from: r, reason: collision with root package name */
    public final KeyEvent.Callback f5273r;

    public u(RelativeLayout relativeLayout, EditText editText, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6) {
        this.f5266b = relativeLayout;
        this.f5267l = editText;
        this.f5268m = textView;
        this.f5269n = textView2;
        this.f5270o = textView3;
        this.f5271p = textView4;
        this.f5272q = textView5;
        this.f5273r = textView6;
    }

    public static u c(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(2131558488, (ViewGroup) null, false);
        int i = 2131362144;
        EditText editText = (EditText) ViewBindings.findChildViewById(inflate, 2131362144);
        if (editText != null) {
            i = 2131363725;
            TextView textView = (TextView) ViewBindings.findChildViewById(inflate, 2131363725);
            if (textView != null) {
                i = 2131363891;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(inflate, 2131363891);
                if (textView2 != null) {
                    i = 2131363906;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(inflate, 2131363906);
                    if (textView3 != null) {
                        i = 2131364012;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(inflate, 2131364012);
                        if (textView4 != null) {
                            i = 2131364181;
                            TextView textView5 = (TextView) ViewBindings.findChildViewById(inflate, 2131364181);
                            if (textView5 != null) {
                                i = 2131364379;
                                TextView textView6 = (TextView) ViewBindings.findChildViewById(inflate, 2131364379);
                                if (textView6 != null) {
                                    return new u((RelativeLayout) inflate, editText, textView, textView2, textView3, textView4, textView5, textView6);
                                }
                            }
                        }
                    }
                }
            }
        }
        com.google.gson.internal.a.i("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
        return null;
    }

    public void a(String str) {
        this.f5270o.setText(str);
        this.f5266b.setVisibility(8);
        this.f5269n.setVisibility(8);
        this.f5271p.setText(((FileExplorerActivity) this.f5273r).getString(2131951793));
    }

    public void b(String str) {
        str.getClass();
        EditText editText = this.f5267l;
        editText.setFocusable(false);
        editText.setFocusableInTouchMode(false);
        editText.clearFocus();
        ((ProgressBar) this.f5272q).setVisibility(0);
        TextView textView = this.f5268m;
        textView.setVisibility(0);
        textView.setText(((FileExplorerActivity) this.f5273r).getString(2131951881, str));
        this.f5269n.setVisibility(8);
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        switch (this.f5265a) {
            case 1:
                return this.f5266b;
            default:
                return (LinearLayout) this.f5272q;
        }
    }

    public u(LinearLayout linearLayout, EditText editText, EditText editText2, RelativeLayout relativeLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.f5272q = linearLayout;
        this.f5267l = editText;
        this.f5273r = editText2;
        this.f5266b = relativeLayout;
        this.f5268m = textView;
        this.f5269n = textView2;
        this.f5270o = textView3;
        this.f5271p = textView4;
    }

    public u(ProgressBar progressBar, TextView textView, EditText editText, FileExplorerActivity fileExplorerActivity, TextView textView2, TextView textView3, RelativeLayout relativeLayout, TextView textView4) {
        this.f5272q = progressBar;
        this.f5268m = textView;
        this.f5267l = editText;
        this.f5273r = fileExplorerActivity;
        this.f5269n = textView2;
        this.f5270o = textView3;
        this.f5266b = relativeLayout;
        this.f5271p = textView4;
    }
}
