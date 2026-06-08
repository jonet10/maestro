package androidx.fragment.app;

import d7.l;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class FragmentManagerKt {
    public static final void commit(FragmentManager fragmentManager, boolean z9, l lVar) {
        fragmentManager.getClass();
        lVar.getClass();
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        beginTransaction.getClass();
        lVar.invoke(beginTransaction);
        if (z9) {
            beginTransaction.commitAllowingStateLoss();
        } else {
            beginTransaction.commit();
        }
    }

    public static /* synthetic */ void commit$default(FragmentManager fragmentManager, boolean z9, l lVar, int i, Object obj) {
        if ((i & 1) != 0) {
            z9 = false;
        }
        fragmentManager.getClass();
        lVar.getClass();
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        beginTransaction.getClass();
        lVar.invoke(beginTransaction);
        if (z9) {
            beginTransaction.commitAllowingStateLoss();
        } else {
            beginTransaction.commit();
        }
    }

    public static final void commitNow(FragmentManager fragmentManager, boolean z9, l lVar) {
        fragmentManager.getClass();
        lVar.getClass();
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        beginTransaction.getClass();
        lVar.invoke(beginTransaction);
        if (z9) {
            beginTransaction.commitNowAllowingStateLoss();
        } else {
            beginTransaction.commitNow();
        }
    }

    public static /* synthetic */ void commitNow$default(FragmentManager fragmentManager, boolean z9, l lVar, int i, Object obj) {
        if ((i & 1) != 0) {
            z9 = false;
        }
        fragmentManager.getClass();
        lVar.getClass();
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        beginTransaction.getClass();
        lVar.invoke(beginTransaction);
        if (z9) {
            beginTransaction.commitNowAllowingStateLoss();
        } else {
            beginTransaction.commitNow();
        }
    }

    public static final void transaction(FragmentManager fragmentManager, boolean z9, boolean z10, l lVar) {
        fragmentManager.getClass();
        lVar.getClass();
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        beginTransaction.getClass();
        lVar.invoke(beginTransaction);
        if (z9) {
            if (z10) {
                beginTransaction.commitNowAllowingStateLoss();
                return;
            } else {
                beginTransaction.commitNow();
                return;
            }
        }
        if (z10) {
            beginTransaction.commitAllowingStateLoss();
        } else {
            beginTransaction.commit();
        }
    }

    public static /* synthetic */ void transaction$default(FragmentManager fragmentManager, boolean z9, boolean z10, l lVar, int i, Object obj) {
        if ((i & 1) != 0) {
            z9 = false;
        }
        if ((i & 2) != 0) {
            z10 = false;
        }
        fragmentManager.getClass();
        lVar.getClass();
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        beginTransaction.getClass();
        lVar.invoke(beginTransaction);
        if (z9) {
            if (z10) {
                beginTransaction.commitNowAllowingStateLoss();
                return;
            } else {
                beginTransaction.commitNow();
                return;
            }
        }
        if (z10) {
            beginTransaction.commitAllowingStateLoss();
        } else {
            beginTransaction.commit();
        }
    }
}
