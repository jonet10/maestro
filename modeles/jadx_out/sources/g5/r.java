package g5;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.leanback.app.BrowseSupportFragment;
import androidx.leanback.widget.Row;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class r extends BrowseSupportFragment.FragmentFactory {
    @Override // androidx.leanback.app.BrowseSupportFragment.FragmentFactory
    public final Fragment createFragment(Object obj) {
        obj.getClass();
        long id = ((Row) obj).getHeaderItem().getId();
        if (id == 1) {
            return new q();
        }
        if (id == 2) {
            return new n();
        }
        if (id != 3) {
            if (id == 4) {
                return new v();
            }
            return null;
        }
        n0 n0Var = new n0();
        Bundle bundle = new Bundle();
        bundle.putInt("id", -1);
        bundle.putString("name", "");
        bundle.putString("description", null);
        bundle.putBoolean("isFloating", false);
        bundle.putInt("parentCategoryId", 0);
        bundle.putInt("isGame", 0);
        bundle.putBoolean("isLeaf", false);
        n0Var.setArguments(bundle);
        return n0Var;
    }
}
