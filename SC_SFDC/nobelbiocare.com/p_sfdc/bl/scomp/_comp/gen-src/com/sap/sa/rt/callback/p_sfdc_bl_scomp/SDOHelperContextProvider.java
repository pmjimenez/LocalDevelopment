                                
                
package com.sap.sa.rt.callback.p_sfdc_bl_scomp;   


import com.sap.sdo.api.impl.SapHelperProvider;

import commonj.sdo.helper.HelperContext;


public final class SDOHelperContextProvider {
	
    private static final SDOHelperContextProvider INSTANCE = new SDOHelperContextProvider();

    public static SDOHelperContextProvider getInstance() {
        return INSTANCE;
    }

    private HelperContext contextInstance;

    public synchronized HelperContext getContextInstance() {
        if (contextInstance == null) {
            createContextInstance();            
        } 
        return contextInstance;  
    }

    private void createContextInstance() {
        this.contextInstance = SapHelperProvider.getNewContext();        
    }

    private SDOHelperContextProvider() {}
}