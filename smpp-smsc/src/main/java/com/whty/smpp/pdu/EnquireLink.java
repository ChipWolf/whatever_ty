/****************************************************************************
 * SMPPEnquireLinkSM.java
 *
 * Copyright (C) Selenium Software Ltd 2006
 *
 * This file is part of SMPPSim.
 *
 * SMPPSim is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * SMPPSim is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with SMPPSim; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 *
 * @author martin@seleniumsoftware.com
 * http://www.woolleynet.com
 * http://www.seleniumsoftware.com
 * $Header: /var/cvsroot/SMPPSim2/distribution/2.6.9/SMPPSim/src/java/com/seleniumsoftware/SMPPSim/pdu/EnquireLink.java,v 1.1 2012/07/24 14:48:59 martin Exp $
 ****************************************************************************/

package com.whty.smpp.pdu;
/**
 * @ClassName EnquireLink
 * @author Administrator
 * @date 2017-1-23 下午3:23:32
 * @Description TODO(这里用一句话描述这个类的作用)
 */
public class EnquireLink extends Request implements Demarshaller {

	// PDU attributes

	public void demarshall(byte[] request) throws Exception {
		// demarshall the header
		super.demarshall(request);
	}
	
	/**
	 * *returns String representation of PDU
	 */
	public String toString() {
		return super.toString();
	}

}