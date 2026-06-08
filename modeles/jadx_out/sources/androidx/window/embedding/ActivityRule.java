package androidx.window.embedding;

import androidx.window.core.ExperimentalWindowApi;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.g;
import q6.l;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@ExperimentalWindowApi
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class ActivityRule extends EmbeddingRule {
    private final boolean alwaysExpand;
    private final Set<ActivityFilter> filters;

    public ActivityRule(Set<ActivityFilter> set, boolean z9) {
        set.getClass();
        this.alwaysExpand = z9;
        this.filters = l.J0(set);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActivityRule)) {
            return false;
        }
        ActivityRule activityRule = (ActivityRule) obj;
        return kotlin.jvm.internal.l.a(this.filters, activityRule.filters) && this.alwaysExpand == activityRule.alwaysExpand;
    }

    public final boolean getAlwaysExpand() {
        return this.alwaysExpand;
    }

    public final Set<ActivityFilter> getFilters() {
        return this.filters;
    }

    public int hashCode() {
        return (this.filters.hashCode() * 31) + (this.alwaysExpand ? 1231 : 1237);
    }

    public final ActivityRule plus$window_release(ActivityFilter activityFilter) {
        activityFilter.getClass();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.addAll(this.filters);
        linkedHashSet.add(activityFilter);
        return new ActivityRule(l.J0(linkedHashSet), this.alwaysExpand);
    }

    public /* synthetic */ ActivityRule(Set set, boolean z9, int i, g gVar) {
        this(set, (i & 2) != 0 ? false : z9);
    }
}
