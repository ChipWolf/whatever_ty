package com.whty.smpp.socket.message;

import org.jboss.netty.buffer.ChannelBuffer;

import com.whty.smpp.socket.exception.RecoverablePduException;
import com.whty.smpp.socket.exception.UnrecoverablePduException;
/**
 * 
 * @ClassName EmptyBody
 * @author Administrator
 * @date 2017-3-10 下午1:46:39
 * @Description TODO(这里用一句话描述这个类的作用)
 */
public abstract class EmptyBody<R extends PduResponse> extends PduRequest<R> {
    
    public EmptyBody(int commandId, String name) {
        super(commandId, name);
    }

    @Override
    public void readBody(ChannelBuffer buffer) throws UnrecoverablePduException, RecoverablePduException {
        // no body
    }

    @Override
    public int calculateByteSizeOfBody() {
        return 0;   // no body
    }

    @Override
    public void writeBody(ChannelBuffer buffer) throws UnrecoverablePduException, RecoverablePduException {
        /// no body
    }

    @Override
    public void appendBodyToString(StringBuilder buffer) {
        // no body
    }

}