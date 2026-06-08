package androidx.datastore.core;

import d7.l;
import d7.p;
import r7.h;
import t6.c;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public interface InterProcessCoordinator {
    h getUpdateNotifications();

    Object getVersion(c cVar);

    Object incrementAndGetVersion(c cVar);

    <T> Object lock(l lVar, c cVar);

    <T> Object tryLock(p pVar, c cVar);
}
