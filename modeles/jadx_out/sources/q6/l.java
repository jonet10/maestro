package q6;

import androidx.graphics.shapes.MeasuredPolygon;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class l extends r {
    public static ArrayList A0(Iterable iterable, Collection collection) {
        iterable.getClass();
        if (!(iterable instanceof Collection)) {
            ArrayList arrayList = new ArrayList(collection);
            r.k0(iterable, arrayList);
            return arrayList;
        }
        Collection collection2 = (Collection) iterable;
        ArrayList arrayList2 = new ArrayList(collection2.size() + collection.size());
        arrayList2.addAll(collection);
        arrayList2.addAll(collection2);
        return arrayList2;
    }

    public static List B0(Iterable iterable) {
        iterable.getClass();
        if (!(iterable instanceof Collection)) {
            List H0 = H0(iterable);
            if (((ArrayList) H0).size() > 1) {
                Collections.sort(H0);
            }
            return H0;
        }
        Collection collection = (Collection) iterable;
        if (collection.size() <= 1) {
            return G0(iterable);
        }
        Object[] array = collection.toArray(new Comparable[0]);
        Comparable[] comparableArr = (Comparable[]) array;
        comparableArr.getClass();
        if (comparableArr.length > 1) {
            Arrays.sort(comparableArr);
        }
        array.getClass();
        List asList = Arrays.asList(array);
        asList.getClass();
        return asList;
    }

    public static List C0(Iterable iterable, Comparator comparator) {
        iterable.getClass();
        if (!(iterable instanceof Collection)) {
            List H0 = H0(iterable);
            q.j0(H0, comparator);
            return H0;
        }
        Collection collection = (Collection) iterable;
        if (collection.size() <= 1) {
            return G0(iterable);
        }
        Object[] array = collection.toArray(new Object[0]);
        array.getClass();
        if (array.length > 1) {
            Arrays.sort(array, comparator);
        }
        List asList = Arrays.asList(array);
        asList.getClass();
        return asList;
    }

    public static List D0(ArrayList arrayList, int i) {
        if (i < 0) {
            s1.o.o(a4.x.g(i, "Requested element count ", " is less than zero."));
            return null;
        }
        if (i == 0) {
            return t.f8724a;
        }
        if (i >= arrayList.size()) {
            return G0(arrayList);
        }
        if (i == 1) {
            return a.a.H(q0(arrayList));
        }
        ArrayList arrayList2 = new ArrayList(i);
        int size = arrayList.size();
        int i6 = 0;
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            arrayList2.add(obj);
            i6++;
            if (i6 == i) {
                break;
            }
        }
        return m.f0(arrayList2);
    }

    public static final void E0(Iterable iterable, AbstractCollection abstractCollection) {
        iterable.getClass();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            abstractCollection.add(it.next());
        }
    }

    public static int[] F0(Collection collection) {
        collection.getClass();
        int[] iArr = new int[collection.size()];
        Iterator it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            iArr[i] = ((Number) it.next()).intValue();
            i++;
        }
        return iArr;
    }

    public static List G0(Iterable iterable) {
        iterable.getClass();
        if (!(iterable instanceof Collection)) {
            return m.f0(H0(iterable));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return t.f8724a;
        }
        if (size != 1) {
            return new ArrayList(collection);
        }
        return a.a.H(iterable instanceof List ? ((List) iterable).get(0) : collection.iterator().next());
    }

    public static final List H0(Iterable iterable) {
        iterable.getClass();
        if (iterable instanceof Collection) {
            return new ArrayList((Collection) iterable);
        }
        ArrayList arrayList = new ArrayList();
        E0(iterable, arrayList);
        return arrayList;
    }

    public static Set I0(Collection collection) {
        collection.getClass();
        if (collection instanceof Collection) {
            return new LinkedHashSet(collection);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        E0(collection, linkedHashSet);
        return linkedHashSet;
    }

    public static Set J0(Iterable iterable) {
        iterable.getClass();
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            int size = collection.size();
            if (size != 0) {
                if (size != 1) {
                    LinkedHashSet linkedHashSet = new LinkedHashSet(a0.h0(collection.size()));
                    E0(iterable, linkedHashSet);
                    return linkedHashSet;
                }
                Set singleton = Collections.singleton(iterable instanceof List ? ((List) iterable).get(0) : collection.iterator().next());
                singleton.getClass();
                return singleton;
            }
        } else {
            LinkedHashSet linkedHashSet2 = new LinkedHashSet();
            E0(iterable, linkedHashSet2);
            int size2 = linkedHashSet2.size();
            if (size2 != 0) {
                if (size2 != 1) {
                    return linkedHashSet2;
                }
                Set singleton2 = Collections.singleton(linkedHashSet2.iterator().next());
                singleton2.getClass();
                return singleton2;
            }
        }
        return v.f8726a;
    }

    public static boolean o0(Iterable iterable, Object obj) {
        int i;
        iterable.getClass();
        if (iterable instanceof Collection) {
            return ((Collection) iterable).contains(obj);
        }
        if (!(iterable instanceof List)) {
            Iterator it = iterable.iterator();
            int i6 = 0;
            while (true) {
                if (!it.hasNext()) {
                    i = -1;
                    break;
                }
                Object next = it.next();
                if (i6 < 0) {
                    m.h0();
                    throw null;
                }
                if (kotlin.jvm.internal.l.a(obj, next)) {
                    i = i6;
                    break;
                }
                i6++;
            }
        } else {
            i = ((List) iterable).indexOf(obj);
        }
        return i >= 0;
    }

    public static Object p0(Iterable iterable, int i) {
        iterable.getClass();
        boolean z9 = iterable instanceof List;
        if (z9) {
            return ((List) iterable).get(i);
        }
        androidx.room.support.b bVar = new androidx.room.support.b(i, 5);
        if (z9) {
            List list = (List) iterable;
            if (i >= 0 && i < list.size()) {
                return list.get(i);
            }
            bVar.invoke(Integer.valueOf(i));
            throw null;
        }
        if (i < 0) {
            bVar.invoke(Integer.valueOf(i));
            throw null;
        }
        int i6 = 0;
        for (Object obj : iterable) {
            int i10 = i6 + 1;
            if (i == i6) {
                return obj;
            }
            i6 = i10;
        }
        bVar.invoke(Integer.valueOf(i));
        throw null;
    }

    public static Object q0(List list) {
        list.getClass();
        if (!list.isEmpty()) {
            return list.get(0);
        }
        androidx.privacysandbox.ads.adservices.customaudience.a.s("List is empty.");
        return null;
    }

    public static Object r0(List list) {
        list.getClass();
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public static Object s0(Set set) {
        set.getClass();
        if (set instanceof List) {
            List list = (List) set;
            if (list.isEmpty()) {
                return null;
            }
            return list.get(0);
        }
        Iterator it = set.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        return null;
    }

    public static Object t0(MeasuredPolygon measuredPolygon, int i) {
        measuredPolygon.getClass();
        if (i < 0 || i >= measuredPolygon.size()) {
            return null;
        }
        return measuredPolygon.get(i);
    }

    public static int u0(List list, Object obj) {
        list.getClass();
        return list.indexOf(obj);
    }

    public static final void v0(Iterable iterable, StringBuilder sb, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, d7.l lVar) {
        iterable.getClass();
        sb.append(charSequence2);
        int i = 0;
        for (Object obj : iterable) {
            i++;
            if (i > 1) {
                sb.append(charSequence);
            }
            a.a.i(sb, obj, lVar);
        }
        sb.append(charSequence3);
    }

    public static String x0(Iterable iterable, String str, String str2, String str3, d7.l lVar, int i) {
        if ((i & 1) != 0) {
            str = ", ";
        }
        String str4 = str;
        String str5 = (i & 2) != 0 ? "" : str2;
        String str6 = (i & 4) != 0 ? "" : str3;
        if ((i & 32) != 0) {
            lVar = null;
        }
        iterable.getClass();
        StringBuilder sb = new StringBuilder();
        v0(iterable, sb, str4, str5, str6, "...", lVar);
        return sb.toString();
    }

    public static Object y0(List list) {
        list.getClass();
        if (!list.isEmpty()) {
            return list.get(list.size() - 1);
        }
        androidx.privacysandbox.ads.adservices.customaudience.a.s("List is empty.");
        return null;
    }

    public static Comparable z0(Iterable iterable) {
        iterable.getClass();
        Iterator it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        Comparable comparable = (Comparable) it.next();
        while (it.hasNext()) {
            Comparable comparable2 = (Comparable) it.next();
            if (comparable.compareTo(comparable2) < 0) {
                comparable = comparable2;
            }
        }
        return comparable;
    }
}
