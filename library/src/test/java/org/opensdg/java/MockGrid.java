package org.opensdg.java;

import org.opensdg.protocol.MockTunnel;
import org.opensdg.protocol.generated.ControlProtocol.PeerReply;

public class MockGrid extends GridConnection {

    public MockGrid(byte[] clientPrivateKey) {
        super(clientPrivateKey);

        // Replace the Tunnel with a mock
        tunnel = new MockTunnel(tunnel.getMyPeerId(), this);
    }

    @Override
    ForwardRequest pair(String otp) {
        ForwardRequest request = new ForwardRequest(0);
        PeerReply.Builder reply = PeerReply.newBuilder();

        reply.setId(0);
        reply.setResult(0);
        request.reportDone(reply.build());
        return request;
    }
}
