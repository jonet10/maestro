package androidx.lifecycle.viewmodel.internal;

import a4.x;
import androidx.annotation.MainThread;
import com.google.gson.internal.a;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import o7.a0;
import q6.r;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class ViewModelImpl {
    private final Set<AutoCloseable> closeables;
    private volatile boolean isCleared;
    private final Map<String, AutoCloseable> keyToCloseables;
    private final SynchronizedObject lock;

    public ViewModelImpl(a0 a0Var, AutoCloseable... autoCloseableArr) {
        a0Var.getClass();
        autoCloseableArr.getClass();
        this.lock = new SynchronizedObject();
        this.keyToCloseables = new LinkedHashMap();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        this.closeables = linkedHashSet;
        addCloseable(CloseableCoroutineScopeKt.VIEW_MODEL_SCOPE_KEY, CloseableCoroutineScopeKt.asCloseable(a0Var));
        r.l0(linkedHashSet, autoCloseableArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void closeWithRuntimeException(AutoCloseable autoCloseable) {
        if (autoCloseable != null) {
            try {
                x.z(autoCloseable);
            } catch (Exception e10) {
                a.k(e10);
            }
        }
    }

    public final void addCloseable(String str, AutoCloseable autoCloseable) {
        AutoCloseable autoCloseable2;
        str.getClass();
        autoCloseable.getClass();
        if (this.isCleared) {
            closeWithRuntimeException(autoCloseable);
            return;
        }
        synchronized (this.lock) {
            autoCloseable2 = (AutoCloseable) this.keyToCloseables.put(str, autoCloseable);
        }
        closeWithRuntimeException(autoCloseable2);
    }

    @MainThread
    public final void clear() {
        if (this.isCleared) {
            return;
        }
        this.isCleared = true;
        synchronized (this.lock) {
            try {
                Iterator it = this.keyToCloseables.values().iterator();
                while (it.hasNext()) {
                    closeWithRuntimeException((AutoCloseable) it.next());
                }
                Iterator it2 = this.closeables.iterator();
                while (it2.hasNext()) {
                    closeWithRuntimeException((AutoCloseable) it2.next());
                }
                this.closeables.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final <T extends AutoCloseable> T getCloseable(String str) {
        T t9;
        str.getClass();
        synchronized (this.lock) {
            t9 = (T) this.keyToCloseables.get(str);
        }
        return t9;
    }

    public final void addCloseable(AutoCloseable autoCloseable) {
        autoCloseable.getClass();
        if (this.isCleared) {
            closeWithRuntimeException(autoCloseable);
            return;
        }
        synchronized (this.lock) {
            this.closeables.add(autoCloseable);
        }
    }

    public ViewModelImpl(a0 a0Var) {
        a0Var.getClass();
        this.lock = new SynchronizedObject();
        this.keyToCloseables = new LinkedHashMap();
        this.closeables = new LinkedHashSet();
        addCloseable(CloseableCoroutineScopeKt.VIEW_MODEL_SCOPE_KEY, CloseableCoroutineScopeKt.asCloseable(a0Var));
    }

    public ViewModelImpl(AutoCloseable... autoCloseableArr) {
        autoCloseableArr.getClass();
        this.lock = new SynchronizedObject();
        this.keyToCloseables = new LinkedHashMap();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        this.closeables = linkedHashSet;
        r.l0(linkedHashSet, autoCloseableArr);
    }

    public ViewModelImpl() {
        this.lock = new SynchronizedObject();
        this.keyToCloseables = new LinkedHashMap();
        this.closeables = new LinkedHashSet();
    }
}
