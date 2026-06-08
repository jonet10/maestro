package androidx.transition;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RequiresApi(21)
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
class GhostViewPlatform implements GhostView {
    private static final String TAG = "GhostViewApi21";
    private static Method sAddGhostMethod;
    private static boolean sAddGhostMethodFetched;
    private static Class<?> sGhostViewClass;
    private static boolean sGhostViewClassFetched;
    private static Method sRemoveGhostMethod;
    private static boolean sRemoveGhostMethodFetched;
    private final View mGhostView;

    private GhostViewPlatform(@NonNull View view) {
        this.mGhostView = view;
    }

    @SuppressLint({"BanUncheckedReflection"})
    public static GhostView addGhost(View view, ViewGroup viewGroup, Matrix matrix) {
        fetchAddGhostMethod();
        Method method = sAddGhostMethod;
        if (method != null) {
            try {
                return new GhostViewPlatform((View) method.invoke(null, view, viewGroup, matrix));
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e10) {
                com.google.gson.internal.a.k(e10.getCause());
            }
        }
        return null;
    }

    private static void fetchAddGhostMethod() {
        if (sAddGhostMethodFetched) {
            return;
        }
        try {
            fetchGhostViewClass();
            Method declaredMethod = sGhostViewClass.getDeclaredMethod("addGhost", View.class, ViewGroup.class, Matrix.class);
            sAddGhostMethod = declaredMethod;
            declaredMethod.setAccessible(true);
        } catch (NoSuchMethodException e10) {
            Log.i(TAG, "Failed to retrieve addGhost method", e10);
        }
        sAddGhostMethodFetched = true;
    }

    private static void fetchGhostViewClass() {
        if (sGhostViewClassFetched) {
            return;
        }
        try {
            sGhostViewClass = Class.forName("android.view.GhostView");
        } catch (ClassNotFoundException e10) {
            Log.i(TAG, "Failed to retrieve GhostView class", e10);
        }
        sGhostViewClassFetched = true;
    }

    private static void fetchRemoveGhostMethod() {
        if (sRemoveGhostMethodFetched) {
            return;
        }
        try {
            fetchGhostViewClass();
            Method declaredMethod = sGhostViewClass.getDeclaredMethod("removeGhost", View.class);
            sRemoveGhostMethod = declaredMethod;
            declaredMethod.setAccessible(true);
        } catch (NoSuchMethodException e10) {
            Log.i(TAG, "Failed to retrieve removeGhost method", e10);
        }
        sRemoveGhostMethodFetched = true;
    }

    @SuppressLint({"BanUncheckedReflection"})
    public static void removeGhost(View view) {
        fetchRemoveGhostMethod();
        Method method = sRemoveGhostMethod;
        if (method != null) {
            try {
                method.invoke(null, view);
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e10) {
                com.google.gson.internal.a.k(e10.getCause());
            }
        }
    }

    @Override // androidx.transition.GhostView
    public void setVisibility(int i) {
        this.mGhostView.setVisibility(i);
    }

    @Override // androidx.transition.GhostView
    public void reserveEndViewTransition(ViewGroup viewGroup, View view) {
    }
}
