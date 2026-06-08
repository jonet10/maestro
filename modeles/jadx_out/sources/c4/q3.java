package c4;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.uptodown.activities.MainActivity;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class q3 extends FragmentStateAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MainActivity f2010a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q3(MainActivity mainActivity, FragmentManager fragmentManager, Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
        this.f2010a = mainActivity;
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter
    public final Fragment createFragment(int i) {
        MainActivity mainActivity = this.f2010a;
        if (i == 0) {
            u4.m1 m1Var = new u4.m1();
            mainActivity.f3316o0 = m1Var;
            return m1Var;
        }
        if (i == 1) {
            String string = mainActivity.getString(2131952658);
            u4.g1 g1Var = new u4.g1(string);
            Bundle bundle = new Bundle();
            bundle.putInt("id", 523);
            bundle.putString("name", string);
            bundle.putString("description", null);
            bundle.putBoolean("isFloating", false);
            bundle.putInt("parentCategoryId", 0);
            bundle.putInt("isGame", 0);
            bundle.putBoolean("isLeaf", false);
            g1Var.setArguments(bundle);
            mainActivity.f3315m0 = g1Var;
            return g1Var;
        }
        if (i != 2) {
            u4.f1 f1Var = new u4.f1();
            mainActivity.f3317p0 = f1Var;
            return f1Var;
        }
        String string2 = mainActivity.getString(2131951720);
        string2.getClass();
        u4.w0 w0Var = new u4.w0(string2);
        Bundle bundle2 = new Bundle();
        bundle2.putInt("id", 831);
        bundle2.putString("name", string2);
        bundle2.putString("description", null);
        bundle2.putBoolean("isFloating", false);
        bundle2.putInt("parentCategoryId", 0);
        bundle2.putInt("isGame", 0);
        bundle2.putBoolean("isLeaf", false);
        w0Var.setArguments(bundle2);
        mainActivity.n0 = w0Var;
        return w0Var;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return 4;
    }
}
