package androidx.privacysandbox.ads.adservices.common;

import android.adservices.common.FrequencyCapFilters;
import androidx.annotation.RequiresExtension;
import androidx.annotation.RestrictTo;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@ExperimentalFeatures.Ext8OptIn
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class FrequencyCapFilters {
    public static final int AD_EVENT_TYPE_CLICK = 3;
    public static final int AD_EVENT_TYPE_IMPRESSION = 1;
    public static final int AD_EVENT_TYPE_VIEW = 2;
    public static final int AD_EVENT_TYPE_WIN = 0;
    public static final Companion Companion = new Companion(null);
    private final List<KeyedFrequencyCap> keyedFrequencyCapsForClickEvents;
    private final List<KeyedFrequencyCap> keyedFrequencyCapsForImpressionEvents;
    private final List<KeyedFrequencyCap> keyedFrequencyCapsForViewEvents;
    private final List<KeyedFrequencyCap> keyedFrequencyCapsForWinEvents;

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface AdEventType {
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ FrequencyCapFilters(java.util.List r2, java.util.List r3, java.util.List r4, java.util.List r5, int r6, kotlin.jvm.internal.g r7) {
        /*
            r1 = this;
            r7 = r6 & 1
            q6.t r0 = q6.t.f8724a
            if (r7 == 0) goto L7
            r2 = r0
        L7:
            r7 = r6 & 2
            if (r7 == 0) goto Lc
            r3 = r0
        Lc:
            r7 = r6 & 4
            if (r7 == 0) goto L11
            r4 = r0
        L11:
            r6 = r6 & 8
            if (r6 == 0) goto L16
            r5 = r0
        L16:
            r1.<init>(r2, r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.privacysandbox.ads.adservices.common.FrequencyCapFilters.<init>(java.util.List, java.util.List, java.util.List, java.util.List, int, kotlin.jvm.internal.g):void");
    }

    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 8), @RequiresExtension(extension = 31, version = 9)})
    private final List<android.adservices.common.KeyedFrequencyCap> convertToAdServices(List<KeyedFrequencyCap> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<KeyedFrequencyCap> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().convertToAdServices$ads_adservices_release());
        }
        return arrayList;
    }

    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 8), @RequiresExtension(extension = 31, version = 9)})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final android.adservices.common.FrequencyCapFilters convertToAdServices$ads_adservices_release() {
        android.adservices.common.FrequencyCapFilters build = new FrequencyCapFilters.Builder().setKeyedFrequencyCapsForWinEvents(convertToAdServices(this.keyedFrequencyCapsForWinEvents)).setKeyedFrequencyCapsForImpressionEvents(convertToAdServices(this.keyedFrequencyCapsForImpressionEvents)).setKeyedFrequencyCapsForViewEvents(convertToAdServices(this.keyedFrequencyCapsForViewEvents)).setKeyedFrequencyCapsForClickEvents(convertToAdServices(this.keyedFrequencyCapsForClickEvents)).build();
        build.getClass();
        return build;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FrequencyCapFilters)) {
            return false;
        }
        FrequencyCapFilters frequencyCapFilters = (FrequencyCapFilters) obj;
        return l.a(this.keyedFrequencyCapsForWinEvents, frequencyCapFilters.keyedFrequencyCapsForWinEvents) && l.a(this.keyedFrequencyCapsForImpressionEvents, frequencyCapFilters.keyedFrequencyCapsForImpressionEvents) && l.a(this.keyedFrequencyCapsForViewEvents, frequencyCapFilters.keyedFrequencyCapsForViewEvents) && l.a(this.keyedFrequencyCapsForClickEvents, frequencyCapFilters.keyedFrequencyCapsForClickEvents);
    }

    public final List<KeyedFrequencyCap> getKeyedFrequencyCapsForClickEvents() {
        return this.keyedFrequencyCapsForClickEvents;
    }

    public final List<KeyedFrequencyCap> getKeyedFrequencyCapsForImpressionEvents() {
        return this.keyedFrequencyCapsForImpressionEvents;
    }

    public final List<KeyedFrequencyCap> getKeyedFrequencyCapsForViewEvents() {
        return this.keyedFrequencyCapsForViewEvents;
    }

    public final List<KeyedFrequencyCap> getKeyedFrequencyCapsForWinEvents() {
        return this.keyedFrequencyCapsForWinEvents;
    }

    public int hashCode() {
        return this.keyedFrequencyCapsForClickEvents.hashCode() + ((this.keyedFrequencyCapsForViewEvents.hashCode() + ((this.keyedFrequencyCapsForImpressionEvents.hashCode() + (this.keyedFrequencyCapsForWinEvents.hashCode() * 31)) * 31)) * 31);
    }

    public String toString() {
        return "FrequencyCapFilters: keyedFrequencyCapsForWinEvents=" + this.keyedFrequencyCapsForWinEvents + ", keyedFrequencyCapsForImpressionEvents=" + this.keyedFrequencyCapsForImpressionEvents + ", keyedFrequencyCapsForViewEvents=" + this.keyedFrequencyCapsForViewEvents + ", keyedFrequencyCapsForClickEvents=" + this.keyedFrequencyCapsForClickEvents;
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FrequencyCapFilters(List<KeyedFrequencyCap> list) {
        this(list, null, null, null, 14, null);
        list.getClass();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FrequencyCapFilters(List<KeyedFrequencyCap> list, List<KeyedFrequencyCap> list2) {
        this(list, list2, null, null, 12, null);
        list.getClass();
        list2.getClass();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FrequencyCapFilters(List<KeyedFrequencyCap> list, List<KeyedFrequencyCap> list2, List<KeyedFrequencyCap> list3) {
        this(list, list2, list3, null, 8, null);
        list.getClass();
        list2.getClass();
        list3.getClass();
    }

    public FrequencyCapFilters(List<KeyedFrequencyCap> list, List<KeyedFrequencyCap> list2, List<KeyedFrequencyCap> list3, List<KeyedFrequencyCap> list4) {
        list.getClass();
        list2.getClass();
        list3.getClass();
        list4.getClass();
        this.keyedFrequencyCapsForWinEvents = list;
        this.keyedFrequencyCapsForImpressionEvents = list2;
        this.keyedFrequencyCapsForViewEvents = list3;
        this.keyedFrequencyCapsForClickEvents = list4;
    }

    public FrequencyCapFilters() {
        this(null, null, null, null, 15, null);
    }
}
