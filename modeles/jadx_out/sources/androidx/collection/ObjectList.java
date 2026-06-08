package androidx.collection;

import a3.b;
import a4.x;
import androidx.annotation.IntRange;
import com.google.gson.internal.a;
import d7.l;
import d7.p;
import d7.q;
import i7.d;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.g;
import t0.f;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public abstract class ObjectList<E> {
    public int _size;
    public Object[] content;

    private ObjectList(int i) {
        this.content = i == 0 ? ObjectListKt.EmptyArray : new Object[i];
    }

    public static /* synthetic */ String joinToString$default(ObjectList objectList, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, l lVar, int i6, Object obj) {
        if (obj != null) {
            b.r("Super calls with default arguments not supported in this target, function: joinToString");
            return null;
        }
        if ((i6 & 1) != 0) {
            charSequence = ", ";
        }
        if ((i6 & 2) != 0) {
            charSequence2 = "";
        }
        if ((i6 & 4) != 0) {
            charSequence3 = "";
        }
        if ((i6 & 8) != 0) {
            i = -1;
        }
        if ((i6 & 16) != 0) {
            charSequence4 = "...";
        }
        if ((i6 & 32) != 0) {
            lVar = null;
        }
        CharSequence charSequence5 = charSequence4;
        l lVar2 = lVar;
        return objectList.joinToString(charSequence, charSequence2, charSequence3, i, charSequence5, lVar2);
    }

    public final boolean any(l lVar) {
        lVar.getClass();
        Object[] objArr = this.content;
        int i = this._size;
        for (int i6 = 0; i6 < i; i6++) {
            if (((Boolean) lVar.invoke(objArr[i6])).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public abstract List<E> asList();

    public final boolean contains(E e10) {
        return indexOf(e10) >= 0;
    }

    public final boolean containsAll(List<? extends E> list) {
        list.getClass();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (!contains(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    public final int count(l lVar) {
        lVar.getClass();
        Object[] objArr = this.content;
        int i = this._size;
        int i6 = 0;
        for (int i10 = 0; i10 < i; i10++) {
            if (((Boolean) lVar.invoke(objArr[i10])).booleanValue()) {
                i6++;
            }
        }
        return i6;
    }

    public final E elementAt(@IntRange(from = 0) int i) {
        if (i >= 0 && i < this._size) {
            return (E) this.content[i];
        }
        a.g(this._size - 1, x.p(i, "Index ", " must be in 0.."));
        return null;
    }

    public final E elementAtOrElse(@IntRange(from = 0) int i, l lVar) {
        lVar.getClass();
        return (i < 0 || i >= this._size) ? (E) lVar.invoke(Integer.valueOf(i)) : (E) this.content[i];
    }

    public boolean equals(Object obj) {
        if (obj instanceof ObjectList) {
            ObjectList objectList = (ObjectList) obj;
            int i = objectList._size;
            int i6 = this._size;
            if (i == i6) {
                Object[] objArr = this.content;
                Object[] objArr2 = objectList.content;
                d K = f.K(0, i6);
                int i10 = K.f5695a;
                int i11 = K.f5696b;
                if (i10 > i11) {
                    return true;
                }
                while (kotlin.jvm.internal.l.a(objArr[i10], objArr2[i10])) {
                    if (i10 == i11) {
                        return true;
                    }
                    i10++;
                }
                return false;
            }
        }
        return false;
    }

    public final E first(l lVar) {
        lVar.getClass();
        Object[] objArr = this.content;
        int i = this._size;
        for (int i6 = 0; i6 < i; i6++) {
            E e10 = (E) objArr[i6];
            if (((Boolean) lVar.invoke(e10)).booleanValue()) {
                return e10;
            }
        }
        androidx.privacysandbox.ads.adservices.customaudience.a.s("ObjectList contains no element matching the predicate.");
        return null;
    }

    public final E firstOrNull(l lVar) {
        lVar.getClass();
        Object[] objArr = this.content;
        int i = this._size;
        for (int i6 = 0; i6 < i; i6++) {
            E e10 = (E) objArr[i6];
            if (((Boolean) lVar.invoke(e10)).booleanValue()) {
                return e10;
            }
        }
        return null;
    }

    public final <R> R fold(R r9, p pVar) {
        pVar.getClass();
        Object[] objArr = this.content;
        int i = this._size;
        for (int i6 = 0; i6 < i; i6++) {
            r9 = (R) pVar.invoke(r9, objArr[i6]);
        }
        return r9;
    }

    public final <R> R foldIndexed(R r9, q qVar) {
        qVar.getClass();
        Object[] objArr = this.content;
        int i = this._size;
        for (int i6 = 0; i6 < i; i6++) {
            r9 = (R) qVar.invoke(Integer.valueOf(i6), r9, objArr[i6]);
        }
        return r9;
    }

    public final <R> R foldRight(R r9, p pVar) {
        pVar.getClass();
        Object[] objArr = this.content;
        int i = this._size;
        while (true) {
            i--;
            if (-1 >= i) {
                return r9;
            }
            r9 = (R) pVar.invoke(objArr[i], r9);
        }
    }

    public final <R> R foldRightIndexed(R r9, q qVar) {
        qVar.getClass();
        Object[] objArr = this.content;
        int i = this._size;
        while (true) {
            i--;
            if (-1 >= i) {
                return r9;
            }
            r9 = (R) qVar.invoke(Integer.valueOf(i), objArr[i], r9);
        }
    }

    public final void forEach(l lVar) {
        lVar.getClass();
        Object[] objArr = this.content;
        int i = this._size;
        for (int i6 = 0; i6 < i; i6++) {
            lVar.invoke(objArr[i6]);
        }
    }

    public final void forEachIndexed(p pVar) {
        pVar.getClass();
        Object[] objArr = this.content;
        int i = this._size;
        for (int i6 = 0; i6 < i; i6++) {
            pVar.invoke(Integer.valueOf(i6), objArr[i6]);
        }
    }

    public final void forEachReversed(l lVar) {
        lVar.getClass();
        Object[] objArr = this.content;
        int i = this._size;
        while (true) {
            i--;
            if (-1 >= i) {
                return;
            } else {
                lVar.invoke(objArr[i]);
            }
        }
    }

    public final void forEachReversedIndexed(p pVar) {
        pVar.getClass();
        Object[] objArr = this.content;
        int i = this._size;
        while (true) {
            i--;
            if (-1 >= i) {
                return;
            } else {
                pVar.invoke(Integer.valueOf(i), objArr[i]);
            }
        }
    }

    public final E get(@IntRange(from = 0) int i) {
        if (i >= 0 && i < this._size) {
            return (E) this.content[i];
        }
        a.g(this._size - 1, x.p(i, "Index ", " must be in 0.."));
        return null;
    }

    public final d getIndices() {
        return f.K(0, this._size);
    }

    @IntRange(from = -1)
    public final int getLastIndex() {
        return this._size - 1;
    }

    @IntRange(from = 0)
    public final int getSize() {
        return this._size;
    }

    public int hashCode() {
        Object[] objArr = this.content;
        int i = this._size;
        int i6 = 0;
        for (int i10 = 0; i10 < i; i10++) {
            Object obj = objArr[i10];
            i6 += (obj != null ? obj.hashCode() : 0) * 31;
        }
        return i6;
    }

    public final int indexOf(E e10) {
        Object[] objArr = this.content;
        int i = 0;
        if (e10 == null) {
            int i6 = this._size;
            while (i < i6) {
                if (objArr[i] == null) {
                    return i;
                }
                i++;
            }
            return -1;
        }
        int i10 = this._size;
        while (i < i10) {
            if (e10.equals(objArr[i])) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public final int indexOfFirst(l lVar) {
        lVar.getClass();
        Object[] objArr = this.content;
        int i = this._size;
        for (int i6 = 0; i6 < i; i6++) {
            if (((Boolean) lVar.invoke(objArr[i6])).booleanValue()) {
                return i6;
            }
        }
        return -1;
    }

    public final int indexOfLast(l lVar) {
        lVar.getClass();
        Object[] objArr = this.content;
        int i = this._size;
        do {
            i--;
            if (-1 >= i) {
                return -1;
            }
        } while (!((Boolean) lVar.invoke(objArr[i])).booleanValue());
        return i;
    }

    public final boolean isEmpty() {
        return this._size == 0;
    }

    public final boolean isNotEmpty() {
        return this._size != 0;
    }

    public final String joinToString(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, l lVar) {
        StringBuilder s6 = x.s(charSequence, charSequence2, charSequence3, charSequence4, charSequence2);
        Object[] objArr = this.content;
        int i6 = this._size;
        int i10 = 0;
        while (true) {
            if (i10 >= i6) {
                s6.append(charSequence3);
                break;
            }
            Object obj = objArr[i10];
            if (i10 == i) {
                s6.append(charSequence4);
                break;
            }
            if (i10 != 0) {
                s6.append(charSequence);
            }
            if (lVar == null) {
                s6.append(obj);
            } else {
                s6.append((CharSequence) lVar.invoke(obj));
            }
            i10++;
        }
        return s6.toString();
    }

    public final E last(l lVar) {
        E e10;
        lVar.getClass();
        Object[] objArr = this.content;
        int i = this._size;
        do {
            i--;
            if (-1 >= i) {
                androidx.privacysandbox.ads.adservices.customaudience.a.s("ObjectList contains no element matching the predicate.");
                return null;
            }
            e10 = (E) objArr[i];
        } while (!((Boolean) lVar.invoke(e10)).booleanValue());
        return e10;
    }

    public final int lastIndexOf(E e10) {
        Object[] objArr = this.content;
        if (e10 == null) {
            for (int i = this._size - 1; -1 < i; i--) {
                if (objArr[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i6 = this._size - 1; -1 < i6; i6--) {
                if (e10.equals(objArr[i6])) {
                    return i6;
                }
            }
        }
        return -1;
    }

    public final E lastOrNull(l lVar) {
        E e10;
        lVar.getClass();
        Object[] objArr = this.content;
        int i = this._size;
        do {
            i--;
            if (-1 >= i) {
                return null;
            }
            e10 = (E) objArr[i];
        } while (!((Boolean) lVar.invoke(e10)).booleanValue());
        return e10;
    }

    public final boolean none() {
        return isEmpty();
    }

    public final boolean reversedAny(l lVar) {
        lVar.getClass();
        Object[] objArr = this.content;
        for (int i = this._size - 1; -1 < i; i--) {
            if (((Boolean) lVar.invoke(objArr[i])).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return joinToString$default(this, null, "[", "]", 0, null, new ObjectList$toString$1(this), 25, null);
    }

    public /* synthetic */ ObjectList(int i, g gVar) {
        this(i);
    }

    public static /* synthetic */ void getContent$annotations() {
    }

    public static /* synthetic */ void get_size$annotations() {
    }

    public final boolean containsAll(E[] eArr) {
        eArr.getClass();
        for (E e10 : eArr) {
            if (!contains(e10)) {
                return false;
            }
        }
        return true;
    }

    public final boolean containsAll(Iterable<? extends E> iterable) {
        iterable.getClass();
        Iterator<? extends E> it = iterable.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public final E firstOrNull() {
        if (isEmpty()) {
            return null;
        }
        return get(0);
    }

    public final boolean any() {
        return isNotEmpty();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean containsAll(ObjectList<E> objectList) {
        objectList.getClass();
        Object[] objArr = objectList.content;
        int i = objectList._size;
        for (int i6 = 0; i6 < i; i6++) {
            if (!contains(objArr[i6])) {
                return false;
            }
        }
        return true;
    }

    public final int count() {
        return this._size;
    }

    public final E lastOrNull() {
        if (isEmpty()) {
            return null;
        }
        return (E) this.content[this._size - 1];
    }

    public final E first() {
        if (!isEmpty()) {
            return (E) this.content[0];
        }
        androidx.privacysandbox.ads.adservices.customaudience.a.s("ObjectList is empty.");
        return null;
    }

    public final E last() {
        if (!isEmpty()) {
            return (E) this.content[this._size - 1];
        }
        androidx.privacysandbox.ads.adservices.customaudience.a.s("ObjectList is empty.");
        return null;
    }

    public final String joinToString(CharSequence charSequence) {
        charSequence.getClass();
        return joinToString$default(this, charSequence, null, null, 0, null, null, 62, null);
    }

    public final String joinToString(CharSequence charSequence, CharSequence charSequence2) {
        charSequence.getClass();
        charSequence2.getClass();
        return joinToString$default(this, charSequence, charSequence2, null, 0, null, null, 60, null);
    }

    public final String joinToString(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3) {
        x.A(charSequence, charSequence2, charSequence3);
        return joinToString$default(this, charSequence, charSequence2, charSequence3, 0, null, null, 56, null);
    }

    public final String joinToString(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i) {
        x.A(charSequence, charSequence2, charSequence3);
        return joinToString$default(this, charSequence, charSequence2, charSequence3, i, null, null, 48, null);
    }

    public final String joinToString(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4) {
        charSequence.getClass();
        charSequence2.getClass();
        charSequence3.getClass();
        charSequence4.getClass();
        return joinToString$default(this, charSequence, charSequence2, charSequence3, i, charSequence4, null, 32, null);
    }

    public final String joinToString() {
        return joinToString$default(this, null, null, null, 0, null, null, 63, null);
    }
}
