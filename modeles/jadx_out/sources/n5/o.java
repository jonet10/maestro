package n5;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.uptodown.UptodownApp;
import d7.p;
import java.util.HashMap;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public final Context f8101a;

    /* renamed from: b, reason: collision with root package name */
    public final View f8102b;

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f8103c;

    /* renamed from: d, reason: collision with root package name */
    public final p f8104d;

    public o(Context context, View view, HashMap hashMap, p pVar) {
        this.f8101a = context;
        this.f8102b = view;
        this.f8103c = hashMap;
        this.f8104d = pVar;
    }

    public final void a() {
        Context context = this.f8101a;
        View inflate = LayoutInflater.from(context).inflate(2131558858, (ViewGroup) null, false);
        if (((RecyclerView) ViewBindings.findChildViewById(inflate, 2131363082)) == null) {
            com.google.gson.internal.a.i("Missing required view with ID: ".concat(inflate.getResources().getResourceName(2131363082)));
            return;
        }
        final LinearLayout linearLayout = (LinearLayout) inflate;
        linearLayout.getClass();
        View view = this.f8102b;
        boolean z9 = true;
        PopupWindow popupWindow = new PopupWindow((View) linearLayout, view.getWidth(), -2, true);
        float f = UptodownApp.I;
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("SettingsPreferences", 0);
            if (sharedPreferences.contains("animations")) {
                z9 = sharedPreferences.getBoolean("animations", true);
            }
        } catch (Exception unused) {
        }
        if (z9) {
            float f10 = UptodownApp.I;
            linearLayout.startAnimation(AnimationUtils.loadAnimation(context, 2130772027));
            linearLayout.setVisibility(0);
        } else {
            linearLayout.setVisibility(0);
        }
        View findViewById = linearLayout.findViewById(2131363082);
        findViewById.getClass();
        RecyclerView recyclerView = (RecyclerView) findViewById;
        n nVar = new n(this.f8103c, new k(this, popupWindow));
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(nVar);
        popupWindow.setElevation(10.0f);
        popupWindow.showAsDropDown(view);
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: n5.l
            @Override // android.widget.PopupWindow.OnDismissListener
            public final void onDismiss() {
                Context context2 = o.this.f8101a;
                float f11 = UptodownApp.I;
                boolean z10 = true;
                try {
                    SharedPreferences sharedPreferences2 = context2.getSharedPreferences("SettingsPreferences", 0);
                    if (sharedPreferences2.contains("animations")) {
                        z10 = sharedPreferences2.getBoolean("animations", true);
                    }
                } catch (Exception unused2) {
                }
                LinearLayout linearLayout2 = linearLayout;
                if (!z10) {
                    linearLayout2.setVisibility(8);
                    return;
                }
                float f12 = UptodownApp.I;
                linearLayout2.startAnimation(AnimationUtils.loadAnimation(context2, 2130772000));
                linearLayout2.setVisibility(8);
            }
        });
    }
}
