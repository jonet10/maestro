package androidx.window.embedding;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import androidx.window.R;
import androidx.window.core.ExperimentalWindowApi;
import java.util.HashSet;
import java.util.Set;
import kotlin.jvm.internal.l;
import l7.m;
import q6.v;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@ExperimentalWindowApi
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class SplitRuleParser {
    private final ComponentName buildClassName(String str, CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            com.google.gson.internal.a.p("Activity name must not be null");
            return null;
        }
        String obj = charSequence.toString();
        if (obj.charAt(0) == '.') {
            return new ComponentName(str, l.g(obj, str));
        }
        int x02 = m.x0('/', 0, 6, obj);
        if (x02 > 0) {
            str = obj.substring(0, x02);
            obj = obj.substring(x02 + 1);
        }
        if (obj.equals("*") || m.x0('.', 0, 6, obj) >= 0) {
            return new ComponentName(str, obj);
        }
        return new ComponentName(str, str + '.' + obj);
    }

    private final ActivityFilter parseActivityFilter(Context context, XmlResourceParser xmlResourceParser) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(xmlResourceParser, R.styleable.ActivityFilter, 0, 0);
        String string = obtainStyledAttributes.getString(R.styleable.ActivityFilter_activityName);
        String string2 = obtainStyledAttributes.getString(R.styleable.ActivityFilter_activityAction);
        String packageName = context.getApplicationContext().getPackageName();
        packageName.getClass();
        return new ActivityFilter(buildClassName(packageName, string), string2);
    }

    private final ActivityRule parseSplitActivityRule(Context context, XmlResourceParser xmlResourceParser) {
        return new ActivityRule(v.f8726a, context.getTheme().obtainStyledAttributes(xmlResourceParser, R.styleable.ActivityRule, 0, 0).getBoolean(R.styleable.ActivityRule_alwaysExpand, false));
    }

    private final SplitPairFilter parseSplitPairFilter(Context context, XmlResourceParser xmlResourceParser) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(xmlResourceParser, R.styleable.SplitPairFilter, 0, 0);
        String string = obtainStyledAttributes.getString(R.styleable.SplitPairFilter_primaryActivityName);
        String string2 = obtainStyledAttributes.getString(R.styleable.SplitPairFilter_secondaryActivityName);
        String string3 = obtainStyledAttributes.getString(R.styleable.SplitPairFilter_secondaryActivityAction);
        String packageName = context.getApplicationContext().getPackageName();
        packageName.getClass();
        return new SplitPairFilter(buildClassName(packageName, string), buildClassName(packageName, string2), string3);
    }

    private final SplitPairRule parseSplitPairRule(Context context, XmlResourceParser xmlResourceParser) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(xmlResourceParser, R.styleable.SplitPairRule, 0, 0);
        float f = obtainStyledAttributes.getFloat(R.styleable.SplitPairRule_splitRatio, 0.0f);
        int dimension = (int) obtainStyledAttributes.getDimension(R.styleable.SplitPairRule_splitMinWidth, 0.0f);
        int dimension2 = (int) obtainStyledAttributes.getDimension(R.styleable.SplitPairRule_splitMinSmallestWidth, 0.0f);
        int i = obtainStyledAttributes.getInt(R.styleable.SplitPairRule_splitLayoutDirection, 3);
        return new SplitPairRule(v.f8726a, obtainStyledAttributes.getBoolean(R.styleable.SplitPairRule_finishPrimaryWithSecondary, false), obtainStyledAttributes.getBoolean(R.styleable.SplitPairRule_finishSecondaryWithPrimary, true), obtainStyledAttributes.getBoolean(R.styleable.SplitPairRule_clearTop, false), dimension, dimension2, f, i);
    }

    private final SplitPlaceholderRule parseSplitPlaceholderRule(Context context, XmlResourceParser xmlResourceParser) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(xmlResourceParser, R.styleable.SplitPlaceholderRule, 0, 0);
        String string = obtainStyledAttributes.getString(R.styleable.SplitPlaceholderRule_placeholderActivityName);
        float f = obtainStyledAttributes.getFloat(R.styleable.SplitPlaceholderRule_splitRatio, 0.0f);
        int dimension = (int) obtainStyledAttributes.getDimension(R.styleable.SplitPlaceholderRule_splitMinWidth, 0.0f);
        int dimension2 = (int) obtainStyledAttributes.getDimension(R.styleable.SplitPlaceholderRule_splitMinSmallestWidth, 0.0f);
        int i = obtainStyledAttributes.getInt(R.styleable.SplitPlaceholderRule_splitLayoutDirection, 3);
        String packageName = context.getApplicationContext().getPackageName();
        packageName.getClass();
        Intent component = new Intent().setComponent(buildClassName(packageName, string));
        component.getClass();
        return new SplitPlaceholderRule(v.f8726a, component, dimension, dimension2, f, i);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private final Set<EmbeddingRule> parseSplitXml(Context context, int i) {
        SplitPlaceholderRule plus$window_release;
        ActivityRule plus$window_release2;
        SplitPairRule parseSplitPairRule;
        try {
            XmlResourceParser xml = context.getResources().getXml(i);
            xml.getClass();
            HashSet hashSet = new HashSet();
            int depth = xml.getDepth();
            int next = xml.next();
            ActivityRule activityRule = null;
            SplitPairRule splitPairRule = null;
            SplitPlaceholderRule splitPlaceholderRule = null;
            while (next != 1 && (next != 3 || xml.getDepth() > depth)) {
                if (xml.getEventType() != 2 || "split-config".equals(xml.getName())) {
                    next = xml.next();
                } else {
                    String name = xml.getName();
                    if (name != null) {
                        switch (name.hashCode()) {
                            case 511422343:
                                if (name.equals("ActivityFilter")) {
                                    if (activityRule != null || splitPlaceholderRule != null) {
                                        ActivityFilter parseActivityFilter = parseActivityFilter(context, xml);
                                        if (activityRule == null) {
                                            if (splitPlaceholderRule != null) {
                                                hashSet.remove(splitPlaceholderRule);
                                                plus$window_release = splitPlaceholderRule.plus$window_release(parseActivityFilter);
                                                hashSet.add(plus$window_release);
                                                splitPlaceholderRule = plus$window_release;
                                                break;
                                            }
                                        } else {
                                            hashSet.remove(activityRule);
                                            plus$window_release2 = activityRule.plus$window_release(parseActivityFilter);
                                            hashSet.add(plus$window_release2);
                                            activityRule = plus$window_release2;
                                            break;
                                        }
                                    } else {
                                        com.google.gson.internal.a.p("Found orphaned ActivityFilter");
                                        return null;
                                    }
                                }
                                break;
                            case 520447504:
                                if (name.equals("SplitPairRule")) {
                                    parseSplitPairRule = parseSplitPairRule(context, xml);
                                    hashSet.add(parseSplitPairRule);
                                    activityRule = null;
                                    splitPlaceholderRule = null;
                                    splitPairRule = parseSplitPairRule;
                                    break;
                                }
                                break;
                            case 1579230604:
                                if (name.equals("SplitPairFilter")) {
                                    if (splitPairRule == null) {
                                        com.google.gson.internal.a.p("Found orphaned SplitPairFilter outside of SplitPairRule");
                                        return null;
                                    }
                                    SplitPairFilter parseSplitPairFilter = parseSplitPairFilter(context, xml);
                                    hashSet.remove(splitPairRule);
                                    parseSplitPairRule = splitPairRule.plus$window_release(parseSplitPairFilter);
                                    hashSet.add(parseSplitPairRule);
                                    splitPairRule = parseSplitPairRule;
                                    break;
                                }
                                break;
                            case 1793077963:
                                if (name.equals("ActivityRule")) {
                                    plus$window_release2 = parseSplitActivityRule(context, xml);
                                    hashSet.add(plus$window_release2);
                                    splitPairRule = null;
                                    splitPlaceholderRule = null;
                                    activityRule = plus$window_release2;
                                    break;
                                }
                                break;
                            case 2050988213:
                                if (name.equals("SplitPlaceholderRule")) {
                                    plus$window_release = parseSplitPlaceholderRule(context, xml);
                                    hashSet.add(plus$window_release);
                                    activityRule = null;
                                    splitPairRule = null;
                                    splitPlaceholderRule = plus$window_release;
                                    break;
                                }
                                break;
                        }
                    }
                    next = xml.next();
                }
            }
            return hashSet;
        } catch (Resources.NotFoundException unused) {
            return null;
        }
    }

    public final Set<EmbeddingRule> parseSplitRules$window_release(Context context, int i) {
        context.getClass();
        return parseSplitXml(context, i);
    }
}
