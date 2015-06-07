package com.sonal.context;

public class ServiceRequestContext {
    
    private static final ThreadLocal<ServiceRequestVO> serviceRequestHolder = new InheritableThreadLocal<ServiceRequestVO>();
    
    public static void setServiceRequestVO(ServiceRequestVO serviceRequestVO){
	serviceRequestHolder.set(serviceRequestVO);
    }
    
    public static ServiceRequestVO getServiceRequestVO(){
	return serviceRequestHolder.get();
    }
    
    public static void removeServiceRequestVO(){
	serviceRequestHolder.remove();
    }

}
