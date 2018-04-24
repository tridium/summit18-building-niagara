package com.niagarasummit.barcode.demoAnnotation;

import javax.baja.batchJob.BBatchJob;
import javax.baja.batchJob.BJobStep;
import javax.baja.nre.annotations.AgentOn;
import javax.baja.nre.annotations.NiagaraSingleton;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.provisioningNiagara.ui.BStationStepFactory;
import javax.baja.sys.BObject;
import javax.baja.sys.Context;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import javax.baja.ui.BWidget;

/** Provisioning factory class for barcodes */ 
@NiagaraType(agent = @AgentOn(types={"barcode:BarcodeStep"}))
@NiagaraSingleton
public class BBarcodeFactory
  extends BStationStepFactory
{


  public BJobStep makeStep(BWidget owner,
                           BBatchJob currentBatchJob,
                           BObject jobTarget,
                           BObject    source,
                           Context cx)
    throws Exception
  {
    return new BBarcodeStep();
  }
}
