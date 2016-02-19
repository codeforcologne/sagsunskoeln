package de.illilli.opendata.service.sagsunskoeln;

import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SagsUnsConverterTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testConvertToDate() {
		SagsUnsConverter converter = new SagsUnsConverter(AskForSagsunsTest.getA1627());
		Date expected = new Date(1455654377000L);
		Date actual = converter.getSagsUnsBo().getRequestedDatetime();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testServiceCode() {
		SagsUnsConverter converter = new SagsUnsConverter(AskForSagsunsTest.getA1627());
		int expected = 17;
		int actual = converter.getSagsUnsBo().getServiceCode();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testlat() {
		SagsUnsConverter converter = new SagsUnsConverter(AskForSagsunsTest.getA1627());
		Double expected = 50.9384079215;
		Double actual = converter.getSagsUnsBo().getLat();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testlng() {
		SagsUnsConverter converter = new SagsUnsConverter(AskForSagsunsTest.getA1627());
		Double expected = 6.83454483747;
		Double actual = converter.getSagsUnsBo().getLng();
		Assert.assertEquals(expected, actual);
	}

}
