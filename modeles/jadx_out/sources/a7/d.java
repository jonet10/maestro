package a7;

import java.io.BufferedReader;
import java.util.Iterator;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class d implements Iterator, e7.a {

    /* renamed from: a, reason: collision with root package name */
    public String f208a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f209b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ e f210l;

    public d(e eVar) {
        this.f210l = eVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f208a == null && !this.f209b) {
            String readLine = ((BufferedReader) this.f210l.f212b).readLine();
            this.f208a = readLine;
            if (readLine == null) {
                this.f209b = true;
            }
        }
        return this.f208a != null;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            com.google.gson.internal.a.l();
            return null;
        }
        String str = this.f208a;
        this.f208a = null;
        str.getClass();
        return str;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
