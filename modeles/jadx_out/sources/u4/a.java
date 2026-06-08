package u4;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.uptodown.activities.AppDetailActivity;
import com.uptodown.activities.MainActivity;
import com.uptodown.activities.MoreInfo;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10413a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f10414b;

    public /* synthetic */ a(d dVar, int i) {
        this.f10413a = i;
        this.f10414b = dVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f10413a) {
            case 0:
                d dVar = this.f10414b;
                FragmentActivity activity = dVar.getActivity();
                if (!(activity instanceof MainActivity)) {
                    if (!(activity instanceof AppDetailActivity)) {
                        if (activity instanceof MoreInfo) {
                            FragmentActivity activity2 = dVar.getActivity();
                            activity2.getClass();
                            ((MoreInfo) activity2).finish();
                            break;
                        }
                    } else {
                        FragmentActivity activity3 = dVar.getActivity();
                        activity3.getClass();
                        ((AppDetailActivity) activity3).finish();
                        break;
                    }
                } else {
                    FragmentActivity activity4 = dVar.getActivity();
                    activity4.getClass();
                    ((MainActivity) activity4).h1();
                    break;
                }
                break;
            default:
                FragmentActivity activity5 = this.f10414b.getActivity();
                activity5.getClass();
                ((c4.k0) activity5).Q();
                break;
        }
    }
}
