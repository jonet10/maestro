package androidx.core.util;

import android.annotation.SuppressLint;
import p6.i;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class PairKt {
    @SuppressLint({"UnknownNullness"})
    public static final <F, S> F component1(Pair<F, S> pair) {
        return pair.first;
    }

    @SuppressLint({"UnknownNullness"})
    public static final <F, S> S component2(Pair<F, S> pair) {
        return pair.second;
    }

    public static final <F, S> android.util.Pair<F, S> toAndroidPair(i iVar) {
        return new android.util.Pair<>(iVar.f8441a, iVar.f8442b);
    }

    public static final <F, S> Pair<F, S> toAndroidXPair(i iVar) {
        return new Pair<>(iVar.f8441a, iVar.f8442b);
    }

    public static final <F, S> i toKotlinPair(Pair<F, S> pair) {
        return new i(pair.first, pair.second);
    }

    @SuppressLint({"UnknownNullness"})
    public static final <F, S> F component1(android.util.Pair<F, S> pair) {
        return (F) pair.first;
    }

    @SuppressLint({"UnknownNullness"})
    public static final <F, S> S component2(android.util.Pair<F, S> pair) {
        return (S) pair.second;
    }

    public static final <F, S> i toKotlinPair(android.util.Pair<F, S> pair) {
        return new i(pair.first, pair.second);
    }
}
