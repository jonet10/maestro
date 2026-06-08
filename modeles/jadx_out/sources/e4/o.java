package e4;

import android.text.Layout;
import android.text.SpannableString;
import android.text.style.AlignmentSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import x4.q1;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class o extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f4645a;

    /* renamed from: b, reason: collision with root package name */
    public final f0.i f4646b;

    /* renamed from: c, reason: collision with root package name */
    public final String f4647c;

    public o(ArrayList arrayList, f0.i iVar, String str) {
        iVar.getClass();
        this.f4645a = arrayList;
        this.f4646b = iVar;
        this.f4647c = str;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        ArrayList arrayList = this.f4645a;
        if (arrayList == null) {
            return 0;
        }
        arrayList.getClass();
        return arrayList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        m5.a0 a0Var = (m5.a0) viewHolder;
        a0Var.getClass();
        ArrayList arrayList = this.f4645a;
        q1 q1Var = arrayList != null ? (q1) arrayList.get(i) : null;
        q1Var.getClass();
        String str = this.f4647c;
        str.getClass();
        TextView textView = a0Var.f7303b;
        textView.setText(q1Var.f11340a);
        a0Var.f7304l.setText(q1Var.f11341b);
        a0Var.itemView.setOnClickListener(new g4.b0(11, a0Var, q1Var));
        if (l7.u.m0(q1Var.f11342c, "ar", false)) {
            if (str.equals("ar")) {
                return;
            }
            SpannableString spannableString = new SpannableString(q1Var.f11340a);
            spannableString.setSpan(new AlignmentSpan.Standard(Layout.Alignment.ALIGN_OPPOSITE), 0, spannableString.length(), 33);
            textView.setText(spannableString);
            return;
        }
        if (str.equals("ar")) {
            SpannableString spannableString2 = new SpannableString(q1Var.f11340a);
            spannableString2.setSpan(new AlignmentSpan.Standard(Layout.Alignment.ALIGN_OPPOSITE), 0, spannableString2.length(), 33);
            textView.setText(spannableString2);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View s6 = androidx.lifecycle.l.s(viewGroup, 2131558588, viewGroup, false);
        s6.getClass();
        f0.i iVar = this.f4646b;
        iVar.getClass();
        m5.a0 a0Var = new m5.a0(s6);
        a0Var.f7302a = iVar;
        View findViewById = s6.findViewById(2131363940);
        findViewById.getClass();
        TextView textView = (TextView) findViewById;
        a0Var.f7303b = textView;
        View findViewById2 = s6.findViewById(2131363939);
        findViewById2.getClass();
        TextView textView2 = (TextView) findViewById2;
        a0Var.f7304l = textView2;
        textView.setTypeface(f4.c.f4883x);
        textView2.setTypeface(f4.c.f4883x);
        return a0Var;
    }
}
