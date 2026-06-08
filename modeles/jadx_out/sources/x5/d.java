package x5;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import n4.i;
import u4.f;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class d extends p9.a {
    public static final /* synthetic */ int V = 0;
    public TextView A;
    public TextView B;
    public TextView C;
    public TextView D;
    public TextView E;
    public TextView F;
    public TextView G;
    public TextView H;
    public TextView I;
    public TextView J;
    public TextView K;
    public TextView L;
    public TextView M;
    public TextView N;
    public TextView O;
    public TextView P;
    public TextView Q;
    public TextView R;
    public ImageView S;
    public b T;
    public e U;

    /* renamed from: z, reason: collision with root package name */
    public TextView f11510z;

    public static void a(TextView textView, TextView textView2, String str, String str2) {
        if (str.length() > 0 && textView != null) {
            textView.setText(str);
        }
        if (str2.length() > 0) {
            if (textView2 == null) {
                return;
            }
            textView2.setText(str2);
        } else {
            if (textView != null) {
                textView.setVisibility(8);
            }
            if (textView2 == null) {
                return;
            }
            textView2.setVisibility(8);
        }
    }

    public final void b(String str, String str2, TextView textView) {
        if (str.length() > 0 && textView != null) {
            textView.setText(str);
        }
        if (URLUtil.isValidUrl(str2)) {
            if (textView == null) {
                return;
            }
            textView.setOnClickListener(new f(12, this, str2));
        } else {
            if (textView == null) {
                return;
            }
            textView.setVisibility(8);
        }
    }

    @Override // p9.a, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        b bVar = arguments == null ? null : (b) i.a(arguments, "partner_detail_args", b.class);
        if (bVar == null) {
            bVar = new b(null, null, null, null, null, null, null, null, null, null, null, null, 0, 0, null, null, null, 131071);
        }
        this.T = bVar;
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        ViewModelStore viewModelStore = activity.getViewModelStore();
        viewModelStore.getClass();
        this.U = (e) new ViewModelProvider(viewModelStore, new b6.i(8)).get(e.class);
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater.getClass();
        View inflate = layoutInflater.inflate(2131558518, viewGroup, false);
        inflate.getClass();
        return inflate;
    }

    /* JADX WARN: Removed duplicated region for block: B:121:0x039f  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x03b3  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x03ca  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0483  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x04a1  */
    @Override // p9.a, androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onViewCreated(android.view.View r27, android.os.Bundle r28) {
        /*
            Method dump skipped, instructions count: 1206
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: x5.d.onViewCreated(android.view.View, android.os.Bundle):void");
    }
}
