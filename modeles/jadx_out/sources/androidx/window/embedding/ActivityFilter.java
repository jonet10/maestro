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
public final class ActivityFilter {
    private final ComponentName componentName;
    private final String intentAction;

    public ActivityFilter(ComponentName componentName, String str) {
        componentName.getClass();
        this.componentName = componentName;
        this.intentAction = str;
        String packageName = componentName.getPackageName();
        packageName.getClass();
        String className = componentName.getClassName();
        className.getClass();
        if (packageName.length() <= 0) {
            com.google.gson.internal.a.p("Package name must not be empty");
            throw null;
        }
        if (className.length() <= 0) {
            com.google.gson.internal.a.p("Activity class name must not be empty.");
            throw null;
        }
        if (m.q0(packageName, "*", false) && m.y0(packageName, "*", 0, false, 6) != packageName.length() - 1) {
            com.google.gson.internal.a.p("Wildcard in package name is only allowed at the end.");
            throw null;
        }
        if (!m.q0(className, "*", false) || m.y0(className, "*", 0, false, 6) == className.length() - 1) {
            return;
        }
        com.google.gson.internal.a.p("Wildcard in class name is only allowed at the end.");
        throw null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActivityFilter)) {
            return false;
        }
        ActivityFilter activityFilter = (ActivityFilter) obj;
        return l.a(this.componentName, activityFilter.componentName) && l.a(this.intentAction, activityFilter.intentAction);
    }

    public final ComponentName getComponentName() {
        return this.componentName;
    }

    public final String getIntentAction() {
        return this.intentAction;
    }

    public int hashCode() {
        int hashCode = this.componentName.hashCode() * 31;
        String str = this.intentAction;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public final boolean matchesActivity(Activity activity) {
        activity.getClass();
        if (!MatcherUtils.INSTANCE.areActivityOrIntentComponentsMatching$window_release(activity, this.componentName)) {
            return false;
        }
        String str = this.intentAction;
        if (str == null) {
            return true;
        }
        Intent intent = activity.getIntent();
        return l.a(str, intent == null ? null : intent.getAction());
    }

    public final boolean matchesIntent(Intent intent) {
        intent.getClass();
        if (!MatcherUtils.INSTANCE.areComponentsMatching$window_release(intent.getComponent(), this.componentName)) {
            return false;
        }
        String str = this.intentAction;
        return str == null || l.a(str, intent.getAction());
    }

    public String toString() {
        return "ActivityFilter(componentName=" + this.componentName + ", intentAction=" + ((Object) this.intentAction) + ')';
    }
}
