package c4;

import androidx.appcompat.widget.SearchView;
import com.uptodown.activities.MyDownloads;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class h5 implements SearchView.OnQueryTextListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MyDownloads f1677a;

    public h5(MyDownloads myDownloads) {
        this.f1677a = myDownloads;
    }

    @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
    public final boolean onQueryTextChange(String str) {
        str.getClass();
        int i = MyDownloads.V;
        MyDownloads myDownloads = this.f1677a;
        myDownloads.B0().f1950e = str;
        myDownloads.C0(false);
        return false;
    }

    @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
    public final boolean onQueryTextSubmit(String str) {
        str.getClass();
        int i = MyDownloads.V;
        MyDownloads myDownloads = this.f1677a;
        myDownloads.B0().f1950e = str;
        myDownloads.C0(false);
        return true;
    }
}
