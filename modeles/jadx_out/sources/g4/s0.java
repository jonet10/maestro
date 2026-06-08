package g4;

import android.app.AlertDialog;
import android.app.Application;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c4.w4;
import java.net.Socket;
import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class s0 extends h {
    public AlertDialog A;
    public TextView B;
    public TextView C;
    public TextView D;

    /* renamed from: y, reason: collision with root package name */
    public TextView f5257y;

    /* renamed from: z, reason: collision with root package name */
    public ProgressBar f5258z;

    public final void C() {
        View inflate = View.inflate(this, 2131558530, null);
        TextView textView = (TextView) inflate.findViewById(2131364160);
        this.f5257y = textView;
        if (textView != null) {
            textView.setTypeface(f4.c.f4882w);
        }
        ProgressBar progressBar = (ProgressBar) inflate.findViewById(2131363050);
        this.f5258z = progressBar;
        if (progressBar != null) {
            progressBar.setProgress(0);
        }
        TextView textView2 = (TextView) inflate.findViewById(2131363697);
        this.D = textView2;
        textView2.getClass();
        textView2.setTypeface(f4.c.f4882w);
        TextView textView3 = this.D;
        if (textView3 != null) {
            textView3.setOnClickListener(new q0(this, 1));
        }
        TextView textView4 = (TextView) inflate.findViewById(2131364269);
        this.B = textView4;
        if (textView4 != null) {
            textView4.setTypeface(f4.c.f4883x);
        }
        TextView textView5 = (TextView) inflate.findViewById(2131363804);
        this.C = textView5;
        if (textView5 != null) {
            textView5.setTypeface(f4.c.f4882w);
        }
        G(inflate);
    }

    public final void D() {
        ArrayList arrayList;
        m4.g gVar = f4.c.f4884y;
        Integer valueOf = (gVar == null || (arrayList = gVar.g) == null) ? null : Integer.valueOf(arrayList.size());
        valueOf.getClass();
        if (valueOf.intValue() <= 0) {
            i(getString(2131952412));
            return;
        }
        w4 w4Var = (w4) this;
        f0.i iVar = new f0.i(w4Var, 29);
        View inflate = View.inflate(this, 2131558484, null);
        m4.g gVar2 = f4.c.f4884y;
        gVar2.getClass();
        ArrayList arrayList2 = gVar2.g;
        i4.a aVar = new i4.a();
        aVar.f5653a = arrayList2;
        aVar.f5654b = iVar;
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(2131363317);
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), 1, false));
        }
        recyclerView.setAdapter(aVar);
        View findViewById = inflate.findViewById(2131363688);
        findViewById.getClass();
        TextView textView = (TextView) findViewById;
        textView.setTypeface(f4.c.f4882w);
        textView.setOnClickListener(new q0(w4Var, 3));
        G(inflate);
    }

    public final void E() {
        AlertDialog alertDialog = this.A;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        this.A = null;
    }

    public final void G(View view) {
        AlertDialog alertDialog;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(view);
        builder.setCancelable(false);
        AlertDialog create = builder.create();
        this.A = create;
        Window window = create != null ? create.getWindow() : null;
        window.getClass();
        window.setBackgroundDrawable(new ColorDrawable(0));
        if (isFinishing() || (alertDialog = this.A) == null) {
            return;
        }
        alertDialog.show();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Socket socket;
        m4.g gVar;
        super.onResume();
        m4.b bVar = f4.c.f4885z;
        if (bVar != null && ((socket = bVar.f7283d) == null || socket.isClosed())) {
            Application application = getApplication();
            application.getClass();
            if (!((f4.c) application).f4887b.get() && (gVar = f4.c.f4884y) != null) {
                gVar.b();
            }
        }
        AlertDialog alertDialog = this.A;
        if (alertDialog == null || !alertDialog.isShowing()) {
            return;
        }
        if (f4.c.A) {
            f4.c.A = false;
            runOnUiThread(new p0(this, 1));
            t0.f.f(this, null);
            return;
        }
        String str = f4.c.B;
        if (str != null) {
            runOnUiThread(new androidx.work.impl.c(this, str, f4.c.C, 3));
            f4.c.B = null;
            f4.c.C = null;
            return;
        }
        String str2 = f4.c.D;
        if (str2 != null) {
            runOnUiThread(new r0(this, str2, 1));
            f4.c.D = null;
            return;
        }
        String str3 = f4.c.E;
        if (str3 != null) {
            runOnUiThread(new r0(this, str3, 0));
            f4.c.E = null;
        }
    }

    public void F() {
    }
}
