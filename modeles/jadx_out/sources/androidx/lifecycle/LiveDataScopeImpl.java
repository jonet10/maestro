package androidx.lifecycle;

import android.annotation.SuppressLint;
import o7.c0;
import o7.m0;
import p6.x;
import t7.n;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class LiveDataScopeImpl<T> implements LiveDataScope<T> {
    private final t6.h coroutineContext;
    private CoroutineLiveData<T> target;

    public LiveDataScopeImpl(CoroutineLiveData<T> coroutineLiveData, t6.h hVar) {
        coroutineLiveData.getClass();
        hVar.getClass();
        this.target = coroutineLiveData;
        v7.e eVar = m0.f8288a;
        this.coroutineContext = hVar.plus(n.f10348a.f8468l);
    }

    @Override // androidx.lifecycle.LiveDataScope
    @SuppressLint({"NullSafeMutableLiveData"})
    public Object emit(T t9, t6.c cVar) {
        Object C = c0.C(new LiveDataScopeImpl$emit$2(this, t9, null), this.coroutineContext, cVar);
        return C == u6.a.f10762a ? C : x.f8463a;
    }

    @Override // androidx.lifecycle.LiveDataScope
    public Object emitSource(LiveData<T> liveData, t6.c cVar) {
        return c0.C(new LiveDataScopeImpl$emitSource$2(this, liveData, null), this.coroutineContext, cVar);
    }

    @Override // androidx.lifecycle.LiveDataScope
    public T getLatestValue() {
        return this.target.getValue();
    }

    public final CoroutineLiveData<T> getTarget$lifecycle_livedata() {
        return this.target;
    }

    public final void setTarget$lifecycle_livedata(CoroutineLiveData<T> coroutineLiveData) {
        coroutineLiveData.getClass();
        this.target = coroutineLiveData;
    }
}
