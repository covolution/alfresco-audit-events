package org.alfresco.events.audit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * Just tests basic class constructor
 */
public class AuditEventImplTest
{

    @Test
    public void testGetDataAsJson() throws Exception
    {
        AuditEventImpl aei = new AuditEventImpl("app1", "xyx", null, 345l, "kkong", produceValues());
        assertNotNull(aei.getDataAsJson());
//        assertEquals("boss", aei.getDataAsJson());
    }


    private Map<String, Serializable> produceValues() throws Exception
    {
        final int OVERLIMIT_SIZE = 1500;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < OVERLIMIT_SIZE; i++)
        {
            sb.append("a");
        }
/*
        MLText mlTextValue = new MLText();
        mlTextValue.put(Locale.ENGLISH, sb.toString());

        HashMap<String, Serializable> map = new HashMap<String, Serializable>();
        map.put("String", sb.toString());
        MLText mlTextValue1 = new MLText();
        mlTextValue1.put(Locale.ENGLISH, sb.toString());
        map.put("MLText", mlTextValue1);

        ArrayList<Serializable> list = new ArrayList<Serializable>();
        list.add(sb.toString());
        MLText mlTextValue2 = new MLText();
        mlTextValue2.put(Locale.ENGLISH, sb.toString());
        list.add(mlTextValue2);
*/
        Map<String, Serializable> values = new HashMap<String, Serializable>(13);
        values.put("/3.1/4.1", sb.toString());
  //      values.put("/3.1/4.2", mlTextValue);
    //    values.put("map", map);
      //  values.put("collection", list);
      //  values.put("unmodifiableCollection", (Serializable) Collections.unmodifiableCollection(list));
        return values;

    }
}