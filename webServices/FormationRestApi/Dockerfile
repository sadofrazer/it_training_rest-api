FROM maven:3.8.5-openjdk-18-slim as build
LABEL name="sadofrazer"
RUN mkdir /opt/FormationRestApi
WORKDIR /opt/FormationRestApi
#Dockerfile sera dans chaque webservices
COPY . /opt/FormationRestApi/
ENV DB_NAME = "it_training_bdd"
ENV DB_HOST = "it-training-bdd.cloudapps-cm.com"
ENV DB_USER = "frazer"
ENV DB_PASSWORD = "frazer@123"
ENV DB_PORT=3306
#RUN sed -ri -e 's!url="jdbc:mysql://it-training-bdd.cloudapps-cm.com:3306/it_training_bdd"!url="jdbc:mysql://${DB_HOST}:${DB_PORT}/${DB_NAME}"!g' /opt/FormationRestApi/src/main/webapp/META-INF/context.xml
#RUN sed -ri -e 's!username="frazer"!username=${DB_USER}!g' /opt/FormationRestApi/src/main/webapp/META-INF/context.xml
#RUN sed -ri -e 's!password="frazer@123"!password=${DB_PASSWORD}!g' /opt/FormationRestApi/src/main/webapp/META-INF/context.xml
RUN mvn clean 
RUN mvn install
RUN mvn package
RUN cp /opt/FormationRestApi/target/FormationRestApi.war /opt/FormationRestApi.war


FROM tomcat:8.5.79-jre17-temurin as tomcat
LABEL name="sadofrazer"
COPY --from=build /opt/FormationRestApi.war /usr/local/tomcat/webapps/
EXPOSE 8080
CMD ["catalina.sh", "run"]