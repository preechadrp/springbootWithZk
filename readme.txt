-zk 10.0.0-jakarta
-springboot แบบ .jar
-build .jar โดยใช้ maven-jar-plugin + maven-dependency-plugin แทน spring-boot-maven-plugin
 แก้ปัญหา nested path ไปยัง zk.xml
-java 21 
-ตำแหน่ง /src/main/resources/META-INF/resources เท่ากับ webapp ใน .war
 มันเป็นกฎของ Servlet Container เวลามี JAR อยู่ใน classpath เช่น jar:file:/xxx.jar!/META-INF/resources/
 จำง่ายๆ
  WAR → webapp/
  JAR → META-INF/resources/