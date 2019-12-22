package io.corestack.kubeedge.cloud.socket;

import io.corestack.kubeedge.cloud.message.EdgeMessage;
import io.fabric8.kubernetes.api.model.Node;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(
        value = "/node/{name}",
        decoders = {EdgeMessageDecoder.class}
)
@Service
public class NodeSocket {

    private final static Logger LOGGER = LoggerFactory.getLogger(NodeSocket.class);

    @OnOpen
    public void onOpen(Session session, @PathParam("name") String name) {

    }

    @OnMessage
    public void onMessage(EdgeMessage message, @PathParam("name") String name) {
        LOGGER.info("Received message: {}.", message);
        Node node = (Node) message.getResource();
        LOGGER.info("Node: {}.", node);
        LOGGER.info("Node: {}.", node.getMetadata().getName());
    }
}
