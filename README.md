## Alfresco Audit Data as Events
Takes Alfresco Audit Data and sends it as Events

### Overview
- alfresco-events-audit - Java that contains the AuditEvent bean (needed by the listener for deserialization)
- alfresco-messaging-audit - Configures the Alfresco messaging system with a new audit topic
- audit-events-amp - Wraps the projects in an amp, for installing in Alfresco.

### Quick start
- `mvn install` and the repo amp is in audit-events-amp

#### The Sample Listener
The sample listener is a standard logging listener just with a dependency on the alfresco-events-audit jar 
(for deserialization of messages)
`cd sample-listener`
`mvn install`
`java -jar target/sample-listener-1.0.0-SNAPSHOT.jar --topic=alfresco.audit.events`

### License
Copyright (C) 2016 Alfresco Software Limited

This file is part of an unsupported extension to Alfresco.

Alfresco Software Limited licenses this file
to you under the Apache License, Version 2.0 (the
"License"); you may not use this file except in compliance
with the License.  You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing,
software distributed under the License is distributed on an
"AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
KIND, either express or implied.  See the License for the
specific language governing permissions and limitations
under the License.
