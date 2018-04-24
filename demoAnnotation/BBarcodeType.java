package com.niagarasummit.barcode.demoAnnotation;

import javax.baja.nre.annotations.NiagaraEnum;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.nre.annotations.Range;
import javax.baja.sys.BFrozenEnum;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;

@NiagaraType
/** Barcode types enumeration */
@NiagaraEnum(
  range = {
    @Range(ordinal = 1,value = "Code_39"),
    @Range(ordinal = 2,value = "Code_128"),
    @Range(ordinal = 3,value = "QR_Code"),
    @Range(ordinal = 4,value = "SCC_14_Code"),
    @Range(ordinal = 5,value = "UPC_Code"),
    @Range(ordinal = 6,value = "EAN_Code")
  }
)
public final class BBarcodeType
  extends BFrozenEnum
{

}
