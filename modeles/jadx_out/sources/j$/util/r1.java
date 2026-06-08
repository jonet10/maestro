package j$.util;

import androidx.core.location.LocationRequestCompat;
import java.util.Comparator;
import java.util.Iterator;
import java.util.function.Consumer;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public class r1 implements Spliterator {

    /* renamed from: a, reason: collision with root package name */
    public final java.util.Collection f6110a;

    /* renamed from: b, reason: collision with root package name */
    public Iterator f6111b = null;

    /* renamed from: c, reason: collision with root package name */
    public final int f6112c;

    /* renamed from: d, reason: collision with root package name */
    public long f6113d;

    /* renamed from: e, reason: collision with root package name */
    public int f6114e;

    @Override // j$.util.Spliterator
    public final /* synthetic */ long getExactSizeIfKnown() {
        return c.d(this);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ boolean hasCharacteristics(int i) {
        return c.e(this, i);
    }

    public r1(java.util.Collection collection, int i) {
        this.f6110a = collection;
        this.f6112c = (i & 4096) == 0 ? i | 16448 : i;
    }

    @Override // j$.util.Spliterator
    public final Spliterator trySplit() {
        long j;
        Iterator it = this.f6111b;
        if (it == null) {
            it = this.f6110a.iterator();
            this.f6111b = it;
            j = this.f6110a.size();
            this.f6113d = j;
        } else {
            j = this.f6113d;
        }
        if (j <= 1 || !it.hasNext()) {
            return null;
        }
        int i = this.f6114e + 1024;
        if (i > j) {
            i = (int) j;
        }
        if (i > 33554432) {
            i = 33554432;
        }
        Object[] objArr = new Object[i];
        int i6 = 0;
        do {
            objArr[i6] = it.next();
            i6++;
            if (i6 >= i) {
                break;
            }
        } while (it.hasNext());
        this.f6114e = i6;
        long j6 = this.f6113d;
        if (j6 != LocationRequestCompat.PASSIVE_INTERVAL) {
            this.f6113d = j6 - i6;
        }
        return new k1(objArr, 0, i6, this.f6112c);
    }

    @Override // j$.util.Spliterator
    public final void forEachRemaining(Consumer consumer) {
        consumer.getClass();
        Iterator it = this.f6111b;
        if (it == null) {
            it = this.f6110a.iterator();
            this.f6111b = it;
            this.f6113d = this.f6110a.size();
        }
        c.r(it, consumer);
    }

    @Override // j$.util.Spliterator
    public final boolean tryAdvance(Consumer consumer) {
        consumer.getClass();
        if (this.f6111b == null) {
            this.f6111b = this.f6110a.iterator();
            this.f6113d = this.f6110a.size();
        }
        if (!this.f6111b.hasNext()) {
            return false;
        }
        consumer.accept(this.f6111b.next());
        return true;
    }

    @Override // j$.util.Spliterator
    public final long estimateSize() {
        if (this.f6111b == null) {
            this.f6111b = this.f6110a.iterator();
            long size = this.f6110a.size();
            this.f6113d = size;
            return size;
        }
        return this.f6113d;
    }

    @Override // j$.util.Spliterator
    public final int characteristics() {
        return this.f6112c;
    }

    @Override // j$.util.Spliterator
    public Comparator getComparator() {
        if (c.e(this, 4)) {
            return null;
        }
        throw new IllegalStateException();
    }
}
