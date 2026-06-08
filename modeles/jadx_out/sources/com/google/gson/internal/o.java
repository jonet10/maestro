package com.google.gson.internal;

import j$.util.Objects;
import java.io.Writer;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class o extends Writer {

    /* renamed from: a, reason: collision with root package name */
    public final StringBuilder f3248a;

    /* renamed from: b, reason: collision with root package name */
    public final n f3249b = new n();

    public o(StringBuilder sb) {
        this.f3248a = sb;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public final Writer append(CharSequence charSequence) {
        this.f3248a.append(charSequence);
        return this;
    }

    @Override // java.io.Writer
    public final void write(char[] cArr, int i, int i6) {
        n nVar = this.f3249b;
        nVar.f3246a = cArr;
        nVar.f3247b = null;
        this.f3248a.append((CharSequence) nVar, i, i6 + i);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public final Appendable append(CharSequence charSequence) {
        this.f3248a.append(charSequence);
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public final Writer append(CharSequence charSequence, int i, int i6) {
        this.f3248a.append(charSequence, i, i6);
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public final Appendable append(CharSequence charSequence, int i, int i6) {
        this.f3248a.append(charSequence, i, i6);
        return this;
    }

    @Override // java.io.Writer
    public final void write(String str, int i, int i6) {
        Objects.requireNonNull(str);
        this.f3248a.append((CharSequence) str, i, i6 + i);
    }

    @Override // java.io.Writer
    public final void write(int i) {
        this.f3248a.append((char) i);
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // java.io.Writer, java.io.Flushable
    public final void flush() {
    }
}
