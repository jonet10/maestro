package m5;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Typeface;
import android.text.SpannableString;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import c4.a7;
import com.uptodown.UptodownApp;
import com.uptodown.activities.PreregistrationActivity;
import x4.u2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class o0 extends RecyclerView.ViewHolder {

    /* renamed from: a, reason: collision with root package name */
    public final g4.v f7490a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f7491b;

    /* renamed from: l, reason: collision with root package name */
    public final f0.i f7492l;

    /* renamed from: m, reason: collision with root package name */
    public final boolean f7493m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o0(g4.v vVar, Context context, f0.i iVar) {
        super((RelativeLayout) vVar.f5278n);
        context.getClass();
        this.f7490a = vVar;
        this.f7491b = context;
        this.f7492l = iVar;
        this.f7493m = true;
        final int i = 0;
        ((RelativeLayout) vVar.f5280p).setOnClickListener(new View.OnClickListener(this) { // from class: m5.n0

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ o0 f7484b;

            {
                this.f7484b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int bindingAdapterPosition;
                e4.d0 d0Var;
                int bindingAdapterPosition2;
                int i6 = i;
                o0 o0Var = this.f7484b;
                switch (i6) {
                    case 0:
                        f0.i iVar2 = o0Var.f7492l;
                        if (iVar2 != null && (bindingAdapterPosition = o0Var.getBindingAdapterPosition()) != -1) {
                            PreregistrationActivity preregistrationActivity = (PreregistrationActivity) iVar2.f4811b;
                            float f = UptodownApp.I;
                            if (b4.d.t() && (d0Var = preregistrationActivity.Q) != null && !d0Var.f4510c.isEmpty()) {
                                e4.d0 d0Var2 = preregistrationActivity.Q;
                                d0Var2.getClass();
                                Object obj = d0Var2.f4510c.get(bindingAdapterPosition);
                                obj.getClass();
                                preregistrationActivity.i0(((x4.x1) obj).f11448a);
                                break;
                            }
                        }
                        break;
                    default:
                        f0.i iVar3 = o0Var.f7492l;
                        if (iVar3 != null && (bindingAdapterPosition2 = o0Var.getBindingAdapterPosition()) != -1) {
                            PreregistrationActivity preregistrationActivity2 = (PreregistrationActivity) iVar3.f4811b;
                            float f10 = UptodownApp.I;
                            if (b4.d.t() && preregistrationActivity2.T()) {
                                if (u2.h(preregistrationActivity2) != null) {
                                    e4.d0 d0Var3 = preregistrationActivity2.Q;
                                    d0Var3.getClass();
                                    Object obj2 = d0Var3.f4510c.get(bindingAdapterPosition2);
                                    obj2.getClass();
                                    x4.x1 x1Var = (x4.x1) obj2;
                                    if (!preregistrationActivity2.isFinishing()) {
                                        AlertDialog alertDialog = preregistrationActivity2.F;
                                        if (alertDialog != null) {
                                            alertDialog.dismiss();
                                        }
                                        g4.v e10 = g4.v.e(preregistrationActivity2.getLayoutInflater());
                                        TextView textView = (TextView) e10.f5276l;
                                        TextView textView2 = (TextView) e10.f5280p;
                                        TextView textView3 = (TextView) e10.f5277m;
                                        TextView textView4 = (TextView) e10.f5275b;
                                        textView2.setTypeface(f4.c.f4882w);
                                        textView2.setText(preregistrationActivity2.getString(2131951768));
                                        textView.setTypeface(f4.c.f4883x);
                                        String string = preregistrationActivity2.getString(2131951819, x1Var.f11449b);
                                        string.getClass();
                                        String str = x1Var.f11449b;
                                        str.getClass();
                                        SpannableString spannableString = new SpannableString(string);
                                        int y02 = l7.m.y0(string, str, 0, false, 6);
                                        int length = str.length() + y02;
                                        if (y02 != -1) {
                                            float dimension = preregistrationActivity2.getResources().getDimension(2131166539);
                                            Typeface typeface = f4.c.f4882w;
                                            typeface.getClass();
                                            spannableString.setSpan(new j5.e(dimension, typeface, ContextCompat.getColor(preregistrationActivity2, 2131100787)), y02, length, 33);
                                        }
                                        textView.setText(spannableString);
                                        textView4.setTypeface(f4.c.f4882w);
                                        textView3.setTypeface(f4.c.f4882w);
                                        textView3.setText(preregistrationActivity2.getString(2131951930));
                                        textView4.setVisibility(0);
                                        textView4.setOnClickListener(new a7(preregistrationActivity2, 4));
                                        textView3.setOnClickListener(new c.e(15, preregistrationActivity2, x1Var));
                                        ((ImageView) e10.f5279o).setOnClickListener(new a7(preregistrationActivity2, 5));
                                        AlertDialog.Builder builder = new AlertDialog.Builder(preregistrationActivity2);
                                        builder.setView((RelativeLayout) e10.f5278n);
                                        builder.setCancelable(true);
                                        AlertDialog create = builder.create();
                                        preregistrationActivity2.F = create;
                                        if (create != null) {
                                            Window window = create.getWindow();
                                            if (window != null) {
                                                a4.x.y(window, 0);
                                            }
                                            AlertDialog alertDialog2 = preregistrationActivity2.F;
                                            alertDialog2.getClass();
                                            alertDialog2.show();
                                            break;
                                        }
                                    }
                                } else if (!preregistrationActivity2.isFinishing()) {
                                    AlertDialog alertDialog3 = preregistrationActivity2.F;
                                    if (alertDialog3 != null) {
                                        alertDialog3.dismiss();
                                    }
                                    g4.v e11 = g4.v.e(preregistrationActivity2.getLayoutInflater());
                                    TextView textView5 = (TextView) e11.f5277m;
                                    ((TextView) e11.f5280p).setTypeface(f4.c.f4882w);
                                    ((TextView) e11.f5276l).setTypeface(f4.c.f4883x);
                                    textView5.setTypeface(f4.c.f4882w);
                                    textView5.setOnClickListener(new a7(preregistrationActivity2, 2));
                                    ((ImageView) e11.f5279o).setOnClickListener(new a7(preregistrationActivity2, 3));
                                    AlertDialog.Builder builder2 = new AlertDialog.Builder(preregistrationActivity2);
                                    builder2.setView((RelativeLayout) e11.f5278n);
                                    builder2.setCancelable(true);
                                    AlertDialog create2 = builder2.create();
                                    preregistrationActivity2.F = create2;
                                    if (create2 != null) {
                                        Window window2 = create2.getWindow();
                                        if (window2 != null) {
                                            a4.x.y(window2, 0);
                                        }
                                        AlertDialog alertDialog4 = preregistrationActivity2.F;
                                        alertDialog4.getClass();
                                        alertDialog4.show();
                                        break;
                                    }
                                }
                            }
                        }
                        break;
                }
            }
        });
        TextView textView = (TextView) vVar.f5275b;
        final int i6 = 1;
        textView.setOnClickListener(new View.OnClickListener(this) { // from class: m5.n0

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ o0 f7484b;

            {
                this.f7484b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int bindingAdapterPosition;
                e4.d0 d0Var;
                int bindingAdapterPosition2;
                int i62 = i6;
                o0 o0Var = this.f7484b;
                switch (i62) {
                    case 0:
                        f0.i iVar2 = o0Var.f7492l;
                        if (iVar2 != null && (bindingAdapterPosition = o0Var.getBindingAdapterPosition()) != -1) {
                            PreregistrationActivity preregistrationActivity = (PreregistrationActivity) iVar2.f4811b;
                            float f = UptodownApp.I;
                            if (b4.d.t() && (d0Var = preregistrationActivity.Q) != null && !d0Var.f4510c.isEmpty()) {
                                e4.d0 d0Var2 = preregistrationActivity.Q;
                                d0Var2.getClass();
                                Object obj = d0Var2.f4510c.get(bindingAdapterPosition);
                                obj.getClass();
                                preregistrationActivity.i0(((x4.x1) obj).f11448a);
                                break;
                            }
                        }
                        break;
                    default:
                        f0.i iVar3 = o0Var.f7492l;
                        if (iVar3 != null && (bindingAdapterPosition2 = o0Var.getBindingAdapterPosition()) != -1) {
                            PreregistrationActivity preregistrationActivity2 = (PreregistrationActivity) iVar3.f4811b;
                            float f10 = UptodownApp.I;
                            if (b4.d.t() && preregistrationActivity2.T()) {
                                if (u2.h(preregistrationActivity2) != null) {
                                    e4.d0 d0Var3 = preregistrationActivity2.Q;
                                    d0Var3.getClass();
                                    Object obj2 = d0Var3.f4510c.get(bindingAdapterPosition2);
                                    obj2.getClass();
                                    x4.x1 x1Var = (x4.x1) obj2;
                                    if (!preregistrationActivity2.isFinishing()) {
                                        AlertDialog alertDialog = preregistrationActivity2.F;
                                        if (alertDialog != null) {
                                            alertDialog.dismiss();
                                        }
                                        g4.v e10 = g4.v.e(preregistrationActivity2.getLayoutInflater());
                                        TextView textView2 = (TextView) e10.f5276l;
                                        TextView textView22 = (TextView) e10.f5280p;
                                        TextView textView3 = (TextView) e10.f5277m;
                                        TextView textView4 = (TextView) e10.f5275b;
                                        textView22.setTypeface(f4.c.f4882w);
                                        textView22.setText(preregistrationActivity2.getString(2131951768));
                                        textView2.setTypeface(f4.c.f4883x);
                                        String string = preregistrationActivity2.getString(2131951819, x1Var.f11449b);
                                        string.getClass();
                                        String str = x1Var.f11449b;
                                        str.getClass();
                                        SpannableString spannableString = new SpannableString(string);
                                        int y02 = l7.m.y0(string, str, 0, false, 6);
                                        int length = str.length() + y02;
                                        if (y02 != -1) {
                                            float dimension = preregistrationActivity2.getResources().getDimension(2131166539);
                                            Typeface typeface = f4.c.f4882w;
                                            typeface.getClass();
                                            spannableString.setSpan(new j5.e(dimension, typeface, ContextCompat.getColor(preregistrationActivity2, 2131100787)), y02, length, 33);
                                        }
                                        textView2.setText(spannableString);
                                        textView4.setTypeface(f4.c.f4882w);
                                        textView3.setTypeface(f4.c.f4882w);
                                        textView3.setText(preregistrationActivity2.getString(2131951930));
                                        textView4.setVisibility(0);
                                        textView4.setOnClickListener(new a7(preregistrationActivity2, 4));
                                        textView3.setOnClickListener(new c.e(15, preregistrationActivity2, x1Var));
                                        ((ImageView) e10.f5279o).setOnClickListener(new a7(preregistrationActivity2, 5));
                                        AlertDialog.Builder builder = new AlertDialog.Builder(preregistrationActivity2);
                                        builder.setView((RelativeLayout) e10.f5278n);
                                        builder.setCancelable(true);
                                        AlertDialog create = builder.create();
                                        preregistrationActivity2.F = create;
                                        if (create != null) {
                                            Window window = create.getWindow();
                                            if (window != null) {
                                                a4.x.y(window, 0);
                                            }
                                            AlertDialog alertDialog2 = preregistrationActivity2.F;
                                            alertDialog2.getClass();
                                            alertDialog2.show();
                                            break;
                                        }
                                    }
                                } else if (!preregistrationActivity2.isFinishing()) {
                                    AlertDialog alertDialog3 = preregistrationActivity2.F;
                                    if (alertDialog3 != null) {
                                        alertDialog3.dismiss();
                                    }
                                    g4.v e11 = g4.v.e(preregistrationActivity2.getLayoutInflater());
                                    TextView textView5 = (TextView) e11.f5277m;
                                    ((TextView) e11.f5280p).setTypeface(f4.c.f4882w);
                                    ((TextView) e11.f5276l).setTypeface(f4.c.f4883x);
                                    textView5.setTypeface(f4.c.f4882w);
                                    textView5.setOnClickListener(new a7(preregistrationActivity2, 2));
                                    ((ImageView) e11.f5279o).setOnClickListener(new a7(preregistrationActivity2, 3));
                                    AlertDialog.Builder builder2 = new AlertDialog.Builder(preregistrationActivity2);
                                    builder2.setView((RelativeLayout) e11.f5278n);
                                    builder2.setCancelable(true);
                                    AlertDialog create2 = builder2.create();
                                    preregistrationActivity2.F = create2;
                                    if (create2 != null) {
                                        Window window2 = create2.getWindow();
                                        if (window2 != null) {
                                            a4.x.y(window2, 0);
                                        }
                                        AlertDialog alertDialog4 = preregistrationActivity2.F;
                                        alertDialog4.getClass();
                                        alertDialog4.show();
                                        break;
                                    }
                                }
                            }
                        }
                        break;
                }
            }
        });
        ((TextView) vVar.f5277m).setTypeface(f4.c.f4882w);
        textView.setTypeface(f4.c.f4882w);
        ((TextView) vVar.f5276l).setTypeface(f4.c.f4883x);
    }
}
