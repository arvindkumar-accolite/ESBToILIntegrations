package com.prud.mapper.impl;

import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.prud.constant.IntegrationConstants;
import com.prud.model.il.NBSCRTIREC.NBSCRTIBANKDETAILS.DATEFROM;

import ma.glasnost.orika.CustomConverter;
import ma.glasnost.orika.metadata.Type;

public class DateFromCustomConverter extends CustomConverter<String, DATEFROM> {

	public DATEFROM convert(String source, Type<? extends DATEFROM> destinationType) {
		Date date = null;
		try {
			date = new SimpleDateFormat(IntegrationConstants.CLTDOBX_FORMAT).parse(source);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);

		DATEFROM dateFrom = new DATEFROM();
		dateFrom.setCCYY(BigInteger.valueOf(cal.get(Calendar.YEAR)));
		dateFrom.setMM(BigInteger.valueOf(cal.get(Calendar.MONTH) + 1));
		dateFrom.setDD(BigInteger.valueOf(cal.get(Calendar.DAY_OF_MONTH)));
		return dateFrom;
	}

}
