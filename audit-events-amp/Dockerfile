# Alfresco Solr 6 Docker image with events
#
FROM docker-internal.alfresco.com/platform:latest
MAINTAINER Gethin James, gethin.james@alfresco.com

COPY target/*.amp $ALFRESCO_HOME/amps/
COPY alfresco-audit-search.xml $ALFRESCO_HOME/tomcat/shared/classes/alfresco/extension/audit/
RUN $ALFRESCO_HOME/java/bin/java -jar $ALFRESCO_HOME/bin/alfresco-mmt.jar install $ALFRESCO_HOME/amps $ALFRESCO_HOME/tomcat/webapps/alfresco.war -directory -verbose -nobackup
