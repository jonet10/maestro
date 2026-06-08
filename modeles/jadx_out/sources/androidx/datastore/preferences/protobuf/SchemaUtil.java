package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.FieldSet;
import androidx.datastore.preferences.protobuf.Internal;
import com.google.gson.internal.a;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@CheckReturnValue
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
final class SchemaUtil {
    private static final int DEFAULT_LOOK_UP_START_NUMBER = 40;
    private static final Class<?> GENERATED_MESSAGE_CLASS = getGeneratedMessageClass();
    private static final UnknownFieldSchema<?, ?> UNKNOWN_FIELD_SET_FULL_SCHEMA = getUnknownFieldSetSchema();
    private static final UnknownFieldSchema<?, ?> UNKNOWN_FIELD_SET_LITE_SCHEMA = new UnknownFieldSetLiteSchema();

    private SchemaUtil() {
    }

    public static int computeSizeBoolList(int i, List<?> list, boolean z9) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (!z9) {
            return CodedOutputStream.computeBoolSize(i, true) * size;
        }
        return CodedOutputStream.computeLengthDelimitedFieldSize(size) + CodedOutputStream.computeTagSize(i);
    }

    public static int computeSizeBoolListNoTag(List<?> list) {
        return list.size();
    }

    public static int computeSizeByteStringList(int i, List<ByteString> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int computeTagSize = CodedOutputStream.computeTagSize(i) * size;
        for (int i6 = 0; i6 < list.size(); i6++) {
            computeTagSize += CodedOutputStream.computeBytesSizeNoTag(list.get(i6));
        }
        return computeTagSize;
    }

    public static int computeSizeEnumList(int i, List<Integer> list, boolean z9) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int computeSizeEnumListNoTag = computeSizeEnumListNoTag(list);
        if (!z9) {
            return (CodedOutputStream.computeTagSize(i) * size) + computeSizeEnumListNoTag;
        }
        return CodedOutputStream.computeLengthDelimitedFieldSize(computeSizeEnumListNoTag) + CodedOutputStream.computeTagSize(i);
    }

    public static int computeSizeEnumListNoTag(List<Integer> list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof IntArrayList)) {
            int i6 = 0;
            while (i < size) {
                i6 += CodedOutputStream.computeEnumSizeNoTag(list.get(i).intValue());
                i++;
            }
            return i6;
        }
        IntArrayList intArrayList = (IntArrayList) list;
        int i10 = 0;
        while (i < size) {
            i10 += CodedOutputStream.computeEnumSizeNoTag(intArrayList.getInt(i));
            i++;
        }
        return i10;
    }

    public static int computeSizeFixed32List(int i, List<?> list, boolean z9) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (!z9) {
            return CodedOutputStream.computeFixed32Size(i, 0) * size;
        }
        return CodedOutputStream.computeLengthDelimitedFieldSize(size * 4) + CodedOutputStream.computeTagSize(i);
    }

    public static int computeSizeFixed32ListNoTag(List<?> list) {
        return list.size() * 4;
    }

    public static int computeSizeFixed64List(int i, List<?> list, boolean z9) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (!z9) {
            return CodedOutputStream.computeFixed64Size(i, 0L) * size;
        }
        return CodedOutputStream.computeLengthDelimitedFieldSize(size * 8) + CodedOutputStream.computeTagSize(i);
    }

    public static int computeSizeFixed64ListNoTag(List<?> list) {
        return list.size() * 8;
    }

    public static int computeSizeGroupList(int i, List<MessageLite> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i6 = 0;
        for (int i10 = 0; i10 < size; i10++) {
            i6 += CodedOutputStream.computeGroupSize(i, list.get(i10));
        }
        return i6;
    }

    public static int computeSizeInt32List(int i, List<Integer> list, boolean z9) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int computeSizeInt32ListNoTag = computeSizeInt32ListNoTag(list);
        if (!z9) {
            return (CodedOutputStream.computeTagSize(i) * size) + computeSizeInt32ListNoTag;
        }
        return CodedOutputStream.computeLengthDelimitedFieldSize(computeSizeInt32ListNoTag) + CodedOutputStream.computeTagSize(i);
    }

    public static int computeSizeInt32ListNoTag(List<Integer> list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof IntArrayList)) {
            int i6 = 0;
            while (i < size) {
                i6 += CodedOutputStream.computeInt32SizeNoTag(list.get(i).intValue());
                i++;
            }
            return i6;
        }
        IntArrayList intArrayList = (IntArrayList) list;
        int i10 = 0;
        while (i < size) {
            i10 += CodedOutputStream.computeInt32SizeNoTag(intArrayList.getInt(i));
            i++;
        }
        return i10;
    }

    public static int computeSizeInt64List(int i, List<Long> list, boolean z9) {
        if (list.size() == 0) {
            return 0;
        }
        int computeSizeInt64ListNoTag = computeSizeInt64ListNoTag(list);
        if (z9) {
            return CodedOutputStream.computeLengthDelimitedFieldSize(computeSizeInt64ListNoTag) + CodedOutputStream.computeTagSize(i);
        }
        return (CodedOutputStream.computeTagSize(i) * list.size()) + computeSizeInt64ListNoTag;
    }

    public static int computeSizeInt64ListNoTag(List<Long> list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof LongArrayList)) {
            int i6 = 0;
            while (i < size) {
                i6 += CodedOutputStream.computeInt64SizeNoTag(list.get(i).longValue());
                i++;
            }
            return i6;
        }
        LongArrayList longArrayList = (LongArrayList) list;
        int i10 = 0;
        while (i < size) {
            i10 += CodedOutputStream.computeInt64SizeNoTag(longArrayList.getLong(i));
            i++;
        }
        return i10;
    }

    public static int computeSizeMessage(int i, Object obj, Schema schema) {
        return obj instanceof LazyFieldLite ? CodedOutputStream.computeLazyFieldSize(i, (LazyFieldLite) obj) : CodedOutputStream.computeMessageSize(i, (MessageLite) obj, schema);
    }

    public static int computeSizeMessageList(int i, List<?> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int computeTagSize = CodedOutputStream.computeTagSize(i) * size;
        for (int i6 = 0; i6 < size; i6++) {
            Object obj = list.get(i6);
            computeTagSize = (obj instanceof LazyFieldLite ? CodedOutputStream.computeLazyFieldSizeNoTag((LazyFieldLite) obj) : CodedOutputStream.computeMessageSizeNoTag((MessageLite) obj)) + computeTagSize;
        }
        return computeTagSize;
    }

    public static int computeSizeSInt32List(int i, List<Integer> list, boolean z9) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int computeSizeSInt32ListNoTag = computeSizeSInt32ListNoTag(list);
        if (!z9) {
            return (CodedOutputStream.computeTagSize(i) * size) + computeSizeSInt32ListNoTag;
        }
        return CodedOutputStream.computeLengthDelimitedFieldSize(computeSizeSInt32ListNoTag) + CodedOutputStream.computeTagSize(i);
    }

    public static int computeSizeSInt32ListNoTag(List<Integer> list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof IntArrayList)) {
            int i6 = 0;
            while (i < size) {
                i6 += CodedOutputStream.computeSInt32SizeNoTag(list.get(i).intValue());
                i++;
            }
            return i6;
        }
        IntArrayList intArrayList = (IntArrayList) list;
        int i10 = 0;
        while (i < size) {
            i10 += CodedOutputStream.computeSInt32SizeNoTag(intArrayList.getInt(i));
            i++;
        }
        return i10;
    }

    public static int computeSizeSInt64List(int i, List<Long> list, boolean z9) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int computeSizeSInt64ListNoTag = computeSizeSInt64ListNoTag(list);
        if (!z9) {
            return (CodedOutputStream.computeTagSize(i) * size) + computeSizeSInt64ListNoTag;
        }
        return CodedOutputStream.computeLengthDelimitedFieldSize(computeSizeSInt64ListNoTag) + CodedOutputStream.computeTagSize(i);
    }

    public static int computeSizeSInt64ListNoTag(List<Long> list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof LongArrayList)) {
            int i6 = 0;
            while (i < size) {
                i6 += CodedOutputStream.computeSInt64SizeNoTag(list.get(i).longValue());
                i++;
            }
            return i6;
        }
        LongArrayList longArrayList = (LongArrayList) list;
        int i10 = 0;
        while (i < size) {
            i10 += CodedOutputStream.computeSInt64SizeNoTag(longArrayList.getLong(i));
            i++;
        }
        return i10;
    }

    public static int computeSizeStringList(int i, List<?> list) {
        int size = list.size();
        int i6 = 0;
        if (size == 0) {
            return 0;
        }
        int computeTagSize = CodedOutputStream.computeTagSize(i) * size;
        if (!(list instanceof LazyStringList)) {
            while (i6 < size) {
                Object obj = list.get(i6);
                computeTagSize = (obj instanceof ByteString ? CodedOutputStream.computeBytesSizeNoTag((ByteString) obj) : CodedOutputStream.computeStringSizeNoTag((String) obj)) + computeTagSize;
                i6++;
            }
            return computeTagSize;
        }
        LazyStringList lazyStringList = (LazyStringList) list;
        while (i6 < size) {
            Object raw = lazyStringList.getRaw(i6);
            computeTagSize = (raw instanceof ByteString ? CodedOutputStream.computeBytesSizeNoTag((ByteString) raw) : CodedOutputStream.computeStringSizeNoTag((String) raw)) + computeTagSize;
            i6++;
        }
        return computeTagSize;
    }

    public static int computeSizeUInt32List(int i, List<Integer> list, boolean z9) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int computeSizeUInt32ListNoTag = computeSizeUInt32ListNoTag(list);
        if (!z9) {
            return (CodedOutputStream.computeTagSize(i) * size) + computeSizeUInt32ListNoTag;
        }
        return CodedOutputStream.computeLengthDelimitedFieldSize(computeSizeUInt32ListNoTag) + CodedOutputStream.computeTagSize(i);
    }

    public static int computeSizeUInt32ListNoTag(List<Integer> list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof IntArrayList)) {
            int i6 = 0;
            while (i < size) {
                i6 += CodedOutputStream.computeUInt32SizeNoTag(list.get(i).intValue());
                i++;
            }
            return i6;
        }
        IntArrayList intArrayList = (IntArrayList) list;
        int i10 = 0;
        while (i < size) {
            i10 += CodedOutputStream.computeUInt32SizeNoTag(intArrayList.getInt(i));
            i++;
        }
        return i10;
    }

    public static int computeSizeUInt64List(int i, List<Long> list, boolean z9) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int computeSizeUInt64ListNoTag = computeSizeUInt64ListNoTag(list);
        if (!z9) {
            return (CodedOutputStream.computeTagSize(i) * size) + computeSizeUInt64ListNoTag;
        }
        return CodedOutputStream.computeLengthDelimitedFieldSize(computeSizeUInt64ListNoTag) + CodedOutputStream.computeTagSize(i);
    }

    public static int computeSizeUInt64ListNoTag(List<Long> list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof LongArrayList)) {
            int i6 = 0;
            while (i < size) {
                i6 += CodedOutputStream.computeUInt64SizeNoTag(list.get(i).longValue());
                i++;
            }
            return i6;
        }
        LongArrayList longArrayList = (LongArrayList) list;
        int i10 = 0;
        while (i < size) {
            i10 += CodedOutputStream.computeUInt64SizeNoTag(longArrayList.getLong(i));
            i++;
        }
        return i10;
    }

    @CanIgnoreReturnValue
    public static <UT, UB> UB filterUnknownEnumList(Object obj, int i, List<Integer> list, Internal.EnumLiteMap<?> enumLiteMap, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema) {
        if (enumLiteMap == null) {
            return ub;
        }
        if (!(list instanceof RandomAccess)) {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int intValue = it.next().intValue();
                if (enumLiteMap.findValueByNumber(intValue) == null) {
                    ub = (UB) storeUnknownEnum(obj, i, intValue, ub, unknownFieldSchema);
                    it.remove();
                }
            }
            return ub;
        }
        int size = list.size();
        int i6 = 0;
        for (int i10 = 0; i10 < size; i10++) {
            Integer num = list.get(i10);
            int intValue2 = num.intValue();
            if (enumLiteMap.findValueByNumber(intValue2) != null) {
                if (i10 != i6) {
                    list.set(i6, num);
                }
                i6++;
            } else {
                ub = (UB) storeUnknownEnum(obj, i, intValue2, ub, unknownFieldSchema);
            }
        }
        if (i6 != size) {
            list.subList(i6, size).clear();
        }
        return ub;
    }

    private static Class<?> getGeneratedMessageClass() {
        if (Protobuf.assumeLiteRuntime) {
            return null;
        }
        try {
            return Class.forName("androidx.datastore.preferences.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Object getMapDefaultEntry(Class<?> cls, String str) {
        try {
            java.lang.reflect.Field[] declaredFields = Class.forName(cls.getName() + "$" + toCamelCase(str, true) + "DefaultEntryHolder").getDeclaredFields();
            if (declaredFields.length == 1) {
                return UnsafeUtil.getStaticObject(declaredFields[0]);
            }
            throw new IllegalStateException("Unable to look up map field default entry holder class for " + str + " in " + cls.getName());
        } catch (Throwable th) {
            a.k(th);
            return null;
        }
    }

    private static UnknownFieldSchema<?, ?> getUnknownFieldSetSchema() {
        try {
            Class<?> unknownFieldSetSchemaClass = getUnknownFieldSetSchemaClass();
            if (unknownFieldSetSchemaClass == null) {
                return null;
            }
            return (UnknownFieldSchema) unknownFieldSetSchemaClass.getConstructor(null).newInstance(null);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> getUnknownFieldSetSchemaClass() {
        if (Protobuf.assumeLiteRuntime) {
            return null;
        }
        try {
            return Class.forName("androidx.datastore.preferences.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static <T, FT extends FieldSet.FieldDescriptorLite<FT>> void mergeExtensions(ExtensionSchema<FT> extensionSchema, T t9, T t10) {
        FieldSet<FT> extensions = extensionSchema.getExtensions(t10);
        if (extensions.isEmpty()) {
            return;
        }
        extensionSchema.getMutableExtensions(t9).mergeFrom(extensions);
    }

    public static <T> void mergeMap(MapFieldSchema mapFieldSchema, T t9, T t10, long j) {
        UnsafeUtil.putObject(t9, j, mapFieldSchema.mergeFrom(UnsafeUtil.getObject(t9, j), UnsafeUtil.getObject(t10, j)));
    }

    public static <T, UT, UB> void mergeUnknownFields(UnknownFieldSchema<UT, UB> unknownFieldSchema, T t9, T t10) {
        unknownFieldSchema.setToMessage(t9, unknownFieldSchema.merge(unknownFieldSchema.getFromMessage(t9), unknownFieldSchema.getFromMessage(t10)));
    }

    public static void requireGeneratedMessage(Class<?> cls) {
        Class<?> cls2;
        if (GeneratedMessageLite.class.isAssignableFrom(cls) || Protobuf.assumeLiteRuntime || (cls2 = GENERATED_MESSAGE_CLASS) == null || cls2.isAssignableFrom(cls)) {
            return;
        }
        a.p("Message classes must extend GeneratedMessage or GeneratedMessageLite");
    }

    public static boolean safeEquals(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static boolean shouldUseTableSwitch(int i, int i6, int i10) {
        if (i6 < 40) {
            return true;
        }
        long j = i6 - i;
        long j6 = i10;
        return j + 10 <= ((j6 + 3) * 3) + ((2 * j6) + 3);
    }

    @CanIgnoreReturnValue
    public static <UT, UB> UB storeUnknownEnum(Object obj, int i, int i6, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema) {
        if (ub == null) {
            ub = unknownFieldSchema.getBuilderFromMessage(obj);
        }
        unknownFieldSchema.addVarint(ub, i, i6);
        return ub;
    }

    public static String toCamelCase(String str, boolean z9) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if ('a' > charAt || charAt > 'z') {
                if ('A' > charAt || charAt > 'Z') {
                    if ('0' <= charAt && charAt <= '9') {
                        sb.append(charAt);
                    }
                    z9 = true;
                } else if (i != 0 || z9) {
                    sb.append(charAt);
                } else {
                    sb.append((char) (charAt + ' '));
                }
            } else if (z9) {
                sb.append((char) (charAt - ' '));
            } else {
                sb.append(charAt);
            }
            z9 = false;
        }
        return sb.toString();
    }

    public static UnknownFieldSchema<?, ?> unknownFieldSetFullSchema() {
        return UNKNOWN_FIELD_SET_FULL_SCHEMA;
    }

    public static UnknownFieldSchema<?, ?> unknownFieldSetLiteSchema() {
        return UNKNOWN_FIELD_SET_LITE_SCHEMA;
    }

    public static void writeBool(int i, boolean z9, Writer writer) throws IOException {
        if (z9) {
            writer.writeBool(i, true);
        }
    }

    public static void writeBoolList(int i, List<Boolean> list, Writer writer, boolean z9) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeBoolList(i, list, z9);
    }

    public static void writeBytes(int i, ByteString byteString, Writer writer) throws IOException {
        if (byteString == null || byteString.isEmpty()) {
            return;
        }
        writer.writeBytes(i, byteString);
    }

    public static void writeBytesList(int i, List<ByteString> list, Writer writer) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeBytesList(i, list);
    }

    public static void writeDouble(int i, double d10, Writer writer) throws IOException {
        if (Double.doubleToRawLongBits(d10) != 0) {
            writer.writeDouble(i, d10);
        }
    }

    public static void writeDoubleList(int i, List<Double> list, Writer writer, boolean z9) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeDoubleList(i, list, z9);
    }

    public static void writeEnum(int i, int i6, Writer writer) throws IOException {
        if (i6 != 0) {
            writer.writeEnum(i, i6);
        }
    }

    public static void writeEnumList(int i, List<Integer> list, Writer writer, boolean z9) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeEnumList(i, list, z9);
    }

    public static void writeFixed32(int i, int i6, Writer writer) throws IOException {
        if (i6 != 0) {
            writer.writeFixed32(i, i6);
        }
    }

    public static void writeFixed32List(int i, List<Integer> list, Writer writer, boolean z9) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeFixed32List(i, list, z9);
    }

    public static void writeFixed64(int i, long j, Writer writer) throws IOException {
        if (j != 0) {
            writer.writeFixed64(i, j);
        }
    }

    public static void writeFixed64List(int i, List<Long> list, Writer writer, boolean z9) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeFixed64List(i, list, z9);
    }

    public static void writeFloat(int i, float f, Writer writer) throws IOException {
        if (Float.floatToRawIntBits(f) != 0) {
            writer.writeFloat(i, f);
        }
    }

    public static void writeFloatList(int i, List<Float> list, Writer writer, boolean z9) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeFloatList(i, list, z9);
    }

    public static void writeGroupList(int i, List<?> list, Writer writer) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeGroupList(i, list);
    }

    public static void writeInt32(int i, int i6, Writer writer) throws IOException {
        if (i6 != 0) {
            writer.writeInt32(i, i6);
        }
    }

    public static void writeInt32List(int i, List<Integer> list, Writer writer, boolean z9) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeInt32List(i, list, z9);
    }

    public static void writeInt64(int i, long j, Writer writer) throws IOException {
        if (j != 0) {
            writer.writeInt64(i, j);
        }
    }

    public static void writeInt64List(int i, List<Long> list, Writer writer, boolean z9) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeInt64List(i, list, z9);
    }

    public static void writeLazyFieldList(int i, List<?> list, Writer writer) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<?> it = list.iterator();
        while (it.hasNext()) {
            ((LazyFieldLite) it.next()).writeTo(writer, i);
        }
    }

    public static void writeMessage(int i, Object obj, Writer writer) throws IOException {
        if (obj != null) {
            writer.writeMessage(i, obj);
        }
    }

    public static void writeMessageList(int i, List<?> list, Writer writer) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeMessageList(i, list);
    }

    public static void writeSFixed32(int i, int i6, Writer writer) throws IOException {
        if (i6 != 0) {
            writer.writeSFixed32(i, i6);
        }
    }

    public static void writeSFixed32List(int i, List<Integer> list, Writer writer, boolean z9) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeSFixed32List(i, list, z9);
    }

    public static void writeSFixed64(int i, long j, Writer writer) throws IOException {
        if (j != 0) {
            writer.writeSFixed64(i, j);
        }
    }

    public static void writeSFixed64List(int i, List<Long> list, Writer writer, boolean z9) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeSFixed64List(i, list, z9);
    }

    public static void writeSInt32(int i, int i6, Writer writer) throws IOException {
        if (i6 != 0) {
            writer.writeSInt32(i, i6);
        }
    }

    public static void writeSInt32List(int i, List<Integer> list, Writer writer, boolean z9) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeSInt32List(i, list, z9);
    }

    public static void writeSInt64(int i, long j, Writer writer) throws IOException {
        if (j != 0) {
            writer.writeSInt64(i, j);
        }
    }

    public static void writeSInt64List(int i, List<Long> list, Writer writer, boolean z9) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeSInt64List(i, list, z9);
    }

    public static void writeString(int i, Object obj, Writer writer) throws IOException {
        if (obj instanceof String) {
            writeStringInternal(i, (String) obj, writer);
        } else {
            writeBytes(i, (ByteString) obj, writer);
        }
    }

    private static void writeStringInternal(int i, String str, Writer writer) throws IOException {
        if (str == null || str.isEmpty()) {
            return;
        }
        writer.writeString(i, str);
    }

    public static void writeStringList(int i, List<String> list, Writer writer) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeStringList(i, list);
    }

    public static void writeUInt32(int i, int i6, Writer writer) throws IOException {
        if (i6 != 0) {
            writer.writeUInt32(i, i6);
        }
    }

    public static void writeUInt32List(int i, List<Integer> list, Writer writer, boolean z9) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeUInt32List(i, list, z9);
    }

    public static void writeUInt64(int i, long j, Writer writer) throws IOException {
        if (j != 0) {
            writer.writeUInt64(i, j);
        }
    }

    public static void writeUInt64List(int i, List<Long> list, Writer writer, boolean z9) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeUInt64List(i, list, z9);
    }

    public static void writeGroupList(int i, List<?> list, Writer writer, Schema schema) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeGroupList(i, list, schema);
    }

    public static void writeMessageList(int i, List<?> list, Writer writer, Schema schema) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeMessageList(i, list, schema);
    }

    public static int computeSizeGroupList(int i, List<MessageLite> list, Schema schema) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i6 = 0;
        for (int i10 = 0; i10 < size; i10++) {
            i6 += CodedOutputStream.computeGroupSize(i, list.get(i10), schema);
        }
        return i6;
    }

    public static boolean shouldUseTableSwitch(FieldInfo[] fieldInfoArr) {
        if (fieldInfoArr.length == 0) {
            return false;
        }
        return shouldUseTableSwitch(fieldInfoArr[0].getFieldNumber(), fieldInfoArr[fieldInfoArr.length - 1].getFieldNumber(), fieldInfoArr.length);
    }

    public static int computeSizeMessageList(int i, List<?> list, Schema schema) {
        int computeMessageSizeNoTag;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int computeTagSize = CodedOutputStream.computeTagSize(i) * size;
        for (int i6 = 0; i6 < size; i6++) {
            Object obj = list.get(i6);
            if (obj instanceof LazyFieldLite) {
                computeMessageSizeNoTag = CodedOutputStream.computeLazyFieldSizeNoTag((LazyFieldLite) obj);
            } else {
                computeMessageSizeNoTag = CodedOutputStream.computeMessageSizeNoTag((MessageLite) obj, schema);
            }
            computeTagSize = computeMessageSizeNoTag + computeTagSize;
        }
        return computeTagSize;
    }

    @CanIgnoreReturnValue
    public static <UT, UB> UB filterUnknownEnumList(Object obj, int i, List<Integer> list, Internal.EnumVerifier enumVerifier, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema) {
        if (enumVerifier == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i6 = 0;
            for (int i10 = 0; i10 < size; i10++) {
                Integer num = list.get(i10);
                int intValue = num.intValue();
                if (enumVerifier.isInRange(intValue)) {
                    if (i10 != i6) {
                        list.set(i6, num);
                    }
                    i6++;
                } else {
                    ub = (UB) storeUnknownEnum(obj, i, intValue, ub, unknownFieldSchema);
                }
            }
            if (i6 != size) {
                list.subList(i6, size).clear();
            }
            return ub;
        }
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            int intValue2 = it.next().intValue();
            if (!enumVerifier.isInRange(intValue2)) {
                ub = (UB) storeUnknownEnum(obj, i, intValue2, ub, unknownFieldSchema);
                it.remove();
            }
        }
        return ub;
    }
}
