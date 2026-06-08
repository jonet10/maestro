package b6;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import java.util.List;
import l7.k;
import q6.l;
import q6.m;
import q6.t;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class f extends m.a {

    /* renamed from: z, reason: collision with root package name */
    public static final /* synthetic */ int f1075z = 0;

    /* renamed from: n, reason: collision with root package name */
    public ConstraintLayout f1076n;

    /* renamed from: o, reason: collision with root package name */
    public ImageView f1077o;

    /* renamed from: p, reason: collision with root package name */
    public Button f1078p;

    /* renamed from: q, reason: collision with root package name */
    public Button f1079q;

    /* renamed from: r, reason: collision with root package name */
    public Button f1080r;

    /* renamed from: s, reason: collision with root package name */
    public TextView f1081s;

    /* renamed from: t, reason: collision with root package name */
    public TextView f1082t;

    /* renamed from: u, reason: collision with root package name */
    public TextView f1083u;
    public Group v;

    /* renamed from: w, reason: collision with root package name */
    public TextView f1084w;

    /* renamed from: x, reason: collision with root package name */
    public ImageView f1085x;

    /* renamed from: y, reason: collision with root package name */
    public h f1086y;

    @Override // m.a
    public final void b(ViewStub viewStub) {
        viewStub.setLayoutResource(2131558566);
        View inflate = viewStub.inflate();
        inflate.getClass();
        this.f1076n = (ConstraintLayout) inflate.findViewById(2131363045);
        this.f1077o = (ImageView) inflate.findViewById(2131362331);
        this.f1078p = (Button) inflate.findViewById(2131361985);
        this.f1079q = (Button) inflate.findViewById(2131361983);
        this.f1080r = (Button) inflate.findViewById(2131361979);
        this.f1081s = (TextView) inflate.findViewById(2131363972);
        this.f1082t = (TextView) inflate.findViewById(2131363991);
        this.f1083u = (TextView) inflate.findViewById(2131364363);
        this.v = (Group) inflate.findViewById(2131362211);
        this.f1085x = (ImageView) inflate.findViewById(2131362372);
        this.f1084w = (TextView) inflate.findViewById(2131364170);
    }

    public final void c(String str, SpannableString spannableString, String str2, ClickableSpan clickableSpan, boolean z9) {
        Object next;
        List d02;
        str2.getClass();
        k7.d a8 = k.a(new k(str2, 0), str);
        if (((d7.a) a8.f6992b).invoke() == null) {
            a8 = null;
        }
        if (a8 == null) {
            d02 = null;
        } else {
            if (z9) {
                k7.e eVar = new k7.e(a8);
                if (!eVar.hasNext()) {
                    androidx.privacysandbox.ads.adservices.customaudience.a.s("Sequence is empty.");
                    return;
                } else {
                    next = eVar.next();
                    while (eVar.hasNext()) {
                        next = eVar.next();
                    }
                }
            } else {
                k7.e eVar2 = new k7.e(a8);
                if (!eVar2.hasNext()) {
                    androidx.privacysandbox.ads.adservices.customaudience.a.s("Sequence is empty.");
                    return;
                }
                next = eVar2.next();
            }
            i7.d b7 = ((l7.i) next).b();
            d02 = m.d0(Integer.valueOf(b7.f5695a), Integer.valueOf(str2.length() + b7.f5695a));
        }
        if (d02 == null) {
            d02 = t.f8724a;
        }
        if (d02.isEmpty()) {
            return;
        }
        spannableString.setSpan(clickableSpan, ((Number) l.q0(d02)).intValue(), ((Number) l.y0(d02)).intValue(), 33);
        Context context = getContext();
        if (context == null) {
            return;
        }
        h9.d dVar = this.f7263a;
        Integer num = dVar != null ? dVar.f5501l : null;
        spannableString.setSpan(new ForegroundColorSpan(num == null ? ContextCompat.getColor(context, 2131099738) : num.intValue()), ((Number) l.q0(d02)).intValue(), ((Number) l.y0(d02)).intValue(), 33);
    }

    @Override // m.a, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        ViewModelStore viewModelStore = activity.getViewModelStore();
        viewModelStore.getClass();
        this.f1086y = (h) new ViewModelProvider(viewModelStore, new i(0)).get(h.class);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:129:0x024e  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x02c2  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x037e  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x03ce  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01ef  */
    /* JADX WARN: Type inference failed for: r5v7, types: [java.lang.Iterable, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v4, types: [java.lang.Object, java.util.List] */
    @Override // m.a, androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onViewCreated(android.view.View r13, android.os.Bundle r14) {
        /*
            Method dump skipped, instructions count: 1018
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b6.f.onViewCreated(android.view.View, android.os.Bundle):void");
    }
}
