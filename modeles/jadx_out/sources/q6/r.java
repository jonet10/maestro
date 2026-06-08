package q6;

import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class r extends q {
    public static void k0(Iterable iterable, Collection collection) {
        collection.getClass();
        iterable.getClass();
        if (iterable instanceof Collection) {
            collection.addAll((Collection) iterable);
            return;
        }
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            collection.add(it.next());
        }
    }

    public static void l0(AbstractCollection abstractCollection, Object[] objArr) {
        objArr.getClass();
        List asList = Arrays.asList(objArr);
        asList.getClass();
        abstractCollection.addAll(asList);
    }

    public static void m0(List list, d7.l lVar) {
        int size;
        list.getClass();
        if (!(list instanceof RandomAccess)) {
            if ((list instanceof e7.a) && !(list instanceof e7.b)) {
                kotlin.jvm.internal.a0.e(list, "kotlin.collections.MutableIterable");
                throw null;
            }
            try {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    if (((Boolean) lVar.invoke(it.next())).booleanValue()) {
                        it.remove();
                    }
                }
                return;
            } catch (ClassCastException e10) {
                kotlin.jvm.internal.l.e(e10, kotlin.jvm.internal.a0.class.getName());
                throw e10;
            }
        }
        int size2 = list.size() - 1;
        int i = 0;
        if (size2 >= 0) {
            int i6 = 0;
            while (true) {
                Object obj = list.get(i);
                if (!((Boolean) lVar.invoke(obj)).booleanValue()) {
                    if (i6 != i) {
                        list.set(i6, obj);
                    }
                    i6++;
                }
                if (i == size2) {
                    break;
                } else {
                    i++;
                }
            }
            i = i6;
        }
        if (i >= list.size() || i > (size = list.size() - 1)) {
            return;
        }
        while (true) {
            list.remove(size);
            if (size == i) {
                return;
            } else {
                size--;
            }
        }
    }

    public static Object n0(List list) {
        list.getClass();
        if (!list.isEmpty()) {
            return list.remove(list.size() - 1);
        }
        androidx.privacysandbox.ads.adservices.customaudience.a.s("List is empty.");
        return null;
    }
}
