package io.corestack.kubeedge.cloud.socket;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.corestack.kubeedge.cloud.message.EdgeMessage;
import io.fabric8.kubernetes.api.model.Node;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;
import java.io.IOException;

public class EdgeMessageDecoder implements Decoder.Text<EdgeMessage> {

    private static final Logger LOGGER = LoggerFactory.getLogger(EdgeMessageDecoder.class);

    private ObjectMapper objectMapper;

    @Override
    public EdgeMessage decode(String s) throws DecodeException {
        try {
            LOGGER.info("Received: {}.", s);
            EdgeMessage ed = objectMapper.readValue(s, EdgeMessage.class);
            LOGGER.info("source: {}, data: {}.", ed.getSource(), ed.getData());

            if(ed.getSource().equals("node")) {
                ed.setResource(objectMapper.convertValue(ed.getData(), Node.class));
            }
            return ed;
        } catch (IOException e) {
            LOGGER.warn("Error decode.", e);
            throw new DecodeException(s, e.getMessage(), e);
        }
    }

    @Override
    public boolean willDecode(String s) {
        return s != null;
    }

    @Override
    public void init(EndpointConfig endpointConfig) {
        objectMapper = new ObjectMapper();
    }

    @Override
    public void destroy() {

    }
}
