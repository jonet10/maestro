package androidx.window.embedding;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.util.Pair;
import android.view.WindowMetrics;
import androidx.window.core.ExperimentalWindowApi;
import androidx.window.extensions.embedding.ActivityRule;
import androidx.window.extensions.embedding.SplitPairRule;
import androidx.window.extensions.embedding.SplitPlaceholderRule;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import q6.l;
import q6.n;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@ExperimentalWindowApi
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class EmbeddingAdapter {
    private final <F, S> F component1(Pair<F, S> pair) {
        pair.getClass();
        return (F) pair.first;
    }

    private final <F, S> S component2(Pair<F, S> pair) {
        pair.getClass();
        return (S) pair.second;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: translateActivityIntentPredicates$lambda-3, reason: not valid java name */
    public static final boolean m225translateActivityIntentPredicates$lambda3(EmbeddingAdapter embeddingAdapter, Set set, Pair pair) {
        embeddingAdapter.getClass();
        set.getClass();
        pair.getClass();
        Activity activity = (Activity) embeddingAdapter.component1(pair);
        Intent intent = (Intent) embeddingAdapter.component2(pair);
        if (set.isEmpty()) {
            return false;
        }
        Iterator it = set.iterator();
        while (it.hasNext()) {
            if (((SplitPairFilter) it.next()).matchesActivityIntentPair(activity, intent)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: translateActivityPairPredicates$lambda-1, reason: not valid java name */
    public static final boolean m226translateActivityPairPredicates$lambda1(EmbeddingAdapter embeddingAdapter, Set set, Pair pair) {
        embeddingAdapter.getClass();
        set.getClass();
        pair.getClass();
        Activity activity = (Activity) embeddingAdapter.component1(pair);
        Activity activity2 = (Activity) embeddingAdapter.component2(pair);
        if (set.isEmpty()) {
            return false;
        }
        Iterator it = set.iterator();
        while (it.hasNext()) {
            if (((SplitPairFilter) it.next()).matchesActivityPair(activity, activity2)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: translateActivityPredicates$lambda-6, reason: not valid java name */
    public static final boolean m227translateActivityPredicates$lambda6(Set set, Activity activity) {
        set.getClass();
        if (set.isEmpty()) {
            return false;
        }
        Iterator it = set.iterator();
        while (it.hasNext()) {
            ActivityFilter activityFilter = (ActivityFilter) it.next();
            activity.getClass();
            if (activityFilter.matchesActivity(activity)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: translateIntentPredicates$lambda-8, reason: not valid java name */
    public static final boolean m228translateIntentPredicates$lambda8(Set set, Intent intent) {
        set.getClass();
        if (set.isEmpty()) {
            return false;
        }
        Iterator it = set.iterator();
        while (it.hasNext()) {
            ActivityFilter activityFilter = (ActivityFilter) it.next();
            intent.getClass();
            if (activityFilter.matchesIntent(intent)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: translateParentMetricsPredicate$lambda-4, reason: not valid java name */
    public static final boolean m229translateParentMetricsPredicate$lambda4(SplitRule splitRule, WindowMetrics windowMetrics) {
        splitRule.getClass();
        windowMetrics.getClass();
        return splitRule.checkParentMetrics(windowMetrics);
    }

    public final Set<androidx.window.extensions.embedding.EmbeddingRule> translate(Set<? extends EmbeddingRule> set) {
        androidx.window.extensions.embedding.SplitPairRule build;
        set.getClass();
        ArrayList arrayList = new ArrayList(n.i0(set, 10));
        for (EmbeddingRule embeddingRule : set) {
            if (embeddingRule instanceof SplitPairRule) {
                SplitPairRule splitPairRule = (SplitPairRule) embeddingRule;
                build = new SplitPairRule.Builder(translateActivityPairPredicates(splitPairRule.getFilters()), translateActivityIntentPredicates(splitPairRule.getFilters()), translateParentMetricsPredicate((SplitRule) embeddingRule)).setSplitRatio(splitPairRule.getSplitRatio()).setLayoutDirection(splitPairRule.getLayoutDirection()).setShouldFinishPrimaryWithSecondary(splitPairRule.getFinishPrimaryWithSecondary()).setShouldFinishSecondaryWithPrimary(splitPairRule.getFinishSecondaryWithPrimary()).setShouldClearTop(splitPairRule.getClearTop()).build();
                build.getClass();
            } else if (embeddingRule instanceof SplitPlaceholderRule) {
                SplitPlaceholderRule splitPlaceholderRule = (SplitPlaceholderRule) embeddingRule;
                build = new SplitPlaceholderRule.Builder(splitPlaceholderRule.getPlaceholderIntent(), translateActivityPredicates(splitPlaceholderRule.getFilters()), translateIntentPredicates(splitPlaceholderRule.getFilters()), translateParentMetricsPredicate((SplitRule) embeddingRule)).setSplitRatio(splitPlaceholderRule.getSplitRatio()).setLayoutDirection(splitPlaceholderRule.getLayoutDirection()).build();
                build.getClass();
            } else {
                if (!(embeddingRule instanceof ActivityRule)) {
                    com.google.gson.internal.a.p("Unsupported rule type");
                    return null;
                }
                ActivityRule activityRule = (ActivityRule) embeddingRule;
                build = new ActivityRule.Builder(translateActivityPredicates(activityRule.getFilters()), translateIntentPredicates(activityRule.getFilters())).setShouldAlwaysExpand(activityRule.getAlwaysExpand()).build();
                build.getClass();
            }
            arrayList.add((androidx.window.extensions.embedding.EmbeddingRule) build);
        }
        return l.J0(arrayList);
    }

    @SuppressLint({"ClassVerificationFailure", "NewApi"})
    public final Predicate<Pair<Activity, Intent>> translateActivityIntentPredicates(Set<SplitPairFilter> set) {
        set.getClass();
        return new c(this, set, 1);
    }

    @SuppressLint({"ClassVerificationFailure", "NewApi"})
    public final Predicate<Pair<Activity, Activity>> translateActivityPairPredicates(Set<SplitPairFilter> set) {
        set.getClass();
        return new c(this, set, 0);
    }

    @SuppressLint({"ClassVerificationFailure", "NewApi"})
    public final Predicate<Activity> translateActivityPredicates(Set<ActivityFilter> set) {
        set.getClass();
        return new a(set, 1);
    }

    @SuppressLint({"ClassVerificationFailure", "NewApi"})
    public final Predicate<Intent> translateIntentPredicates(Set<ActivityFilter> set) {
        set.getClass();
        return new a(set, 0);
    }

    @SuppressLint({"ClassVerificationFailure", "NewApi"})
    public final Predicate<WindowMetrics> translateParentMetricsPredicate(SplitRule splitRule) {
        splitRule.getClass();
        return new b(splitRule, 0);
    }

    private final SplitInfo translate(androidx.window.extensions.embedding.SplitInfo splitInfo) {
        boolean z9;
        androidx.window.extensions.embedding.ActivityStack primaryActivityStack = splitInfo.getPrimaryActivityStack();
        primaryActivityStack.getClass();
        boolean z10 = false;
        try {
            z9 = primaryActivityStack.isEmpty();
        } catch (NoSuchMethodError unused) {
            z9 = false;
        }
        List activities = primaryActivityStack.getActivities();
        activities.getClass();
        ActivityStack activityStack = new ActivityStack(activities, z9);
        androidx.window.extensions.embedding.ActivityStack secondaryActivityStack = splitInfo.getSecondaryActivityStack();
        secondaryActivityStack.getClass();
        try {
            z10 = secondaryActivityStack.isEmpty();
        } catch (NoSuchMethodError unused2) {
        }
        List activities2 = secondaryActivityStack.getActivities();
        activities2.getClass();
        return new SplitInfo(activityStack, new ActivityStack(activities2, z10), splitInfo.getSplitRatio());
    }

    public final List<SplitInfo> translate(List<? extends androidx.window.extensions.embedding.SplitInfo> list) {
        list.getClass();
        List<? extends androidx.window.extensions.embedding.SplitInfo> list2 = list;
        ArrayList arrayList = new ArrayList(n.i0(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(translate((androidx.window.extensions.embedding.SplitInfo) it.next()));
        }
        return arrayList;
    }
}
