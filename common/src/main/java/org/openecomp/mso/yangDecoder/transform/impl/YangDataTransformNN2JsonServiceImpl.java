package org.openecomp.mso.yangDecoder.transform.impl;

import com.google.common.base.Charsets;
import org.opendaylight.netconf.sal.rest.impl.JsonNormalizedNodeBodyReader;
import org.opendaylight.netconf.sal.rest.impl.NormalizedNodeJsonBodyWriter;
import org.opendaylight.netconf.sal.restconf.impl.NormalizedNodeContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.MediaType;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;

/**
 * Created by Administrator on 2017/3/17.
 */
public class YangDataTransformNN2JsonServiceImpl {
    private static final Logger LOG = LoggerFactory.getLogger(YangDataTransformNN2JsonServiceImpl.class);
    private static final Annotation[] EMPTY_ANNOTATIONS = new Annotation[0];

    public NormalizedNodeContext transformNNCFromString(String uriPath,String jsonpayload,boolean isPost){

        InputStream entityStream = new ByteArrayInputStream(jsonpayload.getBytes(Charsets.UTF_8));
        NormalizedNodeContext normalnodes3 = JsonNormalizedNodeBodyReader.readFrom(uriPath, entityStream, isPost);
        return normalnodes3;
    }
    public String transformNNCToString(NormalizedNodeContext readData) throws IOException {
        NormalizedNodeJsonBodyWriter writer = new NormalizedNodeJsonBodyWriter();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        //readData.getWriterParameters().isPrettyPrint()
        writer.writeTo(readData, NormalizedNodeContext.class, null, EMPTY_ANNOTATIONS,
                MediaType.APPLICATION_JSON_TYPE, null, outputStream );
        return outputStream.toString(Charsets.UTF_8.name());
    }
    public NormalizedNodeContext transformRPCNNCFromString(String uriPath,String jsonpayload)
    {
        return transformNNCFromString(uriPath,jsonpayload,true);
    }
    public NormalizedNodeContext transformDataObjectNNCFromString(String uriPath,String jsonpayload,boolean ispost)
    {
        return transformNNCFromString(uriPath,jsonpayload,ispost);
    }
    public NormalizedNodeContext transformNotficationNNCFromString(String uriPath,String jsonpayload)
    {
        return transformNNCFromString(uriPath,jsonpayload,true);
    }
}