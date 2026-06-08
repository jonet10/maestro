package c4;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.view.View;
import androidx.lifecycle.LifecycleOwnerKt;
import com.uptodown.activities.MoreInfo;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class t3 implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2112a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MoreInfo f2113b;

    public /* synthetic */ t3(MoreInfo moreInfo, int i) {
        this.f2112a = i;
        this.f2113b = moreInfo;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.f2112a;
        final int i6 = 0;
        t6.c cVar = null;
        final MoreInfo moreInfo = this.f2113b;
        switch (i) {
            case 0:
                int i10 = MoreInfo.V;
                o7.c0.s(LifecycleOwnerKt.getLifecycleScope(moreInfo), null, null, new x3(moreInfo, cVar, 4), 3);
                break;
            case 1:
                int i11 = MoreInfo.V;
                String string = moreInfo.getString(2131951958);
                string.getClass();
                String string2 = moreInfo.getString(2131952729);
                string2.getClass();
                j5.c.e(moreInfo, string2, string);
                break;
            case 2:
                int i12 = MoreInfo.V;
                moreInfo.getOnBackPressedDispatcher().onBackPressed();
                break;
            case 3:
                x4.g gVar = moreInfo.Q;
                gVar.getClass();
                String str = gVar.F;
                if (str != null && str.length() != 0) {
                    Object systemService = moreInfo.getSystemService("clipboard");
                    systemService.getClass();
                    ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText(null, str));
                    break;
                }
                break;
            case 4:
                x4.g gVar2 = moreInfo.Q;
                gVar2.getClass();
                x4.j jVar = gVar2.G;
                jVar.getClass();
                moreInfo.C0(jVar);
                break;
            case 5:
                int i13 = MoreInfo.V;
                if (!moreInfo.isFinishing() && moreInfo.T()) {
                    x4.g gVar3 = moreInfo.Q;
                    gVar3.getClass();
                    String str2 = gVar3.V;
                    str2.getClass();
                    j5.c.e(moreInfo, str2, null);
                    break;
                }
                break;
            case 6:
                x4.g gVar4 = moreInfo.Q;
                gVar4.getClass();
                String str3 = gVar4.P;
                if (str3 != null && str3.length() != 0) {
                    Object systemService2 = moreInfo.getSystemService("clipboard");
                    systemService2.getClass();
                    ((ClipboardManager) systemService2).setPrimaryClip(ClipData.newPlainText(null, str3));
                    break;
                }
                break;
            case 7:
                int i14 = MoreInfo.V;
                if (moreInfo.B0().f10195s.getVisibility() != 0) {
                    moreInfo.B0().f10195s.setVisibility(0);
                    moreInfo.B0().f10187o.setImageResource(2131231370);
                    moreInfo.B0().M.post(new Runnable() { // from class: c4.v3
                        @Override // java.lang.Runnable
                        public final void run() {
                            int i15 = i6;
                            MoreInfo moreInfo2 = moreInfo;
                            switch (i15) {
                                case 0:
                                    int i16 = MoreInfo.V;
                                    moreInfo2.B0().M.smoothScrollTo(0, moreInfo2.B0().G.getTop());
                                    break;
                                default:
                                    int i17 = MoreInfo.V;
                                    moreInfo2.B0().M.smoothScrollTo(0, moreInfo2.B0().B.getTop());
                                    break;
                            }
                        }
                    });
                    break;
                } else {
                    moreInfo.B0().f10195s.setVisibility(8);
                    moreInfo.B0().f10187o.setImageResource(2131231374);
                    break;
                }
            case 8:
                x4.g gVar5 = moreInfo.Q;
                gVar5.getClass();
                String str4 = gVar5.M;
                if (str4 != null && str4.length() != 0) {
                    Object systemService3 = moreInfo.getSystemService("clipboard");
                    systemService3.getClass();
                    ((ClipboardManager) systemService3).setPrimaryClip(ClipData.newPlainText(null, str4));
                    break;
                }
                break;
            default:
                int i15 = MoreInfo.V;
                if (moreInfo.B0().f10191q.getVisibility() != 0) {
                    moreInfo.B0().f10191q.setVisibility(0);
                    moreInfo.B0().f10186n.setImageResource(2131231370);
                    final int i16 = 1;
                    moreInfo.B0().M.post(new Runnable() { // from class: c4.v3
                        @Override // java.lang.Runnable
                        public final void run() {
                            int i152 = i16;
                            MoreInfo moreInfo2 = moreInfo;
                            switch (i152) {
                                case 0:
                                    int i162 = MoreInfo.V;
                                    moreInfo2.B0().M.smoothScrollTo(0, moreInfo2.B0().G.getTop());
                                    break;
                                default:
                                    int i17 = MoreInfo.V;
                                    moreInfo2.B0().M.smoothScrollTo(0, moreInfo2.B0().B.getTop());
                                    break;
                            }
                        }
                    });
                    break;
                } else {
                    moreInfo.B0().f10191q.setVisibility(8);
                    moreInfo.B0().f10186n.setImageResource(2131231374);
                    break;
                }
        }
    }
}
