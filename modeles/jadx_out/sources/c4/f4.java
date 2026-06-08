package c4;

import androidx.appcompat.widget.SearchView;
import com.uptodown.activities.MyApps;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class f4 implements SearchView.OnQueryTextListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MyApps f1590a;

    public f4(MyApps myApps) {
        this.f1590a = myApps;
    }

    @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
    public final boolean onQueryTextChange(String str) {
        str.getClass();
        int i = MyApps.f3328g0;
        MyApps myApps = this.f1590a;
        myApps.R0().f2344d = str;
        myApps.S0(true);
        return false;
    }

    @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
    public final boolean onQueryTextSubmit(String str) {
        str.getClass();
        int i = MyApps.f3328g0;
        MyApps myApps = this.f1590a;
        myApps.R0().f2344d = str;
        myApps.S0(true);
        return true;
    }
}
