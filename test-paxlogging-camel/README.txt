mvn clean install

Start karaf 4.1.1

feature:repo-add mvn:org.apache.camel.karaf/apache-camel/2.17.6/xml/features
feature:install camel-blueprint
feature:install camel-paxlogging

put the ./target/test-paxlogging-camel-1.0.0.jar into karaf/deploy/

generating some logs by deploy something or install some features

checking the out.log, there would be lots of duplicated Log messages/missing some messages.