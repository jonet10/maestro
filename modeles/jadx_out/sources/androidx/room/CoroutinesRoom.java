package androidx.room;

import android.os.CancellationSignal;
import androidx.annotation.RestrictTo;
import androidx.room.coroutines.FlowUtil;
import androidx.sqlite.SQLiteConnection;
import java.util.concurrent.Callable;
import r7.h;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class CoroutinesRoom {
    public static final Companion Companion = new Companion(null);

    private CoroutinesRoom() {
    }

    public static final <R> h createFlow(RoomDatabase roomDatabase, boolean z9, String[] strArr, Callable<R> callable) {
        return Companion.createFlow(roomDatabase, z9, strArr, callable);
    }

    public static final <R> Object execute(RoomDatabase roomDatabase, boolean z9, CancellationSignal cancellationSignal, Callable<R> callable, t6.c cVar) {
        return Companion.execute(roomDatabase, z9, cancellationSignal, callable, cVar);
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.g gVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Object createFlow$lambda$1(Callable callable, SQLiteConnection sQLiteConnection) {
            sQLiteConnection.getClass();
            return callable.call();
        }

        public final <R> h createFlow(RoomDatabase roomDatabase, boolean z9, String[] strArr, Callable<R> callable) {
            roomDatabase.getClass();
            strArr.getClass();
            callable.getClass();
            return FlowUtil.createFlow(roomDatabase, z9, strArr, new b(callable, 1));
        }

        /* JADX WARN: Code restructure failed: missing block: B:27:0x0073, code lost:
        
            if (r10 == r4) goto L28;
         */
        /* JADX WARN: Removed duplicated region for block: B:18:0x00aa A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:19:0x00ab A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0053  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final <R> java.lang.Object execute(androidx.room.RoomDatabase r6, boolean r7, final android.os.CancellationSignal r8, java.util.concurrent.Callable<R> r9, t6.c r10) {
            /*
                r5 = this;
                boolean r0 = r10 instanceof androidx.room.CoroutinesRoom$Companion$execute$3
                if (r0 == 0) goto L13
                r0 = r10
                androidx.room.CoroutinesRoom$Companion$execute$3 r0 = (androidx.room.CoroutinesRoom$Companion$execute$3) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                androidx.room.CoroutinesRoom$Companion$execute$3 r0 = new androidx.room.CoroutinesRoom$Companion$execute$3
                r0.<init>(r5, r10)
            L18:
                java.lang.Object r10 = r0.result
                int r1 = r0.label
                r2 = 2
                r3 = 1
                u6.a r4 = u6.a.f10762a
                if (r1 == 0) goto L53
                if (r1 == r3) goto L41
                if (r1 != r2) goto L3a
                java.lang.Object r6 = r0.L$3
                t6.h r6 = (t6.h) r6
                java.lang.Object r6 = r0.L$2
                java.util.concurrent.Callable r6 = (java.util.concurrent.Callable) r6
                java.lang.Object r6 = r0.L$1
                android.os.CancellationSignal r6 = (android.os.CancellationSignal) r6
                java.lang.Object r6 = r0.L$0
                androidx.room.RoomDatabase r6 = (androidx.room.RoomDatabase) r6
                p6.a.e(r10)
                return r10
            L3a:
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                androidx.privacysandbox.ads.adservices.customaudience.a.i(r6)
                r6 = 0
                return r6
            L41:
                java.lang.Object r6 = r0.L$2
                r9 = r6
                java.util.concurrent.Callable r9 = (java.util.concurrent.Callable) r9
                java.lang.Object r6 = r0.L$1
                r8 = r6
                android.os.CancellationSignal r8 = (android.os.CancellationSignal) r8
                java.lang.Object r6 = r0.L$0
                androidx.room.RoomDatabase r6 = (androidx.room.RoomDatabase) r6
                p6.a.e(r10)
                goto L76
            L53:
                p6.a.e(r10)
                boolean r10 = r6.isOpenInternal()
                if (r10 == 0) goto L67
                boolean r10 = r6.inTransaction()
                if (r10 == 0) goto L67
                java.lang.Object r6 = r9.call()
                return r6
            L67:
                r0.L$0 = r6
                r0.L$1 = r8
                r0.L$2 = r9
                r0.label = r3
                java.lang.Object r10 = androidx.room.util.DBUtil.getCoroutineContext(r6, r7, r0)
                if (r10 != r4) goto L76
                goto Laa
            L76:
                t6.h r10 = (t6.h) r10
                r0.L$0 = r6
                r0.L$1 = r8
                r0.L$2 = r9
                r0.L$3 = r10
                r0.label = r2
                o7.l r7 = new o7.l
                t6.c r0 = d0.b.I(r0)
                r7.<init>(r3, r0)
                r7.s()
                o7.a0 r6 = r6.getCoroutineScope()
                androidx.room.CoroutinesRoom$Companion$execute$4$job$1 r0 = new androidx.room.CoroutinesRoom$Companion$execute$4$job$1
                r1 = 0
                r0.<init>(r9, r7, r1)
                o7.s1 r6 = o7.c0.s(r6, r10, r1, r0, r2)
                androidx.room.CoroutinesRoom$Companion$execute$4$1 r9 = new androidx.room.CoroutinesRoom$Companion$execute$4$1
                r9.<init>()
                r7.u(r9)
                java.lang.Object r6 = r7.r()
                if (r6 != r4) goto Lab
            Laa:
                return r4
            Lab:
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.room.CoroutinesRoom.Companion.execute(androidx.room.RoomDatabase, boolean, android.os.CancellationSignal, java.util.concurrent.Callable, t6.c):java.lang.Object");
        }

        private Companion() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:27:0x0056, code lost:
        
            if (r9 == r4) goto L28;
         */
        /* JADX WARN: Removed duplicated region for block: B:18:0x006b A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:19:0x006c A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:20:0x003a  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final <R> java.lang.Object execute(androidx.room.RoomDatabase r6, boolean r7, java.util.concurrent.Callable<R> r8, t6.c r9) {
            /*
                r5 = this;
                boolean r0 = r9 instanceof androidx.room.CoroutinesRoom$Companion$execute$1
                if (r0 == 0) goto L13
                r0 = r9
                androidx.room.CoroutinesRoom$Companion$execute$1 r0 = (androidx.room.CoroutinesRoom$Companion$execute$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                androidx.room.CoroutinesRoom$Companion$execute$1 r0 = new androidx.room.CoroutinesRoom$Companion$execute$1
                r0.<init>(r5, r9)
            L18:
                java.lang.Object r9 = r0.result
                int r1 = r0.label
                r2 = 2
                r3 = 1
                u6.a r4 = u6.a.f10762a
                if (r1 == 0) goto L3a
                if (r1 == r3) goto L31
                if (r1 != r2) goto L2a
                p6.a.e(r9)
                return r9
            L2a:
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                androidx.privacysandbox.ads.adservices.customaudience.a.i(r6)
                r6 = 0
                return r6
            L31:
                java.lang.Object r6 = r0.L$0
                r8 = r6
                java.util.concurrent.Callable r8 = (java.util.concurrent.Callable) r8
                p6.a.e(r9)
                goto L59
            L3a:
                p6.a.e(r9)
                boolean r9 = r6.isOpenInternal()
                if (r9 == 0) goto L4e
                boolean r9 = r6.inTransaction()
                if (r9 == 0) goto L4e
                java.lang.Object r6 = r8.call()
                return r6
            L4e:
                r0.L$0 = r8
                r0.label = r3
                java.lang.Object r9 = androidx.room.util.DBUtil.getCoroutineContext(r6, r7, r0)
                if (r9 != r4) goto L59
                goto L6b
            L59:
                t6.h r9 = (t6.h) r9
                androidx.room.CoroutinesRoom$Companion$execute$2 r6 = new androidx.room.CoroutinesRoom$Companion$execute$2
                r7 = 0
                r6.<init>(r8, r7)
                r0.L$0 = r7
                r0.label = r2
                java.lang.Object r6 = o7.c0.C(r6, r9, r0)
                if (r6 != r4) goto L6c
            L6b:
                return r4
            L6c:
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.room.CoroutinesRoom.Companion.execute(androidx.room.RoomDatabase, boolean, java.util.concurrent.Callable, t6.c):java.lang.Object");
        }
    }

    public static final <R> Object execute(RoomDatabase roomDatabase, boolean z9, Callable<R> callable, t6.c cVar) {
        return Companion.execute(roomDatabase, z9, callable, cVar);
    }
}
