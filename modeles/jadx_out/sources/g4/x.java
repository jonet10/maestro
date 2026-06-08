package g4;

import androidx.appcompat.widget.SearchView;
import com.uptodown.core.activities.FileExplorerActivity;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class x implements SearchView.OnQueryTextListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FileExplorerActivity f5282a;

    public x(FileExplorerActivity fileExplorerActivity) {
        this.f5282a = fileExplorerActivity;
    }

    @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
    public final boolean onQueryTextChange(String str) {
        str.getClass();
        int i = FileExplorerActivity.f3379q0;
        this.f5282a.S(str, null);
        return false;
    }

    @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
    public final boolean onQueryTextSubmit(String str) {
        str.getClass();
        int i = FileExplorerActivity.f3379q0;
        this.f5282a.S(str, null);
        return true;
    }
}
