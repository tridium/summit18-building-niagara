package com.niagarasummit.barcode.demoAnnotation;

import javax.baja.batchJob.BBatchJobService;
import javax.baja.batchJob.driver.BDeviceJobStep;
import javax.baja.batchJob.driver.BDeviceStepDetails;
import javax.baja.batchJob.driver.DeviceNetworkJobOp;
import javax.baja.driver.BDevice;
import javax.baja.nre.annotations.Facet;
import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.BBoolean;
import javax.baja.sys.BFacets;
import javax.baja.sys.BString;
import javax.baja.sys.Property;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;

/** Provisioning step for barcode */
@NiagaraType
/** Property for hello or goodbye */
@NiagaraProperty(
  name = "greetings",
  type = "BBoolean",
  defaultValue = "BBoolean.FALSE",
  facets = {
    @Facet(name = "BFacets.TRUE_TEXT", value="BString.make(\"hello\")"),
    @Facet(name = "BFacets.FALSE_TEXT", value="BString.make(\"goodbye\")")
  }
)
public class BBarcodeStep
  extends BDeviceJobStep
{

  protected void doRun(BBatchJobService svc, BDeviceStepDetails details, BDevice device, DeviceNetworkJobOp opIn)
    throws Exception
  {

  }
}
