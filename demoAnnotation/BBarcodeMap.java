package com.niagarasummit.barcode.demoAnnotation;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import javax.baja.naming.SlotPath;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.nre.annotations.NoSlotomatic;
import javax.baja.nre.util.TextUtil;
import javax.baja.sys.BObject;
import javax.baja.sys.BSimple;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;

/** Barcode map class*/
@NiagaraType
@NoSlotomatic
public class BBarcodeMap
  extends BSimple
{

  public static final BBarcodeMap NULL = new BBarcodeMap(new LinkedHashMap<>());
  public static final BBarcodeMap DEFAULT = NULL;
  
  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BBarcodeMap.class);
  

  BBarcodeMap(LinkedHashMap<String, BBarcodeType> map)
  {
    this.map = map;
  }

  @Override
  public boolean equals(Object obj)
  {
    if (obj == null)
      return false;

    if (!(obj instanceof BBarcodeMap))
      return false;

    BBarcodeMap s = (BBarcodeMap)obj;

    if (map.size() != s.map.size())
      return false;

    Iterator it = map.keySet().iterator();
    Iterator it2 = s.map.keySet().iterator();

    while(it.hasNext() && it2.hasNext())
    {
      String key1 = (String)it.next();
      BBarcodeType val1 = map.get(key1);

      String key2 = (String)it2.next();
      BBarcodeType val2 = s.map.get(key2);

      if (!key1.equals(key2))
        return false;

      if (!val1.equals(val2))
        return false;
    }

    return true;
  }

  @Override
  public String encodeToString() throws IOException
  {
    StringBuilder buff = new StringBuilder();
    map.forEach( (key, value) ->
      {
        buff.append(delim);
        buff.append(key);
        buff.append(delim);
        buff.append(value.getTag());
      }
    );

    return buff.toString();
  }

  @Override
  public BObject decodeFromString(String s) throws IOException
  {
    if (s.length() == 0)
      return DEFAULT;

    String[] strs = TextUtil.splitAndTrim(s, delim);

    if (strs.length % 2 != 0)
      throw new IOException("Invalid Simple array Length (must be even): " + strs.length);

    LinkedHashMap<String, BBarcodeType> newMap = new LinkedHashMap<>();

    String key = null;
    BBarcodeType value;

    for (int i = 0; i < strs.length; ++i)
    {
      // Then decode the array contents and validate Types
      if (i == 0 || i % 2 == 0)
      {
        key = SlotPath.unescape(strs[i]);
      }
      else
      {
        value = (BBarcodeType)(new BBarcodeType()).decodeFromString(strs[i]);
//        value = BBarcodeType.make(strs[i]);

        newMap.put(key, value);
      }
    }

    return new BBarcodeMap(newMap);
  }

  @Override
  public void encode(DataOutput out) throws IOException
  {
    out.writeUTF(encodeToString());
  }

  @Override
  public BObject decode(DataInput in) throws IOException
  {
    return decodeFromString(in.readUTF());
  }

  private LinkedHashMap<String, BBarcodeType> map;
  private static final char delim = ';';
}
