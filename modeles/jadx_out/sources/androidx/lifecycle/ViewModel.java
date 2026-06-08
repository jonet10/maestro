package androidx.lifecycle;

import androidx.annotation.MainThread;
import androidx.lifecycle.viewmodel.internal.ViewModelImpl;
import java.io.Closeable;
import java.util.Arrays;
import o7.a0;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public abstract class ViewModel {
    private final ViewModelImpl impl;

    public ViewModel(a0 a0Var, AutoCloseable... autoCloseableArr) {
        a0Var.getClass();
        autoCloseableArr.getClass();
        this.impl = new ViewModelImpl(a0Var, (AutoCloseable[]) Arrays.copyOf(autoCloseableArr, autoCloseableArr.length));
    }

    public final void addCloseable(String str, AutoCloseable autoCloseable) {
        str.getClass();
        autoCloseable.getClass();
        ViewModelImpl viewModelImpl = this.impl;
        if (viewModelImpl != null) {
            viewModelImpl.addCloseable(str, autoCloseable);
        }
    }

    @MainThread
    public final void clear$lifecycle_viewmodel() {
        ViewModelImpl viewModelImpl = this.impl;
        if (viewModelImpl != null) {
            viewModelImpl.clear();
        }
        onCleared();
    }

    public final <T extends AutoCloseable> T getCloseable(String str) {
        str.getClass();
        ViewModelImpl viewModelImpl = this.impl;
        if (viewModelImpl != null) {
            return (T) viewModelImpl.getCloseable(str);
        }
        return null;
    }

    public void addCloseable(AutoCloseable autoCloseable) {
        autoCloseable.getClass();
        ViewModelImpl viewModelImpl = this.impl;
        if (viewModelImpl != null) {
            viewModelImpl.addCloseable(autoCloseable);
        }
    }

    public /* synthetic */ void addCloseable(Closeable closeable) {
        closeable.getClass();
        ViewModelImpl viewModelImpl = this.impl;
        if (viewModelImpl != null) {
            viewModelImpl.addCloseable(closeable);
        }
    }

    public void onCleared() {
    }

    public ViewModel(a0 a0Var) {
        a0Var.getClass();
        this.impl = new ViewModelImpl(a0Var);
    }

    public ViewModel(AutoCloseable... autoCloseableArr) {
        autoCloseableArr.getClass();
        this.impl = new ViewModelImpl((AutoCloseable[]) Arrays.copyOf(autoCloseableArr, autoCloseableArr.length));
    }

    public ViewModel() {
        this.impl = new ViewModelImpl();
    }

    public /* synthetic */ ViewModel(Closeable... closeableArr) {
        closeableArr.getClass();
        this.impl = new ViewModelImpl((AutoCloseable[]) Arrays.copyOf(closeableArr, closeableArr.length));
    }
}
