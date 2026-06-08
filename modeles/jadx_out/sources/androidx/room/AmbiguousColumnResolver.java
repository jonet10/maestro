package androidx.room;

import androidx.annotation.RestrictTo;
import com.google.android.gms.internal.measurement.z3;
import d7.q;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import kotlin.jvm.internal.l;
import p6.x;
import q6.m;
import q6.n;
import q6.r;
import q6.t;
import r6.i;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class AmbiguousColumnResolver {
    public static final AmbiguousColumnResolver INSTANCE = new AmbiguousColumnResolver();

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class Match {
        private final List<Integer> resultIndices;
        private final i7.d resultRange;

        public Match(i7.d dVar, List<Integer> list) {
            dVar.getClass();
            list.getClass();
            this.resultRange = dVar;
            this.resultIndices = list;
        }

        public final List<Integer> getResultIndices() {
            return this.resultIndices;
        }

        public final i7.d getResultRange() {
            return this.resultRange;
        }
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class ResultColumn {
        private final int index;
        private final String name;

        public ResultColumn(String str, int i) {
            str.getClass();
            this.name = str;
            this.index = i;
        }

        public static /* synthetic */ ResultColumn copy$default(ResultColumn resultColumn, String str, int i, int i6, Object obj) {
            if ((i6 & 1) != 0) {
                str = resultColumn.name;
            }
            if ((i6 & 2) != 0) {
                i = resultColumn.index;
            }
            return resultColumn.copy(str, i);
        }

        public final String component1() {
            return this.name;
        }

        public final int component2() {
            return this.index;
        }

        public final ResultColumn copy(String str, int i) {
            str.getClass();
            return new ResultColumn(str, i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ResultColumn)) {
                return false;
            }
            ResultColumn resultColumn = (ResultColumn) obj;
            return l.a(this.name, resultColumn.name) && this.index == resultColumn.index;
        }

        public final int getIndex() {
            return this.index;
        }

        public final String getName() {
            return this.name;
        }

        public int hashCode() {
            return (this.name.hashCode() * 31) + this.index;
        }

        public String toString() {
            return "ResultColumn(name=" + this.name + ", index=" + this.index + ')';
        }
    }

    private AmbiguousColumnResolver() {
    }

    private final <T> void dfs(List<? extends List<? extends T>> list, List<T> list2, int i, d7.l lVar) {
        if (i == list.size()) {
            lVar.invoke(q6.l.G0(list2));
            return;
        }
        Iterator<T> it = list.get(i).iterator();
        while (it.hasNext()) {
            list2.add(it.next());
            INSTANCE.dfs(list, list2, i + 1, lVar);
            list2.remove(list2.size() - 1);
        }
    }

    public static /* synthetic */ void dfs$default(AmbiguousColumnResolver ambiguousColumnResolver, List list, List list2, int i, d7.l lVar, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            list2 = new ArrayList();
        }
        if ((i6 & 4) != 0) {
            i = 0;
        }
        ambiguousColumnResolver.dfs(list, list2, i, lVar);
    }

    private final void rabinKarpSearch(List<ResultColumn> list, String[] strArr, q qVar) {
        int i = 0;
        int i6 = 0;
        for (String str : strArr) {
            i6 += str.hashCode();
        }
        int length = strArr.length;
        Iterator<T> it = list.subList(0, length).iterator();
        int i10 = 0;
        while (it.hasNext()) {
            i10 += ((ResultColumn) it.next()).getName().hashCode();
        }
        while (true) {
            if (i6 == i10) {
                qVar.invoke(Integer.valueOf(i), Integer.valueOf(length), list.subList(i, length));
            }
            int i11 = i + 1;
            int i12 = length + 1;
            if (i12 > list.size()) {
                return;
            }
            i10 = (i10 - list.get(i).getName().hashCode()) + list.get(length).getName().hashCode();
            i = i11;
            length = i12;
        }
    }

    public static final int[][] resolve(String[] strArr, String[][] strArr2) {
        strArr.getClass();
        strArr2.getClass();
        int length = strArr.length;
        int i = 0;
        for (int i6 = 0; i6 < length; i6++) {
            String str = strArr[i6];
            if (str.charAt(0) == '`' && str.charAt(str.length() - 1) == '`') {
                str = str.substring(1, str.length() - 1);
            }
            String lowerCase = str.toLowerCase(Locale.ROOT);
            lowerCase.getClass();
            strArr[i6] = lowerCase;
        }
        int length2 = strArr2.length;
        for (int i10 = 0; i10 < length2; i10++) {
            int length3 = strArr2[i10].length;
            for (int i11 = 0; i11 < length3; i11++) {
                String[] strArr3 = strArr2[i10];
                String lowerCase2 = strArr3[i11].toLowerCase(Locale.ROOT);
                lowerCase2.getClass();
                strArr3[i11] = lowerCase2;
            }
        }
        i iVar = new i();
        for (String[] strArr4 : strArr2) {
            r.l0(iVar, strArr4);
        }
        i g = z3.g(iVar);
        r6.c t9 = a.a.t();
        int length4 = strArr.length;
        int i12 = 0;
        int i13 = 0;
        while (i12 < length4) {
            String str2 = strArr[i12];
            int i14 = i13 + 1;
            if (g.f8948a.containsKey(str2)) {
                t9.add(new ResultColumn(str2, i13));
            }
            i12++;
            i13 = i14;
        }
        r6.c m10 = a.a.m(t9);
        int length5 = strArr2.length;
        final ArrayList arrayList = new ArrayList(length5);
        for (int i15 = 0; i15 < length5; i15++) {
            arrayList.add(new ArrayList());
        }
        int length6 = strArr2.length;
        int i16 = 0;
        final int i17 = 0;
        while (i16 < length6) {
            final String[] strArr5 = strArr2[i16];
            int i18 = i17 + 1;
            INSTANCE.rabinKarpSearch(m10, strArr5, new q() { // from class: androidx.room.a
                @Override // d7.q
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    x resolve$lambda$16$lambda$7;
                    resolve$lambda$16$lambda$7 = AmbiguousColumnResolver.resolve$lambda$16$lambda$7(strArr5, arrayList, i17, ((Integer) obj).intValue(), ((Integer) obj2).intValue(), (List) obj3);
                    return resolve$lambda$16$lambda$7;
                }
            });
            if (((List) arrayList.get(i17)).isEmpty()) {
                ArrayList arrayList2 = new ArrayList(strArr5.length);
                int length7 = strArr5.length;
                int i19 = i;
                while (i19 < length7) {
                    String str3 = strArr5[i19];
                    r6.c t10 = a.a.t();
                    ListIterator listIterator = m10.listIterator(i);
                    while (true) {
                        r6.a aVar = (r6.a) listIterator;
                        if (!aVar.hasNext()) {
                            break;
                        }
                        ResultColumn resultColumn = (ResultColumn) aVar.next();
                        if (l.a(str3, resultColumn.getName())) {
                            t10.add(Integer.valueOf(resultColumn.getIndex()));
                        }
                    }
                    r6.c m11 = a.a.m(t10);
                    if (m11.isEmpty()) {
                        throw new IllegalStateException(androidx.lifecycle.l.w("Column ", str3, " not found in result").toString());
                    }
                    arrayList2.add(m11);
                    i19++;
                    i = 0;
                }
                dfs$default(INSTANCE, arrayList2, null, 0, new androidx.work.impl.model.d(arrayList, i17, 4), 6, null);
            }
            i16++;
            i17 = i18;
            i = 0;
        }
        if (!arrayList.isEmpty()) {
            int size = arrayList.size();
            int i20 = 0;
            while (i20 < size) {
                Object obj = arrayList.get(i20);
                i20++;
                if (((List) obj).isEmpty()) {
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("Failed to find matches for all mappings");
                    return null;
                }
            }
        }
        kotlin.jvm.internal.x xVar = new kotlin.jvm.internal.x();
        xVar.f7024a = Solution.Companion.getNO_SOLUTION();
        dfs$default(INSTANCE, arrayList, null, 0, new b(xVar, 0), 6, null);
        List<Match> matches = ((Solution) xVar.f7024a).getMatches();
        ArrayList arrayList3 = new ArrayList(n.i0(matches, 10));
        Iterator<T> it = matches.iterator();
        while (it.hasNext()) {
            arrayList3.add(q6.l.F0(((Match) it.next()).getResultIndices()));
        }
        return (int[][]) arrayList3.toArray(new int[0][]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final x resolve$lambda$16$lambda$15(List list, int i, List list2) {
        list2.getClass();
        List list3 = list2;
        Iterator it = list3.iterator();
        if (!it.hasNext()) {
            com.google.gson.internal.a.l();
            return null;
        }
        int intValue = ((Number) it.next()).intValue();
        while (it.hasNext()) {
            int intValue2 = ((Number) it.next()).intValue();
            if (intValue > intValue2) {
                intValue = intValue2;
            }
        }
        Iterator it2 = list3.iterator();
        if (!it2.hasNext()) {
            com.google.gson.internal.a.l();
            return null;
        }
        int intValue3 = ((Number) it2.next()).intValue();
        while (it2.hasNext()) {
            int intValue4 = ((Number) it2.next()).intValue();
            if (intValue3 < intValue4) {
                intValue3 = intValue4;
            }
        }
        ((List) list.get(i)).add(new Match(new i7.d(intValue, intValue3, 1), list2));
        return x.f8463a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final x resolve$lambda$16$lambda$7(String[] strArr, List list, int i, int i6, int i10, List list2) {
        Object obj;
        list2.getClass();
        ArrayList arrayList = new ArrayList(strArr.length);
        int length = strArr.length;
        int i11 = 0;
        while (true) {
            x xVar = x.f8463a;
            if (i11 >= length) {
                ((List) list.get(i)).add(new Match(new i7.d(i6, i10 - 1, 1), arrayList));
                return xVar;
            }
            String str = strArr[i11];
            Iterator it = list2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (l.a(str, ((ResultColumn) obj).component1())) {
                    break;
                }
            }
            ResultColumn resultColumn = (ResultColumn) obj;
            if (resultColumn == null) {
                return xVar;
            }
            arrayList.add(Integer.valueOf(resultColumn.getIndex()));
            i11++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final x resolve$lambda$19(kotlin.jvm.internal.x xVar, List list) {
        list.getClass();
        Solution build = Solution.Companion.build(list);
        if (build.compareTo((Solution) xVar.f7024a) < 0) {
            xVar.f7024a = build;
        }
        return x.f8463a;
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class Solution implements Comparable<Solution> {
        public static final Companion Companion = new Companion(null);
        private static final Solution NO_SOLUTION = new Solution(t.f8724a, Integer.MAX_VALUE, Integer.MAX_VALUE);
        private final int coverageOffset;
        private final List<Match> matches;
        private final int overlaps;

        public Solution(List<Match> list, int i, int i6) {
            list.getClass();
            this.matches = list;
            this.coverageOffset = i;
            this.overlaps = i6;
        }

        @Override // java.lang.Comparable
        public int compareTo(Solution solution) {
            solution.getClass();
            int c9 = l.c(this.overlaps, solution.overlaps);
            return c9 != 0 ? c9 : l.c(this.coverageOffset, solution.coverageOffset);
        }

        public final int getCoverageOffset() {
            return this.coverageOffset;
        }

        public final List<Match> getMatches() {
            return this.matches;
        }

        public final int getOverlaps() {
            return this.overlaps;
        }

        /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
        public static final class Companion {
            public /* synthetic */ Companion(kotlin.jvm.internal.g gVar) {
                this();
            }

            public final Solution build(List<Match> list) {
                list.getClass();
                List<Match> list2 = list;
                int i = 0;
                int i6 = 0;
                for (Match match : list2) {
                    i6 += ((match.getResultRange().f5696b - match.getResultRange().f5695a) + 1) - match.getResultIndices().size();
                }
                Iterator<T> it = list2.iterator();
                if (!it.hasNext()) {
                    com.google.gson.internal.a.l();
                    return null;
                }
                int i10 = ((Match) it.next()).getResultRange().f5695a;
                while (it.hasNext()) {
                    int i11 = ((Match) it.next()).getResultRange().f5695a;
                    if (i10 > i11) {
                        i10 = i11;
                    }
                }
                Iterator<T> it2 = list2.iterator();
                if (!it2.hasNext()) {
                    com.google.gson.internal.a.l();
                    return null;
                }
                int i12 = ((Match) it2.next()).getResultRange().f5696b;
                while (it2.hasNext()) {
                    int i13 = ((Match) it2.next()).getResultRange().f5696b;
                    if (i12 < i13) {
                        i12 = i13;
                    }
                }
                Iterable dVar = new i7.d(i10, i12, 1);
                if (!(dVar instanceof Collection) || !((Collection) dVar).isEmpty()) {
                    Iterator it3 = dVar.iterator();
                    int i14 = 0;
                    while (((i7.c) it3).f5700l) {
                        int nextInt = ((q6.x) it3).nextInt();
                        Iterator<T> it4 = list2.iterator();
                        int i15 = 0;
                        while (true) {
                            if (it4.hasNext()) {
                                i7.d resultRange = ((Match) it4.next()).getResultRange();
                                if (resultRange.f5695a <= nextInt && nextInt <= resultRange.f5696b) {
                                    i15++;
                                }
                                if (i15 > 1) {
                                    i14++;
                                    if (i14 < 0) {
                                        m.g0();
                                        throw null;
                                    }
                                }
                            }
                        }
                    }
                    i = i14;
                }
                return new Solution(list, i6, i);
            }

            public final Solution getNO_SOLUTION() {
                return Solution.NO_SOLUTION;
            }

            private Companion() {
            }
        }
    }

    public static final int[][] resolve(List<String> list, String[][] strArr) {
        list.getClass();
        strArr.getClass();
        return resolve((String[]) list.toArray(new String[0]), strArr);
    }
}
