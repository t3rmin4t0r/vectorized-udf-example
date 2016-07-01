package org.notmysock.hive.udf;

import org.apache.hadoop.hive.ql.exec.UDFArgumentException;
import org.apache.hadoop.hive.ql.exec.vector.VectorizedExpressions;
import org.apache.hadoop.hive.ql.metadata.HiveException;
import org.apache.hadoop.hive.ql.udf.generic.GenericUDF;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.primitive.PrimitiveObjectInspectorFactory;
import org.apache.hadoop.io.Text;
import org.notmysock.hive.udf.vector.VectorStringRot13;

@VectorizedExpressions(value = { VectorStringRot13.class })
public class GenericUDFRot13 extends GenericUDF {

  @Override
  public Object evaluate(DeferredObject[] arg0) throws HiveException {
    return new Text("Unvectorized");
  }

  @Override
  public String getDisplayString(String[] arg0) {
    return String.format("Rot13(%s)", arg0[0]);
  }

  @Override
  public ObjectInspector initialize(ObjectInspector[] arg0)
      throws UDFArgumentException {
    return PrimitiveObjectInspectorFactory.writableStringObjectInspector;
  }

}
