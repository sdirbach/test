package beans;

import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;

public class FD_MulticastAggregator implements AggregationStrategy {

	@Override
	public Exchange aggregate(Exchange mainExchange, Exchange responseExchange) throws RuntimeException {
		System.out.println(">>>mainExchange=" + mainExchange);
		System.out.println(">>>mainExchange.getIn().getBody()=" + (mainExchange != null ? mainExchange.getIn().getBody() : ""));
		System.out.println(">>>responseExchange=" + responseExchange);
		System.out.println(">>>responseExchange.getIn().getBody()=" + (responseExchange != null ? responseExchange.getIn().getBody() : ""));
		if (mainExchange == null) {
			System.out.println("mainExchange is null !!!!");
			throw new RuntimeException("Deliberate Exception");
			//return responseExchange;
		} else {
			String s1 = mainExchange.getIn().getBody(String.class);
			String s2 = responseExchange.getIn().getBody(String.class);
			mainExchange.getIn().setBody(s1 + s2);
			return mainExchange;
		}
	}

}
