// Stub class generated by rmic, do not edit.
// Contents subject to change without notice.

package com.msrm.rmi;

public final class ShipperImpl_Stub
    extends java.rmi.server.RemoteStub
    implements com.msrm.rmi.Shipper, java.rmi.Remote
{
    private static final java.rmi.server.Operation[] operations = {
	new java.rmi.server.Operation("java.util.Map ship(java.lang.Integer[], java.lang.String[], java.lang.Float[])")
    };
    
    private static final long interfaceHash = 8906216377752392609L;
    
    // constructors
    public ShipperImpl_Stub() {
	super();
    }
    public ShipperImpl_Stub(java.rmi.server.RemoteRef ref) {
	super(ref);
    }
    
    // methods from remote interfaces
    
    // implementation of ship(Integer[], String[], Float[])
    public java.util.Map ship(java.lang.Integer[] $param_arrayOf_Integer_1, java.lang.String[] $param_arrayOf_String_2, java.lang.Float[] $param_arrayOf_Float_3)
	throws java.rmi.RemoteException
    {
	try {
	    java.rmi.server.RemoteCall call = ref.newCall((java.rmi.server.RemoteObject) this, operations, 0, interfaceHash);
	    try {
		java.io.ObjectOutput out = call.getOutputStream();
		out.writeObject($param_arrayOf_Integer_1);
		out.writeObject($param_arrayOf_String_2);
		out.writeObject($param_arrayOf_Float_3);
	    } catch (java.io.IOException e) {
		throw new java.rmi.MarshalException("error marshalling arguments", e);
	    }
	    ref.invoke(call);
	    java.util.Map $result;
	    try {
		java.io.ObjectInput in = call.getInputStream();
		$result = (java.util.Map) in.readObject();
	    } catch (java.io.IOException e) {
		throw new java.rmi.UnmarshalException("error unmarshalling return", e);
	    } catch (java.lang.ClassNotFoundException e) {
		throw new java.rmi.UnmarshalException("error unmarshalling return", e);
	    } finally {
		ref.done(call);
	    }
	    return $result;
	} catch (java.lang.RuntimeException e) {
	    throw e;
	} catch (java.rmi.RemoteException e) {
	    throw e;
	} catch (java.lang.Exception e) {
	    throw new java.rmi.UnexpectedException("undeclared checked exception", e);
	}
    }
}
