package eu.xenit.alfred.telemetry.solr.writer;

import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;
import java.util.Map;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.util.NamedList;
import org.apache.solr.request.SolrQueryRequest;
import org.apache.solr.response.QueryResponseWriter;
import org.apache.solr.response.SolrQueryResponse;
import org.apache.solr.response.TextResponseWriter;
import org.apache.solr.search.ReturnFields;

/**
 *
 */

public class PrometheusResponseWriter implements QueryResponseWriter {

    @Override
    public void init(@SuppressWarnings({"rawtypes"})NamedList n) {
    }

    @Override
    public void write(Writer writer, SolrQueryRequest req, SolrQueryResponse rsp) throws IOException {
        PrometheusWriter w = new PrometheusWriter(writer, req, rsp);
        try {
            w.writeResponse();
        } finally {
            w.close();
        }
    }

    @Override
    public String getContentType(SolrQueryRequest request, SolrQueryResponse response) {
        // using the text/plain allows this to be viewed in the browser easily
        return CONTENT_TYPE_TEXT_UTF8;
    }

}

class PrometheusWriter extends TextResponseWriter {

    private static final String RESPONSE_HEADER = "responseHeader";

    public PrometheusWriter(Writer writer, SolrQueryRequest req, SolrQueryResponse rsp) {
        super(writer, req, rsp);
    }

    public void writeResponse() throws IOException {
        writeNamedList(null, rsp.getValues());
    }


    @Override
    public void writeNamedList(String name, NamedList val) throws IOException {
        for (int i=0; i<val.size(); i++) {
            if(!"responseHeader".equals(val.getName(i)))
                writeVal(val.getName(i),val.getVal(i));
        }
    }

    @Override
    public void writeStartDocumentList(String name, long start, int size, long numFound, Float maxScore)
            throws IOException {

    }

    @Override
    public void writeSolrDocument(String name, SolrDocument doc, ReturnFields returnFields, int idx)
            throws IOException {

    }

    @Override
    public void writeEndDocumentList() throws IOException {

    }

    @Override
    public void writeStr(String name, String val, boolean needsEscaping) throws IOException {
        writer.write(name + " " + val + "\n");

    }

    @Override
    public void writeMap(String name, Map val, boolean excludeOuter, boolean isFirstVal) throws IOException {

    }

    @Override
    public void writeArray(String name, Iterator val) throws IOException {

    }

    @Override
    public void writeNull(String name) throws IOException {

    }

    @Override
    public void writeInt(String name, String val) throws IOException {
        writer.write(name + " " + val + "\n");
    }

    @Override
    public void writeLong(String name, String val) throws IOException {
        writer.write(name + " " + val + "\n");
    }

    @Override
    public void writeBool(String name, String val) throws IOException {
        writer.write(name + " " + val + "\n");
    }

    @Override
    public void writeFloat(String name, String val) throws IOException {
        writer.write(name + " " + val + "\n");
    }

    @Override
    public void writeDouble(String name, String val) throws IOException {
        writer.write(name + " " + val + "\n");
    }

    @Override
    public void writeDate(String name, String val) throws IOException {

    }
}
