# steps
    mvn assembly:assembly -DdescriptorId=jar-with-dependencies
    java -jar target/helloWorld-1.0-SNAPSHOT-jar-with-dependencies.jar
