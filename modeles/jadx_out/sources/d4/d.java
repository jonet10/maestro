package d4;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.view.View;
import com.uptodown.activities.preferences.AdvancedPreferencesActivity;
import com.uptodown.core.activities.FileExplorerActivity;
import e4.s0;
import e4.u0;
import m5.d0;
import m5.d1;
import m5.f1;
import m5.g1;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class d implements View.OnLongClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3563a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3564b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Object f3565l;

    public /* synthetic */ d(int i, Object obj, Object obj2) {
        this.f3563a = i;
        this.f3564b = obj;
        this.f3565l = obj2;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        int i = this.f3563a;
        Object obj = this.f3565l;
        Object obj2 = this.f3564b;
        switch (i) {
            case 0:
                AdvancedPreferencesActivity advancedPreferencesActivity = (AdvancedPreferencesActivity) obj2;
                String str = (String) obj;
                int i6 = AdvancedPreferencesActivity.Q;
                if (str != null && str.length() != 0) {
                    Object systemService = advancedPreferencesActivity.getSystemService("clipboard");
                    systemService.getClass();
                    ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText(null, str));
                }
                String string = advancedPreferencesActivity.getString(2131952069);
                string.getClass();
                advancedPreferencesActivity.A(string);
                break;
            case 1:
                ((e4.i) obj2).f4556b.e((x4.g) obj);
                break;
            case 2:
                ((e4.k) obj2).f4577l.e((x4.g) obj);
                break;
            case 3:
                ((e4.l) obj2).f4592l.e((x4.g) obj);
                break;
            case 4:
                ((s0) obj2).f4686b.e((x4.g) obj);
                break;
            case 5:
                ((u0) obj2).f4703b.e((x4.g) obj);
                break;
            case 6:
                x4.g gVar = (x4.g) obj;
                w4.a aVar = ((m5.c) obj2).f7324l;
                if (aVar != null) {
                    aVar.e(gVar);
                    break;
                }
                break;
            case 7:
                ((d0) obj2).f7345l.e((x4.g) obj);
                break;
            case 8:
                ((d1) obj2).f7357m.e((x4.g) obj);
                break;
            case 9:
                ((f1) obj2).f7381m.e((x4.g) obj);
                break;
            case 10:
                x4.g gVar2 = (x4.g) obj;
                w4.a aVar2 = ((g1) obj2).f7399l;
                if (aVar2 != null) {
                    aVar2.e(gVar2);
                    break;
                }
                break;
            default:
                r4.b bVar = (r4.b) obj2;
                int absoluteAdapterPosition = bVar.getAbsoluteAdapterPosition();
                if (absoluteAdapterPosition != -1) {
                    f0.i iVar = bVar.f8901a;
                    iVar.getClass();
                    FileExplorerActivity fileExplorerActivity = (FileExplorerActivity) iVar.f4811b;
                    i4.b bVar2 = fileExplorerActivity.V;
                    if (bVar2 != null) {
                        if (!bVar2.f5657c) {
                            bVar2.c(true);
                            i4.b bVar3 = fileExplorerActivity.V;
                            bVar3.getClass();
                            bVar3.b(absoluteAdapterPosition);
                            FileExplorerActivity.Q(fileExplorerActivity);
                            break;
                        } else {
                            bVar2.b(absoluteAdapterPosition);
                            i4.b bVar4 = fileExplorerActivity.V;
                            bVar4.getClass();
                            if (!bVar4.a().contains(obj)) {
                                fileExplorerActivity.U();
                                i4.b bVar5 = fileExplorerActivity.V;
                                bVar5.getClass();
                                bVar5.c(false);
                                break;
                            } else {
                                FileExplorerActivity.Q(fileExplorerActivity);
                                break;
                            }
                        }
                    }
                }
                break;
        }
        return true;
    }

    public /* synthetic */ d(Object obj, x4.g gVar, int i, int i6) {
        this.f3563a = i6;
        this.f3564b = obj;
        this.f3565l = gVar;
    }
}
