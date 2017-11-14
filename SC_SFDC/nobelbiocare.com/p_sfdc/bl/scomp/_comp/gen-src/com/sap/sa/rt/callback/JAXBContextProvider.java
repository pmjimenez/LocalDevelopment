package com.sap.sa.rt.callback;

import java.lang.ref.SoftReference;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import com.sap.sa.rt.transformation.IJAXBContextProvider;

public final class JAXBContextProvider implements IJAXBContextProvider {
    private static final String CONTEXT_PATH = null;

    private static final JAXBContextProvider INSTANCE = new JAXBContextProvider();

    public static JAXBContextProvider getInstance() {
        return INSTANCE;
    }

    private SoftReference<JAXBContext> contextInstanceReference;

    public synchronized JAXBContext getContextInstance() throws JAXBException {
        if (contextInstanceReference == null) {
            return createContextInstance();
        }

        final JAXBContext contextInstance = contextInstanceReference.get();

        return contextInstance == null ? createContextInstance() : contextInstance;  
    }

    private JAXBContext createContextInstance() throws JAXBException {
        final JAXBContext contextInstance = JAXBContext.newInstance(CONTEXT_PATH);

        contextInstanceReference = new SoftReference<JAXBContext>(contextInstance);

        return contextInstance;
    }

    private JAXBContextProvider() {}
}