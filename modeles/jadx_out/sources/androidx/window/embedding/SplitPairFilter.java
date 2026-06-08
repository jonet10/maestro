package androidx.window.embedding;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import androidx.window.core.ExperimentalWindowApi;
import kotlin.jvm.internal.l;
import l7.m;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@ExperimentalWindowApi
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class SplitPairFilter {
    private final ComponentName primaryActivityName;
    private final String secondaryActivityIntentAction;
    private final ComponentName secondaryActivityName;

    public SplitPairFilter(ComponentName componentName, ComponentName componentName2, String str) {
        componentName.getClass();
        componentName2.getClass();
        this.primaryActivityName = componentName;
        this.secondaryActivityName = componentName2;
        this.secondaryActivityIntentAction = str;
        String packageName = componentName.getPackageName();
        packageName.getClass();
        String className = componentName.getClassName();
        className.getClass();
        String packageName2 = componentName2.getPackageName();
        packageName2.getClass();
        String className2 = componentName2.getClassName();
        className2.getClass();
        if (packageName.length() == 0 || packageName2.length() == 0) {
            com.google.gson.internal.a.p("Package name must not be empty");
            throw null;
        }
        if (className.length() == 0 || className2.length() == 0) {
            com.google.gson.internal.a.p("Activity class name must not be empty.");
            throw null;
        }
        if (m.q0(packageName, "*", false) && m.y0(packageName, "*", 0, false, 6) != packageName.length() - 1) {
            com.google.gson.internal.a.p("Wildcard in package name is only allowed at the end.");
            throw null;
        }
        if (m.q0(className, "*", false) && m.y0(className, "*", 0, false, 6) != className.length() - 1) {
            com.google.gson.internal.a.p("Wildcard in class name is only allowed at the end.");
            throw null;
        }
        if (m.q0(packageName2, "*", false) && m.y0(packageName2, "*", 0, false, 6) != packageName2.length() - 1) {
            com.google.gson.internal.a.p("Wildcard in package name is only allowed at the end.");
            throw null;
        }
        if (!m.q0(className2, "*", false) || m.y0(className2, "*", 0, false, 6) == className2.length() - 1) {
            return;
        }
        com.google.gson.internal.a.p("Wildcard in class name is only allowed at the end.");
        throw null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SplitPairFilter)) {
            return false;
        }
        SplitPairFilter splitPairFilter = (SplitPairFilter) obj;
        return l.a(this.primaryActivityName, splitPairFilter.primaryActivityName) && l.a(this.secondaryActivityName, splitPairFilter.secondaryActivityName) && l.a(this.secondaryActivityIntentAction, splitPairFilter.secondaryActivityIntentAction);
    }

    public final ComponentName getPrimaryActivityName() {
        return this.primaryActivityName;
    }

    public final String getSecondaryActivityIntentAction() {
        return this.secondaryActivityIntentAction;
    }

    public final ComponentName getSecondaryActivityName() {
        return this.secondaryActivityName;
    }

    public int hashCode() {
        int hashCode = (this.secondaryActivityName.hashCode() + (this.primaryActivityName.hashCode() * 31)) * 31;
        String str = this.secondaryActivityIntentAction;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public final boolean matchesActivityIntentPair(Activity activity, Intent intent) {
        activity.getClass();
        intent.getClass();
        ComponentName componentName = activity.getComponentName();
        MatcherUtils matcherUtils = MatcherUtils.INSTANCE;
        if (!matcherUtils.areComponentsMatching$window_release(componentName, this.primaryActivityName) || !matcherUtils.areComponentsMatching$window_release(intent.getComponent(), this.secondaryActivityName)) {
            return false;
        }
        String str = this.secondaryActivityIntentAction;
        return str == null || l.a(str, intent.getAction());
    }

    public final boolean matchesActivityPair(Activity activity, Activity activity2) {
        activity.getClass();
        activity2.getClass();
        MatcherUtils matcherUtils = MatcherUtils.INSTANCE;
        boolean z9 = matcherUtils.areComponentsMatching$window_release(activity.getComponentName(), this.primaryActivityName) && matcherUtils.areComponentsMatching$window_release(activity2.getComponentName(), this.secondaryActivityName);
        if (activity2.getIntent() == null) {
            return z9;
        }
        if (z9) {
            Intent intent = activity2.getIntent();
            intent.getClass();
            if (matchesActivityIntentPair(activity, intent)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return "SplitPairFilter{primaryActivityName=" + this.primaryActivityName + ", secondaryActivityName=" + this.secondaryActivityName + ", secondaryActivityAction=" + ((Object) this.secondaryActivityIntentAction) + '}';
    }
}
