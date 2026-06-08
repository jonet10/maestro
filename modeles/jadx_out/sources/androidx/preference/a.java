package androidx.preference;

import androidx.fragment.app.FragmentManager;
import com.uptodown.activities.ListsActivity;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final /* synthetic */ class a implements FragmentManager.OnBackStackChangedListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f459a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f460b;

    public /* synthetic */ a(Object obj, int i) {
        this.f459a = i;
        this.f460b = obj;
    }

    @Override // androidx.fragment.app.FragmentManager.OnBackStackChangedListener
    public final void onBackStackChanged() {
        int i = this.f459a;
        Object obj = this.f460b;
        switch (i) {
            case 0:
                PreferenceHeaderFragmentCompat.m82onViewCreated$lambda10((PreferenceHeaderFragmentCompat) obj);
                break;
            default:
                ListsActivity listsActivity = (ListsActivity) obj;
                int i6 = ListsActivity.S;
                if (listsActivity.getSupportFragmentManager().getBackStackEntryCount() == 0 && listsActivity.Q) {
                    listsActivity.Q = false;
                    listsActivity.D0();
                    break;
                }
                break;
        }
    }
}
