package androidx.lifecycle;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public interface LiveDataScope<T> {
    Object emit(T t9, t6.c cVar);

    Object emitSource(LiveData<T> liveData, t6.c cVar);

    T getLatestValue();
}
