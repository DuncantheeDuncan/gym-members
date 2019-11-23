# chmod +x run.sh
mvn clean
mvn flyway:migrate
mvn package
mvn dependency:copy-dependencies
java -cp .:target/*: assignment.Run


