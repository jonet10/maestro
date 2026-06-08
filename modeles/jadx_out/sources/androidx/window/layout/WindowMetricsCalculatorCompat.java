package androidx.window.layout;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.Display;
import android.view.DisplayCutout;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class WindowMetricsCalculatorCompat implements WindowMetricsCalculator {
    public static final WindowMetricsCalculatorCompat INSTANCE = new WindowMetricsCalculatorCompat();
    private static final String TAG = "WindowMetricsCalculatorCompat";

    private WindowMetricsCalculatorCompat() {
    }

    @RequiresApi(28)
    @SuppressLint({"BanUncheckedReflection"})
    private final DisplayCutout getCutoutForDisplay(Display display) {
        try {
            Constructor<?> constructor = Class.forName("android.view.DisplayInfo").getConstructor(null);
            constructor.setAccessible(true);
            Object newInstance = constructor.newInstance(null);
            Method declaredMethod = display.getClass().getDeclaredMethod("getDisplayInfo", newInstance.getClass());
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(display, newInstance);
            Field declaredField = newInstance.getClass().getDeclaredField("displayCutout");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(newInstance);
            if (obj instanceof DisplayCutout) {
                return (DisplayCutout) obj;
            }
        } catch (ClassNotFoundException e10) {
            Log.w(TAG, e10);
        } catch (IllegalAccessException e11) {
            Log.w(TAG, e11);
        } catch (InstantiationException e12) {
            Log.w(TAG, e12);
        } catch (NoSuchFieldException e13) {
            Log.w(TAG, e13);
        } catch (NoSuchMethodException e14) {
            Log.w(TAG, e14);
        } catch (InvocationTargetException e15) {
            Log.w(TAG, e15);
        }
        return null;
    }

    private final int getNavigationBarHeight(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("navigation_bar_height", "dimen", "android");
        if (identifier > 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    private final void getRectSizeFromDisplay(Activity activity, Rect rect) {
        activity.getWindowManager().getDefaultDisplay().getRectSize(rect);
    }

    @Override // androidx.window.layout.WindowMetricsCalculator
    public WindowMetrics computeCurrentWindowMetrics(Activity activity) {
        activity.getClass();
        int i = Build.VERSION.SDK_INT;
        return new WindowMetrics(i >= 30 ? ActivityCompatHelperApi30.INSTANCE.currentWindowBounds(activity) : i >= 29 ? computeWindowBoundsQ$window_release(activity) : i >= 28 ? computeWindowBoundsP$window_release(activity) : i >= 24 ? computeWindowBoundsN$window_release(activity) : computeWindowBoundsIceCreamSandwich$window_release(activity));
    }

    @Override // androidx.window.layout.WindowMetricsCalculator
    public WindowMetrics computeMaximumWindowMetrics(Activity activity) {
        Rect rect;
        activity.getClass();
        if (Build.VERSION.SDK_INT >= 30) {
            rect = ActivityCompatHelperApi30.INSTANCE.maximumWindowBounds(activity);
        } else {
            Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
            defaultDisplay.getClass();
            Point realSizeForDisplay$window_release = getRealSizeForDisplay$window_release(defaultDisplay);
            rect = new Rect(0, 0, realSizeForDisplay$window_release.x, realSizeForDisplay$window_release.y);
        }
        return new WindowMetrics(rect);
    }

    @RequiresApi(14)
    public final Rect computeWindowBoundsIceCreamSandwich$window_release(Activity activity) {
        int i;
        activity.getClass();
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        defaultDisplay.getClass();
        Point realSizeForDisplay$window_release = getRealSizeForDisplay$window_release(defaultDisplay);
        Rect rect = new Rect();
        int i6 = realSizeForDisplay$window_release.x;
        if (i6 == 0 || (i = realSizeForDisplay$window_release.y) == 0) {
            defaultDisplay.getRectSize(rect);
            return rect;
        }
        rect.right = i6;
        rect.bottom = i;
        return rect;
    }

    @RequiresApi(24)
    public final Rect computeWindowBoundsN$window_release(Activity activity) {
        activity.getClass();
        Rect rect = new Rect();
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        defaultDisplay.getRectSize(rect);
        if (!ActivityCompatHelperApi24.INSTANCE.isInMultiWindowMode(activity)) {
            Point realSizeForDisplay$window_release = getRealSizeForDisplay$window_release(defaultDisplay);
            int navigationBarHeight = getNavigationBarHeight(activity);
            int i = rect.bottom;
            if (i + navigationBarHeight == realSizeForDisplay$window_release.y) {
                rect.bottom = i + navigationBarHeight;
                return rect;
            }
            int i6 = rect.right;
            if (i6 + navigationBarHeight == realSizeForDisplay$window_release.x) {
                rect.right = i6 + navigationBarHeight;
            }
        }
        return rect;
    }

    @RequiresApi(28)
    @SuppressLint({"BanUncheckedReflection", "BlockedPrivateApi"})
    public final Rect computeWindowBoundsP$window_release(Activity activity) {
        DisplayCutout cutoutForDisplay;
        activity.getClass();
        Rect rect = new Rect();
        Configuration configuration = activity.getResources().getConfiguration();
        try {
            Field declaredField = Configuration.class.getDeclaredField("windowConfiguration");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(configuration);
            if (ActivityCompatHelperApi24.INSTANCE.isInMultiWindowMode(activity)) {
                Object invoke = obj.getClass().getDeclaredMethod("getBounds", null).invoke(obj, null);
                if (invoke == null) {
                    throw new NullPointerException("null cannot be cast to non-null type android.graphics.Rect");
                }
                rect.set((Rect) invoke);
            } else {
                Object invoke2 = obj.getClass().getDeclaredMethod("getAppBounds", null).invoke(obj, null);
                if (invoke2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type android.graphics.Rect");
                }
                rect.set((Rect) invoke2);
            }
        } catch (IllegalAccessException e10) {
            Log.w(TAG, e10);
            getRectSizeFromDisplay(activity, rect);
        } catch (NoSuchFieldException e11) {
            Log.w(TAG, e11);
            getRectSizeFromDisplay(activity, rect);
        } catch (NoSuchMethodException e12) {
            Log.w(TAG, e12);
            getRectSizeFromDisplay(activity, rect);
        } catch (InvocationTargetException e13) {
            Log.w(TAG, e13);
            getRectSizeFromDisplay(activity, rect);
        }
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        Point point = new Point();
        DisplayCompatHelperApi17 displayCompatHelperApi17 = DisplayCompatHelperApi17.INSTANCE;
        defaultDisplay.getClass();
        displayCompatHelperApi17.getRealSize(defaultDisplay, point);
        ActivityCompatHelperApi24 activityCompatHelperApi24 = ActivityCompatHelperApi24.INSTANCE;
        if (!activityCompatHelperApi24.isInMultiWindowMode(activity)) {
            int navigationBarHeight = getNavigationBarHeight(activity);
            int i = rect.bottom;
            if (i + navigationBarHeight == point.y) {
                rect.bottom = i + navigationBarHeight;
            } else {
                int i6 = rect.right;
                if (i6 + navigationBarHeight == point.x) {
                    rect.right = i6 + navigationBarHeight;
                } else if (rect.left == navigationBarHeight) {
                    rect.left = 0;
                }
            }
        }
        if ((rect.width() < point.x || rect.height() < point.y) && !activityCompatHelperApi24.isInMultiWindowMode(activity) && (cutoutForDisplay = getCutoutForDisplay(defaultDisplay)) != null) {
            int i10 = rect.left;
            DisplayCompatHelperApi28 displayCompatHelperApi28 = DisplayCompatHelperApi28.INSTANCE;
            if (i10 == displayCompatHelperApi28.safeInsetLeft(cutoutForDisplay)) {
                rect.left = 0;
            }
            if (point.x - rect.right == displayCompatHelperApi28.safeInsetRight(cutoutForDisplay)) {
                rect.right = displayCompatHelperApi28.safeInsetRight(cutoutForDisplay) + rect.right;
            }
            if (rect.top == displayCompatHelperApi28.safeInsetTop(cutoutForDisplay)) {
                rect.top = 0;
            }
            if (point.y - rect.bottom == displayCompatHelperApi28.safeInsetBottom(cutoutForDisplay)) {
                rect.bottom = displayCompatHelperApi28.safeInsetBottom(cutoutForDisplay) + rect.bottom;
            }
        }
        return rect;
    }

    @RequiresApi(ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HORIZONTAL_BIAS)
    @SuppressLint({"BanUncheckedReflection", "BlockedPrivateApi"})
    public final Rect computeWindowBoundsQ$window_release(Activity activity) {
        activity.getClass();
        Configuration configuration = activity.getResources().getConfiguration();
        try {
            Field declaredField = Configuration.class.getDeclaredField("windowConfiguration");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(configuration);
            Object invoke = obj.getClass().getDeclaredMethod("getBounds", null).invoke(obj, null);
            if (invoke != null) {
                return new Rect((Rect) invoke);
            }
            throw new NullPointerException("null cannot be cast to non-null type android.graphics.Rect");
        } catch (IllegalAccessException e10) {
            Log.w(TAG, e10);
            return computeWindowBoundsP$window_release(activity);
        } catch (NoSuchFieldException e11) {
            Log.w(TAG, e11);
            return computeWindowBoundsP$window_release(activity);
        } catch (NoSuchMethodException e12) {
            Log.w(TAG, e12);
            return computeWindowBoundsP$window_release(activity);
        } catch (InvocationTargetException e13) {
            Log.w(TAG, e13);
            return computeWindowBoundsP$window_release(activity);
        }
    }

    @RequiresApi(14)
    @VisibleForTesting
    public final Point getRealSizeForDisplay$window_release(Display display) {
        display.getClass();
        Point point = new Point();
        DisplayCompatHelperApi17.INSTANCE.getRealSize(display, point);
        return point;
    }
}
