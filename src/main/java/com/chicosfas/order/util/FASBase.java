/*<CHICOSCOPYRIGHT>
 *
 * Copyright (C) 2006-2018 Chico's.
 * All Rights Reserved.  No use, copying or distribution 
 * of this work may be made except in accordance with a
 * valid license agreement from Chico's.  This notice
 * must be included on all copies, modifications and
 * derivatives of this work.
 *
 * Chico's MAKES NO REPRESENTATIONS OR WARRANTIES
 * ABOUT THE SUITABILITY OF THE SOFTWARE, EITHER EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR
 * PURPOSE, OR NON-INFRINGEMENT. MY COMPANY SHALL NOT BE
 * LIABLE FOR ANY DAMAGES SUFFERED BY LICENSEE AS A RESULT
 * OF USING, MODIFYING OR DISTRIBUTING THIS SOFTWARE OR ITS
 * DERIVATIVES.
 *
 *</CHICOSCOPYRIGHT>*/
package com.chicosfas.order.util;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FASBase {
	
	protected static final Logger LOGGER = LogManager.getLogger(FASBase.class);
	
	/**
	 * @return
	 */
	
	public static Logger getLogger() {
		return LOGGER;
	}
	
	/**
	 * This method uses Jackson Library to convert Java Object Into JSON String.
	 * @param javaObject Input Java object
	 * @return response as String
	 */
	public String convertObjectToJSONString(Object javaObject) {
		String jsonString = null;
		try {
			jsonString = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(javaObject);
		} catch (JsonGenerationException jGE) {
			if(LOGGER.isErrorEnabled()) {
				LOGGER.error("JsonGenerationException in convertJSONObjectToString", jGE);
			}
		} catch (JsonMappingException jME) {
			if( LOGGER.isErrorEnabled()) {
				LOGGER.error("JsonMappingException in convertJSONObjectToString", jME);
			}
		} catch (IOException iOE) {
			if( LOGGER.isErrorEnabled()) {
				LOGGER.error("IOException in convertJSONObjectToString", iOE);
			}
		}
		return jsonString;
	}
	

}
