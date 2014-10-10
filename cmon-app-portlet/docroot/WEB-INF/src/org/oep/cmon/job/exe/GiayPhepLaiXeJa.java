/**
 * 
 */
package org.oep.cmon.job.exe;

import org.oep.cmon.job.business.GiayPhepLaiXeBs;

import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.messaging.MessageListenerException;


/** 
 * This is class GiayPhepLaiXeJa
 * 
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  28-May-2013  Nam Dinh    Create new
 */
public class GiayPhepLaiXeJa  implements MessageListener {

	/**
	 * This is  function receive
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param arg0
	 * @throws MessageListenerException
	 */  
	@Override
	public void receive(Message arg0) throws MessageListenerException {
		// TODO Auto-generated method stub
		try {
			GiayPhepLaiXeBs giayPhepLaiXeBs = new GiayPhepLaiXeBs();
			giayPhepLaiXeBs.getDanhSachHoSoMotCua();
		} catch (Exception es) {
			es.printStackTrace();
		}
	}
}
