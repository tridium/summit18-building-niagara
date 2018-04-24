package com.niagarasummit.barcode.ui;

import javax.baja.nre.annotations.AgentOn;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.BDouble;
import javax.baja.sys.BObject;
import javax.baja.sys.BString;
import javax.baja.sys.BValue;
import javax.baja.sys.Property;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import javax.baja.ui.BValueBinding;
import com.niagarasummit.barcode.BBarcodeNumeric;

@NiagaraType(
  agent=@AgentOn(types={"barcode:BarcodeNumeric", "barcode:BarcodeGenerator"})
)

/**
 * BBarcodeBinding implements the binding between the BarcodeNumeric point and the BarcodeGenerator widget.
 */
public class BBarcodeBinding
  extends BValueBinding
{
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.niagarasummit.barcode.ui.BBarcodeBinding(1019310940)1.0$ @*/
/* Generated Fri Apr 06 12:18:25 EDT 2018 by Slot-o-Matic (c) Tridium, Inc. 2012 */

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BBarcodeBinding.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  @Override
  public BValue getOnWidget(Property prop)
  {
    BObject from = get();
    if (from instanceof BBarcodeNumeric)
    {
      String name = prop.getName();
      if (name.equals("imageBuffer"))
      {
        return BString.make(((BBarcodeNumeric)from).getImageBuffer());
      }
      if (name.equals("barcodeHeight"))
      {
        return BDouble.make(((BBarcodeNumeric)from).getBarcodeHeight());
      }
      if (name.equals("barcodeWidth"))
      {
        return BDouble.make(((BBarcodeNumeric)from).getBarcodeWidth());
      }
    }
    return super.getOnWidget(prop);
  }
}

