package org.jvnet.hudson.plugins.port_allocator;

import java.io.IOException;
import java.io.Serializable;

/**
 * Represents an assigned TCP port and encapsulates how it should be cleaned up.
 * 
 * @author Kohsuke Kawaguchi
 */
public abstract class Port implements Serializable {
    /**
     * {@link PortType} that created this port.
     */
    public final PortType type;

    protected Port(PortType type) {
        this.type = type;
    }

    /**
     * @return the TCP port number.
     */
    public abstract int get();

    /**
     * Frees the port.
     *
     * @throws InterruptedException - If the current thread is interrupted while waiting for the completion.
     * @throws IOException - If there's any error in the communication between Channels.
     */
    public abstract void cleanUp() throws IOException, InterruptedException;
}
