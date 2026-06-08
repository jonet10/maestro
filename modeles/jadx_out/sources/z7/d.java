package z7;

import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBindings;
import b2.t1;
import com.uptodown.activities.PasswordEditActivity;
import t4.f0;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class d implements d7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11984a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f11985b;

    public /* synthetic */ d(Object obj, int i) {
        this.f11984a = i;
        this.f11985b = obj;
    }

    @Override // d7.a
    public final Object invoke() {
        int i = this.f11984a;
        Object obj = this.f11985b;
        switch (i) {
            case 0:
                e eVar = (e) obj;
                b8.f o10 = t1.o("kotlinx.serialization.Polymorphic", b8.c.h, new b8.e[0], new androidx.room.b(eVar, 19));
                j7.c cVar = eVar.f11986a;
                cVar.getClass();
                return new b8.b(o10, cVar);
            default:
                int i6 = PasswordEditActivity.Q;
                View inflate = ((PasswordEditActivity) obj).getLayoutInflater().inflate(2131558766, (ViewGroup) null, false);
                int i10 = 2131362145;
                EditText editText = (EditText) ViewBindings.findChildViewById(inflate, 2131362145);
                if (editText != null) {
                    i10 = 2131362156;
                    EditText editText2 = (EditText) ViewBindings.findChildViewById(inflate, 2131362156);
                    if (editText2 != null) {
                        i10 = 2131362332;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(inflate, 2131362332);
                        if (imageView != null) {
                            i10 = 2131362444;
                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(inflate, 2131362444);
                            if (imageView2 != null) {
                                i10 = 2131362807;
                                View findChildViewById = ViewBindings.findChildViewById(inflate, 2131362807);
                                if (findChildViewById != null) {
                                    i10 = 2131363555;
                                    Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(inflate, 2131363555);
                                    if (toolbar != null) {
                                        i10 = 2131363855;
                                        TextView textView = (TextView) ViewBindings.findChildViewById(inflate, 2131363855);
                                        if (textView != null) {
                                            i10 = 2131363985;
                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(inflate, 2131363985);
                                            if (textView2 != null) {
                                                i10 = 2131363994;
                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(inflate, 2131363994);
                                                if (textView3 != null) {
                                                    i10 = 2131364145;
                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(inflate, 2131364145);
                                                    if (textView4 != null) {
                                                        i10 = 2131364418;
                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(inflate, 2131364418);
                                                        if (textView5 != null) {
                                                            return new f0((RelativeLayout) inflate, editText, editText2, imageView, imageView2, findChildViewById, toolbar, textView, textView2, textView3, textView4, textView5);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                com.google.gson.internal.a.i("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i10)));
                return null;
        }
    }
}
