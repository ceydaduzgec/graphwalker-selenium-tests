Setting up a Graphwalker project:



mvn clean install

mvn compile

mvn graphwalker:generate-sources

mvn compile exec:java -Dexec.mainClass="com.mbtroads.Runner"
