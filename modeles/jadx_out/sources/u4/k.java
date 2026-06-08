package u4;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Typeface;
import android.text.SpannableString;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.uptodown.UptodownApp;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class k implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10512a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f0 f10513b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ View f10514l;

    public /* synthetic */ k(f0 f0Var, View view, int i) {
        this.f10512a = i;
        this.f10513b = f0Var;
        this.f10514l = view;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.f10512a;
        View view2 = this.f10514l;
        f0 f0Var = this.f10513b;
        switch (i) {
            case 0:
                float f = UptodownApp.I;
                if (b4.d.t()) {
                    FragmentActivity activity = f0Var.getActivity();
                    activity.getClass();
                    if (((c4.k0) activity).T()) {
                        FragmentActivity activity2 = f0Var.getActivity();
                        activity2.getClass();
                        AlertDialog alertDialog = ((c4.k0) activity2).F;
                        if (alertDialog != null) {
                            alertDialog.dismiss();
                        }
                        if (view2.getContext() != null) {
                            g4.v e10 = g4.v.e(f0Var.getLayoutInflater());
                            TextView textView = (TextView) e10.f5276l;
                            TextView textView2 = (TextView) e10.f5280p;
                            TextView textView3 = (TextView) e10.f5277m;
                            TextView textView4 = (TextView) e10.f5275b;
                            textView2.setTypeface(f4.c.f4882w);
                            textView2.setText(f0Var.getString(2131951768));
                            textView.setTypeface(f4.c.f4883x);
                            String string = f0Var.getString(2131951819, f0Var.B().f11159b);
                            string.getClass();
                            String str = f0Var.B().f11159b;
                            str.getClass();
                            Context context = view2.getContext();
                            context.getClass();
                            SpannableString spannableString = new SpannableString(string);
                            int y02 = l7.m.y0(string, str, 0, false, 6);
                            int length = str.length() + y02;
                            if (y02 != -1) {
                                float dimension = context.getResources().getDimension(2131166539);
                                Typeface typeface = f4.c.f4882w;
                                typeface.getClass();
                                spannableString.setSpan(new j5.e(dimension, typeface, ContextCompat.getColor(context, 2131100787)), y02, length, 33);
                            }
                            textView.setText(spannableString);
                            textView4.setTypeface(f4.c.f4882w);
                            textView3.setTypeface(f4.c.f4882w);
                            textView3.setText(f0Var.getString(2131951930));
                            textView4.setVisibility(0);
                            textView4.setOnClickListener(new p(f0Var, 21));
                            textView3.setOnClickListener(new p(f0Var, 22));
                            ((ImageView) e10.f5279o).setOnClickListener(new p(f0Var, 23));
                            AlertDialog.Builder builder = new AlertDialog.Builder(f0Var.requireContext());
                            builder.setView((RelativeLayout) e10.f5278n);
                            builder.setCancelable(true);
                            f0Var.m0(builder);
                            break;
                        }
                    }
                }
                break;
            default:
                float f10 = UptodownApp.I;
                if (b4.d.t()) {
                    FragmentActivity activity3 = f0Var.getActivity();
                    activity3.getClass();
                    if (((c4.k0) activity3).T()) {
                        FragmentActivity activity4 = f0Var.getActivity();
                        activity4.getClass();
                        AlertDialog alertDialog2 = ((c4.k0) activity4).F;
                        if (alertDialog2 != null) {
                            alertDialog2.dismiss();
                        }
                        if (view2.getContext() != null) {
                            g4.v e11 = g4.v.e(f0Var.getLayoutInflater());
                            TextView textView5 = (TextView) e11.f5277m;
                            ((TextView) e11.f5280p).setTypeface(f4.c.f4882w);
                            ((TextView) e11.f5276l).setTypeface(f4.c.f4883x);
                            textView5.setTypeface(f4.c.f4882w);
                            textView5.setOnClickListener(new p(f0Var, 14));
                            ((ImageView) e11.f5279o).setOnClickListener(new p(f0Var, 15));
                            AlertDialog.Builder builder2 = new AlertDialog.Builder(f0Var.requireContext());
                            builder2.setView((RelativeLayout) e11.f5278n);
                            builder2.setCancelable(true);
                            f0Var.m0(builder2);
                            break;
                        }
                    }
                }
                break;
        }
    }
}
