package com.prud.mapper.impl;

import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.prud.constant.IntegrationConstants;
import com.prud.model.il.NBSCRTIREC.NBSCRTICONTRACTHDRDETAILS.BILLCD;

import ma.glasnost.orika.CustomConverter;
import ma.glasnost.orika.metadata.Type;

public class BillingRenewalDateCustomConverter extends CustomConverter<String, BILLCD> {

	public BILLCD convert(String source, Type<? extends BILLCD> destinationType) {
		Date date = null;
		try {
			date = new SimpleDateFormat(IntegrationConstants.CLTDOBX_FORMAT).parse(source);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Calendar cal = Calendar.getInstance();
		cal.setTime(date);

		BILLCD bRenDate = new BILLCD();
		bRenDate.setCCYY(BigInteger.valueOf(cal.get(Calendar.YEAR)));
		bRenDate.setMM(BigInteger.valueOf(cal.get(Calendar.MONTH) + 1));
		bRenDate.setDD(BigInteger.valueOf(cal.get(Calendar.DAY_OF_MONTH)));
		return bRenDate;
	}

}
