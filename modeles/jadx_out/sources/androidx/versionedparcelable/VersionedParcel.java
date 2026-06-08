package androidx.versionedparcelable;

import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.NetworkOnMainThreadException;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseBooleanArray;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.collection.ArrayMap;
import androidx.collection.ArraySet;
import androidx.lifecycle.l;
import com.google.gson.internal.a;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public abstract class VersionedParcel {
    private static final int EX_BAD_PARCELABLE = -2;
    private static final int EX_ILLEGAL_ARGUMENT = -3;
    private static final int EX_ILLEGAL_STATE = -5;
    private static final int EX_NETWORK_MAIN_THREAD = -6;
    private static final int EX_NULL_POINTER = -4;
    private static final int EX_PARCELABLE = -9;
    private static final int EX_SECURITY = -1;
    private static final int EX_UNSUPPORTED_OPERATION = -7;
    private static final String TAG = "VersionedParcel";
    private static final int TYPE_BINDER = 5;
    private static final int TYPE_FLOAT = 8;
    private static final int TYPE_INTEGER = 7;
    private static final int TYPE_PARCELABLE = 2;
    private static final int TYPE_SERIALIZABLE = 3;
    private static final int TYPE_STRING = 4;
    private static final int TYPE_VERSIONED_PARCELABLE = 1;
    protected final ArrayMap<String, Class> mParcelizerCache;
    protected final ArrayMap<String, Method> mReadCache;
    protected final ArrayMap<String, Method> mWriteCache;

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static class ParcelException extends RuntimeException {
        public ParcelException(Throwable th) {
            super(th);
        }
    }

    public VersionedParcel(ArrayMap<String, Method> arrayMap, ArrayMap<String, Method> arrayMap2, ArrayMap<String, Class> arrayMap3) {
        this.mReadCache = arrayMap;
        this.mWriteCache = arrayMap2;
        this.mParcelizerCache = arrayMap3;
    }

    private Exception createException(int i, String str) {
        switch (i) {
            case EX_PARCELABLE /* -9 */:
                return (Exception) readParcelable();
            case -8:
            default:
                return new RuntimeException("Unknown exception code: " + i + " msg " + str);
            case EX_UNSUPPORTED_OPERATION /* -7 */:
                return new UnsupportedOperationException(str);
            case EX_NETWORK_MAIN_THREAD /* -6 */:
                return new NetworkOnMainThreadException();
            case EX_ILLEGAL_STATE /* -5 */:
                return new IllegalStateException(str);
            case -4:
                return new NullPointerException(str);
            case -3:
                return new IllegalArgumentException(str);
            case -2:
                return new BadParcelableException(str);
            case -1:
                return new SecurityException(str);
        }
    }

    private Class findParcelClass(Class<? extends VersionedParcelable> cls) throws ClassNotFoundException {
        Class cls2 = this.mParcelizerCache.get(cls.getName());
        if (cls2 != null) {
            return cls2;
        }
        Class<?> cls3 = Class.forName(cls.getPackage().getName() + "." + cls.getSimpleName() + "Parcelizer", false, cls.getClassLoader());
        this.mParcelizerCache.put(cls.getName(), cls3);
        return cls3;
    }

    private Method getReadMethod(String str) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException {
        Method method = this.mReadCache.get(str);
        if (method != null) {
            return method;
        }
        System.currentTimeMillis();
        Method declaredMethod = Class.forName(str, true, VersionedParcel.class.getClassLoader()).getDeclaredMethod("read", VersionedParcel.class);
        this.mReadCache.put(str, declaredMethod);
        return declaredMethod;
    }

    @NonNull
    public static Throwable getRootCause(@NonNull Throwable th) {
        while (th.getCause() != null) {
            th = th.getCause();
        }
        return th;
    }

    private <T> int getType(T t9) {
        if (t9 instanceof String) {
            return 4;
        }
        if (t9 instanceof Parcelable) {
            return 2;
        }
        if (t9 instanceof VersionedParcelable) {
            return 1;
        }
        if (t9 instanceof Serializable) {
            return 3;
        }
        if (t9 instanceof IBinder) {
            return 5;
        }
        if (t9 instanceof Integer) {
            return 7;
        }
        if (t9 instanceof Float) {
            return 8;
        }
        a.p(t9.getClass().getName().concat(" cannot be VersionedParcelled"));
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Method getWriteMethod(Class cls) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException {
        Method method = this.mWriteCache.get(cls.getName());
        if (method != null) {
            return method;
        }
        Class findParcelClass = findParcelClass(cls);
        System.currentTimeMillis();
        Method declaredMethod = findParcelClass.getDeclaredMethod("write", cls, VersionedParcel.class);
        this.mWriteCache.put(cls.getName(), declaredMethod);
        return declaredMethod;
    }

    private <T, S extends Collection<T>> S readCollection(S s6) {
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        if (readInt != 0) {
            int readInt2 = readInt();
            if (readInt < 0) {
                return null;
            }
            if (readInt2 == 1) {
                while (readInt > 0) {
                    s6.add(readVersionedParcelable());
                    readInt--;
                }
            } else if (readInt2 == 2) {
                while (readInt > 0) {
                    s6.add(readParcelable());
                    readInt--;
                }
            } else if (readInt2 == 3) {
                while (readInt > 0) {
                    s6.add(readSerializable());
                    readInt--;
                }
            } else if (readInt2 == 4) {
                while (readInt > 0) {
                    s6.add(readString());
                    readInt--;
                }
            } else if (readInt2 == 5) {
                while (readInt > 0) {
                    s6.add(readStrongBinder());
                    readInt--;
                }
            }
        }
        return s6;
    }

    private int readExceptionCode() {
        return readInt();
    }

    private <T> void writeCollection(Collection<T> collection) {
        if (collection == null) {
            writeInt(-1);
        }
        int size = collection.size();
        writeInt(size);
        if (size > 0) {
            int type = getType(collection.iterator().next());
            writeInt(type);
            switch (type) {
                case 1:
                    Iterator<T> it = collection.iterator();
                    while (it.hasNext()) {
                        writeVersionedParcelable((VersionedParcelable) it.next());
                    }
                    break;
                case 2:
                    Iterator<T> it2 = collection.iterator();
                    while (it2.hasNext()) {
                        writeParcelable((Parcelable) it2.next());
                    }
                    break;
                case 3:
                    Iterator<T> it3 = collection.iterator();
                    while (it3.hasNext()) {
                        writeSerializable((Serializable) it3.next());
                    }
                    break;
                case 4:
                    Iterator<T> it4 = collection.iterator();
                    while (it4.hasNext()) {
                        writeString((String) it4.next());
                    }
                    break;
                case 5:
                    Iterator<T> it5 = collection.iterator();
                    while (it5.hasNext()) {
                        writeStrongBinder((IBinder) it5.next());
                    }
                    break;
                case 7:
                    Iterator<T> it6 = collection.iterator();
                    while (it6.hasNext()) {
                        writeInt(((Integer) it6.next()).intValue());
                    }
                    break;
                case 8:
                    Iterator<T> it7 = collection.iterator();
                    while (it7.hasNext()) {
                        writeFloat(((Float) it7.next()).floatValue());
                    }
                    break;
            }
        }
    }

    private void writeSerializable(Serializable serializable) {
        if (serializable == null) {
            writeString(null);
            return;
        }
        String name = serializable.getClass().getName();
        writeString(name);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(serializable);
            objectOutputStream.close();
            writeByteArray(byteArrayOutputStream.toByteArray());
        } catch (IOException e10) {
            androidx.privacysandbox.ads.adservices.customaudience.a.m(l.w("VersionedParcelable encountered IOException writing serializable object (name = ", name, ")"), e10);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void writeVersionedParcelableCreator(VersionedParcelable versionedParcelable) {
        try {
            writeString(findParcelClass(versionedParcelable.getClass()).getName());
        } catch (ClassNotFoundException e10) {
            androidx.privacysandbox.ads.adservices.customaudience.a.m(versionedParcelable.getClass().getSimpleName().concat(" does not have a Parcelizer"), e10);
        }
    }

    public abstract void closeField();

    public abstract VersionedParcel createSubParcel();

    public boolean isStream() {
        return false;
    }

    public <T> T[] readArray(T[] tArr) {
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(readInt);
        if (readInt != 0) {
            int readInt2 = readInt();
            if (readInt < 0) {
                return null;
            }
            if (readInt2 == 1) {
                while (readInt > 0) {
                    arrayList.add(readVersionedParcelable());
                    readInt--;
                }
            } else if (readInt2 == 2) {
                while (readInt > 0) {
                    arrayList.add(readParcelable());
                    readInt--;
                }
            } else if (readInt2 == 3) {
                while (readInt > 0) {
                    arrayList.add(readSerializable());
                    readInt--;
                }
            } else if (readInt2 == 4) {
                while (readInt > 0) {
                    arrayList.add(readString());
                    readInt--;
                }
            } else if (readInt2 == 5) {
                while (readInt > 0) {
                    arrayList.add(readStrongBinder());
                    readInt--;
                }
            }
        }
        return (T[]) arrayList.toArray(tArr);
    }

    public abstract boolean readBoolean();

    public boolean readBoolean(boolean z9, int i) {
        return !readField(i) ? z9 : readBoolean();
    }

    public boolean[] readBooleanArray() {
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        boolean[] zArr = new boolean[readInt];
        for (int i = 0; i < readInt; i++) {
            zArr[i] = readInt() != 0;
        }
        return zArr;
    }

    public abstract Bundle readBundle();

    public Bundle readBundle(Bundle bundle, int i) {
        return !readField(i) ? bundle : readBundle();
    }

    public byte readByte(byte b7, int i) {
        return !readField(i) ? b7 : (byte) (readInt() & 255);
    }

    public abstract byte[] readByteArray();

    public byte[] readByteArray(byte[] bArr, int i) {
        return !readField(i) ? bArr : readByteArray();
    }

    public char[] readCharArray(char[] cArr, int i) {
        if (!readField(i)) {
            return cArr;
        }
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        char[] cArr2 = new char[readInt];
        for (int i6 = 0; i6 < readInt; i6++) {
            cArr2[i6] = (char) readInt();
        }
        return cArr2;
    }

    public abstract CharSequence readCharSequence();

    public CharSequence readCharSequence(CharSequence charSequence, int i) {
        return !readField(i) ? charSequence : readCharSequence();
    }

    public abstract double readDouble();

    public double readDouble(double d10, int i) {
        return !readField(i) ? d10 : readDouble();
    }

    public double[] readDoubleArray() {
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        double[] dArr = new double[readInt];
        for (int i = 0; i < readInt; i++) {
            dArr[i] = readDouble();
        }
        return dArr;
    }

    public Exception readException(Exception exc, int i) {
        int readExceptionCode;
        return (readField(i) && (readExceptionCode = readExceptionCode()) != 0) ? readException(readExceptionCode, readString()) : exc;
    }

    public abstract boolean readField(int i);

    public abstract float readFloat();

    public float readFloat(float f, int i) {
        return !readField(i) ? f : readFloat();
    }

    public float[] readFloatArray() {
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        float[] fArr = new float[readInt];
        for (int i = 0; i < readInt; i++) {
            fArr[i] = readFloat();
        }
        return fArr;
    }

    public <T extends VersionedParcelable> T readFromParcel(String str, VersionedParcel versionedParcel) {
        try {
            return (T) getReadMethod(str).invoke(null, versionedParcel);
        } catch (ClassNotFoundException e10) {
            androidx.privacysandbox.ads.adservices.customaudience.a.m("VersionedParcel encountered ClassNotFoundException", e10);
            return null;
        } catch (IllegalAccessException e11) {
            androidx.privacysandbox.ads.adservices.customaudience.a.m("VersionedParcel encountered IllegalAccessException", e11);
            return null;
        } catch (NoSuchMethodException e12) {
            androidx.privacysandbox.ads.adservices.customaudience.a.m("VersionedParcel encountered NoSuchMethodException", e12);
            return null;
        } catch (InvocationTargetException e13) {
            if (e13.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e13.getCause());
            }
            androidx.privacysandbox.ads.adservices.customaudience.a.m("VersionedParcel encountered InvocationTargetException", e13);
            return null;
        }
    }

    public abstract int readInt();

    public int readInt(int i, int i6) {
        return !readField(i6) ? i : readInt();
    }

    public int[] readIntArray() {
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        int[] iArr = new int[readInt];
        for (int i = 0; i < readInt; i++) {
            iArr[i] = readInt();
        }
        return iArr;
    }

    public <T> List<T> readList(List<T> list, int i) {
        return !readField(i) ? list : (List) readCollection(new ArrayList());
    }

    public abstract long readLong();

    public long readLong(long j, int i) {
        return !readField(i) ? j : readLong();
    }

    public long[] readLongArray() {
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        long[] jArr = new long[readInt];
        for (int i = 0; i < readInt; i++) {
            jArr[i] = readLong();
        }
        return jArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <K, V> Map<K, V> readMap(Map<K, V> map, int i) {
        if (!readField(i)) {
            return map;
        }
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        ArrayMap arrayMap = new ArrayMap();
        if (readInt != 0) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            readCollection(arrayList);
            readCollection(arrayList2);
            for (int i6 = 0; i6 < readInt; i6++) {
                arrayMap.put(arrayList.get(i6), arrayList2.get(i6));
            }
        }
        return arrayMap;
    }

    public abstract <T extends Parcelable> T readParcelable();

    public <T extends Parcelable> T readParcelable(T t9, int i) {
        return !readField(i) ? t9 : (T) readParcelable();
    }

    public Serializable readSerializable() {
        String readString = readString();
        if (readString == null) {
            return null;
        }
        try {
            return (Serializable) new ObjectInputStream(new ByteArrayInputStream(readByteArray())) { // from class: androidx.versionedparcelable.VersionedParcel.1
                @Override // java.io.ObjectInputStream
                public Class<?> resolveClass(ObjectStreamClass objectStreamClass) throws IOException, ClassNotFoundException {
                    Class<?> cls = Class.forName(objectStreamClass.getName(), false, getClass().getClassLoader());
                    return cls != null ? cls : super.resolveClass(objectStreamClass);
                }
            }.readObject();
        } catch (IOException e10) {
            androidx.privacysandbox.ads.adservices.customaudience.a.m(l.w("VersionedParcelable encountered IOException reading a Serializable object (name = ", readString, ")"), e10);
            return null;
        } catch (ClassNotFoundException e11) {
            androidx.privacysandbox.ads.adservices.customaudience.a.m(l.w("VersionedParcelable encountered ClassNotFoundException reading a Serializable object (name = ", readString, ")"), e11);
            return null;
        }
    }

    public <T> Set<T> readSet(Set<T> set, int i) {
        return !readField(i) ? set : (Set) readCollection(new ArraySet());
    }

    @RequiresApi(api = 21)
    public Size readSize(Size size, int i) {
        if (!readField(i)) {
            return size;
        }
        if (readBoolean()) {
            return new Size(readInt(), readInt());
        }
        return null;
    }

    @RequiresApi(api = 21)
    public SizeF readSizeF(SizeF sizeF, int i) {
        if (!readField(i)) {
            return sizeF;
        }
        if (readBoolean()) {
            return new SizeF(readFloat(), readFloat());
        }
        return null;
    }

    public SparseBooleanArray readSparseBooleanArray(SparseBooleanArray sparseBooleanArray, int i) {
        if (!readField(i)) {
            return sparseBooleanArray;
        }
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        SparseBooleanArray sparseBooleanArray2 = new SparseBooleanArray(readInt);
        for (int i6 = 0; i6 < readInt; i6++) {
            sparseBooleanArray2.put(readInt(), readBoolean());
        }
        return sparseBooleanArray2;
    }

    public abstract String readString();

    public String readString(String str, int i) {
        return !readField(i) ? str : readString();
    }

    public abstract IBinder readStrongBinder();

    public IBinder readStrongBinder(IBinder iBinder, int i) {
        return !readField(i) ? iBinder : readStrongBinder();
    }

    public <T extends VersionedParcelable> T readVersionedParcelable() {
        String readString = readString();
        if (readString == null) {
            return null;
        }
        return (T) readFromParcel(readString, createSubParcel());
    }

    public abstract void setOutputField(int i);

    /* JADX WARN: Multi-variable type inference failed */
    public <T> void writeArray(T[] tArr) {
        if (tArr == 0) {
            writeInt(-1);
            return;
        }
        int length = tArr.length;
        writeInt(length);
        if (length > 0) {
            int i = 0;
            int type = getType(tArr[0]);
            writeInt(type);
            if (type == 1) {
                while (i < length) {
                    writeVersionedParcelable((VersionedParcelable) tArr[i]);
                    i++;
                }
                return;
            }
            if (type == 2) {
                while (i < length) {
                    writeParcelable((Parcelable) tArr[i]);
                    i++;
                }
                return;
            }
            if (type == 3) {
                while (i < length) {
                    writeSerializable((Serializable) tArr[i]);
                    i++;
                }
            } else if (type == 4) {
                while (i < length) {
                    writeString((String) tArr[i]);
                    i++;
                }
            } else {
                if (type != 5) {
                    return;
                }
                while (i < length) {
                    writeStrongBinder((IBinder) tArr[i]);
                    i++;
                }
            }
        }
    }

    public abstract void writeBoolean(boolean z9);

    public void writeBoolean(boolean z9, int i) {
        setOutputField(i);
        writeBoolean(z9);
    }

    public void writeBooleanArray(boolean[] zArr) {
        if (zArr == null) {
            writeInt(-1);
            return;
        }
        writeInt(zArr.length);
        for (boolean z9 : zArr) {
            writeInt(z9 ? 1 : 0);
        }
    }

    public abstract void writeBundle(Bundle bundle);

    public void writeBundle(Bundle bundle, int i) {
        setOutputField(i);
        writeBundle(bundle);
    }

    public void writeByte(byte b7, int i) {
        setOutputField(i);
        writeInt(b7);
    }

    public abstract void writeByteArray(byte[] bArr);

    public void writeByteArray(byte[] bArr, int i) {
        setOutputField(i);
        writeByteArray(bArr);
    }

    public abstract void writeByteArray(byte[] bArr, int i, int i6);

    public void writeCharArray(char[] cArr, int i) {
        setOutputField(i);
        if (cArr == null) {
            writeInt(-1);
            return;
        }
        writeInt(cArr.length);
        for (char c9 : cArr) {
            writeInt(c9);
        }
    }

    public abstract void writeCharSequence(CharSequence charSequence);

    public void writeCharSequence(CharSequence charSequence, int i) {
        setOutputField(i);
        writeCharSequence(charSequence);
    }

    public abstract void writeDouble(double d10);

    public void writeDouble(double d10, int i) {
        setOutputField(i);
        writeDouble(d10);
    }

    public void writeDoubleArray(double[] dArr) {
        if (dArr == null) {
            writeInt(-1);
            return;
        }
        writeInt(dArr.length);
        for (double d10 : dArr) {
            writeDouble(d10);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void writeException(Exception exc, int i) {
        setOutputField(i);
        if (exc == 0) {
            writeNoException();
            return;
        }
        int i6 = ((exc instanceof Parcelable) && exc.getClass().getClassLoader() == Parcelable.class.getClassLoader()) ? EX_PARCELABLE : exc instanceof SecurityException ? -1 : exc instanceof BadParcelableException ? -2 : exc instanceof IllegalArgumentException ? -3 : exc instanceof NullPointerException ? -4 : exc instanceof IllegalStateException ? EX_ILLEGAL_STATE : exc instanceof NetworkOnMainThreadException ? EX_NETWORK_MAIN_THREAD : exc instanceof UnsupportedOperationException ? EX_UNSUPPORTED_OPERATION : 0;
        writeInt(i6);
        if (i6 == 0) {
            if (exc instanceof RuntimeException) {
                throw ((RuntimeException) exc);
            }
            a.k(exc);
        } else {
            writeString(exc.getMessage());
            if (i6 != EX_PARCELABLE) {
                return;
            }
            writeParcelable((Parcelable) exc);
        }
    }

    public abstract void writeFloat(float f);

    public void writeFloat(float f, int i) {
        setOutputField(i);
        writeFloat(f);
    }

    public void writeFloatArray(float[] fArr) {
        if (fArr == null) {
            writeInt(-1);
            return;
        }
        writeInt(fArr.length);
        for (float f : fArr) {
            writeFloat(f);
        }
    }

    public abstract void writeInt(int i);

    public void writeInt(int i, int i6) {
        setOutputField(i6);
        writeInt(i);
    }

    public void writeIntArray(int[] iArr) {
        if (iArr == null) {
            writeInt(-1);
            return;
        }
        writeInt(iArr.length);
        for (int i : iArr) {
            writeInt(i);
        }
    }

    public <T> void writeList(List<T> list, int i) {
        writeCollection(list, i);
    }

    public abstract void writeLong(long j);

    public void writeLong(long j, int i) {
        setOutputField(i);
        writeLong(j);
    }

    public void writeLongArray(long[] jArr) {
        if (jArr == null) {
            writeInt(-1);
            return;
        }
        writeInt(jArr.length);
        for (long j : jArr) {
            writeLong(j);
        }
    }

    public <K, V> void writeMap(Map<K, V> map, int i) {
        setOutputField(i);
        if (map == null) {
            writeInt(-1);
            return;
        }
        int size = map.size();
        writeInt(size);
        if (size == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Map.Entry<K, V> entry : map.entrySet()) {
            arrayList.add(entry.getKey());
            arrayList2.add(entry.getValue());
        }
        writeCollection(arrayList);
        writeCollection(arrayList2);
    }

    public void writeNoException() {
        writeInt(0);
    }

    public abstract void writeParcelable(Parcelable parcelable);

    public void writeParcelable(Parcelable parcelable, int i) {
        setOutputField(i);
        writeParcelable(parcelable);
    }

    public <T> void writeSet(Set<T> set, int i) {
        writeCollection(set, i);
    }

    @RequiresApi(api = 21)
    public void writeSize(Size size, int i) {
        setOutputField(i);
        writeBoolean(size != null);
        if (size != null) {
            writeInt(size.getWidth());
            writeInt(size.getHeight());
        }
    }

    @RequiresApi(api = 21)
    public void writeSizeF(SizeF sizeF, int i) {
        setOutputField(i);
        writeBoolean(sizeF != null);
        if (sizeF != null) {
            writeFloat(sizeF.getWidth());
            writeFloat(sizeF.getHeight());
        }
    }

    public void writeSparseBooleanArray(SparseBooleanArray sparseBooleanArray, int i) {
        setOutputField(i);
        if (sparseBooleanArray == null) {
            writeInt(-1);
            return;
        }
        int size = sparseBooleanArray.size();
        writeInt(size);
        for (int i6 = 0; i6 < size; i6++) {
            writeInt(sparseBooleanArray.keyAt(i6));
            writeBoolean(sparseBooleanArray.valueAt(i6));
        }
    }

    public abstract void writeString(String str);

    public void writeString(String str, int i) {
        setOutputField(i);
        writeString(str);
    }

    public abstract void writeStrongBinder(IBinder iBinder);

    public void writeStrongBinder(IBinder iBinder, int i) {
        setOutputField(i);
        writeStrongBinder(iBinder);
    }

    public abstract void writeStrongInterface(IInterface iInterface);

    public void writeStrongInterface(IInterface iInterface, int i) {
        setOutputField(i);
        writeStrongInterface(iInterface);
    }

    public <T extends VersionedParcelable> void writeToParcel(T t9, VersionedParcel versionedParcel) {
        try {
            getWriteMethod(t9.getClass()).invoke(null, t9, versionedParcel);
        } catch (ClassNotFoundException e10) {
            androidx.privacysandbox.ads.adservices.customaudience.a.m("VersionedParcel encountered ClassNotFoundException", e10);
        } catch (IllegalAccessException e11) {
            androidx.privacysandbox.ads.adservices.customaudience.a.m("VersionedParcel encountered IllegalAccessException", e11);
        } catch (NoSuchMethodException e12) {
            androidx.privacysandbox.ads.adservices.customaudience.a.m("VersionedParcel encountered NoSuchMethodException", e12);
        } catch (InvocationTargetException e13) {
            if (e13.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e13.getCause());
            }
            androidx.privacysandbox.ads.adservices.customaudience.a.m("VersionedParcel encountered InvocationTargetException", e13);
        }
    }

    public void writeVersionedParcelable(VersionedParcelable versionedParcelable) {
        if (versionedParcelable == null) {
            writeString(null);
            return;
        }
        writeVersionedParcelableCreator(versionedParcelable);
        VersionedParcel createSubParcel = createSubParcel();
        writeToParcel(versionedParcelable, createSubParcel);
        createSubParcel.closeField();
    }

    public void writeByteArray(byte[] bArr, int i, int i6, int i10) {
        setOutputField(i10);
        writeByteArray(bArr, i, i6);
    }

    public <T extends VersionedParcelable> T readVersionedParcelable(T t9, int i) {
        return !readField(i) ? t9 : (T) readVersionedParcelable();
    }

    public void writeVersionedParcelable(VersionedParcelable versionedParcelable, int i) {
        setOutputField(i);
        writeVersionedParcelable(versionedParcelable);
    }

    private Exception readException(int i, String str) {
        return createException(i, str);
    }

    public double[] readDoubleArray(double[] dArr, int i) {
        return !readField(i) ? dArr : readDoubleArray();
    }

    public float[] readFloatArray(float[] fArr, int i) {
        return !readField(i) ? fArr : readFloatArray();
    }

    public int[] readIntArray(int[] iArr, int i) {
        return !readField(i) ? iArr : readIntArray();
    }

    public long[] readLongArray(long[] jArr, int i) {
        return !readField(i) ? jArr : readLongArray();
    }

    public void writeBooleanArray(boolean[] zArr, int i) {
        setOutputField(i);
        writeBooleanArray(zArr);
    }

    public void writeDoubleArray(double[] dArr, int i) {
        setOutputField(i);
        writeDoubleArray(dArr);
    }

    public void writeFloatArray(float[] fArr, int i) {
        setOutputField(i);
        writeFloatArray(fArr);
    }

    public void writeIntArray(int[] iArr, int i) {
        setOutputField(i);
        writeIntArray(iArr);
    }

    public void writeLongArray(long[] jArr, int i) {
        setOutputField(i);
        writeLongArray(jArr);
    }

    public boolean[] readBooleanArray(boolean[] zArr, int i) {
        return !readField(i) ? zArr : readBooleanArray();
    }

    public void setSerializationFlags(boolean z9, boolean z10) {
    }

    public void writeSerializable(Serializable serializable, int i) {
        setOutputField(i);
        writeSerializable(serializable);
    }

    public <T> void writeArray(T[] tArr, int i) {
        setOutputField(i);
        writeArray(tArr);
    }

    public <T> T[] readArray(T[] tArr, int i) {
        return !readField(i) ? tArr : (T[]) readArray(tArr);
    }

    private <T> void writeCollection(Collection<T> collection, int i) {
        setOutputField(i);
        writeCollection(collection);
    }
}
