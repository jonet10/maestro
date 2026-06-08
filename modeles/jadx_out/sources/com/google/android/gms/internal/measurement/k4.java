package com.google.android.gms.internal.measurement;

import androidx.core.app.NotificationCompat;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class k4 extends h {

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ int f2684l = 0;

    /* renamed from: m, reason: collision with root package name */
    public final Object f2685m;

    public k4(f0.i iVar) {
        super("internal.logger");
        this.f2685m = iVar;
        this.f2651b.put("log", new z8(this, false, true));
        this.f2651b.put(NotificationCompat.GROUP_KEY_SILENT, new x5(NotificationCompat.GROUP_KEY_SILENT, 1));
        ((h) this.f2651b.get(NotificationCompat.GROUP_KEY_SILENT)).d("log", new z8(this, true, true));
        this.f2651b.put("unmonitored", new x5("unmonitored", 2));
        ((h) this.f2651b.get("unmonitored")).d("log", new z8(this, false, false));
    }

    @Override // com.google.android.gms.internal.measurement.h
    public final n a(y2.s sVar, List list) {
        TreeMap treeMap;
        switch (this.f2684l) {
            case 0:
                b2.t1.S(this.f2650a, 3, list);
                String f = ((t) sVar.f11756l).c(sVar, (n) list.get(0)).f();
                n nVar = (n) list.get(1);
                t tVar = (t) sVar.f11756l;
                long c02 = (long) b2.t1.c0(tVar.c(sVar, nVar).g().doubleValue());
                n c9 = tVar.c(sVar, (n) list.get(2));
                HashMap e02 = c9 instanceof k ? b2.t1.e0((k) c9) : new HashMap();
                b5.m mVar = (b5.m) this.f2685m;
                mVar.getClass();
                HashMap hashMap = new HashMap();
                for (String str : e02.keySet()) {
                    HashMap hashMap2 = ((b) mVar.f1061b).f2510c;
                    hashMap.put(str, b.b(hashMap2.containsKey(str) ? hashMap2.get(str) : null, str, e02.get(str)));
                }
                ((ArrayList) mVar.f1063m).add(new b(f, c02, hashMap));
                break;
            case 1:
                b2.t1.S("getValue", 2, list);
                n c10 = ((t) sVar.f11756l).c(sVar, (n) list.get(0));
                n c11 = ((t) sVar.f11756l).c(sVar, (n) list.get(1));
                String f10 = c10.f();
                android.support.v4.media.g gVar = (android.support.v4.media.g) this.f2685m;
                Map map = (Map) ((e1.m1) gVar.f248l).f4105m.get((String) gVar.f247b);
                String str2 = (map == null || !map.containsKey(f10)) ? null : (String) map.get(f10);
                if (str2 != null) {
                    break;
                }
                break;
            case 2:
                break;
            case 3:
                try {
                    break;
                } catch (Exception unused) {
                    return n.f2717c;
                }
            default:
                b2.t1.S(this.f2650a, 3, list);
                ((t) sVar.f11756l).c(sVar, (n) list.get(0)).f();
                n nVar2 = (n) list.get(1);
                t tVar2 = (t) sVar.f11756l;
                n c12 = tVar2.c(sVar, nVar2);
                if (c12 instanceof m) {
                    n c13 = tVar2.c(sVar, (n) list.get(2));
                    if (c13 instanceof k) {
                        k kVar = (k) c13;
                        HashMap hashMap3 = kVar.f2678a;
                        if (hashMap3.containsKey(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY)) {
                            String f11 = kVar.c(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY).f();
                            int b02 = hashMap3.containsKey("priority") ? b2.t1.b0(kVar.c("priority").g().doubleValue()) : 1000;
                            t tVar3 = (t) this.f2685m;
                            m mVar2 = (m) c12;
                            tVar3.getClass();
                            if ("create".equals(f11)) {
                                treeMap = (TreeMap) tVar3.f2806b;
                            } else if (!"edit".equals(f11)) {
                                androidx.privacysandbox.ads.adservices.customaudience.a.i("Unknown callback type: ".concat(String.valueOf(f11)));
                                break;
                            } else {
                                treeMap = (TreeMap) tVar3.f2805a;
                            }
                            if (treeMap.containsKey(Integer.valueOf(b02))) {
                                b02 = ((Integer) treeMap.lastKey()).intValue() + 1;
                            }
                            treeMap.put(Integer.valueOf(b02), mVar2);
                            break;
                        } else {
                            com.google.gson.internal.a.p("Undefined rule type");
                            break;
                        }
                    } else {
                        com.google.gson.internal.a.p("Invalid callback params");
                        break;
                    }
                } else {
                    com.google.gson.internal.a.p("Invalid callback type");
                    break;
                }
        }
        return n.f2717c;
    }

    public k4(t tVar) {
        super("internal.registerCallback");
        this.f2685m = tVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k4(x5 x5Var, android.support.v4.media.g gVar) {
        super("getValue");
        this.f2685m = gVar;
    }

    public k4(e1.k1 k1Var) {
        super("internal.appMetadata");
        this.f2685m = k1Var;
    }

    public k4(b5.m mVar) {
        super("internal.eventLogger");
        this.f2685m = mVar;
    }
}
