package j$.time.zone;

import j$.util.Objects;
import j$.util.concurrent.ConcurrentHashMap;
import java.security.AccessController;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class i {

    /* renamed from: b, reason: collision with root package name */
    public static final CopyOnWriteArrayList f5956b;

    /* renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap f5957c;

    /* renamed from: a, reason: collision with root package name */
    public final Set f5958a;

    static {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        f5956b = copyOnWriteArrayList;
        f5957c = new ConcurrentHashMap(512, 0.75f, 2);
        ArrayList arrayList = new ArrayList();
        AccessController.doPrivileged(new h(arrayList));
        copyOnWriteArrayList.addAll(arrayList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static f a(String str) {
        Objects.requireNonNull(str, "zoneId");
        ConcurrentHashMap concurrentHashMap = f5957c;
        i iVar = (i) concurrentHashMap.get(str);
        if (iVar == null) {
            if (concurrentHashMap.isEmpty()) {
                throw new g("No time-zone data files registered");
            }
            throw new g("Unknown time-zone ID: " + str);
        }
        if (iVar.f5958a.contains(str)) {
            return new f(TimeZone.getTimeZone(str));
        }
        throw new g("Not a built-in time zone: " + str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void b(i iVar) {
        Objects.requireNonNull(iVar, "provider");
        synchronized (i.class) {
            try {
                for (String str : iVar.f5958a) {
                    Objects.requireNonNull(str, "zoneId");
                    if (((i) f5957c.putIfAbsent(str, iVar)) != null) {
                        throw new g("Unable to register zone as one already registered with that ID: " + str + ", currently loading from provider: " + iVar);
                    }
                }
                Collections.unmodifiableSet(new HashSet(f5957c.keySet()));
            } catch (Throwable th) {
                throw th;
            }
        }
        f5956b.add(iVar);
    }

    public i() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (String str : TimeZone.getAvailableIDs()) {
            linkedHashSet.add(str);
        }
        this.f5958a = Collections.unmodifiableSet(linkedHashSet);
    }
}
