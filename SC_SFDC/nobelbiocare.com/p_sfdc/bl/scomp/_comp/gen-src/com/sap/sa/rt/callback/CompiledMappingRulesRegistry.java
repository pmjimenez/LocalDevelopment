
package com.sap.sa.rt.callback;

import java.lang.ref.SoftReference;

import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

import com.sap.sa.rt.mapping.ICompiledMappingRulesRegistry;

public final class CompiledMappingRulesRegistry implements ICompiledMappingRulesRegistry {
    private static final String PATH_SEPARATOR = "/";
    private static final CompiledMappingRulesRegistry INSTANCE = new CompiledMappingRulesRegistry();

    public static CompiledMappingRulesRegistry getInstance() {
        return INSTANCE;
    }

    private static int getKey(Class<?> c, String filepath) {
        return new StringBuilder(c.getName()).append(PATH_SEPARATOR).append(filepath).toString().hashCode();
    }
    
    private SoftReference<Map<Integer, ValueWrapper>> compiledMappingRulesMapReference;

    public void addCompiledMappingRule(Class<?> c, String filepath, Object compiledMapping) {
        final int key = getKey(c, filepath);

        getCompiledMappingRulesMap().put(key, new ValueWrapper(compiledMapping, key));
    }

    public Object getCompiledMappingRule(Class<?> c, String filepath) {
        final ValueWrapper wrapper = getCompiledMappingRulesMap().get(getKey(c, filepath));

        return wrapper != null ? wrapper.value : null;
    }

    private synchronized Map<Integer, ValueWrapper> getCompiledMappingRulesMap() {
        if (compiledMappingRulesMapReference == null) {
            return createReferencedMap();
        }

        final Map<Integer, ValueWrapper> compiledMappingRulesMap = compiledMappingRulesMapReference.get();

        return compiledMappingRulesMap == null ? createReferencedMap() : compiledMappingRulesMap;
    }

    private Map<Integer, ValueWrapper> createReferencedMap() {
        final Map<Integer, ValueWrapper> compiledMappingRulesMap = Collections.synchronizedMap(new HashMap<Integer, ValueWrapper>());

        compiledMappingRulesMapReference = new SoftReference<Map<Integer, ValueWrapper>>(compiledMappingRulesMap);

        return compiledMappingRulesMap;
    }

    private CompiledMappingRulesRegistry() {}

    private static class ValueWrapper {
        private final Object value;
        private final int hashCode;

        public ValueWrapper(Object value, int hashCode) {
            this.value = value;
            this.hashCode = hashCode;
        }

        @Override
        public int hashCode() {
            return hashCode;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof ValueWrapper) {
                return hashCode == ((ValueWrapper) obj).hashCode;
            }

            return super.equals(obj);
        }
    }
}