# steps
    # Fixed: Could not find goal 'assembly' in plugin org.apache.maven.plugins:maven-assembly-plugin
    mvn compile assembly:single
    # Fixed: Unable to make protected final java.lang.Class java.lang.ClassLoader.defineClass(java.lang.String,byte[],int,int,java.security.ProtectionDomain) throws java.lang.ClassFormatError accessible: module java.base does not "opens java.lang" to unnamed module
    java --add-opens=java.base/java.lang=ALL-UNNAMED -jar target/helloWorld-1.0-SNAPSHOT-jar-with-dependencies.jar
