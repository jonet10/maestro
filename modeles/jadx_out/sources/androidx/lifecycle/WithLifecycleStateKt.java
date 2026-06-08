package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import o7.m0;
import o7.w;
import p6.x;
import t7.n;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class WithLifecycleStateKt {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v2, types: [androidx.lifecycle.LifecycleObserver, androidx.lifecycle.WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1] */
    public static final <R> Object suspendWithStateAtLeastUnchecked(final Lifecycle lifecycle, final Lifecycle.State state, boolean z9, final w wVar, final d7.a aVar, t6.c cVar) {
        final o7.l lVar = new o7.l(1, d0.b.I(cVar));
        lVar.s();
        final ?? r72 = new LifecycleEventObserver() { // from class: androidx.lifecycle.WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1
            @Override // androidx.lifecycle.LifecycleEventObserver
            public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                Object jVar;
                lifecycleOwner.getClass();
                event.getClass();
                if (event != Lifecycle.Event.Companion.upTo(Lifecycle.State.this)) {
                    if (event == Lifecycle.Event.ON_DESTROY) {
                        lifecycle.removeObserver(this);
                        lVar.resumeWith(new p6.j(new LifecycleDestroyedException()));
                        return;
                    }
                    return;
                }
                lifecycle.removeObserver(this);
                o7.j jVar2 = lVar;
                try {
                    jVar = aVar.invoke();
                } catch (Throwable th) {
                    jVar = new p6.j(th);
                }
                jVar2.resumeWith(jVar);
            }
        };
        if (z9) {
            wVar.dispatch(t6.i.f10314a, new Runnable() { // from class: androidx.lifecycle.WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$1
                @Override // java.lang.Runnable
                public final void run() {
                    Lifecycle.this.addObserver(r72);
                }
            });
        } else {
            lifecycle.addObserver(r72);
        }
        lVar.u(new d7.l() { // from class: androidx.lifecycle.WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$2
            public final void invoke(Throwable th) {
                w wVar2 = w.this;
                t6.i iVar = t6.i.f10314a;
                if (!wVar2.isDispatchNeeded(iVar)) {
                    lifecycle.removeObserver(r72);
                    return;
                }
                w wVar3 = w.this;
                final Lifecycle lifecycle2 = lifecycle;
                final WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1 withLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1 = r72;
                wVar3.dispatch(iVar, new Runnable() { // from class: androidx.lifecycle.WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$2.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        Lifecycle.this.removeObserver(withLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1);
                    }
                });
            }

            @Override // d7.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return x.f8463a;
            }
        });
        return lVar.r();
    }

    public static final <R> Object withCreated(LifecycleOwner lifecycleOwner, d7.a aVar, t6.c cVar) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        Lifecycle.State state = Lifecycle.State.CREATED;
        v7.e eVar = m0.f8288a;
        p7.c cVar2 = n.f10348a.f8468l;
        boolean isDispatchNeeded = cVar2.isDispatchNeeded(cVar.getContext());
        if (!isDispatchNeeded) {
            if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                throw new LifecycleDestroyedException();
            }
            if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                return aVar.invoke();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, isDispatchNeeded, cVar2, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(aVar), cVar);
    }

    private static final <R> Object withCreated$$forInline(LifecycleOwner lifecycleOwner, d7.a aVar, t6.c cVar) {
        lifecycleOwner.getLifecycle();
        Lifecycle.State state = Lifecycle.State.DESTROYED;
        v7.e eVar = m0.f8288a;
        p7.c cVar2 = n.f10348a.f8468l;
        throw null;
    }

    public static final <R> Object withResumed(LifecycleOwner lifecycleOwner, d7.a aVar, t6.c cVar) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        Lifecycle.State state = Lifecycle.State.RESUMED;
        v7.e eVar = m0.f8288a;
        p7.c cVar2 = n.f10348a.f8468l;
        boolean isDispatchNeeded = cVar2.isDispatchNeeded(cVar.getContext());
        if (!isDispatchNeeded) {
            if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                throw new LifecycleDestroyedException();
            }
            if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                return aVar.invoke();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, isDispatchNeeded, cVar2, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(aVar), cVar);
    }

    private static final <R> Object withResumed$$forInline(LifecycleOwner lifecycleOwner, d7.a aVar, t6.c cVar) {
        lifecycleOwner.getLifecycle();
        Lifecycle.State state = Lifecycle.State.DESTROYED;
        v7.e eVar = m0.f8288a;
        p7.c cVar2 = n.f10348a.f8468l;
        throw null;
    }

    public static final <R> Object withStarted(LifecycleOwner lifecycleOwner, d7.a aVar, t6.c cVar) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        Lifecycle.State state = Lifecycle.State.STARTED;
        v7.e eVar = m0.f8288a;
        p7.c cVar2 = n.f10348a.f8468l;
        boolean isDispatchNeeded = cVar2.isDispatchNeeded(cVar.getContext());
        if (!isDispatchNeeded) {
            if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                throw new LifecycleDestroyedException();
            }
            if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                return aVar.invoke();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, isDispatchNeeded, cVar2, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(aVar), cVar);
    }

    private static final <R> Object withStarted$$forInline(LifecycleOwner lifecycleOwner, d7.a aVar, t6.c cVar) {
        lifecycleOwner.getLifecycle();
        Lifecycle.State state = Lifecycle.State.DESTROYED;
        v7.e eVar = m0.f8288a;
        p7.c cVar2 = n.f10348a.f8468l;
        throw null;
    }

    public static final <R> Object withStateAtLeast(LifecycleOwner lifecycleOwner, Lifecycle.State state, d7.a aVar, t6.c cVar) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        if (state.compareTo(Lifecycle.State.CREATED) < 0) {
            androidx.core.content.pm.a.i(state, "target state must be CREATED or greater, found ");
            return null;
        }
        v7.e eVar = m0.f8288a;
        p7.c cVar2 = n.f10348a.f8468l;
        boolean isDispatchNeeded = cVar2.isDispatchNeeded(cVar.getContext());
        if (!isDispatchNeeded) {
            if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                throw new LifecycleDestroyedException();
            }
            if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                return aVar.invoke();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, isDispatchNeeded, cVar2, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(aVar), cVar);
    }

    private static final <R> Object withStateAtLeast$$forInline(LifecycleOwner lifecycleOwner, Lifecycle.State state, d7.a aVar, t6.c cVar) {
        lifecycleOwner.getLifecycle();
        if (state.compareTo(Lifecycle.State.CREATED) >= 0) {
            v7.e eVar = m0.f8288a;
            p7.c cVar2 = n.f10348a.f8468l;
            throw null;
        }
        throw new IllegalArgumentException(("target state must be CREATED or greater, found " + state).toString());
    }

    public static final <R> Object withStateAtLeastUnchecked(Lifecycle lifecycle, Lifecycle.State state, d7.a aVar, t6.c cVar) {
        v7.e eVar = m0.f8288a;
        p7.c cVar2 = n.f10348a.f8468l;
        boolean isDispatchNeeded = cVar2.isDispatchNeeded(cVar.getContext());
        if (!isDispatchNeeded) {
            if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                throw new LifecycleDestroyedException();
            }
            if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                return aVar.invoke();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, isDispatchNeeded, cVar2, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(aVar), cVar);
    }

    private static final <R> Object withStateAtLeastUnchecked$$forInline(Lifecycle lifecycle, Lifecycle.State state, d7.a aVar, t6.c cVar) {
        v7.e eVar = m0.f8288a;
        p7.c cVar2 = n.f10348a.f8468l;
        throw null;
    }

    private static final <R> Object withCreated$$forInline(Lifecycle lifecycle, d7.a aVar, t6.c cVar) {
        Lifecycle.State state = Lifecycle.State.DESTROYED;
        v7.e eVar = m0.f8288a;
        p7.c cVar2 = n.f10348a.f8468l;
        throw null;
    }

    private static final <R> Object withResumed$$forInline(Lifecycle lifecycle, d7.a aVar, t6.c cVar) {
        Lifecycle.State state = Lifecycle.State.DESTROYED;
        v7.e eVar = m0.f8288a;
        p7.c cVar2 = n.f10348a.f8468l;
        throw null;
    }

    private static final <R> Object withStarted$$forInline(Lifecycle lifecycle, d7.a aVar, t6.c cVar) {
        Lifecycle.State state = Lifecycle.State.DESTROYED;
        v7.e eVar = m0.f8288a;
        p7.c cVar2 = n.f10348a.f8468l;
        throw null;
    }

    private static final <R> Object withStateAtLeast$$forInline(Lifecycle lifecycle, Lifecycle.State state, d7.a aVar, t6.c cVar) {
        if (state.compareTo(Lifecycle.State.CREATED) >= 0) {
            v7.e eVar = m0.f8288a;
            p7.c cVar2 = n.f10348a.f8468l;
            throw null;
        }
        throw new IllegalArgumentException(("target state must be CREATED or greater, found " + state).toString());
    }

    public static final <R> Object withCreated(Lifecycle lifecycle, d7.a aVar, t6.c cVar) {
        Lifecycle.State state = Lifecycle.State.CREATED;
        v7.e eVar = m0.f8288a;
        p7.c cVar2 = n.f10348a.f8468l;
        boolean isDispatchNeeded = cVar2.isDispatchNeeded(cVar.getContext());
        if (!isDispatchNeeded) {
            if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
                if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                    return aVar.invoke();
                }
            } else {
                throw new LifecycleDestroyedException();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, isDispatchNeeded, cVar2, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(aVar), cVar);
    }

    public static final <R> Object withResumed(Lifecycle lifecycle, d7.a aVar, t6.c cVar) {
        Lifecycle.State state = Lifecycle.State.RESUMED;
        v7.e eVar = m0.f8288a;
        p7.c cVar2 = n.f10348a.f8468l;
        boolean isDispatchNeeded = cVar2.isDispatchNeeded(cVar.getContext());
        if (!isDispatchNeeded) {
            if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
                if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                    return aVar.invoke();
                }
            } else {
                throw new LifecycleDestroyedException();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, isDispatchNeeded, cVar2, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(aVar), cVar);
    }

    public static final <R> Object withStarted(Lifecycle lifecycle, d7.a aVar, t6.c cVar) {
        Lifecycle.State state = Lifecycle.State.STARTED;
        v7.e eVar = m0.f8288a;
        p7.c cVar2 = n.f10348a.f8468l;
        boolean isDispatchNeeded = cVar2.isDispatchNeeded(cVar.getContext());
        if (!isDispatchNeeded) {
            if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
                if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                    return aVar.invoke();
                }
            } else {
                throw new LifecycleDestroyedException();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, isDispatchNeeded, cVar2, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(aVar), cVar);
    }

    public static final <R> Object withStateAtLeast(Lifecycle lifecycle, Lifecycle.State state, d7.a aVar, t6.c cVar) {
        if (state.compareTo(Lifecycle.State.CREATED) >= 0) {
            v7.e eVar = m0.f8288a;
            p7.c cVar2 = n.f10348a.f8468l;
            boolean isDispatchNeeded = cVar2.isDispatchNeeded(cVar.getContext());
            if (!isDispatchNeeded) {
                if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
                    if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                        return aVar.invoke();
                    }
                } else {
                    throw new LifecycleDestroyedException();
                }
            }
            return suspendWithStateAtLeastUnchecked(lifecycle, state, isDispatchNeeded, cVar2, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(aVar), cVar);
        }
        androidx.core.content.pm.a.i(state, "target state must be CREATED or greater, found ");
        return null;
    }
}
