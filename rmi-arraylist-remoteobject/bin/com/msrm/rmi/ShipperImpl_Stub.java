// Stub class generated by rmic, do not edit.
// Contents subject to change without notice.

package com.msrm.rmi;

public final class ShipperImpl_Stub
    extends java.rmi.server.RemoteStub
    implements com.msrm.rmi.Shipper, java.rmi.Remote
{
    private static final long serialVersionUID = 2;
    
    private static java.lang.reflect.Method $method_ship_0;
    
    static {
	try {
	    $method_ship_0 = com.msrm.rmi.Shipper.class.getMethod("ship", new java.lang.Class[] {java.lang.Integer[].class, java.lang.String[].class, java.lang.Float[].class});
	} catch (java.lang.NoSuchMethodException e) {
	    throw new java.lang.NoSuchMethodError(
		"stub class initialization failed");
	}
    }
    
    // constructors
    public ShipperImpl_Stub(java.rmi.server.RemoteRef ref) {
	super(ref);
    }
    
    // methods from remote interfaces
    
    // implementation of ship(Integer[], String[], Float[])
    public java.util.ArrayList ship(java.lang.Integer[] $param_arrayOf_Integer_1, java.lang.String[] $param_arrayOf_String_2, java.lang.Float[] $param_arrayOf_Float_3)
	throws java.rmi.RemoteException
    {
	try {
	    Object $result = ref.invoke(this, $method_ship_0, new java.lang.Object[] {$param_arrayOf_Integer_1, $param_arrayOf_String_2, $param_arrayOf_Float_3}, -8148703564751563062L);
	    return ((java.util.ArrayList) $result);
	} catch (java.lang.RuntimeException e) {
	    throw e;
	} catch (java.rmi.RemoteException e) {
	    throw e;
	} catch (java.lang.Exception e) {
	    throw new java.rmi.UnexpectedException("undeclared checked exception", e);
	}
    }
}
