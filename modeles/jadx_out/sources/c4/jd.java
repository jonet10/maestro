package c4;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.view.View;
import com.uptodown.activities.VirusTotalReport;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class jd implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1774a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ VirusTotalReport f1775b;

    public /* synthetic */ jd(VirusTotalReport virusTotalReport, int i) {
        this.f1774a = i;
        this.f1775b = virusTotalReport;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.f1774a;
        VirusTotalReport virusTotalReport = this.f1775b;
        switch (i) {
            case 0:
                int i6 = VirusTotalReport.Q;
                String obj = virusTotalReport.y0().v.getText().toString();
                if (obj != null && obj.length() != 0) {
                    Object systemService = virusTotalReport.getSystemService("clipboard");
                    systemService.getClass();
                    ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText(null, obj));
                    break;
                }
                break;
            case 1:
                int i10 = VirusTotalReport.Q;
                String obj2 = virusTotalReport.y0().f9923x.getText().toString();
                if (obj2 != null && obj2.length() != 0) {
                    Object systemService2 = virusTotalReport.getSystemService("clipboard");
                    systemService2.getClass();
                    ((ClipboardManager) systemService2).setPrimaryClip(ClipData.newPlainText(null, obj2));
                    break;
                }
                break;
            case 2:
                int i11 = VirusTotalReport.Q;
                virusTotalReport.getOnBackPressedDispatcher().onBackPressed();
                break;
            case 3:
                int i12 = VirusTotalReport.Q;
                if (virusTotalReport.z0().f1971e.getValue() != null) {
                    Object value = virusTotalReport.z0().f1971e.getValue();
                    value.getClass();
                    String str = ((x4.f2) value).f11157p;
                    if (str != null && str.length() != 0) {
                        Object value2 = virusTotalReport.z0().f1971e.getValue();
                        value2.getClass();
                        String str2 = ((x4.f2) value2).f11157p;
                        str2.getClass();
                        j5.c.e(virusTotalReport, str2, null);
                        break;
                    }
                }
                if (virusTotalReport.z0().f1969c.getValue() == null) {
                    if (virusTotalReport.z0().f1970d.getValue() != null) {
                        Object value3 = virusTotalReport.z0().f1970d.getValue();
                        value3.getClass();
                        virusTotalReport.l0(((x4.e) value3).B);
                        break;
                    }
                } else {
                    Object value4 = virusTotalReport.z0().f1969c.getValue();
                    value4.getClass();
                    virusTotalReport.l0(((x4.g) value4).P);
                    break;
                }
                break;
            case 4:
                int i13 = VirusTotalReport.Q;
                String string = virusTotalReport.getString(2131952735);
                string.getClass();
                j5.c.e(virusTotalReport, string, null);
                break;
            default:
                int i14 = VirusTotalReport.Q;
                String string2 = virusTotalReport.getString(2131952733);
                string2.getClass();
                j5.c.e(virusTotalReport, string2, null);
                break;
        }
    }
}
