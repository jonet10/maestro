package androidx.window.embedding;

import android.content.Intent;
import androidx.window.core.ExperimentalWindowApi;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@ExperimentalWindowApi
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class SplitPlaceholderRule extends SplitRule {
    private final Set<ActivityFilter> filters;
    private final Intent placeholderIntent;

    public /* synthetic */ SplitPlaceholderRule(Set set, Intent intent, int i, int i6, float f, int i10, int i11, g gVar) {
        this(set, intent, (i11 & 4) != 0 ? 0 : i, (i11 & 8) != 0 ? 0 : i6, (i11 & 16) != 0 ? 0.5f : f, (i11 & 32) != 0 ? 3 : i10);
    }

    @Override // androidx.window.embedding.SplitRule
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SplitPlaceholderRule) || !super.equals(obj) || !super.equals(obj)) {
            return false;
        }
        SplitPlaceholderRule splitPlaceholderRule = (SplitPlaceholderRule) obj;
        return l.a(this.filters, splitPlaceholderRule.filters) && l.a(this.placeholderIntent, splitPlaceholderRule.placeholderIntent);
    }

    public final Set<ActivityFilter> getFilters() {
        return this.filters;
    }

    public final Intent getPlaceholderIntent() {
        return this.placeholderIntent;
    }

    @Override // androidx.window.embedding.SplitRule
    public int hashCode() {
        return this.placeholderIntent.hashCode() + ((this.filters.hashCode() + (super.hashCode() * 31)) * 31);
    }

    public final SplitPlaceholderRule plus$window_release(ActivityFilter activityFilter) {
        activityFilter.getClass();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.addAll(this.filters);
        linkedHashSet.add(activityFilter);
        return new SplitPlaceholderRule(q6.l.J0(linkedHashSet), this.placeholderIntent, getMinWidth(), getMinSmallestWidth(), getSplitRatio(), getLayoutDirection());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SplitPlaceholderRule(Set<ActivityFilter> set, Intent intent, int i, int i6, float f, int i10) {
        super(i, i6, f, i10);
        set.getClass();
        intent.getClass();
        this.placeholderIntent = intent;
        this.filters = q6.l.J0(set);
    }
}
