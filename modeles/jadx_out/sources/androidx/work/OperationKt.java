package androidx.work;

import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.lifecycle.MutableLiveData;
import androidx.work.Operation;
import java.util.concurrent.Executor;
import p6.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class OperationKt {
    /* JADX WARN: Removed duplicated region for block: B:15:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object await(androidx.work.Operation r4, t6.c r5) {
        /*
            boolean r0 = r5 instanceof androidx.work.OperationKt$await$1
            if (r0 == 0) goto L13
            r0 = r5
            androidx.work.OperationKt$await$1 r0 = (androidx.work.OperationKt$await$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.work.OperationKt$await$1 r0 = new androidx.work.OperationKt$await$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            int r1 = r0.label
            r2 = 1
            if (r1 == 0) goto L2c
            if (r1 != r2) goto L25
            p6.a.e(r5)
            goto L41
        L25:
            java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r4)
            r4 = 0
            return r4
        L2c:
            p6.a.e(r5)
            m1.b r4 = r4.getResult()
            r4.getClass()
            r0.label = r2
            java.lang.Object r5 = androidx.concurrent.futures.ListenableFutureKt.await(r4, r0)
            u6.a r4 = u6.a.f10762a
            if (r5 != r4) goto L41
            return r4
        L41:
            r5.getClass()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.OperationKt.await(androidx.work.Operation, t6.c):java.lang.Object");
    }

    private static final Object await$$forInline(Operation operation, t6.c cVar) {
        m1.b result = operation.getResult();
        result.getClass();
        Object await = androidx.concurrent.futures.ListenableFutureKt.await(result, cVar);
        await.getClass();
        return await;
    }

    public static final Operation launchOperation(final Tracer tracer, final String str, final Executor executor, final d7.a aVar) {
        tracer.getClass();
        str.getClass();
        executor.getClass();
        aVar.getClass();
        final MutableLiveData mutableLiveData = new MutableLiveData(Operation.IN_PROGRESS);
        m1.b future = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.work.c
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                x launchOperation$lambda$2;
                launchOperation$lambda$2 = OperationKt.launchOperation$lambda$2(executor, tracer, str, aVar, mutableLiveData, completer);
                return launchOperation$lambda$2;
            }
        });
        future.getClass();
        return new OperationImpl(mutableLiveData, future);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final x launchOperation$lambda$2(Executor executor, final Tracer tracer, final String str, final d7.a aVar, final MutableLiveData mutableLiveData, final CallbackToFutureAdapter.Completer completer) {
        completer.getClass();
        executor.execute(new Runnable() { // from class: androidx.work.d
            @Override // java.lang.Runnable
            public final void run() {
                OperationKt.launchOperation$lambda$2$lambda$1(Tracer.this, str, aVar, mutableLiveData, completer);
            }
        });
        return x.f8463a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void launchOperation$lambda$2$lambda$1(Tracer tracer, String str, d7.a aVar, MutableLiveData mutableLiveData, CallbackToFutureAdapter.Completer completer) {
        boolean isEnabled = tracer.isEnabled();
        if (isEnabled) {
            try {
                tracer.beginSection(str);
            } finally {
                if (isEnabled) {
                    tracer.endSection();
                }
            }
        }
        try {
            aVar.invoke();
            Operation.State.SUCCESS success = Operation.SUCCESS;
            mutableLiveData.postValue(success);
            completer.set(success);
        } catch (Throwable th) {
            mutableLiveData.postValue(new Operation.State.FAILURE(th));
            completer.setException(th);
        }
    }
}
