package androidx.lifecycle.viewmodel.internal;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import d0.b;
import j7.c;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class ViewModelProviderImpl_androidKt {
    public static final <VM extends ViewModel> VM createViewModel(ViewModelProvider.Factory factory, c cVar, CreationExtras creationExtras) {
        factory.getClass();
        cVar.getClass();
        creationExtras.getClass();
        try {
            try {
                return (VM) factory.create(cVar, creationExtras);
            } catch (AbstractMethodError unused) {
                return (VM) factory.create(b.F(cVar));
            }
        } catch (AbstractMethodError unused2) {
            return (VM) factory.create(b.F(cVar), creationExtras);
        }
    }
}
